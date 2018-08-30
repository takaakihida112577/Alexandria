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
<title>settlementConfirm</title>
<script type="text/javascript">
	function OnSettlementCompleteAction(){
		document.getElementById("form").action="SettlementCompleteAction";
		document.getElementById("form").submit();
	}

	function OnCreateAddressAction(){
		document.getElementById("form").action="CreateAddressAction";
		document.getElementById("form").submit();
	}

	function OnMyPagePointInfoAction(){
		document.getElementById("form").action="MyPagePointInfoAction";
		document.getElementById("form").submit();
	}
</script>
<script>
   $(document).ready(function(){
     $('.slider').bxSlider({
    	auto:false,
     	mode:'horizontal',
     	speed:2000,
        pager:true,
        controls:false,
     	slideWidth:450
     });
   });
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="settlementConfirm">
<s:form name="form" id="form">
<table cellspacing="30" align="center">
	<tr>
		<td><h2>商品情報</h2></td>
		<td><h2>宛先選択</h2></td>
	</tr>
	<tr>
		<td rowspan="3">
			<table id="settlementProduct" align="center" border="1" cellspacing="0">
				<tr>
					<th>商品画像</th>
					<th>商品</th>
					<th>単価</th>
					<th>個数</th>
					<th>小計</th>
				</tr>
				<s:iterator value="#session.historyInfoDTOList">
				<tr>
					<td>
						<img src='<s:property value="productImage"/>'>
					</td>
					<td>
						<s:property value="productName"/><br>
						[<s:property value="releaseDate"/>]/[<s:property value="releaseCompany"/>]
					</td>
					<td>
						<s:property value="price"/>
					</td>
					<td>
						<s:property value="productCount"/>
					</td>
					<td>
						<s:property value="subTotal"/>
					</td>
				</tr>
				</s:iterator>
			</table>
		</td>
		<td>
			<button type="button" onclick="OnCreateAddressAction()">新規登録</button>
			<div class="slider">
				<s:iterator value="#session.addressInfoDTOList" status="st">
					<div>
					<table border="1" cellspacing="0">
						<tr>
							<td rowspan="6">
								<s:if test='#st.index==0'>
									<input type="radio" name="id" checked="checked" value='<s:property value="id"/>'><br>
								</s:if>
								<s:else>
									<input type="radio" name="id" value='<s:property value="id"/>'><br>
								</s:else>
							</td>
							<td>名前</td>
							<td><s:property value="lastName"/>　<s:property value="firstName"/></td>
						</tr>
						<tr>
							<td>名前カナ</td>
							<td><s:property value="lastNameKana"/>　<s:property value="firstNameKana"/></td>
						</tr>
						<tr>
							<td>郵便番号</td>
							<td><s:property value="postal"/></td>
						</tr>
						<tr>
							<td>住所</td>
							<td><s:property value="address"/></td>
						</tr>
						<tr>
							<td>電話番号</td>
							<td><s:property value="telNumber"/></td>
						</tr>
						<tr>
							<td>メール</td>
							<td><s:property value="email"/></td>
						</tr>
					</table>
					</div>
				</s:iterator>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<h2>お支払い</h2>
			<br>
			<br>
			<table cellspacing="15" border="1" align="center">
				<tr>
					<td>保有ポイント</td>
					<s:if test='#session.point > #session.totalPrice'>
						<td>
							<s:property value="#session.point"/>
						</td>
					</s:if>
					<s:else>
						<td style="background-color:red; color:white;">
							<s:property value="#session.point"/>
						</td>
					</s:else>
				</tr>
				<tr>
					<td>合計金額</td>
					<td><s:property value="#session.totalPrice"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<s:if test='#session.point > #session.totalPrice'>
							<button type="button" onclick="OnSettlementCompleteAction()"><b>決済</b></button>
						</s:if>
						<s:else>
							<button type="button" onclick="OnMyPagePointInfoAction()"><b>ポイントチャージ</b></button>
						</s:else>
					</td>
				</tr>
			</table>
		</td>
	<tr>
</table>
<s:token/>
</s:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>