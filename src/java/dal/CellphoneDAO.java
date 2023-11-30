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
public class CellphoneDAO extends DBContext {

    // CRUD
    // Create
    public void add(Cellphone cellphone) {
        try {

            String sqlQueryCategory = "INSERT INTO Category (type, color, storage)\n"
                    + "VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sqlQueryCategory);
            ps.setString(1, cellphone.getCategory().getType());
            ps.setString(2, cellphone.getCategory().getColor());
            ps.setInt(3, cellphone.getCategory().getStorage());
            ps.execute();

            String sqlQueryCategoryID = "SELECT TOP 1 category_id\n"
                    + "FROM Category\n"
                    + "ORDER BY category_id DESC;";
            ps = connection.prepareStatement(sqlQueryCategoryID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int category_id = rs.getInt("category_id");

            String sqlQueryCellphone = "INSERT INTO Cellphone (title, category_id, image, description, price)\n"
                    + "VALUES (?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sqlQueryCellphone);
            ps.setString(1, cellphone.getTitle().trim());
            ps.setInt(2, category_id);
            ps.setString(3, cellphone.getImage().trim());
            ps.setString(4, cellphone.getDescription().trim());
            ps.setInt(5, cellphone.getPrice());
            ps.execute();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // READ all Person
    public ArrayList<Cellphone> getAll() {

        try {
            String sql = "SELECT Cellphone.cellphone_id, Cellphone.title, Cellphone.image, Cellphone.description, Cellphone.price, \n"
                    + "	         Category.category_id as category_id, Category.type as type, Category.color as color, Category.storage as storage\n"
                    + "FROM Cellphone\n"
                    + "LEFT JOIN Category \n"
                    + "ON Cellphone.category_id = Category.category_id;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Cellphone> list = new ArrayList<>();
            while (rs.next()) {
                Cellphone cellphone = new Cellphone();
                cellphone.setId(rs.getInt("cellphone_id"));
                cellphone.setTitle(rs.getString("title").trim());
                cellphone.setImage(rs.getString("image").trim());
                cellphone.setDescription(rs.getString("description").trim());
                cellphone.setPrice(rs.getInt("price"));
                Category category = new Category(rs.getString("type").trim(), rs.getString("color").trim(), rs.getInt("storage"));
                cellphone.setCategory(category);

                list.add(cellphone);
            }
            rs.close();
            ps.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    // Delete
    public void delete(int cellphoneId) {
        try {
            int categoryId = getCategoryId(cellphoneId);

            String sqlCellphone = "DELETE FROM Cellphone WHERE cellphone_id = ?;";
            PreparedStatement ps = connection.prepareStatement(sqlCellphone);
            ps.setInt(1, cellphoneId);
            ps.execute();

            String sqlCategory = "DELETE FROM Category WHERE category_id = ?;";
            ps = connection.prepareStatement(sqlCategory);
            ps.setInt(1, categoryId);
            ps.execute();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Get Cellphone
    public Cellphone getCellphone(int id) {
        try {
            String sql = "SELECT Cellphone.cellphone_id, Cellphone.title, Cellphone.image, Cellphone.description, Cellphone.price,\n"
                    + "       Category.category_id as category_id, Category.type as type, Category.color as color, Category.storage as storage\n"
                    + "FROM Cellphone\n"
                    + "lEFT JOIN Category\n"
                    + "ON Cellphone.cellphone_id = Category.category_id\n"
                    + " WHERE Cellphone.cellphone_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Cellphone cellphone = new Cellphone();

            cellphone.setId(rs.getInt("cellphone_id"));
            cellphone.setTitle(rs.getString("title").trim());
            cellphone.setImage(rs.getString("image").trim());
            cellphone.setDescription(rs.getString("description").trim());
            cellphone.setPrice(rs.getInt("price"));
            Category category = new Category(rs.getString("type").trim(), rs.getString("color").trim(), rs.getInt("storage"));
            cellphone.setCategory(category);

            rs.close();
            ps.close();

            return cellphone;

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    // Update
    public void update(Cellphone cellphone) {
        try {
            String sqlCellphone = "UPDATE Cellphone\n"
                    + "SET title = ?,\n"
                    + "    category_id = ?,\n"
                    + "    image = ?,\n"
                    + "    description = ?,\n"
                    + "    price = ?\n"
                    + "WHERE cellphone_id = ?;";
            PreparedStatement ps = connection.prepareStatement(sqlCellphone);
            ps.setString(1, cellphone.getTitle());
            int categoryId = getCategoryId(cellphone.getId());
            ps.setInt(2, categoryId);
            ps.setString(3, cellphone.getImage().trim());
            ps.setString(4, cellphone.getDescription().trim());
            ps.setInt(5, cellphone.getPrice());
            ps.setInt(6, cellphone.getId());
            ps.execute();

            String sqlCategory = "UPDATE Category\n"
                    + "SET type = ?,\n"
                    + "    color = ?,\n"
                    + "    storage = ?,\n"
                    + "WHERE category_id = ?;";
            ps = connection.prepareStatement(sqlCategory);
            ps.setString(1, cellphone.getCategory().getType().trim());
            ps.setString(2, cellphone.getCategory().getColor().trim());
            ps.setInt(3, cellphone.getCategory().getStorage());
            ps.setInt(4, categoryId);

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // getCategoryId
    public int getCategoryId(int cellphoneId) {
        try {
            String sqlQueryCategoryID = "SELECT *\n"
                    + "FROM Cellphone\n"
                    + "WHERE Cellphone.cellphone_id = ?;";
            PreparedStatement ps = connection.prepareStatement(sqlQueryCategoryID);
            ps.setInt(1, cellphoneId);

            ResultSet rs = ps.executeQuery();
            rs.next();
            int category_id = rs.getInt("category_id");

            rs.close();
            ps.close();

            return category_id;

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public ArrayList<Cellphone> searchColorList(String color) {

        try {
            String sql = "SELECT Cellphone.cellphone_id, Cellphone.title, Cellphone.image, Cellphone.price,\n"
                    + "	   Cellphone.cellphone_id, Cellphone.title, Cellphone.category_id, Cellphone.image, Cellphone.description, Cellphone.price, \n"
                    + "       Category.category_id, Category.type, Category.color, Category.storage\n"
                    + "FROM Cellphone\n"
                    + "lEFT JOIN Category\n"
                    + "ON Cellphone.cellphone_id = Category.category_id\n"
                    + "WHERE Category.color = ?;";

            ArrayList<Cellphone> list = new ArrayList<>();

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, color);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cellphone cellphone = new Cellphone();

                cellphone.setId(rs.getInt("cellphone_id"));
                cellphone.setTitle(rs.getString("title").trim());
                cellphone.setImage(rs.getString("image").trim());
                cellphone.setDescription(rs.getString("description").trim());
                cellphone.setPrice(rs.getInt("price"));
                Category category = new Category(rs.getString("type").trim(), rs.getString("color").trim(), rs.getInt("storage"));
                cellphone.setCategory(category);

                list.add(cellphone);
            }

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Cellphone> searchStorage(int storage) {

        try {
            String sql = "SELECT Cellphone.cellphone_id, Cellphone.title, Cellphone.category_id, Cellphone.image, Cellphone.description, Cellphone.price, \n"
                    + "       Category.category_id, Category.type, Category.color, Category.storage\n"
                    + "FROM Cellphone\n"
                    + "lEFT JOIN Category\n"
                    + "ON Cellphone.cellphone_id = Category.category_id\n"
                    + "WHERE Category.storage = ?;";
            ArrayList<Cellphone> list;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, storage);

            ResultSet rs = ps.executeQuery();

            list = new ArrayList<>();
            while (rs.next()) {
                Cellphone cellphone = new Cellphone();

                cellphone.setId(rs.getInt("cellphone_id"));
                cellphone.setTitle(rs.getString("title").trim());
                cellphone.setImage(rs.getString("image").trim());
                cellphone.setDescription(rs.getString("description").trim());
                cellphone.setPrice(rs.getInt("price"));
                Category category = new Category(rs.getString("type").trim(), rs.getString("color").trim(), rs.getInt("storage"));
                cellphone.setCategory(category);

                list.add(cellphone);
            }

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Cellphone> sortPriceList(String action) {
        // action: ASC, DESC

        try {

            String sql = "SELECT Cellphone.cellphone_id, Cellphone.title, Cellphone.category_id, Cellphone.image, Cellphone.description, Cellphone.price, \n"
                    + "       Category.category_id, Category.type, Category.color, Category.storage\n"
                    + "FROM Cellphone\n"
                    + "lEFT JOIN Category\n"
                    + "ON Cellphone.cellphone_id = Category.category_id\n"
                    + "ORDER BY Cellphone.price " + action + ";";
            ArrayList<Cellphone> list;

            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, action);

            ResultSet rs = ps.executeQuery();

            list = new ArrayList<>();
            while (rs.next()) {
                Cellphone cellphone = new Cellphone();

                cellphone.setId(rs.getInt("cellphone_id"));
                cellphone.setTitle(rs.getString("title").trim());
                cellphone.setImage(rs.getString("image").trim());
                cellphone.setDescription(rs.getString("description").trim());
                cellphone.setPrice(rs.getInt("price"));
                Category category = new Category(rs.getString("type").trim(), rs.getString("color").trim(), rs.getInt("storage"));
                cellphone.setCategory(category);

                list.add(cellphone);
            }

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
// ------------------------------------------

    public ArrayList<Cellphone> getAllAccount() {

        try {
            ArrayList<Cellphone> list = new ArrayList<>();
            String sql = "SELECT COUNT(*) FROM Cellphone";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cellphone cellphone = new Cellphone();

                cellphone.setId(rs.getInt("cellphone_id"));
                cellphone.setTitle(rs.getString("title").trim());
                cellphone.setImage(rs.getString("image").trim());
                cellphone.setDescription(rs.getString("description").trim());
                cellphone.setPrice(rs.getInt("price"));
                Category category = new Category(rs.getString("type").trim(), rs.getString("color").trim(), rs.getInt("storage"));
                cellphone.setCategory(category);

                list.add(cellphone);
            }

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTotalCellphone() {
        try {
            String sql = "SELECT COUNT(*) FROM Cellphone";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public ArrayList<Cellphone> pagingCellphoneList(int index) {
        try {
            ArrayList<Cellphone> list = new ArrayList<>();
            String sql = "SELECT Cellphone.cellphone_id, Cellphone.title, Cellphone.category_id, Cellphone.image, Cellphone.description, Cellphone.price, \n"
                    + "       Category.category_id, Category.type, Category.color, Category.storage\n"
                    + "FROM Cellphone\n"
                    + "LEFT JOIN Category ON Cellphone.category_id = Category.category_id\n"
                    + "ORDER BY Cellphone.cellphone_id\n"
                    + "OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY;";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, (index - 1) * 8); // index in Page JSP (must be > 0) 
            // => OFFSET in DB = (index-1)*8
            // vd:index 1 => 8 cellphone

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cellphone cellphone = new Cellphone();

                cellphone.setId(rs.getInt("cellphone_id"));
                cellphone.setTitle(rs.getString("title").trim());
                cellphone.setImage(rs.getString("image").trim());
                cellphone.setDescription(rs.getString("description").trim());
                cellphone.setPrice(rs.getInt("price"));
                Category category = new Category(rs.getString("type").trim(), rs.getString("color").trim(), rs.getInt("storage"));
                cellphone.setCategory(category);

                list.add(cellphone);

            }

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Cellphone> searchNameAjax(String title) {

        try {
            String sql = "SELECT Cellphone.cellphone_id, Cellphone.title, Cellphone.image, Cellphone.description, Cellphone.price,\n"
                    + "       Category.category_id as category_id, Category.type as type, Category.color as color, Category.storage as storage\n"
                    + "FROM Cellphone\n"
                    + "LEFT JOIN Category\n"
                    + "ON Cellphone.category_id = Category.category_id\n"
                    + "WHERE Cellphone.title LIKE ?;";
            ArrayList<Cellphone> list;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");

            ResultSet rs = ps.executeQuery();

            list = new ArrayList<>();
            while (rs.next()) {
                Cellphone cellphone = new Cellphone();

                cellphone.setId(rs.getInt("cellphone_id"));
                cellphone.setTitle(rs.getString("title").trim());
                cellphone.setImage(rs.getString("image").trim());
                cellphone.setDescription(rs.getString("description").trim());
                cellphone.setPrice(rs.getInt("price"));
                Category category = new Category(rs.getString("type").trim(), rs.getString("color").trim(), rs.getInt("storage"));
                cellphone.setCategory(category);

                list.add(cellphone);
            }

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
