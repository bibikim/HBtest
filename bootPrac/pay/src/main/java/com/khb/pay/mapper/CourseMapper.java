package com.khb.pay.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.khb.pay.domain.CourseDTO;

@Mapper
public interface CourseMapper {

	// 1. 강의 목록 조회
	public List<CourseDTO> selectCourseListByMap();
	
	// 2. 강의 상세 조회(COURSE DTO 한개) & 썸네일 조회
	public CourseDTO selectCourseByNo(int coursNo);
	
	// 3. 강의 등록(글쓰기)
	public int insertCourse(CourseDTO course);
	
	
}
