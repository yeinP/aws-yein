package org.yeinp.hiimyein.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yeinp.hiimyein.dto.FilesDto;
import org.yeinp.hiimyein.dto.MeDto;
import org.yeinp.hiimyein.dto.ProjectDto;
import org.yeinp.hiimyein.dto.ReadmeDto;
import org.yeinp.hiimyein.mapper.ProjectMapper;
import org.yeinp.hiimyein.repository.ProjectRepository;
import org.yeinp.hiimyein.repository.ReadmeRepository;
import org.yeinp.hiimyein.service.AwsService;
import org.yeinp.hiimyein.service.ProjectService;
import org.yeinp.hiimyein.service.ReadmeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProjectController {

    @Autowired
    AwsService awsService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ReadmeService readmeService;
    @Autowired
    ReadmeRepository readmeRepository;
    @GetMapping("/projectUpload")
    public String uploadProject(){
        return "page/projectUpload";
    }

    @PostMapping("/upload/project")
    public String uploadMissFile(@RequestPart(value = "files") List<MultipartFile> multipartFiles, @ModelAttribute ProjectDto projectDto, @ModelAttribute ReadmeDto readmeDto) {
        List<FilesDto> s3FileDtoList = awsService.uploadImageMiss(multipartFiles);
        List<String> imageURLs = new ArrayList<>();
        for (FilesDto fileDto : s3FileDtoList) {
            imageURLs.add(fileDto.getFileUrl());
        }
        projectDto.setImageURLs(imageURLs);
        int result = projectService.uploadProject(projectDto);

        int readme = readmeService.uploadReadme(projectDto);
        return "redirect:/";
    }

    @PostMapping("/delete/project/{id}/{title}")
    public String deleteProject(@PathVariable String id, @PathVariable String title, Model model){
        projectRepository.deleteById(id);
        readmeRepository.deleteByProjecttitle(title);
        return "redirect:/";
    }

    @GetMapping("/modify/project/{projectid}")
    public String modifyProject(@PathVariable String projectid, Model model) {
        ProjectDto projectDto = projectService.getProjectById(projectid);
        model.addAttribute("project", projectDto);
        return "/page/projectModify";
    }

    @PostMapping("/modify/project/{projectid}")
    public String modifyProjectPost(@ModelAttribute ProjectDto projectDto, @RequestPart(value = "files") List<MultipartFile> multipartFiles) {
        List<FilesDto> s3FileDtoList = awsService.uploadImageMiss(multipartFiles);
        List<String> imageURLs = new ArrayList<>();
        for (FilesDto fileDto : s3FileDtoList) {
            imageURLs.add(fileDto.getFileUrl());
        }
        projectDto.setImageURLs(imageURLs);
        projectMapper.updateProject(projectDto);
        return "redirect:/";
    }



}
