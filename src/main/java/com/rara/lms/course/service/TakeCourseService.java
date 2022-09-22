package com.rara.lms.course.service;

import com.rara.lms.course.dto.TakeCourseDto;
import com.rara.lms.course.model.ServiceResult;
import com.rara.lms.course.model.TakeCourseParam;

import java.util.List;

public interface TakeCourseService {

    /**
     * 수강 목록
     */
    List<TakeCourseDto> list(TakeCourseParam parameter);

    /**
     * 수강 상세 정보
     */
    TakeCourseDto detail(long id);


    /**
     * 수강신청 내역 상태 변경
     */
    ServiceResult updateStatus(long id, String status);

    /**
     * 내 수강 목록
     */
    List<TakeCourseDto> myCourse(String userId);

    /**
     * 수강신청 취소
     */
    ServiceResult cancel(long id);
}
