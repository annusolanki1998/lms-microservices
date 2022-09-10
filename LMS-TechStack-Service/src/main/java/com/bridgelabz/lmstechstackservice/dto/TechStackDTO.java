package com.bridgelabz.lmstechstackservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/*
 * Purpose : TechStackDTO are used to create and update techStack details
 * Version : 1.0
 * @author : Annu Kumari
 * */

@Data
public class TechStackDTO {
    @NotNull(message = "Image path should not be empty ")
    private String imagePath;

    @NotNull(message = "Status should not be empty ")
    private String status;

    @NotNull(message = "TechName should not be empty ")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid tech name")
    private String techName;

    @NotNull(message = "Email id should not be empty")
    @Pattern(regexp = "[a-z][A-Z a-z 0-9]+[@][a-z]+[.][a-z]{2,}", message = "Invalid email id")
    private String email;

}
