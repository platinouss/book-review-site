package com.platinouss.bookrecommend.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority extends BaseEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authority;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Override
    public String toString() {
        return authority;
    }
}
