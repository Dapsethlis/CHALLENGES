package com.boats.service;
import com.boats.model.AdminModel;
import com.boats.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminModel> getAllUserAdministrators() {
        return (List<AdminModel>) adminRepository.getAllUserAdministrators();
    }

    public Optional<AdminModel> getUserAdministrator(Integer id) {
        return adminRepository.getUserAdministrator(id);
    }

    public AdminModel saveUserAdministrator(AdminModel adminModel) {
        return adminRepository.saveUserAdministrator(adminModel);
    }

    public boolean deleteUserAdministrator(Integer id) {
        adminRepository.deleteUserAdministrator(id);
        return true;
    }

    public AdminModel updateUserAdministrator(AdminModel adminModel) {
        return adminRepository.updateUserAdministrator(adminModel);
    }
}
