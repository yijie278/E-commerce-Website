package org.example.jakartaee;

import jakarta.servlet.annotation.WebServlet;
import org.example.project.ProductProfile;
import org.example.project.ProductProfileManager;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.logging.Logger;

@WebServlet(name = "CategoryServlet", value = "/category-servlet")
public class CategoryServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(CategoryServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");

        if (category == null || category.isEmpty()) {
            response.sendRedirect("shop.jsp");
            return;
        }

        Collection<ProductProfile> allProducts = ProductProfileManager.getAllProducts();
        Collection<ProductProfile> categoryProducts = allProducts.stream()
                .filter(product -> category.equalsIgnoreCase(product.getCategory()))
                .collect(Collectors.toList());

        logger.info("Category: " + category + ", Products retrieved: " + categoryProducts.size());

        request.setAttribute("categoryProducts", categoryProducts);
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}