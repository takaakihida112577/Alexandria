<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>顔社員登録</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
  $('#userImage').change(function(e){
    //ファイルオブジェクトを取得する
    var file = e.target.files[0];
    var reader = new FileReader();

    //画像でない場合は処理終了
    if(file.type.indexOf("image") < 0){
      alert("画像ファイルを指定してください。");
      return false;
    }

    //アップロードした画像を設定する
    reader.onload = (function(file){
      return function(e){
        $("#afterImage").attr("src", e.target.result);
        $("#afterImage").attr("title", file.name);
      };
    })(file);
    reader.readAsDataURL(file);

  });
});
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="leftMenu.jsp"/>
<div id="pointinfo">
	<span>
	<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.loginIdErrorMessageList"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	</span>
	<s:form method="post" action="HeadShotsConfirmAction" enctype="multipart/form-data">
	<table cellspacing="0"align="center">
		<tr>
			<td>
				<img src='<s:property value="#session.faceShots"/>' alt="No Image">
			</td>
			<td>
				<b>→</b>
			</td>
			<td>
				<img src="" alt="No Image" id="afterImage" width="270px" height="270px"><br>
				<s:file name="userImage" id="userImage" accept='image/jpg, image/jpeg'/>
			</td>
		</tr>
		<tr>
			<td>
				Before
			</td>
			<td>

			</td>
			<td>
				After
			</td>
		</tr>
	</table>
	<button type="submit">登録</button>
	</s:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>