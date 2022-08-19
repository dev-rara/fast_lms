package com.example.lms.course.service;

import com.example.lms.course.dto.CourseDto;
import com.example.lms.course.dto.TakeCourseDto;
import com.example.lms.course.model.ServiceResult;
import com.example.lms.course.model.TakeCourseParam;

import java.util.List;

public interface TakeCourseService {

    /**
     * 수강 목록
     */
    List<TakeCourseDto> list(TakeCourseParam parameter);


    /**
     * 수강신청 내역 상태 변경
     */
    ServiceResult updateStatus(long id, String status);
}
