package com.example.lms.util;

import com.example.lms.course.model.ServiceResult;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {

    public static boolean equals(String plaintext, String hased) {

        if (plaintext == null || plaintext.length() < 1) {
            return false;
        }

        if(hased == null || hased.length() < 1) {
            return false;
        }

        return BCrypt.checkpw(plaintext, hased);
    }

    public static String encPassword(String plaintext) {

        if (plaintext == null || plaintext.length() < 1) {
            return "";
        }

        return BCrypt.hashpw(plaintext, BCrypt.gensalt());
    }
}
