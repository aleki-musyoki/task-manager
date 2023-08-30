package com.enigma.projectmicroservice.controllers;

import com.enigma.projectmicroservice.dtos.AllProjectsDTO;
import com.enigma.projectmicroservice.dtos.CreateProjectDTO;
import com.enigma.projectmicroservice.dtos.EditProjectDTO;
import com.enigma.projectmicroservice.dtos.GetProjectDTO;
import com.enigma.projectmicroservice.model.Project;
import com.enigma.projectmicroservice.service.ProjectService;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProjectController {

    @Autowired
    private final ProjectService projectService;

    @PostMapping("/projects/")
    public String createProjects(@RequestBody CreateProjectDTO createProjectDTO) {
        return projectService.createProjects(createProjectDTO);
    }

    @GetMapping("/projects/")
    public Object getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/{projectCode}")
    public Object getProjectByCode(@PathVariable("projectCode") String projectCode) {
        return projectService.getProjectByCode(projectCode);
    }

    @PutMapping("/projects/{projectCode}")
    public Object editProjectDetails(@PathVariable("projectCode") String projectCode, @RequestBody EditProjectDTO editProjectDTO) {
        return projectService.editProjectDetails(projectCode, editProjectDTO);
    }

    @DeleteMapping("projects/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode) {
        return null;
    }

}
