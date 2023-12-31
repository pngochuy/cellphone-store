/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.CellphoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.Cellphone;

/**
 *
 * @author PC
 */
public class editProductServlet extends HttpServlet {

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
            out.println("<title>Servlet editProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editProductServlet at " + request.getContextPath() + "</h1>");
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

        int cellphoneId = Integer.parseInt(request.getParameter("id"));
        CellphoneDAO cellphoneDAO = new CellphoneDAO();
        Cellphone c = cellphoneDAO.getCellphone(cellphoneId);

        request.setAttribute("cellphone", c);

        String inactiveLink = "";
        String activeLink = inactiveLink + "bg-white text-blue-900 rounded-l-lg";
        request.setAttribute("inactiveLink", inactiveLink);
        request.setAttribute("activeLink", activeLink);
        request.setAttribute("isEditProductPage", true);
        request.getRequestDispatcher("pages/adminPage/navigation.jsp").forward(request, response);
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
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String color = request.getParameter("color");
        int storage = Integer.parseInt(request.getParameter("storage"));
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));

        Category category = new Category(type, color, storage);

        Cellphone cellphone = new Cellphone(id, title, category, image, description, price);

        PrintWriter out = response.getWriter();
        out.println(cellphone);

        CellphoneDAO cellphoneDAO = new CellphoneDAO();
        cellphoneDAO.update(cellphone);

        HttpSession session = request.getSession();
        session.setAttribute("message", "Edit successfully!");

        response.sendRedirect("handleClickAdmin?action=products");
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
