<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="categoryMenu">
	<ul>
	<s:iterator value="#session.masterCategoryDTOList" status="st">
		<s:if test='#st.index == #session.categoryId'>
			<li class="select">
				<a href="<s:url action='ProductListAction'><s:param name='categoryId' value='%{categoryId}'/></s:url>"><s:property value="categoryName"/></a>
			</li>
		</s:if>
		<s:else>
			<li>
				<a href="<s:url action='ProductListAction'><s:param name='categoryId' value='%{categoryId}'/></s:url>"><s:property value="categoryName"/></a>
			</li>
		</s:else>
	</s:iterator>
	</ul>
</div>
</body>
</html>