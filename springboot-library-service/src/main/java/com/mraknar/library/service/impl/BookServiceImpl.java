package com.mraknar.library.service.impl;

import com.mraknar.library.dto.book.BookRequestDTO;
import com.mraknar.library.dto.book.BookResponseDTO;
import com.mraknar.library.entity.Book;
import com.mraknar.library.mapper.BookMapper;
import com.mraknar.library.repository.BookRepository;
import com.mraknar.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookResponseDTO createBook(@RequestBody BookRequestDTO book){
        Book bookEntity = bookMapper.toEntity(book);

        if(bookEntity.getStatus() == null){
            bookEntity.setStatus(true);
        }

        return bookMapper.toDTO(bookRepository.save(bookEntity));
    }

    @Override
    public List<BookResponseDTO> getBooks(){
        return bookMapper.toDTO(bookRepository.findAll());
    }
}
