package com.example.pcdGit.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    private String race;
    private LocalDate birthdate;
    private LocalDate latestVaccinationDate ;
    private Integer weight;
    private String Couleur;
    private String origine;
    private String confinement;
    private String utilisation;
    private String sexe;


    @ManyToOne
    @JoinColumn(name="proprietaire_id")
    @JsonBackReference
    private Proprietaire proprietaire;
}
