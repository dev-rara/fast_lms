package com.example.lms.admin.dto;

import com.example.lms.member.entity.Member;
import com.example.lms.member.entity.MemberHistory;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberHistoryDto {

    long id;
    LocalDateTime loginDt;
    String userIp;
    String userAgent;

    long totalCount;
    long seq;

    public String getLoginDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

        return loginDt != null? loginDt.format(formatter) : "";
    }

}
