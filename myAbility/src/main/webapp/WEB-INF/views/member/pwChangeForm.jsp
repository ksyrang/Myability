<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="root" value="/"/>


<c:if test="${empty sessionScope.userInfo }">
	<script>
		location.href = 'index?formpath=home';
	</script>
</c:if>

<input type="hidden" value="${sessionScope.userInfo.userPw }" id="userPw">
<input type="hidden" value="${sessionScope.userInfo.userId }" id="userId">

<center>
	<div class="msgvZone_wrap">
	<h1>비밀번호 변경</h1>
		<h2><font color="red" id="headmsg"> ${msg }</font></h2>
	</div>
	<div class="inputZone">
		<form id="inputForm" class="inputForm" action="pwChangeProc" method="post">
			<table class="inputTable" >
				<tr>
					<th>아이디</th>
					<th><label>${sessionScope.userInfo.userId }</label></th>				
				</tr>
				<tr>
					<th>현재 비밀번호</th>
					<td><input type="password" id="oldPw" name="oldPw" placeholder="비밀번호 입력"></td>				
				</tr>	
				<tr>
					<th>변경 비밀번호</th>
					<td><input type="password" id="newPw" name="newPw" placeholder="비밀번호 입력"></td>				
				</tr>
				<tr>
					<th>변경 비밀번호 확인</th>
					<td><input type="password" id="newPwc" name="newPwc" placeholder="비밀번호 입력"></td>				
				</tr>
				<tr>
					<td colspan=2 align='center'>
						<input type="button" id="loginBtn" class="btn" onclick="pwChangeSubmit();" value="변경">
						<input type="button" id="homeBtn" class="btn" onclick="javacript:location.href='index?formpath=home'" value="메인으로">
					</td>
				</tr>
			</table>
		</form>
	</div>
</center>

<script type="text/javascript">
	var req;
	
	function pwChangeSubmit(){
		
		var userId =document.getElementById("userId");
		var userPw =document.getElementById("userPw");
		var oldPw =document.getElementById("oldPw");
		var newPw =document.getElementById("newPw");
		var newPwc =document.getElementById("newPwc");
				
		if(oldPw.value == "" || newPw.value == "" || newPwc.value == ""){
			alert('비밀번호를 입력해주세요.');
			return;			
		}
		
		if(userPw.value != oldPw.value){
			alert('기존 비밀번호가 일치하지 않습니다..');
			return;			
		}
		
		if(userPw.value == newPw.value){
			document.getElementById('headmsg').innerHTML="기존 비밀번호와 동일합니다.";
			return;			
		}			
		
		
		if(newPw.value != newPwc.value){
			alert('변경 비밀번호가 일치하지 않습니다.');
			return;			
		}		
		
		
		
		document.getElementById("inputForm").submit();		
	}

</script>