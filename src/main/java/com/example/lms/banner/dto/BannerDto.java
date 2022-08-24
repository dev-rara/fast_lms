package com.example.lms.banner.dto;

import com.example.lms.admin.dto.MemberDto;
import com.example.lms.banner.entity.Banner;
import com.example.lms.member.entity.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BannerDto {

    Long id;

    String bannerName;
    String url;
    String alterText;
    int openMethod;

    String fileDirectory;

    int sortOrder;
    boolean openYn;

    LocalDateTime regDt;
    LocalDateTime udtDt;

    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {
        return  BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .url(banner.getUrl())
                .alterText(banner.getAlterText())
                .openMethod(banner.getOpenMethod())
                .fileDirectory(banner.getFileDirectory())
                .sortOrder(banner.getSortOrder())
                .openYn(banner.isOpenYn())
                .regDt(banner.getRegDt())
                .udtDt(banner.getUdtDt())
                .build();
    }

    public static List<BannerDto> of(List<Banner> bannerList) {

        if (bannerList == null) {
            return null;
        }

        List<BannerDto> bannerDtoList = new ArrayList<>();
        for(Banner x: bannerList) {
            bannerDtoList.add(BannerDto.of(x));
        }
        return bannerDtoList;
    }

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return regDt != null ? regDt.format(formatter) : "";
    }

    public String getUdtDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return udtDt != null ? udtDt.format(formatter) : "";
    }
}
