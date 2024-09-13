<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- summernote cdn -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script src="/js/boardWrite.js"></script>
<style>
    .note-editable{
        line-height: 2 !important;
    }
</style>
<script>
	$(function(){
	    $('[name=content]').summernote({
	        placeholder: '내용을 작성하세요',
	        tabsize: 2,
	        height: 200,//에디터 높이
	        minHeight: 200,//에디터 최소 높이
	        lineHeight:20,//기본 줄 간격(px)
	        toolbar: [
	        ['style', ['style']],
	        ['font', ['bold', 'underline', 'italic']],
	        ['color', ['color']],
	        ['para', ['ul', 'ol', 'paragraph']],
	        ['table', ['table']],
	        ['insert', ['link']],
	        ]
	    });
	});
</script>
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