package com.khb.pay.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.springframework.http.ResponseEntity;

import com.khb.pay.domain.CourseDTO;

public interface CourseService {

	// 강의 목록 & 썸네일
	public List<CourseDTO> getCourseList(); 
	public ResponseEntity<byte[]> displayThumbnail(int courseNo);
	
	// 강의 상세
	public CourseDTO getCourseByNo(int courseNo);
	
	// 강의 글 등록
	public void saveCourse(HttpServletRequest request, HttpServletResponse response);
	
}
