<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ユーザー登録確認画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="createUser">
	<br>
	<br>
	<s:form action="CreateUserCompleteAction">
	<h1>新規ユーザー登録</h1>
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
			<tr>
				<td>ユーザーID</td>
				<td colspan="3" class="creatUserTable"><s:property value="userId"/></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td colspan="3" class="creatUserTable"><s:property value="password"/></td>
			<tr>
		</table>
	<h2>　宛先情報</h2>
		<table>
			<tr>
				<td>電話番号</td>
				<td colspan="3" class="creatUserTable"><s:property value="telNumber"/></td>
			</tr>
			<tr>
				<td>郵便番号</td>
				<td colspan="3" class="creatUserTable"><s:property value="postal"/></td>
			</tr>
			<tr>
				<td>住所</td>
				<td colspan="3" class="creatUserTable"><s:property value="address"/></td>
			<tr>
		</table>
	<h2>　個人情報について</h2>
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
	<s:hidden name="userId" value="%{userId}"/>
	<s:hidden name="password" value="%{password}"/>
	<s:hidden name="telNumber" value="%{telNumber}"/>
	<s:hidden name="postal" value="%{postal}"/>
	<s:hidden name="address" value="%{address}"/>
	<s:token/>
	</s:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>