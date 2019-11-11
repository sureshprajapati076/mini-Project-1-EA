package com.example.demo.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.StudentCSV;
import com.example.demo.repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Component
public class DBWriter implements ItemWriter<StudentCSV> {

    @Autowired
    private StudentRepository userRepository;

    @Override
    public void write(List<? extends StudentCSV> students) throws Exception {

        System.out.println("Data Saved for Users: " + students);
       
        
        for(int i=0;i<students.size();i++) {
        	StudentDTO u1=new StudentDTO(i,students.get(i).getFirst(),students.get(i).getLast(),students.get(i).getGpa(),LocalDate.of(LocalDate.now().getYear()-students.get(i).getAge(), 01, 01));
        	userRepository.save(u1);
        }
        
        
    }
}
