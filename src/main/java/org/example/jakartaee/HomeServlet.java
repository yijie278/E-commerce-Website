package org.example.jakartaee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/home-servlet")
public class HomeServlet extends HttpServlet {

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
        // Handle POST and forward to home.jsp if necessary
        request.setAttribute("message", "POST Request Handled");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
