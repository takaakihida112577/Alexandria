<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>パスワード再設定画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="createUser">
	<br>
	<br>
	<s:form action="ResetPasswordConfirmAction">
	<h1>パスワード再設定</h1>
	<h2>　パスワード情報</h2>
		<table align="center">
			<tr>
				<td>ユーザーID　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:textfield name="loginId" placeholder="ユーザーID"/></td>
			</tr>
			<tr>
				<s:if test='!#session.loginIdErrorMessageList.isEmpty()'>
					<td colspan="5" style="color:red;">
						<s:iterator value="#session.loginIdErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<td>パスワード　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:password name="password" placeholder="例)*****"/></td>
			<tr>
			<tr>
				<s:if test='!#session.passwordErrorMessageList.isEmpty()'>
					<td colspan="5" style="color:red;">
						<s:iterator value="#session.passwordErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<td>新しいパスワード　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:password name="newPassword"/></td>
			</tr>
			<tr>
				<s:if test='!#session.newPasswordErrorMessageList.isEmpty()'>
					<td colspan="5" style="color:red;">
						<s:iterator value="#session.newPasswordErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<td>新しいパスワード確認用　<span>必須</span></td>
				<td colspan="3"  class="creatUserTable"><s:password name="reConfirmationPassword"/></td>
			</tr>
			<tr>
				<s:if test='!#session.reConfirmationNewPasswordErrorMessageList.isEmpty()'>
					<td colspan="5" style="color:red;">
						<s:iterator value="#session.reConfirmationNewPasswordErrorMessageList">
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