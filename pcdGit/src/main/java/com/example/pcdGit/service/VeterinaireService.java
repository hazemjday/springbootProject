package com.example.pcdGit.service;


import com.example.pcdGit.Repository.RoleRepo;
import com.example.pcdGit.Repository.UserRepo;
import com.example.pcdGit.Repository.VeterinaireRepo;
import com.example.pcdGit.modal.User;
import com.example.pcdGit.modal.Veterinaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinaireService  {

    @Autowired
    UserRepo userRepo;
    @Autowired
    VeterinaireRepo veterinaireRepo;
    @Autowired
    RoleRepo roleRepo;
    public List<Veterinaire> getVeterinaire() {
        return veterinaireRepo.findAll();
    }


    public ResponseEntity<String> deleteVetrinaire(Long id) {
        Optional<Veterinaire> vet = veterinaireRepo.findById(id);
        if (vet.isPresent()) {
            Veterinaire veto=vet.get();
            veterinaireRepo.delete(veto);
            return ResponseEntity.ok("deleted successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found id: " + id);
        }
    }

    public String addVeterinaire(Veterinaire veterinaire) {

   veterinaireRepo.save(veterinaire);
   return "success";
    }

    public ResponseEntity<String> updateVeterinaire(Long id, Veterinaire veterinaire) {

        Optional<Veterinaire> vet = veterinaireRepo.findById(id);
        if (vet.isPresent()) {
           Veterinaire veto =vet.get();
            veto.setUsername(veto.getUsername());
            veto.setPhone(veto.getPhone());
            veto.setMail(veto.getMail());
            veto.setRegion(veto.getRegion());
            veto.setGender(veto.getGender());
            veto.setImageUrl(veto.getImageUrl());


            veterinaireRepo.save(veto);
            return ResponseEntity.ok("veterinaire updated successfully");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinaire not found with id: " + id);
        }
    }

    public String addAuth(User user) {
        userRepo.save(user);
        return "succes";
    }

    public String deleteAuth(Long id) {

        userRepo.deleteById(id);
        return "success";
    }

    public List<User> getAuth() {
        return userRepo.findAll();
    }

    public String updateAuth(Long id, User use){
        User user=userRepo.findById(id).get();
        user.setUsername(use.getUsername());
        user.setPassword(use.getPassword());
        user.setRoles(use.getRoles());
        return "success";
    }
}
