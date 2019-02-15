<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>JSON to unordered list using AJAX(jQuery)</title>
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
		$('#createUser').click(function(){
			n++;
 			var account = new Member(null,'Tim','tim@gmail.com','http://tim.com','timtimtim'+n);
			var accountToJson = JSON.stringify(account);
			alert(accountToJson);
 			$.ajax({
 				type :'POST',
				url:'/FlyAvis/editData/checkAccount',
				contentType:'application/json',
				data:accountToJson,
 				dataType:'text',
 				success:function(data){
 					uid = data;
 					var str = '建立成功，會員ID為: '+uid;
 					$('#feedback').text(str);
 				},error:function(xhr, ajaxOptions, thrownError){
 					var str = '建立失敗';
 					$('#feedback').text(str);
 				}
 			});
 		});
		
		$('#changeUserData').click(function(){
			x++;
 			var account = new Member(uid,'Tim','tim@gmail.com','http://tim.com'+x,'timtimtim'+n);
			var accountToJson = JSON.stringify(account);
			alert(accountToJson);
 			$.ajax({
 				type :'POST',
				url:'/FlyAvis/editData/updateAccount',
				contentType:'application/json',
				data:accountToJson,
 				dataType:'text',
 				success:function(data){
 					var newMem = JSON.parse(data);
 					var str = '成功修改信箱為: '+newMem.userGoogleMail;
 					$('#feedback').text(str);
 				},error:function(xhr, ajaxOptions, thrownError){
 					var str = '建立失敗';
 					$('#feedback').text(str);
 				}
 			});
 		});
	});
</script>
</head>
<body>
<c:set var="funcName" value="IND" scope="session"/>
<!-- 引入共同的頁首 -->
<jsp:include page="/WEB-INF/views/top.jsp" />
<br>
	<h1 id="htext">經由AJax傳送資訊:</h1>
	<button id="createUser">製作假帳號</button>
	<button id="changeUserData">修改假帳號</button>
	<div id="feedback"></div>
</body>
</html>