package com.enigma.projectmicroservice.service;

import com.enigma.projectmicroservice.dtos.CreateProjectDTO;
import com.enigma.projectmicroservice.dtos.EditProjectDTO;
import com.enigma.projectmicroservice.model.Project;
import com.enigma.projectmicroservice.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public String createProjects(CreateProjectDTO createProjectDTO) {
        projectRepository.save(createMapper(createProjectDTO));
        log.debug("Project Created Successfully");
        return "Successfully created a project";
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Object getProjectByCode(String projectCode){

        if(projectRepository.findByProjectCode(projectCode).isEmpty()){
            return "Not available";
        }
        return new ArrayList<>(projectRepository.findByProjectCode(projectCode));
    }

    public Object editProjectDetails(String projectCode, EditProjectDTO editProjectDTO){
        List<Project> optional = projectRepository.findByProjectCode(projectCode);

        if(optional.isEmpty()){
            return "Project Not Found";
        }

        return null;
    }

    private Project createMapper(CreateProjectDTO createProjectDTO) {
        log.debug("Mapping Project DTO to Model");
        return Project.builder()
                .projectCode(createProjectDTO.getProjectCode())
                .projectName(createProjectDTO.getProjectName())
                .dateAssigned(createProjectDTO.getDateAssigned())
                .dueDate(createProjectDTO.getDueDate())
                .reportingTo(createProjectDTO.getReportingTo())
                .build();
    }

}
