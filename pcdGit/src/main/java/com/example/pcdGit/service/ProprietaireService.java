package com.example.pcdGit.service;


import com.example.pcdGit.Repository.DogsRepo;
import com.example.pcdGit.Repository.ProprietaireRepo;
import com.example.pcdGit.modal.Dog;
import com.example.pcdGit.modal.Proprietaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietaireService {
@Autowired
ProprietaireRepo proprietaireRepo;
@Autowired
DogsRepo dogsRepo;
    public List<Proprietaire> getOwner() {
        return proprietaireRepo.findAll();
    }

    public String addOwner(Proprietaire proprietaire) {
        proprietaireRepo.save(proprietaire);
        return "success";
    }
    public ResponseEntity<String> deleteProprietaire(Long id) {
        Optional<Proprietaire> prop = proprietaireRepo.findById(id);
        if (prop.isPresent()) {
            Proprietaire propr =prop.get();
            for (Dog e:propr.getDog()){
                dogsRepo.delete(e);
            }
            proprietaireRepo.delete(propr);
            return ResponseEntity.ok("deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found id: " + id);
        }
    }

    public ResponseEntity<String> updatePrprietaire(Long id, Proprietaire proprietaire) {

        Optional<Proprietaire> prop = proprietaireRepo.findById(id);
        if (prop.isPresent()) {
            Proprietaire propr =prop.get();
            propr.setName(proprietaire.getName());
            propr.setPhone(proprietaire.getPhone());
            propr.setMail(proprietaire.getMail());
            proprietaireRepo.save(propr);
            return ResponseEntity.ok("Proprietaire updated successfully");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinaire not found with id: " + id);
        }
    }
}
