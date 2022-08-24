package com.example.lms.banner.service.Impl;

import com.example.lms.banner.dto.BannerDto;
import com.example.lms.banner.entity.Banner;
import com.example.lms.banner.mapper.BannerMapper;
import com.example.lms.banner.model.BannerInput;
import com.example.lms.banner.model.BannerParam;
import com.example.lms.banner.repository.BannerRepository;
import com.example.lms.banner.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public boolean add(BannerInput parameter) {

        Banner banner = Banner.builder()
                .bannerName(parameter.getBannerName())
                .url(parameter.getUrl())
                .alterText(parameter.getAlterText())
                .openMethod(parameter.getOpenMethod())
                .fileDirectory(parameter.getFileDirectory())
                .sortOrder(parameter.getSortOrder())
                .openYn(true)
                .regDt(LocalDateTime.now())
                .build();

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean set(BannerInput parameter) {

        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());

        if (!optionalBanner.isPresent()) {
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setBannerName(parameter.getBannerName());
        banner.setUrl(parameter.getUrl());
        banner.setAlterText(parameter.getAlterText());
        banner.setOpenMethod(parameter.getOpenMethod());
        banner.setFileDirectory(parameter.getFileDirectory());
        banner.setSortOrder(parameter.getSortOrder());
        banner.setOpenYn(parameter.isOpenYn());
        banner.setRegDt(banner.getRegDt());
        banner.setUdtDt(LocalDateTime.now());

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        long totalCount = bannerMapper.selectListCount(parameter);

        List<BannerDto> list = bannerMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for(BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }

        return list;
    }

    @Override
    public BannerDto getById(long id) {

        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    @Override
    public boolean del(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;

                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }

        return true;
    }

    @Override
    public List<BannerDto> listAll() {

        List<Banner> bannerList = bannerRepository.findAll();

        return BannerDto.of(bannerList);
    }
}
