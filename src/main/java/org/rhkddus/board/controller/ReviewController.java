package org.rhkddus.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.rhkddus.board.dto.ReviewDTO;
import org.rhkddus.board.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{movieNum}/all")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("movieNum") Long movieNum){

        log.info("--------list-----------");
        log.info("MovieNum : " + movieNum);

        List<ReviewDTO> reviewDTOList = reviewService.getListOfMovie(movieNum);

        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);

    }

    @PostMapping("/{movieNum}")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDTO movieReviewDTO){

        log.info("===========add Movie Review ============");
        log.info("reviewDTO : " + movieReviewDTO);

        Long reviewNum = reviewService.register(movieReviewDTO);

        return new ResponseEntity<>(reviewNum, HttpStatus.OK);

    }

    @PutMapping("/{movieNum}/{reviewNum}")
    public ResponseEntity<Long> modifyReview(@PathVariable Long reviewNum, @RequestBody ReviewDTO movieReviewDTO){

        log.info("modify MovieReview --------------");

        log.info("reviewDTO : " + movieReviewDTO);

        reviewService.modify(movieReviewDTO);

        return new ResponseEntity<>(reviewNum, HttpStatus.OK);

    }


    @DeleteMapping("/{movieNum}/{reviewNum}")
    public ResponseEntity<Long> removeReview(@PathVariable Long reviewNum){

        log.info("---------------Remove Review ---------");

        log.info("reviewNum : " + reviewNum);

        reviewService.remove(reviewNum);

        return new ResponseEntity<>(reviewNum, HttpStatus.OK);


    }







}
