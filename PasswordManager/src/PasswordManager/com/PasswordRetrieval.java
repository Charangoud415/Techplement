package PasswordManager.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PasswordRetrieval {
    public static void retrievePassword(String website, String key) {
        try (Connection conn = DatabaseManager.getConnection()) {
            String sql = "SELECT username, password FROM credentials WHERE website = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, website);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String username = rs.getString("username");
                        String encryptedPassword = rs.getString("password");
                        String decryptedPassword = AESCipher.decrypt(key, encryptedPassword);
                        System.out.println("Website: " + website);
                        System.out.println("Username: " + username);
                        System.out.println("Password: " + decryptedPassword);
                    } else {
                        System.out.println("No credentials found for " + website);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
