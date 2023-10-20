<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>그룹 웹소켓 예제</h1>
<button type="button" class="connect-btn">연결</button>
<button type="button" class="disconnect-btn">종료</button>
<hr>

<input type="text" class="message-input">
<button type="button" class="send-btn">전송</button>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<script>
	$(function(){
		$(".connect-btn").click(function(){
			var uri="ws://localhost:8080/ws/group";
			window.socket = new WebSocket(uri);
		});
		
		$(".disconnect-btn").click(function(){
			window.socket.close();
		});
		
		//전송 버튼을 클릭하면 입력한 메세지를 가져와서 서버로 전달
		$(".send-btn").click(function(){
			//var input = document.querySelector(".message-input").value;
			var input= $(".message-input").val();
			if(input.length==0) return;
			
			window.socket.send(input);
			$(".message-input").val("");
		});
	});

</script>