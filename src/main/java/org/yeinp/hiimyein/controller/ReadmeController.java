package org.yeinp.hiimyein.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yeinp.hiimyein.dto.FilesDto;
import org.yeinp.hiimyein.dto.ProjectDto;
import org.yeinp.hiimyein.dto.ReadmeDto;
import org.yeinp.hiimyein.mapper.ReadmeMapper;
import org.yeinp.hiimyein.service.ProjectService;
import org.yeinp.hiimyein.service.ReadmeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReadmeController {
    @Autowired
    ReadmeService readmeService;
    @Autowired
    ProjectService projectService;

    @Autowired
    ReadmeMapper readmeMapper;

    @GetMapping("/readme/{projectitle}")
    @ResponseBody
    public ReadmeDto getReadme(@PathVariable String projectitle, Model model) {
        ReadmeDto readme = readmeService.getReadMe(projectitle);
        return readme;
    }

    @GetMapping("/upload/readme/{projectitle}")
    public String uploadReadme(@ModelAttribute ReadmeDto readmeDto, @PathVariable String projectitle, Model model){
        ReadmeDto readme = readmeService.getReadMe(projectitle);
        model.addAttribute("readme", readme);

        return "page/modifyReadme";
    }

    @PostMapping("/modify/readme/{id}")
    public String modifyProjectPost(@ModelAttribute ReadmeDto readmeDto){

        readmeMapper.updateReadme(readmeDto);
        return "redirect:/";
    }






}
