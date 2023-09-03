<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script src="/js/boardEdit.js"></script>



<div class="container w-600">
	<form action="edit" method="post" autocomplete="off" onsubmit="return checkForm();">
		<input type="hidden" name="boardNo" value="${boardDto.boardNo}">


		
			<div class="row">
				<h1>게시글 수정</h1>
			</div>
			
			<div class="row left">
				<label>
					제목
					<span class="important">*</span>
				</label>
				<input class="form-input w-100" type="text" name="boardTitle" value="${boardDto.boardTitle}"
				onblur="checkBoardTitle();">
				<div class="fail-feedback">제목은 필수이며 100자 이내로 작성해야 합니다</div>
			</div>
			
			<div class="row left">
				<label>
					내용
					<span class="important">*</span>
				</label>
				<textarea class="form-input w-100" name="boardContent" 
				style="min-height:250px" required oninput="checkBoardContent();">${boardDto.boardContent}</textarea>
				 <div class="fail-feedback">뭐라도 좀 쓰세요</div>
                 <div class="fail2-feedback">1000자 넘겼잖아</div>
			</div>
			<div class="row right">
                <span class="len">0</span>/1000
            </div>
			<div class="row right">
				<a href="list" class="btn">
					<i class="fa-solid fa-list"></i>
					목록
				</a>
				<button type="submit" class="btn btn-positive">
					<i class="fa-solid fa-edit"></i>
					수정
				</button>
			</div>

	</form>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>