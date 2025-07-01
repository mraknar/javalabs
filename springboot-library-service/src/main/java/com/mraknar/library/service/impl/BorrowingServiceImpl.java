package com.mraknar.library.service.impl;

import com.mraknar.library.dto.borrowing.BorrowingRequestDTO;
import com.mraknar.library.dto.borrowing.BorrowingResponseDTO;
import com.mraknar.library.entity.Book;
import com.mraknar.library.entity.Borrowing;
import com.mraknar.library.entity.User;
import com.mraknar.library.exception.BookAlreadyBorrowedException;
import com.mraknar.library.exception.BookNotFoundException;
import com.mraknar.library.exception.UserNotFoundException;
import com.mraknar.library.mapper.BookMapper;
import com.mraknar.library.mapper.BorrowingMapper;
import com.mraknar.library.repository.BookRepository;
import com.mraknar.library.repository.BorrowingRepository;
import com.mraknar.library.repository.UserRepository;
import com.mraknar.library.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BorrowingRepository borrowingRepository;
    private final BorrowingMapper borrowingMapper;
    private final BookMapper bookMapper;

    @Autowired
    public BorrowingServiceImpl(UserRepository userRepository, BookRepository bookRepository, BorrowingRepository borrowingRepository, BorrowingMapper borrowingMapper, BookMapper bookMapper) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.borrowingRepository = borrowingRepository;
        this.borrowingMapper = borrowingMapper;
        this.bookMapper = bookMapper;
    }

    @Override
    public BorrowingResponseDTO createBorrowing(BorrowingRequestDTO dto){

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(dto.getUserId()));

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new BookNotFoundException(dto.getBookId()) );

        if(book.getStatus() == false){
            throw new BookAlreadyBorrowedException(dto.getBookId());
        }

        Borrowing borrowing = new Borrowing();
        borrowing.setUser(user);
        borrowing.setBook(book);
        borrowing.setBorrowDate(dto.getBorrowDate());
        borrowing.setReturnDate(dto.getReturnDate());

        book.setStatus(false);
        bookRepository.save(book);

        borrowingRepository.save(borrowing);


        return borrowingMapper.toDto(borrowing);
    }

    @Override
    public BorrowingResponseDTO returnBook(Long id) {
        Borrowing borrowing = borrowingRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        Book book = borrowing.getBook();
        book.setStatus(true);
        bookRepository.save(book);

        borrowingRepository.delete(borrowing);

        return borrowingMapper.toDto(borrowing);
    }
}
