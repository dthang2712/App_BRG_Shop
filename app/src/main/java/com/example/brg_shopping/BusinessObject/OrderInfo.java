package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderInfo implements Serializable {
        private int CustomerID;
        public int getCustomerID()
        {
            return this.CustomerID;
        }
        public void setCustomerID(int value)
        {
            this.CustomerID = value;
        }

        private int CustomerAddressID;
        public int getCustomerAddressID()
        {
            return this.CustomerAddressID;
        }
        public void setCustomerAddressID(int value)
        {
            this.CustomerAddressID = value;
        }

        private int OrderID;
        public int getOrderID()
        {
            return this.OrderID;
        }
        public void setOrderID(int value)
        {
            this.OrderID = value;
        }

        private String Note;
        public String getNote()
        {
            return this.Note;
        }
        public void setNote(String value)
        {
            this.Note = value;
        }

        private BigDecimal TotalPrice;
        public BigDecimal getTotalPrice()
        {
            return this.TotalPrice;
        }
        public void setTotalPrice(BigDecimal value)
        {
            this.TotalPrice = value;
        }

        private int Status;
        public int getStatus()
        {
            return this.Status;
        }
        public void setStatus(int value)
        {
            this.Status = value;
        }

        private int UserID;
        public int getUserID()
        {
            return this.UserID;
        }
        public void setUserID(int value)
        {
            this.UserID = value;
        }
}
