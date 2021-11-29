package org.rhkddus.board.service.movie;

import org.rhkddus.board.dto.movie.ReviewDTO;
import org.rhkddus.board.entity.Member;
import org.rhkddus.board.entity.Movie;
import org.rhkddus.board.entity.Review;

import java.util.List;

public interface ReviewService {

    //영화의 모든 리뷰
    List<ReviewDTO> getListOfMovie(Long movieNum);

    //영화 리뷰 추가
    Long register(ReviewDTO movieReviewDTO);

    //리뷰 수정
    void modify(ReviewDTO movieReviewDTO);

    //리뷰 삭제
    void remove(Long reviewNum);

    default Review dtoToEntity(ReviewDTO movieReviewDTO){

        Review movieReview = Review.builder()
                .reviewNum(movieReviewDTO.getReviewNum())
                .movie(Movie.builder().movieNum(movieReviewDTO.getMovieNum()).build())
                .member(Member.builder().email(movieReviewDTO.getEmail()).build())
                .grade(movieReviewDTO.getGrade())
                .text(movieReviewDTO.getText())
                .build();

        return movieReview;

    }

    default ReviewDTO entityToDto(Review movieReview){

        ReviewDTO movieReviewDTO = ReviewDTO.builder()
                .reviewNum(movieReview.getReviewNum())
                .movieNum(movieReview.getMovie().getMovieNum())
                .email(movieReview.getMember().getEmail())
                .name(movieReview.getMember().getName())
                .grade(movieReview.getGrade())
                .text(movieReview.getText())
                .regDate(movieReview.getRegDate())
                .modDate(movieReview.getModDate())
                .build();

        return movieReviewDTO;

    }

}
