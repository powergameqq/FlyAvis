<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
$(document).ready(function(){
		$('#htext').css('color','tomato');
		function Member(userId, userName, userGoogleMail,userPhoto,userToken) {
			  this.userId = userId;
			  this.userName = userName;
			  this.userGoogleMail = userGoogleMail;
			  this.userPhoto = userPhoto;
			  this.userToken = userToken;
			 
			}
		var n = 0;
		var x = 0;
		var uid = 0;
		$('#checkUserTokenId').click(function(){
 			var account = new Member(null,'Tim','tim@gmail.com','http://tim.com','timtimtim'+1);
			var accountToJson = JSON.stringify(account);
			alert(accountToJson);
 			$.ajax({
 				type :'POST',
				url:'/FlyAvis/checkUserToken',
				contentType:'application/json',
				data:accountToJson,
 				dataType:'text',
 				success:function(data){
 					uid = data;
 					alert(uid);
//  					var str = '登入成功，會員ID為: ' + uid;
//  					$('#feedback').text(str);
 					window.location.replace("http://localhost:8080/FlyAvis/"+uid);
 					
 				},error:function(xhr, ajaxOptions, thrownError){
 					var str = '登入失敗';
 					$('#feedback').text(str);
 				}
 			});
 		});
		
	});
</script>
</head>
<body>
<c:set var="funcName" value="LOG" scope="session"/>
<c:set var="msg" value="登入" />
<c:if test="${ ! empty sessionScope.timeOut }" > <!-- 表示使用逾時，重新登入 -->
   <c:set var="msg" value="<font color='red'>${sessionScope.timeOut}</font>" />
</c:if>
<!-- 引入共同的頁首 -->
<jsp:include page="/WEB-INF/views/top.jsp" />

<br>
	<h1 id="htext">經由AJax傳送資訊:</h1>
	
	<button id="checkUserTokenId">以假帳號登入</button>
	<div id="feedback"></div>
</body>
</body>
</html>