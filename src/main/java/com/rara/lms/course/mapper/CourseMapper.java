package com.rara.lms.course.mapper;

import com.rara.lms.course.dto.CourseDto;
import com.rara.lms.course.model.CourseParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    long selectListCount(CourseParam parameter);
    List<CourseDto> selectList(CourseParam parameter);

}
