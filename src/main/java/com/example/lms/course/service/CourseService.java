package com.example.lms.course.service;


import com.example.lms.course.dto.CourseDto;
import com.example.lms.course.model.CourseInput;
import com.example.lms.course.model.CourseParam;

import java.util.List;

public interface CourseService {

    /**
     *  강좌 등록
     */
    boolean add(CourseInput parameter);

    /**
     * 강좌 목록
     */
    List<CourseDto> list(CourseParam parameter);
}
