package org.rhkddus.board.dto.movie;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long movieNum;

    private String title;

    @Builder.Default
    private List<MovieImageDTO> imageDTOList = new ArrayList<>();

    //영화의 평균 평점
    private double avg;

    //리뷰 수 / jpa의 count()
    private int reviewCnt;

    private LocalDateTime regDate;

    private LocalDateTime modDate;




}
