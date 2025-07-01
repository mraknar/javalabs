package com.mraknar.library.service;

import com.mraknar.library.dto.book.BookRequestDTO;
import com.mraknar.library.dto.book.BookResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {

    public BookResponseDTO createBook(@RequestBody BookRequestDTO book);

    public List<BookResponseDTO> getBooks();

}
