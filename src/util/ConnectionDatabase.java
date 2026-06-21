package util;

import java.sql.Connection;

public class ConnectionDatabase {
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "050903";
    private static final String URL = "jdbc:postgresql://localhost:5432/movie_management";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return (Connection) java.sql.DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
