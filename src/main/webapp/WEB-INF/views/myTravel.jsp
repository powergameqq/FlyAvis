<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的行程</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#htext').css('color','tomato');
		function MyTrip(tripId, tripName, tripDate,tripViews,tripLike,userId,tripPrivate,createtime,tripPhoto,teamMember,planDetail) {
			this.tripId = tripId;
			this.tripName = tripName;
			this.tripDate = tripDate;
			this.tripViews = tripViews;
			this.tripLike = tripLike;
			this.userId = userId;
			this.tripPrivate = tripPrivate;
			this.createtime = createtime;
			this.tripPhoto = tripPhoto;
			this.teamMember = teamMember;
			this.planDetail = planDetail;
			 
			}
		var n = 0;
		var x = 0;
		var uid = 0;
		$('#createTravel').click(function(){
			n++;
			var account = new MyTrip(null, "TEST01","2019-02-15",0,0,${LoginOK.userId},false,"2019-02-15",null,null,null)
//  			var account = new Member(null,'Tim','tim@gmail.com','http://tim.com','timtimtim'+n);
			var accountToJson = JSON.stringify(account);
			alert(accountToJson);
 			$.ajax({
 				type :'POST',
				url:'/FlyAvis/editData/createTravel',
				contentType:'application/json',
				data:accountToJson,
 				dataType:'text',
 				success:function(data){
 					uid = data;
 					var str = '建立成功，ID為: '+uid;
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
<c:set var="funcName" value="MTR" scope="session"/>
<c:set var="msg" value="我的行程" />
<!-- 引入共同的頁首 -->
<jsp:include page="/WEB-INF/views/top.jsp" />
<br>
	<h1 id="htext">經由AJax傳送資訊:</h1>
	<button id="createTravel">製作假行程</button>
	<div id="feedback"></div>

</body>
</html>