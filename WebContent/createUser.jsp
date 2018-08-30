<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ユーザー情報入力画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="createUser">
	<br>
	<br>
	<s:form action="CreateUserConfirmAction">
	<h1>新規ユーザー登録</h1>
	<h2>　ユーザー情報</h2>
		<table align="center">
			<tr>
				<td>名前　<span>必須</span></td>
				<td>姓　</td>
				<td><s:textfield name="lastName" placeholder="例)田中"/></td>
				<td>名　</td>
				<td><s:textfield name="firstName" placeholder="例)太郎"/></td>
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
				<td>生年月日　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:textfield name="birthday" placeholder="例)2000-11-11"/></td>
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
				<td>ユーザーID　<span>必須</span></td>
				<td colspan="3" class="creatUserTable"><s:textfield name="userId" placeholder="例)tanaka"/></td>
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
		</table>
	<h2>　宛先情報</h2>
		<table>
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
	<h2>　個人情報について</h2>
	<div id="rule">
		<ol>
			<li>第一項: 個人情報について、不正アクセス、紛失、漏洩等が発生しないよう管理責任者を定め、個人情報取り扱い規定を整備し、これらの危険に対する安全対策を積極的に実施します。</li>
			<li>第二項: 個人情報は、ご本人の同意がない限り第三者には提供いたしません。</li>
			<li>第三項: 個人情報は当社にて厳重に管理し当サイト使用以外の目的では使用いたしません。</li>
			<li>第四項: 個人情報は、法律に基づいた、警察等の行政機関や司法機関からの要請があった場合を除き、第三者には提供いたしません。</li>
			<li>第五項: 個人情報の取り扱いの全てもしくはその一部を外部に委託する場合、委託を受けた者に対して適切な監督を実施します。</li>
		</ol>
		<br>
		<input type="checkbox" name="ruleCheck" value="1"><span>上記の個人情報の取り扱いに同意します</span>
	</div>
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