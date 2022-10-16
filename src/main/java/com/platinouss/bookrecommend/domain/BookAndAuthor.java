package com.platinouss.bookrecommend.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookAndAuthor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    @ToString.Exclude
    private Book book;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    @ToString.Exclude
    private Author author;
}
