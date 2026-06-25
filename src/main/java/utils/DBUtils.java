package utils;

import java.sql.*;

public class DBUtils {
    private static Connection connection;

    public static void connect() {
        try {
            String url = "url";
            String username = "username";
            String password = "password";
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            throw new RuntimeException("DB connection failed", e);
        }

    }
 public static String getPassword(String username)
 {
     String query="";
     try(Statement stmt=connection.createStatement()){
         ResultSet rs=stmt.executeQuery(query);

         if (rs.next()) {
             return rs.getString("password");
         }

     } catch (Exception e) {
         throw new RuntimeException("DB Query Failed", e);
     }

     return null;
 }

    public static void close() {
        try {
            connection.close();
        } catch (Exception ignored) {}
    }
}


