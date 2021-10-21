package org.rhkddus.board.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.rhkddus.board.entity.Member;
import org.rhkddus.board.repository.MemberRepository;
import org.rhkddus.board.security.dto.AuthMemberDTO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("UserDetailService loadUserByUsername : " + username);

        Optional<Member> result = memberRepository.findByEmail(username);

        if(!result.isPresent()) {

            throw new UsernameNotFoundException("Please Check Email");

        }

        Member member = result.get();

        log.info("-=-------------------------");
        log.info(member);

        AuthMemberDTO authMember = new AuthMemberDTO(
                member.getEmail(),
                member.getPassword(),
                member.getRoleSet().stream().map(
                        role -> new SimpleGrantedAuthority("ROLE_"+ role.name())).collect(Collectors.toSet())
        );

        authMember.setName(member.getName());

        return authMember;
    }
}
