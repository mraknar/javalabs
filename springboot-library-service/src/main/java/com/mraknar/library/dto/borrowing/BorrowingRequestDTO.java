package com.mraknar.library.dto.borrowing;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @Positive(message = "User ID must be positive number")
    private Long userId;

    @Positive(message = "Book ID must be positive number")
    private Long bookId;

    @NotNull(message = "Borrow date can't be null")
    @FutureOrPresent(message = "Borrow date must be future or present")
    private Date borrowDate;

    @NotNull(message = "Return date can't be null")
    @Future(message = "Return date must be future")
    private Date returnDate;
}
