package com.example.lms.admin.mapper;

import com.example.lms.admin.dto.MemberDto;
import com.example.lms.admin.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberDto> selectList(MemberParam parameter);
}
