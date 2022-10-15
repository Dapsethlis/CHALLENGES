package com.boats.repository;


import com.boats.model.AdminModel;
import com.boats.repository.crudrepository.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<AdminModel> getAllUserAdministrators() {
        return (List<AdminModel>) adminCrudRepository.findAll();
    }

    public Optional<AdminModel> getUserAdministrator(Integer id) {
        return adminCrudRepository.findById(id);
    }

    public AdminModel saveUserAdministrator(AdminModel adminModel) {
        return adminCrudRepository.save(adminModel);
    }

    public boolean deleteUserAdministrator(Integer id) {
        try {
            adminCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public AdminModel updateUserAdministrator(AdminModel adminModel) {
        if (adminModel.getId() != null) {
            Optional<AdminModel> admin = adminCrudRepository.findById(adminModel.getId());
            if (!admin.isEmpty()) {
                if (adminModel.getName() != null) {
                    admin.get().setName(adminModel.getName());
                }
                if (adminModel.getEmail() != null) {
                    admin.get().setEmail(adminModel.getEmail());
                }
                if (adminModel.getPassword() != null) {
                    admin.get().setPassword(adminModel.getPassword());
                }
                adminCrudRepository.save(admin.get());
                return admin.get();
            } else {
                return adminModel;
            }
        } else {
            return adminModel;
        }
    }
}
