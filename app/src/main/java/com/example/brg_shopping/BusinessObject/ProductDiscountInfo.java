package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDiscountInfo implements Serializable {
        private int AutoID;
        public int getAutoID()
        {
            return this.AutoID;
        }
        public void setAutoID(int value)
        {
            this.AutoID = value;
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

        private java.sql.Date DateFrom;
        public java.sql.Date getDateFrom()
        {
            return this.DateFrom;
        }
        public void setDateFrom(java.sql.Date value)
        {
            this.DateFrom = value;
        }

        private java.sql.Date DateTo;
        public java.sql.Date getDateTo()
        {
            return this.DateTo;
        }
        public void setDateTo(java.sql.Date value)
        {
            this.DateTo = value;
        }

        private int Discount;
        public int getDiscount()
        {
            return this.Discount;
        }
        public void setDiscount(int value)
        {
            this.Discount = value;
        }

        private BigDecimal PriceDiscount;
        public BigDecimal getPriceDiscount()
        {
            return this.PriceDiscount;
        }
        public void setPriceDiscount(BigDecimal value)
        {
            this.PriceDiscount = value;
        }
}
