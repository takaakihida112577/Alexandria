<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3;URL='HomeAction'">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>レビュー投稿完了画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="complete">
	<s:iterator value="#session.completeWordList">
		<span><s:property /></span>
	</s:iterator>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>