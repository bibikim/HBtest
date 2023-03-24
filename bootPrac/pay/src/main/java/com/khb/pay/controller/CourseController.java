package com.khb.pay.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khb.pay.service.CourseService;

@Controller
@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	/*
	 * @GetMapping("/course/list") public String list()
	 */
	
	//@GetMapping(value="/courses/page/{page}", produces="application/json")
	//public Map<K, V>
}
