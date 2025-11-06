package org.example.jakartaee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.project.ProductProfile;
import org.example.project.ProductProfileManager;

import java.io.IOException;

@WebServlet(name = "ViewServlet", value = "/view-servlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productId = request.getParameter("id");

        if (productId != null && !productId.isEmpty()) {
            // Directly use the string ID to get the product
            ProductProfile product = ProductProfileManager.getProductById(productId);

            if (product != null) {
                request.setAttribute("product", product);
                RequestDispatcher dispatcher = request.getRequestDispatcher("viewpage.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }

        // If product not found or invalid ID, redirect to shop
        response.sendRedirect("shop.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}