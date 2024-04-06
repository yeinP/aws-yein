package org.yeinp.hiimyein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeinp.hiimyein.dto.ProjectDto;
import org.yeinp.hiimyein.entity.Project;
import org.yeinp.hiimyein.repository.ProjectRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public int uploadProject(ProjectDto projectDto) {
        Date date = new Date();

        Project project = Project.builder()
                .id(projectDto.getId())
                .title(projectDto.getTitle())
                .sumup(projectDto.getSumup())
                .content(projectDto.getContent())
                .function(projectDto.getFunction())
                .giturl(projectDto.getGiturl())
                .backend(projectDto.getBackend())
                .frontend(projectDto.getFrontend())
                .db(projectDto.getDb())
                .ide(projectDto.getIde())
                .deployment(projectDto.getDeployment())
                .role(projectDto.getRole())
                .server(projectDto.getServer())
                .imageURLs(projectDto.getImageURLs())
                .regdate(date)
                .build();

        Project savedProject = projectRepository.save(project);
        return savedProject !=null?1:0;

    }

    @Override
    public List<ProjectDto> getProjectList() {
        List<Project> projectList = projectRepository.findAllByOrderByRegdateDesc();
        return projectList.stream().map(this::entityToProjectDto).collect(Collectors.toList());
    }

    @Override
    public ProjectDto getProjectById(String projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        return project.isPresent() ? entityToProjectDto(project.get()) : null;
    }


}
