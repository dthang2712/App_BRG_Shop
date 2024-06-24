package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class ProductImageInfo implements Serializable {
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

        private byte[] _;
        public byte[] get()
        {
            return this._;
        }
        public void set(byte[] value)
        {
            this._ = value;
        }
}
