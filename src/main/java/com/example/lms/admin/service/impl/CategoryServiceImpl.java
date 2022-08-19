package com.example.lms.admin.service.impl;

import com.example.lms.admin.dto.CategoryDto;
import com.example.lms.admin.entity.Category;
import com.example.lms.admin.mapper.CategoryMapper;
import com.example.lms.admin.model.CategoryInput;
import com.example.lms.admin.repository.CategoryRepository;
import com.example.lms.admin.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    private Sort getSortByValueDesc() {
        return Sort.by(Sort.Direction.DESC, "sortValue");
    }


    @Override
    public List<CategoryDto> list() {
       List<Category> categories = categoryRepository.findAll(getSortByValueDesc());

       return CategoryDto.of(categories);
    }

    @Override
    public boolean add(String categoryName) {

        Category category = Category.builder()
                .categoryName(categoryName)
                .usingYn(true)
                .sortValue(0)
                .build();
        categoryRepository.save(category);

        return false;
    }

    @Override
    public boolean update(CategoryInput parameter) {

        Optional<Category> optionalCategory = categoryRepository.findById(parameter.getId());
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();

            category.setCategoryName(parameter.getCategoryName());
            category.setSortValue(parameter.getSortValue());
            category.setUsingYn(parameter.isUsingYn());

            categoryRepository.save(category);
        }

        return true;
    }

    @Override
    public boolean del(long id) {

        categoryRepository.deleteById(id);

        return true;
    }

    @Override
    public List<CategoryDto> frontList(CategoryDto parameter) {

        return categoryMapper.select(parameter);
    }
}
