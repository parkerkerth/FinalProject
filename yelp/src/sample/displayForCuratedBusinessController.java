package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

/**
 * Controller for the curated businesses
 */
public class displayForCuratedBusinessController implements Initializable {

    @FXML
    private TableView<Business> table;
    @FXML
    private TableColumn<Business, String> nameColumn;
    @FXML
    private TableColumn<Business, Double> starColumn;
    @FXML
    private Button back;


    private static String id;

    ObservableList<Business> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the page
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String pageName = viewsController.getPage();
        loadData(pageName);
    }

    /**
     * gets the business ID
     *
     * @return
     */
    public static String getId() {
        return id;
    }

    /**
     * sets the id for the business
     *
     * @param id
     */
    public static void setId(String id) {
        displayForCuratedBusinessController.id = id;
    }

    /**
     * loads the Businesses for the selected catgeories
     * will load the business name and the rating measured in stars for the business
     *
     * @param pageName
     */
    private void loadData(String pageName) {
        String sql = "SELECT business_id, name, stars FROM business WHERE categories LIKE '%" + pageName + "%' ORDER BY stars DESC LIMIT 20";
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

    /**
     * Event handling for Back button
     * when pressed the window is closed
     *
     * @param event
     */
    @FXML
    public void goBack(ActionEvent event) {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }

    /**
     * Review page for the business
     *
     * @param business_id
     * @param name
     */
    public void displayReviewPage(String business_id, String name) {
        try {
            Stage newWindow = new Stage();
            newWindow.setTitle("Reviews for " + name);
            setId(business_id);
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root = fxmlLoader.load(getClass().getResource("displayReviews.fxml").openStream());
            newWindow.setScene(new Scene(root));
            newWindow.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Event handling when the business is clicked
     * displays the reviews for the business
     *
     * @param event
     */
    @FXML
    public void goToBusiness(MouseEvent event) {
        Business business = table.getSelectionModel().getSelectedItem();
        String id = business.getBusiness_id();
        String name = business.getName();
        displayReviewPage(id, name);
    }

}
