package com.mraknar.library.service;

import com.mraknar.library.dto.borrowing.BorrowingRequestDTO;
import com.mraknar.library.dto.borrowing.BorrowingResponseDTO;

public interface BorrowingService {

    public BorrowingResponseDTO createBorrowing(BorrowingRequestDTO dto);

    public BorrowingResponseDTO returnBook(Long id);
}
