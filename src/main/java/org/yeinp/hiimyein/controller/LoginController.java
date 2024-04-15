package org.yeinp.hiimyein.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yeinp.hiimyein.dto.UserDto;
import org.yeinp.hiimyein.entity.User;
import org.yeinp.hiimyein.service.UserService;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "page/login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String userid, @RequestParam String password, HttpSession session, Model model) {
        UserDto userdto = userService.loginUser(userid, password);
        if (userdto != null) {
            session.setAttribute("user", userdto); // 세션에 사용자 정보 저장
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "page/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user"); // 세션에서 사용자 정보 삭제
        return "redirect:/login";
    }



}
