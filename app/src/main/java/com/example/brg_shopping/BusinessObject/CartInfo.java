package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class CartInfo  implements Serializable
{
    private int cartID;
    public int getCartID()
    {
        return this.cartID;
    }
    public void setCartID(int value)
    {
        this.cartID = value;
    }

    private int customerID;
    public int getCustomerID()
    {
        return this.customerID;
    }
    public void setCustomerID(int value)
    {
        this.customerID = value;
    }

    private int productID;
    public int getProductID()
    {
        return this.productID;
    }
    public void setProductID(int value)
    {
        this.productID = value;
    }

    private String productName;
    public String getProductName()
    {
        return this.productName;
    }
    public void setProductName(String value)
    {
        this.productName = value;
    }
    private int price;
    public int getPrice()
    {
        return this.price;
    }
    public void setPrice(int value)
    {
        this.price = value;
    }
    private int amount;
    public int getAmount()
    {
        return this.amount;
    }
    public void setAmount(int value)
    {
        this.amount = value;
    }
}
