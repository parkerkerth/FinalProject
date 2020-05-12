package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FoodController implements Initializable {

    @FXML
    private TableView<Business> table;
    @FXML
    private TableColumn<Business, String> nameColumn;
    @FXML
    private TableColumn<Business, Double> starColumn;

    ObservableList<Business> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    private void loadData(){
        String sql = "SELECT business_id, name, stars FROM business WHERE categories LIKE '%Food%' ORDER BY stars DESC LIMIT 20";
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

//    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//        @Override
//        public void handle(MouseEvent event) {
//            System.out.println("Hello World");
//        }
//    };

    @FXML
    public void goToBusiness(MouseEvent event) {
       Business business = table.getSelectionModel().getSelectedItem();
    }
}
