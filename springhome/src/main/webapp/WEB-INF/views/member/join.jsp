<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>




<style>
    /*
        진행바 디자인
    */
    .progressbar {
        width: 100%;
        height: 5px;
    }
    .progressbar > .guage {
        width: 0%;
        height: 100%;
        background: rgb(131,58,180);
        background: linear-gradient(90deg, rgba(131,58,180,1) 0%, rgba(253,29,29,1) 50%, rgba(252,176,69,1) 100%);
        /* 스르륵 */
        transition: width 0.1s ease-out;
    }
</style>

<script src="${pageContext.request.contextPath}/js/memberJoin.js"></script>
<script src="${pageContext.request.contextPath}/js/multipage.js"></script>
<script src="${pageContext.request.contextPath}/js/progressbar.js"></script>
<script src="${pageContext.request.contextPath}/js/address.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

</script>



<div class="container w-500">
   	<div class="row">
    	<h2>회원가입</h2>
    </div>
    
	<form class="join-form" action="join" method="post" autocomplete="off">
			
			<!-- 전체 진행단계를 알 수 있는 게이지 출력 -->
            <div class="row">
                <div class="progressbar">
                    <div class="guage"></div>
                </div>
            </div>
		<!-- 1단계 : 아이디+비밀번호+확인 -->
        <div class="row page">
            <div class="row">
            	<h2>1단계 : 아이디/비밀번호</h2>
            </div>
	        <div class="row left">
	            <!-- 라벨에는 for를 이용하여 특정 대상을 연결시킬 수 있다 
	                for="대상ID"
	                체크박스 등도 선택하게 만들 수 있다(디자인적으로 활용)
	            -->
	            <label>
	            	아이디
	            	<i class="fa-solid fa-asterisk red"></i>
	            </label>
	            <input type="text" name= "memberId" class="form-input w-100" 
	                    placeholder="영문 소문자+숫자 5~20자 이내">
	            <div class="success-feedback">멋진 아이디입니다!</div>
	           	<div class="fail-feedback">아이디 형식이 잘못됐습니다</div>
	           	<div class="fail2-feedback">이미 사용중인 아이디입니다</div>
	        </div>
	        <div class="row left">
	            <label>
	            	비밀번호
	            	<i class="fa-solid fa-asterisk red"></i>
	            </label>
	            <input type="password" name="memberPw" class="form-input w-100" 
	                    placeholder="영문 대소문자+숫자+특수문자 반드시 포함 8~16자">
	            <div class="success-feedback">올바른 비밀번호 형식입니다</div>      
	            <div class="fail-feedback">비밀번호 형식이 잘못됐습니다</div>
	        </div>
	        <div class="row left">
                    <label>비밀번호 확인 <i class="fa-solid fa-asterisk red"></i></label>
                    <input type="password" id="password-check" 
                            placeholder="비밀번호 한 번 더 입력" class="form-input w-100">
                    <div class="success-feedback">비밀번호가 일치합니다</div>
                    <div class="fail-feedback">비밀번호가 일치하지 않습니다</div>
                    <div class="fail2-feedback">비밀번호를 먼저 작성하세요</div>
                </div>
                
            <div class="row right">
                    <button type="button" class="btn btn-prev">
                        <i class="fa-solid fa-arrow-left"></i>
                    </button>
                    <button type="button" class="btn btn-next">
                        <i class="fa-solid fa-arrow-right"></i>
                    </button>
                </div>  
                        
        </div>    
            
          <!-- 2단계 : 닉네임 -->
        <div class="row page">
        	<div class="row">
        		<h2>2단계 : 닉네임</h2>
        	</div>
	        <div class="row left">
	            <label>
	            닉네임
	            <i class="fa-solid fa-asterisk red"></i>
	            </label>
	            <input type= "text" name="memberNickname" class="form-input w-100" 
	            placeholder="한글 또는 숫자 2~10자 이내">
	            <div class="success-feedback">멋진 닉네임입니다!</div>
	            <div class="fail-feedback">닉네임 형식이 잘못됐습니다</div>
	            <div class="fail2-feedback">닉네임이 이미 사용중입니다</div>
	        </div>
	        
	        <div class="row right">
                    <button type="button" class="btn btn-prev">
                        <i class="fa-solid fa-arrow-left"></i>
                    </button>
                    <button type="button" class="btn btn-next">
                        <i class="fa-solid fa-arrow-right"></i>
                    </button>
            </div>
        
        </div>
        
        
        <!-- 3단계 : 이메일+연락처 -->
        <div class="row page">
	        <div class="row">
	        <h2>3단계 : 연락 가능한 정보</h2>
	        </div>
        
        
	        <div class="row left">
	                <label>이메일</label>
	        <input type="text" name ="memberEmail"class="form-input w-100" 
	                placeholder="testuser@kh.com">
	        <div class="fail-feedback">이메일 형식이 잘못되었습니다</div>
	        </div>
	        <div class="row left">
	            <label>연락처</label>
	            <input type="tel" name= "memberContact" class="form-input w-100" 
	                    placeholder="010XXXXXXXX (- 없이)">
	             <div class="fail-feedback">전화번호 형식이 올바르지 않습니다</div>       
	        </div>
	        
	        
	        <div class="row right">
	            <button type="button" class="btn btn-prev">
	            	<i class="fa-solid fa-arrow-left"></i>
	            </button>
	            <button type="button" class="btn btn-next">
	            	<i class="fa-solid fa-arrow-right"></i>
	            </button>
            </div>
        
        </div>
        


		<!-- 4단계 : 생년월일-->
        <div class="row page">
	        <div class="row">
	        	<h2>4단계 : 생년월일</h2>
        	</div>
	        <div class="row left">
	            <label>생년월일</label>
	            <input type="date" name="memberBirth" class="form-input w-100">
	            <div class="fail-feedback">잘못된 날짜를 선택하셨습니다</div>
	        </div>

            <div class="row right">
                <button type="button" class="btn btn-prev">
                    <i class="fa-solid fa-arrow-left"></i>
                </button>
                <button type="button" class="btn btn-next">
                    <i class="fa-solid fa-arrow-right"></i>
                </button>
            </div>
        
        
     	</div>
     	
     	
	         <!-- 5단계 : 주소 -->
	   	<div class="row page">
	   	
	       	<div class="row">
	           	<h2>5단계 : 주소</h2>
	       	</div>
	       	
	        <div class="row left">
	            <label style="display: block;">주소</label>
	            <input type="text" name="memberPost" class="form-input post-search" 
	            placeholder="우편번호" size="6" maxlength="6" readonly>
	            <button type="button" class="btn post-search">
	            	<i class="fa-solid fa-magnifying-glass"></i>
	            </button>
	            
	            <input type="text" name="memberAddr1" placeholder="기본주소"
	            		class="form-input w-100 mt-10 post-search" readonly>
	            
	            <input type="text" name="memberAddr2" class="form-input w-100 mt-10" placeholder="상세주소">
	            
	            <div class="fail-feedback">모든 주소를 작성해주세요</div>
	            
	        </div>
	        
			<div class="row right">
				<button type="button" class="btn btn-prev">
			    	<i class="fa-solid fa-arrow-left"></i>
				</button>
			 	<button type="button" class="btn btn-next">
			    	<i class="fa-solid fa-arrow-right"></i>
			 	</button>
			 	<button type="submit" class="btn btn-positive">가입하기</button>            
			</div>
	       	   	
     	</div>


	</form>
</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>