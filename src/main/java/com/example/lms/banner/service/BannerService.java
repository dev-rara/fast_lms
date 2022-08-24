package com.example.lms.banner.service;

import com.example.lms.banner.dto.BannerDto;
import com.example.lms.banner.model.BannerInput;
import com.example.lms.banner.model.BannerParam;

import java.util.List;

public interface BannerService {

    /*
     * 배너 등록
     */
    boolean add(BannerInput bannerInput);

    /*
     * 배너 정보 수정
     */
    boolean set(BannerInput bannerInput);

    /*
     * 배너 목록
     */
    List<BannerDto> list(BannerParam parameter);

    /*
     * 배너 상세 정보
     */
    BannerDto getById(long id);

    /*
     * 배너 정보 삭제
     */
    boolean del(String idList);

    /*
     * 전체 배너 목록
     */
    List<BannerDto> listAll();
}
