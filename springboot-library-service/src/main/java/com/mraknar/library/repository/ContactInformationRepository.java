package com.mraknar.library.repository;

import com.mraknar.library.entity.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation,Long> {
}
