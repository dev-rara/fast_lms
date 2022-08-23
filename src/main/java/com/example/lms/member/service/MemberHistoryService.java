package com.example.lms.member.service;

import com.example.lms.admin.dto.MemberHistoryDto;
import com.example.lms.admin.model.MemberParam;
import com.example.lms.member.model.MemberHistoryInput;

import java.util.List;

public interface MemberHistoryService{

    /**
     * 로그인 기록 저장
     */
    boolean saveHistory(MemberHistoryInput parameter);

    List<MemberHistoryDto> historyList(MemberParam parameter);
}
