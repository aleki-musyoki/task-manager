package com.enigma.projectmicroservice.repositories;

import com.enigma.projectmicroservice.dtos.GetProjectDTO;
import com.enigma.projectmicroservice.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {

    public List<Project> findByProjectCode(String projectCode);

}
