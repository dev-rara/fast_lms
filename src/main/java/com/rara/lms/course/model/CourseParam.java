package com.rara.lms.course.model;


import com.rara.lms.admin.model.CommonParam;
import lombok.*;

@Getter
@Setter
public class CourseParam extends CommonParam {

    long id;
    long categoryId;
}
