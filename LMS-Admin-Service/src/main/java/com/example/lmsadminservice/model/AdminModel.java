package com.example.lmsadminservice.model;

import com.example.lmsadminservice.dto.AdminDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
 * Purpose : AdminModel are used to transfer the data into database
 * Version : 1.0
 * @author : Annu Kumari
 * */

@Data
@Entity
@Table(name = "admin")
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private String profilePath;
    private String password;
    private String status;
    private LocalDateTime creatorStamp;
    private LocalDateTime updatedStamp;

    public AdminModel(AdminDTO adminDTO) {
        this.firstName = adminDTO.getFirstName();
        this.lastName = adminDTO.getLastName();
        this.mobileNumber = adminDTO.getMobileNumber();
        this.emailId = adminDTO.getEmailId();
        this.password = adminDTO.getPassword();
        this.status = adminDTO.getStatus();

    }

    public AdminModel() {

    }


}

