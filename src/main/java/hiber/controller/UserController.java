package hiber.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin/users")
    public String listUsers(Model model ) {
        model.addAttribute("listUsers", userService.listUsers());
        return "user";
    }

    @GetMapping("/admin/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute(user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/one_user")
    public String getMainUser(Model model, Principal principal) {
        System.out.println(principal.getName());
        model.addAttribute("one_user",userService.getUserByEmail(principal.getName()));
        //model.addAttribute("one_user",userService.getUserByEmail(((User) authentication.getPrincipal()).getEmail()));
        return "one_user";
    }
}
