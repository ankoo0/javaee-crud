package com.project.javaeecrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseConnection {

    private static final Logger logger = Logger.getLogger("My Logger");

    private static final String POSTGRES_CONNECTION_URL = "jdbc:postgresql://localhost:5432/javaee-crud";
    private static final String POSTGRES_USERNAME = "postgres";
    private static final String POSTGRES_PASSWORD = "admin";

    //    private static final String H2_CONNECTION_URL = "jdbc:h2:file:C:/data/sample;INIT=RUNSCRIPT FROM 'classpath:users-ddl.sql';DB_CLOSE_DELAY=-1;";
    //    private static final String H2_USERNAME = "sa";
    //    private static final String H2_PASSWORD = "";
    private DataBaseConnection() {

    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(POSTGRES_CONNECTION_URL, POSTGRES_USERNAME, POSTGRES_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, e.toString(), e);
        }

        return con;
    }
}
