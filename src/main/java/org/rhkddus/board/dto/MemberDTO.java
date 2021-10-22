package org.rhkddus.board.dto;


import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String email;

    private String password;

    private String name;



}
