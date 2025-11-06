package org.example.jakartaee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.project.Cart;
import org.example.project.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@WebServlet(name = "CheckoutServlet", value = "/checkout")
public class CheckoutServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(CheckoutServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null || cart.getItems().isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

        try {
            // Create new order
            String orderId = UUID.randomUUID().toString();
            Order order = new Order(orderId, cart.getItems(), cart.getTotal());

            // Get or create orders list in session
            List<Order> orders = (List<Order>) session.getAttribute("orders");
            if (orders == null) {
                orders = new ArrayList<>();
            }
            orders.add(order);

            // Update session
            session.setAttribute("orders", orders);
            session.setAttribute("currentOrder", order); // Store current order

            // Clear the cart
            session.removeAttribute("cart");

            // Redirect to order page
            response.sendRedirect("order.jsp");

        } catch (Exception e) {
            logger.severe("Error processing checkout: " + e.getMessage());
            response.sendRedirect("cart.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}