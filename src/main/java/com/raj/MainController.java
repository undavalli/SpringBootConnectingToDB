package com.raj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raj.StudentRepository;

@Controller
@RequestMapping(path="/demo")
public class MainController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewStudentDetails( @RequestParam String first_name,
			@RequestParam String last_name, @RequestParam int roll_number,@RequestParam String email){
		
		StudentDetails sd= new StudentDetails();
		sd.setFirst_name(first_name);
		sd.setLast_name(last_name);
		sd.setEmail(email);
		sd.setRoll_number(roll_number);
		studentRepository.save(sd);
		return "saved";
		
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<StudentDetails> getAllStudentDetails(){
		return studentRepository.findAll();
	}
	

}
