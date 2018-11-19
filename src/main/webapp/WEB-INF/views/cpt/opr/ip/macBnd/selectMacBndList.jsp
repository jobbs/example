<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     송승규         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
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
					<%-- <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="regionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="regionId" id="regionId" whole="true" value="${searchVo.regionId }" title="센터" cssClass="form-control input-sm" onchange="selectZoneDy(this, 'zoneId' )" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="zoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone name="zoneId" id="zoneId" whole="true" value="${searchVo.zoneId }" regionId="${searchVo.regionId }" title="존" cssClass="form-control input-sm" onchange="selectNetDy(this, 'netId' )" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="netId">망</label>
						</div>
						<div class="cell-body">
							<nform:selectNet name="netId" id="netId" whole="true" value="${searchVo.netId }" zoneId="${searchVo.zoneId }" title="망" cssClass="form-control input-sm" onchange="selectPoolDy(this, 'regionId', 'zoneId', 'poolId' )" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="poolId">자원풀</label>
						</div>
						<div class="cell-body">
							<nform:selectPool name="poolId" id="poolId" value="${searchVo.poolId }" regionId="${searchVo.regionId }" zoneId="${searchVo.zoneId }" netId="${searchVo.netId }" title="자원풀" cssClass="form-control input-sm" />
						</div>
					</div> --%>


					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="센터" for="regionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion
					          name="regionId"
					          id="regionId"
					          title="센터"
					          whole="true"
					          wholeText="전체"
					          cssClass="form-control input-sm"
					          value="${searchVo.regionId}"
					          onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'poolId')" />

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
					          regionId="${searchVo.regionId}"
					          value="${searchVo.zoneId }"
					          wholeText="전체"
					          cssClass="form-control input-sm"
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'poolId', {'searchSwTypeCd' : 'COM', searchPoolTypeCd : '01', 'searchCtlTrgtYn' : 'Y'})" />
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
					          wholeText="전체"
					          extra1=""
					          extra2=""
					          extra3=""
					          value="${searchVo.netClCd}"
					          extra4=""
					          extra5=""
					          cssClass="form-control input-sm"
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'poolId', {'searchSwTypeCd' : 'COM', searchPoolTypeCd : '01', 'searchCtlTrgtYn' : 'Y'})"  />
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
						          zoneId="${searchVo.zoneId }"
						          netClCd="${searchVo.netClCd }"
						          value="${searchVo.poolId}"
						          ctlTrgtYn="Y"/>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="macBndNm">MAC대역명</label>
						</div>
						<div class="cell-body">
							<form:input type="text" path="macBndNm" class="form-control input-sm" title="MAC대역명" maxlength="30" />
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="macAddr">MAC주소</label>
						</div>
						<div class="cell-body">
							<form:input type="text" path="macAddr" class="form-control input-sm onlyMac" title="MAC주소" maxlength="17" />
						</div>
					</div>
				</div>
			</div>
			<div class="box-footer collapse in search-collapse">
				<div class="pull-left">
					<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
				</div>
				<div class="pull-right">
					<button type="button" class="btn btn-red"  onclick="fn_selectMacBndList();" title="조회">조회</button>
				</div>
			</div>
		</div>
	</form:form>
</div>
<div class="col-box-100 search-col">
	<div class="box detail-list-box">
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
		<div class="box-body no-padding detail-list-body">
			<form id=macBndView name="macBndView" method="post">
				<table class="table table-hover table-vertical table-layout-fixed" id="macBndTable">
					<caption>MAC대역 목록 테이블</caption>
					<thead>
						<tr>
							<th><input type="checkbox" id="selectAll" title="전체선택"></th>
							<th><nobr>센터</nobr></th>
							<th><nobr>존</nobr></th>
							<th><nobr>망구분</nobr></th>
							<th><nobr>자원풀</nobr></th>
							<th><nobr>MAC대역명</nobr></th>
							<th><nobr>MAC시작주소</nobr></th>
							<th><nobr>MAC종료주소</nobr></th>
							<th><nobr>할당</nobr></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${macBndList eq null or empty macBndList }">
							</c:when>
							<c:otherwise>
								<c:forEach var="macBndVo" items="${macBndList }" varStatus="i">
									<tr>
										<c:url var="detailUrl" value="selectMacBnd.do">
											<c:forEach var="curParam" items="${param }">
												<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
											</c:forEach>
											<c:param name="macBndSeq" value="${macBndVo.macBndSeq }" />
										</c:url>
										<td><input type="checkbox" name="updtCheck" class="updtCheck" value="${macBndVo.macBndSeq }" title="항목선택"></td>
										<td><nobr><c:out value="${macBndVo.regionNm}" /></nobr></td>
										<td><nobr><c:out value="${macBndVo.zoneNm}" /></nobr></td>
										<td class="alignL"><nobr><c:out value="${macBndVo.netClCdNm}" /></nobr></td>
										<td class="alignL"><nobr title="${macBndVo.rsrcPoolNm}"><c:out value="${macBndVo.rsrcPoolNm}" /></nobr></td>
										<td class="alignL"><nobr><a href="<c:url value="${detailUrl }" />" title="<c:out value="${macBndVo.macBndNm}"/> 상세 화면이동"><c:out value="${macBndVo.macBndNm}" /></a></nobr></td>
										<td><nobr><c:out value="${macBndVo.macStrtAddr }" /></nobr></td>
										<td><nobr><c:out value="${macBndVo.macEndAddr }" /></nobr></td>
										<td class="alignR"><nobr><c:out value="${macBndVo.asgnCnt }" /></nobr></td>
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
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="동기화" onclick='fn_sync();'><i class="fa fa-refresh"></i></button>
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
		location.href = "<c:url value='selectMacBndList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {

		$("#searchVo input[type='text']").val("");
		$("#searchVo select").val("").attr("selected", "selected");
	}

	// 목록조회
	function fn_selectMacBndList(){

		$("#searchVo").attr("action", "selectMacBndList.do");
		$("#searchVo").submit();
	}

	// 동기화
	function fn_sync() {

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

		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_syncCallBack,
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

		jConfirm("선택한 MAC대역을 동기화 하시겠습니까?", function(){
			$('#macBndView').attr("action", "updateMacBndIntfcAsgn.do");
			$('#macBndView').ajaxSubmit(options);
		});
	}

	// 동기화콜백
	function fn_syncCallBack(result){

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

		$("#searchVo").attr("action", "selectMacBndListXlsDwnl.do");
		$("#searchVo").submit();
	}

	// 리스트 테이블 정렬
	$("#macBndTable").DataTable( {
		dom: 'Zlfrtip' ,
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns : [
					{sWidth : "30px" },
					{sWidth : "30px" },
					{sWidth : "30px" },
					{sWidth : "60px" },
					{sWidth : "140px" },
					{sWidth : "140px" },
					{sWidth : "120px" },
					{sWidth : "120px" },
					{sWidth : "35px" }
					],
		order : [[1, "asc"], [2, "asc"], [3, "asc"], [4, "asc"], [5, "asc"]]
	} );
</script>