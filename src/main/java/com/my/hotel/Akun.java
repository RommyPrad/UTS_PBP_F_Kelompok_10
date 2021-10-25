package com.my.hotel;

import android.telephony.PhoneNumberUtils;

public class Akun {
    String name;
    String email;
    String phone;
    String address;
    String password;

    public Akun(String name, String email, String phone, String address, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    public String getname() {
        return name;
    }
    public String getphone() {
        return PhoneNumberUtils.formatNumber(phone);
    }
    public String getEmail() {
        return email;
    }

}
