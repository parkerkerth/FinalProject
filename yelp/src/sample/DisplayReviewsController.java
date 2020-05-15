package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Controller for the Reviews Displays
 */
public class DisplayReviewsController implements Initializable {

    @FXML
    private TextArea textArea;
    private final String STARS = " stars\n";
    private final String ELITE = " -- Elite reviewer for ";
    private final String YEARS = " years\n\n";
    private final String YEAR = " year\n\n";
    private final String NOT = " -- Not an elite reviewer\n\n";

    @FXML
    private Button back;

    /**
     * Initilazes the stage
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String id = displayForCuratedBusinessController.getId();
        loadReviews(id);
    }


    /**
     * Loads the top reviews for each business upon clicking on the business
     *
     * @param id
     */
    private void loadReviews(String id) {
        String sql = "SELECT text, name, stars, elite FROM review JOIN user " +
                "ON review.user_id = user.user_id WHERE business_id = '" + id +
                "' ORDER BY LENGTH(elite) DESC LIMIT 10";
        String allReviews = "";
        try {
            Connection con = DBConnection.connect();
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                String text = rs.getString("text");
                Double stars = rs.getDouble("stars");
                String name = rs.getString("name");
                String elite = rs.getString("elite");
                int yearsElite = calculateElite(elite);
                if (yearsElite == 0) {
                    allReviews = allReviews + stars.toString() + STARS + text + "\n" + name + NOT;
                } else if (yearsElite == 1) {
                    allReviews = allReviews + stars.toString() + STARS + text + "\n" + name + ELITE + yearsElite + YEAR;
                } else {
                    allReviews = allReviews + stars.toString() + STARS + text + "\n" + name + ELITE + yearsElite + YEARS;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        textArea.setWrapText(true);
        textArea.setText(allReviews);
        textArea.setEditable(false);
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
     * Calculates the amount of years that a reviewer was
     * Elite
     *
     * @param eliteColumn
     * @return
     */
    public static int calculateElite(String eliteColumn) {
        if (eliteColumn.length() > 3) {
            String[] years = eliteColumn.split(",");
            return years.length;
        }
        return 0;
    }

}
