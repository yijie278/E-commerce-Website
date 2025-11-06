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

@WebServlet(name = "addToCartServlet", value = "/addToCartServlet")
public class addToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Get or create cart
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // Get product ID and quantity
        String productId = request.getParameter("id");
        String quantityStr = request.getParameter("qty");
        int quantity = 1; // default quantity

        try {
            if (quantityStr != null && !quantityStr.isEmpty()) {
                quantity = Integer.parseInt(quantityStr);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // Get product and add to cart
        if (productId != null && !productId.isEmpty()) {
            ProductProfile product = ProductProfileManager.getProductById(productId);
            if (product != null) {
                cart.addItem(product, quantity);
                session.setAttribute("cart", cart);
            }
        }

        // Redirect to cart page
        response.sendRedirect("cart.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}