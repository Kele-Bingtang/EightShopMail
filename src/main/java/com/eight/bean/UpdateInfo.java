package com.eight.bean;

public class UpdateInfo {
    private String user_info_id;
    private String user_id;
    private String user_name;
    private String real_name;
    private String identity_card_type;
    private String identity_card_no;
    private String user_sex;
    private String mobile_phone;
    private String email;

    public String getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(String user_info_id) {
        this.user_info_id = user_info_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getIdentity_card_type() {
        return identity_card_type;
    }

    public void setIdentity_card_type(String identity_card_type) {
        this.identity_card_type = identity_card_type;
    }

    public String getIdentity_card_no() {
        return identity_card_no;
    }

    public void setIdentity_card_no(String identity_card_no) {
        this.identity_card_no = identity_card_no;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UpdateInfo{" +
                "user_info_id='" + user_info_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", real_name='" + real_name + '\'' +
                ", identity_card_type='" + identity_card_type + '\'' +
                ", identity_card_no='" + identity_card_no + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

