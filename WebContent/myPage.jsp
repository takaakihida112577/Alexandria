<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>マイページ画面</title>
<script>
	function OnMyPageUserInfoAction(){
		document.getElementById("form").action="MyPageUserInfoAction";
		document.getElementById("form").submit();
	}
	function OnMyPageHistoryInfoAction(){
		document.getElementById("form").action="MyPageHistoryInfoAction";
		document.getElementById("form").submit();
	}
	function OnMyPagePointInfoAction(){
		document.getElementById("form").action="MyPagePointInfoAction";
		document.getElementById("form").submit();
	}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="mypage">
	<h1>マイページ<br>Account</h1>
</div>
<div id="mypageMenu">
	<button type="button" onclick="OnMyPageUserInfoAction()"><h1>ユーザー情報</h1><br><br><br><h3>User information</h3><img src="./img/mypage.png" alt="マイページ"></button>
	<button type="button" onclick="OnMyPageHistoryInfoAction()"><h1>購入履歴</h1><br><br><br><h3>Purchase history</h3><img src="./img/history.png" alt="マイページ"></button>
	<button type="button" onclick="OnMyPagePointInfoAction()"><h1>ポイント</h1><br><br><br><h3>Point</h3><img src="./img/point.png" alt="マイページ"></button>
</div>
<!--
<form name="form" id="form">
<button type="button" onclick="OnMyPageUserInfoAction()">ユーザー情報</button>
<button type="button" onclick="OnMyPageHistoryInfoAction()">購入履歴</button>
<button type="button" onclick="OnMyPagePointInfoAction()">ポイントチャージ</button>
</form>
 -->
 <jsp:include page="footer.jsp"/>
</body>
</html>