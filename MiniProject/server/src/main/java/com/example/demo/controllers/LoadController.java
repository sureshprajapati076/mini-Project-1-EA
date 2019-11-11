package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.ResponseBody;
import com.example.demo.model.StudentCSV;
import com.example.demo.repository.StudentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class LoadController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;
    
    @Autowired
    StudentRepository userRepo;    

    @GetMapping(value="/load",produces="application/json")
    public ResponseBody load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

    	if(userRepo.findAll().isEmpty()) {
        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("JobExecution: " + jobExecution.getStatus());


        return new ResponseBody(jobExecution.getStatus().toString());
    	}else
    	{
    		return new ResponseBody("Batch Job Already Performed Before");
    	}
    }
    @GetMapping("/listall")
    public List<StudentDTO> show() {
    	return userRepo.findAll();
    }
    @GetMapping(value="/public",produces="application/json")
    public ResponseBody publicFun() {
    	 
    	return new ResponseBody("This Page is accessible for all public");
    }
}
