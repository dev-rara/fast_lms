package com.example.lms.admin.dto;

import com.example.lms.admin.entity.Category;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    Long id;
    String categoryName;
    int sortValue;
    boolean usingYn;

    //추가 컬럼
    int courseCount;


    public static List<CategoryDto> of(List<Category> categories) {
        if(categories != null) {
            List<CategoryDto> categoryDtoList = new ArrayList<>();
            for (Category x : categories) {
                categoryDtoList.add(of(x));
            }
            return categoryDtoList;
        }
        return null;
    }

    public static CategoryDto of(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .sortValue(category.getSortValue())
                .usingYn(category.isUsingYn())
                .build();
    }
}
