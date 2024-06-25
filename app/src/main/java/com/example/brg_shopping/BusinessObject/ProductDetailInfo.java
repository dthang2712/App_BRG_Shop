package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class ProductDetailInfo implements Serializable {
    private int productID;
    public int getProductID()
    {
        return this.productID;
    }
    public void setProductID(int value)
    {
        this.productID = value;
    }
    private int productDetailID;
    public int getProductDetailID()
    {
        return this.productDetailID;
    }
    public void setProductDetailID(int value)
    {
        this.productDetailID = value;
    }

    private String key;
    public String getKey()
    {
        return this.key;
    }
    public void setKey(String value)
    {
        this.key = value;
    }

    private String description;
    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String value)
    {
        this.description = value;
    }



}
