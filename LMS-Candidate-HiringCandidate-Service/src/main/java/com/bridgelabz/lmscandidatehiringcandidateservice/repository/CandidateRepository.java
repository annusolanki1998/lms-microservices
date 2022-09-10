package com.bridgelabz.lmscandidatehiringcandidateservice.repository;

import com.bridgelabz.lmscandidatehiringcandidateservice.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Purpose: Creating repository for candidate
 * @author: Annu Kumari
 * @Param:  To save in database
 * Version: 1.0
 */

public interface CandidateRepository extends JpaRepository<CandidateModel, Long> {
    @Query(value = "select count(status) from candidate  where status=:isStatus", nativeQuery = true)
    Long getCountByStatus(@Param("isStatus") String status);
}
