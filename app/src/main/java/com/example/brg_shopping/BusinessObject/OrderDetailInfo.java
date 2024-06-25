package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class OrderDetailInfo implements Serializable {
        private int OrderID;
        public int getOrderID()
        {
            return this.OrderID;
        }
        public void setOrderID(int  value)
        {
            this.OrderID = value;
        }
    private int OrderDetailID;
    public int getOrderDetailID()
    {
        return this.OrderDetailID;
    }
    public void setOrderDetailID(int  value)
    {
        this.OrderDetailID = value;
    }

        private int ProductID;
        public int getProductID()
        {
            return this.ProductID;
        }
        public void setProductID(int value)
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
