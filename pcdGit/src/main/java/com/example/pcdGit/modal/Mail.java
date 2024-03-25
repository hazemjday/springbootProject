package com.example.pcdGit.modal;

import lombok.Data;

import java.util.List;

@Data
public class Mail {
    private String subject;
    private String message;
    private List<String> emails;

}
