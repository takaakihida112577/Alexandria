<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>宛先新規登録画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<s:form action="CreateAddressConfirmAction">
<div id="createUser">
	<br>
	<br>
	<h1>新規宛先登録</h1>
	<h2>　宛先情報</h2>
		<table>
			<tr>
				<td>名前　<span>必須</span></td>
				<td>姓　</td>
				<td><s:textfield name="lastName" placeholder="例)田中" value="%{lastName}"/></td>
				<td>名　</td>
				<td><s:textfield name="firstName" placeholder="例)太郎" value="%{firstName}"/></td>
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
				<td><s:textfield name="lastNameKana" placeholder="例)タナカ"/>　</td>
				<td>名カナ　</td>
				<td><s:textfield name="firstNameKana" placeholder="例)タロウ"/></td>
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
				<td>メールアドレス　<span>必須</span></td>
				<td colspan="3"  class="creatUserTable"><s:textfield name="email" placeholder="例)sample@sample.jp"/></td>
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
			<tr>
				<td>電話番号　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:textfield name="telNumber" placeholder="例)000-0000-0000"/></td>
			<tr>
			<tr>
				<s:if test='!#session.telNumberErrorMessageList.isEmpty()'>
					<td colspan="4" style="color:red;">
						<s:iterator value="#session.telNumberErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<td>郵便番号　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:textfield name="postal" placeholder="例)000-0000"/></td>
			<tr>
			<tr>
				<s:if test='!#session.postalErrorMessageList.isEmpty()'>
					<td colspan="4" style="color:red;">
						<s:iterator value="#session.postalErrorMessageList">
							<s:property />
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<td>住所　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:textfield name="address" placeholder="例)東京都新宿区西新宿２丁目８−１"/></td>
			<tr>
			<tr>
				<s:if test='!#session.addressErrorMessageList.isEmpty()'>
					<td colspan="4" style="color:red;">
						<s:iterator value="#session.addressErrorMessageList">
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
</div>
</s:form>
<jsp:include page="footer.jsp"/>
</body>
</html>