package com.example.lms.member.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Member {
    @Id
    private String userId;

    private String userName;
    private String phone;
    private String password;

    // DB 내부적으로 저장하는 회원등록일
    private LocalDateTime regDt;

    //메일 인증 완료 여부확인
    private boolean emailAuthYn;

    //계정 활성화 일자
    private LocalDateTime emailAuthDt;

    //회원가입 시 메일 인증키 확인
    private String emailAuthKey;

    //비밀번호 초기화 시 확인용
    private String resetPasswordKey;

    private LocalDateTime resetPasswordLimitDt;

    //관리자 여부 확인
    private boolean adminYn;
}
