package com.example.demo.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class StudentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first;
    private String last;
    private Double gpa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

   

    public StudentDTO(Integer id,String first, String last, Double gpa, LocalDate dob) {
		super();
		this.id=id;
		this.first = first;
		this.last = last;
		this.gpa = gpa;
		this.dob = dob;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public StudentDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
}
