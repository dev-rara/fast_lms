package com.rara.lms.admin.service;

import com.rara.lms.admin.dto.CategoryDto;
import com.rara.lms.admin.model.CategoryInput;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> list();

    /**
     * 카테고리 신규추가
     */
    boolean add(String categoryName);

    /**
     * 카테고리 수정
     */
    boolean update(CategoryInput parameter);

    /**
     * 카테고리 삭제
     */
    boolean del(long id);

    /**
     * 프론트 카테고리
     */
    List<CategoryDto> frontList(CategoryDto parameter);
}
