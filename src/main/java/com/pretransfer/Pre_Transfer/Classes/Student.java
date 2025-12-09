package com.pretransfer.Pre_Transfer.Classes;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String currentMajor;
    private int creditsCompleted;
    private String highSchoolStatus;
    //We need to change frontend to send array of classes taken
    private String intendedMajor;
    private String currentInstitution;
    private String meetingGoals;
    private String intendedSemester;
    private boolean mainCampus;
    private List<String> errors;
}
