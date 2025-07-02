package com.mraknar.library.service;

import com.mraknar.library.dto.borrowing.BorrowingRequestDTO;
import com.mraknar.library.dto.borrowing.BorrowingResponseDTO;

public interface BorrowingService {

    BorrowingResponseDTO createBorrowing(BorrowingRequestDTO dto);

    BorrowingResponseDTO returnBook(Long id);
}
