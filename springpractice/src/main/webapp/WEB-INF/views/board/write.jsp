<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script src="/js/boardWrite.js"></script>

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