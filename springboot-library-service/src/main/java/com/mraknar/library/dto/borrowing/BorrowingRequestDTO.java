package com.mraknar.library.dto.borrowing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRequestDTO {

    private Long userId;

    private Long bookId;

    private Date borrowDate;

    private Date returnDate;
}
