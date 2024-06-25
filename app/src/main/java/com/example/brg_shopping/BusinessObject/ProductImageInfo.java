package com.example.brg_shopping.BusinessObject;

import java.io.Serializable;

public class ProductImageInfo implements Serializable {
        private int ProductImageID;
        public int getProductImageID()
        {
            return this.ProductImageID;
        }
        public void setProductImageID(int value)
        {
            this.ProductImageID = value;
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

        private byte[] Image;
        public byte[] getImage()
        {
            return this.Image;
        }
        public void setImage(byte[] value)
        {
            this.Image = value;
        }
}
