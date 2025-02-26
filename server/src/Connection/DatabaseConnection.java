package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private Connection connection;
    private static DatabaseConnection instance;

    public static DatabaseConnection getInstance() {
        if(instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {

    }

    public void connectToDatabase() throws Exception {
        try
        {
            String username = "root";
            String password = "dhanna";
            String url = "jdbc:mysql://localhost:3306/chatfusion";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful!");
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        } 
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
