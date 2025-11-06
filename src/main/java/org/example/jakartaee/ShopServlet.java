package org.example.jakartaee;
import jakarta.servlet.annotation.WebServlet;
import org.example.project.ProductProfile;
import org.example.project.ProductProfileManager;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Logger;

@WebServlet(name = "ShopServlet", value = "/shop-servlet")
public class ShopServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ShopServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<ProductProfile> products = ProductProfileManager.getAllProducts();
        System.out.println("Products retrieved: " + (products != null ? products.size() : 0)); // Debugging

        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop.jsp");
        dispatcher.forward(request, response);
    }

    //testing to display one
//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            // Retrieve productId from request, default to "1" if not provided
//            String productId = request.getParameter("productId");
//            if (productId == null) {
//                productId = "1";
//            }
//
//            // Fetch the specific product based on productId
//            ProductProfile selectedProduct = ProductProfileManager.getProductById(productId);
//
//            // Debugging: Print the selected product
//            System.out.println("Product retrieved: " + (selectedProduct != null ? selectedProduct.getName() : "None"));
//
//            // Set the product as a request attribute
//            request.setAttribute("product", selectedProduct);
//
//            // Forward to shop.jsp
//            RequestDispatcher dispatcher = request.getRequestDispatcher("shop.jsp");
//            dispatcher.forward(request, response);
//        }
}

