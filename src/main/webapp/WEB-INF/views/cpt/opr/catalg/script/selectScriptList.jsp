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
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100 search-col">
	<form:form commandName="searchVo" method="get">
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
					<div class="cell-title"><label for="searchOSType" title="OS유형">OS유형</label></div>
                    <div class="cell-body">
                    	<nform:selectCode
                    		name="searchOSType"
                    		id="searchOSType"
                    		parentCd="102"
                    		parentGrpCd="003"
                    		value="${searchVo.searchOSType }"
                    		class="form-control input-sm" />
                    </div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title"><label for="searchOSVer" title="OS버전">OS버전</label></div>
                    <div class="cell-body">
                    	<form:input type="text" path="searchOSVer" class="form-control input-sm pull-right" maxlength="16" title="OS버전" />
                    </div>
				</div>
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label for="useYn">사용여부</label>
					</div>
					<div class="cell-body">
						<div class="input-group">
							<form:select path="searchUseYn" cssClass="form-control input-sm" title="사용여부">
				              	<form:option value="">전체</form:option>
				              	<form:option value="Y">사용</form:option>
				              	<form:option value="N">미사용</form:option>
							</form:select>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="box-footer collapse in search-collapse">
			<div class="pull-left">
		        <button type="button" class="btn" onclick="formReset('searchVo')">초기화</button>
	      </div>
	      <div class="pull-right">
		    <button type="submit" class="btn btn-red">조회</button>
		  </div>
		</div><!-- /box-footer -->
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
				</div>
	  		</div><!-- /box-header -->
		</div><!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table class="table table-hover table-vertical table-layout-fixed"  id="noticeTable">
			<caption>스태틱라우팅스크립트 목록</caption>
				  <col class="col5">
				  <col class="col8">
                  <col class="col10">
                  <col class="col10">
                  <col class="colAuto">
                  <col class="col10">
                  <col class="col10">
				<thead>
				<tr>
					<th>No.</th>
					<th>사용여부</th>
					<th>OS유형</th>
					<th>OS버전</th>
					<th>실행스크립트</th>
					<th>등록자</th>
					<th>등록일자</th>
				</tr>
				</thead>

				<tbody>
					<c:choose>
						<c:when test="${list eq null or empty list }">
							<tr><td colspan="7">검색된 데이터가 없습니다.</td></tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list }" varStatus="i">
								<c:url var="detailUrl" value="selectScript.do">
									<c:forEach var="curParam" items="${param }">
										<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
									</c:forEach>
									<c:param name="sRoutingScriptSeq" value="${vo.sRoutingScriptSeq }" />
								</c:url>

								<tr>
									<td><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></td>
									<td>
										<c:choose>
											<c:when test = "${ vo.useYn eq 'Y' }">
												<span class="status status-green">사용</span>
											</c:when>
											<c:otherwise>
												<span class="status status-gray">미사용</span>
											</c:otherwise>
										</c:choose>
									</td>
									<td><a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.sRoutingScriptSeq}"/>"><c:out value="${vo.osTyNm}"/></a></td>
									<td class="alignL"><c:out value="${vo.osVer}" /></td>
									<td class="alignL"><c:out value="${vo.script}" /></td>
									<td><c:out value="${vo.regUserNm}" /></td>
									<td><fmt:formatDate value="${vo.regDttm }" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- /box-body -->

		<!-- box-footer -->
		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${searchVo.paginationInfo }" type="common" jsFunction="goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize>
					<c:url var="insertUrl" value="insertScript.do">
						<c:forEach var="curParam" items="${param }">
							<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
						</c:forEach>
					</c:url>
					<button class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="추가" onclick="goToUrl('${insertUrl}')"><i class="fa fa-plus"></i></button>
				</menu:authorize>
			</div>
		</div>
		<!-- /box-footer -->
	</div>
</div>

<script type="text/javascript">
function goPage(page){
	location.href = "selectScriptList.do?paginationInfo.currentPageNo=" + page + "&${listParam}";
}
</script>