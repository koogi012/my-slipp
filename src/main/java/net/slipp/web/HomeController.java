package net.slipp.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.slipp.domain.QuestionRepository;

@Controller
public class HomeController {
	
	@Autowired
	private QuestionRepository	questionRepository;
	
	@GetMapping("/")
	public String home(Model model, HttpSession session ) {
		
		model.addAttribute("questions", questionRepository.findAll());
		
		return "index";
	}

}
