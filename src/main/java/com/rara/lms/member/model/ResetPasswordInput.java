package com.rara.lms.member.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResetPasswordInput {

    private String userId;
    private String userName;

    private String id;
    private String password;
}
