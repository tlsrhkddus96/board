package org.rhkddus.board.repository;

import org.junit.jupiter.api.Test;
import org.rhkddus.board.entity.Member;
import org.rhkddus.board.entity.Movie;
import org.rhkddus.board.entity.Review;
import org.rhkddus.board.repository.movie.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMovieReviews() {


        IntStream.rangeClosed(1,200).forEach(i-> {

            //영화번호
            Long movieNum = (long)(Math.random()*100) + 1 ;

            //리뷰어 번호
            Long mid = ((long)(Math.random()*100) +1) ;
            String email = "user"+mid+"@aaa.com";

            Member member = Member.builder().email(email).build();

            Review movieReview = Review.builder()
                    .member(member)
                    .movie(Movie.builder().movieNum(movieNum).build())
                    .grade((int)(Math.random()*5) +1 )
                    .text("이 영화에 대한 느낌은... " + i)
                    .build();

            reviewRepository.save(movieReview);


        });

    }


    @Test
    public void testGetMovieReviews(){

        Movie movie = Movie.builder().movieNum(18L).build();

        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(movieReview -> {

            System.out.println(movieReview.getReviewNum());
            System.out.println("\t"+movieReview.getGrade());
            System.out.println("\t"+movieReview.getText());
            System.out.println("\t"+movieReview.getMember().getEmail());
            System.out.println("---------------------------");


        });

    }



}
