package com.example.pcdGit.modal;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String region;


    @ManyToMany
    private List<Proprietaire> proprietaire =new ArrayList<>();



    @ManyToMany
    private List<Veterinaire> veterinaire =new ArrayList<>();
}


