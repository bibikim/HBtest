package com.khb.pay.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CourseImgDTO {
	
	private int imgNo;
	private int courseNo;
	private String imgPath;		// 이미지 경로
	private String imgOrigin;
	private String filesystem;	// 이미지 파일명
	private int hasThumbnail;	// 썸네일(대표 이미지) 여부
}
