
	$(function(){
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
						$(".btn-cert").prop("disabled",true);
					}
					else{
						$(".cert-input").removeClass("success fail")
											.addClass("fail");
					}
				},
			});
		});
	});