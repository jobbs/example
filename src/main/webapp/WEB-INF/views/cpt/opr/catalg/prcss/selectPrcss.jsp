<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 09. 30.
 * @lastmodified 2016. 09. 30.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 09. 30.     이화영         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
  		<div class="box-header">
    		<h3 class="box-title">기본정보</h3>
  		</div><!-- /box-header -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>기본정보</caption>
	    		<colgroup>
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col16">
					<col class="col12">
					<col class="col12">
					<col class="col12">
					<col class="col12">
				</colgroup>
				<tbody>
	  			<tr>
	    			<th>프로세스ID</th>
	    			<td><c:out value="${vo.procssSeq}"/></td>
					<th>프로세스명</th>
					<td><c:out value="${vo.procssNm}"/></td>
					<th>등록자</th>
					<td><c:out value="${vo.regUserNm}"/></td>
					<th>등록일시</th>
					<td><c:out value="${vo.regDt}"/></td>
				</tr>
				<tr>
	  				<th>설명</th>
	  				<td colspan="6"><c:out value="${vo.prcssDc}"/></td>
				</tr>
	    		</tbody>
	  		</table>
		</div><!-- /box-body -->
    </div>

    <div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">프로세스 흐름</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>프로세스 흐름</caption>
				<tr>
					<td>
						<c:if test="${unitJobList ne null}">
							<button class="btn btn-side-info btn-red btn-lg mg-5"><i class="fa fa-caret-right"></i> 실행</button><i class="fa fa-arrow-right"></i>
								<c:forEach var="vo" items="${unitJobList}" varStatus="i">
									<button class="btn btn-default btn-lg mg-5" data-toggle="collapse"><c:out value="${i.count}. ${vo.uJobNm}"/></button><i class="fa fa-arrow-right"></i>
								</c:forEach>
							<button class="btn btn-side-info btn-green btn-lg mg-5"><i class="fa fa-check-square-o"></i> 완료</button>
						</c:if>
					</td>
				</tr>
    		</table>
		</div>
	</div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">단위업무 정보</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-vertical">
				<caption>단위업무 정보 목록</caption>
				<colgroup>
					<col class="col3">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
				</colgroup>
      			<thead>
          		<tr>
            		<th>No.</th>
            		<th>단위업무ID</th>
            		<th>단위업무명</th>
            		<th>단위업무유형</th>
            		<th>인터페이스 URL</th>
            		<th>인터페이스 파라메터</th>
            		<th>단위업무설명</th>
          		</tr>
        		</thead>
        		<tbody>
        			<c:choose>
						<c:when test="${unitJobList eq null or empty unitJobList }">
							<tr>
								<td colspan="7">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
	          				<c:forEach var="unitJobList" items="${unitJobList}" varStatus="i">
								<tr>
									<td><c:out value="${i.count}"/></td>
									<td><c:out value="${unitJobList.uJobId}"/></td>
									<td class="alignL"><c:out value="${unitJobList.uJobNm}"/></td>
									<td><c:out value="${unitJobList.uJobTyNm}"/></td>
									<td class="alignL"><c:out value="${unitJobList.intfcUrl}"/></td>
									<td class="alignL"><c:out value="${unitJobList.intfcParamtr}"/></td>
									<td class="alignL"><c:out value="${unitJobList.uJobDc}"/></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
        		</tbody>
      		</table>
  		</div>
	</div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">단위업무 관계</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-vertical">
				<caption>단위업무 관계 목록</caption>
				<colgroup>
					<col class="col3">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
				</colgroup>
      			<thead>
          		<tr>
            		<th>No.</th>
            		<th>시작 단위업무</th>
            		<th>종료 단위업무</th>
            		<th>조건 변수</th>
            		<th>조건 변수값</th>
            		<th>설명</th>
            		<th>등록일자</th>
          		</tr>
        		</thead>
        		<tbody>
        			<c:choose>
						<c:when test="${unitJobRelateList eq null or empty unitJobRelateList }">
							<tr>
								<td colspan="8">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
	          				<c:forEach var="unitJobRelateList" items="${unitJobRelateList}" varStatus="i">
								<tr>
									<td><c:out value="${i.count}"/></td>
									<td><c:out value="${unitJobRelateList.strtUJobId}"/></td>
									<td><c:out value="${unitJobRelateList.endUJobId}"/></td>
									<td><c:out value="${unitJobRelateList.endUJobCndVarId}"/></td>
									<td><c:out value="${unitJobRelateList.endUJobCndVarVl}"/></td>
									<td class="alignL"><c:out value="${unitJobRelateList.dc}"/></td>
									<td><fmt:formatDate value="${unitJobRelateList.regDt}" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
        		</tbody>
      		</table>
  		</div>
	</div>

	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">프로세스 변수</h3>
		</div>
		<div class="box-body no-padding">
  			<table class="table table-vertical">
  				<caption>프로세스 변수 목록</caption>
    			<colgroup>
					<col class="col3">
					<col class="colAuto">
					<col class="colAuto">
					<col class="colAuto">
				</colgroup>
      			<thead>
        		<tr>
        			<th>No.</th>
        			<th>변수명</th>
					<th>변수값</th>
					<th>설명</th>
				</tr>
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${procssVarList eq null or empty procssVarList }">
						<tr>
							<td colspan="5">검색된 데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="procssVarList" items="${procssVarList}" varStatus="i">
							<tr>
								<td><c:out value="${i.count}"/></td>
								<td class="alignL"><c:out value="${procssVarList.varNm}"/></td>
								<td class="alignL"><c:out value="${procssVarList.varVl}"/></td>
								<td class="alignL"><c:out value="${procssVarList.varDc}"/></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
        		</tbody>
      		</table>
  		</div>
	</div>
</div><!-- /col -->

<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_selectPrcssList();"><i class="fa fa-arrow-left"></i></button>
		</div>
   	</div><!-- /page-btn-group -->
</div>


<script type="text/javascript">

//뒤로
function fn_selectPrcssList(){
	location.href = '<c:url value="selectPrcssList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'procssSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

</script>