package com.example.lms_service.member.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberInput {

    private String userId;
    private String userName;
    private String password;
    private String phone;

}
