package com.resume.tailor.controller;

import com.resume.tailor.model.TailorRequest;
import com.resume.tailor.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "*") // 允许跨域
public class TailorController {

    @Autowired
    private TailorService tailorService;

    @PostMapping("/tailor")
    public String tailorResume(@RequestBody TailorRequest request) {
        return tailorService.tailor(request);
    }
}
