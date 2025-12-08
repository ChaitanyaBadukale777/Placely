package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobportal.model.Job;
import com.jobportal.repository.JobRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "*")
public class JobController {

    @Autowired
    private JobRepository jobRepo;

    // ✅ ADMIN: ADD JOB
    @PostMapping("/add")
    public Job addJob(@RequestBody Job job) {
        return jobRepo.save(job);
    }

    // ✅ USER: VIEW ALL JOBS
    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    // ✅ USER: VIEW SINGLE JOB BY ID
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobRepo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        jobRepo.deleteById(id);
        return ResponseEntity.ok("Job deleted");
    }


}
