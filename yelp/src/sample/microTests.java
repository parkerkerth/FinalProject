package sample;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


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

    @AfterAll
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void closeStatementShouldCloseStatement() throws SQLException{
        Statement statement = connection.createStatement();
        DBConnection.closeStatement(statement);
        assertTrue(statement.isClosed());
    }
}
