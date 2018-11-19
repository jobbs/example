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
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-hover table-horizon">
				<caption>사용자 목록 테이블</caption>
				<tbody>
				<tr>
					<td style="word-break : break-all;"><cf:escapedXmlOut value="${message }"/> </td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="col-box-100">
	<div class="button">
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>