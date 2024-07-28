package com.jimmy.marketplace.ihm;
import java.io.IOException;

import com.jimmy.marketplace.business.CatalogBrowser;
import com.jimmy.marketplace.business.Customer;
import com.jimmy.marketplace.dao.CustomerDAO;
import com.jimmy.marketplace.dao.DAOContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns="/login", loadOnStartup = 1)
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        DAOContext.init( this.getServletContext() );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute( "email", "" );
        request.setAttribute( "password", "" );
        request.setAttribute( "errorMessage", "" );
        request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
    }

    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter( "txtLogin" );
        String password = request.getParameter( "txtPassword" );

        request.setAttribute( "login", login );
        request.setAttribute( "password", password );

        Customer connectedUser = CustomerDAO.isValidLogin( login, password );
        if ( connectedUser != null ) {
            HttpSession session = request.getSession( true );
            session.setAttribute( "connectedUser", connectedUser );
            session.setAttribute( "catalogBrowser", new CatalogBrowser() );

            request.getRequestDispatcher( "/viewProduct.jsp" ).forward( request, response );
        } else {
            request.setAttribute( "errorMessage", "Email ou mot de passe incorrect." );
            request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
        }
    }

    public void destroy() {
    }
}