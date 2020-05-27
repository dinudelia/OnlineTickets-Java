package managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    public Connection createConnection() {
        try {
            String url = "jdbc:mysql://localhost/pao2";
            String username = "root";
            String password = "1234";

            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection error.");
        }

        return null;
    }

    public static DBConnectionManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private final static class SingletonHolder {
        private static final DBConnectionManager INSTANCE =
                new DBConnectionManager();
    }
}
