package com.bridgelabz.lmstechstackservice.controller;

import com.bridgelabz.lmstechstackservice.dto.TechStackDTO;
import com.bridgelabz.lmstechstackservice.model.TechStackModel;
import com.bridgelabz.lmstechstackservice.service.ITechStackService;
import com.bridgelabz.lmstechstackservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/techstack")
public class TechStackController {
    @Autowired
    ITechStackService techStackService;

    /*
     * Purpose: Print welcome message
     * @author: Annu kumari
     * */

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to LMS Spring application project";
    }

    /*
     * Purpose: Create techStack details
     * @author: Annu Kumari
     * @Param: techStackDTO and token
     * */

    @PostMapping("/addtechstack")
    public ResponseEntity<ResponseUtil> addTechStack(@Valid @RequestBody TechStackDTO techStackDTO,
                                                     @RequestHeader String token) {
        ResponseUtil responseUtil = techStackService.addTechStack(techStackDTO, token);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }

    /*
     * Purpose: Update existing techStack details by using id
     * @author: Annu Kumari
     * @Param: id,techStackDTO,and token
     * */


    @PutMapping("/updatetechstack/{id}")
    public ResponseEntity<ResponseUtil> updateTechStack(@PathVariable Long id,
                                                        @Valid @RequestBody TechStackDTO techStackDTO,
                                                        @RequestHeader String token) {
        ResponseUtil responseUtil = techStackService.updateTechStack(techStackDTO, token, id);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }

    /*
     * Purpose: Retrieve all techStack details
     * @author: Annu Kumari
     * @Param: token
     * */

    @GetMapping("/gettechstacks")
    public ResponseEntity<List<?>> getTechStacks(@RequestHeader String token) {
        List<TechStackModel> responseUtil = techStackService.getTechStacks(token);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);

    }

    /*
     * Purpose: Delete existing techStack details by using id
     * @author: Annu Kumari
     * @Param: id and token
     * */


    @DeleteMapping("deletetechstack/{id}")
    public ResponseEntity<ResponseUtil> deleteTechStack(@PathVariable Long id,
                                                        @RequestHeader String token) {
        ResponseUtil responseUtil = techStackService.deleteTechStack(token, id);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }

    /*
     * Purpose: Retrieve existing techStack details by using id
     * @author: Annu Kumari
     * @Param: id and token
     * */
    @GetMapping("gettechstack/{id}")
    public ResponseEntity<ResponseUtil> getTechStack(@PathVariable Long id,
                                                     @RequestHeader String token) {
        ResponseUtil responseUtil = techStackService.getTechStack(token, id);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }

}
