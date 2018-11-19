<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세-가상서버 스펙변경 </pre>
 *
 * @author 이호성
 * @lastmodifier 이호성
 * @created 2016. 10. 6.
 * @lastmodified 2016. 10. 6.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 6.     이호성         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:if test="${vmVo ne null}">
	<div class="col-box-100">

		<div class="col-info server <c:choose><c:when test='${"02" eq vmVo.statGrpCd}'><c:out value="server-up"/></c:when>
										      <c:when test='${"01" eq vmVo.statGrpCd}'><c:out value="server-down"/></c:when>
										      <c:when test='${"04" eq vmVo.statGrpCd}'><c:out value="server-exception"/></c:when>
										      <c:otherwise><c:out value="server-inprogress"/></c:otherwise> </c:choose>" >
			<div class="col-info-body alignL">
				<div class="col-info-box alignL">
					<span class="label"></span>
					<h4 class="stat"><c:out value="${vmVo.statGrpCdNm}"/><c:if test='${"03" eq vmVo.statGrpCd}'><c:out value="(${vmVo.statCdNm})"/></c:if></h4>
					<menu:authorize authType="act">
						<c:choose>
							<c:when test='${vmVo.delYn eq "N"}'>
								<button type="button" class="btn btn-sm btn-refresh vm-sync" onclick="javascript:fn_vmHandl('D');">새로고침</button>
							</c:when>
							<c:otherwise>
								<span class='status  status-red'>삭제됨</span>
							</c:otherwise>
						</c:choose>
					</menu:authorize>
				</div>
				<div class="col-info-box alignR">
					<c:if test='${vmVo.delYn eq "N"}'>
						<div class="col-info-btn">
							<menu:authorize authType="act">
								<button type="button" class="btn vm-start" title="시작" onclick="javascript:fn_vmHandl('S');" <c:if test='${"01" ne vmVo.statGrpCd}'><c:out value="disabled"/></c:if>><i class="fa fa-play-circle"></i><span>시작</span></button>
							   	<c:if test='${"03" ne vmVo.vrlzSwTyCd}'>
							   	<button type="button" class="btn vm-shutdown"  title="중지"  onclick="javascript:fn_vmHandl('T');" <c:if test='${"02" ne vmVo.statGrpCd}'><c:out value="disabled"/></c:if>><i class="fa fa-ban"></i><span>중지</span></button>
							   	</c:if>
							   	<button type="button" class="btn vm-stop"  title="강제종료"  onclick="javascript:fn_vmHandl('O');" <c:if test='${"02" ne vmVo.statGrpCd}'><c:out value="disabled"/></c:if>><i class="fa fa-power-off"></i><span>강제종료</span></button>
							</menu:authorize>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div><!--  /가상서버 상태 표시  -->
</c:if>

<div class="col-box-100 detail-col">
<!-- box -->
	<div class="box detail-list-box">
		<div class="box-header">
		    <h3 class="box-title">기본 정보 </h3>
		</div><!-- /box-header -->

		<!-- box-body -->
		<div class="box-body no-padding">
		    <table class="table table-horizon">
		    	<caption>기본정보</caption>
		        <colgroup>
			        <col class="col10">
			        <col class="col15">
			        <col class="col10">
			        <col class="col15">
			        <col class="col10">
			        <col class="col15">
			        <col class="col10">
			        <col class="col15">
			      </colgroup>
		        <tbody>
		        	<tr><th>제목</th><td colspan="3"><c:out value="${rsrcReqVmSpecChngInfo.sbjct }"/></td>
			          	<th>실행자</th><td><c:out value="${rsrcReqVmSpecChngInfo.exeUserNm }"/></td>
			          	<th>실행일시</th><td><c:out value="${rsrcReqVmSpecChngInfo.exeDttm }"/></td></tr>
			        <tr><th>상태</th><td>
			        	<span class="status
								<c:choose>
									<c:when test="${'01' eq rsrcReqVmSpecChngInfo.rsrcReqPrcssStatCd}"><c:out value="status-blue"/></c:when>
									<c:when test="${'02' eq rsrcReqVmSpecChngInfo.rsrcReqPrcssStatCd}"><c:out value="status-yellow"/></c:when>
									<c:when test="${'03' eq rsrcReqVmSpecChngInfo.rsrcReqPrcssStatCd}"><c:out value="status-green"/></c:when>
									<c:when test="${'04' eq rsrcReqVmSpecChngInfo.rsrcReqPrcssStatCd}"><c:out value="status-aqua"/></c:when>
									<c:when test="${'05' eq rsrcReqVmSpecChngInfo.rsrcReqPrcssStatCd}"><c:out value="status-red"/></c:when>
									<c:when test="${'06' eq rsrcReqVmSpecChngInfo.rsrcReqPrcssStatCd}"><c:out value="status-gray"/></c:when>
									<c:when test="${'07' eq rsrcReqVmSpecChngInfo.rsrcReqPrcssStatCd}"><c:out value="status-green"/></c:when>
									<c:otherwise><c:out value="status-gray"/></c:otherwise>
								</c:choose>
	                			status-red "><c:out value="${rsrcReqVmSpecChngInfo.rsrcReqPrcssStatNm}"/>
	                		</span>
			        </td>
			          	<th>티켓번호</th><td><c:out value="${rsrcReqVmSpecChngInfo.ticktNo }"/></td>
			          	<th>요청번호</th><td><c:out value="${rsrcReqVmSpecChngInfo.rsrcReqNo }"/></td>
			          	<th>요청일시</th><td><c:out value="${rsrcReqVmSpecChngInfo.rsrcReqDttm }"/></td></tr>
			        <tr><th>요청유형</th><td><c:out value="${rsrcReqVmSpecChngInfo.rsrcReqTyNm }"/></td>
			          	<th>요청자</th><td><c:out value="${rsrcReqVmSpecChngInfo.rsrcReqUsrNm }"/></td>
			          	<th>요청부처</th><td><c:out value="${rsrcReqVmSpecChngInfo.reqInstitutionNm }"/></td>
			          	<th>핸드폰</th><td><c:out value="${rsrcReqVmSpecChngInfo.mobile }"/></td></tr>
			        <tr><th>이메일</th><td><c:out value="${rsrcReqVmSpecChngInfo.email }"/></td>
			          	<th>완료일시</th><td><c:out value="${rsrcReqVmSpecChngInfo.comptDttm }"/></td>
			          	<th>테스트여부</th><td colspan="3" ><c:choose><c:when test="${rsrcReqVmSpecChngInfo.testYn eq 'Y'}">예</c:when>
															   <c:when test="${rsrcReqVmSpecChngInfo.testYn eq 'N'}">아니오</c:when>
															  <c:otherwise><c:out value="${rsrcReqVmSpecChngInfo.testYn}"/></c:otherwise>
											</c:choose></td></tr>
		        </tbody>
			</table>
		</div>
	</div><!-- /box -->

  	<!-- box(목록조회 테이블) -->
	<div class="box detail-list-box">
	    <div class="box-header">
			<h3 class="box-title">가상서버 정보  <small class="text-red"><c:if test="${vmVo.delYn eq 'Y' }"><c:out value="[삭제됨]" /></c:if></small></h3>
	   	</div><!-- /box-header -->
	    <!-- box-body -->
	    <div class="box-body no-padding">
	    <table class="table table-horizon">
	    	<caption>가상서버정보</caption>
				<colgroup>
					<col class="col10">
				    <col class="col15">
					<col class="col10">
				    <col class="col15">
				    <col class="col10">
				    <col class="col15">
				    <col class="col10">
				    <col class="col15">
				</colgroup>
				<tbody>
					<c:choose>
						<c:when test="${vmVo eq null}">
							<tr><td colspan="8" class="btn btn-red btn-lg"><c:out  value="가상서버정보 조회 권한이 없습니다."/></td></tr>
						</c:when>
						<c:otherwise>
							<tr><th>센터</th><td><c:out value="${vmVo.regionNm }" /></td>
								<th>존</th><td><c:out value="${vmVo.zoneNm }" /></td>
								<th>망</th><td><c:out value="${vmVo.netNm }" /></td>
								<th>자원풀</th><td><c:out value="${vmVo.rsrcPoolNm }" /></td></tr>
							<tr><th>클러스터명</th><td><c:out value="${vmVo.clstrNm }" /></td>
								<th>물리서버명</th><td><c:out value="${vmVo.pmNm }" /></td>
								<th>부처</th><td><c:out value="${vmVo.institutionNm }" /></td>
								<th>업무</th><td><nobr>
												<c:forEach var="vmJobVo" items="${vmVo.vmJobVoList }" varStatus="i">
													<c:out value="${vmJobVo.jobNm }" /><c:if test="${fn:length(vmVo.vmJobVoList) > (i.index + 1) }"><c:out value=","/></c:if>
												</c:forEach>
											</nobr></td></tr>
							<tr><th>가상화SW</th><td><c:out value="${vmVo.vrlzSwTyCdNm }" /></td>
								<th>가상서버명</th><td><c:out value="${vmVo.vmNm }" /></td>
								<th>가상서버ID</th><td><c:out value="${vmVo.vmId }" /></td>
								<th>호스트명</th><td><c:out value="${vmVo.hstNm }" /></td></tr>
							<tr><th>IP주소</th><td><c:out value="${vmVo.rprsntIpAddr }" /></td>
								<th>OS유형</th><td><c:out value="${vmVo.osTyCdNm }" /></td>
								<th>운영체제</th><td><c:out value="${vmVo.osNm }" /></td>
								<th>S/W</th><td><c:out value="${vmVo.pltfrm }" /></td></tr>
							<tr><th>CPU vCore</th><td><c:out value="${vmVo.cpuVcoreQty }" /></td>
								<th>CPU Ent</th><td><c:out value="${vmVo.cpuEnt }" /></td>
								<th>메모리 (GB)</th><td><c:out value="${vmVo.memAsgnCapa }" /></td>
								<th>스토리지 (GB)</th><td><c:out value="${vmVo.strgAsgnCapa}" /></td></tr>
							<tr><th>서비스기간</th>
									<td colspan="7">
										<c:choose>
											<c:when test="${vmVo.servcStrtDt ne null }">
												<fmt:formatDate pattern="yyyy-MM-dd" value="${vmVo.servcStrtDt}"/>
												 ~ <fmt:formatDate pattern="yyyy-MM-dd" value="${vmVo.servcEndDt}"/>
											</c:when>
											<c:otherwise>
												영구
											</c:otherwise>
										</c:choose>
									</td></tr>
							<tr><th>가상서버구성ID</th><td colspan="7"><c:out value="${vmVo.vmCompId }"/></td></tr>
							<tr><th>비고</th><td colspan="7"><c:out value="${vmVo.rmk }"/></td></tr>

							<tr id="trHaDiv" style="display:none;"><th>HA구성정보</th>
							  <td colspan="7">

							      <table id="haListTable" class="table table-bordered table-vertical">
							       	<caption>HA정보</caption>
								        <colgroup>
												<col class="col30">
												<col class="colAuto">
												<col class="col30">
								        </colgroup>
							        <thead>
							           <tr>
							             <th>HA그룹명</th>
							             <th>가상서버명</th>
							             <th>가상서버구성ID</th>
							           </tr>
							        </thead>
							        <tbody>
							        	<c:choose>
											<c:when test="${rsrcReqHaVmList eq null or empty rsrcReqHaVmList }">
											<tr>
												<td colspan="3">검색된 데이터가 없습니다.</td>
											</tr>
											</c:when>
											<c:otherwise>
											<c:forEach var="rsrcReqHaVmListVo" items="${rsrcReqHaVmList }" varStatus="i">
												<tr>
													<c:if test="${tempHaGrpNm != rsrcReqHaVmListVo.haGrpNm }">
													<c:set var="tempHaGrpNm" value="${rsrcReqHaVmListVo.haGrpNm }"/>
													<td class="alignL" rowspan="${rsrcReqHaVmList.size()}"><c:out value="${rsrcReqHaVmListVo.haGrpNm}" /></td>
													</c:if>

													<td class="alignL"><c:out value="${rsrcReqHaVmListVo.vmNm}" /></td>
													<td class="alignL"><c:out value="${rsrcReqHaVmListVo.vmCompId}" /></td>
												</tr>
											</c:forEach>
											</c:otherwise>
											</c:choose>
								      </tbody>
								    </table>
								  </td>
		  						</tr>

						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
	    </div>
	  </div><!-- /box -->


<form:form commandName="rsrcReqVmSpecChngInfo" name="rsrcReqVmSpecChngFrm"	id="rsrcReqVmSpecChngFrm" method="post">
	<form:hidden path="regionId" value= "${vmVo.regionId }" />  <!-- 센터ID -->
	<form:hidden path="zoneId" value= "${vmVo.zoneId }"   />   <!-- 존ID -->
	<form:hidden path="netId" value= "${vmVo.netId }"  />  <!-- 망ID -->
	<form:hidden path="netClCd" value= "${vmVo.netClCd }"  />  <!-- 망구분코드 -->
	<form:hidden path="rsrcPoolId"  value= "${vmVo.rsrcPoolId }" />  <!-- 매니저ID -->
	<form:hidden path="vmSeq"  value= "${vmVo.vmSeq }" />  <!-- 가상서버UUID -->
	<form:hidden path="uuid"  value= "${vmVo.uuid }" />  <!-- 가상서버UUID -->
	<form:hidden path="rsrcReqNo" />  <!-- 자원요청번호 -->
	<form:hidden path="rsrcReqSeq" />  <!-- 자원요청일련번호 -->
	<form:hidden path="rsrcReqDtlPrcssStatCd" />  <!-- 자원요청상세진행상태코드 -->
	<form:hidden path="schRsrcReqNo" value="${rsrcReqVmSpecChngInfo.rsrcReqNo}" /> <!-- 조회 자원요청번호  -->
	<form:hidden path="procssInstSeq" />  <!-- 프로세스인스턴스ID -->
	<form:hidden path="rsrcReqTyCd" />  <!-- 자원요청 구분 코드  -->
	<form:hidden path="vmChngClCd" />  <!-- 자원요청 구분 코드  -->
	<form:hidden path="reqStrgDmnSeq" />  <!-- 스토리지도메인SEQ -->
	<form:hidden path="vrCnvrSwTyCd" value= "${vmVo.vrlzSwTyCd }" />  <!-- 가상화SW유형코드 -->
	<form:hidden path="haCompYn" />  <!-- ha여부-->
	<form:hidden path="ticktNo" />  <!--티켓번호-->
	<form:hidden path="exeType" />  <!-- 실행타입-->
	<form:hidden path="chngReqCpuVcoreQty" value="${rsrcReqVmSpecChngInfo.chngReqCpuVcoreQty}" />  <!-- 요청 CPU 코어수-->
	<form:hidden path="chngReqMemAsgnCapa" value="${rsrcReqVmSpecChngInfo.chngReqMemAsgnCapa}" />  <!-- 요청 MEM 욜량-->
	<form:hidden path="chngReqStrgAsgnCapa" value="${rsrcReqVmSpecChngInfo.chngReqStrgAsgnCapa}" />  <!-- 요청 스토리지 량-->
	<form:hidden path="chngPreStrgAsgnCapa" value="${rsrcReqVmSpecChngInfo.chngPreStrgAsgnCapa}" />  <!-- 요청 스토리지 량-->



	<div class="box detail-list-box">
		<c:if test="${rsrcReqVmSpecChngInfo.vmChngClCd eq '01'}">
			<div class="box-header">
		    <h3 class="box-title">가상서버 스펙변경 정보</h3>
		  </div>

    	<!-- box-body s-->
	    <div class="box-body no-padding">
	      <table class="table table-vertical">
	      	<caption>가상서버스펙변경정보(변경전,변경후)</caption>
	        <colgroup>
	        <col class="col25">
	        <col class="col25">
	        <col class="col25">
	        <col class="col25">
	        </colgroup>
          <thead>
            <tr>
              <th colspan="2" class="bg-dark" style="border-bottom: 1px solid #D5CEC0;">변경 전</th>
              <th colspan="2" class="bg-blue" style="border-bottom: 1px solid #D3C1C1;">변경 후</th>
            </tr>
            <tr>
              <th>vCore</th>
              <th>메모리(GB)</th>
              <th>vCore</th>
              <th>메모리(GB)</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="alignC"><c:out value="${rsrcReqVmSpecChngInfo.chngPreCpuVcoreQty}" /></td>
              <td class="alignC"><c:out value="${rsrcReqVmSpecChngInfo.chngPreMemAsgnCapa}" /></td>
              <td class="alignC"><c:out value="${rsrcReqVmSpecChngInfo.chngReqCpuVcoreQty}" /></td>
              <td class="alignC"><c:out value="${rsrcReqVmSpecChngInfo.chngReqMemAsgnCapa}" /></td>
            </tr>
          </tbody>
        </table>
    	</div>

    	<div class="box detail-list-box">
	      <div class="box-header">
	        <h3 class="box-title">가상서버 스펙변경 설정</h3>
	    	</div>

				<div class="box-body no-padding">
			    <table class="table table-horizon">
			      <caption>가상서버 스펙변경 설정</caption>
						<colgroup>
							<col class="col10">
							<col class="col90">
						</colgroup>
		        <tbody>
		        	<tr>
			        	<th><span class="text-red">*</span>가상서버 재기동 여부</th>
		            <td colspan="5">

		              <div class="input-group">
		                <form:select path="vmStopYn" cssClass="form-control" title="가상서버 재기동 여부">
		                	<form:option value="N">N</form:option>
			              	<form:option value="Y">Y</form:option>
										</form:select>
		              </div>
		            </td>
		          </tr>



		          <tr id="specMaxMinDiv" style="display:none;">
	                <th>스펙 변경 허용범위</th>
	                  <td>

	                    <table id="specMaxMinTable" class="table table-bordered table-vertical">
	                    	<caption>스펙 허용범위 선택</caption>
	                      <colgroup>
				          				<col class="col20">
				          				<col class="col40">
				          				<col class="col40">
	                      </colgroup>
	                      <thead>
	                        <tr>
	                          <th>구분</th>
	                          <th>최소값</th>
	                          <th>최대값</th>
	                        </tr>
	                      </thead>
	                      <tbody>
						  	<tr>
						      <th>
							    <label for="cpuVcoreQty">CPU vCore</label>
							  </th>
							  <td><c:out value="${vmVo.minCpuVcoreQty }" /></td>
							  <td><c:out value="${vmVo.maxCpuVcoreQty }" /></td>
							</tr>
							<tr>
							  <th>
								<label for="memAsgnCapa">메모리(GB)</label>
							  </th>
							  <td><c:out value="${vmVo.minMemAsgnCapa }" /></td>
							  <td><c:out value="${vmVo.maxMemAsgnCapa }" /></td>
							</tr>
                      </tbody>
                    </table>
                    <br>* 스펙변경 허용범위에 포함될 경우  가상서버 재 기동을 하지 않아도 정상적으로 반영됩니다.<br>
                  </td>
              </tr>



		        </tbody>
			    </table>
			  </div>
			</div>
		</c:if>
  </div>

	<c:if test="${rsrcReqVmSpecChngInfo.vmChngClCd eq '02'}">

		<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title">스토리지 정보</h3>
				<div class="box-tools">
					<div class="pull-right">
					</div>
				</div>
			</div>
			<div class="box-body no-padding detail-list-body">
				<table class="table table-vertical table-layout-fixed" id="vrDskTable">
					<caption>스토리지 정보</caption>
					<thead>
						<tr>
							<th><nobr title="No.">No.</nobr></th>
							<th><nobr title="스토리지도메인명">도메인명</nobr></th>
							<th><nobr title="디스크명">디스크명</nobr></th>
							<th><nobr title="용량 (GB)">용량 (GB)</nobr></th>
							<th><nobr title="용도">용도</nobr></th>
							<th><nobr title="생성일자">생성일자</nobr></th>
							<th><nobr title="비고">비고</nobr></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vrDskVo" items="${vrDskListVo}" varStatus="i">
							<tr>
								<td><nobr title="<c:out value="${i.count }" />"><c:out value="${i.count }" /></nobr></td>
								<td class="alignL"><nobr title="<c:out value="${vrDskVo.strgDmnNm }"/>"><c:out value="${vrDskVo.strgDmnNm }"/></nobr></td>
								<td class="alignL"><nobr title="<c:out value="${vrDskVo.vrDskNm }"/>"><c:out value="${vrDskVo.vrDskNm }"/></nobr></td>
								<td class="alignR"><nobr title="<c:out value="${vrDskVo.dskAsgnCapa }"/>"><c:out value="${vrDskVo.dskAsgnCapa }"/></nobr></td>
								<td class="alignL"><nobr title="<c:out value="${vrDskVo.prpos }"/>"><c:out value="${vrDskVo.prpos }"/></nobr></td>
								<td><nobr title="<fmt:formatDate value="${vrDskVo.creDt }" pattern="YYYY-MM-dd"/>"><fmt:formatDate value="${vrDskVo.creDt }" pattern="YYYY-MM-dd"/></nobr></td>
								<td class="alignL"><nobr title="<c:out value="${vrDskVo.rmk }"/>"><c:out value="${vrDskVo.rmk }"/></nobr></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

    <div class="box detail-list-box">
      <div class="box-header">
        <h3 class="box-title">스토리지 추가 설정</h3>
    </div>

		<div class="box-body no-padding">
	    <table class="table table-horizon">
	      <caption>스토리지 추가 설정</caption>
				<colgroup>
					<col class="col10">
					<col class="col23">
					<col class="col10">
					<col class="col23">
					<col class="col10">
					<col class="col24">
				</colgroup>
        <tbody>
        	<c:if test="${vmVo.vrlzSwTyCd ne '03'}">
				<tr>
		        	<th><span class="text-red">*</span>스토리지 선택</th>
		            <td colspan="5">
		              <div class="input-group">
		              	<form:input path="reqStrgDmnNm" class="form-control essential" disabled="true" title="스토리지 선택"/>
		                	<div class="input-group-btn pad-left-5"><button id="asgnVrDskBtn" class="btn btn-default" onclick="javascript:fn_asgnVrDskNmOpen();return false;" data-toggle="tooltip" data-original-title="스토리지선택"><i class="fa fa-search"></i></button></div>
		                	<div class="input-group-btn"><button id="initStrgBtn" class="btn btn-default" onclick="fn_StrgDmnClear('STRG');return false;" data-toggle="tooltip" data-original-title="초기화"><i class="fa fa-eraser"></i></button></div>
		              </div>
		            </td>
		        </tr>
        	</c:if>
            <tr>
	        	<th><span class="text-red">*</span>할당정책 선택</th>
        		<td colspan="5">
	            <nform:selectCode
								parentCd="150"
								parentGrpCd="094"
								name="reqStrgAsgnPolicyCd"
								id="reqStrgAsgnPolicyCd"
								wholeText="할당정책을 선택하세요."
								value="${rsrcReqVmSpecChngInfo.reqStrgAsgnPolicyCd }"
								title="할당정책"
								cssClass="form-control essential" />
				</td>
          	</tr>
          <tr>
           	<th>현재량</th><td><c:out value="${rsrcReqVmSpecChngInfo.chngPreStrgAsgnCapa}" /><small><c:out value="(GB)"></c:out></small></td>
            <th>요청승인량</th><td><c:out value="${rsrcReqVmSpecChngInfo.chngReqStrgAsgnCapa}" /><small><c:out value="(GB)"></c:out></small></td>
            <th>총량</th><td><c:out value="${rsrcReqVmSpecChngInfo.chngPreStrgAsgnCapa+rsrcReqVmSpecChngInfo.chngReqStrgAsgnCapa}" /><small><c:out value="(GB)"></c:out></small></td>
          </tr>
        </tbody>
	    </table>
	   </div>
	  </div>
  </c:if>

    <div class="box-footer clearfix">
    	<div class="pull-right">
        	<button id="procssStatBtn" class="btn btn-sm" onclick="javascript:fn_procssStatOpen(); return false;"><i class="fa fa-file-o"></i>진행상태조회</button>
        	<button id="nTopsReSendBtn" class="btn btn-sm" onclick="javascript:fn_resendNtops(); return false;"><i class="fa fa-file-o"></i>nTOPS 결과 재전송</button>
    	</div>
  	</div><!-- /box-footer -->
	<br>

</form:form>
  </div><!-- /col -->

<c:if test="${vmVo ne null}">
	<form:form commandName="vmVo" name="vmFrm"	id="vmFrm" method="post" action="">
		<form:hidden path="vmSeq"/>
		<form:hidden path="statGrpCd"/>
		<form:hidden path="statGrpCdNm"/>
	</form:form>
</c:if>

 <!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
  <div class="col-box-100">
    <!-- page-btn-group -->
    <div class="edit-btn-group">

	    <c:url var="updateUrl" value="updateRsrcReq.do">
				<c:forEach var="curParam" items="${param }">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:forEach>
			</c:url>
			<c:url var="listUrl" value="selectRsrcReqList.do">
				<c:forEach var="curParam" items="${param }">
					<c:if test="${curParam.key ne 'boardSeq'}">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>


	    <div class="pull-left btns">
	      <button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
	    </div>
	    <div class="pull-right btns">
	    	<menu:authorize authType="act" onlyOprAdm="true">
	    	  <c:if test="${vmVo.delYn eq 'N'}">
			  <button id = "manualRsrcReqBtn" class="btn btn-sm btn-hover-green" onclick="javascript:fn_execRsrcReq('M')"  data-toggle="tooltip" title="" data-original-title="수동완료"><i class="fa fa-arrow-circle-o-right"></i></button>
		      <button id="execRsrcReqBtn" class="btn btn-sm btn-hover-green" onclick="javascript:fn_execRsrcReq()"  data-toggle="tooltip" title="" data-original-title="실행"><i class="fa fa-play-circle"></i></button></c:if>
		      <button id="rjctRsrcReqBtn" class="btn btn-sm btn-hover-red" onclick="javascript:fn_rjctRsrcReq()" data-toggle="tooltip" title="" data-original-title="반려"><i class="fa fa-times"></i></button>
	    	</menu:authorize>

				<menu:modAuthorize regId="${rsrcReqVmSpecChngInfo.regUserId }">
					<button id = "deleteRsrcReqBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="javascript:fn_deleteRsrcReq()"><i class="fa fa-minus"></i></button>
				</menu:modAuthorize>
	    </div>
    </div><!-- /page-btn-group -->
  </div><!-- /col -->

<script type="text/javascript">
$(function() {
	fn_formInit("${rsrcReqVmSpecChngInfo.rsrcReqPrcssStatCd}");
	setInterval(function(){ fn_selectVmStatSync(); }, 30*1000);
});

//폼 셋팅
function fn_formInit(statCd) {

	var testYn = "${rsrcReqVmSpecChngInfo.testYn }"; //테스트여부
	var vmChngClCd = "${rsrcReqVmSpecChngInfo.vmChngClCd }";

	if(testYn != 'Y') {
		$("#deleteRsrcReqBtn").hide();  //삭제버튼을 감춘다.
	}

	if(statCd != '01') {

		$('select').each(function(){
			try{
				$(this).attr('disabled','disabled');
			}catch(e){}
		});

		$("#manualRsrcReqBtn").hide(); //수동실행버튼을 숨긴다.
		$("#execRsrcReqBtn").hide();
		$("#rjctRsrcReqBtn").hide();
		$("#procssStatBtn").show(); //진행상태 버튼을 활성화한다
		$("#nTopsReSendBtn").hide(); //nTOPS 재전송  버튼을 활성화한다.


		if(statCd == '04' || statCd == '07' ){  //반려상태 , 수동완료상태인 경우
			$("#procssStatBtn").hide(); //진행상태 버튼을 숨긴다.
		}

		if(statCd == '03' ||  statCd == '07' ){  //완료,  수동완료상태인 경우
			$("#nTopsReSendBtn").show(); //nTOPS 재전송  버튼을 활성화한다.
		}
	}else {
    	$("#manualRsrcReqBtn").show(); //수동실행버튼을 활성화한다.
		$("#procssStatBtn").hide();
		$("#nTopsReSendBtn").hide();
	}

	//IBM PVM 인경우
	if($('#vrCnvrSwTyCd').val() == '04' && vmChngClCd != "02") {
		document.getElementById('specMaxMinDiv').style.display = ""; //스펙 허용범위 선택영역을 보여준다.
	}

	if($("#haCompYn").val() == 'Y') {
		document.getElementById('trHaDiv').style.display = ""; //HA영역을 보여준다.
	}

	// 스토리지 생성요청 이면서, HP인경우
	if($('#vrCnvrSwTyCd').val() == '03' && vmChngClCd == "02") {
		$("#reqStrgAsgnPolicyCd").val("02"); // Preallocated
		$("#reqStrgAsgnPolicyCd").attr('disabled', true); // 할당영역을 고정시켜준다.
	}
}


//가상서버 시작, 중지, 강제종료, 동기화
function fn_vmHandl(type) {

	var msgStr = "";
	var urlStr = "";

	if(type =="S") {  //시작
		msgStr = "가상서버를 시작 하시겠습니까?";
		urlStr = "<c:url value='/cpt/rsrc/com/vm/executeVmStart.do'/>";
		jConfirm(msgStr, function(){ sendRequestvmHandl(urlStr); });
	}else if(type =="T") { //중지
		msgStr = "가상서버를 중지 하시겠습니까?";
		urlStr = "<c:url value='/cpt/rsrc/com/vm/executeVmShutdown.do'/>";
		jConfirm(msgStr, function(){ sendRequestvmHandl(urlStr); });
	}else if(type =="O") { //강제종료
		msgStr = "가상서버를 강제종료 하시겠습니까?";
		urlStr = "<c:url value='/cpt/rsrc/com/vm/executeVmStop.do'/>";
		jConfirm(msgStr, function(){ sendRequestvmHandl(urlStr); });
	}else if(type =="D") { //동기화
		//msgStr = "가상서버 상태정보를 동기화 하시겠습니까?";
		urlStr = "<c:url value='/cpt/rsrc/com/vm/selectExecVmStatSync.do'/>";
		sendRequestvmHandl(urlStr);
	}
}
function sendRequestvmHandl(urlStr){
	var vmSeq = "${vmVo.vmSeq}";

	$.ajax({
		type : "POST"
		,url : urlStr
		,data : "vmSeq="+vmSeq
		,beforeSend: function() {
			$.ncmsLoding.startFullScreen();
		}
		,complete : function() {
		  	$.ncmsLoding.remove();
		}
		,error: function(xhr, textStatus, errorThrown){
			 $.ncmsLoding.remove();
			jAlert('오류가 발생하였습니다.');
		}
		,success :executeVmHandlResultHandler,

	});
}


// fn_vmHandl success
function executeVmHandlResultHandler(result){
	if(result.success){
		//성공 메시지 삭제 및  reload
		fn_selectVmStatSync();
	}
	else{
		jAlert(result.messageList);
	}
}

//스토리지선택 버튼 클릭 시
function fn_asgnVrDskNmOpen(){

	var regionId = $('#regionId').val();
	var zoneId =$('#zoneId').val();
	var netId = $('#netId').val();
	var poolId = $('#rsrcPoolId').val();

	var params = { searchRegionId: regionId, searchZoneId : zoneId , searchNetId : netId , searchRsrcPoolId : poolId };
	var args = {key:"selectRsrcReqStrgP", width:1280 , height:720};
	windowOpen('selectRsrcReqStrgP.do', params, args);
}

//스토리지 선택 callback
function fn_selectedStrg(strg){
	$('#reqStrgDmnNm').val(strg.strgDmnNm);
	$('#reqStrgDmnSeq').val(strg.strgDmnSeq);
}

//스토리지 선택 초기화
function fn_StrgDmnClear(target){
	$('#reqStrgDmnNm').val('');
	$('#reqStrgDmnSeq').val('');
}


//가상서버 상태확인 (실행중인지 체크)
function checkValidateVm(){
	var vmChngClCd = "${rsrcReqVmSpecChngInfo.vmChngClCd}";	//01: 가상서버 스펙변경 , 02: 스토리지 추가
	var statGrpCd = $('#vmFrm #statGrpCd').val();  // "${vmVo.statGrpCd}";	//01:다운, 02: 업, 03:진행중, 04:예외
	var vmStopYn = $('#vmStopYn').val();  // 가상서버중지여부
	var vrCnvrSwTyCd = $('#vrCnvrSwTyCd').val(); //가상화SW유형코드

	if(vrCnvrSwTyCd == '02' && vmChngClCd=='01' && statGrpCd!='01') { //VmWare인 경우는 가상서버 다운 상태에서만 스펙변경이 가능함.
		return false;
	}


	if(statGrpCd =='01' || statGrpCd=='' || vmChngClCd=='02' || (vmChngClCd=='01' && vmStopYn == "N") ){
		//다운 또는 없을 경우만 처리
		return true;
	}


	return false;
}

//실행 버튼 클릭 시
function fn_execRsrcReq(btnFlag) {

	if(!fn_form_validation("rsrcReqVmSpecChngFrm")){
		return;
	}

	//RHEV가 아닐경우
	//if($('#vrCnvrSwTyCd').val() != '01') {
	//국정자원 정책상 down 후 스펙변경 , 스토리지변경 , 가상서버 삭제 실행하기로 함. 2018.02.08 확인사항.
		if(!checkValidateVm() && btnFlag != 'M'){
			jAlert("가상서버가 상태 ["+ ($('#vmFrm #statGrpCdNm').val())+"].\n가상서버 [다운(OFF)] 상태만 실행 가능합니다.");
			return;
		}
	//}

	var delyn = "${vmVo.delYn}";
	var msg = '실행 하시겠습니까?';
	if(delyn == 'Y'){
		msg = '삭제된 가상서버입니다.\n-실행하시겠습니까?';
	}

	// 수동 실행 버튼 클릭시
	if(btnFlag == 'M') {
		$('#exeType').val(btnFlag);
	}

	jConfirm(msg, function(){
		$.ncmsLoding.startFullScreen();
		$.post('formRsrcReqVmSpecChngExec.do', $('#rsrcReqVmSpecChngFrm').serialize(), fn_callbackRsrcReqVmSpecChng, 'json').always(function(){$.ncmsLoding.remove();});
	});

}

//삭제 버튼 클릭 시
function fn_deleteRsrcReq() {
	jConfirm('삭제 하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateRsrcReqDeleteYn.do', $('#rsrcReqVmSpecChngFrm').serialize(), function(result) {

			jInfo(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

//실행 후
function fn_callbackRsrcReqVmSpecChng(result){
	if(result.success){
		jInfo(result.messageList, function() {
			fn_reloadPage();
		});
	}else{
		jAlert(result.messageList);
	}
}

function fn_reloadPage(){
	location.reload();
	//$("#rsrcReqVmSpecChngFrm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/formRsrcReqVmSpecChng.do'/>");
  	//$("#rsrcReqVmSpecChngFrm").submit();
}

//반려버튼 클릭 시
function fn_rjctRsrcReq() {
	//alert("추후개발예정");
	var params = { rsrcReqNo : $('#rsrcReqNo').val() , rsrcReqSeq : $('#rsrcReqSeq').val(), rsrcReqTyCd: $('#rsrcReqTyCd').val() };

	var width = 740;
	var height = 290;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {key:"RsrcReqRjct", width:width , height:height, posX : posX , posY : posY};

	windowOpen('selectRsrcReqRjctP.do', params, args)
}


/**
 *  실행내역
 */
function fn_procssStatOpen(){
	//jAlert("작업진행내역팝업 오픈 -진행 내역 요약 상세 화면은 협의 후 수정이 필요. ");
	var params = { rsrcReqNo : $('#rsrcReqNo').val() , rsrcReqSeq : $('#rsrcReqSeq').val()};
	var args = {key:"selectRsrcReqExeListP", width: 1100 , height: 710 };
	windowOpen('selectRsrcReqExeListP.do', params, args);
}


/**
* nTOPS 결과 재전송
*/
function fn_resendNtops(){
	var rsrcReqNo = $('#rsrcReqVmSpecChngFrm #rsrcReqNo').val();
	var rsrcReqTyCd = $('#rsrcReqVmSpecChngFrm #rsrcReqTyCd').val();

	jConfirm("nTOPS 결과 재전송을  실행하시겠습니까", function(result){
		var data ={ rsrcReqNo : rsrcReqNo ,
				rsrcReqTyCd : rsrcReqTyCd
		};

		$.post("<c:url value='resendResultToNtops.do'/>", data, fn_callbackResendNtops, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

//실행 후
function fn_callbackResendNtops(result){
	if(result.success){
		jInfo(result.messageList);
	}else{
		jAlert(result.messageList);
	}
}

/**
 *  주기적 동기화
 */
 var xhr = null;
 function fn_selectVmStatSync(){

	var vmSeq = "${vmVo.vmSeq}";

	if(vmSeq ==null || vmSeq == undefined || vmSeq ==''){
		console.log("vmSeq is not existed. No Reflash!");
		return;
	}

	$.ajax({
		type: 'post'
		, url : "/cpt/rsrc/com/vm/selectVmStatSync.do"
		, data : "vmSeq="+vmSeq
		, success: selectVmStatSyncResultHandler
		, beforeSend: function() {
		}
		, complete : function() {
		}
		,error: function(xhr, textStatus, errorThrown){
			if(xhr.status === 0 || xhr.readyState === 0){
				console.log(xhr);
				return;
			}
			jAlert('오류가 발생하였습니다.');
		}
	});
}

 /**
 * 	동기화 결과 출력
 */
function selectVmStatSyncResultHandler(result){
	if(result.success){
		if(result.data && result.data.statGrpCd){

			var statGrpCd = result.data.statGrpCd;
			var $container = $('div.server');


			$container.find('.col-info-box.alignL .label').remove();
			switch(statGrpCd){
			case '01' : // 다운(OFF)
				$container.removeClass('server-up').removeClass('server-inprogress').removeClass('server-exception').addClass('server-down');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '02' : // 업(ON)
				$container.removeClass('server-down').removeClass('server-inprogress').removeClass('server-exception').addClass('server-up');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '03' : // 처리중
				$container.removeClass('server-up').removeClass('server-down').removeClass('server-exception').addClass('server-inprogress');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			case '04' : // 예외
				$container.removeClass('server-up').removeClass('server-down').removeClass('server-inprogress').addClass('server-exception');
				$container.find('.stat').before('<span class="label"></span>');
				break;
			default : // 그외
				break;
			}

			if(statGrpCd == '03'){
				$container.find('.stat').html(result.data.statGrpCdNm + "("+ result.data.statCdNm+")");
			}else{
				$container.find('.stat').html(result.data.statGrpCdNm);
			}

			$container.find('.vm-start').prop('disabled', ("01" != statGrpCd));
			$container.find('.vm-shutdown').prop('disabled', ("02" != statGrpCd));
			$container.find('.vm-stop').prop('disabled', ("02" != statGrpCd));

			$('#vmFrm #statGrpCd').val(statGrpCd);
			$('#vmFrm #statGrpCdNm').val(result.data.statGrpCdNm);
		}
	}
	else{
		jAlert(result.messageList);
	}
}


</script>