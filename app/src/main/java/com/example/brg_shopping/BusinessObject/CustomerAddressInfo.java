package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class CustomerAddressInfo implements Serializable
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

    private String CustomerAddressID;
    public String getCustomerAddressID()
    {
        return this.CustomerAddressID;
    }
    public void setCustomerAddressID(String value)
    {
        this.CustomerAddressID = value;
    }

    private String AddressName;
    public String getAddressName()
    {
        return this.AddressName;
    }
    public void setAddressName(String value)
    {
        this.AddressName = value;
    }

    private String PhoneNumber;
    public String getPhoneNumber()
    {
        return this.PhoneNumber;
    }
    public void setPhoneNumber(String value)
    {
        this.PhoneNumber = value;
    }

    private String City;
    public String getCity()
    {
        return this.City;
    }
    public void setCity(String value)
    {
        this.City = value;
    }

    private String District;
    public String getDistrict()
    {
        return this.District;
    }
    public void setDistrict(String value)
    {
        this.District = value;
    }

    private String Ward;
    public String getWard()
    {
        return this.Ward;
    }
    public void setWard(String value)
    {
        this.Ward = value;
    }

    private String AddressDetail;
    public String getAddressDetail()
    {
        return this.AddressDetail;
    }
    public void setAddressDetail(String value)
    {
        this.AddressDetail = value;
    }

    private boolean Default;
    public boolean getDefault()
    {
        return this.Default;
    }
    public void setDefault(boolean value)
    {
        this.Default = value;
    }
}
