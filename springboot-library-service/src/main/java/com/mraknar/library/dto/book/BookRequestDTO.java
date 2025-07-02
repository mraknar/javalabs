package com.mraknar.library.dto.book;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {

    @NotBlank(message = "Title can't be empty")
    @Size(min = 3, max = 50, message = "Title length must be between 3-50")
    private String title;

    @NotBlank(message = "Author can't be empty")
    @Size(min = 3, max = 50, message = "Author length must be between 3-50")
    private String author;

    @NotBlank(message = "ISBN can't be empty")
    @Size(min = 3, max = 20, message = "ISBN length must be between 3-20")
    private String isbn;

    @NotBlank(message = "Publisher can't be empty")
    @Size(min = 3, max = 50, message = "Publisher length must be between 3-50")
    private String publisher;

    private Boolean status;

}
