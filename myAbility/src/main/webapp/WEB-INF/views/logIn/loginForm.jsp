<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="root" value="/"/>


<c:if test="${not empty sessionScope.userId }">
	<script>
		location.href = 'index?formpath=home';
	</script>
</c:if>
<center>
	<div class="msgvZone_wrap">
	<h1>로그인</h1>
		<h2><font color="red"> ${msg }</font></h2>
	</div>
	<div class="inputZone">
		<form id="inputForm" class="inputForm" action="loginProc" method="post">
			<table class="inputTable" >
				<tr>
					<th>아이디</th>
					<td><input type="text" id="userId" name="userId" placeholder="아이디 입력"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="userPw" name="userPw" placeholder="비밀번호 입력"></td>				
				</tr>
				<tr>
					<td colspan=2 align='center'>
						<input type="button" id="loginBtn" class="btn" onclick="logininfoSubmit();" value="로그인">
						<input type="button" id="homeBtn" class="btn" onclick="javacript:location.href='index?formpath=home'" value="메인으로">
					</td>
				</tr>
			</table>
		</form>
	</div>
</center>

<script type="text/javascript">
	var req;
	
	function logininfoSubmit(){
		
		var id =document.getElementById("userId");
		var pw =document.getElementById("userPw");
		
		if(id.value == "" || pw.value == ""){
			alert('아이디 혹은 비밀번호를 확인해주세요.');
			return;			
		}
		
		document.getElementById("inputForm").submit();		
	}

</script>