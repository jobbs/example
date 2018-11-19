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
	<form:form id="gitUserSearchVo" commandName="gitUserSearchVo" method="GET">
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
				
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label for="institutionNm">부처명</label>
						</div>
						<div class="cell-body">
							<form:input type="text" path="institutionNm" class="form-control input-sm pull-right" maxlength="30" title="부처명" />
						</div>
					</div>
	
					<div class="form-cell form-cell-50 col-lay-30">
						<div class="cell-title">
							<label for="gitUserNm">Git사용자명</label>
						</div>
						<div class="cell-body">
							<input id="gitUserNm" name="gitUserNm" class="form-control input-sm" title="Git사용자명" type="text" value="">
						</div>
						</div>
					<div class="form-cell form-cell-50 col-lay-30">
						<div class="cell-title">
							<label for="gitUserId">Git사용자ID</label>
						</div>
						<div class="cell-body">
							<input id="gitUserId" name="gitUserId" class="form-control input-sm" title="사용자ID" type="text" value="">
						</div>
					</div>
					

              
				</div>
			</div>

				<div class="box-footer collapse in search-collapse">
					<div class="pull-left">
						<button type="button" class="btn" onclick="fn_reset();" title="검색조건 초기화">초기화</button>
					</div>
					<div class="pull-right">
						<button type="button" class="btn btn-red" onclick="fn_selectServcAreaList();" title="조회">조회</button>
					</div>
				</div>
				
			</div>
			
	</form:form>
</div>


<div class="col-box-100 search-col"> 
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${bldVo.paginationInfo.currentPageNo } /
				${bldVo.paginationInfo.totalPageCount },
				총 ${bldVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="bldSearchVo" value="${bldVo }"/>
					<div class="input-group-cell pad-right">
						<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_downloadExcel();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div> 
		</div>
		<div class="box-body no-padding detail-list-body">
			<form id="servcAreaView" name="servcAreaView" method="post">
				<table class="table table-hover table-vertical table-layout-fixed" id="atmSclServcAreaTable">
					<caption>서비스영역 목록 테이블</caption>
					
					<colgroup>
                      <col class="col3">
                      <col class="col8">
                      <col class="col8">
                      <col class="col8">
                      <col class="col8">
                      <col class="col8">
                    </colgroup>

					<thead>
                      <tr>
                        <th>No.</th>
                        <th>Git사용자명</th>
                        <th>Git사용자ID</th>
                        <th>부처</th>
                        <th>등록일시</th>
                        <th>등록자</th> 
                      </tr>
                    </thead>
                    
					<tbody>
						<c:forEach var="vo" items="${list}" varStatus="i">
							<tr>
								<c:url var="detailUrl" value="selectBldList.do"> 
									<c:forEach var="curParam" items="${param }">
										<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
									</c:forEach>
									<c:param name="servcAreaSeq" value="${vo.servcAreaSeq }" />
								</c:url>
								
								<td class="alignC"><c:out value="${(bldVo.paginationInfo.totalRecordCount-bldVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
								<td class="alignL"><c:out value="${vo.institutionNm}" /></td>
		                           <td class="alignL"><c:out value="${vo.regionNm}" /></td>
		                           <td class="alignL"><c:out value="${vo.zoneNm}" /></td>
		                           <td class="alignL"><c:out value="${vo.netNm}" /></td>
		                           <td class="alignC"><c:out value="${vo.rsrcPoolNm}" /></td>
		                           <td class="alignL">
		                               <a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.servcAreaNm}"/> 상세 화면이동"><c:out value="${vo.servcAreaNm}" /></a>
		                           </td>
		                           <td class="alignC"><c:out value="${vo.creUserNm}" /></td>
		                           <td class="alignC"><c:out value="${vo.creDttm}" /></td>
		                           <td class="alignC"><c:out value="${vo.updtUserNm}" /></td>
		                           <td class="alignC"><c:out value="${vo.updtDttm}" /></td>
		                       </tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
		

		
		<div class="box-footer edit-btn-group ">
			<ul class="pagination">
				<ui:pagination paginationInfo="${bldVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<%-- <div class="pull-right btns">
				<menu:authorize onlyOprAdm="true">
				<c:url var="insertUrl" value="insertServcAreaView.do">
                        <c:forEach var="curParam" items="${param }">
                            <c:param name="${curParam.key }" value="${curParam.value }"></c:param>
                        </c:forEach>
                    </c:url>
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="서비스영역 생성" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
				</menu:authorize>
			</div> --%>
	
		</div>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function() {
		
	});

	// 페이징 이동
	function fn_goPage(page){
		location.href = "<c:url value='selectBldList.do?paginationInfo.currentPageNo=" + page + "&${listParam}'/>";
	}

	// 검색조건 초기화
	function fn_reset() {
		$("#bldSearchVo input[type='text']").val("");
		$("#bldSearchVo select").val("").attr("selected", "selected");
	}

	// 서비스영역 목록조회
	function fn_selectServcAreaList(){

		$("#bldSearchVo").attr("action", "selectBldList.do");
		$("#bldSearchVo").submit();
	}

	

	// 엑셀 다운로드
	function fn_downloadExcel() {
		if("${bldSearchVo.paginationInfo.totalRecordCount}" == '0') {
			jAlert("다운로드할 데이터가 없습니다");
			return;
		}

		$("#bldSearchVo").attr("action", "excelDownServcNsList.do");
		$("#bldSearchVo").submit();
	}
	
	
	
    $("#atmSclServcAreaTable").DataTable({
        dom : 'Zlfrtip',
        paging : false,
        searching : false,
        info : false,
        aoColumns : [
              {sWidth : "50px" },
              {sWidth : "110px" },
              {sWidth : "110px" },
              {sWidth : "110px" },
              {sWidth : "110px" },
              {sWidth : "110px" },
              {sWidth : "160px" },
              {sWidth : "110px" },
              {sWidth : "110px" },
              {sWidth : "110px" },
              {sWidth : "110px" } 
        ],
        order : [ [ 0, "desc" ] ]
    });
	
	
</script>