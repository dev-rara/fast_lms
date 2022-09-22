package com.rara.lms.banner.mapper;

import com.rara.lms.banner.dto.BannerDto;
import com.rara.lms.banner.model.BannerParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    long selectListCount(BannerParam parameter);
    List<BannerDto> selectList(BannerParam parameter);

    List<BannerDto> selectAllList();
}
