package com.rara.lms.banner.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BannerInput {

    Long id;
    String bannerName;
    String url;
    String alterText;
    int openMethod;
    String fileDirectory;
    int sortOrder;
    boolean openYn;

    String idList;
}
