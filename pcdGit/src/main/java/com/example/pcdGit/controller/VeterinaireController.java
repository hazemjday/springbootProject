package com.example.pcdGit.controller;




import com.example.pcdGit.modal.User;
import com.example.pcdGit.modal.Veterinaire;
import com.example.pcdGit.service.VeterinaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("veterinaire")

public class VeterinaireController {
    @Autowired
    VeterinaireService veterinaireService;


    @GetMapping("/all")
    public List<Veterinaire> getveteinaires(){
        return veterinaireService.getVeterinaire();
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteVaccinatin(@PathVariable Long id) {
        return veterinaireService.deleteVetrinaire(id);
    }


    @PostMapping("/add")
    public String addVeterinaire(@RequestBody Veterinaire veterinaire){
        return veterinaireService.addVeterinaire(veterinaire);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<String> updateProprietaire(@PathVariable Long id, @RequestBody Veterinaire veterinaire ) {
        return  veterinaireService.updateVeterinaire(id, veterinaire);

    }


    //add the login coordinates to the user
    @PostMapping("/addAuthentification")
    public String addAuth (@RequestBody User user){
        return veterinaireService.addAuth(user);
    }

    @DeleteMapping("/deleteAuthen/{id}")
    public String deleteAuth(@PathVariable Long id) {
        return veterinaireService.deleteAuth(id);
    }

    @GetMapping("/getAuth")
    public List<User> getAuth(){
        return veterinaireService.getAuth();
    }

    @PutMapping("/updateAuth/{id}")
    public String UpdateAuth(@PathVariable Long id, @RequestBody User use){
        return veterinaireService.updateAuth(id, use);
    }

}
