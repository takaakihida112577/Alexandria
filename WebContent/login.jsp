<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ログイン画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="loginMenu">
	<s:form action="LoginAction">
	<table align="center">
			<tr>
				<td><img src="./img/homeLogo.png" alt="タイトルロゴ"></td>
			</tr>
			<tr>
				<td><s:textfield name="loginId" placeholder="UserID" autocomplete="off"/></td>
			</tr>
			<tr>
				<td><s:password name="password" placeholder="Password"  autocomplete="off"/></td>
			</tr>
			<tr>
				<td><button type="submit">ログイン</button></td>
			</tr>
	</table>
	</s:form>
	<h3><a href='<s:url action="CreateUserAction"></s:url>'>新規登録</a></h3>
	<h3><a href='<s:url action="ResetPasswordAction"></s:url>'>パスワード再設定</a></h3>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>