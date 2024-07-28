package com.jimmy.marketplace.dao;

import com.jimmy.marketplace.business.Product;

import java.sql.*;

public class ProductDAO extends DAOContext {
    public static int getProductCount() {
        try ( Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword) ) {
            String query = "SELECT COUNT(product_id) FROM products";
            try ( Statement statement = connection.createStatement() ) {
                try ( ResultSet resultSet = statement.executeQuery(query) ) {
                    resultSet.next();
                    return resultSet.getInt(1);
                }
            }
        } catch( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    public static Product getProductById(long productId ) {
        try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPassword ) ){
//            System.out.println( "connection to the database" );
            String query = "SELECT * FROM products WHERE product_id=?";
            try ( PreparedStatement statement  = connection.prepareStatement( query ) ) {
                statement.setLong( 1, productId );
                try ( ResultSet resultSet = statement.executeQuery() ) {
                    resultSet.next();
                    return new Product(
                            resultSet.getLong( "product_id" ),
                            resultSet.getString( "product_name" ),
                            resultSet.getString( "description" ),
                            resultSet.getDouble( "price" )
                    );
                }
            }

        } catch ( Exception exception ) {

            throw new RuntimeException( exception );

        }
    }
}
