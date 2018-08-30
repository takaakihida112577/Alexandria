<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ヘッダー画面</title>
<script type="text/javascript">
function OnCartAction(){
	document.getElementById("form").action="CartAction";
	document.getElementById("form").submit();
}

function OnMyPageAction(){
	document.getElementById("form").action="MyPageAction";
	document.getElementById("form").submit();
}

function OnGoLoginAction(){
	document.getElementById("form").action="GoLoginAction";
	document.getElementById("form").submit();
}

function OnGoLogoutAction(){
	document.getElementById("form").action="LogoutAction";
	document.getElementById("form").submit();
}
</script>
</head>
<body>
<div id="header">
	<a href="<s:url action='HomeAction'/>"><img src="./img/homeLogo.png" alt="タイトルロゴ"></a>
	<div id="headerRight">
		<s:form name="form" id="form">
		<div onclick="OnCartAction()">
			<p><b>カート</b></p>
			Cart
			<img src="./img/cart.png" alt="カート">
		</div>
		<s:if test='#session.logined==1'>
			<div onclick="OnMyPageAction()">
				<p><b>マイページ</b></p>
				Mypage
				<img src="./img/mypage.png" alt="マイページ">
			</div>
		</s:if>
		<s:if test='#session.logined==0'>
			<div onclick="OnGoLoginAction()">
				<p><b>ログイン</b></p>
				Login
				<img src="./img/login.png" alt="ログイン">
			</div>
		</s:if>
		<s:else>
			<div onclick="OnGoLogoutAction()">
				<p><b>ログアウト</b></p>
				Logout
				<img src="./img/login.png" alt="ログアウト">
			</div>
		</s:else>

		</s:form>
	</div>
</div>
</body>
</html>