/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.handleClick;

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
import model.Order;

/**
 *
 * @author PC
 */
public class handleClickAdmin extends HttpServlet {

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
            out.println("<title>Servlet handleClickAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet handleClickAdmin at " + request.getContextPath() + "</h1>");
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
        String inactiveLink = "";
        String activeLink = inactiveLink + "bg-white text-blue-900 rounded-l-lg";

        if (action.equals("homePage")) {
            // redirect to homePage.jsp to display dashboard.jsp

            response.sendRedirect("handleClickHome?action=homePage");
        } else if (action.equals("dashboard")) {
            // redirect to navigaion.jsp to display dashboard.jsp
            OrderDAO orderDAO = new OrderDAO();
            CellphoneDAO cellphoneDAO = new CellphoneDAO();
            HttpSession session = request.getSession();
            session.setAttribute("orderList", orderDAO.getAll());
            session.setAttribute("cellphoneList", cellphoneDAO.getAll());
            
            request.setAttribute("inactiveLink", inactiveLink);
            request.setAttribute("activeLink", activeLink);
            request.setAttribute("isDashboard", true);
            request.getRequestDispatcher("pages/adminPage/navigation.jsp").forward(request, response);
        } else if (action.equals("products")) {
            // redirect to products.jsp to display products.jsp
            CellphoneDAO cellphoneDAO = new CellphoneDAO();
            ArrayList<Cellphone> list = cellphoneDAO.getAll();
            
            request.setAttribute("listCellphone", list);
            request.setAttribute("inactiveLink", inactiveLink);
            request.setAttribute("activeLink", activeLink);
            request.setAttribute("isProducts", true);
            request.getRequestDispatcher("pages/adminPage/navigation.jsp").forward(request, response);
        } else if (action.equals("orders")) {
            // redirect to orders.jsp to display orders.jsp

            CellphoneDAO cellphoneDAO = new CellphoneDAO();
            OrderDAO orderDAO = new OrderDAO();
            PrintWriter out = response.getWriter();

            ArrayList<ArrayList<Integer>> cellphoneTitleList = new ArrayList<>();
            ArrayList<ArrayList<Integer>> cellphoneQuantityList = new ArrayList<>();

            for (Order o : orderDAO.getAll()) {
                cellphoneTitleList.add(o.getCellphoneId());
                cellphoneQuantityList.add(o.getQuantity());
            }

            ArrayList<ArrayList<String>> cellphoneTitleListString = new ArrayList<>();
            for (ArrayList<Integer> list : cellphoneTitleList) {
                ArrayList<String> titleList = new ArrayList<>();
                for (Integer i : list) {

                    titleList.add(cellphoneDAO.getCellphone(i).getTitle());

                }
                cellphoneTitleListString.add(titleList);
            }

            HttpSession session = request.getSession();
            session.setAttribute("orderList", orderDAO.getAll());
            session.setAttribute("titleList", cellphoneTitleListString);
            session.setAttribute("quantityList", cellphoneQuantityList);

            request.setAttribute("inactiveLink", inactiveLink);
            request.setAttribute("activeLink", activeLink);
            request.setAttribute("isOrders", true);
            request.getRequestDispatcher("pages/adminPage/navigation.jsp").forward(request, response);
        } else if (action.equals("setting")) {
            // redirect to navigaion.jsp to display setting.jsp
            CellphoneDAO cellphoneDAO = new CellphoneDAO();
            ArrayList<Cellphone> list = cellphoneDAO.getAll();
            request.setAttribute("listCellphone", list);
            request.setAttribute("inactiveLink", inactiveLink);
            request.setAttribute("activeLink", activeLink);
            request.setAttribute("isSetting", true);
            request.getRequestDispatcher("pages/adminPage/navigation.jsp").forward(request, response);
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
