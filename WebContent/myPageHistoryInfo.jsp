<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>購入履歴画面</title>
<script type="text/javascript">
	//チェックの全選択,解除
	function allcheck( tf ) {
	   var ElementsCount = document.DeleteHistoryInfo.elements.length; // チェックボックスの数
	   for( i=0 ; i<ElementsCount ; i++ ) {
	      document.DeleteHistoryInfo.elements[i].checked = tf; // ON・OFFを切り替え
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
<s:form action="DeleteHistoryInfoAction" id="DeleteHistoryInfo">
<div id="mypageHistoryInfo">
	<div id="mypageUserInfo">
		<h1>購入履歴<br>Purchase history</h1>
	</div>
	<div>
	<table cellspacing="20">
		<tr>
			<s:iterator value="#session.historyInfoDTOList">
			<td>
				<table>
					<tr>
						<td colspan="2"><s:checkbox name="checkList" value="checked" fieldValue="%{id}"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<img src="./img/homeLogo.png" alt="タイトルロゴ" id="checkList">
						</td>
					</tr>
					<tr>
						<td colspan="2"><img src='<s:property value="productImage"/>'></td>
					</tr>
					<tr>
						<td>購入日</td>
						<td><s:property value="insertDate"/></td>
					</tr>
					<tr>
						<td>出版社</td>
						<td><s:property value="releaseCompany"/></td>
					</tr>
					<tr>
						<td>商品名</td>
						<td><s:property value="productName"/></td>
					</tr>
					<tr>
						<td>購入金額</td>
						<td><s:property value="price"/>pt</td>
					</tr>
					<tr>
						<td colspan="2"><h3><a href='<s:url action="CreateReviewAction"><s:param name="productId" value="%{productId}"/></s:url>'>レビュー投稿</a></h3></td>
					</tr>
				</table>
			</td>
			</s:iterator>
		</tr>
	</table>
	</div>
	<span id="checkAllButton"><button type="button" onclick="allcheck(true)">全選択</button></span>
	<button type="submit">購入履歴削除</button>
</div>
</s:form>
<!-- エラー出力画面
<s:if test='!#session.checkListErrorMessageList.isEmpty()'>
	<s:iterator value="#session.checkListErrorMessageList">
		<s:property /><br>
	</s:iterator>
</s:if>
<s:if test='#session.historyInfoDTOList==null'>
購入履歴はありません
</s:if>
<s:form action="DeleteHistoryInfoAction">
<s:iterator value="#session.historyInfoDTOList">
	<img src="./img/history3.png" width="100px" height="200px">
	<s:checkbox name="checkList" value="checked" fieldValue="%{id}"/>
	<s:property value="id"/>
	<s:property value="insertDate"/>
	<s:property value="productName"/>
	<s:property value="productImage"/>
	<s:property value="productCount"/>
	<s:property value="price"/>
	<s:property value="releaseCompany"/>
	<s:property value="releaseDate"/>
	<s:hidden name="id" value="%{id}"/>
	<a href='<s:url action="CreateReviewAction"><s:param name="productId" value="%{productId}"/></s:url>'>レビュー投稿</a>
</s:iterator>
<button type="submit">削除</button>
</s:form>
-->
<jsp:include page="footer.jsp"/>
</body>
</html>