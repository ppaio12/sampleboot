package com.exam.service;

import com.exam.dto.Member;
import com.exam.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public int save(Member member) {
        return memberMapper.save(member);
    }

    @Override
    public Member findById(String userid) {
        return memberMapper.findById(userid);
    }

}
