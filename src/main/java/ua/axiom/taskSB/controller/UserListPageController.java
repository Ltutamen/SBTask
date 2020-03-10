package ua.axiom.taskSB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.axiom.taskSB.Entities.User;
import ua.axiom.taskSB.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Controller
public class UserListPageController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String mainPage(Map<String, Object> pageModel) {
        pageModel.put("name", "Your name!");
        return "index";
    }

    //  ADMIN ONLY data about users
    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String usersListPage(Map<String, Object> pageModel) {
        List<User> users = userRepository.findAll();
        pageModel.put("user-list", users);

        return "users-list";
    }

    /**
     * Accepts data from the 'submit' button on /users page
     * @param username
     * @param password
     * @param pageModel
     * @return
     */
    @PostMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String usersListPagePost(@RequestParam String username,
                                    @RequestParam String password,
                                    Map<String, Object> pageModel) {
        User newUser = new User(username, password, User.Role.USER);
        pageModel.put("user-list", userRepository.findAll());
        userRepository.save(newUser);
        return "users-list";
    }

    /*
    @GetMapping("/login")
    public String loginPage(Map<String, Object> model) {
        model.put("message", "");
        return "/login";
    }


    @PostMapping("/login")
    public String defUserPage(@RequestParam String username,
                              @RequestParam String password,
                              Map<String, Object> model) {
        User user = userRepository.findByUsername(username);

        if(user != null) {
            return "/def-page";
        }

        model.put("message", "User not found!");
        return "/login";
    }
    */
}
