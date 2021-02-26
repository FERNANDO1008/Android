package com.example.luis_medina.data;

/**
 * A generic class that holds a result success w/ data or an error exception.
 */
public class Result<T> {
    // hide the private constructor to limit subclass types (Success, Error)
    private Result() {
    }

    @Override
    public String toString() {
        if (this instanceof com.example.luis_medina.data.Result.Success) {
            com.example.luis_medina.data.Result.Success success = (com.example.luis_medina.data.Result.Success) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof com.example.luis_medina.data.Result.Error) {
            com.example.luis_medina.data.Result.Error error = (com.example.luis_medina.data.Result.Error) this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }

    // Success sub-class
    public final static class Success<T> extends com.example.luis_medina.data.Result {
        private T data;

        public Success(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }

    // Error sub-class
    public final static class Error extends com.example.luis_medina.data.Result {
        private Exception error;

        public Error(Exception error) {
            this.error = error;
        }

        public Exception getError() {
            return this.error;
        }
    }
}