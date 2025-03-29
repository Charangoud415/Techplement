package PasswordManager.com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/PasswordManager";
    private static final String USER = "root"; // Change to your MySQL username
    private static final String PASSWORD = "Charan@12345"; // Change to your MySQL password

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	
}
