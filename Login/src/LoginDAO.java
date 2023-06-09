/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nguyenan
 */
import java.sql.*;

public class LoginDAO {

    private static Connection conn;

    public boolean validate(String username, String password) {
        try {
            conn = MySQLConnUtils.getMySQLConnection();

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            boolean isValid = result.next();

            conn.close();

            return isValid;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}

