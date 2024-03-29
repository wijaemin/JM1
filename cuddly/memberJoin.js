$(function(){


    var status={
        id:false,
        name:false,
        pw:false,
        pwCheck:false,
        contact:false,
        email:false,
        birth:false,
        emailOk:false,
        ok:function(){
            return this.id && this.name && this.pw && this.pwCheck && 
                 this.contact && this.email && this.birth && this.emailOk;
        }
    };






        //이메일 인증번호 보내기

		$(".btn-send").find(".fa-spinner").hide();
		$(".cert-wrapper").hide();
		
		//인증번호 보내기 버튼 누르면
		//서버로 비동기 통신을 보내 메일 발송 요쳥
		$(".btn-send").click(function(){
			var email = $("[name=memberEmail]").val();
			if(email.length == 0) return;
			$(".btn-send").prop("disabled",true);
			$(".btn-send").find(".fa-spinner").show();
			$(".btn-send").find("span").text("이메일 보내는중이요");
			
			$.ajax({
				url:"http://localhost:8080/cuddly/rest/cert/send",
				method:"post",
				data:{certEmail:email},
				success: function(){
					$(".btn-send").prop("disabled",false);
					$(".btn-send").find(".fa-spinner").hide();
					$(".btn-send").find("span").text("인증번호 보내기");
					
					window.alert("이메일로 보내드렸어요");
					
					$(".cert-wrapper").show();
				},
			});

		});
		
		//확인버튼 누르면 이메일과 인증번호를 서버로 전달해서 검사
		$(".btn-cert").click(function(){
			var email = $("[name=memberEmail]").val();
			var number = $(".cert-input").val();
		
			
			if(email.length==0 || number.length ==0 ) return;
			
			$.ajax({
				url:"http://localhost:8080/cuddly/rest/cert/check",
				method : "post",
				data:{
					certEmail:email,
					certNumber:number,
					
				},
				success:function(response){
					if(response.result){
						$(".cert-input").removeClass("success fail")
											.addClass("success");
                        status.emailOk =true;                    
						$(".btn-cert").prop("disabled",true);
					}
					else{
						$(".cert-input").removeClass("success fail")
											.addClass("fail");
                        status.emailOk =false;
					}
				},
			});
		});
















    $("[name=memberId]").blur(function(e){
        var regex=/^[a-z][a-z0-9-_]{4,14}$/;
        var inputId=$(e.target).val();
        
        var isValid=regex.test(inputId);
        $(e.target).removeClass("success fail fail2");
        if(isValid){//형식이 유효하다면
          $.ajax({
            url:"http://localhost:9999/cuddly/rest/member/idCheck",
            method:"post",
            // data : {memberId : e.target.value},
            data :{memberId:$(e.target).val()},
            success:function(response){
                if(response =="Y"){//사용가능
                    $(e.target).addClass("success");
                    status.id=true;
                }
                else{//사용불가(중복)
                    $(e.target).addClass("fail2");
                    status.id=false;
                }
            },
            error:function(){
                alert("서버와의 통신이 원활하지 않습니다");
            },
          });
        }
        else{
            $(e.target).addClass("fail");
            status.id=false;
        }
   
    });

    $("[name=memberName]").blur(function(){
        var regex=/^[가-힣]{2,7}$/;
        var inputName=$(this).val();
        var isValid=regex.test(inputName);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.name=isValid;

    });

    $("[name=memberPw]").blur(function(){
        var regex=/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,20}$/;
        var inputPw=$(this).val();
        
        var isValid=regex.test(inputPw);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.pw=isValid;
    });

    $("#password-check").blur(function(){
        var inputPw=$("[name=memberPw]").val();
        var checkPw=$(this).val();

        var isValid=inputPw==checkPw;

        $(this).removeClass("success fail fail2");
        if(inputPw.length==0){
            $(this).addClass("fail2");
            status.pwCheck=false;

        }
        else if(isValid){
            $(this).addClass("success");
            status.pwCheck=true;
        }
        else{
            $(this).addClass("fail");
            status.pwCheck=false;
        }
    });

    $("[name=memberContact]").blur(function(){
        var regex = /^010[1-9][0-9]{7}$/;
        var inputContact=$(this).val();
        
        var isValid=$(this).val().length==0 || regex.test(inputContact);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.contact=isValid;
    });

    $("[name=memberEmail]").blur(function(){
        var regex=/^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
        var inputEmail=$(this).val();
        
        var isValid=regex.test(inputEmail);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.email=isValid;
    });
    $("[name=memberBirth]").blur(function(){
        var regex=/^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((02)-(0[1-9]|1[0-9]|2[0-9])))$/;
        var inputBirth=$(this).val();
        
        var isValid=$(this).val().length==0 || regex.test(inputBirth);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.birth=isValid;
    });




    //페이지 이탈 방지
    //- window에 beforeunload 이벤트 설정
    $(window).on("beforeunload", function(){
        return false;
    });

    //-form 전송할 때는 beforeunload 이벤트를 제거
    $(".join-form").submit(function(e){
        $(".form-input").blur();
        
        if(!status.ok()){
            e.preventDefault();
        }
        else{
            $(window).off("beforeunload");
        }
    });

 });