package mahi_mahi.services;

import java.sql.*;

public class DBHandler {
    private Connection connection;
    // namaDB, DBUsername, dan DBPassword diganti dengan yang dipakai di mySQL
    private static String DB_URL = "jdbc:mysql://localhost:3306/pabrik_dorayaki";
    private static String DB_Username = "root";
    private static String DB_Password = "password";

    public DBHandler() {
        try {
            System.out.println("Connecting to mySQL DB...");
            this.connection = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            System.out.println("DB connected :D");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection to DB failed :(");
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

}
