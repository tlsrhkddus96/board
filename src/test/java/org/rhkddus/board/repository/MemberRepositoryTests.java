package org.rhkddus.board.repository;

import org.junit.jupiter.api.Test;
import org.rhkddus.board.entity.Member;
import org.rhkddus.board.entity.MemberRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMembers(){

        IntStream.rangeClosed(1,100).forEach(i -> {

            Member member = Member.builder()
                    .email("user"+i + "@aaa.com")
                    .password(passwordEncoder.encode("1111"))
                    .name("USER"+i)
                    .build();

            member.addMemberRole(MemberRole.USER);

            if(i > 90){
                member.addMemberRole(MemberRole.ADMIN);
            }

            memberRepository.save(member);

        });

    }


    @Commit
    @Transactional
    @Test
    public void testDeleteMember(){

        String email = "user99@aaa.com";

        Member member = Member.builder().email(email).build();


        reviewRepository.deleteByMember(member);
        boardRepository.deleteByMember(member);
        memberRepository.deleteById(email);

    }


    @Test
    public void testRead(){

        Optional<Member> result = memberRepository.findByEmail("user95@aaa.com");

        Member member = result.get();

        System.out.println(member);

    }




}
