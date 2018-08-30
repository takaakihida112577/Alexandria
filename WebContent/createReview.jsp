<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>レビュー投稿画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="leftMenu.jsp"/>
<!-- エラーメッセージリスト

-->

<div id="reviewdiv">
	<div id="mypageUserInfo">
		<h1>レビュー投稿<br>Review</h1>
	</div>
	<div id="reviewForm">
	<s:if test='!#session.reviewTextErrorMessageList.isEmpty()'>
		<s:iterator value="#session.reviewTextErrorMessageList">
			<s:property />
		</s:iterator>
	</s:if>
	<s:if test='!#session.reviewTitleErrorMessageList.isEmpty()'>
		<s:iterator value="#session.reviewTitleErrorMessageList">
			<s:property />
		</s:iterator>
	</s:if>
	<s:if test='!#session.starErrorMessageList.isEmpty()'>
			<s:iterator value="#session.reviewTitleErrorMessageList">
				<s:property />
			</s:iterator>
		</s:if>
		<s:form action="CreateReviewConfirmAction">
			<table border="1" cellspacing="0" align="center">
				<tr>
					<td>タイトル(30字以内)</td>
					<td><s:textfield name="reviewTitle"/></td>
				</tr>
				<tr>
					<td>評価</td>
					<td>
						<div>
						<input type="radio" name="star" id="star1" value="5">
						<label for="star1"><span>★</span></label>
						<input type="radio" name="star" id="star2" value="4">
						<label for="star2"><span>★</span></label>
						<input type="radio" name="star" id="star3" value="3">
						<label for="star3"><span>★</span></label>
						<input type="radio" name="star" id="star4" value="2">
						<label for="star4"><span>★</span></label>
						<input type="radio" name="star" id="star5" value="1">
						<label for="star5"><span>★</span></label>
						</div>
					</td>
				</tr>
				<tr>
					<td>レビュー(255字以内)</td>
					<td><s:textarea name="reviewText"/></td>
				</tr>
			</table>
			<s:hidden name="productId" value="%{productId}"/>
			<button type="submit">投稿</button>
		</s:form>
	</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>