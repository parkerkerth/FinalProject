package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static sample.displayForCuratedBusinessController.getId;

public class DisplayReviewsController implements Initializable {

    @FXML
    private TextArea textArea;
    private final String STARS = " stars\n";
    private final String ELITE = " -- Elite reviewer for ";
    private final String YEARS = " years\n\n";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String id = getId();
        loadReviews(id);
    }

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
                int yearsElite = 0;
                if (elite != "") {
                    String[] years = elite.split(",");
                    yearsElite = years.length;
                }

                allReviews = allReviews + stars.toString() + STARS + text + "\n" + name + ELITE + yearsElite + YEARS;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        textArea.setWrapText(true);
        textArea.setText(allReviews);
        textArea.setEditable(false);
    }

}
