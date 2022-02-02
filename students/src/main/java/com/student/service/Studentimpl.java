package com.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.details.StudentDetails;

@Service
public class Studentimpl implements StudentService {
	
	List<StudentDetails> list;
	
	public Studentimpl()
	{
		list = new ArrayList<>();
		list.add(new StudentDetails(001, "om gupta"));
		list.add(new StudentDetails(002, "Rajesh kumar"));
		list.add(new StudentDetails(003, "Rishikesh kumar"));
	}

	@Override
	public List<StudentDetails> getDetails() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public StudentDetails addStudentDetails(StudentDetails details) {
		// TODO Auto-generated method stub
		
		list.add(details);
		return details;
	}

	public StudentDetails getStudent(long id) {
		// TODO Auto-generated method stub
		StudentDetails  Id= null;
		for(StudentDetails itemDetails : list)
		{
			if(itemDetails.getStudent_Id() == id)
			{
				Id = itemDetails;
				break;
			}
		}
		return Id;
	}

	@Override
	public StudentDetails updateDetails(StudentDetails details) {
		// TODO Auto-generated method stub
		list.forEach(e->{
			if(e.getStudent_Id() == details.getStudent_Id())
			{
				e.setStudent_Id(details.getStudent_Id());
				e.setStudent_Name(details.getStudent_Name());
				
			}
		});
		return details;
	}



	@Override
	public void deleteDetails(Long parLong) {
		// TODO Auto-generated method stub
		list = this.list.stream().filter(e->e.getStudent_Id()!=parLong).collect(Collectors.toList());
	}
	
	
	

}
