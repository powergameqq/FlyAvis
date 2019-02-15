<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/eDM.css" type="text/css" />

<script
	src="${pageContext.request.contextPath}/javascript/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/javascript/eDM.js"></script>

<c:set var='debug' value='true' scope='application' />
<table class='menuOuter'>
  <tr height="48px">
    <td width="60px" rowspan='2'>
    <h1 style="color: tomato;">FlyAvis</h1>
    </td>
    <td>
      <table class='menuInner' > 
        <tr>
          <td class='menuData'>
            <div class='menu'>
			  <c:if test="${empty LoginOK}">
				<a href="<c:url value='/login' />">
				     登入 
				</a>
              </c:if>
			</div>
		  </td>
		  <td class='menuData'>
			<div class='menu'>
			   <c:if test="${ funcName != 'BIL' }">
                  <a href="<c:url value='/build' />" >
				        建立新行程
				  </a>
			   </c:if>
			   <c:if test="${ funcName == 'BIL' }"> 
                                                 建立新行程
               </c:if>
			</div>
		  </td>
		  <td class='menuData'>
			<div class='menu'>
			  <c:if test="${ funcName != 'MTR' }">
			     <a href="<c:url value='/myTravel' />">
				     我的行程
				 </a>
			  </c:if>
			  <c:if test="${ funcName == 'MTR' }"> 
                                               我的行程
              </c:if>
			</div>
		  </td>
		  <td class='menuData'>
			<div class='menu'>
			  <c:if test="${ funcName != 'MBI' }">
				 <a href="<c:url value='/myBill' />">
				     查看預算
			     </a>
			  </c:if>
			  <c:if test="${ funcName == 'MBI' }"> 
                                                查看預算
              </c:if>
			</div>
		  </td>
		  <td class='menuData'>
			<div class='menu'>
		      <c:if test="${ funcName != 'ABM' }">
				<a href="<c:url value='/aboutMe' />">
                                             關於我們
                </a>
              </c:if>
			  <c:if test="${ funcName == 'ABM' }"> 
                                             關於我們
              </c:if>
			</div>
		  </td>
		  <td class='menuData'>
			<div class='menu'>
		       &nbsp;
			</div>
		  </td>
          
		  <td class='menuData'>
		  <div class='menu'>
			<c:if test="${ funcName != 'REG' }">
			   <a href="<c:url value='/test' />"> 註冊 </a>
			</c:if> 
			<c:if test="${ funcName == 'REG' }"> 
                                                     註冊
            </c:if>
            </div>
          </td>
		  <td class='menuData'>
		  <div class='menu' style='width:50px;'>
			<c:if test="${ funcName != 'IND' }">
			   <a href="<c:url value='/index' />"> 回首頁 </a>
			</c:if>
			
			</div>
		  </td>
		  
		  <td class='menuData'>
		  <div class='menu'>
			<c:if test="${ ! empty LoginOK }">
			   <a href="<c:url value='/logout' />">
  				登出 
	           </a>
			</c:if>
			</div>
		  </td>
		  <td class='menuData'>
		  <div class='menu'>
			<c:if test="${ ! empty LoginOK }">
			   歡迎${LoginOK.userName}
			</c:if>
			</div>
		  </td>
<!-- 		  <td class='menuData'> -->
<%--            	<c:if test="${! empty LoginOK }"> --%>
<!--                <img height='40px' width='30px' -->
<%-- 	src='${pageContext.request.contextPath}/_00_init/getImage?id=${LoginOK.memberId}&type=MEMBER'> --%>
	
<%-- 			</c:if> --%>
<!-- 		  </td>  -->
<!-- 		</tr> -->
		<tr height='20px'>
			<td width='300px' colspan='9'><small>${pageContext.session.id }</small>
			</td>
		</tr>
	  </table>
	<tr>
      <td>
	  <hr style="color: #f00; background-color: #f00; height: 2px;">
	  </td>
	</tr>
</table>