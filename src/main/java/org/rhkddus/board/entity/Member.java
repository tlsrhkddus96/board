package org.rhkddus.board.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member  extends BaseEntity{


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long memberNum;

    private String email;

    private String password;

    private String name;


}
