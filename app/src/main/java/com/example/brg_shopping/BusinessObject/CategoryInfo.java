package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class CategoryInfo implements Serializable
{
    private int autoID;
    public int getAutoID()
    {
        return this.autoID;
    }
    public void setAutoID(int value)
    {
        this.autoID = value;
    }

    private String categoryID;
    public String getCategoryID()
    {
        return this.categoryID;
    }
    public void setCategoryID(String value)
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
