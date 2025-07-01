package com.mraknar.library.controller;

import com.mraknar.library.dto.book.BookRequestDTO;
import com.mraknar.library.dto.book.BookResponseDTO;
import com.mraknar.library.entity.Book;
import com.mraknar.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public BookResponseDTO createBook(@RequestBody BookRequestDTO book) {
        return bookService.createBook(book);
    }

    @GetMapping("/books")
    public List<BookResponseDTO> getBooks(){
        return bookService.getBooks();
    }

}
