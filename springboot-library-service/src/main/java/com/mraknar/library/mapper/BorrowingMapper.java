package com.mraknar.library.mapper;

import com.mraknar.library.dto.borrowing.BorrowingRequestDTO;
import com.mraknar.library.dto.borrowing.BorrowingResponseDTO;
import com.mraknar.library.entity.Borrowing;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowingMapper {
    Borrowing toEntity(BorrowingRequestDTO dto);

    BorrowingResponseDTO toDto(Borrowing borrowing);
}

