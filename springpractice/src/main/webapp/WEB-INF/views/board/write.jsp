<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- summernote cdn -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<style>
    .note-editable{
        line-height: 2 !important;
    }
</style>
<script src="/js/boardWrite.js"></script>
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

	<form action="write" method="post">
		<c:if test="${isReply}">
			<input type="hidden" name="boardParent" value="${originDto.no}">
		</c:if>
        <div class="container w-600">
            <div class="row">
				<c:choose>
					<c:when test="${isReply}">
						<h2>답글 작성</h2>
					</c:when>
					<c:otherwise>
						<h2>게시글 달성</h2>
					</c:otherwise>
				</c:choose>
            </div>
            <div class="row left">
                <label>제목<span class="important">*</span></label>
                <c:choose>
                	<c:when test="${isReply}">
		                <input type="text" name="title" class="form-input w-100" value="RE:${originDto.title}" required>
                	</c:when>
                	<c:otherwise>
                		<input type="text" name="title" class="form-input w-100" required>
                	</c:otherwise>
                </c:choose>
            </div>
            <div class="row left">
                <label>내용</label>
                <textarea name="content" class="form-input w-100 fixed" required></textarea>
            </div>
            <div class="row right">
                <button class="btn btn-positive">글쓰기</button>
                <a href="list" class="btn">목록보기</a>
            </div>
            
        </div>
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>