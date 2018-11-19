<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 27.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 27.     이화영         v1.0             최초생성
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

<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">알림 정보</h3>
		</div><!-- /box-header -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>알림정보</caption>
				<colgroup>
					<col class="col17">
					<col class="col17">
					<col class="col17">
					<col class="col16">
					<col class="col17">
					<col class="col16">
				</colgroup>
				<tbody>
  				<tr>
    				<th>알림명</th>
    				<td colspan="5"><c:out value="${packgAlrmInfoVo.patchAlrmNm}"/></td>
				</tr>
				<tr>
  					<th>알림내용</th>
  					<td colspan="5"><c:out value="${packgAlrmInfoVo.patchAlrmCn}"/></td>
				</tr>
				<tr>
  					<th>알림통보자</th>
  					<td><c:out value="${packgAlrmInfoVo.patchAlrmDspthNm}"/></td>
  					<th>알림일자</th>
  					<td><c:out value="${packgAlrmInfoVo.patchAlrmDttm}"/></td>
  					<th>확인일자</th>
  					<td><c:out value="${packgAlrmInfoVo.confrmDt}"/></td>
				</tr>
    			</tbody>
  			</table>
		</div><!-- /box-body -->
    </div>

    <div class="box detail-list-box">
  		<div class="box-header">
    		<h3 class="box-title">패치대상 정보</h3>
  		</div><!-- /box-header -->
		<div class="box-body no-padding">
  			<table class="table table-vertical">
  				<caption>패치대상 정보</caption>
    			<colgroup>
					<col class="col25">
					<col class="col15">
					<col class="col15">
					<col class="col15">
					<col class="col15">
					<col class="col15">
				</colgroup>
				<tbody>
				 <tr>
					<th colspan="3" class="bg-dark" style="border-bottom: 1px solid #D5CEC0;">변경 전</th>
					<th colspan="3" class="bg-blue" style="border-bottom: 1px solid #D3C1C1;">변경 후</th>
				</tr>
				<tr>
					<th>패키지명</th>
					<th>버전</th>
	                <th>릴리즈</th>
					<th>버전</th>
					<th>릴리즈</th>
					<th>등록일자</th>
				</tr>
				<tr>
					<td class="alignL"><c:out value="${packgAlrmInfoVo.packgNm}"/></td>
					<td class="alignL"><c:out value="${packgAlrmInfoVo.ver}"/></td>
					<td class="alignL"><c:out value="${packgAlrmInfoVo.release}"/></td>
					<td class="alignL"><c:out value="${packgAlrmInfoVo.maxVer}"/></td>
					<td class="alignL"><c:out value="${packgAlrmInfoVo.maxRelease}"/></td>
					<td><c:out value="${packgAlrmInfoVo.patchAlrmDttm}"/></td>
				</tr>
				</tbody>
			</table>
		</div><!-- /box-body -->
    </div>

    <div class="box detail-list-box">
  		<div class="box-header">
    		<h3 class="box-title">가상서버 상세정보</h3>
  		</div><!-- /box-header -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>가상서버 상세정보</caption>
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
					<th>가상서버ID</th>
					<td><c:out value="${vmPatchVo.vmId}"/></td>
				</tr>
				<tr>
					<th>가상서버구성ID</th>
					<td><c:out value="${vmPatchVo.vmCompId}"/></td>
  					<th>가상화SW</th>
  					<td><c:out value="${vmPatchVo.vrlzSwTyCdNm}"/></td>
					<th>호스트명</th>
  					<td><c:out value="${vmPatchVo.hstNm}"/></td>
				</tr>
				<tr>
					<th>IP주소</th>
					<td><c:out value="${vmPatchVo.rprsntIpAddr}"/></td>
					<th>OS타입</th>
					<td><c:out value="${vmPatchVo.osTyCdNm}"/></td>
					<th>운영체제</th>
  					<td><c:out value="${vmPatchVo.osNm}"/></td>
				</tr>
				<tr>
					<th>서비스기간</th>
					<td colspan="3">
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
    			</tbody>
  			</table>
		</div><!-- /box-body -->
    </div>
</div><!-- col -->

<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_selectPackgAlrmList();"><i class="fa fa-arrow-left"></i></button>
		</div>
	</div>
</div>

<script type="text/javascript">

//뒤로
function fn_selectPackgAlrmList(){
	location.href = '<c:url value="selectPackgAlrmList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'patchAlrmSeq' && pageParam.key ne 'vmSeq' && pageParam.key ne 'chargerId'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

</script>