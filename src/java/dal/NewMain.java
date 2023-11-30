/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dal;

import java.time.LocalDateTime;
import model.Category;
import model.Cellphone;
import model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        CellphoneDAO cellphoneDAO = new CellphoneDAO();
        
        int id = orderDAO.getCountOrder();
        System.out.println(id);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        orderDAO.add(new Order(1, "Thao Uyen", "thaouyen123@example.com", "Ha Tinh", 12345, "Address 2", 555, LocalDateTime.now(), 4, list));
//        for (Order o : orderDAO.getAll()) {
//            if (o.getId() == 1) {
//                System.out.println(orderDAO.getOrder(1).getDateCreated());
//            }
//            
//        }
        for (Cellphone o : cellphoneDAO.searchNameAjax("iPhone")) {
            System.out.println(o);

            
        }
        
        // Generate 10 random orders
        List<Order> orders = new ArrayList<>();
        // Create 10 Order objects with the current time
//        for (int i = 3; i < 4; i++) {
//            Order order = new Order(
//                    "Name " + i,
//                    "email" + i + "@example.com",
//                    "City " + i,
//                    10000 + i,
//                    "Address " + i,
//                    100 * (i + 1),
//                    LocalDateTime.now(),
//                    i + 1,
//                    i
//            );
//            orderDAO.add(order);
////            // Print the created order
////            System.out.println(order);
//        }
//        Order order1 = new Order(
//                1,
//                "John Doe",
//                "john.doe@example.com",
//                "New York",
//                12345,
//                "123 Main St",
//                500,
//                LocalDateTime.now(),
//                2,
//                1
//        );
//        orderDAO.add(order1);       

//        for (Order o : orderDAO.getAll()) {
//            if (o.getId() == 3) {
//                System.out.println(orderDAO.getOrder(o.getId()));
//                orderDAO.update(new Order(3, "Thao Uyen", "thaouyen123@example.com", "Ha Tinh", 12345, "Address 2", 555, LocalDateTime.now(), 4, 2));
//                System.out.println(orderDAO.getOrder(o.getId()));
//            }
//            
//        }
//        for (Order o : orderDAO.getAll()) {
//            System.out.println(o);
//        }
//        if (cellphoneDAO.sortPriceList("DESC") == null) {
//            System.out.println("No list!");
//
//        } else {
//
//            for (Cellphone c : cellphoneDAO.sortPriceList("DESC")) {
//                System.out.println(c);
//            }
//        }
//        System.out.println(cellphoneDAO.getTotalCellphone());
        
//        for (Cellphone c : cellphoneDAO.pagingCellphoneList(2)) {
//            System.out.println(c);
//        }

    }

}
