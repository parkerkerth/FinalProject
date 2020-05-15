package sample;

import java.sql.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests class
 */
public class microTests {

    private static Connection connection;

    @BeforeAll
    public static void setConnection() {
        connection = DBConnection.connect();
    }

    @Test
    public void testConnection() {
        assertNotNull(connection);
    }

    /**
     * tests that calculateElite returns 0 when the elite column is empty
     */
    @Test
    public void testCalculateElite() {
        String sql = "SELECT elite FROM user WHERE user_id = 'xU02wVd4akbHrk8JiOdDYQ'";
        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            String elite = rs.getString("elite");
            int years = DisplayReviewsController.calculateElite(elite);
            assertEquals(0, years);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void closeStatementShouldCloseStatement() throws SQLException {
        Statement statement = connection.createStatement();
        DBConnection.closeStatement(statement);
        assertTrue(statement.isClosed());
    }

    @AfterAll
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
