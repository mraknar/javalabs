package com.mraknar.library.controller;

import com.mraknar.library.dto.borrowing.BorrowingRequestDTO;
import com.mraknar.library.dto.borrowing.BorrowingResponseDTO;
import com.mraknar.library.service.BorrowingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api")
public class BorrowingController {

    private BorrowingService borrowingService;

    @Autowired
    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @PostMapping("/borrow")
    public ResponseEntity<BorrowingResponseDTO> createBorrowing(@RequestBody @Valid BorrowingRequestDTO dto) {
        return ResponseEntity.ok(borrowingService.createBorrowing(dto));
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<BorrowingResponseDTO> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(borrowingService.returnBook(id));
    }

}
