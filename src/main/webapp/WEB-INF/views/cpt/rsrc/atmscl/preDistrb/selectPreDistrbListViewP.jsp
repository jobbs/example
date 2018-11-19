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

<div class="col-box-100">
		<form:form commandName="preDistrbVo" method="GET">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>
	<div class="box-search">
		<div class="box-body">
				<div class="form-group">
					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="센터" for="regionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion name="regionId" id="regionId" cssClass="form-control input-sm" title="센터" value="${preDistrbVo.regionId}" whole="true"
							  byRole="false" onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false})" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="존" for="zoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone name="zoneId" id="zoneId" class="form-control input-sm"	title="존" whole="true" regionId="${preDistrbVo.regionId}"
							value="${preDistrbVo.zoneId}"  byRole="false" onchange="selectPoolByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId' , {'searchPoolTypeCd' : '05', 'byRole' : false})" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="망구분" for="netClCd">망구분 </label>
						</div>
						<div class="cell-body">
						<nform:selectCode name="netClCd" id="netClCd" title="망" cssClass="form-control input-sm"
								whole="true"
								parentCd="NETCD"
          						parentGrpCd="067"
								zoneId="${preDistrbVo.zoneId}"
							 	value="${preDistrbVo.netClCd}"
							 	byRole="false"
								onchange="selectPoolByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId', {'searchPoolTypeCd' : '05', 'byRole' : false  } )" />
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
						          regionId="${preDistrbVo.regionId }"
						          zoneId="${preDistrbVo.zoneId}"
						          netClCd="${preDistrbVo.netClCd }"
						          value="${preDistrbVo.rsrcPoolId}"
						          ctlTrgtYn=""/>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="institutionNm">부처</label>
						</div>
						<div class="cell-body">
							<form:input path="institutionNm"  title="부처" cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="jobNm">업무</label>
						</div>
						<div class="cell-body">
							<form:input path="jobNm" title="업무"  cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="imgNm">이미지명</label>
						</div>
						<div class="cell-body">
							<form:input path="imgNm" title="이미지명"  cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="imgVer">이미지버전</label>
						</div>
						<div class="cell-body">
							<form:input path="imgVer" title="이미지버전"  cssClass="form-control input-sm" value=""/>
						</div>
					</div>

					<div class="box-footer collapse in search-collapse">
						<div class="pull-left">
							<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
						</div>
						<div class="pull-right">
							<button type="button" class="btn btn-red" onclick="fn_selectPreDistrbList();" title="조회">조회</button>
						</div>
					</div>

				</div>
			</div>
	</div>
	</form:form>

<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${preDistrbVo.paginationInfo.currentPageNo } /
				${preDistrbVo.paginationInfo.totalPageCount },
				총 ${preDistrbVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="preDistrbVo" value="${preDistrbVo}"/>
				</div>
			</div>
		</div>
		<div class="box-body no-padding detail-list-body">

				<table class="table table-hover table-horizon table-layout-fixed" id="preDistrbListTable">
					<caption>이미지 목록 테이블</caption>

	          	 <thead>
					<tr>
						<th>선택</th>
						<th>부처</th>
						<th>업무</th>
						<th>센터</th>
						<th>존</th>
						<th>망구분</th>
						<th>자원풀</th>
						<th>서비스명</th>
						<th>이미지 저장소</th>
						<th>이미지명</th>
						<th>버전</th>
						<th>생성일</th>
                    </tr>
				</thead>

					<tbody>
						<c:forEach var="vo" items="${list}" varStatus="i">

							<tr>

									<td class="alignC">
									    <input type="hidden" name="imgId" value="${vo.imgId}" />
										<input type="hidden" name="imgNm" value="${vo.imgNm}" />
										<input type="hidden" name="rsrcPoolId" value="${vo.rsrcPoolId}" />
										<input type="hidden" name="regionId" value="${vo.regionId}" />
										<input type="hidden" name="zoneId" value="${vo.zoneId}" />
										<input type="hidden" name="netClCd" value="${vo.netClCd}" />
										<input type="hidden" name="servcAreaId" value="${vo.servcAreaId}" />
										<input type="hidden" name="servcAreaSeq" value="${vo.servcAreaSeq}" />
										<input type="hidden" name="imgRepoDtlAddr" value="${vo.imgRepoDtlAddr}" />
										<!--이미지 기본정보 셋팅  -->
										<input type="hidden" name="imgVer" value="${vo.imgVer}" />
										<input type="hidden" name="institutionNm" value="${vo.institutionNm}" />
										<input type="hidden" name="jobNm" value="${vo.jobNm}" />
										<input type="hidden" name="regionNm" value="${vo.regionNm}" />
										<input type="hidden" name="zoneNm" value="${vo.zoneNm}" />
										<input type="hidden" name="netNm" value="${vo.netNm}" />
										<input type="hidden" name="rsrcPoolNm" value="${vo.rsrcPoolNm}" />
										<input type="hidden" name="creDttm" value="${vo.creDttm}" />
										<input type="hidden" name="servcNm" value="${vo.servcNm}" />

										<input type="radio" name="servcAreaSeq" value="${vo.servcAreaSeq }" title="서비스SEQ ${vo.servcAreaSeq }"/>
									</td>
									<td class="alignL"><c:out value="${vo.institutionNm}" /></td>
									<td class="alignL"><c:out value="${vo.jobNm}" /></td>
		                        	<td class="alignC"><c:out value="${vo.regionNm}" /></td>
		                          	<td class="alignC"><c:out value="${vo.zoneNm}" /></td>
		                           	<td class="alignC"><c:out value="${vo.netNm}" /></td>
		                           	<td class="alignL"><c:out value="${vo.rsrcPoolNm}" /></td>
		                           	<td class="alignL"><c:out value="${vo.servcNm}" /></td>
		                           	<td class="alignL"><c:out value="${vo.imgRepoDtlAddr}"/></td>
		                           	<td class="alignL"><c:out value="${vo.imgNm}"/></td>
		                           	<td class="alignR"><c:out value="${vo.imgVer}" /></td>
		                           	<td class="alignC"><c:out value="${vo.creDttm}" /></td>

		                       </tr>
						</c:forEach>
					</tbody>
				</table>
		</div>



		<div class="box-footer ">
			<ul class="pagination">
				<ui:pagination paginationInfo="${preDistrbVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
	</div>
</div>

<div class="col-box-100">
	<div class="button">
		<menu:authorize>
			<button type="button" class="btn btn-dark" onclick="selectPreDistrbS()">선택</button>
		</menu:authorize>
		<button type="button" class="btn close-window">닫기</button>
	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectPreDistrbListViewP.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#preDistrbVo input[type='text']").val("");
		$("#preDistrbVo select").val("").attr("selected", "selected");
	}

	// 이미지 목록조회
	function fn_selectPreDistrbList(){

		$("#preDistrbVo").attr('target', '_self');
		$("#preDistrbVo").attr("action", "<c:url value='selectPreDistrbListViewP.do'/>");
		$("#preDistrbVo").submit();
	}

     $("#preDistrbListTable").DataTable({
    	    dom : 'Zlfrtip',
    	    paging : false,
    		searching : false,
    		info : false,
    		bAutoWidth : false,
        aoColumns : [
              {sWidth : "60px" },	// No
              {sWidth : "140px" }, 	// 부처
              {sWidth : "90px" }, 	// 업무
              {sWidth : "60px" }, 	// 센터
              {sWidth : "60px" },	// 존
              {sWidth : "80px" },	// 망구분
              {sWidth : "130px" },	// 자원풀
              {sWidth : "150px" },	// 서비스명
              {sWidth : "210px" },	// 이미지 저장소
              {sWidth : "140px" },	// 이미지명
              {sWidth : "50px" },	// 버전
              {sWidth : "110px" }	// 생성일
        ],
        order : [ [ 0, "desc" ] ]
    });
    function selectPreDistrbS(){

    	if( $("input:radio[name='servcAreaSeq']:checked").size() == 0 ) {
    		jAlert("대상을 선택하여 주시기 바랍니다.");
    		return;
    	}

    	var data = null;
    	$("input:radio[name='servcAreaSeq']").each(function(index) {
    		if( $(this).prop("checked") ) {
    			data = new EntityInstitution();
    			data.servcAreaSeq = $(this).val();
    			data.imgNm = $("input:hidden[name='imgNm']:eq(" + index + ")").val();
    			data.imgId = $("input:hidden[name='imgId']:eq(" + index + ")").val();
    			data.imgRepoDtlAddr = $("input:hidden[name='imgRepoDtlAddr']:eq(" + index + ")").val();
    			data.rsrcPoolId = $("input:hidden[name='rsrcPoolId']:eq(" + index + ")").val();
    			data.servcAreaId = $("input:hidden[name='servcAreaId']:eq(" + index + ")").val();
    			data.servcAreaSeq = $("input:hidden[name='servcAreaSeq']:eq(" + index + ")").val();
    			data.regionId = $("input:hidden[name='regionId']:eq(" + index + ")").val();
    			data.zoneId = $("input:hidden[name='zoneId']:eq(" + index + ")").val();
    			data.netClCd = $("input:hidden[name='netClCd']:eq(" + index + ")").val();
    			//대상 이미지 기본정보 셋팅
    			data.imgVer = $("input:hidden[name='imgVer']:eq(" + index + ")").val();
    			data.institutionNm = $("input:hidden[name='institutionNm']:eq(" + index + ")").val();
    			data.jobNm = $("input:hidden[name='jobNm']:eq(" + index + ")").val();
    			data.regionNm = $("input:hidden[name='regionNm']:eq(" + index + ")").val();
    			data.zoneNm = $("input:hidden[name='zoneNm']:eq(" + index + ")").val();
    			data.netNm = $("input:hidden[name='netNm']:eq(" + index + ")").val();
    			data.rsrcPoolNm = $("input:hidden[name='rsrcPoolNm']:eq(" + index + ")").val();
    			data.creDttm = $("input:hidden[name='creDttm']:eq(" + index + ")").val();
    			data.servcNm = $("input:hidden[name='servcNm']:eq(" + index + ")").val();

    		}
    	});

    	var evt = jQuery.Event('selectPreDistrb', {
    		"procType" : "<c:out value="${preDistrbVo.searchType}" />",
    		"datas" : data
        });

        var _parent = window.opener;
        _parent.jQuery(_parent.document).trigger(evt);
        window.close();
    }
    $("#preDistrbListTable input[name='servcAreaSeq']").parent().parent().click(function() {
    	var $target = $(this).find("input[name='servcAreaSeq']");
    	if( $target.attr("type") == "radio" ) {
    		$target.prop("checked", true);
    	} else {
    		var checked = $target.prop("checked");
    		$target.prop("checked", !checked);
    	}
    });


</script>