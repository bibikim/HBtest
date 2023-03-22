package com.khb.pay.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.khb.pay.domain.CourseDTO;

@Mapper
public interface CourseMapper {

	public List<CourseDTO> selectCourseListByMap(Map<String, Object> map);
	
	
	// 썸네일은 여기서 썸네일DTO 타입으로 cousrNo 변수로 해서 받기
	
}
