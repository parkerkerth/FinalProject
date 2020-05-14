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

public class  viewsController implements Initializable {

    private static String page;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setPage(String page) {
        this.page = page;
    }

    public static String getPage() {
        return page;
    }

    //Button Text should be identical to the value of the parameter "title" JMA 5/12/20
    /*
        Displays the Curated Businesses for each category
        categories include: Food, Active Life, Hotels & Travel, and Shopping
     */
    public void displayCuratedBusinesses(String title) {
        try {
            Stage newWindow = new Stage();
            newWindow.setTitle(title);
            setPage(title);
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root = fxmlLoader.load(getClass().getResource("displayForCuratedBusinesses.fxml").openStream());
            newWindow.setScene(new Scene(root));
            newWindow.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToFoodBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Food");
    }

    public void goToActiveLifeBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Active Life");
    }

    public void goToHotelsAndTravelBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Hotels & Travel");
    }

    public void goToShoppingBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Shopping");
    }

}
