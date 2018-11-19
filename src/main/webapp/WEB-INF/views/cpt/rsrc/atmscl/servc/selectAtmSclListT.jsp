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
        <c:choose>
			<c:when test="${servcSclngVo.sclngClCd eq null or empty servcSclngVo.sclngClCd }">
				<table class="table table-horizon">
						<caption>오토스케일  예약정보</caption>
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
				<c:if test="${servcSclngVo.sclngClCd eq '03' }">

					<table class="table table-horizon">
						<caption>오토스케일  예약정보</caption>
						<colgroup>
							<col class="col13">
							<col class="col20">
							<col class="col13">
							<col class="col20">
							<col class="col14">
							<col class="col20">
						</colgroup>

						<tbody>
							<tr>
							    <th>구분</th>
							    <td colspan="5"><c:out value="${servcSclngVo.sclngClNm }" /></td>
							</tr>
							<tr>
								<th>예약명</th>
								<td><c:out value="${servcSclngVo.minPodQty }" /></td>
								<th>예약일자</th>
								<td><c:out value="${servcSclngVo.rsrvStrtDt }" />~<c:out value="${servcSclngVo.rsrvEndDt }" /></td>
								<th>Pod수</th>
								<td><c:out value="${servcSclngVo.maxPodQty }" /></td>
							</tr>
						</tbody>
					</table>
				</c:if>

				<c:if test="${servcSclngVo.sclngClCd eq '01' }">
					<table class="table table-horizon">
						<caption>오토스케일  OpenShift 설정정보</caption>
						<colgroup>
							<col class="col13">
							<col class="col20">
							<col class="col13">
							<col class="col20">
							<col class="col14">
							<col class="col20">
						</colgroup>

						<tbody>
							<tr>
							    <th>구분</th>
							    <td colspan="5"><c:out value="${servcSclngVo.sclngClNm }" /></td>
							</tr>
							<tr>
								<th>최소  Pod수</th>
								<td><c:out value="${servcSclngVo.minPodQty }" /></td>
								<th>최대  Pod수</th>
								<td><c:out value="${servcSclngVo.maxPodQty }" /></td>
								<th>CPU사용량(%)</th>
								<td><c:out value="${servcSclngVo.endThresVl }" /></td>
							</tr>
						</tbody>
					</table>
				</c:if>

				<c:if test="${servcSclngVo.sclngClCd eq '02' }">

					<table class="table table-horizon">
						<caption>오토스케일  OpenShift 설정정보</caption>
						<colgroup>
							<col class="col13">
							<col class="col20">
							<col class="col13">
							<col class="col20">
							<col class="col14">
							<col class="col20">
						</colgroup>

						<tbody>
							<tr>
							    <th>구분</th>
							    <td><c:out value="${servcSclngVo.sclngClNm }" /></td>
							    <th>최소  Pod수</th>
								<td><c:out value="${servcSclngVo.minPodQty }" /></td>
								<th>최대  Pod수</th>
								<td><c:out value="${servcSclngVo.maxPodQty }" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="box">
				<div class="box-body no-padding">
					<table class="table table-horizon">
						<caption>다차원 설정정보</caption>
						<colgroup>
							<col class="col13">
							<col class="col20">
							<col class="col13">
							<col class="col20">
							<col class="col14">
							<col class="col20">
						</colgroup>

						<tbody>
							<tr>
							    <th>그룹</th>
							    <th>임계치구분</th>
							    <th>임계치</th>
							</tr>

						<c:forEach var="list" items="${list }" varStatus="i">
							<tr>
							    <td><c:out value="${list.sclGrpNm }" /></td>
								<td><c:out value="${list.thresClNm }" /></td>
								<td class="alignR">
									<c:out value="${list.endThresVl }" />
									<c:if test="${list.thresClCd eq '01' or list.thresClCd eq '02' }">%</c:if>
									<c:if test="${list.thresClCd eq '03'}">KB/Sec</c:if>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
</div>