<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="root" value="/"/>
<style type="text/css">
	a:link{color:black;font-family:sans-serif;text-decoration:none;}
	a:visited{color:black;font-family:sans-serif;text-decoration:none;}
	a:hover{color:#cc3300; font-weight:bold; }
	a:active{color:#ff00cc; text-decoration:underline; }
	
	#header_table td{
		width: 100px;
	}
</style>

<div id="header_wrap" align="center" >
	<table id="header_table" border=1 style="width: 100%;">
		<tr>
			<th align="center" colspan=5>
				<a href="${root }index?formpath=home">
					<font size="20px;">KJS Ability</font>
				</a>
			</th>
		</tr>
		<tr align="center">
		<c:choose>
			<c:when test="${empty sessionScope.userInfo }">
				<td><a href="${root }index?formpath=login">login</a></td>
				<td><a href="${root }index?formpath=join">join</a></td>
				<td><a href="${root }index?formpath=findInfo">findInfo</a></td>
			</c:when>
			<c:otherwise>
				<td><a href="${root }index?formpath=home">address</a></td>
				<td><a href="${root }index?formpath=modifyInfo">changeInfo</a></td>
				<td><a href="${root }index?formpath=pwChange">pwChange</a></td>	
				<td><a href="${root }logout">logOut</a></td>
			</c:otherwise>
		</c:choose>
		</tr>
	</table>
</div>
<!--  -->