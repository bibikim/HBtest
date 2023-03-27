package com.khb.pay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.khb.pay.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/course/list", produces="application/json")
	public String list(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		courseService.getCourseList(model);
		return "course/list";
	}
	
	@GetMapping("/course/write")
	public String write() {
		return "course/write";
	}
	
	@PostMapping("/course/add")
	public void add(MultipartHttpServletRequest multiRequest, HttpServletResponse response) {
		courseService.saveCourse(multiRequest, response);
	}
	
	@ResponseBody
	@GetMapping("/course/display")
	public ResponseEntity<byte[]> display(@RequestParam int courseNo) {
		return courseService.displayThumbnail(courseNo);
	}
	
	//@GetMapping(value="/courses/page/{page}", produces="application/json")
	//public Map<K, V>
}
