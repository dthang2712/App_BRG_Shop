package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class CartInfo  implements Serializable
{
    private int CartID;
    public int getCartID()
    {
        return this.CartID;
    }
    public void setCartID(int value)
    {
        this.CartID = value;
    }

    private int CustomerID;
    public int getCustomerID()
    {
        return this.CustomerID;
    }
    public void setCustomerID(int value)
    {
        this.CustomerID = value;
    }

    private int ProductID;
    public int getProductID()
    {
        return this.ProductID;
    }
    public void setProductID(int value)
    {
        this.ProductID = value;
    }

    private int Amount;
    public int getAmount()
    {
        return this.Amount;
    }
    public void setAmount(int value)
    {
        this.Amount = value;
    }
}
