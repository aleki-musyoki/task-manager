package com.enigma.projectmicroservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@Document(value = "projects")
public class Project {

    @Id
    private long Id;
    private String projectCode;
    private String projectName;
    private Date dateAssigned;
    private Date dueDate;
    private String reportingTo;
    private Object tasks;
}
