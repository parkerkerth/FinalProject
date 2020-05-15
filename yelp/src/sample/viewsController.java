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

/**
 * Controller for the main display stage
 */
public class viewsController implements Initializable {

    private static String page;

    /**
     * Initalizes the page
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Setter for page
     *
     * @param page
     */
    public void setPage(String page) {
        this.page = page;
    }

    /**
     * gets the page
     *
     * @return
     */
    public static String getPage() {
        return page;
    }

    /**
     * Displays the Curated Businesses for each category
     * categories include: Food, Active Life, Hotels & Travel, and Shopping
     *
     * @param title
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

    /**
     * Displays the Food businesses with the highest ratings
     * when the Food Button is clicked
     * Event Handling
     *
     * @param actionEvent
     */
    public void goToFoodBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Food");
    }

    /**
     * Displays the  Active Life businesses with the highest ratings
     * when the  Active Life Button is clicked
     * Event Handling
     *
     * @param actionEvent
     */
    public void goToActiveLifeBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Active Life");
    }

    /**
     * Displays the Hotels & Travel businesses with the highest ratings
     * when the  Hotels & Travel Button is clicked
     * Event Handling
     *
     * @param actionEvent
     */
    public void goToHotelsAndTravelBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Hotels & Travel");
    }

    /**
     * Displays the Shopping businesses with the highest ratings
     * when the Shopping Button is clicked
     * Event Handling
     *
     * @param actionEvent
     */
    public void goToShoppingBusinesses(ActionEvent actionEvent) {
        displayCuratedBusinesses("Shopping");
    }

}
