<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

                <!-- 메뉴바 -->
                <nav class="navbar navbar-expand-lg bg-light fixed-top" data-bs-theme="light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">집가고싶다</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarColor03">
                            <ul class="navbar-nav me-auto">
                                <li class="nav-item">
                                    <a class="nav-link active" href="#">
                                        <span class="visually-hidden">(current)</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Features</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Pricing</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">About</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                                        aria-haspopup="true" aria-expanded="false">Dropdown</a>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="#">Action</a>
                                        <a class="dropdown-item" href="#">Another action</a>
                                        <a class="dropdown-item" href="#">Something else here</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#">Separated link</a>
                                    </div>
                                </li>
                            </ul>
                            <form class="d-flex">
                                <input class="form-control me-sm-2" type="search" placeholder="Search">
                                <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                            </form>
                        </div>
                    </div>
                  </nav> 


				<div class="row mt-5">
					<div class="col mt-5">
					<h1>결제를 배워보자</h1>
					</div>
				</div>

				<c:choose>
				
				<c:when test="${sessionScope.name == null}">
					<form action="login" method="post">
					
						<div class="row mt-5">
							<div class="col text-center">
								<input type="text" name="memberId" placeholder="아이디"><br><br>
							</div>
						</div>
						
						<div class="row mt-5">
							<div class="col">
								<input type="password" name="memberPw" placeholder="비밀번호"><br><br>
							</div>						
						</div>
						
						<div class="row mt-5">
							<div class="col">
								<button type="submit" class="btn btn-primary w-100">로그인</button>
							</div>						
						</div>
						
					</form>
				
				</c:when>
					<c:otherwise>
					
						<div class="row mt-5">
						<h1>${sessionScope.name}으로 로그인 중...</h1>
						</div>
						<a href="logout" 
						class="text-secondary link-underline link-underline-opacity-0 
						link-underline-opacity-75-hover">
						로그아웃
						</a>
					</c:otherwise>
				</c:choose>
				
				<h2><a class="link-opcity-50 link-underline link-underline-opacity-0 
						link-underline-opacity-75-hover" href="pay/test1">첫번째 예제</a></h2>
				<h2><a class="link-opcity-50 link-underline link-underline-opacity-0 
						link-underline-opacity-75-hover" href="pay/test2">두번째 예제</a></h2>
				<h2><a class="link-opcity-50 link-underline link-underline-opacity-0 
						link-underline-opacity-75-hover" href="pay/test3">세번째 예제</a></h2>






                <!-- 푸터 -->
                <hr>
                <div class="row">
                    <div class="col-6">
                        <h4 class="text-secondary">
                            <span class="badge bg-primary">KH</span>
                            &copy; KH정보교육원 Inst 
                        </h4>
                    </div>
                    <div class="col-3">
                        <div class="list-group">
                            <a href="#" class="list-group-item list-group-item-action border-0">항목1</a>
                            <a href="#" class="list-group-item list-group-item-action border-0">항목2</a>
                            <a href="#" class="list-group-item list-group-item-action border-0">항목3</a>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="list-group">
                            <a href="#" class="list-group-item list-group-item-action border-0">항목4</a>
                            <a href="#" class="list-group-item list-group-item-action border-0">항목5</a>
                            <a href="#" class="list-group-item list-group-item-action border-0">항목6</a>
                        </div>
                    </div>
                </div>
                

                
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>