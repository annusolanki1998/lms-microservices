package com.bridgelabz.lmstechstackservice.repository;

import com.bridgelabz.lmstechstackservice.model.TechStackModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose: Creating repository for techStack
 *
 * @author: Annu Kumari
 * @Param: To save in database
 * Version: 1.0
 */

public interface TechStackRepository extends JpaRepository<TechStackModel, Long> {
}
