package com.exam.mapper;
import com.exam.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public int save(Member member);
    public Member findById(String userid);
}
