package com.test.xy.demo.modle.net;

import java.io.IOException;

/**
 * 返回错误异常
 */
public class ResultException extends IOException {
    public ResultException(String message) {
        super(message);
    }
}
