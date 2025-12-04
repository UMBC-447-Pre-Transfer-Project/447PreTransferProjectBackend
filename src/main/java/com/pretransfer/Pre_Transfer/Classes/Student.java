package com.pretransfer.Pre_Transfer.Classes;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String currentMajor;
    private int creditsCompleted;
    private String highSchoolStatus;
    private String email;
    //We need to change frontend to send array of classes taken
    private String intendedMajor;
    private String previousInstitution;
    private String meetingGoals;
    private String intendedSemester;
}
