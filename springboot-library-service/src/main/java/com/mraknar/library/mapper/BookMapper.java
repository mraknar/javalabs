package com.mraknar.library.mapper;

import com.mraknar.library.dto.book.BookRequestDTO;
import com.mraknar.library.dto.book.BookResponseDTO;
import com.mraknar.library.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponseDTO toDTO(Book book);

    Book toEntity(BookRequestDTO book);

    List<BookResponseDTO> toDTO(List<Book> books);
}
