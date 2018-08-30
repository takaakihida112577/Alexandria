<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ポイント画面</title>
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
	<s:if test="!#session.passwordErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="!#session.pointErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.pointErrorMessageList"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	</span>
	<s:form action="ChargePointConfirmAction">
	<table cellspacing="0"align="center">
		<tr>
			<td>
				<br>
				<img src="./img/point.png" alt="マイページ">
			</td>
			<td>
				<b>→</b>
			</td>
			<td>
				<img src="./img/mypage.png" alt="マイページ">
			</td>
		</tr>
		<tr>
			<td>
				チャージポイント
			</td>
			<td>

			</td>
			<td>
				保有ポイント
			</td>
		</tr>
		<tr>
			<td>
				<s:textfield name="point"/>
			</td>
			<td>

			</td>
			<td>
				<s:property value="#session.point"/>
			</td>
		</tr>
	</table>
	<table align="center">
		<tr>
		 	<td>ユーザーID</td>
		 	<td><s:textfield name="loginId"/></td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td><s:password name="password"/></td>
		</tr>
	</table>
	<button type="submit">チャージ</button>
	</s:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>