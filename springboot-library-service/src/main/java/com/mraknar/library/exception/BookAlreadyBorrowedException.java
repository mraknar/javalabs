package com.mraknar.library.exception;

public class BookAlreadyBorrowedException extends RuntimeException {
    public BookAlreadyBorrowedException(Long id) {
        super("Book already borrowed with ID: " + id);
    }
}
