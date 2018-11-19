<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 8. 12.
 * @lastmodified 2017. 8. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 8. 12.     x         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<div class="box">
	<div class="box-body no-padding">
		<c:choose>
			<c:when test="${atmsclDistrbVo.reqCpuCorQty eq null or atmsclDistrbVo.reqCpuCorQty eq 0.0 }">
				<table class="table table-horizon">
						<caption>자원제한정보</caption>
						<colgroup>
							<col class="col100">
						</colgroup>

						<tbody>
							<tr>
							    <td class="alignC">설정된 정보가 없습니다.</th>
							</tr>

						</tbody>
					</table>
			</c:when>

			<c:otherwise>

				<table class="table table-horizon" id="limitTable">
					<caption>자원제한 정보</caption>
					<colgroup>
						<col class="col10">
						<col class="col45">
						<col class="col10">
						<col class="col45">
					</colgroup>

					<tbody>
						<tr>
						    <th>요청 CPU</th>
						    <td><c:out value="${atmsclDistrbVo.reqCpuCorQty }" /> Core</td>
							<th>제한 CPU</th>
							<td><c:out value="${atmsclDistrbVo.lmttCpuCorQty }" /> Core</td>
						</tr>
						<tr>
							<th>요청 메모리</th>
							<td><c:out value="${atmsclDistrbVo.reqMemCapa }" /> GB</td>
							<th>제한 메모리</th>
							<td><c:out value="${atmsclDistrbVo.lmttMemCapa }" /> GB</td>
						</tr>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</div>