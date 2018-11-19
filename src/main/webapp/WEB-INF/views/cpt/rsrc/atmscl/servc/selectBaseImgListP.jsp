<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre>베이스이미지 선택 화면</pre>
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
			<form:hidden path="regionId" />
			<form:hidden path="zoneId" />
			<form:hidden path="netClCd" />
			<form:hidden path="rsrcPoolId" />


			<div class="box-body">

				<div class="form-group">


					<!--
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
					          onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false, 'searchSwTypeCd' : 'ATMSCL','searchPoolTypeCd':'05'})" />
						</div>
					</div>


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
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false, 'searchSwTypeCd' : 'ATMSCL','searchPoolTypeCd':'05'})" />
						</div>
					</div>


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
					          onchange="selectPoolByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'searchCtlTrgtYn' : '','byRole' : false, 'searchSwTypeCd' : 'ATMSCL','searchPoolTypeCd':'05'})"  />
						</div>
					</div>

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
					-->

					<div class="form-cell form-cell-70 col-lay-25">
			            <div class="cell-title">
			                <label title="이미지유형" for=imgTyCd>이미지유형</label>
			            </div>
			            <div class="cell-body">
			                <nform:selectCode
			                            parentCd="300"
			                            parentGrpCd="099"
			                            name="imgTyCd"
			                            id="imgTyCd"
			                            whole="true"
			                            cssClass="form-control input-sm"
			                            value="${searchVo.imgTyCd}"  />
			            </div>
			        </div>

					<div class="form-cell form-cell-70 col-lay-25">
						<div class="cell-title">
							<label for="imgNm">이미지명</label>
						</div>
						<div class="cell-body">
							<div class="input-group">
								<form:input path="imgNm" type="text" class="form-control input-sm pull-right" maxlength="60" title="이미지명" />
							</div>
						</div>
					</div>

					<div class="form-cell form-cell-100 alignR pad-top-5">
						<div class="pull-left">
					    	<button type="button" class="btn btn-sm" onclick="fn_initialize();">초기화</button>
					  	</div>
					  	<div class="pull-right">
							<button class="btn btn-red btn-sm" type="button" onclick="fn_selectBaseImgList()">조회</button>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- 베이스이미지 테이블 영역 -->
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
		<form:form commandName="imgVo" id="baseImgFrm" method="get">
			<div class="box-body no-padding" style="overflow-x:auto;">
				<table class="table table-hover table-vertical table-layout-fixed" id="baseImgTable">
					<caption>베이스 이미지 목록 테이블</caption>
					<thead>
						<tr>
							<th>선택</th>
							<th>센터</th>
							<th>존</th>
							<th>망구분</th>
							<th>자원풀</th>
							<th>이미지유형</th>
							<th>이미지명</th>
							<th>용량(GB)</th>
							<th>생성자</th>
							<th>생성일시</th>
							<th>수정자</th>
							<th>수정일시</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${list eq null or empty list }">
							</c:when>
							<c:otherwise>
								<c:forEach var="baseImgVo" items="${list }" varStatus="i">
									<tr>
										<td class="alignC">
											<input type="radio" id="imgId" name ="imgId" value="${baseImgVo.imgId }" title="${baseImgVo.imgId}_선택" />
											<input type="hidden" id="baseImgVo_${baseImgVo.imgId}_imgNm"  value="${baseImgVo.imgNm }"/>
											<input type="hidden" id="baseImgVo_${baseImgVo.imgId}_imgVer"  value="${baseImgVo.imgVer }"/>
											<input type="hidden" id="baseImgVo_${baseImgVo.imgId}_servcAreaSeq"  value="${baseImgVo.servcAreaSeq }"/>
											<input type="hidden" id="baseImgVo_${baseImgVo.imgId}_servcAreaId"  value="${baseImgVo.servcAreaId }"/>
										</td>
										<td class="alignL"><c:out value="${baseImgVo.regionNm}" /></td>
										<td class="alignL"><c:out value="${baseImgVo.zoneNm}" /></td>
										<td class="alignL"><c:out value="${baseImgVo.netNm}" /></td>
										<td class="alignC"><c:out value="${baseImgVo.rsrcPoolNm}" /></td>
										<td class="alignL"><c:out value="${baseImgVo.imgTyCdNm }" /></td>
										<td class="alignL"><c:out value="${baseImgVo.imgNm }" /></td>
										<td class="alignR"><c:out value="${baseImgVo.imgCapa }" /></td>
										<td><c:out value="${baseImgVo.creUserNm }" /></td>
										<td><c:out value="${baseImgVo.creDttm }" /></td>
										<td><c:out value="${baseImgVo.updtUserNm }" /></td>
										<td><c:out value="${baseImgVo.updtDttm }" /></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
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
  	<button type="button" class="btn btn-dark" onclick="fn_selectBaseImg()">선택</button>
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
	location.href = "selectBaseImgListPView.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}


// 조회
function fn_selectBaseImgList(){

	$('#searchVo').attr('target', '_self');
	$('#searchVo').attr('action', '<c:url var="select" value="selectBaseImgListPView.do"/>');
	$('#searchVo').submit();
}


//베이스이미지선택
function fn_selectBaseImg(){

	var imgId = $("input:radio[name='imgId']:checked").val();

	if(imgId=='' || imgId== undefined){
		jAlert("베이스 이미지를 선택해 주세요.");
	}else{
		var baseImgVo = {
				imgId : imgId
				, imgNm : $("#baseImgVo_"+imgId+"_imgNm" ).val()
				, imgVer : $("#baseImgVo_"+imgId+"_imgVer" ).val()
				, baseImgServcAreaId : $("#baseImgVo_"+imgId+"_servcAreaId" ).val()
				, baseImgServcAreaSeq : $("#baseImgVo_"+imgId+"_servcAreaSeq" ).val()
		};

		window.opener.fn_selectedBaseImg(baseImgVo);
		self.close();
	}
}


$("#baseImgFrm input[name='imgId']").parent().parent().click(function() {
	var $target = $(this).find("input[name='imgId']");
	$target.prop("checked", true);
});


$("#baseImgTable").DataTable( {
	dom: 'Zlfrtip' ,
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
				{sWidth : "30px" },
				{sWidth : "28px" },
	      		{sWidth : "60px" },
	      		{sWidth : "60px" },
	      		{sWidth : "80px" },
				{sWidth : "65px" },
				{sWidth : "80px" },
				{sWidth : "40px" },
				{sWidth : "50px" },
				{sWidth : "70px" },
				{sWidth : "50px" },
				{sWidth : "70px" }
				],
	order : [[1, "asc"], [2, "asc"]]
} );

</script>