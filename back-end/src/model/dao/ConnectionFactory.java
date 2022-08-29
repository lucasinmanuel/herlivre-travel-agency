package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2077Mm-84";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/herlivre";

    public static Connection createConnectionToMySQL() throws SQLException {

        return DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

    }
}
