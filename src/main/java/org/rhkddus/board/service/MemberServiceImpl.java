package org.rhkddus.board.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.rhkddus.board.dto.MemberDTO;
import org.rhkddus.board.entity.Member;
import org.rhkddus.board.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public String register(MemberDTO dto) {


        log.info(dto);

        Member member = dtoToEntity(dto);

        memberRepository.save(member);

        return member.getEmail();

    }
}
