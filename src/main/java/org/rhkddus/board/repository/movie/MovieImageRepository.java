package org.rhkddus.board.repository.movie;

import org.rhkddus.board.entity.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {

    @Modifying
    @Query("delete from MovieImage mi where mi.movie.movieNum =:movieNum")
    void deleteByMovieNum(Long movieNum);


}
