/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import model.Category;
import model.Cellphone;

/**
 *
 * @author PC
 */
public class AdminDAO extends DBContext {

    // Get Admin
    public Admin getAdmin(String username, String password) {
        
        try {
            String sql = "SELECT * FROM Admin WHERE username = ? AND password = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            Admin admin = new Admin();

            while (rs.next()) {
                admin.setId(rs.getInt("adminID"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setName(rs.getString("name"));
                
                // return lap tuc!
                return admin;
            }

            rs.close();
            ps.close();      
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
