package com.pretransfer.Pre_Transfer.Classes;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "students")
public class Student {
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private String major;
    private int creditsCompleted;
    private String status;
}
