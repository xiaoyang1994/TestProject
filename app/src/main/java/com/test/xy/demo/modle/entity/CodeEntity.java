package com.test.xy.demo.modle.entity;

/**
 * 手机验证码实体
 */

public class CodeEntity {

    /**
     * code : 123456
     * tips : 验证码已下发，五分钟内有效
     */

    private int code;
    private String tips;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
