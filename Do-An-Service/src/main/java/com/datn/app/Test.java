package com.datn.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {
        String s = new BCryptPasswordEncoder().encode("abc@123456");
        System.out.println(s);
    }
}
