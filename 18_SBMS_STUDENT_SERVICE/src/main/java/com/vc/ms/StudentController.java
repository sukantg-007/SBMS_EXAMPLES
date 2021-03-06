package com.vc.ms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentRepo studentRepo;
	
	@PostMapping("/add")
	public String save(@RequestBody Student student) {
		Student s=studentRepo.save(student);
		String msg="";
		msg=(s==null)?"Student Insersion Failed":"Student Insersion Success";
		return msg;
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, @RequestBody Student st) {
		Student s=studentRepo.findById(id).orElse(null);
		String msg="Student Insersion Failed";
		if(!s.equals(null)) {
			s.setName(st.getName());
			s.setAddr(st.getAddr());
			s.setCourse(st.getCourse());
			msg="Student Insersion Success";
		}
		return msg;
	}
	
	@GetMapping("/get/{id}")
	public Student get(@PathVariable("id") Long id) {
		return studentRepo.findById(id).orElse(null);
	}
}
