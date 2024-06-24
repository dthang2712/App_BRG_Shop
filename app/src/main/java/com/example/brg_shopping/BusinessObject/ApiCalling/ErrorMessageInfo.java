package com.example.brg_shopping.BusinessObject.ApiCalling;

public class ErrorMessageInfo {
        private String msgCode;
        private String msgString;

        public ErrorMessageInfo() {
        }

        public ErrorMessageInfo(String msgCode, String msgString) {
            this.msgCode = msgCode;
            this.msgString = msgString;
        }

        public String getMsgCode() {
            return msgCode;
        }

        public void setMsgCode(String msgCode) {
            this.msgCode = msgCode;
        }

        public String getMsgString() {
            return msgString;
        }

        public void setMsgString(String msgString) {
            this.msgString = msgString;
        }
}
