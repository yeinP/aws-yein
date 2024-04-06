package org.yeinp.hiimyein.service;

import org.yeinp.hiimyein.dto.ProjectDto;
import org.yeinp.hiimyein.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    int uploadProject(ProjectDto projectDto);

    List<ProjectDto> getProjectList();

    ProjectDto getProjectById(String projectId);

    default ProjectDto entityToProjectDto(Project project){
        return ProjectDto.builder().id(project.getId())
                .title(project.getTitle())
                .sumup(project.getSumup())
                .content(project.getContent())
                .function(project.getFunction())
                .giturl(project.getGiturl())
                .backend(project.getBackend())
                .frontend(project.getFrontend())
                .db(project.getDb())
                .ide(project.getIde())
                .deployment(project.getDeployment())
                .role(project.getRole())
                .server(project.getServer())
                .imageURLs(project.getImageURLs()).regdate(project.getRegdate())
                .build();
    }
}
