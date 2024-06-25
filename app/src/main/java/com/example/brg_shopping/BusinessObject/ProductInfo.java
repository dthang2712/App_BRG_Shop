package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductInfo implements Serializable
{
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

    private byte[] productImage;
    public byte[] getProductImage()
    {
        return this.productImage;
    }
    public void setProductImage(byte[] value)
    {
        this.productImage = value;
    }

    private BigDecimal price;
    public BigDecimal getPrice()
    {
        return this.price;
    }
    public void setPrice(BigDecimal value)
    {
        this.price = value;
    }

    private int categoryID;
    public int getCategoryID()
    {
        return this.categoryID;
    }
    public void setCategoryID(int value)
    {
        this.categoryID = value;
    }

    private String unit;
    public String getUnit()
    {
        return this.unit;
    }
    public void setUnit(String value)
    {
        this.unit = value;
    }

    private String content;
    public String getContent()
    {
        return this.content;
    }
    public void setContent(String value)
    {
        this.content = value;
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
