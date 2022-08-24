package com.example.lms.banner.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bannerName;
    private String url;
    private String alterText;
    private int openMethod;

    private String fileDirectory;

    private int sortOrder;
    private boolean openYn;

    private LocalDateTime regDt;
    private LocalDateTime udtDt;
}
