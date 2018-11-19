<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 5.
 * @lastmodified 2016. 10. 5.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 5.     송승규         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<form:form id="searchVo" commandName="searchVo" method="GET">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
		<div class="box box-search">
			<div class="box-header">
				<h3 class="box-title">검색조건</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
						<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
					</button>
				</div>
			</div>
			<div class="box-body collapse in search-collapse">
				<div class="form-group">

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="센터" for="equalsRegionId">센터</label>
					</div>
					<div class="cell-body">
						<nform:selectRegion
				          name="regionId"
				          id="regionId"
				          title="센터"
				          whole="true"
				          byRole="false"
				          wholeText="전체"
				          cssClass="form-control input-sm"
				          value="${searchVo.regionId}"
				          onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'poolId', {'byRole' : false, 'searchSwTypeCd' : 'COM','searchPoolTypeCd':'01'})" />

					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="존" for="zoneId">존</label>
					</div>
					<div class="cell-body">
						<nform:selectZone
				          name="zoneId"
				          id="zoneId"
				          whole="true"
				          byRole="false"
				          regionId="${searchVo.regionId}"
				          value="${searchVo.zoneId}"
				          wholeText="전체"
				          cssClass="form-control input-sm"
				          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'poolId', {'byRole' : false, 'searchSwTypeCd' : 'COM','searchPoolTypeCd':'01'})" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="망구분" for="netClCd">망구분 </label>
					</div>
					<div class="cell-body">
						<nform:selectCode
				          parentCd="NETCD"
				          parentGrpCd="067"
				          name="netClCd"
				          id="netClCd"
				          whole="true"
				          byRole="false"
				          wholeText="전체"
				          extra1=""
				          extra2=""
				          extra3=""
				          value="${searchVo.netClCd}"
				          extra4=""
				          extra5=""
				          cssClass="form-control input-sm"
				          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'poolId', {'searchCtlTrgtYn' : '','byRole' : false, 'searchSwTypeCd' : 'COM','searchPoolTypeCd':'01'})"  />
					</div>
				</div>
				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="자원풀" for="poolId">자원풀</label>
					</div>
					<div class="cell-body">
						<nform:selectPool
					          name="poolId"
					          id="poolId"
					          title="자원풀"
					          wholeText="전체"
					          poolTypeCd="01"
					          cssClass="form-control input-sm"
					          swTypeCd="COM"
					          regionId="${searchVo.regionId }"
					          zoneId="${searchVo.zoneId}"
					          netClCd="${searchVo.netClCd }"
					          value="${searchVo.poolId}"
					          ctlTrgtYn=""/>
					</div>
				</div>


					<%-- <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="regionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="regionId" id="regionId" whole="true" byRole="false" value="${searchVo.regionId }" cssClass="form-control input-sm" onchange="selectZoneDy(this, 'zoneId', {'byRole' : false} )" title="센터" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="zoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone name="zoneId" id="zoneId" whole="true" byRole="false" value="${searchVo.zoneId }" regionId="${searchVo.regionId }" cssClass="form-control input-sm" onchange="selectNetDy(this, 'netId', {'byRole' : false} )" title="존" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="netId">망</label>
						</div>
						<div class="cell-body">
							<nform:selectNet name="netId" id="netId" whole="true" byRole="false" value="${searchVo.netId }" zoneId="${searchVo.zoneId }" cssClass="form-control input-sm" onchange="selectPoolDy(this, 'regionId', 'zoneId', 'poolId', {'byRole' : false} )" title="망" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="poolId">자원풀</label>
						</div>
						<div class="cell-body">
							<nform:selectPool name="poolId" id="poolId" value="${searchVo.poolId }" regionId="${searchVo.regionId }" zoneId="${searchVo.zoneId }" netId="${searchVo.netId }" cssClass="form-control input-sm" title="자원풀" />
						</div>
					</div> --%>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="useYn">사용여부</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:select path="useYn" cssClass="form-control input-sm" title="사용여부">
					              	<form:option value="">전체</form:option>
					              	<form:option value="Y">사용</form:option>
					              	<form:option value="N">미사용</form:option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="tmplatNm">템플릿명</label>
						</div>
						<div class="cell-body">
							<form:input type="text" path="tmplatNm" class="form-control input-sm pull-right" maxlength="30" title="템플릿명" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="tmplatClCd">템플릿구분</label>
						</div>
						<div class="cell-body">
							<form:select path="tmplatClCd" cssClass="form-control input-sm" title="템플릿구분">
								<c:forEach var="tmplatClCdCode" items="${tmplatClCdCode}" varStatus="i">
									<form:option value="${tmplatClCdCode.cd}">${tmplatClCdCode.cdNm}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="vrlzSwTyCd">가상화SW</label>
						</div>
						<div class="cell-body">
							<form:select path="vrlzSwTyCd" cssClass="form-control input-sm" title="가상화SW">
								<c:forEach var="vrlzSwTyCdCode" items="${vrlzSwTyCdCode}" varStatus="i">
									<form:option value="${vrlzSwTyCdCode.cd}">${vrlzSwTyCdCode.cdNm}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="osTyCd">OS 유형</label>
						</div>
						<div class="cell-body">
							<form:select path="osTyCd" cssClass="form-control input-sm" title="OS타입">
								<c:forEach var="osTyCdCode" items="${osTyCdCode}" varStatus="i">
									<form:option value="${osTyCdCode.cd}">${osTyCdCode.cdNm}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="osNm">운영체제</label>
						</div>
						<div class="cell-body">
							<form:input type="text" path="osNm" class="form-control input-sm pull-right" maxlength="30" title="운영체제" />
						</div>
					</div><%--
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="osBit">OS Bit</label>
						</div>
						<div class="cell-body">
							<form:select path="osBit" cssClass="form-control input-sm" title="OS Bit">
								<c:forEach var="osBitCode" items="${osBitCode}" varStatus="i">
									<form:option value="${osBitCode.cd}">${osBitCode.cdNm}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div> --%>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for=vmCrePrcssYn>가상화진행여부</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:select path="vmCrePrcssYn" cssClass="form-control input-sm" title="가상화진행여부">
	              	<form:option value="">전체</form:option>
	              	<form:option value="Y">진행중</form:option>
	              	<form:option value="N">미진행</form:option>
								</form:select>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
				</div>
				<div class="pull-right">
					<button type="button" class="btn btn-red" onclick="fn_selectTmplatList();" title="조회">조회</button>
				</div>
			</div>
		</div>
	</form:form>
</div>
<div class="col-box-100 search-col">
	<div class="box list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${searchVo.paginationInfo.currentPageNo } /
				${searchVo.paginationInfo.totalPageCount },
				총 ${searchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_downloadExcel();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>
		<div class="box-body no-padding list-body">
			<form id=tmplatView name="tmplatView" method="post">
				<table class="table table-hover table-vertical table-layout-fixed" id="tmplatTable">
					<caption>템플릿 목록 테이블</caption>
					<thead>
						<tr>
							<th><input type="checkbox" id="selectAll" title="전체선택"></th>
							<th><nobr>사용여부</nobr></th>
							<th><nobr>센터</nobr></th>
							<th><nobr>존</nobr></th>
							<th><nobr>망구분</nobr></th>
							<th><nobr>자원풀</nobr></th><%--
							<th><nobr>템플릿ID</nobr></th> --%>
							<th><nobr>템플릿명</nobr></th>
							<th><nobr>템플릿<br>구분</nobr></th>
							<th><nobr>템플릿<br>버전</nobr></th>
							<th><nobr>가상화SW</nobr></th>
							<th><nobr>OS 유형</nobr></th>
							<th><nobr>운영체제</nobr></th>
							<th><nobr>OS 버전</nobr></th>
							<th><nobr>용도</nobr></th><%--
							<th><nobr>Platform</nobr></th>
							<th><nobr>OS Bit</nobr></th>
							<th><nobr>Kernel</nobr></th>
							<th><nobr>언어</nobr></th>--%>
							<th><nobr>스토리지<br>(GB)</nobr></th>
							<th><nobr>가상화<br>진행여부</nobr></th>
							<th><nobr>생성일자</nobr></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${tmplatList eq null or empty tmplatList }">
							</c:when>
							<c:otherwise>
								<c:forEach var="tmplatVo" items="${tmplatList }" varStatus="i">
									<tr>
										<c:url var="detailUrl" value="selectTmplat.do">
											<c:forEach var="curParam" items="${param }">
												<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
											</c:forEach>
											<c:param name="tmplatSeq" value="${tmplatVo.tmplatSeq }" />
										</c:url>
										<td><input type="checkbox" name="updtCheck" class="updtCheck" value="${tmplatVo.tmplatSeq }" title="항목선택"></td>
										<td>
											<c:choose>
												<c:when test = "${ tmplatVo.useYn eq 'Y' }">
													<span class="status status-green">사용</span>
												</c:when>
												<c:otherwise>
													<span class="status status-gray">미사용</span>
												</c:otherwise>
											</c:choose>
										</td>
										<td><nobr><c:out value="${tmplatVo.regionNm}" /></nobr></td>
										<td><nobr><c:out value="${tmplatVo.zoneNm}" /></nobr></td>
										<%-- <td><nobr><c:out value="${tmplatVo.netNm}" /></nobr></td> --%>
										<td><nobr><c:out value="${tmplatVo.netClNm}" /></nobr></td>
										<td class="alignL"><nobr title="${tmplatVo.rsrcPoolNm}"><c:out value="${tmplatVo.rsrcPoolNm}" /></nobr></td><%--
										<td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${tmplatVo.tmplatId}"/> 상세 화면이동"><c:out value="${tmplatVo.tmplatId}" /></a></nobr></td> --%>
										<td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${tmplatVo.tmplatNm}"/> 상세 화면이동"><c:out value="${tmplatVo.tmplatNm}" /></a></nobr></td>
										<td><nobr><c:out value="${tmplatVo.tmplatClCd}" /></nobr></td>
										<td class="alignL"><nobr><c:out value="${tmplatVo.tmplatVer }" /></nobr></td>
										<td class="alignL"><nobr><c:out value="${tmplatVo.vrlzSwTyCd }" /></nobr></td>
										<td class="alignL"><nobr><c:out value="${tmplatVo.osTyCd }" /></nobr></td>
										<td class="alignL"><nobr><c:out value="${tmplatVo.osNm }" /></nobr></td>
										<td class="alignL"><nobr><c:out value="${tmplatVo.osVer }" /></nobr></td>
										<td class="alignL"><nobr title="${tmplatVo.prpos }"><c:out value="${tmplatVo.prpos }" /></nobr></td><%--
										<td class="alignL"><nobr title="${tmplatVo.pltfrm }"><c:out value="${tmplatVo.pltfrm }" /></nobr></td>
										<td><nobr><c:out value="${tmplatVo.osBit }" /></nobr></td>
										<td class="alignL"><nobr><c:out value="${tmplatVo.krnlVer }" /></nobr></td>
										<td><nobr><c:out value="${tmplatVo.lang }" /></nobr></td>--%>
										<td class="alignR"><nobr><c:out value="${tmplatVo.strgAsgnCapa }" /></nobr></td>
										<td class="alignC">
											<c:choose>
												<c:when test = "${ tmplatVo.vmCrePrcssYn eq 'Y' }">
													<span class="status status-green">진행중</span>
												</c:when>
												<c:otherwise>
													<span class="status status-gray">미진행</span>
												</c:otherwise>
											</c:choose>
										</td>
										<td><nobr><fmt:formatDate value="${tmplatVo.regDttm }" pattern="yyyy-MM-dd" /></nobr></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</form>
		</div>
		<div class="box-footer edit-btn-group ">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize onlyOprAdm="true">
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="사용" onclick='fn_updateCheck("Y");'><i class="fa fa-plus"></i></button>
					<button type="button" class="btn btn-hover-red" data-toggle="tooltip" data-original-title="미사용" onclick='fn_updateCheck("N");'><i class="fa fa-minus"></i></button>
				</menu:authorize>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$('#selectAll').click(function(){
			$('.updtCheck').prop('checked', $(this).is(":checked"));
		});

		$('.updtCheck').click(function(){
			if($('.updtCheck:checked').length == $('.updtCheck').length){
				$('#selectAll').prop('checked', true);
			}
			else {
				$('#selectAll').prop('checked', false);
			}
		});
	});

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectTmplatList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#searchVo input[type='text']").val("");
		$("#searchVo select").val("").attr("selected", "selected");
	}

	// 템플릿 목록조회
	function fn_selectTmplatList(){

		$("#searchVo").attr("action", "selectTmplatList.do");
		$("#searchVo").submit();
	}

	// 사용/미사용 선택 체크
	function fn_updateCheck(bool){
		var checked = 0;
		$("input[name='updtCheck']").each(function() {
			if ($(this).prop("checked")) {
				checked++;
			}
		});

		if (checked == 0) {
			jAlert("적용대상을 선택하시기 바랍니다.");
			return;
		}

		fn_updateTmplatUseYn(bool);
	}

	// 사용/미사용 처리
	function fn_updateTmplatUseYn(bool) {

		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_updateTmplatUseYnCallBack,
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				alert('오류 발생');
			}
		};

		if(bool == 'Y'){
			jConfirm("선택한 템플릿을 사용처리 하시겠습니까?", function(){
				$('#tmplatView').attr("action", "updateTmplatUseY.do");
				$('#tmplatView').ajaxSubmit(options);
			});
		}else{
			jConfirm("선택한 템플릿을 미사용처리 하시겠습니까?",function(){
				$('#tmplatView').attr("action", "updateTmplatUseN.do");
				$('#tmplatView').ajaxSubmit(options);
			});
		}
	}

	// 사용/미사용 콜백
	function fn_updateTmplatUseYnCallBack(result){

		if(result.success){
			jAlert("적용되었습니다.", function(){
				if(result.procType == "update") {
					location.reload();
				}
			});
		}else{
			jAlert(result.messageList);
		}
	}

	// 엑셀 다운로드
	function fn_downloadExcel() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드할 데이터가 없습니다");
			return;
		}

		$("#searchVo").attr("action", "selectTmplatListXlsDwnl.do");
		$("#searchVo").submit();
	}

	// 리스트 테이블 정렬
	$("#tmplatTable").DataTable( {
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
					{sWidth : "30px" }, // 선택
					{sWidth : "50px" }, // 사용여부
					{sWidth : "35px" }, // 센터
					{sWidth : "30px" }, // 존
					{sWidth : "60px" }, // 망구분
					{sWidth : "130px" }, // 자원풀
					//{sWidth : "150px" }, // 템플릿ID
					{sWidth : "150px" }, // 템플릿명
					{sWidth : "40px" }, // 템플릿구분
					{sWidth : "40px" }, // 템플릿버전
					{sWidth : "95px" }, // 가상화SW
					{sWidth : "65px" }, // OS유형
					{sWidth : "65px" }, // 운영체제
					{sWidth : "50px" }, // OS버전
					{sWidth : "80px" }, // 용도
					//{sWidth : "60px" }, // Platform
					//{sWidth : "40px" }, // OS Bit
					//{sWidth : "45px" }, // Kernel
					//{sWidth : "45px" }, // 언어
					{sWidth : "50px" }, // 스토리지
					{sWidth : "80px" }, // 가상화진행여부
					{sWidth: "80px"}, // 생성일자
					],
		order : [[2, "asc"], [3, "asc"], [4, "asc"], [5, "asc"], [6, "asc"]]
	} );
</script>