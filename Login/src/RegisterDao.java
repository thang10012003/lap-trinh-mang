/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author nguyenan
 */
import java.sql.*;

public class RegisterDao {
    
    public static boolean register(String username, String password, String confirmPassword) {
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            
            if (!password.equals(confirmPassword)) {
                return false;
            }
            
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            int result = statement.executeUpdate();
            
            conn.close();
            
            return result > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
}
