<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>商品詳細画面</title>
<script type="text/javascript">
	function OnSettlementConfirmAction(){
		document.getElementById("productDetailsform").action = "SettlementConfirmAction";
		document.getElementById("productDetailsform").submit();
	}

	function OnAddCartAction(){
		document.getElementById("productDetailsform").action = "AddCartAction";
		document.getElementById("productDetailsform").submit();
	}

	function OnReview(){
		document.getElementById("reviewbutton").style.visibility = "hidden";
		document.getElementById("reviewDIV").style.visibility = "visible";
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<jsp:include page="leftMenu.jsp"/>
	<div id="rightMenu">
		<jsp:include page="category.jsp"/>
		<div id="productdetails">
			<div id="imagedetails">
				<img src='<s:property value="#session.productImage"/>'>
			</div>
			<div id="maindetails">
				<h2><s:property value="#session.productName"/><br>[<s:property value="#session.releaseDate"/>　<s:property value="#session.releaseCompany"/>]</h2>
				<span>
					<s:if test='#session.rank=="0"'>
						<b>☆☆☆☆☆</b>
					</s:if>
					<s:if test='#session.rank=="1"'>
						<b>★☆☆☆☆</b>
					</s:if>
					<s:if test='#session.rank=="2"'>
						<b>★★☆☆☆</b>
					</s:if>
					<s:if test='#session.rank=="3"'>
						<b>★★★☆☆</b>
					</s:if>
					<s:if test='#session.rank=="4"'>
						<b>★★★★☆</b>
					</s:if>
					<s:if test='#session.rank=="5"'>
						<b>★★★★★</b>
					</s:if>
				</span>
				<h3>あらすじ</h3>
				<span><s:property value="#session.productShortDescription"/></span>
				<h3>内容</h3>
				<span><s:property value="#session.productDescription"/></span>
			</div>
			<div id="procedure">
				<form name="productDetailsform" id="productDetailsform">
					<!-- 商品情報を送ります -->
					<!-- 仮のカートIDとcheckListを送信します -->
					<s:hidden name="id" value="%{'0'}"/>
					<s:hidden name="checkList" value="%{'0'}"/>
					<s:hidden name ="productId" value="%{#session.productId}"/>
					<s:hidden name ="productName" value="%{#session.productName}"/>
					<s:hidden name ="productShortDescription" value="%{#session.productShortDescription}"/>
					<s:hidden name ="productDescription" value="%{#session.productDescription}"/>
					<s:hidden name ="productImage" value="%{#session.productImage}"/>
					<s:hidden name ="price" value="%{#session.price}"/>
					<s:hidden name ="releaseDate" value="%{#session.releaseDate}"/>
					<s:hidden name ="releaseCompany" value="%{#session.releaseCompany}"/>

					<span><s:property value="#session.price"/>pt</span><br><br>
					購入個数<s:select name="productCount" list="%{#session.productCountList}"/>冊<br><br>
					<button type="button" onclick="OnSettlementConfirmAction()">購入<br>Purchase</button>
					<button type="button" onclick="OnAddCartAction()">カート<br>Cart</button>
				</form>
			</div>
			<div id="relevance">
				<br>
				<br>
				<h2>関連書籍</h2>
				<table align="center">
					<tr>
						<s:iterator value="#session.productInfoListRelevance">
							<td>
								<a href="<s:url action='ProductDetailsAction'><s:param name='productId' value='%{productId}'/><s:param name='categoryId' value="%{categoryId}" /></s:url>"><img src='<s:property value="productImage"/>'></a><br>
							</td>
						</s:iterator>
					</tr>
					<tr>
						<s:iterator value="#session.productInfoListRelevance">
							<td>
								<s:property value="productName"/><br>
								<s:property value="releaseCompany"/><br>
								<s:property value="price"/>pt
							</td>
						</s:iterator>
					</tr>
				</table>
			</div>
			<jsp:include page="review.jsp"/>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>