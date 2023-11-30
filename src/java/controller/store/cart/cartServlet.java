/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.store.cart;

import dal.CellphoneDAO;
import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cellphone;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Order;

/**
 *
 * @author PC
 */
public class cartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        
//        CellphoneDAO cellphoneDAO = new CellphoneDAO();
//        Cellphone cellphone = cellphoneDAO.getCellphone(id);
//        
//        ArrayList<Cellphone> listCurrent = new ArrayList<>();
//        listCurrent.add(cellphone);
//        HttpSession session = request.getSession();
//        session.setAttribute("cellphoneListCart ", listCurrent);
//
//        request.getRequestDispatcher("/handleClickHome?action=cart").forward(request, response);
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Forward tới cart.jsp để hiển thị danh sách
        request.getRequestDispatcher("/handleClickHome?action=cart").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String[] updatedQuantities = request.getParameterValues("updatedQuantity[]");
//        String totalPaid = request.getParameter("totalPaid");
//        PrintWriter out = response.getWriter();
//        if (updatedQuantities != null) {
//            for (String quantity : updatedQuantities) {
//                
//                out.println(quantity);
//            }
//        }
//        
//        out.println(totalPaid);

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        int postalCode = Integer.parseInt(request.getParameter("postalCode"));
        String address = request.getParameter("address");
        int totalPaid = Integer.parseInt(request.getParameter("totalPaid"));

        String dateCreatedString = request.getParameter("dateCreated");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime dateCreated = LocalDateTime.parse(dateCreatedString, formatter);

//        out.println("name: " + name);
//        out.println("email: " + email);
//        out.println("city: " + city);
//        out.println("postalCode: " + postalCode);
//        out.println("address: " + address);
//        out.println("totalPaid: " + totalPaid);
//        out.println("dateCreated: " + dateCreated);
//        String[] updatedQuantities = request.getParameterValues("updatedQuantity[]");
//        if (updatedQuantities != null) {
//            for (String quantity : updatedQuantities) {
//                out.println("quantity: " + Integer.parseInt(quantity));
//            }
//        }
//        String[] updatedCellphoneId = request.getParameterValues("updatedCellphoneId[]");
//        if (updatedCellphoneId != null) {
//            for (String cellphoneId : updatedCellphoneId) {
//                out.println("cellphoneId: " + Integer.parseInt(cellphoneId));
//            }
//        }
        OrderDAO orderDAO = new OrderDAO();

        String[] updatedQuantities = request.getParameterValues("updatedQuantity[]");
        String[] updatedCellphoneId = request.getParameterValues("updatedCellphoneId[]");
        // Chuyển đổi ArrayList thành chuỗi phân tách bằng dấu phẩy (,) trước khi lưu vào cột cellphone_ids
        ArrayList<Integer> quantityList = new ArrayList<>();
        ArrayList<Integer> cellphoneIdList = new ArrayList<>();
        for (String i : updatedQuantities) {
            quantityList.add(Integer.parseInt(i));
        }
        for (String i : updatedCellphoneId) {
            cellphoneIdList.add(Integer.parseInt(i));
        }
        
        Order order = new Order(name, email, city, postalCode, address, totalPaid, dateCreated, quantityList, cellphoneIdList);
        orderDAO.add(order);
//        String cellphoneIds = String.join(",", cellphoneIdList);

//        ArrayList<Order> listOrder = new ArrayList<>();
//        if (updatedQuantities != null && updatedCellphoneId != null && updatedQuantities.length == updatedCellphoneId.length) {
//
//            for (int i = 0; i < updatedQuantities.length; i++) {
//                int quantity = Integer.parseInt(updatedQuantities[i]);
//                int cellphoneId = Integer.parseInt(updatedCellphoneId[i]);
//
//                Order order = new Order(name, email, city, postalCode, address, totalPaid, dateCreated, quantity, cellphoneIdList);
//                listOrder.add(order);
//
//            }
//        } else {
//            out.println("Error~");
//        }

//        for (Order o : listOrder) {
////            int id = orderDAO.getCountOrder();
////            id = id++;
////            out.println(o);
//            orderDAO.add(o);
//        }
        response.sendRedirect("/Store/handleClickHome?action=cartSuccess");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
