package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomerInfo implements Serializable {
    private int CustomerID;
    private String password;
    private String fullName;
    private String dateOfBirth;
    private Date dateOfBirth_Format;
    private String sex;
    private String phoneNumber;
    private String email;
    public int getCustomerID() {
        return this.CustomerID;
    }
    public void setCustomerID(int value) {
        this.CustomerID = value;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String value) {
        this.password = value;
    }
    public String getFullName() {
        return this.fullName;
    }
    public void setFullName(String value) {
        this.fullName = value;
    }
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(String value) {
        this.dateOfBirth = value;
        setDateOfBirth_Format();
    }

    public Date getDateOfBirth_Format() {
        if (dateOfBirth_Format == null) {
            setDateOfBirth_Format();
        }
        return dateOfBirth_Format;
    }

    public void setDateOfBirth_Format() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            this.dateOfBirth_Format = formatter.parse(dateOfBirth);
        }
        catch (ParseException e) {
            this.dateOfBirth_Format = Calendar.getInstance().getTime();
        }
    }

    public String getSex() {
        return this.sex;
    }
    public void setSex(String value) {
        this.sex = value;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String value) {
        this.email = value;
    }

}
