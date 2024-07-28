package com.jimmy.marketplace.dao;

import com.jimmy.marketplace.business.Customer;
import jakarta.annotation.Resource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO extends DAOContext {

    public static Customer isValidLogin(String email, String password) {
        try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPassword ) ) {
            String query = "SELECT * FROM customers WHERE email=? AND password=?";
            try ( PreparedStatement statement  = connection.prepareStatement( query ) ) {
                statement.setString( 1, email );
                statement.setString( 2, password );
                try ( ResultSet resultSet = statement.executeQuery() ) {
                    if ( resultSet.next() ) {
                        return new Customer(
                                resultSet.getLong( "customer_id" ),
                                resultSet.getString( "email" ),
                                resultSet.getString( "password" )
                        );
                    } else {
                        return null;
                    }
                }
            }
        } catch ( Exception exception ) {
            throw new RuntimeException( exception );
        }
    }
}
