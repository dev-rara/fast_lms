package com.rara.lms.course.service;


import com.rara.lms.course.dto.CourseDto;
import com.rara.lms.course.model.CourseInput;
import com.rara.lms.course.model.CourseParam;
import com.rara.lms.course.model.ServiceResult;
import com.rara.lms.course.model.TakeCourseInput;

import java.util.List;

public interface CourseService {

    /**
     *  강좌 등록
     */
    boolean add(CourseInput parameter);

    /**
     * 강좌 정보 수정
     */
    boolean set(CourseInput parameter);

    /**
     * 강좌 목록
     */
    List<CourseDto> list(CourseParam parameter);

    /**
     * 강좌 상세 정보
     */
    CourseDto getById(long id);

    /**
     * 강좌 내용 삭제
     */
    boolean del(String idList);

    /**
     * 프론트 강좌 목록
     */
    List<CourseDto> frontList(CourseParam parameter);


    /**
     * 프론트 강좌 상세 정보
     */
     CourseDto frontDetail(long id);

    /**
     * 수강신청
     */
    ServiceResult req(TakeCourseInput parameter);

    /**
     * 전체 강좌 목록
     */
    List<CourseDto> listAll();
}
