package com.jimmy.marketplace.dao;

import jakarta.servlet.ServletContext;

public class DAOContext {
    protected static String dbUrl;
    protected static String dbLogin;
    protected static String dbPassword;

    public static void init(ServletContext context) {

        try {
            Class.forName( context.getInitParameter( "JDBC_DRIVER"));
            dbUrl = context.getInitParameter( "DB_URL");
            dbLogin = context.getInitParameter( "DB_LOGIN");
            dbPassword = context.getInitParameter( "DB_PASSWORD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
