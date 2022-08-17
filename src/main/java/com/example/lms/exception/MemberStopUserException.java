package com.example.lms.exception;

public class MemberStopUserException extends RuntimeException {
    public MemberStopUserException(String error) {
        super(error);
    }
}
