package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.details.StudentDetails;
import com.student.service.StudentService;

@RestController
public class Mycontroller {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/index")
	public List<StudentDetails> getDetails()
	{
	    return	this.studentService.getDetails();
	}
	

	// post method
	@PostMapping("/add")
	public StudentDetails addStudentDetails(@RequestBody StudentDetails details)
	{
		return this.studentService.addStudentDetails(details);
	}
	
	// single student details
	@GetMapping("/index/{id}")
	public StudentDetails getStudent(@PathVariable String id)
	{
		return this.studentService.getStudent(Long.parseLong(id));
	}
	
	
	
	// put request 
	@PutMapping("/index/{id}")
	public StudentDetails updateDetails(@RequestBody StudentDetails details)
	
	{ 
		return this.studentService.updateDetails(details);
	}
	
	// delete method
	
	@DeleteMapping("/index/{Id}")
	public ResponseEntity<HttpStatus> deleteDetails(@PathVariable String Id){
		try {
			this.studentService.deleteDetails(Long.parseLong(Id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
