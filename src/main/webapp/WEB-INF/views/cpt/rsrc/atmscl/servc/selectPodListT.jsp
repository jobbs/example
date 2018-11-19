<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 07. 01.
 * @lastmodified 2017. 07. 01.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 7. 01.     x         v1.0             최초생성
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
		<table class="table table-vertical">
			<caption>Pod 목록 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="col10">
				<col class="col10">
				<col class="col10">
				<col class="col10">
				<col class="col10">
				<col class="col10">
				<col class="col10">
				<col class="col10">
			</colgroup>
			<thead>
			<tr>
				<th>Pod명</th>
				<th>상태</th>
				<th>CPU<br>Core</th>
				<th>CPU<br>사용률(%)</th>
				<th>메모리<br>할당량(GB)</th>
				<th>메모리<br>사용률(%)</th>
				<th>네트워크<br>In(KB/Sec)</th>
				<th>네트워크<br>Out(KB/Sec)</th>
				<th>생성일시</th>
			</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${list eq null or empty list }">
						<tr>
							<td colspan="9">Pod 정보가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="pod" items="${list }" varStatus="i">
				          <tr>
				          	<td class="alignL"><c:out value="${pod.podNm }" /></td>
							<td class="alignC">
								<!-- 진행중 01: 완료:02, 실패 03: New: 04 , Pending:05, 기타:06 -->
		                		<span class="status <c:choose>
		                								<c:when test="${'01' eq pod.statCd}"><c:out value="status-blue"/></c:when>
		                								<c:when test="${'02' eq pod.statCd}"><c:out value="status-green"/></c:when>
		                								<c:when test="${'03' eq pod.statCd}"><c:out value="status-red"/></c:when>
														<c:otherwise><c:out value="status-gray"/></c:otherwise>
		                							</c:choose>
		                			status-red "><c:out value="${pod.statCdNm}"/>
		                		</span>
							</td>
							<td class="alignR"><c:out value="${pod.cpuCorQty }" /></td>
							<td class="alignR"><c:out value="${pod.cpuUseRt }" /></td>
							<td class="alignR"><c:out value="${pod.memAsgnCapa }" /></td>
							<td class="alignR"><c:out value="${pod.memUseRt }" /></td>
							<td class="alignR"><c:out value="${pod.netwkIn }" /></td>
							<td class="alignR"><c:out value="${pod.netwkOut }" /></td>
							<td><c:out value="${pod.creDttm }" /></td>
				          </tr>
				        </c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>

</div>