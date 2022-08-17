package com.example.lms.admin.repository;

import com.example.lms.admin.entity.Category;
import com.example.lms.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
