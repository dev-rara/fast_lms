package com.example.lms.banner.mapper;

import com.example.lms.banner.dto.BannerDto;
import com.example.lms.banner.model.BannerParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    long selectListCount(BannerParam parameter);
    List<BannerDto> selectList(BannerParam parameter);

}
