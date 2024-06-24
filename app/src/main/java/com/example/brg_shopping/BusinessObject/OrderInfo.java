package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderInfo implements Serializable {
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

        private String OrderID;
        public String getOrderID()
        {
            return this.OrderID;
        }
        public void setOrderID(String value)
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

        private String UserID;
        public String getUserID()
        {
            return this.UserID;
        }
        public void setUserID(String value)
        {
            this.UserID = value;
        }
}
