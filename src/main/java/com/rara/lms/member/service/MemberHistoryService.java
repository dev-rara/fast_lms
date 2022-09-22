package com.rara.lms.member.service;

import com.rara.lms.admin.dto.MemberHistoryDto;
import com.rara.lms.admin.model.MemberParam;
import com.rara.lms.member.model.MemberHistoryInput;

import java.util.List;

public interface MemberHistoryService{

    /**
     * 로그인 기록 저장
     */
    boolean saveHistory(MemberHistoryInput parameter);

    List<MemberHistoryDto> historyList(MemberParam parameter);
}
