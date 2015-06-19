package org.sambasoft.controller;

import org.sambasoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public String listUsers(Model model) {

		model.addAttribute("users", userService.findAll());

		return "users";

	}

}
