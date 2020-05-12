package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class viewsController implements Initializable {

    @FXML
    private TableView<Business> table;
    @FXML
    private TableColumn<Business, String> nameColumn;
    @FXML
    private TableColumn<Business, Double> starColumn;

    ObservableList<Business> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //Button Text should be identical to the value of the parameter "title" JMA 5/12/20
    /*
        Displays the Curated Businesses for each category
        categories include: Food, Active Life, Hotels & Travel, and Shopping
     */
    public void displayCuratedBusinesses(String title, String fxmlPageName, ActionEvent actionEvent) {
        try {
            Stage newWindow = new Stage();
            newWindow.setTitle(title);
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root = fxmlLoader.load(getClass().getResource(fxmlPageName).openStream());
            newWindow.setScene(new Scene(root, 600, 600));
            newWindow.showAndWait();
            loadData(title);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToFoodBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Food", "displayForCuratedBusinesses.fxml", actionEvent);
    }

    public void goToActiveLifeBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Active Life", "displayForCuratedBusinesses.fxml", actionEvent);
    }

    public void goToHotelsAndTravelBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Hotels & Travel", "displayForCuratedBusinesses.fxml", actionEvent);
    }

    public void goToShoppingBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Shopping", "displayForCuratedBusinesses.fxml", actionEvent);
    }

    private void loadData(String pageName) {
        String sql = "SELECT business_id, name, stars FROM business WHERE categories LIKE " + "'%" + pageName + "%'" + "ORDER BY stars DESC LIMIT 20";
        try {
            Connection con = DBConnection.connect();
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("business_id");
                String name = rs.getString("name");
                Double stars = rs.getDouble("stars");
                oblist.add(new Business(id, name, stars));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        starColumn.setCellValueFactory(new PropertyValueFactory<>("stars"));
        table.setItems(oblist);
    }

    @FXML
    public void goToBusiness(MouseEvent event) {
        Business business = table.getSelectionModel().getSelectedItem();
    }
}
