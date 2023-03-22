package com.khb.pay.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ThumbnailDTO {
	
	private int thumbnailNo;
	private int courseNo;
	private String thumbnailPath;
	private String thumbnailOrigin;
	private String filesystem;
	private int hasThumbnail;
}
