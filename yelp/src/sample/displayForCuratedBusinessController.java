package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static sample.viewsController.getPage;

public class displayForCuratedBusinessController implements Initializable {

    @FXML
    private TableView<Business> table;
    @FXML
    private TableColumn<Business, String> nameColumn;
    @FXML
    private TableColumn<Business, Double> starColumn;
    @FXML
    private Button back;

    ObservableList<Business> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String pageName = getPage();
        loadData(pageName);
    }

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

    @FXML
    public void goBack(ActionEvent event){
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void goToBusiness(MouseEvent event) {
        Business business = table.getSelectionModel().getSelectedItem();
    }

}
