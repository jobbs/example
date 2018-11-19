<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     이화영         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:url var="vmPatchXlsDwnl" value="selectVmPatchXlsDwnl.do">
	<c:param name="vmSeq" value="${vmPatchVo.vmSeq }"></c:param>
</c:url>

<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">가상서버 상세정보</h3>
		</div><!-- /box-header -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>가상서버 상세정보목록</caption>
				<colgroup>
					<col class="col13">
					<col class="col20">
					<col class="col13">
					<col class="col20">
					<col class="col13">
					<col class="col21">
				</colgroup>
				<tbody>
				<tr>
					<th>센터</th>
					<td><c:out value="${vmPatchVo.regionNm}"/></td>
					<th>존</th>
					<td><c:out value="${vmPatchVo.zoneNm}"/></td>
					<th>망구분</th>
					<td><c:out value="${vmPatchVo.netNm}"/></td>
				</tr>
				<tr>
					<th>상태</th>
					<td><c:out value="${vmPatchVo.statGrpCdNm}"/></td>
					<th>부처</th>
					<td><c:out value="${vmPatchVo.institutionNm}"/></td>
					<th>업무</th>
					<td><c:out value="${vmPatchVo.jobsNm}"/></td>
				</tr>
				<tr>
					<th>자원풀</th>
					<td><c:out value="${vmPatchVo.rsrcPoolNm}"/></td>
					<th>가상서버명</th>
					<td><c:out value="${vmPatchVo.vmNm}"/></td>
					<th>가상서버구성ID</th>
					<td><c:out value="${vmPatchVo.vmCompId}"/></td>
				</tr>
				<tr>
					<th>호스트명</th>
					<td><c:out value="${vmPatchVo.hstNm}"/></td>
					<th>IP주소</th>
					<td><c:out value="${vmPatchVo.rprsntIpAddr}"/></td>
					<th>OS타입</th>
					<td><c:out value="${vmPatchVo.osTyCdNm}"/></td>
				</tr>
				<tr>
					<th>운영체제</th>
					<td><c:out value="${vmPatchVo.osNm}"/></td>
					<th>서비스기간</th>
					<td>
						<c:choose>
							<c:when test="${vmPatchVo.servcStrtDt ne null }">
								<fmt:formatDate value="${vmPatchVo.servcStrtDt }" pattern="yyyy-MM-dd" /> ~ <fmt:formatDate value="${vmPatchVo.servcEndDt }" pattern="yyyy-MM-dd" />
							</c:when>
							<c:otherwise>
								영구
							</c:otherwise>
						</c:choose>
					</td>
					<th>물리서버구성ID</th>
					<td><c:out value="${vmPatchVo.pmCompId}"/></td>
				</tr>
				<tr>
					<th>CPU(vCore)</th>
					<td><c:out value="${vmPatchVo.cpuVcoreQty}"/></td>
					<th>메모리(GB)</th>
					<td><c:out value="${vmPatchVo.memAsgnCapa}"/></td>
					<th>스토리지할당량(GB)</th>
					<td><c:out value="${vmPatchVo.strgAsgnCapa}"/></td>
				</tr>
			<%-- <tr>
					<th>패키지명</th>
					<td colspan="3"><c:out value="${vmPatchVo.packgNm}"/></td>
					<th>설치일자</th>
					<td><c:out value="${vmPatchVo.regDttm}"/></td>
	 						</tr> --%>
				</tbody>
			</table>
		</div><!-- /box-body -->
	</div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">패키지목록 관계</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_selectVmPatchXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-vertical table-bordered" id="packgListTbl">
				<caption>패키지목록 관계</caption>
				<colgroup>
  					<col class="col5">
  					<col class="colAuto">
  					<col class="col8">
  					<col class="col10">
  					<col class="col12">
  					<col class="col8">
  					<col class="col10">
  					<col class="col10">
  					<col class="col8">
				</colgroup>
   				<thead>
     			<tr>
   					<th colspan="5" class="bg-dark" style="border-bottom: 1px solid #D5CEC0;">설치 패키지 정보</th>
   					<th colspan="4" class="bg-blue" style="border-bottom: 1px solid #D3C1C1;">최신 패키지 정보</th>
   				</tr>
   					<tr>
       				<th>No.</th>
       				<th>패키지명</th>
       				<th>버전</th>
       				<th>릴리즈</th>
       				<th>설치일자</th>
       				<th>버전</th>
       				<th>릴리즈</th>
       				<th>레파지토리</th>
       				<th>업데이트 가능 여부</th>
     			</tr>
     			</thead>
     			<tbody>
       			<c:choose>
					<c:when test="${vmPatchPackgList eq null or empty vmPatchPackgList }">
						<tr>
							<td colspan="9">검색된 데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="vmPatchPackgList" items="${vmPatchPackgList}" varStatus="i">
							<tr>
								<td><c:out value="${i.count}"/></td>
								<td class="alignL"><c:out value="${vmPatchPackgList.packgNm}"/></td>
								<td class="alignL"><c:out value="${vmPatchPackgList.ver}"/></td>
								<td class="alignL"><c:out value="${vmPatchPackgList.release}"/></td>
								<td><c:out value="${vmPatchPackgList.instlDt}"/></td>
								<td class="alignL"><c:out value="${vmPatchPackgList.lastVer}"/></td>
								<td class="alignL"><c:out value="${vmPatchPackgList.lastRelease}"/></td>
								<td class="alignL"><c:out value="${vmPatchPackgList.repositNm}"/></td>
								<td>
									<c:choose>
										<c:when test="${vmPatchPackgList.ver ne vmPatchPackgList.lastVer
											or vmPatchPackgList.release ne vmPatchPackgList.lastRelease}"><span class="status status-blue">가능</span></c:when>
										<c:otherwise></c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
     			</tbody>
   			</table>
 		</div>
	</div>
</div>

<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_selectVmPatchList();"><i class="fa fa-arrow-left"></i></button>
		</div>
 	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.cmnTable.js" />"></script>
<script type="text/javascript">
//뒤로
function fn_selectVmPatchList(){
	location.href = '<c:url value="selectVmPatchList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'vmSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

/* $(document).ready(function() {
	$("#packgListTbl").rowspan(5);
	$("#packgListTbl").rowspan(6);
}); */

//목록의 정보를 Excel로 다운로드 한다.
function fn_selectVmPatchXlsDwnl() {
	if("${vmPatchPackgList.size()}" == '') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	goToUrl('${vmPatchXlsDwnl}');
}
</script>