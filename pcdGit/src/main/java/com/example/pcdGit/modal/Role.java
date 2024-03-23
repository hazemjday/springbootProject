package com.example.pcdGit.modal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="role")
public class Role {
    @Id
    @Column

    Long id;
    String name;

}
