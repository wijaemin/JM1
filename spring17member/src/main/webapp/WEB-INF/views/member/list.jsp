<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form>
	<div>아이디<input type="text" name="memberId" value="${vo.memberId}"></div>
	<div>닉네임<input type="text" name="memberNickname" value="${vo.memberNickname}"></div>
	<div>전화번호<input type="text" name="memberContact" value="${vo.memberContact}"></div>
	<div>
	생년월일
	<input type="date" name="memberBirthBegin" value="${vo.memberBirthBegin}">
	~
	<input type="date" name="memberBirthEnd" value="${vo.memberBirthEnd}">
	</div>
	<div>
	포인트
	<input type="number" name="memberPointMin" value="${vo.memberPointMin}">부터
	<input type="number" name="memberPointMax" value="${vo.memberPointMax}">까지
	</div>
	<div>
	등급
	<c:choose>
		<c:when test="${vo.memberLevelList.contains('일반')}">
			<input type="checkbox" name="memberLevelList" value="일반" checked>일반
		</c:when>
		<c:otherwise>
			<input type="checkbox" name="memberLevelList" value="일반">일반
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${vo.memberLevelList.contains('VIP')}">
			<input type="checkbox" name="memberLevelList" value="VIP" checked>VIP
		</c:when>
		<c:otherwise>
			<input type="checkbox" name="memberLevelList" value="VIP">VIP
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${vo.memberLevelList.contains('관리자')}">
			<input type="checkbox" name="memberLevelList" value="관리자" checked>관리자
		</c:when>
		<c:otherwise>
			<input type="checkbox" name="memberLevelList" value="관리자">관리자
		</c:otherwise>
	</c:choose>
	</div>
	
	<!-- 정렬 -->
	<div>
	1차 정렬
	<select name="orderList">
		<option value="">선택하세요</option>
		<option value="member_level asc">등급순</option>
		<option value="member_point desc">포인트 많은 순</option>
		<option value="member_point asc">포인트 적은 순</option>
		<option value="member_login desc">최근 로그인순</option>
	</select>
	</div>
	<div>
	2차 정렬
	<select name="orderList">
		<option value="">선택하세요</option>
		<option value="member_level asc">등급순</option>
		<option value="member_point desc">포인트 많은 순</option>
		<option value="member_point asc">포인트 적은 순</option>
		<option value="member_login desc">최근 로그인순</option>
	</select>
	</div>
	<div>
	<input type="number" name="begin" value="${vo.begin}">부터
	<input type="number" name="end" value="${vo.end}">까지
	</div>
	
		
	
	<button type="submit">검색</button>
</form>

<table border="1">
	<thead>
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
			<th>이메일</th>
			<th>연락처</th>
			<th>생일</th>
			<th>주소</th>
			<th>등급</th>
			<th>포인트</th>
			<th>가입일</th>
			<th>마지막로그인</th>
			<th>마지막변경일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="memberDto" items="${list}">
			<tr>
				<td>${memberDto.memberId}</td>
				<td>${memberDto.memberNickname}</td>
				<td>${memberDto.memberEmail}</td>
				<td>${memberDto.memberContact}</td>
				<td>${memberDto.memberBirth}</td>
				<td>
				${memberDto.memberPost}/
				${memberDto.memberAddr1}/
				${memberDto.memberAddr2}
				</td>
				<td>${memberDto.memberLevel}</td>
				<td>${memberDto.memberPoint}</td>
				<td>${memberDto.memberJoin}</td>
				<td>${memberDto.memberLogin}</td>
				<td>${memberDto.memberChange}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>