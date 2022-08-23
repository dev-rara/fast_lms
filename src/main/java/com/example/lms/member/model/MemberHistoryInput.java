package com.example.lms.member.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberHistoryInput {

    private String userId;
    private LocalDateTime loginDt;
    private String userIp;
    private String userAgent;
}
