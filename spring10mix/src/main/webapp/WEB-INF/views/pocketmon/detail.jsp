<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    	페이지 내에서 프로그래밍 처릐를 할 수 있는
    	추가 도구를 사용하도록 설정
     --%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.no}번 몬스터 정보</title>
</head>
<body>
	
	<c:choose>
		<c:when test="${dto !=null}" ><%--if와 동일 --%>
		<h1>${dto.no}번 몬스터 정보</h1>
		<h1>이름:${dto.name}</h1>
		<h1>속성:${dto.type}</h1>
		</c:when>
		<c:otherwise><%--else와 동일--%>
			<h1>sorry</h1>
			<img width="100" height ="100" alt="sorry" src="/sorry.gif">
		</c:otherwise>
	</c:choose>

<a href="list">목록으로 이동</a>
</body>
</html>