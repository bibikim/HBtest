package com.khb.pay.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.khb.pay.domain.CourseDTO;
import com.khb.pay.domain.CourseImgDTO;

public interface CourseService {

	// 강의 목록
	public void getCourseList(Model model); 
	// 강의 상세
	public CourseDTO getCourseByNo(int courseNo);
	public CourseImgDTO getCourseImgByNo(int courseNo);
	
	// 썸네일 가져오기
	public ResponseEntity<byte[]> displayThumbnail(int courseNo);
	
	
	// 강의 글 등록
	public void saveCourse(CourseDTO course);
	public void saveCourseImg(MultipartHttpServletRequest multi, HttpServletResponse response);
	
}
