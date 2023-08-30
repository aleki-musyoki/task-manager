package com.enigma.projectmicroservice.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@Builder
public class GetProjectDTO {
    @Id
    private long Id;
    private String projectCode;
    private String projectName;
    private Date dateAssigned;
    private Date dueDate;
    private String reportingTo;
    private Object tasks;
}
