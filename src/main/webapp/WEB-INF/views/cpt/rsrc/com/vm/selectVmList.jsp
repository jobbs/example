<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>가상서버 목록 화면</pre>
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     심원보         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="vmSearchVoClass" value="ncis.cpt.rsrc.com.vo.VmSearchVo"/>
<c:set var="groupClass" value="ncis.cpt.rsrc.com.validation.SearchValidation"/>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<c:if test='${!vmSearchVo.netVmSltAt }'>
<c:set var="pollCl" value="01"></c:set>
</c:if>
<c:if test='${vmSearchVo.netVmSltAt }'>
<c:set var="pollCl" value="CN"></c:set>
</c:if>
<!-- 검색조건 영역 -->
<div class="col-box-100 search-col">

	<div class="box box-search">

		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<!-- 접기 버튼 -->
				<button type="button" class="btn btn-sm" title="접어두기" data-toggle="collapse" data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="접어두기" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>

		<form:form commandName="vmSearchVo" method="get">
		<form:hidden path="paginationInfo.recordCountPerPage" id="recordCountPerPage"/>

		<!-- box-body -->
		<div class="box-body collapse in search-collapse">

			<div class="form-group">

				<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="센터" for="equalsRegionId">센터</label>
						</div>
						<div class="cell-body">
							<nform:selectRegion
					          name="equalsRegionId"
					          id="equalsRegionId"
					          title="센터"
					          whole="true"
					          wholeText="전체"
					          cssClass="form-control input-sm"
					          value="${vmSearchVo.equalsRegionId}"
					          onchange="selectZoneByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId')" />

						</div>
					</div>
				</c:if>

				<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="존" for="equalsZoneId">존</label>
						</div>
						<div class="cell-body">
							<nform:selectZone
					          name="equalsZoneId"
					          id="equalsZoneId"
					          whole="true"
					          regionId="${vmSearchVo.equalsRegionId}"
					          value="${vmSearchVo.equalsZoneId}"
					          wholeText="전체"
					          cssClass="form-control input-sm"
					          onchange="selectPoolByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId', {'searchCtlTrgtYn' : 'Y',  'netVmSltAt' : 'netVmSltAt'})" />
						</div>
					</div>
				</c:if>

				<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="망구분" for="equalsNetClCd">망구분 </label>
						</div>
						<div class="cell-body">
							 <nform:selectCode
					          parentCd="NETCD"
					          parentGrpCd="067"
					          name="equalsNetClCd"
					          id="equalsNetClCd"
					          whole="true"
					          wholeText="전체"
					          extra1=""
					          extra2=""
					          extra3=""
					          value="${vmSearchVo.equalsNetClCd}"
					          extra4=""
					          extra5=""
					          cssClass="form-control input-sm"
					          onchange="selectPoolByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId', {'searchCtlTrgtYn' : 'Y',  'netVmSltAt' : 'netVmSltAt'})"  />
						</div>
					</div>
				</c:if>

				<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
					<!-- 검색조건 : select -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="자원풀" for="equalsRsrcPoolId">자원풀</label>
						</div>
						<div class="cell-body">

							<nform:selectPool
						          name="equalsRsrcPoolId"
						          id="equalsRsrcPoolId"
						          title="자원풀"
						          wholeText="전체"
						          poolTypeCd="${pollCl}"
						          cssClass="form-control input-sm"
						          swTypeCd="COM"
						          regionId="${vmSearchVo.equalsRegionId }"
						          zoneId="${vmSearchVo.equalsZoneId}"
						          netClCd="${vmSearchVo.equalsNetClCd }"
						          netVmSltAt="${vmSearchVo.netVmSltAt }"
						          value="${vmSearchVo.equalsRsrcPoolId}"
						          ctlTrgtYn=""/>
						</div>
					</div>
				</c:if>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="상태" for="equalsStatCd">상태</label>
					</div>
					<div class="cell-body">
						<form:select path="equalsStatGrpCd" title="상태" cssClass="form-control input-sm">
							<c:forEach var="statGrpCd" items="${statGrpCdList }">
								<form:option value="${statGrpCd.cd}" ><c:out value="${statGrpCd.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>

				<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="클러스터명" for="containsClstrNm">클러스터명</label>
						</div>
						<div class="cell-body">
							<form:input path="containsClstrNm" title="클러스터명" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(vmSearchVoClass, 'containsClstrNm', groupClass)}" />
						</div>
					</div>
				</c:if>

				<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="물리서버명" for="containsPmNm">물리서버명</label>
						</div>
						<div class="cell-body">
							<form:input path="containsPmNm" title="물리서버명" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(vmSearchVoClass, 'containsPmNm', groupClass)}" />
						</div>
					</div>
				</c:if>

				<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
					<!-- 검색조건 : input -->
					<div class="form-cell form-cell-50 col-lay-25">
						<div class="cell-title">
							<label title="물리서버구성ID" for="containsPmCompId">물리서버구성ID</label>
						</div>
						<div class="cell-body">
							<form:input path="containsPmCompId" title="물리서버구성ID" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(vmSearchVoClass, 'containsPmCompId', groupClass)}" />
						</div>
					</div>
				</c:if>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="가상서버구성ID" for="containsVmCompId">가상서버구성ID</label>
					</div>
					<div class="cell-body">
						<form:input path="containsVmCompId" title="가상서버구성ID" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(vmSearchVoClass, 'containsVmCompId', groupClass)}" />
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="가상서버명" for="containsVmNm">가상서버명</label>
					</div>
					<div class="cell-body">
						<form:input path="containsVmNm" title="가상서버명" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(vmSearchVoClass, 'containsVmNm', groupClass)}" />
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="가상서버ID" for="containsVmId">가상서버ID</label>
					</div>
					<div class="cell-body">
						<form:input path="containsVmId" title="가상서버ID" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(vmSearchVoClass, 'containsVmId', groupClass)}" />
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="호스트명" for="containsHstNm">호스트명</label>
					</div>
					<div class="cell-body">
						<form:input path="containsHstNm" title="호스트명" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(vmSearchVoClass, 'containsHstNm', groupClass)}" />
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="IP주소" for="containsRprsntIpAddr">IP주소</label>
					</div>
					<div class="cell-body">
						<form:input path="containsRprsntIpAddr" title="IP주소" cssClass="form-control input-sm onlyIp" value="" maxlength="${ivu.getMaxlength(vmSearchVoClass, 'containsRprsntIpAddr', groupClass)}" />
					</div>
				</div>

				<!-- 검색조건 : select -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="OS유형" for="equalsOsTyCd">OS유형</label>
					</div>
					<div class="cell-body">
						<form:select path="equalsOsTyCd" title="OS유형" cssClass="form-control input-sm">
							<c:forEach var="osTyCd" items="${osTyCdList }">
								<form:option value="${osTyCd.cd}" ><c:out value="${osTyCd.cdNm }"/></form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="부처" for="containsInstitutionNm">부처</label>
					</div>
					<div class="cell-body">
						<form:input path="containsInstitutionNm" title="부처" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(vmSearchVoClass, 'containsInstitutionNm', groupClass)}" />
					</div>
				</div>

				<!-- 검색조건 : input -->
				<div class="form-cell form-cell-50 col-lay-25">
					<div class="cell-title">
						<label title="업무" for="existsContainsJobNm">업무</label>
					</div>
					<div class="cell-body">
						<form:input path="existsContainsJobNm" title="업무" cssClass="form-control input-sm" value="" maxlength="${ivu.getMaxlength(vmSearchVoClass, 'existsContainsJobNm', groupClass)}" />
					</div>
				</div>

				<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
					<!-- 검색조건 : checkbox -->
					<div class="form-cell form-cell-50 col-lay-50">
						<div class="cell-title">
							<label title="가상화SW">가상화SW</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
								<c:choose>
									<c:when test="${vmSearchVo eq null or vmSearchVo.existsVrlzSwTyCdList eq null}">
										<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
											<form:checkbox path="existsVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" data-name="existsVrlzSwTyCdList" checked="checked"/>
											<label title="" for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach var="vrlzSwTyCd" items="${vrlzSwTyCdList }" varStatus="i">
											<form:checkbox path="existsVrlzSwTyCdList[${i.index }]" title="가상화SW" value="${vrlzSwTyCd.cd}" id="${vrlzSwTyCd.cd}" data-name="existsVrlzSwTyCdList"/>
											<label title="" for="${vrlzSwTyCd.cd}"><c:out value="${vrlzSwTyCd.cdNm}"/></label>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</div>
						</div>



					</div>
				</c:if>
				<div class="form-cell form-cell-50 col-lay-50">
				<div class="cell-title">
							<label title="NFV가상서버 조회여부" for="netVmSltAt">NFV가상서버  조회여부</label>
						</div>
						<div class="cell-body">
							<div class="input-group input-group-check">
							<form:checkbox path="netVmSltAt" title="NFV가상서버조회여부" value="true" id="netVmSltAt" data-name="netVmSltAt" onchange="selectPoolByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId', {'searchCtlTrgtYn' : 'Y',  'netVmSltAt' : 'netVmSltAt'})"/>
							</div>
						</div>
				</div>

			</div>

		</div>

		<!-- box-footer -->
		<div class="box-footer collapse in search-collapse">
		  <div class="pull-left">
		    <button type="button" class="btn" title="초기화" onclick="fn_initialize();">초기화</button>
		  </div>
		  <div class="pull-right">
		  	<c:url var="selectVmListUrl" value="selectVmList.do">
			</c:url>
		    <button type="button" class="btn btn-red pull-right" title="조회" onclick="fn_selectVmList();">조회</button>
		  </div>
		</div>

		</form:form>

	</div>

</div>

<!-- 그리드 영역 -->
<div class="col-box-100 search-col">

	<div class="box list-box">

		<!-- box-header -->
		<div class="box-header">
			<h3 class="box-title">검색결과<small>
				${vmSearchVo.paginationInfo.currentPageNo } /
				${vmSearchVo.paginationInfo.totalPageCount },
				총 ${vmSearchVo.paginationInfo.totalRecordCount }건
			</small></h3>
			<div class="box-tools">
				<div class="input-group-box">
					<nform:selectRecodeCntPerPage formId="vmSearchVo" value="${vmSearchVo }"/>
					<div class="input-group-cell pad-right">
						<button type="button" class="btn btn-sm btn-function" data-toggle="tooltip" title="엑셀다운로드" data-original-title="엑셀다운로드" onclick="fn_selectVmListXlsDwnl();"><i class="fa fa-download"></i></button>
					</div>
				</div>
			</div>
		</div>

		<!-- box-body -->
		<div class="box-body no-padding list-body">
			<table id="vmTable" class="table table-hover table-vertical table-layout-fixed">
				<caption>가상서버 목록</caption>
				<thead>
					<tr>
						<c:choose>
							<c:when test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
								<th><nobr title="선택">선택</nobr></th>
							</c:when>
							<c:otherwise>
								<th><nobr title="No.">No.</nobr></th>
							</c:otherwise>
						</c:choose>
						<th><nobr title="상태">상태</nobr></th>
						<th><nobr title="부처">부처</nobr></th>
						<th><nobr title="업무">업무</nobr></th>
						<c:if test="${vmSearchVo.netVmSltAt}">
							<th><nobr title="네트워크유형">네트워크<br>유형</nobr></th>
						</c:if>
						<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
							<th><nobr title="센터">센터</nobr></th>
							<th><nobr title="존">존</nobr></th>
							<th><nobr title="망구분">망구분</nobr></th>
							<th><nobr title="자원풀">자원풀</nobr></th>
							<th><nobr title="클러스터명">클러스터명</nobr></th>
							<th><nobr title="물리서버명">물리서버명</nobr></th>
							<th><nobr title="물리서버구성ID">물리서버구성ID</nobr></th>
						</c:if>
						<th><nobr title="가상서버명">가상서버명</nobr></th>
						<th><nobr title="가상서버구성ID">가상서버구성ID</nobr></th>
						<th><nobr title="가상서버ID">가상서버ID</nobr></th>
						<th><nobr title="호스트명">호스트명</nobr></th>
						<th><nobr title="IP주소">IP주소</nobr></th>
						<th><nobr title="OS유형">OS유형</nobr></th>
						<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
							<th><nobr title="가상화SW">가상화SW</nobr></th>
						</c:if>
						<th><nobr title="CPU 사용률 (%)">CPU<br>사용률<br>(%)</nobr></th>
						<th><nobr title="CPU 가상화율 (%)">CPU<br>vCore</nobr></th>
						<th><nobr title="메모리 사용률 (%)">메모리<br>사용률<br>(%)</nobr></th>
						<th><nobr title="메모리 (GB)">메모리<br>(GB)</nobr></th>
						<th><nobr title="스토리지 (GB)">스토리지<br>(GB)</nobr></th>
						<th><nobr title="네트워크 In (KB/S)">네트워크<br>In<br>(KB/S)</nobr></th>
						<th><nobr title="네트워크 Out (KB/S)">네트워크<br>Out<br>(KB/S)</nobr></th>
						<th><nobr title="기동일시">기동일시</nobr></th>
						<th><nobr title="생성일시">생성일시</nobr></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vmVo" items="${vmVoList }" varStatus="i">
						<c:url var="selectVmUrl" value="selectVm.do">
							<c:param name="vmSeq" value="${vmVo.vmSeq }" />
							<c:param name="searchType" value="info" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>

						<c:url var="selectNetVmUrl" value="/cpt/rsrc/net/vm/selectNetVm.do">
							<c:param name="vmSeq" value="${vmVo.vmSeq }" />
							<c:param name="searchType" value="info" />
							<c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach>
						</c:url>
						<tr>
							<c:choose>
								<c:when test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
									<td><nobr><input type="radio" name="vm_row" title="선택여부" value="${vmVo.vmSeq }" <c:if test='${"Y" ne vmVo.ctlTrgtYn or vmVo.vmClCd eq "02"}'><c:out value="disabled"/></c:if>/></nobr></td>
								</c:when>
								<c:otherwise>
									<td><nobr title="<c:out value="${(vmSearchVo.paginationInfo.totalRecordCount - vmSearchVo.paginationInfo.firstRecordIndex - i.count) + 1}" />"><c:out value="${(vmSearchVo.paginationInfo.totalRecordCount - vmSearchVo.paginationInfo.firstRecordIndex - i.count) + 1}" /></nobr></td>
								</c:otherwise>
							</c:choose>
							<td class="alignL">
							<nobr>
							<c:if test="${null ne vmVo.statGrpCd}">
								<div class="server-info server
									<c:choose>
										<c:when test='${"01" eq vmVo.statGrpCd}'><c:out value="server-down"/></c:when>
										<c:when test='${"02" eq vmVo.statGrpCd}'><c:out value="server-up"/></c:when>
										<c:when test='${"03" eq vmVo.statGrpCd}'><c:out value="server-inprogress"/></c:when>
										<c:when test='${"04" eq vmVo.statGrpCd}'><c:out value="server-exception"/></c:when>
							   			<c:otherwise></c:otherwise>
									</c:choose>
								">
									<div class="server-info-body alignL">
										<div class="server-info-box alignL">
											<span title="<c:out value="${vmVo.statGrpCdNm }" />" class="label"></span><h4 title="<c:out value="${vmVo.statGrpCdNm }" />" class="stat"><c:out value="${vmVo.statGrpCdNm }" /></h4>
										</div>
									</div>
								</div>
							</c:if>
							</nobr>
							</td>
							<td class="alignL"><nobr title="<c:out value="${vmVo.institutionNm }" />"><c:out value="${vmVo.institutionNm }" /></nobr></td>
							<td class="alignL"><nobr title="<c:out value="${vmVo.jobsNm }" />"><c:out value="${vmVo.jobsNm }" /></nobr></td>
							<c:if test="${vmSearchVo.netVmSltAt}">
							<td class="alignC"><nobr title="<c:out value="${vmVo.netwkTyClCdNm }" />"><c:out value="${vmVo.netwkTyClCdNm }" /></nobr></td>
							</c:if>
							<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
								<td class="alignL"><nobr title="<c:out value="${vmVo.regionNm }" />"><c:out value="${vmVo.regionNm }" /></nobr></td>
								<td class="alignL"><nobr title="<c:out value="${vmVo.zoneNm }" />"><c:out value="${vmVo.zoneNm }" /></nobr></td>
								<td class="alignL"><nobr title="<c:out value="${vmVo.netNm }" />"><c:out value="${vmVo.netNm }" /></nobr></td>
								<td class="alignL"><nobr title="<c:out value="${vmVo.rsrcPoolNm }" />"><c:out value="${vmVo.rsrcPoolNm }" /></nobr></td>
								<td class="alignL"><nobr title="<c:out value="${vmVo.clstrNm }" />"><c:out value="${vmVo.clstrNm }" /></nobr></td>
								<td class="alignL"><nobr title="<c:out value="${vmVo.pmNm }" />"><c:out value="${vmVo.pmNm }" /></nobr></td>
								<td><nobr title="<c:out value="${vmVo.pmCompId }" />"><c:out value="${vmVo.pmCompId }" /></nobr></td>
							</c:if>
							<td class="alignL"><nobr>
								<c:if test="${vmVo.vmNm ne null}">
									<c:choose>
										<c:when test="${vmSearchVo.netVmSltAt and (vmVo.vmClCd eq '02')}">
											<a href="<c:url value="${selectNetVmUrl }" />" title="<c:out value="${vmVo.vmNm }"/>"><c:out value="${vmVo.vmNm }" /></a>
										</c:when>
										<c:otherwise>
											<a href="<c:url value="${selectVmUrl }" />" title="<c:out value="${vmVo.vmNm }"/>"><c:out value="${vmVo.vmNm }" /></a>
										</c:otherwise>
									</c:choose>
								</c:if>
							</nobr></td>
							<td><nobr title="<c:out value="${vmVo.vmCompId }" />">
								<c:if test="${vmVo.vmCompId ne null}">
									<c:choose>
										<c:when test="${vmSearchVo.netVmSltAt and mvVo.vmClCd eq '02'}">
											<a href="<c:url value="${selectNetVmUrl }" />" title="<c:out value="${vmVo.vmNm }"/>"><c:out value="${vmVo.vmCompId }" /></a>
										</c:when><c:otherwise>
											<a href="<c:url value="${selectVmUrl }" />" title="<c:out value="${vmVo.vmNm }"/>"><c:out value="${vmVo.vmCompId }" /></a>
										</c:otherwise>
									</c:choose>
								</c:if>
							</nobr></td>
							<td class="alignL"><nobr>
								<c:if test="${vmVo.vmId ne null}">
									<c:choose>
										<c:when test="${vmSearchVo.netVmSltAt and mvVo.vmClCd eq '02'}">
											<a href="<c:url value="${selectNetVmUrl }" />" title="<c:out value="${vmVo.vmNm }"/>"><c:out value="${vmVo.vmId }" /></a>
										</c:when>
										<c:otherwise>
											<a href="<c:url value="${selectVmUrl }" />" title="<c:out value="${vmVo.vmNm }"/>"><c:out value="${vmVo.vmId }" /></a>
										</c:otherwise>
									</c:choose>
								</c:if>
							</nobr></td>
							<td class="alignL"><nobr title="<c:out value="${vmVo.hstNm }" />"><c:out value="${vmVo.hstNm }" /></nobr></td>
							<td class="alignL"><nobr title="<c:out value="${vmVo.rprsntIpAddr }" />"><c:out value="${vmVo.rprsntIpAddr }" /></nobr></td>
							<td class="alignL"><nobr title="<c:out value="${vmVo.osTyCdNm }" />"><c:out value="${vmVo.osTyCdNm }" /></nobr></td>
							<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
								<td class="alignL"><nobr title="<c:out value="${vmVo.vrlzSwTyCdNm }" />"><c:out value="${vmVo.vrlzSwTyCdNm }" /></nobr></td>
							</c:if>
							<td class="notellipsis">
								<span title="<fmt:formatNumber value="${vmVo.cpuUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${vmVo.cpuUseRt}" pattern="0"/></span>
								<div title="<fmt:formatNumber value="${vmVo.cpuUseRt}" pattern="0"/>" class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${vmVo.cpuUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<%-- <td class="alignR"><nobr title=""><c:out value="${vmVo.cpuEnt }"/></nobr></td> --%>
							<td class="alignR"><nobr title="<c:out value="${vmVo.cpuVcoreQty }"/>"><c:out value="${vmVo.cpuVcoreQty }"/></nobr></td>
							<td class="notellipsis">
								<span title="<fmt:formatNumber value="${vmVo.memUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${vmVo.memUseRt}" pattern="0"/></span>
								<div title="<fmt:formatNumber value="${vmVo.memUseRt}" pattern="0"/>" class="progress">
									<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${vmVo.memUseRt}" pattern="0"/>%"></div>
								</div>
							</td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${vmVo.memAsgnCapa}" pattern="0"/>"><fmt:formatNumber value="${vmVo.memAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${vmVo.strgAsgnCapa}" pattern="0"/>"><fmt:formatNumber value="${vmVo.strgAsgnCapa}" pattern="0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${vmVo.netwkIn}" pattern="0.0"/>"><fmt:formatNumber value="${vmVo.netwkIn }" pattern="0.0"/></nobr></td>
							<td class="alignR"><nobr title="<fmt:formatNumber value="${vmVo.netwkOut}" pattern="0.0"/>"><fmt:formatNumber value="${vmVo.netwkOut }" pattern="0.0"/></nobr></td>
							<td><nobr title="<fmt:formatDate value="${vmVo.strtupDttm }" pattern="yyyy-MM-dd HH:mm:ss" />"><fmt:formatDate value="${vmVo.strtupDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></nobr></td>
							<td><nobr title="<fmt:formatDate value="${vmVo.creDttm }" pattern="yyyy-MM-dd HH:mm:ss" />"><fmt:formatDate value="${vmVo.creDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></nobr></td>
							<%-- <td class="alignL"><nobr title="<c:out value="${vmVo.uptime }" />"><c:out value="${vmVo.uptime }" /></nobr></td>
							<td><nobr title="<fmt:formatDate value="${vmVo.regDttm }" pattern="yyyy-MM-dd HH:mm:ss" />"><fmt:formatDate value="${vmVo.regDttm }" pattern="yyyy-MM-dd HH:mm:ss" /></nobr></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="box-footer edit-btn-group">
			<ul class="pagination">
				<ui:pagination paginationInfo="${vmSearchVo.paginationInfo }" type="common" jsFunction="fn_goPage" />
			</ul>
			<div class="pull-right btns">
				<menu:authorize onlyOprAdm="true">
					<button type="button" class="btn btn-sm btn-hover-blue" data-toggle="tooltip" title="생성 요청" data-original-title="생성 요청" onclick="fn_insertVmCreReq();"><i class="fa fa-plus"></i></button>
					<button type="button" class="btn btn-sm btn-hover-yellow" data-toggle="tooltip" title="스펙변경 요청" data-original-title="스펙변경 요청" onclick="fn_insertVmSpecModReq();"><i class="fa fa-eraser"></i></button>
					<button type="button" class="btn btn-sm btn-hover-yellow" data-toggle="tooltip" title="스토리지추가 요청" data-original-title="스토리지추가 요청" onclick="fn_insertVmStrgAddReq();"><i class="fa fa-plus-circle"></i></button>
					<!-- <button type="button" class="btn btn-sm btn-hover-yellow" data-toggle="tooltip" title="스토리지삭제 요청" data-original-title="스토리지삭제 요청" onclick="fn_insertVmStrgDelReq();"><i class="fa fa-minus-circle"></i></button> -->
					<button type="button" class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="삭제 요청" data-original-title="삭제 요청" onclick="fn_insertVmDelReq();"><i class="fa fa-minus"></i></button>
				</menu:authorize>
			</div>
		</div>

	</div>

</div>

<script type="text/javascript">



// 검색조건 초기화
function fn_initialize(){
	$('#vmSearchVo input[type="text"]').val('');
	$('#vmSearchVo select').val('').attr('selected', 'selected');
	$('#vmSearchVo input[type="checkbox"][data-name="existsVrlzSwTyCdList"]').prop('checked', 'checked');
	$('#vmSearchVo input[type="checkbox"][data-name="netVmSltAt"]').prop('checked', '');
}

// 조회
function fn_selectVmList(){
	if($('#netVmSltAt').prop("checked")){
		console.log($('#equalsNetClCd').prop("onchange"));

		//onchange="selectPoolByNetClCd('equalsRegionId', 'equalsZoneId', 'equalsNetClCd', 'equalsRsrcPoolId', {searchPoolTypeCd : '${pollCl}','searchCtlTrgtYn' : 'Y'})"  />
	}else{
		console.log($('#equalsNetClCd').prop("onchange"));
	}

	// 클러스터명
	var tmp = $.trim($("#vmSearchVo input[name='containsClstrNm']").val());
	if(tmp != '') $("#vmSearchVo input[name='containsClstrNm']").val(tmp);
	// 물리서버명
	tmp = $.trim($("#vmSearchVo input[name='containsPmNm']").val());
	if(tmp != '') $("#vmSearchVo input[name='containsPmNm']").val(tmp);
	// 물리서버 구성 ID
	tmp = $.trim($("#vmSearchVo input[name='containsPmCompId']").val());
	if(tmp != '') $("#vmSearchVo input[name='containsPmCompId']").val(tmp);
	// 가상서버 구성 ID
	tmp = $.trim($("#vmSearchVo input[name='containsVmCompId']").val());
	if(tmp != '') $("#vmSearchVo input[name='containsVmCompId']").val(tmp);
	// 가상서버명
	tmp = $.trim($("#vmSearchVo input[name='containsVmNm']").val());
	if(tmp != '') $("#vmSearchVo input[name='containsVmNm']").val(tmp);
	// 가상서버 ID
	tmp = $.trim($("#vmSearchVo input[name='containsVmId']").val());
	if(tmp != '') $("#vmSearchVo input[name='containsVmId']").val(tmp);
	// 호스트명
	tmp = $.trim($("#vmSearchVo input[name='containsHstNm']").val());
	if(tmp != '') $("#vmSearchVo input[name='containsHstNm']").val(tmp);
	// IP 주소
	tmp = $.trim($("#vmSearchVo input[name='containsRprsntIpAddr']").val());
	if(tmp != '') $("#vmSearchVo input[name='containsRprsntIpAddr']").val(tmp);
	// 부처명
	tmp = $.trim($("#vmSearchVo input[name='containsInstitutionNm']").val());
	if(tmp != '') $("#vmSearchVo input[name='containsInstitutionNm']").val(tmp);
	// 업무명
	tmp = $.trim($("#vmSearchVo input[name='existsContainsJobNm']").val());
	if(tmp != '') $("#vmSearchVo input[name='existsContainsJobNm']").val(tmp);



	$('#vmSearchVo').attr('target', '_self');
	$('#vmSearchVo').attr('action', '<c:url var="select" value="selectVmList.do"/>');
	$('#vmSearchVo').submit();
}

// 가상서버 생성요청
function fn_insertVmCreReq(){
	location.href = '<c:url value="insertVmCreReq.do"><c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach></c:url>';
}

//가상서버 스펙변경요청
function fn_insertVmSpecModReq(){
	if($('.list-box table input[type="radio"]:checked').length == 0){
		jAlert("선택된 가상서버가 없습니다.");
		return;
	}
	location.href = '<c:url value="insertVmSpecModReq.do"><c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach></c:url><c:choose><c:when test="${param eq null or param.isEmpty()}"><c:out value="?"/></c:when><c:otherwise><c:out value="&" escapeXml="false"/></c:otherwise></c:choose>vmSeq=' + $('.list-box table input[type="radio"]:checked').val();
}

//가상서버 스토리지추가요청
function fn_insertVmStrgAddReq(){
	if($('.list-box table input[type="radio"]:checked').length == 0){
		jAlert("선택된 가상서버가 없습니다.");
		return;
	}
	location.href = '<c:url value="insertVmStrgAddReq.do"><c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach></c:url><c:choose><c:when test="${param eq null or param.isEmpty()}"><c:out value="?"/></c:when><c:otherwise><c:out value="&" escapeXml="false"/></c:otherwise></c:choose>vmSeq=' + $('.list-box table input[type="radio"]:checked').val();
}

// 가상서버 스토리지삭제요청
function fn_insertVmStrgDelReq(){
	if($('.list-box table input[type="radio"]:checked').length == 0){
		jAlert("선택된 가상서버가 없습니다.");
		return;
	}
	location.href = '<c:url value="insertVmStrgDelReq.do"><c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach></c:url><c:choose><c:when test="${param eq null or param.isEmpty()}"><c:out value="?"/></c:when><c:otherwise><c:out value="&" escapeXml="false"/></c:otherwise></c:choose>vmSeq=' + $('.list-box table input[type="radio"]:checked').val();}

// 가상서버 삭제요청
function fn_insertVmDelReq(){
	if($('.list-box table input[type="radio"]:checked').length == 0){
		jAlert("선택된 가상서버가 없습니다.");
		return;
	}
	location.href = '<c:url value="insertVmDelReq.do"><c:forEach var="pageParam" items="${param}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:forEach></c:url><c:choose><c:when test="${param eq null or param.isEmpty()}"><c:out value="?"/></c:when><c:otherwise><c:out value="&" escapeXml="false"/></c:otherwise></c:choose>vmSeq=' + $('.list-box table input[type="radio"]:checked').val();
}

// 페이지 이동
function fn_goPage(page){
	location.href = '<c:url value="selectVmList.do"/>?paginationInfo.currentPageNo=' + page + '&${listParam}';
}

// 목록의 정보를 Excel로 다운로드 한다.
function fn_selectVmListXlsDwnl() {
	if("${vmSearchVo.paginationInfo.totalRecordCount}" == '0') {
		jAlert("엑셀로 다운로드할 데이터가 없습니다.");
		return;
	}
	$('#vmSearchVo').attr('target', '_self');
	$('#vmSearchVo').attr('action', '<c:url value="selectVmListXlsDwnl.do"/>');
	$('#vmSearchVo').submit();
}

//<td><nobr><c:out value="${(searchVo.paginationInfo.totalRecordCount-searchVo.paginationInfo.firstRecordIndex-i.count)+1}" /></nobr></td>
$("#vmTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
	<c:choose>
		<c:when test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
			{sWidth : "28px" }, //선택
		</c:when>
		<c:otherwise>
			{sWidth : "28px" }, //No.
		</c:otherwise>
	</c:choose>
		{sWidth : "94px" }, //상태
		{sWidth : "80px" }, //부처*
		{sWidth : "80px" }, //업무*
	<c:if test="${vmSearchVo.netVmSltAt}">
		{sWidth : "60px" }, //네트워크유형
	</c:if>
	<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
		{sWidth : "28px" }, //센터
		{sWidth : "25px" }, //존
		{sWidth : "60px" }, //망구분*
		{sWidth : "80px" }, //자원풀*
		{sWidth : "80px" }, //클러스터명*
		{sWidth : "100px" }, //물리서버명*
		{sWidth : "84px" }, //물리서버구성ID
	</c:if>
		{sWidth : "140px" }, //가상서버명
		{sWidth : "82px" }, //가상서버구성ID
		{sWidth : "110px" }, //가상서버ID
		{sWidth : "80px" }, //호스트명
		{sWidth : "100px" }, //IP주소
		{sWidth : "50px" }, //OS유형
	<c:if test="${vmSearchVo.sysAdm or vmSearchVo.oprAdm}">
		{sWidth : "70px" }, //가상화SW
	</c:if>
		{sWidth : "40px" }, //CPU 사용률
		{sWidth : "40px" }, //CPU vCore
		{sWidth : "40px" }, //메모리 사용률
		{sWidth : "40px" }, //메모리 할당량
		{sWidth : "50px" }, //스토리지
		{sWidth : "50px" }, //네트워크In
		{sWidth : "50px" }, //네트워크Out
		{sWidth : "130px" },//기동일시
		{sWidth : "130px" } //생성일시
	],
	order : [],

});

</script>
