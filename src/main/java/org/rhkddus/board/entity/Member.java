package org.rhkddus.board.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member  extends BaseEntity{


    @Id
    private String email;

    private String password;

    private String name;


    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void addMemberRole(MemberRole memberRole){
        roleSet.add(memberRole);

    }

    public void setPassword(String password){
        this.password = password;
    }

}
