<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<script src="/js/boardWrite.js"></script>
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


<script>

</script>

<div class="container w-600">
<c:choose>
	<c:when test="${isReply}">
		<div class="row">
			<h2>답글 작성</h2>
		</div>
	</c:when>
	<c:otherwise>
		   <div class="row">
                <h1>게시글 작성</h1>
            </div>
	</c:otherwise>
</c:choose>
	<%-- 답글일 때만 추가 정보를 전송 --%>
	<form action="write" method="post" autocomplete="off" onsubmit="return checkForm();">
	<c:if test="${isReply}">
	<input type="hidden" name="boardParent" value="${originDto.boardNo}">
	</c:if>
	
	
	<c:choose>
		<c:when test="${isReply}">
			 <div class="row left">
                <label >
                	제목
                	<span class="important">*</span>
                </label>
                <input type="text" name="boardTitle"  value="RE: ${originDto.boardTitle}" 
                class="form-input w-100" onblur="checkBoardTitle();">
                <div class="fail-feedback">제목은 필수이며 100자 이내로 작성해야 합니다</div>
            </div>
							
		</c:when>
		<c:otherwise>
		 <div class="row left">
                <label >
                	제목
                	<span class="important">*</span>
                </label>
                <input type="text" name="boardTitle" class="form-input w-100"
                onblur="checkBoardTitle();">
                <div class="fail-feedback">제목은 필수이며 100자 이내로 작성해야 합니다</div>
            </div>
		</c:otherwise>
	</c:choose>
	 <div class="row left">
                <label>
                	내용
                	<span class="important">*</span>
                </label>
                <textarea name="boardContent" class="form-input fixed w-100" rows="10"
                 oninput="checkBoardContent();"></textarea>
                 <div class="fail-feedback">뭐라도 좀 쓰세요</div>
                 <div class="fail2-feedback">1000자 넘겼잖아</div>
            </div>
            
            <div class="row right">
                <span class="len">0</span>/1000
            </div>
	 <div class="row ">
                <button type="submit" class="btn btn-positive">글쓰기</button>
                <a type="button"  href="list" class="btn">목록보기</a>
            </div>
	
	
	 
	</form>
	
	
	
	
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>