package cn.howieli.lol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/admin")
	public String login() {
		return "admin/login";
	}
	
	@GetMapping("/admin/index")
	public String index() {
		return "admin/index";
	}
	
}
