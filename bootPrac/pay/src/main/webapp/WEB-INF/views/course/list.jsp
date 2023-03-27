<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="/resources/js/jquery-3.6.1.min.js"></script>
<script>
	
	
	// 목록 가져오기
	function fn_getList() {
		
		$.ajax({
			type: 'get',
			url: '/course/list',
			data: 'page=' + page,
			dataType: 'json',
			success: function(resData) {
				totalPage = resData.totalPage;
				$.each(resData.courseList, function(i, course){
					var courseList = '<div class="course">';
					courseList += '<div>' + course.courseNo + '</div>';
					courseList += '<div>' + course.coTitle + '</div>';
					courseList += '<div>' + course.price + '</div>';
					courseList += '</div>';
					$('.course-list').append(courseList);
				}) 
			}
		})
		
	}
	
	
</script>
<body>



	<div>
		<a href="/course/write">강의 등록</a>
		<div class="course-container">
			<div class="course-list"></div>
		</div>
	</div>


</body>
</html>