package com.bridgelabz.lmstechstackservice.service;

import com.bridgelabz.lmstechstackservice.dto.TechStackDTO;
import com.bridgelabz.lmstechstackservice.exception.TechStackNotFoundException;
import com.bridgelabz.lmstechstackservice.model.TechStackModel;
import com.bridgelabz.lmstechstackservice.repository.TechStackRepository;
import com.bridgelabz.lmstechstackservice.util.ResponseUtil;
import com.bridgelabz.lmstechstackservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Purpose: Creating service for techStack
 *
 * @author: Annu Kumari
 * @Param: business logic is present here
 * Version: 1.0
 */

@Service
public class TechStackService implements ITechStackService {
    @Autowired
    TechStackRepository techStackRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Autowired
    RestTemplate restTemplate;

    /**
     * Purpose: Creating method to add techStack details
     *
     * @author: Annu Kumari
     * @Param: techStackDto
     */

    @Override
    public ResponseUtil addTechStack(TechStackDTO techStackDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://EUREKA-ADMIN-CLIENT:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            TechStackModel techStackModel = new TechStackModel(techStackDTO);
            techStackModel.setCreationTimeStamp(LocalDateTime.now());
            techStackRepository.save(techStackModel);
            String body = "Tech stack is added successfully with techStackId " + techStackModel.getId();
            String subject = "Tech stack registration successfully";
            mailService.send(techStackModel.getEmail(), subject, body);
            return new ResponseUtil(200, "Sucessfully", techStackModel);
        }
        throw new TechStackNotFoundException(400, "Token is wrong");
    }

    /**
     * Purpose: Creating method to update existing techStack details
     *
     * @author: Annu Kumari
     * @Param: techStackDto, id and token
     */

    @Override
    public ResponseUtil updateTechStack(TechStackDTO techStackDTO, String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://EUREKA-ADMIN-CLIENT:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<TechStackModel> isTechStackPresent = techStackRepository.findById(id);
            if (isTechStackPresent.isPresent()) {
                isTechStackPresent.get().setImagePath(techStackDTO.getImagePath());
                isTechStackPresent.get().setStatus(techStackDTO.getStatus());
                isTechStackPresent.get().setTechName(techStackDTO.getTechName());
                isTechStackPresent.get().setEmail(techStackDTO.getEmail());
                isTechStackPresent.get().setUpdatedTimeStamp(LocalDateTime.now());
                techStackRepository.save(isTechStackPresent.get());
                String body = "Tech stack is added successfully with bankId " + isTechStackPresent.get().getId();
                String subject = "Tech stack registration successfully";
                mailService.send(isTechStackPresent.get().getEmail(), subject, body);
                return new ResponseUtil(200, "Sucessfully", isTechStackPresent.get());
            } else {
                throw new TechStackNotFoundException(400, "Tech stack not found");
            }
        }
        throw new TechStackNotFoundException(400, "Token is wrong");
    }

    /**
     * Purpose: Creating method to get techStack details
     *
     * @author: Annu Kumari
     * @Param: token
     */


    @Override
    public List<TechStackModel> getTechStacks(String token) {
        boolean isUserPresent = restTemplate.getForObject("http://EUREKA-ADMIN-CLIENT:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            List<TechStackModel> isTechStackPresent = techStackRepository.findAll();
            if (isTechStackPresent.size() > 0) {
                return isTechStackPresent;
            } else {
                throw new TechStackNotFoundException(400, "Tech stack is not found");
            }
        }
        throw new TechStackNotFoundException(400, "Token is wrong");
    }

    /**
     * Purpose: Creating method to delete existing techStack details
     *
     * @author: Annu Kumari
     * @Param: id and token
     */


    @Override
    public ResponseUtil deleteTechStack(String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://EUREKA-ADMIN-CLIENT:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<TechStackModel> isTechStackPresent = techStackRepository.findById(id);
            if (isTechStackPresent.isPresent()) {
                techStackRepository.delete(isTechStackPresent.get());
                return new ResponseUtil(200, "Sucessfully", isTechStackPresent.get());

            } else {
                throw new TechStackNotFoundException(400, "Tech stack not found");
            }
        }
        throw new TechStackNotFoundException(400, "Token is wrong");
    }

    /**
     * Purpose: Creating method to get techStack details
     *
     * @author: Annu Kumari
     * @Param: id and token
     */


    @Override
    public ResponseUtil getTechStack(String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://EUREKA-ADMIN-CLIENT:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<TechStackModel> isTechStackPresent = techStackRepository.findById(id);
            if (isTechStackPresent.isPresent()) {
                return new ResponseUtil(200, "Sucessfully", isTechStackPresent.get());
            } else {
                throw new TechStackNotFoundException(400, "Tech stack not found");
            }
        }
        throw new TechStackNotFoundException(400, "Token is wrong");
    }
}

