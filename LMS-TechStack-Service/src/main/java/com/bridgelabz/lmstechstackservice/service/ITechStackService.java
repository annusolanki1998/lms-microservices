package com.bridgelabz.lmstechstackservice.service;

import com.bridgelabz.lmstechstackservice.dto.TechStackDTO;
import com.bridgelabz.lmstechstackservice.model.TechStackModel;
import com.bridgelabz.lmstechstackservice.util.ResponseUtil;

import java.util.List;

/**
 * Purpose: Creating Interface for techStack service
 *
 * @author: Annu Kumari
 * @Param: All service methods
 * Version: 1.0
 */
public interface ITechStackService {

    ResponseUtil addTechStack(TechStackDTO techStackDTO, String token);

    ResponseUtil updateTechStack(TechStackDTO techStackDTO, String token, Long id);

    List<TechStackModel> getTechStacks(String token);

    ResponseUtil deleteTechStack(String token, Long id);

    ResponseUtil getTechStack(String token, Long id);
}
