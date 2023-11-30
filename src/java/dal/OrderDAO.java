/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

/**
 *
 * @author PC
 */
public class OrderDAO extends DBContext {

    // CRUD
    // Create
    public void add(Order order) {
        try {

            String sqlQueryCategory = "INSERT INTO [Order] (name, email, city, postal_code, address, total_paid, date_created, quantity, cellphone_id)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sqlQueryCategory);

            ps.setString(1, order.getName());
            ps.setString(2, order.getEmail());
            ps.setString(3, order.getCity());
            ps.setInt(4, order.getPostalCode());
            ps.setString(5, order.getAddress());
            ps.setInt(6, order.getTotalPaid());
//            ps.setDate(8, order.getDateCreated());
            ps.setTimestamp(7, Timestamp.valueOf(order.getDateCreated())); // Convert LocalDateTime to Timestamp

            // Chuyển đổi ArrayList thành chuỗi phân tách bằng dấu phẩy (,) trước khi lưu vào cột cellphone_ids
            ArrayList<String> quantityList = new ArrayList<>();
            for (Integer i : order.getQuantity()) {
                quantityList.add(i.toString());
            }
            String quantites = String.join(",", quantityList);
            ps.setString(8, quantites);

            // Chuyển đổi ArrayList thành chuỗi phân tách bằng dấu phẩy (,) trước khi lưu vào cột cellphone_ids
            ArrayList<String> cellphoneIdList = new ArrayList<>();
            for (Integer i : order.getCellphoneId()) {
                cellphoneIdList.add(i.toString());
            }
            String cellphoneIds = String.join(",", cellphoneIdList);
            ps.setString(9, cellphoneIds);

            ps.execute();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // READ all Orders
    public ArrayList<Order> getAll() {

        try {
            // "SELECT * FROM [Order];";
            String sql = "SELECT [Order].order_id, [Order].name, [Order].email, [Order].city, \n"
                    + "	   [Order].postal_code, [Order].address, [Order].total_paid, \n"
                    + "	   [Order].date_created, [Order].quantity, [Order].cellphone_id\n"
                    + "FROM [Order]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Order> list = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();

                order.setId(rs.getInt("order_id"));
                order.setName(rs.getString("name").trim());
                order.setEmail(rs.getString("email").trim());
                order.setCity(rs.getString("city").trim());
                order.setPostalCode(rs.getInt("postal_code"));
                order.setAddress(rs.getString("address").trim());
                order.setTotalPaid(rs.getInt("total_paid"));
                // convert Timestamp to LocalDate
                order.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());

                // Phân tách chuỗi quantitesString thành ArrayList
                String quantitesString = rs.getString("quantity");
                ArrayList<Integer> quantites = new ArrayList<>();
                if (quantitesString != null && !quantitesString.isEmpty()) {
                    String[] ids = quantitesString.split(",");
                    for (String id : ids) {
                        quantites.add(Integer.parseInt(id));
                    }
                }
                order.setQuantity(quantites);

                // Phân tách chuỗi cellphoneIdsString thành ArrayList
                String cellphoneIdsString = rs.getString("cellphone_id");
                ArrayList<Integer> cellphoneIds = new ArrayList<>();
                if (cellphoneIdsString != null && !cellphoneIdsString.isEmpty()) {
                    String[] ids = cellphoneIdsString.split(",");
                    for (String id : ids) {
                        cellphoneIds.add(Integer.parseInt(id));
                    }
                }
                order.setCellphoneId(cellphoneIds);

                list.add(order);
            }
            rs.close();
            ps.close();

            return list;

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    // Delete
    public void delete(int orderId) {
        try {

            String sqlCellphone = "DELETE FROM [Order] WHERE order_id = ?;";
            PreparedStatement ps = connection.prepareStatement(sqlCellphone);
            ps.setInt(1, orderId);
            ps.execute();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Get Order
    public Order getOrder(int orderId) {
        try {
            String sql = "SELECT [Order].order_id, [Order].name, [Order].email, [Order].city, \n"
                    + "	   [Order].postal_code, [Order].address, [Order].total_paid, \n"
                    + "	   [Order].date_created, [Order].quantity, [Order].cellphone_id\n"
                    + "FROM [Order]\n"
                    + "WHERE [Order].order_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Order order = new Order();

            order.setId(rs.getInt("order_id"));
            order.setName(rs.getString("name").trim());
            order.setEmail(rs.getString("email").trim());
            order.setCity(rs.getString("city").trim());
            order.setPostalCode(rs.getInt("postal_code"));
            order.setAddress(rs.getString("address").trim());
            order.setTotalPaid(rs.getInt("total_paid"));
            // convert Timestamp to LocalDate
            order.setDateCreated(rs.getTimestamp("date_created").toLocalDateTime());

            // Phân tách chuỗi quantitesString thành ArrayList
            String quantitesString = rs.getString("quantity");
            ArrayList<Integer> quantites = new ArrayList<>();
            if (quantitesString != null && !quantitesString.isEmpty()) {
                String[] quans = quantitesString.split(",");
                for (String id : quans) {
                    quantites.add(Integer.parseInt(id));
                }
            }
            order.setQuantity(quantites);

            // Phân tách chuỗi cellphoneIdsString thành ArrayList
            String cellphoneIdsString = rs.getString("cellphone_id");
            ArrayList<Integer> cellphoneIds = new ArrayList<>();
            if (cellphoneIdsString != null && !cellphoneIdsString.isEmpty()) {
                String[] ids = cellphoneIdsString.split(",");
                for (String id : ids) {
                    cellphoneIds.add(Integer.parseInt(id));
                }
            }
            order.setCellphoneId(cellphoneIds);

            rs.close();
            ps.close();

            return order;

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    // Update
    public void update(Order order) {
        try {
            String sqlCellphone = "UPDATE [Order]\n"
                    + "SET name = ?,\n"
                    + "    email = ?,\n"
                    + "    city = ?,\n"
                    + "    postal_code = ?,\n"
                    + "    address = ?,\n"
                    + "    total_paid = ?,\n"
                    + "    date_created = ?,\n"
                    + "    quantity = ?,\n"
                    + "    cellphone_id = ?\n"
                    + "WHERE order_id = ?;";
            PreparedStatement ps = connection.prepareStatement(sqlCellphone);

            ps.setString(1, order.getName());
            ps.setString(2, order.getEmail());
            ps.setString(3, order.getCity());
            ps.setInt(4, order.getPostalCode());
            ps.setString(5, order.getAddress());
            ps.setInt(6, order.getTotalPaid());
//            ps.setDate(7, order.getDateCreated());
            ps.setTimestamp(7, Timestamp.valueOf(order.getDateCreated())); // Convert LocalDateTime to Timestamp
            
            
//            ps.setInt(8, order.getQuantity());
            // Chuyển đổi ArrayList thành chuỗi phân tách bằng dấu phẩy (,) trước khi lưu vào cột cellphone_ids
            ArrayList<String> quantityList = new ArrayList<>();
            for (Integer i : order.getCellphoneId()) {
                quantityList.add(i.toString());
            }
            String quantites = String.join(",", quantityList);
            ps.setString(8, quantites);

            // Chuyển đổi ArrayList thành chuỗi phân tách bằng dấu phẩy (,) trước khi lưu vào cột cellphone_ids
            ArrayList<String> cellphoneIdList = new ArrayList<>();
            for (Integer i : order.getCellphoneId()) {
                cellphoneIdList.add(i.toString());
            }
            String cellphoneIds = String.join(",", cellphoneIdList);
            ps.setString(9, cellphoneIds);

            ps.setInt(10, order.getId());

            ps.execute();

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // getCategoryId
    public int getCountOrder() {
        try {
            String sqlQueryCategoryID = "SELECT COUNT(*) as count FROM [Order];";
            PreparedStatement ps = connection.prepareStatement(sqlQueryCategoryID);

            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt("count");

            rs.close();
            ps.close();

            return count;

        } catch (SQLException ex) {
            Logger.getLogger(CellphoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
}
