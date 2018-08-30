<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ユーザー情報変更画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="createUser">
	<br>
	<br>
	<s:form action="ChangeUserInfoConfirmAction">
	<h1>ユーザー情報変更</h1>
	<h2>　ユーザー情報</h2>
		<table align="center">
			<tr>
				<td>名前　<span>必須</span></td>
				<td>姓　</td>
				<td><s:textfield name="lastName" placeholder="例)田中" value="%{#session.lastName}"/></td>
				<td>名　</td>
				<td><s:textfield name="firstName" placeholder="例)太郎" value="%{#session.firstName}"/></td>
			</tr>
			<tr>
				<s:if test='!#session.lastNameErrorMessageList.isEmpty()'>
					<td colspan="5" style="color:red;">
						<s:iterator value="#session.lastNameErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<s:if test='!#session.firstNameErrorMessageList.isEmpty()'>
					<td colspan="5" style="color:red;">
						<s:iterator value="#session.firstNameErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<td>名前カナ　<span>必須</span></td>
				<td>姓カナ　</td>
				<td><s:textfield name="lastNameKana" placeholder="例)タナカ" value="%{#session.lastNameKana}"/>　</td>
				<td>名カナ　</td>
				<td><s:textfield name="firstNameKana" placeholder="例)タロウ" value="%{#session.firstNameKana}"/></td>
			</tr>
			<tr>
				<s:if test='!#session.lastNameKanaErrorMessageList.isEmpty()'>
					<td colspan="5" style="color:red;">
						<s:iterator value="#session.lastNameKanaErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<s:if test='!#session.firstNameKanaErrorMessageList.isEmpty()'>
					<td colspan="5" style="color:red;">
						<s:iterator value="#session.firstNameKanaErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<td>生年月日　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:textfield name="birthday" placeholder="例)2000-11-11" value="%{#session.birthday}"/></td>
			</tr>
			<tr>
				<s:if test='!#session.birthdayErrorMessageList.isEmpty()'>
					<td colspan="5" style="color:red;">
						<s:iterator value="#session.birthdayErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<td>メールアドレス　<span>必須</span></td>
				<td colspan="3"  class="creatUserTable"><s:textfield name="email" placeholder="例)sample@sample.jp" value="%{#session.email}"/></td>
			</tr>
			<tr>
				<s:if test='!#session.emailErrorMessageList.isEmpty()'>
					<td colspan="5" style="color:red;">
						<s:iterator value="#session.emailErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
		</table>
	<br>
	<h2></h2>
		<br>
		<button type="submit">確認画面</button>
		<br>
		<br>
	</s:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>