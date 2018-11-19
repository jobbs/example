<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre>서비스영역 선택 화면</pre>
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
 * 2017. 05. 13.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<!-- 검색조건 영역 -->
	<div class="box-search">
		<!-- box-header -->
		<form:form id="searchVo" commandName="searchVo" method="GET">
			<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage" />
			<div class="box-body">
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
					          byRole="false"
					          wholeText="전체"
					          extra1=""
					          extra2=""
					          extra3=""
					          value="${searchVo.netClCd}"
					          extra4=""
					          extra5=""
					          cssClass="form-control input-sm"
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false,'searchPoolTypeCd':'05'})"  />
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
							<label for="institutionNm">부처</label>
						</div>
						<div class="cell-body">
							<form:input type="text" path="institutionNm" class="form-control input-sm pull-right" maxlength="30" title="부처명" />
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
	                    <div class="cell-title">
	                        <label for="servcAreaNm">서비스영역명</label>
	                    </div>
	                    <div class="cell-body">
	                        <form:input type="text" path="servcAreaNm" class="form-control input-sm pull-right" maxlength="30" title="서비스영역명" />
	                    </div>
	                </div>

	                <div class="form-cell form-cell-50 col-lay-25">
	                    <div class="cell-title">
	                        <label for="servcAreaCompId">서비스영역구성ID</label>
	                    </div>
	                    <div class="cell-body">
	                        <form:input type="text" path="servcAreaCompId" class="form-control input-sm pull-right" maxlength="10" title="서비스영역구성ID" />
	                    </div>
	                </div>

	                <div class="form-cell form-cell-100 alignR pad-top-5">
						<div class="pull-left">
					    	<button type="button" class="btn btn-sm" onclick="fn_initialize();">초기화</button>
					  	</div>
					  	<div class="pull-right">
							<button class="btn btn-red btn-sm" type="button" onclick="fn_selectServcAreaList()">조회</button>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>

	<div class="box">
		<div class="box-header">
			<h3 class="box-title">
				검색결과<small> ${searchVo.paginationInfo.currentPageNo }
					/ ${searchVo.paginationInfo.totalPageCount }, 총
					${searchVo.paginationInfo.totalRecordCount }건 </small>
			</h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="searchVo" value="${searchVo }"/>
				</div>
			</div>
		</div>
		<!-- /box-header -->
		<!-- box-body -->
		<form:form commandName="servcAreaVo" id="servcAreaFrm" method="get">
			<div class="box-body no-padding" style="overflow-x:auto;">
				<table class="table table-hover table-vertical table-layout-fixed" id="atmSclServcAreaTable">
					<caption>서비스영역 목록 테이블</caption>
					<thead>
                      <tr>
                        <th>선택</th>
                        <th>부처</th>
                        <th>센터</th>
                        <th>존</th>
                        <th>망구분</th>
                        <th>자원풀</th>
                        <th>서비스영역명</th>
                        <th>서비스영역구성ID</th>
                        <th>생성자</th>
                        <th>생성일자</th>
                        <th>수정자</th>
                        <th>수정일자</th>
                      </tr>
                    </thead>
					<tbody>
						<c:forEach var="vo" items="${list }" varStatus="i">
							<tr>
								<td class="alignC">
									<input type="radio" id="servcAreaSeq" name ="servcAreaSeq" value="${vo.servcAreaSeq }" title="${vo.servcAreaSeq}_선택" />
									<input type="hidden" id="servcAreaVo_${vo.servcAreaSeq}_servcAreaNm"  value="${vo.servcAreaNm }"/>
									<input type="hidden" id="servcAreaVo_${vo.servcAreaSeq}_servcAreaId"  value="${vo.servcAreaId }"/>
									<input type="hidden" id="servcAreaVo_${vo.servcAreaSeq}_rsrcPoolId"  value="${vo.rsrcPoolId }"/>
									<input type="hidden" id="servcAreaVo_${vo.servcAreaSeq}_regionId"  value="${vo.regionId }"/>
									<input type="hidden" id="servcAreaVo_${vo.servcAreaSeq}_zoneId"  value="${vo.zoneId }"/>
									<input type="hidden" id="servcAreaVo_${vo.servcAreaSeq}_netClCd"  value="${vo.netClCd }"/>
								</td>
								<td class="alignL"><c:out value="${vo.institutionNm}" /></td>
		                           <td class="alignL"><c:out value="${vo.regionNm}" /></td>
		                           <td class="alignL"><c:out value="${vo.zoneNm}" /></td>
		                           <td class="alignL"><c:out value="${vo.netNm}" /></td>
		                           <td class="alignC"><c:out value="${vo.rsrcPoolNm}" /></td>
		                           <td class="alignL"><c:out value="${vo.servcAreaNm}" /></td>
		                           <td class="alignC"><c:out value="${vo.servcAreaCompId}" /></td>
		                           <td class="alignC"><c:out value="${vo.creUserNm}" /></td>
		                           <td class="alignC"><c:out value="${vo.creDttm}" /></td>
		                           <td class="alignC"><c:out value="${vo.updtUserNm}" /></td>
		                           <td class="alignC"><c:out value="${vo.updtDttm}" /></td>
		                       </tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="box-footer">
				<ul class="pagination">
					<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
				</ul>
			</div>
		</form:form>

		<!-- /box-body -->
	</div>
</div>
<!-- popup 버튼 -->
<div class="col-box-100">
  <div class="button">
  	<button type="button" class="btn btn-dark" onclick="fn_selectServcArea()">선택</button>
  	<button type="button" class="btn close-window" >닫기</button>
   </div>
</div>
<!-- /popup 버튼 -->

<script type="text/javascript">

//검색조건 초기화
function fn_initialize(){
	$('#searchVo input[type="text"]').val('');
}


//페이지 이동
function fn_goPage(page){
	location.href = "selectServcAreaListPView.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}


// 조회
function fn_selectServcAreaList(){

	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url var="select" value="selectServcAreaListPView.do"/>');
	$('#searchVo').submit();
}


//서비스영역 선택
function fn_selectServcArea(){

	var servcAreaSeq = $("input:radio[name='servcAreaSeq']:checked").val();

	if(servcAreaSeq=='' || servcAreaSeq== undefined){
		jAlert("서비스영역을 선택해 주세요.");
	}else{

		var servcAreaVo = {
				servcAreaSeq : servcAreaSeq
				, servcAreaId : $("#servcAreaVo_"+servcAreaSeq+"_servcAreaId" ).val()
				, servcAreaNm : $("#servcAreaVo_"+servcAreaSeq+"_servcAreaNm" ).val()
				, rsrcPoolId: $("#servcAreaVo_"+servcAreaSeq+"_rsrcPoolId" ).val()
				, regionId: $("#servcAreaVo_"+servcAreaSeq+"_regionId" ).val()
				, zoneId: $("#servcAreaVo_"+servcAreaSeq+"_zoneId" ).val()
				, netClCd: $("#servcAreaVo_"+servcAreaSeq+"_netClCd" ).val()
		};


		window.opener.fn_selectedServcArea(servcAreaVo);
		self.close();
	}
}


$("#servcAreaFrm input[name='servcAreaSeq']").parent().parent().click(function() {
	var $target = $(this).find("input[name='servcAreaSeq']");
	$target.prop("checked", true);
});


$("#atmSclServcAreaTable").DataTable({
    dom : 'Zlfrtip',
    paging : false,
    searching : false,
    info : false,
    aoColumns : [
          {sWidth : "50px" },
          {sWidth : "80px" },
          {sWidth : "28px" },
    	  {sWidth : "60px" },
    	  {sWidth : "60px" },
    	  {sWidth : "80px" },
          {sWidth : "130px" },
          {sWidth : "85px" },
          {sWidth : "85px" },
          {sWidth : "85px" },
          {sWidth : "85px" },
          {sWidth : "85px" }
    ],
    order : [ [ 0, "desc" ] ]
});

</script>