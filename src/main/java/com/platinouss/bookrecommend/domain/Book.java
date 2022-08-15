package com.platinouss.bookrecommend.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    @OneToMany(mappedBy = "book")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "book_review_info_id")
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

    @OneToMany(mappedBy = "book")
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @ToString.Exclude
    private Publisher publisher;
}