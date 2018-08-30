<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script>
   $(document).ready(function(){
     $('.slider').bxSlider({
    	auto:true,
     	mode:'horizontal',
     	speed:2000,
        pager:false,
     	slideWidth:1200
     });
   });
</script>
<title>ユーザー情報画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="leftMenu.jsp"/>
<br>
<div id="rightMenu">
	<div id="mypageUserInfo">
		<h1>ユーザー情報<br>User information</h1>
	</div>
	<div id="mypageUserInfoMenu">
		<table cellspacing="0">
			<tr>
				<td>ユーザー情報</td>
				<td>宛先情報</td>
			</tr>
		</table>
		<s:form action="ChangeUserInfoAction">
		<div class="userInfodiv">
			<table align="center" cellspacing="0" border="1">
			<tr>
				<td>名前</td>
				<td>姓　</td>
				<td><s:property value="#session.lastName"/></td>
				<td>名　</td>
				<td><s:property value="#session.firstName"/></td>
			</tr>
			<tr>
				<td>名前カナ</td>
				<td>姓カナ　</td>
				<td><s:property value="#session.lastNameKana"/>　</td>
				<td>名カナ　</td>
				<td><s:property value="#session.firstNameKana"/></td>
			</tr>
			<tr>
				<td>生年月日</td>
				<td colspan="3" class="creatUserTable"><s:property value="#session.birthday"/></td>
				<td rowspan="4"><button type="submit">変更</button></td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td colspan="3"  class="creatUserTable"><s:property value="#session.email"/></td>
			</tr>
			<tr>
				<td>ユーザーID</td>
				<td colspan="3" class="creatUserTable"><s:property value="#session.userId"/></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td colspan="3" class="creatUserTable">***************</td>
			<tr>
			</table>
		</div>
		</s:form>
		<div class="slider">
			<s:iterator value="#session.addressInfoDTOList">
			<s:form action="ChangeAddressInfoAction">
				<div>
					<table  cellspacing="0" border="1">
						<tr>
							<td>宛名</td>
							<td>姓　</td>
							<td><s:property value="lastName"/></td>
							<td>名　</td>
							<td><s:property value="firstName"/></td>
						</tr>
						<tr>
							<td>宛名カナ</td>
							<td>姓カナ　</td>
							<td><s:property value="lastNameKana"/>　</td>
							<td>名カナ　</td>
							<td><s:property value="firstNameKana"/></td>
						</tr>
						<tr>
							<td>メールアドレス</td>
							<td colspan="3"  class="creatUserTable"><s:property value="email"/></td>
							<td rowspan="4"><button type="submit">変更</button></td>
						</tr>
						<tr>
							<td>電話番号</td>
							<td colspan="3"  class="creatUserTable"><s:property value="telNumber"/></td>
						</tr>
						<tr>
							<td>郵便番号</td>
							<td colspan="3" class="creatUserTable"><s:property value="postal"/></td>
						</tr>
						<tr>
							<td>住所</td>
							<td colspan="3" class="creatUserTable"><s:property value="address"/></td>
						<tr>
					</table>
					<s:hidden name="id" value="%{id}"/>
					<s:hidden name="lastName" value="%{lastName}"/>
					<s:hidden name="firstName" value="%{firstName}"/>
					<s:hidden name="lastNameKana" value="%{lastNameKana}"/>
					<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
					<s:hidden name="email" value="%{email}"/>
					<s:hidden name="telNumber" value="%{telNumber}"/>
					<s:hidden name="postal" value="%{postal}"/>
					<s:hidden name="address" value="%{address}"/>
				</div>
			</s:form>
			</s:iterator>
		</div>
		<br>
		<div style="text-align:center; background-color:rgba(137,189,222,0.4); border-radius:10px;">
			<a href='<s:url action="HeadShotsAction"></s:url>'><img src="./img/mypage.png" alt="マイページ" width="300px" height="300px"><br>顔写真登録</a>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>