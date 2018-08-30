<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>商品一覧画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="leftMenu.jsp"/>
<div id="rightMenu">
	<jsp:include page="category.jsp"/>
	<div id="productlist">
		<s:if test='#session.productInfoDTOList == null'>
			商品情報がありません
		</s:if>
		<s:else>
			<s:iterator value="#session.productInfoDTOList">
				<div class="list">
					<img src='<s:property value="productImage"/>'><br>
					<a href="<s:url action='ProductDetailsAction'><s:param name='productId' value='%{productId}'/><s:param name='categoryId' value="%{categoryId}" /></s:url>"><s:property value="productName"/></a><br>
					<s:property value="releaseCompany"/><br>
					<span>
					<s:if test='rank=="0"'>
						<b>☆☆☆☆☆</b>
					</s:if>
					<s:if test='rank=="1"'>
						<b>★☆☆☆☆</b>
					</s:if>
					<s:if test='rank=="2"'>
						<b>★★☆☆☆</b>
					</s:if>
					<s:if test='rank=="3"'>
						<b>★★★☆☆</b>
					</s:if>
					<s:if test='rank=="4"'>
						<b>★★★★☆</b>
					</s:if>
					<s:if test='rank=="5"'>
						<b>★★★★★</b>
					</s:if>
					</span><br>
					<s:property value="price"/>pt
				</div>
			</s:iterator>
				<div id="pagecss">
				<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
						<s:if test="#session.currentPageNo == #pageNo.count">
							<a class="pageNo"><s:property value="%{#pageNo.count}" />
							</a>
						</s:if>
						<s:else>
							<a class="pageNo"
								href="<s:url action='SerchProductAction'><s:param name='pageNo' value='%{#pageNo.count}'/><s:param name='categoryId' value='%{categoryId}'/><s:param name='keywords' value='%{keywords}'/></s:url>"><s:property
									value="%{#pageNo.count}" />
							</a>
						</s:else>
				</s:iterator>
				</div>
		</s:else>
	</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>