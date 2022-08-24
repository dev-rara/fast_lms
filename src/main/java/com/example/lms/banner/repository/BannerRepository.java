package com.example.lms.banner.repository;

import com.example.lms.banner.entity.Banner;
import com.example.lms.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BannerRepository extends JpaRepository<Banner, Long> {

}
