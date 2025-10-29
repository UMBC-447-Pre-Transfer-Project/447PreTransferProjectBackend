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
    private String major;
    private int creditsCompleted;
    private String status;
    private String email;
    //We need to change frontend to send array of classes taken
    private String classesTaken;
    private String previousCollege;
    private String additionalComments;
    private String committed;
}
