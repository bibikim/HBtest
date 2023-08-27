package com.khb.pay.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.khb.pay.domain.CourseDTO;
import com.khb.pay.domain.CourseImgDTO;

@Mapper
public interface CourseMapper {

	// 1. 강의 목록 조회
	public List<CourseDTO> selectCourseListByMap(Map<String, Object> map);
	public int selectCousrCnt();
	
	
	// 2. 강의 상세 조회(COURSE DTO 한개) & 썸네일 조회
	public CourseDTO selectCourseByNo(int courseNo);
	public CourseImgDTO selectImgByNo(int courseNo);
	
	// 3. 강의 등록(글쓰기 & 이미지 삽입)
	public int insertCourse(CourseDTO course);
	public int insertImg(CourseImgDTO courseImg);
	
	
}
