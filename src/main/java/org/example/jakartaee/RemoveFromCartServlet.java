package org.example.jakartaee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.project.Cart;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "RemoveFromCartServlet", value = "/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(RemoveFromCartServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null) {
            try {
                String productId = request.getParameter("id");

                if (productId != null && !productId.isEmpty()) {
                    cart.removeItem(productId);
                    logger.info("Removed product " + productId + " from cart");
                } else {
                    logger.warning("No product ID provided for removal");
                }
            } catch (Exception e) {
                logger.severe("Error removing item from cart: " + e.getMessage());
            }
        } else {
            logger.warning("Cart not found in session");
        }

        response.sendRedirect("cart.jsp");
    }
}