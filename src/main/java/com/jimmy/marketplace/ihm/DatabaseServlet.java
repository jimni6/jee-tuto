//package com.jimmy.marketplace.ihm;
//
//import jakarta.annotation.Resource;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@WebServlet("/connect")
//public class DatabaseServlet extends HttpServlet {
//
//    @Resource(name = "jdbc/PostgresDS")
//    private DataSource dataSource;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement stmt = connection.prepareStatement("INSERT INTO customers (first_name, last_name, email, phone, address, city, state, zip_code) VALUES ('Raymonde', 'Pepey', 'pepey@example.com', '555-1001', '789 Elm rgrgrgrg', 'grgrgrgrg', 'IL', '62701')");
//             ResultSet rs = stmt.executeQuery()) {
//
//            while (rs.next()) {
//                // Process results
//                resp.getWriter().println(rs.getString("column_name"));
//                System.out.println(stmt);
//                System.out.println("I'm in sr next!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new ServletException("Database access error", e);
//        }
//    }
//}
