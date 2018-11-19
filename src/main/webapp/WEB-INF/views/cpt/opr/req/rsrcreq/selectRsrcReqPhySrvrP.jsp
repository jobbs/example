<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세-물리서버 선택(팝업)</pre>
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 17.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     김봉민         v1.0             최초생성
 * 2016. 11. 17.     김봉민         v1.01            수정
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


<!-- 검색조건 영역 -->
<div class="col-box-100">

	<div class="box-search">

		<form:form commandName="pmSearchVo" method="get">
			<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
			<form:hidden path="searchRegionId" />
			<form:hidden path="searchZoneId" />
			<form:hidden path="searchNetId" />
			<form:hidden path="searchRsrcPoolId" />
			<form:hidden path="searchVrCnvrSwTyCd" />
			<form:hidden path="searchClstrSeq" />
			<form:hidden path="searchClstrNm" />

		<!-- box-body -->
		<div class="box-body">

			<div class="form-group">

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>센터</label>
					</div>
					<div class="cell-body" >
							<nform:selectRegion name="regionId" id="regionId" title="센터"
								wholeText="센터을 선택하세요" byRole="false"
								cssClass="form-control input-sm"
								value="${pmSearchVo.searchRegionId}" whole="true"
								onchange="selectZoneDy(this, 'regionId', {'byRole' : false}  )" />
						</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>존</label>
					</div>
					<div class="cell-body">
							<nform:selectZone name="zoneId" id="zoneId" title="존"
								wholeText="존을 선택하세요" cssClass="form-control input-sm"
								byRole="false" whole="true"
								regionId="${pmSearchVo.searchRegionId}"
								value="${pmSearchVo.searchZoneId}"
								onchange="selectPoolDy(this, 'regionIdAll', 'zoneIdAll', 'poolIdAll' , {'searchSwTypeCd':'COM', 'searchPoolTypeCd' : '01', 'byRole' : false})" />
						</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>망</label>
					</div>
					<div class="cell-body">
							<nform:selectNet name="netId" id="netId" title="망"
								wholeText="망을 선택하세요" cssClass="form-control input-sm"
								byRole="false" whole="true" zoneId="${pmSearchVo.searchZoneId}"
								value="${pmSearchVo.searchNetId}"
								onchange="selectPoolDy(this, 'regionId', 'zoneId', 'rsrcPoolId',  {'searchSwTypeCd':'COM', 'searchPoolTypeCd' : '01', 'byRole' : false}   )" />
						</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>자원풀</label>
					</div>
					<div class="cell-body">
							<nform:selectPool name="rsrcPoolId" id="rsrcPoolId" title="자원풀"
								wholeText="자원풀을 선택하세요" cssClass="form-control input-sm"
								whole="true" regionId="${pmSearchVo.searchRegionId}"
								zoneId="${pmSearchVo.searchZoneId}"
								netId="${pmSearchVo.searchNetId }"
								value="${pmSearchVo.searchRsrcPoolId}"
								onchange="selectClusterDy(this, 'clusterId' )" />
						</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>클러스터명</label>
					</div>
					<div class="cell-body">
						<input type="text" class="form-control input-sm" value="<c:out value='${pmSearchVo.searchClstrNm}'/>" title="부처" readonly="readonly">
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>상태</label>
					</div>
					<div class="cell-body">
						<form:select path="searchStatCd" title="상태" cssClass="form-control input-sm">
							<c:forEach var="statCd" items="${statCdList }">
								<form:option value="${statCd.cd}" ><c:out value="${statCd.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>물리서버명</label>
					</div>
					<div class="cell-body">
						<form:input path="searchPmNm" name="searchPmNm" title="물리서버명" cssClass="form-control input-sm" value=""/>
					</div>
				</div>


				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>물리서버 구성ID</label>
					</div>
					<div class="cell-body">
						<form:input path="searchPmCompId" name="searchPmCompId" title="물리서버 구성ID" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label>IP주소</label>
					</div>
					<div class="cell-body">
						<form:input path="searchRprsntIpAddr" name="searchRprsntIpAddr" title="IP주소" cssClass="form-control input-sm" value=""/>
					</div>
				</div>

				<!-- 검색조건 : checkbox -->
				<div class="form-cell form-cell-50 col-lay-75">
					<div class="cell-title">
						<label>가상화SW</label>
					</div>
					<div class="cell-body">
						<div class="input-group input-group-check">
							<c:choose>
								<c:when test="${pmSearchVo eq null or pmSearchVo.searchVrlzSwTyCdList eq null}">
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="searchVrlzSwTyCdList[${i.index}]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" checked="checked" />
										<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
										<form:checkbox path="searchVrlzSwTyCdList[${i.index}]" name="searchVrlzSwTyCdList" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" />
										<label for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
									</c:forEach>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>

			</div>

		</div>

		<!-- box-footer -->
		<div class="box-footer collapse in search-collapse">
		  <div class="pull-left">
		    <button type="submit" class="btn" onclick="fn_initialize();">초기화</button>
		  </div>
		  <div class="pull-right">
		  	<c:url var="selectRsrcReqPhySrvrPUrl" value="fn_selectRsrcReqPhySrvrP(); return false;">
			</c:url>
		    <button type="submit" class="btn btn-red pull-right" onclick="fn_selectRsrcReqPhySrvrP(); return false;">조회</button>
		  </div>
		</div>

		</form:form>

	</div>

</div>

<!-- 그리드 영역 -->
<div class="col-box-100">

	<div class="box">

		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">물리서버목록</h3>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body"   style="height:400px; overflow-x: auto; overflow-y: auto;">
			<table id="pmTable" class="table table-hover table-vertical table-layout-fixed">
				<caption>물리서버목록</caption>
				<thead>
					<tr><th><nobr>선택</nobr></th>
						<th><nobr>상태</nobr></th>
						<th><nobr>센터</nobr></th>
						<th><nobr>존</nobr></th>
						<th><nobr>망</nobr></th>
						<th><nobr>자원풀</nobr></th>
						<th><nobr>클러스터명</nobr></th>
						<th><nobr>물리서버명</nobr></th>
						<th><nobr>물리서버 구성ID</nobr></th>
						<th><nobr>IP주소</nobr></th>
						<th><nobr>가상화SW</nobr></th>
						<th><nobr>가상<br>서버수</nobr></th>
						<th><nobr>CPU<br>사용률<br>(%)</nobr></th>
						<th><nobr>CPU<br>가상화율<br>(%)</nobr></th>
						<th><nobr>CPU<br>vCore</nobr></th>
						<th><nobr>CPU<br>Core</nobr></th>
						<th><nobr>메모리<br>사용률<br>(%)</nobr></th>
						<th><nobr>메모리<br>가상화율<br>(%)</nobr></th>
						<th><nobr>메모리<br>할당량<br>(GB)</nobr></th>
						<th><nobr>메모리<br>전체량<br>(GB)</nobr></th>
						<th><nobr>스토리지<br>(GB)</nobr></th>
						<th><nobr>네트워크<br>In<br>(KB/S)</nobr></th>
						<th><nobr>네트워크<br>Out<br>(KB/S)</nobr></th></tr>
				</thead>
				<tbody>
					<c:forEach var="pmVo" items="${pmVoList }" varStatus="i">
						<c:url var="selectPmUrl" value="selectPm.do">
							<c:param name="pmSeq" value="${pmVo.pmSeq }" />
						</c:url>
						<tr>
							<td><nobr><input type="radio" name="pm_row" title="선택여부" value="${pmVo.pmSeq }">
									  <input type="hidden" id="inputPmNm_${pmVo.pmSeq}"  value="${pmVo.pmNm }"/>
								</nobr></td>
							<td class="alignL"><nobr>
								<div class="server-info server
										<c:choose><c:when test='${"01" eq pmVo.statCd}'><c:out value="server-down"/></c:when>
												  <c:when test='${"02" eq pmVo.statCd}'><c:out value="server-up"/></c:when>
												  <c:when test='${"03" eq pmVo.statCd}'><c:out value="server-maintain"/></c:when>
												  <c:when test='${"05" eq pmVo.statCd}'><c:out value="server-exception"/></c:when>
												  <c:otherwise><c:out value="server-inprogress"/></c:otherwise>
										</c:choose>">
									<div class="server-info-body alignL"><div class="server-info-box alignL"><span class="label"></span><h4 class="stat"><c:out value="${pmVo.statCdNm }" /></h4></div></div>
								</div>
								</nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.regionNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.zoneNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.netNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.rsrcPoolNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.clstrNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.pmNm }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.pmCompId }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.rprsntIpAddr }" /></nobr></td>
							<td class="alignL"><nobr><c:out value="${pmVo.vrlzSwTyCdNm }" /></nobr></td>
							<td class="alignR"><nobr><c:out value="${pmVo.vmCnt }" /></nobr></td>
							<td class="notellipsis">
								<span class="label label-green"><fmt:formatNumber value="${pmVo.cpuUseRt}" pattern="0"/></span>
								<div class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${pmVo.cpuUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.cpuVrlzRt}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><c:out value="${pmVo.totCpuVcoreQty }"/></nobr></td>
							<td class="alignR"><nobr><c:out value="${pmVo.cpuCoreQty }"/></nobr></td>
							<td class="notellipsis">
								<span class="label label-green"><fmt:formatNumber value="${pmVo.memUseRt}" pattern="0"/></span>
								<div class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${pmVo.memUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.memVrlzRt}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.totMemAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.memCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.totStrgAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.netwkIn }" pattern="0.0"/></nobr></td>
							<td class="alignR"><nobr><fmt:formatNumber value="${pmVo.netwkOut }" pattern="0.0"/></nobr></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!-- popup 버튼 -->
<div class="col-box-100">
		<div class="button">
			<button class="btn btn-dark" data-target="#tree-resource" onclick="javascript:fn_selectedTmplatP(); return false;">선택</button>
			<button class="btn close-window" data-target="#tree-resource" onclick="self.close();">닫기</button>
		</div>

</div>
<!-- /popup 버튼 -->

<script type="text/javascript">


$(function() {
	$('#regionId').attr('disabled',true);
	$('#zoneId').attr('disabled',true);
	$('#netId').attr('disabled',true);
	$('#rsrcPoolId').attr('disabled',true);
	$('#pmSearchVo input[type="checkbox"]').attr('disabled',true);

	//$('#clusterId').attr('disabled',true);
});


$('table tr').click(function(e){
	var $target =  $(this).find('td input[type="radio"]');
	if( $target.attr("type") == "radio" ) {
		$target.prop("checked", true);
	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});

// 검색조건 초기화
function fn_initialize(){
	//$('#pmSearchVo input[type="text"]').val('');
	//$('#pmSearchVo #searchRsrcPoolId').val('').attr('selected', 'selected');
	$('#searchPmNm').val('');
	$('#searchPmCompId').val('');
	$('#searchRprsntIpAddr').val('');
	$('#pmSearchVo #searchStatCd').val('').attr('selected', 'selected');
}

// 조회
function fn_selectRsrcReqPhySrvrP(){
	$('#pmSearchVo').attr('target', '_self');
	$('#pmSearchVo').attr('action', '<c:url var="select" value="selectRsrcReqPhySrvrP.do"/>');
	$('#pmSearchVo').submit();
}

/**
* 선택
*/
function fn_selectedTmplatP() {
	if ($('table input[type="radio"]:checked').length == 0) {
		jAlert("선택된 물리서버가 없습니다.");
		return;
	}
	var pmSeq = $('table input[type="radio"]:checked').val();
	var pmNm = $('#inputPmNm_'+pmSeq).val();

	window.opener.fn_selectedPhySrvr(pmSeq, pmNm);
	self.close();
}


$("#pmTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [	{sWidth : "32px" }, 	//선택
	             	{sWidth : "78px" }, 	//상태
	                {sWidth : "33px" }, 	//센터
	                {sWidth : "29px" }, 	//존
	                {sWidth : "53px" }, 	//망
	                {sWidth : "100px" },	//자원풀
	                {sWidth : "100px" },	//클러스터명
	                {sWidth : "113px" },	//물리서버명
	                {sWidth : "90px" }, 	//물리서버구성ID
	                {sWidth : "91px" }, 	//IP주소
	                {sWidth : "70px" }, 	//가상화SW
	                {sWidth : "43px" },    	//가상서버수
	                {sWidth : "44px" }, 	//CPU 사용률
	                {sWidth : "54px" }, 	//<th>CPU 가상화율</th>
	                {sWidth : "43px" }, 	//<th>CPU vCore</th>
	                {sWidth : "37px" }, 	//<th>CPU  Core</th>
	                {sWidth : "44px" }, 	//<th>메모리 사용률</th>
	                {sWidth : "54px" }, 		//<th>메모리 가상화율</th>
	                {sWidth : "44px" }, 	//<th>메모리 할당량<br>(GB)</th>
	                {sWidth : "44px" }, 	//<th>메모리 전체량<br>(GB)</th>
	                {sWidth : "54px" }, 	//<th>스토리지<br>(GB)</th>
	                {sWidth : "53px" }, 	//<th>네트워크In<br>(KB/S)</th>
	                {sWidth : "53px" }  	//<th>네트워크Out<br>(KB/S)</th></tr>

	],
	order : [ [ 0, "desc" ] ]
});







</script>
