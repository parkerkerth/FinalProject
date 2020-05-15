package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    /**
     * Connects to the database
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+System.getProperty("user.dir")+"/yelpdb.db";
           // String url = "jdbc:sqlite:/Users/elizaneiman-golden/Desktop/compsci/yelpdb.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void closeStatement(Statement statement) {
        try{
            if(null != statement){
                statement.close();
                statement = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
