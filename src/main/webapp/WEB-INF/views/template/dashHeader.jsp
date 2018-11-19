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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<c:set var="menu" value="${menu:getCurrentMenuByCd(20) }" />
<c:set var="subMenuList" value="${menu.subMenuList }"></c:set>

<c:set var="currentMenu" value="${menu:getCurrentMenu(requestScope['javax.servlet.forward.request_uri'],pageContext.request.contextPath) }" />
<c:set var="menuLocation" value="${currentMenu.location }"></c:set>

<nav class="navbar navbar-menus dashboard" role="navigation">

	<div class="navbar-logo">
		<a href="<c:url value="/dsb/" />"><b>Cloud</b>통합관리시스템<span>대시보드</span></a>
	</div>
	<div class="navbar-left">
		<ul class="navbar-menu">
			<c:forEach var="topMenu" items="${subMenuList }">
				<li <c:if test="${menuLocation[2].menuSeq eq topMenu.menuSeq }"> class="active"</c:if>>
					<a href="<c:url value="${topMenu.realUrl }" />"><c:out value="${topMenu.menuNm }" /></a>
				</li>
			</c:forEach>
			<li class="menu-all"><a href="#" data-toggle="collapse" data-target=".navbar-menu-all">전체메뉴</a></li>
		</ul>
		<div class="navbar-menu-all collapse">
			<ul>
				<c:forEach var="subMenu" items="${subMenuList }">
					<li>
						<h5><c:out value="${subMenu.menuNm }" /></h5>
						<ul>
							<c:forEach var="child" items="${subMenu.subMenuList }" varStatus="secondStatus">
							<li><a href="<c:url value="${child.realUrl }" />"><c:out value="${child.menuNm }" /></a></li>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
			</ul>
		</div>
		<script>
			//전체메뉴 하위메뉴 가로사이즈 적용
			$(function(){
					var allMenu_ul = $('.navbar-menu-all').children('ul');
					var allMenu_li = allMenu_ul.children('li');
					var width_data = 100/(allMenu_li.length);
					var width = width_data + "%";
					allMenu_li.each(function(index){
						$(this).css({"width":width});
					});
			});
		</script>
	</div>

	<div class="navbar-right">
		<div class="input-group pull-right">
			<!-- <input type="text" name="table_search" class="form-control input-sm pull-right" placeholder="Search">
			<div class="input-group-btn">
				<button class="btn btn-sm btn-default">
					<i class="fa fa-search"></i>
				</button>
			</div> -->
		</div>
	</div>
</nav>

<script>
$(function(){
	  $(".navbar-tap li.dashboard").addClass("active").siblings("li").removeClass("active");
});
</script>