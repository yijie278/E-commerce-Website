package org.example.jakartaee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.project.Cart;
import org.example.project.ProductProfile;
import org.example.project.ProductProfileManager;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "UpdateCartServlet", value = "/updateCart")
public class UpdateCartServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UpdateCartServlet.class.getName());

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

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        try {
            String productId = request.getParameter("id");
            String quantityStr = request.getParameter("qty");

            if (productId != null && quantityStr != null) {
                int quantity = Integer.parseInt(quantityStr);

                if (quantity > 0) {
                    ProductProfile product = ProductProfileManager.getProductById(productId);
                    if (product != null) {
                        cart.updateQuantity(productId, quantity);
                        logger.info("Updated quantity for product " + productId + " to " + quantity);
                    } else {
                        logger.warning("Product not found with ID: " + productId);
                    }
                } else {
                    logger.warning("Invalid quantity: " + quantity);
                }
            }
        } catch (NumberFormatException e) {
            logger.severe("Error parsing quantity: " + e.getMessage());
        } catch (Exception e) {
            logger.severe("Error updating cart: " + e.getMessage());
        }

        response.sendRedirect("cart.jsp");
    }
}