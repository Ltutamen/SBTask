package ua.axiom.taskSB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @RequestMapping("/")
    public String mainPageMapping() {
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/users")
    public String usersListMapping() {
        return "users-list";
    }

    @RequestMapping("/def-page")
    public String defaultUserPage() {
        return "user-page";
    }


}

