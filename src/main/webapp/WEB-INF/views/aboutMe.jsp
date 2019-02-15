<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>關於我們</title>
</head>
<body>
<c:set var="funcName" value="ABM" scope="session"/>
<c:set var="msg" value="關於我們" />
<!-- 引入共同的頁首 -->
<jsp:include page="/WEB-INF/views/top.jsp" />

</body>
</html>