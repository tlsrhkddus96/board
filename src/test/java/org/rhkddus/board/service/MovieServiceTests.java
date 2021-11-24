package org.rhkddus.board.service;

import org.junit.jupiter.api.Test;
import org.rhkddus.board.dto.MovieDTO;
import org.rhkddus.board.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieServiceTests {

    @Autowired
    MovieService movieService;



    @Test
    public void testRemove(){

        Long movieNum = 100L;

        movieService.removeWithReviews(movieNum);

    }


    @Test
    public void testModify(){

        MovieDTO movieDTO = MovieDTO.builder()
                .movieNum(98L)
                .title("제목 변경")
                .build();

        movieService.modify(movieDTO);

    }


}
