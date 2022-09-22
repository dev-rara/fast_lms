package com.rara.lms.course.model;


import com.rara.lms.admin.model.CommonParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TakeCourseParam extends CommonParam {

    long id;
    String status;

    String userId;


    long searchCourseId;
}
