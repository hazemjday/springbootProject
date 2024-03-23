package com.example.pcdGit.service;


import com.example.pcdGit.Repository.DogsRepo;
import com.example.pcdGit.modal.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class DogsService {

    @Autowired
    DogsRepo dogsRepo;

    public List<Dog> getDogs() {
     return dogsRepo.findAll();
    }

    public String addDog(Dog dog) {
    dogsRepo.save(dog);
   return "success";
    }

    public ResponseEntity<String> deleteDog(Long id) {
        Optional<Dog> dog = dogsRepo.findById(id);
        if (dog.isPresent()) {
            Dog doggie=dog.get();
            dogsRepo.delete(doggie);
            return ResponseEntity.ok("deleted successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found id: " + id);
        }

    }

    public ResponseEntity<String> updateDog(Long id, Dog dog) {
        Optional<Dog> doggie = dogsRepo.findById(id);
        if (doggie.isPresent()) {
            Dog doggo =doggie.get();
            doggo.setImageUrl(dog.getImageUrl());
            doggo.setRace(dog.getRace());
            doggo.setBirthdate(dog.getBirthdate());
            doggo.setWeight(dog.getWeight());
            doggo.setConfinement(dog.getConfinement());
            doggo.setUtilisation(dog.getUtilisation());
            doggo.setSexe(dog.getSexe());
            doggo.setCouleur(dog.getCouleur());
            doggo.setOrigine(dog.getOrigine());
            dogsRepo.save(doggo);
            return ResponseEntity.ok("dog updated successfully");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veterinaire not found with id: " + id);
        }
    }

    public String getage(Long id) {
        Optional<Dog> dog = dogsRepo.findById(id);
        Dog doggie= dog.get();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(doggie.getBirthdate(), currentDate);
        return (period.getYears()+ " ans et "+period.getMonths()+" mois");
    }

    public String setDogVaccination( Long id,  LocalDate latestDate) {
        Optional<Dog> dog = dogsRepo.findById(id);
        Dog doggie= dog.get();
        doggie.setLatestVaccinationDate(latestDate);
        dogsRepo.save(doggie);
        return "success";

    }


    public Boolean dogVaccinated(Long id) {
        Optional<Dog> dog = dogsRepo.findById(id);
        Dog doggie= dog.get();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(doggie.getLatestVaccinationDate(), currentDate);
        if(period.getYears()>=1 ){
            return false;
        }
        else {
            return true;
        }
    }
}
