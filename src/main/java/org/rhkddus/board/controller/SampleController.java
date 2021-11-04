package org.rhkddus.board.controller;

import lombok.extern.log4j.Log4j2;
import org.rhkddus.board.security.service.UserDetailService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sample/")
public class SampleController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/all")
    public void exAll(){

        log.info("exAll....");

    }

    @GetMapping("/member")
    public void exMember(){

        log.info("exMember.....");

    }

    @GetMapping("/admin")
    public void exAdmin(){

        log.info("exAdmin");

    }



}
