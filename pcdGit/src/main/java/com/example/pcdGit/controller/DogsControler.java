package com.example.pcdGit.controller;


import com.example.pcdGit.modal.Dog;
import com.example.pcdGit.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
@RestController
@RequestMapping("dogs")
public class DogsControler {
@Autowired
DogsService dogsService;

//get al the dogs that exists
    @GetMapping("/all")
    public List<Dog> getDogs(){
        return dogsService.getDogs();
    }


    //delete a dog by his id

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteDog(@PathVariable Long id) {
        return dogsService.deleteDog(id);
    }

//add a dog
    @PostMapping("/add")
    public String addDog(@RequestBody Dog dog){
        return dogsService.addDog(dog);
    }


    //update nformations about a dog
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDog(@PathVariable Long id, @RequestBody Dog dog) {
        return  dogsService.updateDog(id, dog);}


    //get the age of te dog starting from the birthday
    @GetMapping("dogAge/{id}")
    public String calculateAge(@PathVariable Long id) {
        return dogsService.getage(id);
    }

    // when he click on a button vaccin this will automatically update the date of the birth of the dog
@PutMapping("dogVaccination/{idDog}")
public  String setDogVaccination(@PathVariable Long idDog,@RequestBody LocalDate latestDate){
       return dogsService.setDogVaccination(idDog, latestDate);
}

//if the dog is vaccinated it will return true
    @GetMapping("checkDog/{idDog}")
    public Boolean dogVaccinated(@PathVariable Long idDog){
        return dogsService.dogVaccinated(idDog);
    }
}
