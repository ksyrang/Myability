<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="root" value="/"/>

<style type="text/css">

</style>

<script type="text/javascript">
	var req;
	var idCheck = 0;
	
	function logininfoSubmit(){
		var id =document.getElementById("userId");
		var pw =document.getElementById("userPw");
		var userPwC =document.getElementById("userPwC");
		var name =document.getElementById("name");
		var mobile =document.getElementById("mobile");
		var email =document.getElementById("email");
		if(id.value == "" || pw.value == "" || userPwC.value =="" || name.value =="" || mobile.value =="" || email.value =="" ){
			alert('필수 입력사항들을 확인해주세요.');
			return;			
		}
		
		if(idCheck == 0){
			alert('아이디 중복여부를 확인하세요.');
			return;
		}
		
		if(userPwC.value != pw.value){
			alert('비밀번호를 일치하지 않습니다.');
			return;
		}
		
		document.getElementById("inputForm").submit();		
	}
	
	function checkId(){//AJAX
		var id =document.getElementById("userId");
		if(id.value == ""){
			alert('아이디를 입력하세요.');
			return;			
		}
		req = new XMLHttpRequest();
		req.onreadystatechange = printMsg;//리턴된 결과 받기
		req.open('post','checkId');//무슨 방식으로 어디에 보낼 것인가
		req.send(id.value);//보낼 자료는 내용
	}
	
	function printMsg(){
		var msg = document.getElementById("msg");
		msg.innerHTML = req.responseText;
		if(msg.innerHTML == "중복된 아이디 입니다."){
			idCheck = 0;
		}else {
			idCheck = 1;
		}
	}
	
	function pwCheck(){
		var pw =document.getElementById("userPw");
		var userPwC =document.getElementById("userPwC");
		if(pw.value == userPwC.value){
			//document.getElementById('pwLabel').style.borderColor = "green";
			document.getElementById('pwLabel').innerHTML = "일치";
		}
		else {
			document.getElementById('pwLabel').innerHTML = "불일치";
		}
	}
	
	
	
</script>
<style>
	.inputZone input[type=text], input[type=password]{
		width: 220px;
		height: 25px; 
		font-size: 20px;
	}
	
</style>

<c:if test="${not empty sessionScope.userId }">
	<script>
		location.href = 'index?formpath=home';
	</script>
</c:if>

<center>
	<div class="msgZone_wrap">
	<h1>가입</h1>
		<h2><font color="red" id="msg"> ${msg }</font></h2>
	</div>
	<div class="inputZone">
		<form id="inputForm" class="inputForm" action="joinProc" method="post">
			<table class="inputTable" >
				<tr>
					<th class="joincolumn">아이디*</th>
					<td><input type="text" id="userId" name="userId" placeholder="userId" value="${joinInfo.userId }"></td>
					<td><input type="button" value="중복 확인" onclick="checkId()"></td>
				</tr>
				<tr>
					<th>비밀번호*</th>
					<td><input type="password" id="userPw" name="userPw" placeholder="userPw" onchange="pwCheck()"></td>				
				</tr>
				<tr>
					<th>비밀번호 확인*</th>
					<td><input type="password" id="userPwC" name="userPwC" placeholder="userPwC" onchange="pwCheck()"></td>
					<td><label id="pwLabel"></label></td>
				</tr>
				<tr>
					<th>이름*</th>
					<td><input type="text" id="name" name="name" placeholder="name" value="${joinInfo.name }"></td>				
				</tr>
				<tr>
					<th>휴대전화*</th>
					<td><input type="text" id="mobile" name="mobile" placeholder="mobile" value="${joinInfo.mobile }"></td>				
				</tr>
				<tr>
					<th>이메일*</th>
					<td><input type="text" id="email" name="email" placeholder="email" value="${joinInfo.email }"></td>				
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="n" checked="checked" >선택 안함
						<input type="radio" name="gender" value="m">남성
						<input type="radio" name="gender" value="w">여성
					</td>				
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input type="text" id="zonecode" name="zipCode" placeholder="zipCode" readonly="readonly" value="${joinInfo.zipCode }"></td>
					<td colspan="2"><input type="button" value="우편번호 검색" onclick="daumPost()"></td>				
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" id="addr1" name="addr1" placeholder="addr1" readonly="readonly" value="${joinInfo.addr1 }"></td>				
				</tr>
				<tr>
					<th>상세 주소</th>
					<td><input type="text" id="addr2" name="addr2" placeholder="addr2" value="${joinInfo.addr2 }"></td>				
				</tr>
				<tr>
					<td colspan=2 align='center'>
						<input type="button" id="joinBtn" class="btn" onclick="logininfoSubmit();" value="회원가입">
						<input type="button" id="backBtn" class="btn" onclick="javascript:history.back();" value="뒤로가기">
					</td>
			</table>
		</form>
	</div>
</center>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function daumPost(){
		
	    new daum.Postcode({
	        oncomplete: function(data) {
	   			var addr = "";
	   			// R == 도로명 주소, J == 지번 주소
	   			if(data.userSelectedType == "R")
	   				addr = data.roadAddress;
	   			else{
	   				addr = data.jibunAddress;
	   			}
	   			document.getElementById('zonecode').value= data.zonecode; // 우편번호
	   			document.getElementById('addr1').value = addr;
	   			document.getElementById('addr2').focus();
	        }
	    }).open();
	    
	}
</script>


