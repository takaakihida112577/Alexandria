<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Insert title here</title>
<script type="text/javascript">
	function OnDeleteAction(){
		document.getElementById("cartform").action = "DeleteCartAction";
		document.getElementById("cartform").submit();
	}

	function OnSettlementConfirmAction(){
		document.getElementById("cartform").action = "SettlementConfirmAction";
		document.getElementById("cartform").submit();
	}

	//チェックの全選択,解除
	function allcheck( tf ) {
	   var ElementsCount = document.cartform.elements.length; // チェックボックスの数
	   for( i=0 ; i<ElementsCount ; i++ ) {
	      document.cartform.elements[i].checked = tf; // ON・OFFを切り替え
	   }

	   if(tf){
		   document.getElementById("checkAllButton").innerHTML = '<button type="button" onclick="allcheck(false)">全解除</button>';
	   }else{
		   document.getElementById("checkAllButton").innerHTML = '<button type="button" onclick="allcheck(true)">全選択</button>';
	   }
	}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="leftMenu.jsp"/>
<div id="rightMenu">
	<div id="cart">
		<h1>
			カート<br>Cart
		</h1>
		<s:if test='#session.cartInfoDTOList==null'>
			カートは空です
		</s:if>
		<s:else>
			<!-- エラー出力画面 -->
		<s:if test='!#session.checkListErrorMessageList.isEmpty()'>
			<s:iterator value="#session.checkListErrorMessageList">
				<span><s:property /><br></span>
			</s:iterator>
		</s:if>
		<button onclick="OnSettlementConfirmAction()">決済</button>
		<button onclick="OnDeleteAction()">削除</button>
		<form name="cartform" id="cartform">
			<table align="center" border="1" cellspacing="0">
				<tr>
					<th id="checkAllButton"><button type="button" onclick="allcheck(true)">全選択</button></th>
					<th>画像</th>
					<th>商品名</th>
					<th>価格</th>
					<th>個数</th>
					<th>小計</th>
				</tr>
				<s:iterator value="#session.cartInfoDTOList">
					<tr>
						<td><s:checkbox name="checkList" value="checked" fieldValue="%{id}"/></td>
						<td><img src='<s:property value="productImage"/>' width="100px" height="120px"></td>
						<td><s:property value="productName"/></td>
						<td><s:property value="price"/></td>
						<td><s:property value="productCount"/></td>
						<td><s:property value="subTotal"/></td>
						<s:hidden name="id" value="%{id}"/>
						<s:hidden name="userId" value="%{userId}"/>
						<s:hidden name="tempUserId" value="%{tempUserId}"/>
						<s:hidden name="productId" value="%{productId}"/>
						<s:hidden name="productCount" value="%{productCount}"/>
						<s:hidden name="price" value="%{price}"/>
						<s:hidden name="productName" value="%{productName}"/>
						<s:hidden name="productImage" value="%{productImage}"/>
						<s:hidden name="releaseCompany" value="%{releaseCompany}"/>
						<s:hidden name="releaseDate" value="%{releaseDate}"/>
						<s:hidden name="productShortDescription" value="%{productShortDescription}"/>
						<s:hidden name="productDescription" value="%{productDescription}"/>
						<s:hidden name="subTotal" value="%{subTotal}"/>
					</tr>
				</s:iterator>
		</table>
		<s:hidden name="settlementFlg" value="%{'cart'}"/>
		</form>
		</s:else>
	</div>
</div>


<!-- エラー出力画面
<s:if test='!#session.checkListErrorMessageList.isEmpty()'>
	<s:iterator value="#session.checkListErrorMessageList">
		<s:property /><br>
	</s:iterator>
</s:if>
<s:if test='#session.cartInfoDTOList==null'>
カートは空です
</s:if>
<s:else>
<form name="form" id="form">
<s:iterator value="#session.cartInfoDTOList">
	<s:checkbox name="checkList" value="checked" fieldValue="%{id}"/>
	商品名:<s:property value="productName"/><br>
	商品画像:<s:property value="productImage"/><br>
	商品金額:<s:property value="price"/><br>
	商品個数:<s:property value="productCount"/><br>
	<s:hidden name="id" value="%{id}"/>
	<s:hidden name="userId" value="%{userId}"/>
	<s:hidden name="tempUserId" value="%{tempUserId}"/>
	<s:hidden name="productId" value="%{productId}"/>
	<s:hidden name="productCount" value="%{productCount}"/>
	<s:hidden name="price" value="%{price}"/>
	<s:hidden name="productName" value="%{productName}"/>
	<s:hidden name="productImage" value="%{productImage}"/>
	<s:hidden name="releaseCompany" value="%{releaseCompany}"/>
	<s:hidden name="releaseDate" value="%{releaseDate}"/>
	<s:hidden name="productShortDescription" value="%{productShortDescription}"/>
	<s:hidden name="productDescription" value="%{productDescription}"/>
	<s:hidden name="subTotal" value="%{subTotal}"/>
</s:iterator>

<s:hidden name="settlementFlg" value="%{'cart'}"/>
<button onclick="OnSettlementConfirmAction()">決済</button>

<button onclick="OnDeleteAction()">削除</button>
</form>
</s:else>
-->
<jsp:include page="footer.jsp"/>
</body>
</html>