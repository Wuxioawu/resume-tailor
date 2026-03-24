package com.resume.tailor.model;

import lombok.Data;

@Data
public class TailorRequest {
    private String originalResume; // the text of resume for user input
    private String jobDescription; // the job description
}