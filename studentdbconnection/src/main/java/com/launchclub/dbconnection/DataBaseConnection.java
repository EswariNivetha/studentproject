package com.launchclub.dbconnection;

import com.launchclub.exception.ConnectionFailedException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DataBase Connection.
 *
 * @author EswariNivethaVU
 */
public class DataBaseConnection {

    /**
     * Connects the Database.
     */
    public Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentdetails", "postgres",
                    "root");
        } catch (Exception e) {
          throw new ConnectionFailedException("Connection Error");
        }
        return connection;
    }
}