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
public class BorrowingResponseDTO {

    private Long id;

    private Date returnDate;

    private Date borrowDate;
}
