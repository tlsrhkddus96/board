package org.rhkddus.board.service.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.rhkddus.board.dto.ReviewDTO;
import org.rhkddus.board.entity.Movie;
import org.rhkddus.board.entity.Review;
import org.rhkddus.board.repository.movie.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;


    @Override
    public List<ReviewDTO> getListOfMovie(Long movieNum) {

        Movie movie = Movie.builder().movieNum(movieNum).build();

        List<Review> result = reviewRepository.findByMovie(movie);

        return result.stream().map(movieReview -> entityToDto(movieReview)).collect(Collectors.toList());


    }

    @Override
    public Long register(ReviewDTO movieReviewDTO) {

        Review movieReview = dtoToEntity(movieReviewDTO);

        reviewRepository.save(movieReview);

        return movieReview.getReviewNum();

    }

    @Override
    public void modify(ReviewDTO movieReviewDTO) {

        Optional<Review> result = reviewRepository.findById(movieReviewDTO.getReviewNum());

        if(result.isPresent()){

            Review movieReview = result.get();
            movieReview.changeGrade(movieReviewDTO.getGrade());
            movieReview.changeText(movieReviewDTO.getText());

            reviewRepository.save(movieReview);

        }

    }

    @Override
    public void remove(Long reviewNum) {

        reviewRepository.deleteById(reviewNum);

    }
}
