package org.example.jakartaee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    // Handle GET request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Optional: Set attributes in the request to send data to the JSP
        request.setAttribute("message", "Welcome to Jom Makan! Discover Malaysia's Flavors.");

        // Forward the request to home.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handle POST request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve form data
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        // Validate credentials (example logic)
        if (email != null && password != null && email.equals("test@example.com") && password.equals("password123")) {
            // Redirect to home.jsp after successful login
            response.sendRedirect("home.jsp");
        } else {
            // Forward to the login page with an error message
            request.setAttribute("message", "Invalid credentials. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp"); // Assuming this is the login page
            try {
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Handle PUT request
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("message", "PUT Request Handled");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handle DELETE request
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("message", "DELETE Request Handled");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {}
}
