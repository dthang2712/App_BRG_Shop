package com.example.brg_shopping.BusinessObject.ApiCalling;

public class ActionMessageInfo {
        private Object response;
        private boolean isSuccess;
        private ErrorMessageInfo err;

        public ActionMessageInfo() {
            isSuccess = false;
            err = new ErrorMessageInfo();
        }

        public ActionMessageInfo(String message) {
            isSuccess = false;
            err = new ErrorMessageInfo("001", message);
        }

        public Object getResponse() {
            return response;
        }

        public void setResponse(Object response) {
            this.response = response;
        }

        public boolean isSuccess() {
            return isSuccess;
        }

        public void setSuccess(boolean success) {
            isSuccess = success;
        }

        public ErrorMessageInfo getErr() {
            return err;
        }

        public void setErr(ErrorMessageInfo err) {
            this.err = err;
        }
}
