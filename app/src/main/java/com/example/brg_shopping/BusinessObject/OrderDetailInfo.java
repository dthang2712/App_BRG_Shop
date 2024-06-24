package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class OrderDetailInfo implements Serializable {
        private int _AutoID;
        public int getAutoID()
        {
            return this._AutoID;
        }
        public void setAutoID(int value)
        {
            this._AutoID = value;
        }

        private String _OrderID;
        public String getOrderID()
        {
            return this._OrderID;
        }
        public void setOrderID(String value)
        {
            this._OrderID = value;
        }

        private String _ProductID;
        public String getProductID()
        {
            return this._ProductID;
        }
        public void setProductID(String value)
        {
            this._ProductID = value;
        }

        private int _Amount;
        public int getAmount()
        {
            return this._Amount;
        }
        public void setAmount(int value)
        {
            this._Amount = value;
        }
}
