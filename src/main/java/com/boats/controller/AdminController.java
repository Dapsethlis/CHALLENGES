package com.boats.controller;

import com.boats.model.AdminModel;
import com.boats.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    @PostMapping("/all")
    public List<AdminModel> getAllUserAdministrators() {
        return (List<AdminModel>) adminService.getAllUserAdministrators();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<AdminModel> getAllUserAdministrators2() {
        return (List<AdminModel>) adminService.getAllUserAdministrators();
    }

    @GetMapping("{id}")
    public Optional<AdminModel> getUserAdministrator(@PathVariable Integer id) {
        return adminService.getUserAdministrator(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel saveUserAdministrator(@RequestBody AdminModel adminModel) {
        return adminService.saveUserAdministrator(adminModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUserAdministratorModel(@PathVariable Integer id) {
        adminService.deleteUserAdministrator(id);
        return true;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel updateUserAdministrator(@RequestBody AdminModel adminModel) {
        return adminService.updateUserAdministrator(adminModel);
    }
}
