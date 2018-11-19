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
	<form:form commandName="atmsclDistrbVo" method="GET">
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
							<nform:selectRegion name="regionId" id="regionId" cssClass="form-control input-sm" title="센터" value="${atmsclDistrbVo.regionId}" whole="true"
							  byRole="false" onchange="selectZoneByNetClCd('regionId', 'zoneId', 'netClCd', 'rsrcPoolId', {'byRole' : false})" />
						</div>
					</div>

					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="존" for="zoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone name="zoneId" id="zoneId" class="form-control input-sm"	title="존" whole="true" regionId="${atmsclDistrbVo.regionId}"
							value="${atmsclDistrbVo.zoneId}"  byRole="false" onchange="selectPoolByNetClCd('regionId', 'zoneId','netClCd', 'rsrcPoolId' , {'searchPoolTypeCd' : '05', 'byRole' : false})" />
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
								zoneId="${atmsclDistrbVo.zoneId}"
							 	value="${atmsclDistrbVo.netClCd}"
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
						          regionId="${atmsclDistrbVo.regionId }"
						          zoneId="${atmsclDistrbVo.zoneId}"
						          netClCd="${atmsclDistrbVo.netClCd }"
						          value="${atmsclDistrbVo.rsrcPoolId}"
						          ctlTrgtYn=""/>
						</div>
					</div>

					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="institutionNm">부처명</label>
						</div>
						<div class="cell-body">
							<form:input path="institutionNm"  title="부처명" cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="jobNm">업무명</label>
						</div>
						<div class="cell-body">
							<form:input path="jobNm" title="업무명"  cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="lastDistrbVer">배포버전</label>
						</div>
						<div class="cell-body">
							<form:input path="lastDistrbVer" title="배포버전"  cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="statCd">배포상태</label>
						</div>
						<div class="cell-body">
							<form:select path="statCd"  class="form-control input-sm" title="배포상태" >
								<form:option value="">전체</form:option>
								<form:option value="01">처리중</form:option>
								<form:option value="02">완료</form:option>
								<form:option value="03">오류</form:option>
							</form:select>
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="servcAreaNm">서비스영역명</label>
						</div>
						<div class="cell-body">
							<form:input path="servcAreaNm" title="서비스영역명"  cssClass="form-control input-sm" value=""/>
						</div>
					</div>
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="servcNm">서비스명</label>
						</div>
						<div class="cell-body">
							<form:input path="servcNm" title="서비스명"  cssClass="form-control input-sm" value="" />
						</div>
					</div>

                    <div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="imgTag">배포이미지명</label>
						</div>
						<div class="cell-body">
							<form:input path="imgNm" title="배포이미지명" cssClass="form-control input-sm" value="" />
						</div>
					</div>
				</div>
			</div>


				<div class="box-footer collapse in search-collapse">
					<div class="pull-left">
						<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
					</div>
					<div class="pull-right">
						<c:url var="selectAtmsclDistrbListUrl" value="selectAtmsclDistrbList.do"></c:url>
						<button type="button" class="btn btn-red" onclick="fn_selectAtmsclDistrbList();" title="조회">조회</button>
					</div>
				</div>

			</div>

	</form:form>



<div class="box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${atmsclDistrbVo.paginationInfo.currentPageNo } /
				${atmsclDistrbVo.paginationInfo.totalPageCount },
				총 ${atmsclDistrbVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="atmsclDistrbVo" value="${atmsclDistrbVo}"/>
				</div>
			</div>
		</div>
		<div class="box-body no-padding">

				<table class="table table-hover table-vertical" id="atmsclDistrbListTable">
					<caption>대상선택 목록 테이블</caption>

	          	 <thead>
					<tr>
						<th>선택</th>
						<th>배포상태</th>
						<th>부처명</th>
						<th>업무명</th>
						<th>센터</th>
						<th>존</th>
						<th>망구분</th>
						<th>자원풀</th>
						<th>서비스영역명</th>
						<th>서비스명</th>
						<th>배포이미지명</th>
						<th>배포버전</th>
						<th>생성일</th>
                    </tr>
				</thead>

					<tbody>
						<c:forEach var="vo" items="${list}" varStatus="i">

							<tr>

									<td class="alignC">
										<input type="hidden" name="servcNm" value="${vo.servcNm}" />
										<input type="radio" name="servcSeq" value="${vo.servcSeq }" title="서비스SEQ ${vo.servcSeq }"/>
									</td>
									<td class="alignC">
									 <c:choose>
											<c:when test="${vo.statCd =='01'}">
												<span title="${vo.statNm }" class="status status-blue"><c:out value="${vo.statNm }"/></span>
											</c:when>
											<c:when test="${vo.statCd =='02'}">
												<span title="${vo.statNm }" class="status status-green"><c:out value="${vo.statNm }"/></span>
											</c:when>
											<c:when test="${vo.statCd =='03'}">
												<span title="${vo.statNm }" class="status status-red"><c:out value="${vo.statNm }"/></span>
											</c:when>
											<c:when test="${vo.statCd =='04'}">
												<span title="${vo.statNm }" class="status status-aqua"><c:out value="${vo.statNm }"/></span>
											</c:when>

											<c:otherwise></c:otherwise>
										</c:choose>
									</td>
									<td class="alignL"><c:out value="${vo.institutionNm}" /></td>
									<td class="alignL"><c:out value="${vo.jobNm}" /></td>
		                        	<td class="alignC"><c:out value="${vo.regionNm}" /></td>
		                          	<td class="alignC"><c:out value="${vo.zoneNm}" /></td>
		                           	<td class="alignC"><c:out value="${vo.netNm}" /></td>
		                           	<td class="alignL"><c:out value="${vo.rsrcPoolNm}" /></td>
		                           	<td class="alignL"><c:out value="${vo.servcAreaNm}"/></td>
		                           	<td class="alignL"><c:out value="${vo.servcNm}" /></td>
		                           	<td class="alignL"><c:out value="${vo.imgNm}"/></td>
		                           	<td class="alignR"><c:out value="${vo.lastDistrbVer}" /></td>
		                           	<td class="alignC"><c:out value="${vo.creDttm}" /></td>
		                       </tr>
						</c:forEach>
					</tbody>
				</table>
		</div>



		<div class="box-footer">
			<ul class="pagination">
				<ui:pagination paginationInfo="${atmsclDistrbVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
		</div>
</div>
</div>
<div class="col-box-100">
	<div class="button">
		<button type="button" class="btn btn-dark" onclick="selectDistrbS()">선택</button>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectDistrbListViewP.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#atmsclDistrbVo input[type='text']").val("");
		$("#atmsclDistrbVo select").val("").attr("selected", "selected");
	}

	// 배포 목록조회
	function fn_selectAtmsclDistrbList(){

		$("#atmsclDistrbVo").attr('target', '_self');
		$("#atmsclDistrbVo").attr("action", contextPath+'/cmn/component/atmsclDistrb/selectDistrbListViewP.do');
		$("#atmsclDistrbVo").submit();
	}


    $("#atmsclDistrbListTable").DataTable({
        dom : 'Zlfrtip',
        paging : false,
    	searching : false,
    	info : false,
    	bAutoWidth : false,
        aoColumns : [
              {sWidth : "50px" },	// 선택
              {sWidth : "65px" },	// 상태
              {sWidth : "110px" }, 	// 부처
              {sWidth : "110px" }, 	// 업무
              {sWidth : "50px" }, 	// 센터
              {sWidth : "50px" },	// 존
              {sWidth : "80px" },	// 망구분
              {sWidth : "110px" },	// 자원풀
              {sWidth : "140px" },	// 서비스영역명
              {sWidth : "140px" },	// 서비스명
              {sWidth : "140px" },	// 배포이미지명
              {sWidth : "65px" },	// 버전
              {sWidth : "110px" }	// 생성일
        ],
        order : [ [ 0, "desc" ] ]
    });
    function selectDistrbS(){

    	if( $("input:radio[name='servcSeq']:checked").size() == 0 ) {
    		jAlert("대상을 선택하여 주시기 바랍니다.");
    		return;
    	}

    	var data = null;
    	$("input:radio[name='servcSeq']").each(function(index) {
    		if( $(this).prop("checked") ) {
    			data = new EntityInstitution();
    			data.servcSeq = $(this).val();
    			data.servcNm = $("input:hidden[name='servcNm']:eq(" + index + ")").val();
    		}
    	});

    	var evt = jQuery.Event('selectDistrb', {
    		"procType" : "<c:out value="${atmsclDistrbVo.searchType}" />",
    		"datas" : data
        });

        var _parent = window.opener;
        _parent.jQuery(_parent.document).trigger(evt);
        window.close();
    }

    $("#atmsclDistrbListTable input[name='servcSeq']").parent().parent().click(function() {
    	var $target = $(this).find("input[name='servcSeq']");
    	if( $target.attr("type") == "radio" ) {
    		$target.prop("checked", true);
    	} else {
    		var checked = $target.prop("checked");
    		$target.prop("checked", !checked);
    	}
    });

</script>