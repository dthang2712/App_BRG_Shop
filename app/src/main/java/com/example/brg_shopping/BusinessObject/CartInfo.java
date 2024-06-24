package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class CartInfo  implements Serializable
{
    private int AutoID;
    public int getAutoID()
    {
        return this.AutoID;
    }
    public void setAutoID(int value)
    {
        this.AutoID = value;
    }

    private String CustomerID;
    public String getCustomerID()
    {
        return this.CustomerID;
    }
    public void setCustomerID(String value)
    {
        this.CustomerID = value;
    }

    private String ProductID;
    public String getProductID()
    {
        return this.ProductID;
    }
    public void setProductID(String value)
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
