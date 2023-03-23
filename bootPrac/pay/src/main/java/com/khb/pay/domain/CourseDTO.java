package com.khb.pay.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CourseDTO {

	private int cousreNo;
	private String coTitle;
	private String coIntro;
	private String coCtnt;
	private String price;
	private String coTeacher;
	private Date uploadDate;

	private String thumbPath;
	private String thumbOrigin;
	private String filesystem;
	private int hasThumbnail;

}
