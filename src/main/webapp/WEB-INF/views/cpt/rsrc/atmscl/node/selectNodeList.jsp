<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 04. 28.
 * @lastmodified 2017. 04. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 04. 28.     x         v1.0             최초생성
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
							<label title="센터" for="regionId">센터</label>
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
					          onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false,'searchPoolTypeCd':'05'})" />
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
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false,'searchPoolTypeCd':'05'})" />
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
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'searchCtlTrgtYn' : '','byRole' : false, 'searchPoolTypeCd':'05'})"  />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="자원풀" for="rsrcPoolId">자원풀</label>
						</div>
						<div class="cell-body">
							<nform:selectPool
						          name="rsrcPoolId"
						          id="rsrcPoolId"
						          title="자원풀"
						          wholeText="전체"
						          poolTypeCd="05"
						          cssClass="form-control input-sm"
						          swTypeCd="ATMSCL"
						          regionId="${searchVo.regionId }"
						          zoneId="${searchVo.zoneId}"
						          netClCd="${searchVo.netClCd }"
						          value="${searchVo.rsrcPoolId}"
						          ctlTrgtYn=""/>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
			            <div class="cell-title">
			                <label title="상태" for="statCd">상태</label>
			            </div>
			            <div class="cell-body">
			                <nform:selectCode
			                            parentCd="301"
			                            parentGrpCd="100"
			                            name="statCd"
			                            id="statCd"
			                            whole="true"
			                            cssClass="form-control input-sm"
			                            value="${searchVo.statCd}" />
			            </div>
			        </div>

			        <div class="form-cell form-cell-50 col-lay-25">
			            <div class="cell-title">
			                <label title="노드유형" for="atmsclNodeTyCd">노드유형</label>
			            </div>
			            <div class="cell-body">
			                <nform:selectCode
			                            parentCd="302"
			                            parentGrpCd="101"
			                            name="atmsclNodeTyCd"
			                            id="atmsclNodeTyCd"
			                            whole="true"
			                            cssClass="form-control input-sm"
			                            value="${searchVo.atmsclNodeTyCd}" />
			            </div>
			        </div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="atmsclNodeNm">노드명</label>
						</div>
						<div class="cell-body">
							<form:input type="text" path="atmsclNodeNm" class="form-control input-sm pull-right" maxlength="30" title="노드명" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
	                    <div class="cell-title">
	                        <label for="atmsclNodeIpAddr">IP주소</label>
	                    </div>
	                    <div class="cell-body">
	                        <form:input type="text" path="atmsclNodeIpAddr" class="form-control input-sm pull-right" maxlength="30" title="IP주소" />
	                    </div>
	                </div>

			    </div>

				<div class="box-footer collapse in search-collapse">
					<div class="pull-left">
						<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
					</div>
					<div class="pull-right">
						<button type="button" class="btn btn-red" onclick="fn_selectNodeList();" title="조회">조회</button>
					</div>
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
			<form id="servcAreaView" name="servcAreaView" method="post">
				<table class="table table-hover table-vertical table-layout-fixed" id="nodeTable">
					<caption>노드 목록 테이블</caption>
					<thead>
                    	<tr>
                          	<th>상태</th>
							<th>센터</th>
							<th>존</th>
							<th>망구분</th>
							<th>자원풀</th>
							<th>노드유형</th>
							<th>노드명</th>
							<th>IP주소</th>
							<th>Pod수</th>
							<th>CPU<br>보유 Core</th>
							<th>CPU<br>할당 Core</th>
							<th>CPU<br>사용률(%)</th>
							<th>메모리<br>보유량(GB)</th>
							<th>메모리<br>할당량(GB)</th>
							<th>메모리<br>사용률(%)</th>
							<th>네트워크<br>In(KB/Sec)</th>
							<th>네트워크 <br>Out(KB/Sec)</th>
							<th>생성일자</th>
                      	</tr>
                    </thead>

					<tbody>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<tr>
								<c:url var="detailUrl" value="selectNode.do">
									<c:forEach var="curParam" items="${param }">
										<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
									</c:forEach>
									<c:param name="nodeRsrcPoolId" value="${vo.rsrcPoolId }" />
									<c:param name="atmsclNodeId" value="${vo.atmsclNodeId }" />
								</c:url>

								<td class="alignL">
									<c:if test="${null ne vo.statCd}">
										<div class="server-info server
											<c:choose>
												<c:when test='${"01" eq vo.statCd}'><c:out value="server-up"/></c:when>
												<c:when test='${"02" eq vo.statCd}'><c:out value="server-down"/></c:when>
												<c:when test='${"03" eq vo.statCd}'><c:out value="server-inprogress"/></c:when>
												<c:when test='${"04" eq vo.statCd}'><c:out value="server-exception"/></c:when>
									   			<c:otherwise></c:otherwise>
											</c:choose>
										">
											<div class="server-info-body alignL">
												<div class="server-info-box alignL">
													<span title="<c:out value="${vo.statCdNm }" />" class="label"></span><h4 title="<c:out value="${vo.statCdNm }" />" class="stat"><c:out value="${vo.statCdNm }" /></h4>
												</div>
											</div>
										</div>
									</c:if>
								</td>
								<td class="alignL"><c:out value="${vo.regionNm}" /></td>
								<td class="alignL"><c:out value="${vo.zoneNm}" /></td>
								<td class="alignL"><c:out value="${vo.netNm}" /></td>
								<td class="alignL"><c:out value="${vo.rsrcPoolNm}" /></td>
								<td class="alignL"><c:out value="${vo.atmsclNodeTyCdNm}" /></td>
								<td class="alignL">
								    <a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.atmsclNodeNm}"/> 상세 화면이동"><c:out value="${vo.atmsclNodeNm}" /></a>
								</td>
								<td class="alignC"><c:out value="${vo.atmsclNodeIpAddr}" /></td>
								<td class="alignR"><c:out value="${vo.podQty}" /></td>
								<td class="alignR"><c:out value="${vo.cpuCorQty}" /></td>
								<td class="alignR"><c:out value="${vo.sumCpuCorQty}" /></td>
								<td class="notellipsis">
									<span title="<fmt:formatNumber value="${vo.avgCpuUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${vo.avgCpuUseRt}" pattern="0"/></span>
									<div title="<fmt:formatNumber value="${vo.avgCpuUseRt}" pattern="0"/>" class="progress">
										<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${vo.avgCpuUseRt}" pattern="0"/>%"></div>
									</div>
								</td>
								<td class="alignR"><c:out value="${vo.memAsgnCapa}" /></td>
								<td class="alignR"><c:out value="${vo.sumMemAsgnCapa}" /></td>
								<td class="notellipsis">
									<span title="<fmt:formatNumber value="${vo.avgMemUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${vo.avgMemUseRt}" pattern="0"/></span>
									<div title="<fmt:formatNumber value="${vo.avgMemUseRt}" pattern="0"/>" class="progress">
										<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${vo.avgMemUseRt}" pattern="0"/>%"></div>
									</div>
								</td>
								<td class="alignR"><c:out value="${vo.netwkIn}" /></td>
								<td class="alignR"><c:out value="${vo.netwkOut}" /></td>
								<td class="alignC"><c:out value="${vo.creDttm}" /></td>
		                       </tr>
						</c:forEach>
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
				<c:url var="insertUrl" value="insertNodeView.do">
                        <c:forEach var="curParam" items="${param }">
                            <c:param name="${curParam.key }" value="${curParam.value }"></c:param>
                        </c:forEach>
                    </c:url>
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="노드 생성" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
				</menu:authorize>
			</div>


		</div>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function() {

	});

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectNodeList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#searchVo input[type='text']").val("");
		$("#searchVo select").val("").attr("selected", "selected");
	}

	// 서비스영역 목록조회
	function fn_selectNodeList(){

		$("#searchVo").attr("action", "selectNodeList.do");
		$("#searchVo").submit();
	}



	// 엑셀 다운로드
	function fn_downloadExcel() {
		if("${searchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드할 데이터가 없습니다");
			return;
		}

		$("#searchVo").attr("action", "selectNodeListXlsDwnl.do");
		$("#searchVo").submit();
	}



    $("#nodeTable").DataTable({
        dom : 'Zlfrtip',
        paging : false,
        searching : false,
        info : false,
        aoColumns : [
            {sWidth : "74px" }, //상태
            {sWidth : "28px" }, //센터
      		{sWidth : "60px" }, //존
      		{sWidth : "60px" }, //망구분
      		{sWidth : "80px" }, //자원풀
      		{sWidth : "80px" }, //노드유형
      		{sWidth : "188px" }, //노드명
      		{sWidth : "95px" }, //IP주소
      		{sWidth : "55px" }, //POD수
      		{sWidth : "80px" }, //CPU 보유 Core
            {sWidth : "80px" }, //CPU 할당 Core
			{sWidth : "80px" }, //CPU 사용률
			{sWidth : "80px" }, //메모리 qhdb량
			{sWidth : "80px" }, //메모리 할당량
			{sWidth : "80px" }, //메모리 사용률
			{sWidth : "80px" }, //네트워크In
			{sWidth : "80px" }, //네트워크Out
			{sWidth : "80px" }, //생성일자
        ],
        order : [ [ 0, "desc" ] ]
        ,columnDefs:[{type:'ip-address', targets:[7]}]
    });


</script>
