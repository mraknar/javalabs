package com.mraknar.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false,  length = 50)
    private String title;

    @Column(name = "author", nullable = false,  length = 50)
    private String author;

    @Column(name = "isbn", nullable = false,  length = 15)
    private String isbn;

    @Column(name = "publisher", nullable = false,  length = 30)
    private String publisher;

    private Boolean status;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Borrowing> borrowings;

}
