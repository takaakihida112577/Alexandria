<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>パスワード再設定確認画面</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="createUser">
	<br>
	<br>
	<s:form action="ResetPasswordCompleteAction">
	<h1>パスワード再設定確認</h1>
	<h2>　パスワード情報</h2>
		<table align="center">
			<tr>
				<td>ユーザーID　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:property value="#session.loginId"/></td>
			</tr>
			<tr>
				<td>パスワード　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:property value="#session.concealPassword"/></td>
			<tr>
		</table>
	<br>
	<h2></h2>
		<br>
		<button type="submit">確認画面</button>
		<br>
		<br>
	<s:token/>
	</s:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>