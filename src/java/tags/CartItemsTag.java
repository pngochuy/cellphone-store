/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tags;

/**
 *
 * @author PC
 */
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import model.Cellphone;
import model.Order;

public class CartItemsTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        ArrayList<Cellphone> order = (ArrayList<Cellphone>) pageContext.getAttribute("cellphoneListCart", PageContext.SESSION_SCOPE);

        // Hiển thị danh sách sản phẩm trong giỏ hàng
        JspWriter out = getJspContext().getOut();

        for (Cellphone cellphone : order) {
            out.println("<tr>");
            out.println("    <td class=\"productInfoCell\">");
            out.println("        <div class=\"productImageBox\">");
            out.println("            <img src=\"images/" + cellphone.getImage() + "\" alt=\"image\">");
            out.println("        </div>");
            out.println("        <strong data-cellphone-id=\"" + cellphone.getId() + "\">" + cellphone.getTitle() + "</strong>");
            out.println("    </td>");
            out.println("    <td>");
            out.println("        <div class=\"quantityContainer\">");
            out.println("            <button class=\"decreaseBtn\" type=\"button\" onclick=\"decreaseValue(this)\">-</button>");
            out.println("            <strong name=\"quantity\" class=\"quantityLabel\" data-incrementable=\"true\">1</strong>");
            out.println("            <button class=\"increaseBtn\" type=\"button\" onclick=\"increaseValue(this)\">+</button>");
            out.println("            <input type=\"hidden\" name=\"updatedQuantity[]\" class=\"updatedQuantityInput\" value=\"\">");
            out.println("            <div id=\"inputContainer\">");
            out.println("               <input type=\"hidden\" name=\"updatedCellphoneId[]\" class=\"updatedCellphoneIdInput\" value=\"" + cellphone.getId() + "\">");
//            out.println("               <input type=\"hidden\" name=\"updatedCellphoneId[]\" class=\"updatedCellphoneIdInput\" value=\"\">");
            out.println("            </div>");
            out.println("        </div>");
            out.println("    </td>");
            out.println("    <td>");
            out.println("        <strong>$" + cellphone.getPrice() + "</strong>");
            out.println("    </td>");
            out.println("</tr>");
        }
    }

}
