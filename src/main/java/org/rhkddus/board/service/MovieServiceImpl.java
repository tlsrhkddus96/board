package org.rhkddus.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.rhkddus.board.dto.MovieDTO;
import org.rhkddus.board.dto.PageRequestDTO;
import org.rhkddus.board.dto.PageResultDTO;
import org.rhkddus.board.entity.Movie;
import org.rhkddus.board.entity.MovieImage;
import org.rhkddus.board.repository.MovieImageRepository;
import org.rhkddus.board.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    private final MovieImageRepository imageRepository;

    @Transactional
    @Override
    public Long register(MovieDTO movieDTO) {

        Map<String, Object> entityMap = dtoToEntity(movieDTO);
        Movie movie = (Movie) entityMap.get("movie");
        List<MovieImage> movieImageList = (List<MovieImage>) entityMap.get("imgList");

        movieRepository.save(movie);

        movieImageList.forEach(movieImage -> {

            imageRepository.save(movieImage);

        });

        return movie.getMovieNum();

    }

    @Override
    public PageResultDTO<MovieDTO, Object[]> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("movieNum").descending());

        Page<Object[]> result = movieRepository.getListPage(pageable);

        Function<Object[], MovieDTO> fn = (arr -> entitiesToDTO(
                (Movie) arr[0],
                (List<MovieImage>) (Arrays.asList((MovieImage)arr[1])),
                (Double) arr[2],
                (Long) arr[3]
        ));

        return new PageResultDTO<>(result, fn);
    }


}
