<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<form action="edit" method="post" autocomplete="off">
		<div class="container w-500">
				<div class="row">
					<h1>수정하기</h1>
				</div>
					<input type="hidden" name="no" value="${boardDto.no}">	
				<div class="row left">
					제목<input type="text" name="title" class="form-input w-100" value="${boardDto.title}" required><br><br>
				</div>
				<div class="row left">
					내용<textarea name="content" class="form-input w-100 fixed" required>${boardDto.content}</textarea><br><br>
				</div>
				<div class="row">
				<button class="btn btn-positive">등록하기</button>
				</div>
		</div>
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>