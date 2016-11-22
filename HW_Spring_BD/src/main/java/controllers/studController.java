package controllers;

import models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.studentRepository;
import java.util.List;

@Controller
public class studController {

	@Autowired
	studentRepository studentRepository;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getAllStudents(ModelMap map){
		List<Student> students = studentRepository.getAll();
		map.addAttribute("students",students);
		return "index";
	}

	@RequestMapping(value = "/getSum", method = RequestMethod.GET)
	public String getSumPoints(ModelMap map, @RequestParam("id") int id) {
		Long sum = studentRepository.getSumPoints(id);
		map.addAttribute("sum", sum);
		return "index";
	}

	@RequestMapping(value = "/getAverage", method = RequestMethod.GET)
	public String getAveragePoints(ModelMap map, @RequestParam("id") int id) {
		Long aver=studentRepository.averagePoint(id);
		map.addAttribute("aver", aver);
		return "index";
	}

	@RequestMapping(value = "/getPointOfLesson", method = RequestMethod.GET)
	public String getPointOfLesson(ModelMap map, @RequestParam("id") int id, @RequestParam("lesson") String lesson) {
		Integer points=studentRepository.pointForLesson(id, lesson);
		map.addAttribute("points", points);
		return "index";
	}

}


