package org.rhkddus.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    //리뷰 id
    private Long reviewNum;

    //무비 id
    private Long movieNum;

    //멤버 id
    private String email;

    private String name;

    private int grade;
    private String text;

    private LocalDateTime regDate, modDate;


}
