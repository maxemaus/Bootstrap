package CRUD.SpringBoot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import CRUD.SpringBoot.demo.model.Role;
import CRUD.SpringBoot.demo.model.User;
import CRUD.SpringBoot.demo.service.RoleService;
import CRUD.SpringBoot.demo.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminsController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminsController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsersList());
        model.addAttribute("user",new User());
        model.addAttribute("allRoles", roleService.getRolesList());
        return "users";
    }


    @PostMapping("/adduser")
    public String addUser(@Validated(User.class) @ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @PostMapping("update")
    public String editUser(@Validated(User.class) @ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

}
