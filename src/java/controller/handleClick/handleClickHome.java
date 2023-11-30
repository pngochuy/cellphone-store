/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.handleClick;

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
public class handleClickHome extends HttpServlet {

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
            out.println("<title>Servlet handleClickHome</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet handleClickHome at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");

        if (action.equals("homePage")) {
            // ở đây chuyển sang "homePageServlet" để phân trang list cellphone

            request.setAttribute("isHomePage", true);
            request.getRequestDispatcher("homePageServlet").forward(request, response);
//            request.setAttribute("isHomePage", true);
//            request.getRequestDispatcher("pages/homePage/homePage.jsp").forward(request, response);
        } else if (action.equals("allProducts")) {
            // redirect to allProducts.jsp to display allProducts.jsp

            request.setAttribute("isAllProducts", true);
            request.getRequestDispatcher("pages/homePage/homePage.jsp").forward(request, response);
        } else if (action.equals("categories")) {
            // redirect to categories.jsp to display categories.jsp

            CellphoneDAO cellphoneDAO = new CellphoneDAO();
            HttpSession session = request.getSession();
            session.setAttribute("cellphoneList", cellphoneDAO.getAll());

            request.setAttribute("isCategories", true);
            request.getRequestDispatcher("pages/homePage/homePage.jsp").forward(request, response);
        } else if (action.equals("account")) {
            // redirect to account.jsp to display account.jsp

            request.setAttribute("isAccount", true);
            request.getRequestDispatcher("pages/homePage/homePage.jsp").forward(request, response);
        } else if (action.equals("cart")) {
            // redirect to cart.jsp to display cart.jsp

            request.setAttribute("isCart", true);
            request.getRequestDispatcher("pages/homePage/homePage.jsp").forward(request, response);
        } else if (action.equals("cartSuccess")) {
            // redirect to cartSuccess.jsp to display orders.jsp

            request.setAttribute("isCartSuccess", true);
            request.getRequestDispatcher("pages/homePage/homePage.jsp").forward(request, response);
        } else if (action.equals("readmore")) {

            request.setAttribute("isReadmore", true);
            request.getRequestDispatcher("pages/homePage/homePage.jsp").forward(request, response);

        }
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
        processRequest(request, response);
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
