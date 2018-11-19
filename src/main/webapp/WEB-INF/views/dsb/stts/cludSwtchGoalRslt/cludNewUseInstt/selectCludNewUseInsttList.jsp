<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 18.
 * @lastmodified 2016. 10. 18.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 18.     김동훈         v1.0             최초생성
 *
 --%>
 <%@page	import=" java.util.*"  %>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/chart/chart.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/ncms_common.js" />"></script>


<div class="col-box-100 search-col">
	<div class="box list-box">
    	<div class="box-header">
            <h3 class="box-title">연도별 G-클라우드 신규 이용기관(G-CMS VM생성일자 기준)</h3>
            <div class="box-tools">
               <div class="input-group-box">
        			<div class="input-group-cell pad-right">
        				<button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드" onclick="fn_excelDown()"><i class="fa fa-download"></i></button>
        			</div>
        		</div>
            </div>
		</div><!-- /box-header -->
		<div class="box-body no-padding list-body">
	    	<table class="table table-hover table-vertical table-bordered ">
	        	<caption>연도별 G-클라우드 신규 이용기관(G-CMS VM생성일자 기준)</caption>
	            <colgroup>
	            	<c:if test="${list eq null or empty list}">
	            		<col  class="colAuto"/>
	            	</c:if>
					<c:forEach var="vo" items="${list }" >
						<col  class="colAuto"/>
	              	</c:forEach>
	            </colgroup>
	            <thead>
	            	<tr>
						<c:if test="${list eq null or empty list}">
		                	<tr><th >검색된 데이터가 없습니다.</th></tr>
		                </c:if>
	                 	<c:forEach var="vo" items="${list }" >
							<th title="<c:out value="${vo.stdrYr}"/>"><c:out value="${vo.stdrYr}"/></th>
						</c:forEach>
					</tr>
				</thead>
	            <tbody>
					<tr>
			        	<c:forEach var="vo" items="${list }" >
			            	<td><pre><a href="#" onclick="fn_doUpdatePage('${vo.stdrYr}')"><c:out value="${vo.institutionNm}" /></a></pre></td>
			            </c:forEach>
					</tr>
		            <tr>
		            	<c:forEach var="vo" items="${list }" >
		                	<td>
		                		업무수 : <fmt:formatNumber value="${vo.jobQty}" pattern="#,###"/>/<fmt:formatNumber value="${vo.sumJobQty}" pattern="#,###"/>
		                		<br/>
		                		기관수 : <fmt:formatNumber value="${vo.institutionQty}" pattern="#,###"/>/<fmt:formatNumber value="${vo.sumInstitutionQty}" pattern="#,###"/>
		                	</td>
		                </c:forEach>
					</tr>
				</tbody>
			</table>
		</div><!-- /box-body -->
		<div class="box-footer edit-btn-group">
			<div class="pull-left btns"></div>
			<ul class="pagination">
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertCludNewUseInsttView.do">
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="fn_goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
				</menu:authorize>
			</div>
		</div>
	</div><!-- /box(목록조회 테이블) -->
</div><!-- /col -->
<form id="excelForm" name="excelForm" action='<c:url value="selectCludNewUseInsttXlsDown.do"/>'>
</form>
<form id="updateForm" name="updateForm" action='<c:url value="updateCludNewUseInsttView.do"/>'>
	<input type="hidden" name="stdrYr"/>
</form>
<script>
function fn_excelDown(){
	<c:if test="${list eq null or empty list}">
		jAlert('엑셀로 다운로드할 데이터가 없습니다.');
		return;
	</c:if>
	excelForm.submit();
}
function fn_goToUrl(url){
	location.href=url;
}
function fn_doUpdatePage(stdrYr){
	updateForm.stdrYr.value=stdrYr;
	updateForm.submit();
}

</script>