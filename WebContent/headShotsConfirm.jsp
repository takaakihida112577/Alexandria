<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="leftMenu.jsp"/>
<div id="pointinfo">
	<span>
	<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.loginIdErrorMessageList"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	</span>
	<s:form method="post" action="HeadShotsCompleteAction" enctype="multipart/form-data">
	<table cellspacing="0"align="center">
		<tr>
			<td>
				<br>
				<img src='<s:property value="#session.faceShots"/>' alt="No Image">
			</td>
			<td>
				<b>→</b>
			</td>
			<td>
				<img src='<s:property value="#session.userImageFileName"/>' alt="No Image">
			</td>
		</tr>
		<tr>
			<td>
				Before
			</td>
			<td>

			</td>
			<td>
				After
			</td>
		</tr>
	</table>
	<button type="submit">登録</button>
	<s:hidden name="userImageFileName" value="%{#session.userImageFileName}"/>
	</s:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>