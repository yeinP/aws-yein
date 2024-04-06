package org.yeinp.hiimyein.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yeinp.hiimyein.dto.*;
import org.yeinp.hiimyein.entity.User;
import org.yeinp.hiimyein.mapper.AboutmeMapper;
import org.yeinp.hiimyein.repository.SkillRepository;
import org.yeinp.hiimyein.service.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    SkillService skillService;
    @Autowired
    ProjectService projectService;
    @Autowired
    AwsService awsService;
    @Autowired
    ReadmeService readmeService;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    AboutmeMapper aboutmeMapper;
    @GetMapping("/")
    public String home(Model model, HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute("user");
        if(userDto != null){
            model.addAttribute("userid", userDto.getUserid());
        }
        model.addAttribute("aboutMe", userService.getAboutMe("박예인"));
        model.addAttribute("backendSkill", skillService.listSkill("backend"));
        model.addAttribute("frontendSkill", skillService.listSkill("frontend"));
        model.addAttribute("dbSkill", skillService.listSkill("db"));
        model.addAttribute("serverSkill", skillService.listSkill("server"));
        model.addAttribute("toolSkill", skillService.listSkill("tool"));
        model.addAttribute("documentSkill", skillService.listSkill("document"));
        model.addAttribute("project", projectService.getProjectList());

        return "/page/home";
    }

    @GetMapping("/modify/aboutme")
    public String modifyAboutMe(Model model){
        model.addAttribute("aboutMe", userService.getAboutMe("박예인"));
        return "/page/aboutme";
    }

    @PostMapping("/modify/aboutme/{id}")
    public String modifyAboutMePost(@ModelAttribute MeDto meDto,@RequestPart(value = "file") MultipartFile multipartFiles){
        FilesDto s3FileDtoList = awsService.uploadPortUrl(multipartFiles);
        String fileUrl =  s3FileDtoList.getFileUrl();
        meDto.setPortfolio(fileUrl);
        aboutmeMapper.updateAboutMe(meDto);
        return "redirect:/";
    }


    @PostMapping("/insert/skill")
    public String insertSkill(@ModelAttribute SkillDto skillDto){
        skillService.insertSkill(skillDto);
        return "redirect:/";
    }

    @PostMapping("/delete/skill/{id}")
    public String deleteSkill(@PathVariable String id){
        skillRepository.deleteById(id);
        return "redirect:/";
    }

}
