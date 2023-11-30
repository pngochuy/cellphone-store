/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.store.homePage;

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
public class homePageServlet extends HttpServlet {

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
            out.println("<title>Servlet homePage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet homePage at " + request.getContextPath() + "</h1>");
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
        String index = request.getParameter("index");

        if (index == null) {
            index = "1";
        }

        int indexPage = Integer.parseInt(index);

        CellphoneDAO cellphoneDAO = new CellphoneDAO();

        int count = cellphoneDAO.getTotalCellphone();
        int endPage = count / 8; // lay 8 cellphone
        if (count % 8 != 0) {
            ++endPage;
        }

        ArrayList<Cellphone> list = cellphoneDAO.pagingCellphoneList(indexPage);

        request.setAttribute("endPage", endPage);
        request.setAttribute("listCellphone", list);
        request.setAttribute("tag", indexPage); // dùng để cho css sau này

        
        HttpSession session = request.getSession();
        if (session.getAttribute("cellphoneFeatured") == null) {
            Cellphone cellphone = cellphoneDAO.getCellphone(1);
            session.setAttribute("cellphoneFeatured", cellphone);
        } else {
            
        }
        

        request.setAttribute("isHomePage", true);
        request.getRequestDispatcher("pages/homePage/homePage.jsp").forward(request, response);
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
