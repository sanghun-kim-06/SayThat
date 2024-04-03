<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign up | SayThat</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<h2>회원가입</h2>
<form action="/signUp" method="post" name="frm">
<lable id="label1">ID : </lable>
<input type="text" id="id" name="id"><lable id="label1-1"></lable>
<lable>PASSWORD : </lable>
<input type="text" id="password" name="password">
<lable>NAME : </lable>
<input type="text" id="name" name="name">
<lable>PHONE : </lable>
<input type="number" id="phone" name="phone">
<input type="hidden" id="joindate" name="joindate"> 
<input type="submit" onclick="return check()">
</form>

<script type="text/javascript">
$("#id").on("focusout", function() {
	
	var id = $("#id").val();
	
	if(id == '' || id.length == 0) {
		$("#label1").css("color", "red").text("공백은 ID로 사용할 수 없습니다.");
		return false;
	}
	
	//Ajax로 전송
	$.ajax({
		url : '/userIdCheck',
		data : {
			id : id
		},
		type : 'POST',
		dataType : 'json',
		success : function(result) {
			
			console.log(result.result);
			console.log(result.result == "사용 가능한 ID입니다.");
			if (result.result == "사용 가능한 ID입니다.") {
				$("#label1-1").css("color", "black").text(result.result);
			} else{
				$("#label1-1").css("color", "red").text(result.result);
				$("#id").val('');
			}
		}
	});
});



function check(){
	if(document.frm.id.value.trim() == ""){
		document.frm.id.focus();
		alert("아이디를 입력해주세요");
		return false;
	}
	if(document.frm.password.value.trim() == ""){
		document.frm.password.focus();
		alert("비밀번호를 입력해주세요");
		return false;
	}
	if(document.frm.name.value.trim() == ""){
		document.frm.name.focus();
		alert("이름을 입력해주세요");
		return false;
	}
	if(document.frm.phone.value.trim() == ""){
		document.frm.phone.focus();
		alert("핸드폰번호를 입력해주세요");
		return false;
	}
	let dt = new Date();
	let dtv = dt.getFullYear() + "-" + dt.getMonth() + "-" + dt.getDate();
	document.frm.joindate.value = dtv;
	
	document.frm.submit();
}
</script>
</body>
</html>