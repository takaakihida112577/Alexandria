<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>レフトメニュー画面</title>
</head>
<body>
<div id="leftMenu">
	<div id="account">
		<s:if test='#session.faceShots == null'>
			<img src="./img/mypage.png"><br>
		</s:if>
		<s:else>
			<img src='<s:property value="#session.faceShots"/>' alt="No Image"><br>
		</s:else>
		<s:if test='#session.loginId==null'>
			<span>
				<s:if test='#session.logined==0'>
					ゲストさん
				</s:if>
				<s:else>
					<s:property value="#session.loginId"/>さん
				</s:else>
			</span>
			<br>
			<span>保有ポイント:0pt</span>
		</s:if>
		<s:else>
			<s:property value="#session.loginId"/>
			<br>
			<span>保有ポイント:<s:property value="#session.point"/></span>pt
		</s:else>
	</div>
	<h3><b>検索メニュー</b></h3>
	<s:form action="SerchProductAction">
		<select name="categoryId">
			<option value="0" selected>全ての商品</option>
			<s:iterator value="#session.masterCategoryDTOList">
				<option value='<s:property value="categoryId"/>'><s:property value="categoryName"/></option>
			</s:iterator>
		</select><br>
		<input type="text" name="keywords"/>
		<button type="submit">検索</button>
	</s:form>
	<br>
	<h3 style="background-color:green"><b>人気商品</b></h3>
	<div id="ranking" style="width:100%">
		<s:iterator value="#session.productInfoDTOListByRank" status="rankNo">
			<s:if test='#rankNo.count==1'>
				<div class="rankinglist">
				<p style="color:red"><b>No.<s:property value="#rankNo.count"/></b></p>
					<a href="<s:url action='ProductDetailsAction'><s:param name='productId' value='%{productId}'/><s:param name='categoryId' value="%{categoryId}" /></s:url>"><img src='<s:property value="productImage"/>'><br><s:property value="productName"/></a><br>
					<s:property value="releaseCompany"/><br>
				</div>
			</s:if>
			<s:if test='#rankNo.count==2'>
				<div class="rankinglist">
				<p style="color:blue"><b>No.<s:property value="#rankNo.count"/></b></p>
					<a href="<s:url action='ProductDetailsAction'><s:param name='productId' value='%{productId}'/><s:param name='categoryId' value="%{categoryId}" /></s:url>"><img src='<s:property value="productImage"/>'><br><s:property value="productName"/></a><br>
					<s:property value="releaseCompany"/><br>
				</div>
			</s:if>
			<s:if test='#rankNo.count==3'>
				<div class="rankinglist">
				<p style="color:green"><b>No.<s:property value="#rankNo.count"/></b></p>
					<a href="<s:url action='ProductDetailsAction'><s:param name='productId' value='%{productId}'/><s:param name='categoryId' value="%{categoryId}" /></s:url>"><img src='<s:property value="productImage"/>'><br><s:property value="productName"/></a><br>
					<s:property value="releaseCompany"/><br>
				</div>
			</s:if>
		</s:iterator>
	</div>
</div>
</body>
</html>