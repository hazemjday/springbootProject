package com.example.pcdGit.Repository;


import com.example.pcdGit.modal.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepo extends JpaRepository<Vaccination, Long> {

}
