/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.CellphoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Category;
import model.Cellphone;

@MultipartConfig
/**
 *
 * @author PC
 */
public class addProductServlet extends HttpServlet {

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
            out.println("<title>Servlet addProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addProductServlet at " + request.getContextPath() + "</h1>");
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

        String inactiveLink = "";
        String activeLink = inactiveLink + "bg-white text-blue-900 rounded-l-lg";
        request.setAttribute("inactiveLink", inactiveLink);
        request.setAttribute("activeLink", activeLink);
        request.setAttribute("isAddProductPage", true);
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
        String action = request.getParameter("action");

        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String color = request.getParameter("color");
        int storage = Integer.parseInt(request.getParameter("storage"));
        String fileName = request.getParameter("fileName");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));

        CellphoneDAO cellphoneDAO = new CellphoneDAO();
        if (action.equals("yes")) {

            Category category = new Category(type, color, storage);

            Cellphone cellphone = new Cellphone(title, category, fileName, description, price);

//            PrintWriter out = response.getWriter();
//            out.println(cellphone);
            cellphoneDAO.add(cellphone);
            ArrayList<Cellphone> list = cellphoneDAO.getAll();

            HttpSession session = request.getSession();
            session.setAttribute("message", "Add successfully!");

            request.setAttribute("listCellphone", list);

            response.sendRedirect("handleClickAdmin?action=products");
        } else if (action.equals("no")) {
            // giu lai gia tri vua nhap, mat cong nhap lai :))
            request.setAttribute("title", title);
            request.setAttribute("type", type);
            request.setAttribute("color", color);
            request.setAttribute("storage", storage);
            request.setAttribute("fileName", fileName);
            request.setAttribute("description", description);
            request.setAttribute("price", price);
            
            // quay lai trang addProduct.jsp de tiep tuc
            String inactiveLink = "";
            String activeLink = inactiveLink + "bg-white text-blue-900 rounded-l-lg";
            request.setAttribute("inactiveLink", inactiveLink);
            request.setAttribute("activeLink", activeLink);
            request.setAttribute("isAddProductPage", true);
            request.getRequestDispatcher("pages/adminPage/navigation.jsp").forward(request, response);
        }

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
