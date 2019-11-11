package com.example.demo.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.model.StudentCSV;


@Component
public class Processor implements ItemProcessor<StudentCSV, StudentCSV> {

   

    public Processor() {
       
    }

    @Override
    public StudentCSV process(StudentCSV user) throws Exception {
    	String str=user.getFirst();
    	
        user.setFirst(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
        str=user.getLast();
        user.setLast(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
        
        return user;
    }
}
