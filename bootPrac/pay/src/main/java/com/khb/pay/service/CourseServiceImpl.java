package com.khb.pay.service;

import java.io.File;
import java.io.PrintWriter;
import java.lang.StackWalker.Option;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.khb.pay.domain.CourseDTO;
import com.khb.pay.domain.CourseImgDTO;
import com.khb.pay.mapper.CourseMapper;
import com.khb.pay.util.MyFileUtil;
import com.khb.pay.util.PageUtil;

import lombok.AllArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

	private CourseMapper courseMapper;
	private MyFileUtil fileUtil;
	private PageUtil pageUtil;
	
	@Override
	public void getCourseList(Model model) {
		
		Map<String, Object> modelMap = model.asMap();
		HttpServletRequest request = (HttpServletRequest)modelMap.get("request");
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		int totalRecord = courseMapper.selectCousrCnt();
		
		pageUtil.setPageUtil(page, totalRecord);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin() -1);
		map.put("recordPerPage", pageUtil.getRecordPerPage());
		
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("beginNo", totalRecord - (page-1) * pageUtil.getRecordPerPage());
		model.addAttribute("paging", pageUtil.getPaging("/course/list"));
		
		List<CourseDTO>	course = courseMapper.selectCourseListByMap(map);
		model.addAttribute("courseList", course);
		
	}
	
	
	@Override
	public CourseDTO getCourseByNo(int courseNo) {
		return courseMapper.selectCourseByNo(courseNo);
	}
	
	
	@Transactional
	@Override
	public void saveCourseImg(MultipartHttpServletRequest multirequest, HttpServletResponse response) {
		
		CourseImgDTO courseImg = CourseImgDTO.builder()
				.courseNo(Integer.parseInt(multirequest.getParameter("courseNo")))
				.imgPath(multirequest.getParameter("imgPath"))
				.imgOrigin(multirequest.getParameter("imgOrigin"))
				.filesystem(multirequest.getParameter("filesystem"))
				.hasThumbnail(Integer.parseInt(multirequest.getParameter("hasThumbnail")))
				.build();
		
		
		// 썸네일용 이미지 받아오기
		List<MultipartFile> files = multirequest.getFiles("file");
		
		int attachResult;
		if(files.get(0).getSize() == 0) {
			attachResult = 1;
		} else {
			attachResult = 0;
		}
		
		// DB에 강의 정보 저장
		int result = courseMapper.insertCourse(course);
		
		// 첨부 파일 목록 순회
		for(MultipartFile multiFile : files) {
			
			try {
				
				// 첨부가 있는지 점검
				if(multiFile != null && multiFile.isEmpty() == false) {
					
					// 원래 이름
					String imgOrigin = multiFile.getOriginalFilename();
					imgOrigin = imgOrigin.substring(imgOrigin.lastIndexOf("\\") + 1);
					
					// 저장할 이름
					String filesystem = fileUtil.getFilename(imgOrigin);
					
					// 저장할 경로
					String imgPath = fileUtil.getTodayPath();
					
					// 저장 경로 만들기
					File dir = new File(imgPath);
					if(dir.exists() == false) {
						dir.mkdirs();
					}
					
					// 첨부할 File 객체
					File file = new File(dir, filesystem);
					
					// 첨부파일 서버에 저장
					multiFile.transferTo(file);
					
					// 이지미 담기위해 다시 CourseDTO 생성
					CourseImgDTO courseAttach = CourseImgDTO.builder()
							.imgOrigin(imgOrigin)
							.imgPath(imgPath)
							.filesystem(filesystem)
							.hasThumbnail(0)	// 썸네일 디폴트 0(썸네일 없다)
							.courseNo(courseImg.getCourseNo())
							.build();
					
					// 첨부 파일 content-type 확인
					String contentType = Files.probeContentType(file.toPath());  // 이미지의 content-type (image/jpeg, image/png, image/gif)
					
					// 첨부파일이 이미지면 썸네일 만든당
					if(contentType != null && contentType.startsWith("image")) {
						
						// 썸네일 서버에 저장
						Thumbnails.of(file)
								.size(50, 50)
								.toFile(new File(dir, "s_" + filesystem));  
						
						// 썸네일이 있는 첨부로 상태 변경
						courseAttach.setHasThumbnail(1);	// 이미지 첨부가 있으면 hasThumbnail을 1로 변경(썸네일 있다)
						
					}
					
					attachResult += courseMapper.insertCourse(course);
					
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		// 응답
		try {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			if(result > 0 && attachResult == files.size()) {
				out.println("<script>");
				out.println("alert('업로드 되었습니다.');");
				out.println("location.href='/course/list'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('업로드에 실패했습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public ResponseEntity<byte[]> displayThumbnail(int courseNo) {
		
		CourseImgDTO course = courseMapper.selectCourseByNo(courseNo);
		File file = new File(course.getImgPath(), course.getFilesystem());
		
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
	
	
	
	
	
	
}
