package io.zipcoder.persistenceapp.Services;
import org.h2.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    /**
     * Connect to Database
     */

    public static String URL = "jdbc:h2:mem:testdb;Mode=Oracle";
    public static String userName = "sa";
    public static String passWord = "";

    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, userName, passWord);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }


}
