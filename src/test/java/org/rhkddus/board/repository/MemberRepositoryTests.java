package org.rhkddus.board.repository;

import org.junit.jupiter.api.Test;
import org.rhkddus.board.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertMembers(){

        IntStream.rangeClosed(1,100).forEach(i -> {

            Member member = Member.builder()
                    .email("user"+i + "@aaa.com")
                    .password("1111")
                    .name("USER"+i)
                    .build();

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
//        boardRepository.deleteByMember(member);
        memberRepository.deleteById(email);

    }




}
