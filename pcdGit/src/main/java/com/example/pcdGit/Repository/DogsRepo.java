package com.example.pcdGit.Repository;


import com.example.pcdGit.modal.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogsRepo extends JpaRepository<Dog,Long> {

}
