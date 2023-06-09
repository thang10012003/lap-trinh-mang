import java.sql.*;

public class MySQLConnUtils {

    private static MySQLConnUtils instance = null;
    private Connection connection = null;

    private MySQLConnUtils() {
    }

    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "your_database_name";
        String userName = "root";
        String password = "";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
            throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3300/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        MySQLConnUtils.getIntance().setConnection(conn);

        return conn;
    }

    public static MySQLConnUtils getIntance() {
        if (instance == null) {
            instance = new MySQLConnUtils();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
