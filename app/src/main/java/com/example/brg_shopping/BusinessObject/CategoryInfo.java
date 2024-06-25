package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class CategoryInfo implements Serializable
{
    private int categoryID;
    public int getCategoryID()
    {
        return this.categoryID;
    }
    public void setCategoryID(int value)
    {
        this.categoryID = value;
    }

    private String categoryName;
    public String getCategoryName()
    {
        return this.categoryName;
    }
    public void setCategoryName(String value)
    {
        this.categoryName = value;
    }
}
