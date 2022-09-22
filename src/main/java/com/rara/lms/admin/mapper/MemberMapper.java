package com.rara.lms.admin.mapper;

import com.rara.lms.admin.dto.MemberDto;
import com.rara.lms.admin.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberDto> selectList(MemberParam parameter);

    long selectListCount(MemberParam parameter);

    int updateLastLoginDt(String userId, LocalDateTime lastLoginDt);
}
