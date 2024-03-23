package com.example.pcdGit.Repository;


import com.example.pcdGit.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    public  User findByUsername(String username);
}

