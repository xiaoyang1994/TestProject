package com.test.xy.demo.modle.entity;


public class LoginEntity {


    /**
     * userInfo : {"id":101,"verificationCode":0,"username":"18302133288","fullName":"wanyufan","icon":"150-150-30.png","activeEnterprise":93,"activeEnterpriseAdmin":false}
     * id : 101
     * token : eyJhbGciOiOUZ7GGezA
     * username : 18302133288
     */

    private UserInfoBean userInfo;
    private String id;
    private String token;
    private String username;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static class UserInfoBean {
        /**
         * id : 101
         * verificationCode : 0
         * username : 18302133288
         * fullName : wanyufan
         * icon : 150-150-30.png
         * activeEnterprise : 93
         * activeEnterpriseAdmin : false
         */

        private String id;
        private String verificationCode;
        private String username;
        private String fullName;
        private String icon;
        private String activeEnterprise;
        private boolean activeEnterpriseAdmin;
        private String level;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVerificationCode() {
            return verificationCode;
        }

        public void setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getActiveEnterprise() {
            return activeEnterprise;
        }

        public void setActiveEnterprise(String activeEnterprise) {
            this.activeEnterprise = activeEnterprise;
        }

        public boolean isActiveEnterpriseAdmin() {
            return activeEnterpriseAdmin;
        }

        public void setActiveEnterpriseAdmin(boolean activeEnterpriseAdmin) {
            this.activeEnterpriseAdmin = activeEnterpriseAdmin;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }
}
