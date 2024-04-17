<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<table border="1" width="800">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>조회수</th>
				<th>좋아요수</th>
				<th>댓글수</th>
				<th>작성일</th>
				<th>수정일</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="boardListDto" items="${list}">
			<tr>
				<td>
					${boardListDto.no}
				</td>
				<td>
					${boardListDto.writer}
				</td>
				<td>
					${boardListDto.title}
				</td>
				<td>
					${boardListDto.readcount}
				</td>
				<td>
					${boardListDto.likecount}
				</td>
				<td>
					${boardListDto.replycount}
				</td>
				<td>
					${boardListDto.createdAt}
				</td>
				<td>
					${boardListDto.updatedAt}
				</td>
			</tr>
			</c:forEach>
		</tbody>
	<tr>
	</tr>
</table>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>