package com.jingjing.manage.exception;

/**
 * Created by yuanqingjing on 2018/4/26
 */
public class WebException extends RuntimeException {
    public WebException(String message) {
        super(message);
    }

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }
}
