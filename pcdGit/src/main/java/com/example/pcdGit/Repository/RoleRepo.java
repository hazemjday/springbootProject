package com.example.pcdGit.Repository;


import com.example.pcdGit.modal.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
public Role findByName(String name);
}
