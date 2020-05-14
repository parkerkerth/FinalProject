package sample;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class microTests {
    Connection connection;

    @BeforeEach
    public void before() {
        connection = DBConnection.connect();
    }

    @AfterEach
    public void after() {
        DBConnection.connect();
    }

    @Test
    public void closeStatementShouldCloseStatement() throws SQLException{
        Statement statement = connection.createStatement();
        DBConnection.closeStatement(statement);
        assertTrue(statement.isClosed());
    }
}
