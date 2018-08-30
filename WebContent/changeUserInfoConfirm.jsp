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
<div id="createUser">
	<br>
	<br>
	<s:form action="ChangeUserInfoCompleteAction">
	<h1>ユーザー情報変更</h1>
	<h2>　ユーザー情報</h2>
		<table align="center">
			<tr>
				<td>名前</td>
				<td>姓　</td>
				<td><s:property value="lastName"/></td>
				<td>名　</td>
				<td><s:property value="firstName"/></td>
			</tr>
			<tr>
				<td>名前カナ</td>
				<td>姓カナ　</td>
				<td><s:property value="lastNameKana"/>　</td>
				<td>名カナ　</td>
				<td><s:property value="firstNameKana"/></td>
			</tr>
			<tr>
				<td>生年月日</td>
				<td colspan="3" class="creatUserTable"><s:property value="birthday"/></td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td colspan="3"  class="creatUserTable"><s:property value="email"/></td>
			</tr>
		</table>
	<br>
	<h2></h2>
		<br>

		<button type="submit">登録</button>
		<br>
		<br>

		<s:hidden name="lastName" value="%{lastName}"/>
		<s:hidden name="firstName" value="%{firstName}"/>
		<s:hidden name="lastNameKana" value="%{lastNameKana}"/>
		<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
		<s:hidden name="birthday" value="%{birthday}"/>
		<s:hidden name="email" value="%{email}"/>
	</s:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>