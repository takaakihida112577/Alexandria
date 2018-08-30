<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>レビュー画面</title>
</head>
<body>
	<div id="review">
		<br>
		<br>
		<s:iterator value="#session.reviewInfoDTOList">
			<table cellspacing="2">
				<tr>
					<td rowspan="3">
						<img src="./img/mypage.png" alt="マイページ"><br>
						<span><s:property value="userId"/></span>
					</td>
					<td><s:property value="reviewTitle"/>　[<s:property value="insertDate"/>]</td>
				</tr>
				<tr>
					<td>
						<s:if test='star=="0"'>
							<b>☆☆☆☆☆</b>
						</s:if>
						<s:if test='star=="1"'>
							<b>★☆☆☆☆</b>
						</s:if>
						<s:if test='star=="2"'>
							<b>★★☆☆☆</b>
						</s:if>
						<s:if test='star=="3"'>
							<b>★★★☆☆</b>
						</s:if>
						<s:if test='star=="4"'>
							<b>★★★★☆</b>
						</s:if>
						<s:if test='star=="5"'>
							<b>★★★★★</b>
						</s:if>
					</td>
				</tr>
				<tr>
					<td><s:property value="reviewText"/></td>
				</tr>
			</table>
		</s:iterator>
	</div>
</body>
</html>