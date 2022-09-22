package com.rara.lms.course.model;

import lombok.*;

@Getter
@Setter
public class ServiceResult {

    boolean result;
    String message;

    public ServiceResult() {
        result = true;
    }

    public ServiceResult(boolean result) {
        this.result = result;
    }

    public ServiceResult(boolean result, String message) {
        this.result = result;
        this.message = message;
    }
}
