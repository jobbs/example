<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="message.site.title"/></title>
<style type="text/css">
*{ margin:0; padding:0;}
.wrap{ width:100%; height:100%; /* background-image:url(landscape.jpg); */ background-position:center center; background-repeat:no-repeat; background-size:cover; position:fixed;}
.login_box{ width:500px; height:100%; margin-left:30px; background-color:#000; opacity:0.7;}
.login_box .logo{ text-align:center; padding-top:150px;}
.login_box .text2{ color:#fff; text-align:center; padding-top:20px;}
.login_box .text3{ color:#fff; padding-top:60px; text-align:center;font-family:sans-serif;}
.login_box .text4{padding-top:10px; text-align:center;}
.login_box .text4 .pp{ width:250px; height:30px; font-size:20px; color:#666; padding-left:10px;}
.login_box .text5{ color:#fff; padding-top:20px; text-align:center; font-family:sans-serif;}
.login_box .text6{ text-align:center; margin-top:80px;}
.login_box .text6 .login { display:inline-block; padding:10px 30px; border:1px solid #fff; color:#7f7f7f; font-size:30px;}
.login_box .text6 .login:hover { display:inline-block; padding:10px 30px; border:1px solid #fff; background:#fff; color:#000; font-size:30px;}
</style>
</head>
<body>
	<div class="wrap">
		<div class="login_box">
			<form name="loginFrm" id="loginFrm" action="<c:url value="/super/login/superUserProcess" />" method="post">
		    	<p class="logo"><!-- <img src="/resources/images/common/company_top_logo.jpg" alt="로고" /> --></p>
		        <p class="text2"><!-- 아이디와 패스워드를 입력해주세요 --></p>
		        <p class="text3">USER NAME</p>
		        <p class="text4"><input type="text" name="userId" class="pp" style="ime-mode:disabled" value=""  placeholder=""/></p>
		        <p class="text5">PASSWORD</p>
		        <p class="text4"><input type="password" name="userPass" class="pp"/></p>
		        <p class="text6"><input type="submit" value="Login" class="login"/></p>
	        </form>
		</div>
	</div>
</body>
</html>