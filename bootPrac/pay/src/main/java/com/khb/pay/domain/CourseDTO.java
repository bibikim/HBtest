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

	private int courseNo;
	private String coTitle;
	private String coIntro;
	private String coCtnt;
	private String price;
	private String teacher;
	private Date uploadDate;


}
