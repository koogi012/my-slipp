package net.slipp.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.slipp.domain.Question;
import net.slipp.domain.QuestionRepository;
import net.slipp.domain.User;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	QuestionRepository	questionRepository;

	@GetMapping("/form")
	public String form(HttpSession session) {
		
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		return "/qna/form";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable Long id, Model model ) {
		
		model.addAttribute("question", questionRepository.findOne(id));
		
		return "/qna/show";
	}

	@PostMapping("")
	public String create(String title, String contents, HttpSession session) {
		
		if (!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}

		User sessionedUser = HttpSessionUtils.getUserFromSession(session);
		Question newQuestion = new Question(sessionedUser, title, contents );
		
		questionRepository.save(newQuestion);		
		
		return "redirect:/";
	}

}
