/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.store.cart;

import dal.CellphoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cellphone;

/**
 *
 * @author PC
 */
public class addToCartServlet extends HttpServlet {

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
            out.println("<title>Servlet addToCartServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addToCartServlet at " + request.getContextPath() + "</h1>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward tới cart.jsp để hiển thị danh sách
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
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();

        // Kiểm tra xem HttpSession đã tồn tại hay chưa
        if (session.getAttribute("cellphoneListCart") != null) {
            // Đã tồn tại danh sách cellphone, lấy danh sách từ session
            ArrayList<Cellphone> cellphoneList = (ArrayList<Cellphone>) session.getAttribute("cellphoneListCart");

            // Thêm cellphone mới vào danh sách
            CellphoneDAO cellphoneDAO = new CellphoneDAO();
            Cellphone cellphone = cellphoneDAO.getCellphone(id);
            cellphoneList.add(cellphone);
        } else {
            // Chưa có danh sách cellphone, tạo mới và thêm cellphone vào danh sách
            ArrayList<Cellphone> cellphoneList = new ArrayList<>();
            CellphoneDAO cellphoneDAO = new CellphoneDAO();
            Cellphone cellphone = cellphoneDAO.getCellphone(id);
            cellphoneList.add(cellphone);

            // Lưu danh sách vào HttpSession
            session.setAttribute("cellphoneListCart", cellphoneList);
        }

        // Chuyển hướng đến cart.jsp để hiển thị danh sách
        response.sendRedirect("addToCartServlet");  
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
