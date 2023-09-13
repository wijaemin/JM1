<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- summernote cdn-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<style>
    .note-editable{
        /* 폰트 사이즈가 있어야 높이 조절이 된다 */
        line-height: 2 !important;
    }

</style>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<script src="/js/boardEdit.js"></script>
<script>
        $(function(){
            $('[name=boardContent]').summernote({
                placeholder: '내용적어',
                tabsize: 2,//탭을 누르면 이동할 간격
                height: 200,//에디터 높이
                minHeight: 200,//에디터 최소높이
                toolbar: [
                ['style', ['style']],
                ['font', ['bold', 'italic', 'clear']],
                ['color', ['color']],
                ['para', ['paragraph']],
                ['table', ['table']],
                ['insert', ['link']],
                ]
            });
        });

</script>



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
				>
				<div class="fail-feedback">제목은 필수이며 100자 이내로 작성해야 합니다</div>
			</div>
			
			<div class="row left">
				<label>
					내용
					<span class="important">*</span>
				</label>
				<textarea class="form-input w-100" name="boardContent" 
				style="min-height:250px" required>${boardDto.boardContent}</textarea>
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