/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.store.categories;

import dal.CellphoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cellphone;

/**
 *
 * @author PC
 */
public class categoriesServlet extends HttpServlet {

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
            out.println("<title>Servlet categoriesServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet categoriesServlet at " + request.getContextPath() + "</h1>");
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
        CellphoneDAO cellphoneDAO = new CellphoneDAO();
        String selectedColor = request.getParameter("selectedColor");
        String selectedStorage = request.getParameter("selectedStorage");
        String selectedPrice = request.getParameter("selectedPrice");

//        PrintWriter out = response.getWriter();
//        out.println(selectedColor);
//        out.println(selectedStorage);
//        out.println(selectedPrice);
        if (selectedColor != null) {
            if (selectedColor.equals("all")) {
                ArrayList<Cellphone> list = cellphoneDAO.getAll();
                request.setAttribute("listChoice", list);
            } else if (selectedColor.equals("Black")) {
                ArrayList<Cellphone> listColor = cellphoneDAO.searchColorList("Black");
                request.setAttribute("listChoice", listColor);
            } else if (selectedColor.equals("Red")) {
                ArrayList<Cellphone> listColor = cellphoneDAO.searchColorList("Red");
                request.setAttribute("listChoice", listColor);
            } else if (selectedColor.equals("Blue")) {
                ArrayList<Cellphone> listColor = cellphoneDAO.searchColorList("Blue");
                request.setAttribute("listChoice", listColor);
            } else if (selectedColor.equals("Yellow")) {
                ArrayList<Cellphone> listColor = cellphoneDAO.searchColorList("Yellow");
                request.setAttribute("listChoice", listColor);
            }
        }
        //            --------------------------------------------------
        if (selectedStorage != null) {
            if (Integer.parseInt(selectedStorage) == 64) {
                ArrayList<Cellphone> listStorage = cellphoneDAO.searchStorage(64);
                request.setAttribute("listChoice", listStorage);
            } else if (Integer.parseInt(selectedStorage) == 128) {
                ArrayList<Cellphone> listStorage = cellphoneDAO.searchStorage(128);
                request.setAttribute("listChoice", listStorage);
            } else if (Integer.parseInt(selectedStorage) == 512) {
                ArrayList<Cellphone> listStorage = cellphoneDAO.searchStorage(512);
                request.setAttribute("listChoice", listStorage);
            } else if (Integer.parseInt(selectedStorage) == 1024) {
                ArrayList<Cellphone> listStorage = cellphoneDAO.searchStorage(1024);
                request.setAttribute("listChoice", listStorage);
            }
        }
        //            --------------------------------------------------
        if (selectedPrice != null) {
            if (selectedPrice.equals("asc")) {
                ArrayList<Cellphone> listPrice = cellphoneDAO.sortPriceList("ASC");
                request.setAttribute("listChoice", listPrice);
            } else if (selectedPrice.equals("desc")) {
                ArrayList<Cellphone> listPrice = cellphoneDAO.sortPriceList("DESC");
                request.setAttribute("listChoice", listPrice);
            }
        }

        request.getRequestDispatcher("/handleClickHome?action=categories").forward(request, response);
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
