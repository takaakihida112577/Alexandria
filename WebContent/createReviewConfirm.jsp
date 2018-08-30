<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>レビュー投稿確認画面</title>
</head>
<body>

<div id="reviewdiv">
	<div id="mypageUserInfo">
		<h1>レビュー投稿<br>Review</h1>
	</div>
	<div id="reviewForm">
		<s:form action="CreateReviewCompleteAction">
			<table border="1" cellspacing="0" align="center">
				<tr>
					<td>タイトル</td>
					<td><s:property value="reviewTitle"/></td>
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




<s:form action="CreateReviewCompleteAction">
レビュータイトル:<s:property value="reviewTitle"/>
評価:<s:property value="star"/>
レビュー内容:<s:property value="reviewText"/>
<s:hidden name="reviewTitle" value="%{reviewTitle}"/>
<s:hidden name="star" value="%{star}"/>
<s:hidden name="reviewText" value="%{reviewText}"/>
<s:hidden name="productId" value="%{productId}"/>
<s:submit value="投稿"/>
<s:token/>
</s:form>
<jsp:include page="footer.jsp"/>
</body>
</html>