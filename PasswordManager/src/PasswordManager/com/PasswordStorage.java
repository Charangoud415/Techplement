package PasswordManager.com;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PasswordStorage {
    public static void storePassword(String website, String username, String password, String key) {
        try (Connection conn = DatabaseManager.getConnection()) {
            String encryptedPassword = AESCipher.encrypt(key, password);
            String sql = "INSERT INTO credentials (website, username, password) VALUES (?, ?, ?)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, website);
                pstmt.setString(2, username);
                pstmt.setString(3, encryptedPassword);
                pstmt.executeUpdate();
                System.out.println("Password stored securely!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
