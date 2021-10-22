package org.rhkddus.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.rhkddus.board.dto.MemberDTO;
import org.rhkddus.board.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member/")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;



    @GetMapping("/form")
    public void form(){

    }

    @PostMapping("/form")
    public String formPost(MemberDTO dto, RedirectAttributes redirectAttributes){

        log.info(dto);

        String email = memberService.register(dto);


        log.info("EMAIL : " + email);

        redirectAttributes.addFlashAttribute("email" + email);

        return "redirect:/board/list";

    }


}
