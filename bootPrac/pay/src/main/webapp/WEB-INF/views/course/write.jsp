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

	$('#frm_write').submit(function(ev){
		if($('.title').val() == '') {
			alert('강의명을 입력해주세요.');
			ev.preventDefault();
			$('.title').focus();
			return;
		}
		
		if($('#content').val() == '') {
			alert('강의 내용은 필수 입력사항입니다.');
			ev.preventDefault();
			$('#content').focus();
			return;
		}
		
		if($('#thumbnail').val() == '') {
			alert('강의 대표 이미지 등록은 필수 입력사항입니다.');
			ev.preventDefault();
			$('#thumbnail').focus();
			return;
		}
		
		
		
	})

</script>
<body>

	<div>
		
		<div>
			
			<form id="frm_write" action="/course/add" method="post" enctype="multipart/form-data">
				
				<div class="wr-title">
					<input type="text" class="title" name="coTitle" placeholder="강의명을 입력해주세요.">
				</div>
				
				<div class="wr-intro">
					<input type="text" class="intro" name="coIntro" placeholder="짧은 강의 소개">
				</div>
				
				<div class="wr-teacher">
					<input type="text" class="teacher" name="coTeacher" placeholder="강사 이름">
				</div>
				
				<div class="wr-price">
					<input type="text" class="price" name="price" placeholder="강의 비용 입력">
				</div>
				
				
				<div class="file-thumb">
					<span>썸네일 등록</span>
					<div class="filezone">
						<input type="file" name="thumbnail" id="thumbnail" multiple="multiple" accept="image/gif, image/png, image/jpg, image/jpeg">
					</div>
				</div>
				
				<div class="wr-ctnt">
					<label for="content">강의 내용</label>
					<textarea id="content" name="coCtnt"></textarea>
				</div>
				
				<div class="wr-btn">
					<button class="add-btn">등록하기</button>
				</div>
				
			</form>
			
		</div>
		
	</div>
	

</body>
</html>