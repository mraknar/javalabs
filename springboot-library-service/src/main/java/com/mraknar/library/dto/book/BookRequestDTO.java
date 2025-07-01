package com.mraknar.library.dto.book;


import com.mraknar.library.entity.Borrowing;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {

    private String title;

    private String author;

    private String isbn;

    private String publisher;

    private Boolean status;

}
