package com.jimmy.marketplace.business;

import com.jimmy.marketplace.dao.ProductDAO;

import java.util.ArrayList;
import java.util.List;

public class CatalogBrowser {

    private int currentPosition = 1;
    private Product currentArticle;
    private int articleCount = ProductDAO.getProductCount();

//    private List<ShoppingCartLine> shoppingCart = new ArrayList<>();


    public CatalogBrowser() {
        currentArticle = ProductDAO.getProductById( currentPosition );
    }

    public Product getCurrentArticle() {
        return currentArticle;
    }

//    public List<ShoppingCartLine> getShoppingCart() {
//        return shoppingCart;
//    }

//    public int getShoppingCartSize() {
//        int fullQuantity = 0;
//        for (ShoppingCartLine shoppingCartLine : shoppingCart) {
//            fullQuantity += shoppingCartLine.getQuantity();
//        }
//        return fullQuantity;
//    }

    public void goPrevious() {
        if ( --currentPosition < 1 ) {
            currentPosition = articleCount;
        }
        currentArticle = ProductDAO.getProductById( currentPosition );
    }

    public void goNext() {
        if ( ++currentPosition > articleCount ) {
            currentPosition = 1;
        }
        currentArticle = ProductDAO.getProductById( currentPosition );
    }

//    public void addCurrentArticle() {
//        for (ShoppingCartLine shoppingCartLine : shoppingCart) {
//            if ( shoppingCartLine.getArticle().getIdArticle() == currentArticle.getIdArticle() ) {
//                shoppingCartLine.increaseQuantity();
//                return;
//            }
//        }
//        shoppingCart.add( new ShoppingCartLine( currentArticle, 1 ) );
//    }

}
