package com.zerobase.fast_lms.member.repository;

import com.zerobase.fast_lms.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
