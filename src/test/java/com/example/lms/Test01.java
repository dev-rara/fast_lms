package com.example.lms;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test01 {

    @Test
    void TEST_01() {

        String value = "2022-08-15";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            System.out.println(LocalDate.parse(value, formatter));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
