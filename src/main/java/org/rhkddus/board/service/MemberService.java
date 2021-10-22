package org.rhkddus.board.service;

import org.rhkddus.board.dto.MemberDTO;
import org.rhkddus.board.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MemberService {




    String register(MemberDTO dto);

    default Member dtoToEntity(MemberDTO dto){

        Member member = Member.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .name(dto.getName())
                .build();

        return member;

    }


}
