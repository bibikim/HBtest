package com.khb.pay.service;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.khb.pay.domain.CourseDTO;
import com.khb.pay.mapper.CourseMapper;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	
	@Override
	public List<CourseDTO> getCourseList() {
		return courseMapper.selectCourseListByMap();
	}
	
	@Override
	public ResponseEntity<byte[]> displayThumbnail(int courseNo) {
		
		CourseDTO course = courseMapper.selectCourseByNo(courseNo);
		File file = new File(course.getThumbPath(), course.getFilesystem());
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			if(course.getHasThumbnail() == 1) {
				
				HttpHeaders headers = new HttpHeaders();
				headers.add("Content-Type", Files.probeContentType(file.toPath()));
				File thumbnail = new File(course.getThumbPath(), "s_" + course.getFilesystem());
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(thumbnail), null, HttpStatus.OK);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	@Override
	public CourseDTO getCourseByNo(int courseNo) {
		return courseMapper.selectCourseByNo(courseNo);
	}
	
	@Override
	public void saveCourse(HttpServletRequest request, HttpServletResponse response) {
		
		CourseDTO course = CourseDTO.builder()
				.coTitle(request.getParameter("coTitle"))
				.coIntro(request.getParameter("coIntro"))
				.coCtnt(request.getParameter("coCtnt"))
				.price(request.getParameter("price"))
				.coTeacher(request.getParameter("coTeacher"))
				.build();
		
		int result = courseMapper.insertCourse(course);
		
		// 썸네일용 이미지 첨부
		
		
		
	}
	
}
