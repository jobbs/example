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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<c:set var="currentMenu" value="${menu:getCurrentMenu(requestScope['javax.servlet.forward.request_uri'],pageContext.request.contextPath) }"/>

<c:set var="topMenuByMenuId" value="${menu:getTopMenu(currentMenu.menuSeq) }"></c:set>
<c:set var="subMenuList" value="${topMenuByMenuId.subMenuList }"></c:set>
<c:set var="menuLocation" value="${currentMenu.location }"></c:set>

<aside class="left-side" id="left-side">
	<section class="sidebar">
		<div class="box menu-box">
			<div class="box-header">
				<h3 class="box-title"><i class="ci ci-boxes"></i>${menuLocation[2].menuNm }</h3>
				<!-- <div class="box-tools pull-right">
					<button class="btn btn-sm" data-toggle="collapse" data-target="#menu-list"><i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기"></i></button>
				</div> -->
			</div>
			<div class="box-body collapse in" id="menu-list">
				<ul class="sidebar-menu">

					<c:forEach var="subMenu" items="${subMenuList }" varStatus="firstStatus">
					<li class="<c:if test="${currentMenu.menuSeq eq subMenu.menuSeq or menuLocation[3].menuSeq eq subMenu.menuSeq}">active</c:if>">

						<c:choose>
							<c:when test="${fn:length(subMenu.subMenuList) eq 0 }">
								<a href="<c:url value="${subMenu.realUrl }" />"><span><c:out value="${subMenu.menuNm }" /></span></a>
							</c:when>
							<c:otherwise>
								<a href="#"><span><c:out value="${subMenu.menuNm }" /></span></a>
							</c:otherwise>
						</c:choose>

						<c:if test="${fn:length(subMenu.subMenuList) > 0 }">
						<ul class="treeview-menu">
							<c:forEach var="child" items="${subMenu.subMenuList }" varStatus="secondStatus">
							<li class="<c:if test="${currentMenu.menuSeq eq child.menuSeq or menuLocation[4].menuSeq eq child.menuSeq}">active</c:if>">

								<c:choose>
									<c:when test="${fn:length(child.subMenuList) eq 0 }">
										<c:choose>
											<c:when test="${child.popupYn eq 'Y' }">
												<a href="<c:out value="javascript:fn_popupmenu('${child.realUrl }','${child.menuFile }')" />"><span><c:out value="${child.menuNm }" /></span></a>
											</c:when>
											<c:otherwise>
												<a href="<c:url value="${child.realUrl }" />"><span><c:out value="${child.menuNm }" /></span></a>
											</c:otherwise>
										</c:choose>

									</c:when>
									<c:otherwise>
										<a href="#"><span><c:out value="${child.menuNm }" /></span></a>
									</c:otherwise>
								</c:choose>

								<c:if test="${fn:length(child.subMenuList) > 0 }">
								<ul class="treeview-menu">
									<c:forEach var="childSub" items="${child.subMenuList }" varStatus="csi">
									<li><a href="<c:url value="${childSub.realUrl }" />"><c:out value="${childSub.menuNm }" /></a></li>
									</c:forEach>
								</ul>
								</c:if>
							</li>
							</c:forEach>
						</ul>

						</c:if>
					</li>
					</c:forEach>

				</ul>
			</div>	<!-- /box-body -->
		</div> <!-- /box -->
	</section>

</aside>

<script>
function fn_popupmenu(url,keyname)
{
	var searchParams = "";
	var url = contextPath+url;
	var args = {key:keyname, width:740,height:820};
	windowOpen(url, searchParams, args);
}
</script>