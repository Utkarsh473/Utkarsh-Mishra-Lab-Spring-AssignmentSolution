package com.greatlearning.StudentMgmtSpringboot.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.StudentMgmtSpringboot.Service.StudentService;
import com.greatlearning.StudentMgmtSpringboot.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService st;

	@RequestMapping("/readall")
	public String findall(Model m) {
		List<Student> s = st.readAll();

		m.addAttribute("Student_List", s);

		return "StudentList";
	}

	@GetMapping("/showFormForAdd")
	public String AddForm(Model m) {
		Student s = new Student();

		m.addAttribute("student", s);

		return "StudentForm";
	}

	@GetMapping("/showFormForUpdate")
	public String UpdateForm(@RequestParam("id") int id, Model m) {
		Student s = st.readById(id);

		m.addAttribute("student", s);

		return "StudentForm";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String deptt, @RequestParam("country") String country) {
		
		Student s;

		if (id != 0) {
			s = st.readById(id);
			s.setDepartment(deptt);
			s.setCountry(country);
			s.setName(name);
		}

		else {
			s = new Student(id,name, deptt, country);
		}
		
		st.save(s);

		return "redirect:/student/readall";
	}

	@RequestMapping(value = "/delete",method= {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE})
	public String delete(@RequestParam("id") int id) {
		st.delete(id);

		return "redirect:/student/readall";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;
	}
}
