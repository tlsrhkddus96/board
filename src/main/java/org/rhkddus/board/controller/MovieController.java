package org.rhkddus.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.rhkddus.board.dto.MovieDTO;
import org.rhkddus.board.dto.PageRequestDTO;
import org.rhkddus.board.service.MovieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/movie")
@Log4j2
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String register(MovieDTO movieDTO, RedirectAttributes redirectAttributes){

        log.info("movieDTO: " + movieDTO);

        Long movieNum = movieService.register(movieDTO);

        redirectAttributes.addFlashAttribute("msg", movieNum);

        return "redirect:/movie/list";

    }


    @GetMapping("list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        log.info("pageRequestDTO : "+ pageRequestDTO);

        model.addAttribute("result", movieService.getList(pageRequestDTO));

    }


    @GetMapping({"/read", "/modify"})
    public void read(long movieNum, @ModelAttribute("requestDTO")PageRequestDTO requestDTO, Model model){

        log.info("movieNum : " + movieNum);

        MovieDTO movieDTO = movieService.getMovie(movieNum);

        model.addAttribute("dto", movieDTO);

    }

    @PostMapping("/remove")
    public String remove(long movieNum, RedirectAttributes redirectAttributes){

        log.info("movieNum : " + movieNum);

        movieService.removeWithReviews(movieNum);

        redirectAttributes.addFlashAttribute("msg", movieNum);

        return "redirect:/movie/list";

    }

    @PostMapping("/modify")
    public String modify(MovieDTO dto,
                         @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes){

        log.info("Post Modify");
        log.info("dto : " + dto);

        movieService.modify(dto);

        redirectAttributes.addAttribute("page", requestDTO.getPage());

        redirectAttributes.addAttribute("movieNum",dto.getMovieNum());

        return "redirect:/movie/read";

    }



}
