package com.example.lms.course.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResult {

    boolean result;
    String message;


    public ServiceResult(boolean result) {
        this.result = result;
    }
}
