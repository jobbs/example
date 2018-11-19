<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청상세-가상서버 생성 </pre>
 *
 * @author hsLee
 * @lastmodifier hsLee
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>

	<div class="col-box-100 detail-col">

		<!-- HA 요청건일 경우만 보여주는 영역 #시작#  -->
		<div id="haDiv" style="display:none;">
			<div class="box detail-list-box">
			  <div class="box-header">
			    <h3 class="box-title">HA 목록</h3>
			  </div><!-- /box-header -->

			  <div class="box-body no-padding">
		      <table id="haListTable" class="table table-bordered table-vertical">
		       	<caption>HA정보</caption>
			        <colgroup>
							<col class="col5">
							<col class="col5">
							<col class="col20">
							<col class="colAuto">
							<col class="col10">
							<col class="col10">
							<col class="col10">
							<col class="col10">
			        </colgroup>
		        <thead>
		           <tr>
		           	 <th class="bg-blue">선택</th>
		             <th class="bg-blue">No.</th>
		             <th class="bg-blue">HA그룹명</th>
		             <th class="bg-blue">가상서버명</th>
		             <th class="bg-blue">자원요청번호</th>
		             <th class="bg-blue">HA상태</th>
		             <th class="bg-blue">설정상태</th>
		             <th class="bg-blue">진행상태</th>
		           </tr>
		         </thead>
		         <tbody>
		         <c:choose>
								<c:when test="${rsrcReqHaVmList eq null or empty rsrcReqHaVmList }">
									<tr>
										<td colspan="6">검색된 데이터가 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="rsrcReqHaVmListVo" items="${rsrcReqHaVmList }" varStatus="i">
		                <tr>
		                	<td><input type="radio" id="haRdo" name="haRdo" value="${rsrcReqHaVmListVo.rsrcReqNo}" /></td>
		                  <td><c:out value="${i.count}" /></td>

		                  <c:if test="${tempHaGrpNm != rsrcReqHaVmListVo.haGrpNm }">
		          					<c:set var="tempHaGrpNm" value="${rsrcReqHaVmListVo.haGrpNm }"/>
		          					<td class="alignL" rowspan="${rsrcReqHaVmList.size()}"><c:out value="${rsrcReqHaVmListVo.haGrpNm}" /></td>
		          				</c:if>

		                  <td class="alignL"><c:out value="${rsrcReqHaVmListVo.vmNm}" /></td>
		                  <td><c:out value="${rsrcReqHaVmListVo.rsrcReqNo}" /></td>
		                  <td><c:out value="${rsrcReqHaVmListVo.haStatNm}" /></td>
		                  <td>
		                  <c:if test="${rsrcReqHaVmListVo.exeStatCd ne '02' }">
		                  <font color="red"><c:out value="${rsrcReqHaVmListVo.exeStatNm}" /></font>
		                  </c:if>
		                  <c:if test="${rsrcReqHaVmListVo.exeStatCd eq '02' }">
		                  <c:out value="${rsrcReqHaVmListVo.exeStatNm}" />
		                  </c:if></td>
		                  <td>
		                  <c:if test="${rsrcReqHaVmListVo.procssStatCd ne '03' && rsrcReqHaVmListVo.procssStatCd ne '07' && rsrcReqHaVmListVo.exeStatCd ne '01'  }">
		                  <div class="pull-center">
						             <button id="haProcssStatBtn${i.count}" class="btn btn-sm" onclick="javascript:fn_procssStatOpen('${rsrcReqHaVmListVo.rsrcReqNo}', '${rsrcReqHaVmListVo.rsrcReqSeq}'); return false;"><i class="fa fa-file-o"></i>진행상태조회</button>
						         	</div>
						   </c:if>
						  <c:if test="${rsrcReqHaVmListVo.procssStatCd eq '07'}">
						  <div class="pull-center">
						         	<button id="haNTopsReSendBtn" class="btn btn-sm" onclick="javascript:fn_resendNtops(); return false;"><i class="fa fa-file-o"></i>nTOPS 결과 재전송</button>
						  </div>
						  </c:if>
		                  <c:if test="${rsrcReqHaVmListVo.procssStatCd eq '03'}">대기중</c:if>
		                  </td>
		                </tr>
			            </c:forEach>
								</c:otherwise>
							</c:choose>
			      </tbody>
			    </table>
			  </div>
			</div>
		</div>
		<!-- HA 요청건일 경우만 보여주는 영역 #끝#  -->


		<div class="box detail-list-box">
		  <div class="box-header">
		    <h3 class="box-title">기본 정보</h3>
		  </div><!-- /box-header -->

		  <div class="box-body no-padding">
	      <table class="table table-horizon">
	      	<caption>가상서버 생성 기본정보</caption>
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
		       	<tr>
		          <th>제목</th><td colspan="3"><c:out value="${rsrcReqVmCreInfo.sbjct }"/></td>
		          <th>실행자</th><td><c:out value="${rsrcReqVmCreInfo.exeUserNm }"/></td>
		          <th>실행일시</th><td><c:out value="${rsrcReqVmCreInfo.exeDttm }"/></td>
		        </tr>
		        <tr>
		          <th>상태</th>
		          <td>
					<span class="status
						<c:choose>
							<c:when test="${'01' eq rsrcReqVmCreInfo.rsrcReqPrcssStatCd}"><c:out value="status-blue"/></c:when>
							<c:when test="${'02' eq rsrcReqVmCreInfo.rsrcReqPrcssStatCd}"><c:out value="status-yellow"/></c:when>
							<c:when test="${'03' eq rsrcReqVmCreInfo.rsrcReqPrcssStatCd}"><c:out value="status-green"/></c:when>
							<c:when test="${'04' eq rsrcReqVmCreInfo.rsrcReqPrcssStatCd}"><c:out value="status-aqua"/></c:when>
							<c:when test="${'05' eq rsrcReqVmCreInfo.rsrcReqPrcssStatCd}"><c:out value="status-red"/></c:when>
							<c:when test="${'06' eq rsrcReqVmCreInfo.rsrcReqPrcssStatCd}"><c:out value="status-gray"/></c:when>
							<c:when test="${'07' eq rsrcReqVmCreInfo.rsrcReqPrcssStatCd}"><c:out value="status-green"/></c:when>
							<c:otherwise><c:out value="status-gray"/></c:otherwise>
						</c:choose>
               			status-red "><c:out value="${rsrcReqVmCreInfo.rsrcReqPrcssStatNm}"/>
               		</span>
					</td>
		          <th>티켓번호</th><td><c:out value="${rsrcReqVmCreInfo.ticktNo }"/></td>
		          <th>요청번호</th><td><c:out value="${rsrcReqVmCreInfo.rsrcReqNo }"/></td>
		          <th>요청일시</th><td><c:out value="${rsrcReqVmCreInfo.rsrcReqDttm }"/></td>
		        </tr>
		        <tr>
		          <th>요청유형</th><td><c:out value="${rsrcReqVmCreInfo.rsrcReqTyNm }"/></td>
		          <th>요청자</th><td><c:out value="${rsrcReqVmCreInfo.rsrcReqUsrNm }"/></td>
		          <th>요청부처</th><td><c:out value="${rsrcReqVmCreInfo.reqInstitutionNm }"/></td>
		          <th>핸드폰</th><td><c:out value="${rsrcReqVmCreInfo.mobile }"/></td>
		        </tr>
		        <tr>
		          <th>이메일</th><td><c:out value="${rsrcReqVmCreInfo.email }"/></td>
		          <th>완료일시</th><td><c:out value="${rsrcReqVmCreInfo.comptDttm }"/></td>
		          <th>테스트여부</th>
		          <td colspan="3" >
					<c:choose>
						<c:when test="${rsrcReqVmCreInfo.testYn eq 'Y'}">예</c:when>
						<c:when test="${rsrcReqVmCreInfo.testYn eq 'N'}">아니오</c:when>
						<c:otherwise><c:out value="${rsrcReqVmCreInfo.testYn}"/></c:otherwise>
					</c:choose>
				</td>
		        </tr>
	        </tbody>
	      </table>
		  </div>
		</div>

	  <div class="box detail-list-box">
	    <div class="box-header">
	      <h3 class="box-title">가상서버 생성 정보</h3>
	   </div><!-- /box-header -->

	    <div class="box-body no-padding">
	      <table class="table table-horizon"><caption>가상서버 생성 상세정보</caption>
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
	          <tr>
	          	<th>부처</th><td><c:out value="${rsrcReqVmCreInfo.useGvDprtNm }"/></td>
	          	<th>업무</th><td><c:out value="${rsrcReqVmCreInfo.useJobNm }"/></td>
	            <th>용도</th><td><c:out value="${rsrcReqVmCreInfo.prposNm }"/></td>
	            <th>서비스기간</th><td><c:out value="${rsrcReqVmCreInfo.servcDtNm }"/></td>
	          </tr>
	          <tr>
	          	<th>센터(망구분)</th><td><c:out value="${rsrcReqVmCreInfo.regionNm }"/>(<c:out value="${rsrcReqVmCreInfo.netNm }"/>)</td>
	            <th>가상서버명</th><td><c:out value="${rsrcReqVmCreInfo.vmNm }"/></td>
	            <th>가상서버ID</th><td><c:out value="${rsrcReqVmCreInfo.vmId }"/></td>
	            <th>가상서버구성ID</th><td><c:out value="${rsrcReqVmCreInfo.vmCompId }"/></td>
	          </tr>
	          <tr>
	          	<th>운영체제</th><td><c:out value="${rsrcReqVmCreInfo.osNm }"/></td>
	          	<th>Hypervisor종류</th><td><c:out value="${rsrcReqVmCreInfo.vrCnvrSwTyNm }"/></td>
	          	<th>호스트명</th><td><c:out value="${rsrcReqVmCreInfo.hstNm }"/></td>
	          	<th>소프트웨어</th><td><c:out value="${rsrcReqVmCreInfo.swTyNm }"/></td>
	          </tr>
	          <tr>
	            <th>CPU vCore</th><td><c:out value="${rsrcReqVmCreInfo.reqCpuVcoreQty }"/></td>
	            <th>메모리(GB)</th><td><c:out value="${rsrcReqVmCreInfo.reqMemAsgnCapa }"/></td>

	            <c:if test="${rsrcReqVmCreInfo.haYn eq 'Y'}">
	            <th>OS 스토리지(GB)</th><td><c:out value="${rsrcReqVmCreInfo.strgAsgnCapa }"/></td>
	            <th>HA 스토리지(GB)</th><td><c:out value="${rsrcReqVmCreInfo.haStrgCapa }"/></td>
	            </c:if>
	            <c:if test="${rsrcReqVmCreInfo.haYn ne 'Y'}">
	            <th>OS 스토리지(GB)</th><td colspan="3"><c:out value="${rsrcReqVmCreInfo.strgAsgnCapa }"/></td>
	            </c:if>
	          </tr>
	        </tbody>
	      </table>
	    </div>
	  </div>

  	<form:form commandName="rsrcReqVmCreInfo" name="rsrcReqVmCreFrm"	id="rsrcReqVmCreFrm" method="post" action="">
	    <form:hidden path="regionId" />  <!-- 센터ID -->
	    <form:hidden path="zoneId" />   <!-- 존ID -->
	    <form:hidden path="netId" />  <!-- 망ID -->
	    <form:hidden path="rsrcPoolId" />  <!-- 매니저ID -->
	    <form:hidden path="pmSeq" />  <!-- 물리서버일련번호 -->
	    <form:hidden path="reqVrDskId" />  <!-- 가상디스크ID -->
	    <form:hidden path="tmplatSeq" />  <!-- 템플릿Seq -->
	    <form:hidden path="pSrvrNm" />  <!-- 물리서버명 -->
	    <form:hidden path="asgnVrDskId" />  <!-- 할당가상디스크ID -->
	    <form:hidden path="useGvDprtId" />  <!-- 부처ID -->
	    <form:hidden path="useJobId" />  <!-- 업무ID -->
	    <form:hidden path="rsrcReqNo" />  <!-- 자원요청번호 -->
	    <form:hidden path="rsrcReqSeq" />  <!-- 자원요청일련번호 -->
	    <form:hidden path="prposNm" />  <!-- 용도 -->
	    <form:hidden path="haGrpCd" />  <!-- HA그룹코드 -->
			<form:hidden path="prposClCd" />  <!-- 용도코드 -->
			<form:hidden path="rsrcReqPrcssStatCd" />  <!-- 자원요청상세진행상태코드 -->
			<form:hidden path="rsrcReqDtlPrcssStatCd" />  <!-- 자원요청상세진행상태코드(상세) -->
			<form:hidden path="rsrcReqTyCd" />  <!-- 자원요청 구분 코드  -->
			<form:hidden path="schRsrcReqNo"/> <!-- 조회 자원요청번호  -->
			<form:hidden path="procssInstSeq" />  <!-- 프로세스인스턴스SEQ -->
			<form:hidden path="vrCnvrSwTyCd" />  <!-- 가상화소프트웨어유형코드 -->
			<form:hidden path="reqStrgDmnSeq" />  <!-- 스토리지도메인SEQ -->
			<form:hidden path="strgAsgnCapa" />  <!-- 스토리지할당량 -->
			<form:hidden path="netClCd" />  <!-- 망구분 코드-->
			<form:hidden path="ticktNo" />  <!-- 티켓번호-->
			<form:hidden path="vmIdAutoYn" />  <!-- 가상서버ID자동입력여부-->
			<form:hidden path="haYn" />  <!-- ha여부-->
			<form:hidden path="exeStatCd" />  <!-- 설정상태-->
			<form:hidden path="exeType" />  <!-- 실행타입-->
			<form:hidden path="osTyCd"/>  <!-- OS 타입-->
			<form:hidden path="haGrpId" />  <!-- hh그룹ID-->
			<c:if test="${rsrcReqVmCreInfo.haYn eq 'Y' and rsrcReqVmCreInfo.rsrcReqDtlPrcssStatCd ne '01'}">
			<form:hidden path="vmId" />  <!-- VM_ID -->
			<form:hidden path="clstrSeq"/>  <!-- VM_ID -->
			</c:if>

    <div class="box detail-list-box">
      <div class="box-header">
        <h3 class="box-title">가상서버 생성 설정</h3>
      </div><!-- /box-header -->

      <div class="box-body no-padding">
        <table class="table table-horizon">
        	<caption>가상서버 생성 설정</caption>
          <colgroup>
          <col class="col20">
          <col class="colAuto">
          </colgroup>
          <tbody>
            <tr>
              <th><span class="text-red">*</span>템플릿 선택</th>
                <td>
                  <div class="input-group">
                  	<form:input path="tmplatNm" cssClass="form-control essential" disabled="true" title="템플릿 선택"  />
                    <div class="input-group-btn">
                      <button id="tmplatBtn" class="btn" onclick="javascript:fn_tmplatOpen();return false;" data-toggle="tooltip" data-original-title="템플릿선택" ><i class="fa fa-search"></i></button>
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <th><span class="text-red">*</span>센터/존/망구분/가상화매니저</th>
                	<td>
                		<form:input path="rsrcPoolNm" cssClass="form-control" disabled="true" title="센터/존/망/가상화매니저명"/>
                	</td>
              </tr>
              <tr>
                <th><span class="text-red">*</span>클러스터 선택</th>
                <td>
                	<c:choose>
										<c:when test="${rsrcReqVmCreInfo.rsrcReqDtlPrcssStatCd eq '01' }">
                  	<form:select path="clstrSeq" name="clstrSeq" id="clstrSeq" title="클러스터 선택" cssClass="form-control" onchange="fn_clstrSelected(); return false;">
                  		<form:option value="">--선택하세요--</form:option>
                  	</form:select>
	                  </c:when>
										<c:otherwise>
	                  	<form:input path="clstrNm" cssClass="form-control essential" disabled="true" title="클러스터명"  />
	                  </c:otherwise>
									</c:choose>
                </td>
              </tr>
              <tr>
                <th>IP대역 선택</th>
                  <td>
                    <table class="table table-bordered table-vertical">
                    	<caption>IP대역 선택</caption>
                      <colgroup>
			          				<col class="col10">
			          				<col class="col35">
			          				<col class="col20">
			          				<col class="col10">
			          				<col class="col10">
			          				<col class="col10">
			          				<col class="colAuto">
                      </colgroup>
                      <thead>
                        <tr>
                          <th>선택</th>
                          <th>인터페이스명</th>
                          <th>IP</th>
                          <th>자동할당여부</th>
                          <th>NAT여부</th>
                          <th>수동할당</th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:choose>
												<c:when test="${rsrcReqVmCreInfo.rsrcReqNetwkIntfc eq null or empty rsrcReqVmCreInfo.rsrcReqNetwkIntfc }">
													<tr>
														<td colspan="7">검색된 데이터가 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>
													<c:forEach var="netwkIntfcVo" items="${rsrcReqVmCreInfo.rsrcReqNetwkIntfc }" varStatus="i">
		                        <tr>
		                          <td><c:out value="${i.count}" /></td>
		                          <td><c:out value="${netwkIntfcVo.netwkIntfcId}" />
		                          	<form:hidden path="rsrcReqNetwkIntfc[${i.index}].nicPrposCd" id="nicPrposCd${i.index}" />
		                          	<form:hidden path="rsrcReqNetwkIntfc[${i.index}].netwkIntfcId"/>
		                          	<form:hidden path="rsrcReqNetwkIntfc[${i.index}].ipBndSeq" id="ipBndSeq${i.index}"/></td>
		                           <td>
		                           <div class="input-group-btn">
		                          	<form:input path="rsrcReqNetwkIntfc[${i.index}].ipAddr" id="ip${i.index}" cssClass="form-control" readonly="true" title="IP선택" />
						                   </div>
		                          </td>
		                          <td>
		                          	<form:select path="rsrcReqNetwkIntfc[${i.index}].ipAutoAsgnYn" id="ipAutoAsgnYn${i.index}" cssClass="form-control" title="자동할당여부" onchange="javascript:fn_ipAutoAsgnYn(${i.index})">
									              	<form:option value="Y">Y</form:option>
									              	<form:option value="N">N</form:option>
																</form:select>
		                          </td>
		                          <td>
		                          	<form:select path="rsrcReqNetwkIntfc[${i.index}].natYn" id="natYn${i.index}" cssClass="form-control" title="NAT할당여부" >
									              	<form:option value="N">N</form:option>
									              	<form:option value="Y">Y</form:option>
																</form:select>
		                          </td>
		                          <td>
						                  	<button class="btn" id="btn_ip${i.count}"  onclick="javascript:fn_ipOpen(${i.index});return false;">조회하기</button>
						                  </td>
						          <td>
						          	<c:if test="${rsrcReqVmCreInfo.rsrcReqDtlPrcssStatCd eq '01' }">
						          		<button type="button" class="btn btn-sm btn-function" name="btnRsrcReqNetwkIntfc" onclick="javascript:fn_deleteRsrcReqNetwkIntfc(this, '${netwkIntfcVo.nicPrposCd}'  , '${i.index}')" title="네트워크인터페이스삭제">삭제</button>
						          		<input type="hidden" id="ipDelYn${i.index}" />
						          	</c:if>

						          	<c:if test="${rsrcReqVmCreInfo.rsrcReqDtlPrcssStatCd ne '01' && netwkIntfcVo.ipAddr eq ''  }">
						          		<input type="hidden" id="ipDelYn${i.index}" value="Y"/>
						          		삭제
						          	</c:if>
						          </td>
		                        </tr>
					                </c:forEach>
												</c:otherwise>
											</c:choose>
                      </tbody>
                    </table>
                  </td>
              </tr>


              <tr>
                <th>물리서버 선택</th>
                  <td>
                    <div class="input-group">
                      <form:input path="pmNm" class="form-control" disabled="true" title="물리서버 선택"/>
                      <div class="input-group-btn pad-left-5"><button id="pmBtn" class="btn btn-default" onclick="javascript:fn_pSrvrOpen();return false;" data-toggle="tooltip" data-original-title="물리서버선택"><i class="fa fa-search"></i></button></div>
                      <div class="input-group-btn"><button id="initPmBtn" class="btn btn-default" onclick="fn_clear('PM');return false;" data-toggle="tooltip" data-original-title="초기화"><i class="fa fa-eraser"></i></button></div>
                    </div>
                  </td>
              </tr>
              <tr>
                <th>스토리지 선택</th>
                  <td>
                    <div class="input-group">
                    	<form:input path="reqStrgDmnNm" class="form-control" disabled="true" title="스토리지 선택"/>
                      	<div class="input-group-btn pad-left-5"><button id="asgnVrDskBtn" class="btn btn-default" onclick="javascript:fn_asgnVrDskNmOpen();return false;" data-toggle="tooltip" data-original-title="스토리지선택"><i class="fa fa-search"></i></button></div>
                      	<div class="input-group-btn"><button id="initStrgBtn" class="btn btn-default" onclick="fn_clear('STRG');return false;" data-toggle="tooltip" data-original-title="초기화"><i class="fa fa-eraser"></i></button></div>
                    </div>
                  </td>
              </tr>

              <c:if test="${rsrcReqVmCreInfo.rsrcReqDtlPrcssStatCd eq '01'}">
              <tr>
                <th>가상서버ID</th>
                  <td>
                    <div class="input-group-box full">
                    	<form:input path="vmId" class="form-control" readonly="true" title="가상서버ID" maxlength="100"/>
                    	<div class="input-group-cell pad-right-5 fix-cell">
				              	<div class="input-group input-group-check pad-left-5">
                    			<input type="checkbox" id="vmIdCheck" name="vmIdCheck" onclick="javascript:fn_vmIdCheck();"/><label for="vmIdCheck">직접입력</label>
                    		</div>
                    	</div>
                    </div>
                  </td>
              </tr>
              </c:if>
              <tr id="specMaxMinDiv" style="display:none;">
                <th>스펙 허용범위 선택</th>
                  <td>
                    <table id="specMaxMinTable" class="table table-bordered table-vertical">
                    	<caption>스펙 허용범위 선택</caption>
                      <colgroup>
			          				<col class="col10">
			          				<col class="col30">
			          				<col class="col30">
			          				<col class="col30">
                      </colgroup>
                      <thead>
                        <tr>
                          <th>구분</th>
                          <th>최소값</th>
                          <th>기본값</th>
                          <th>최대값</th>
                        </tr>
                      </thead>
                      <tbody>
										  	<tr>
										    	<th>
													<label for="cpuVcoreQty"><span class="text-red">*</span>CPU vCore</label>
												</th>
												<td>
													<form:input path="reqMinCpuVcoreQty" type="number" class="form-control onlyInteger" value="" step="1" min="1" max="128" onblur="fn_checkData();" maxlength="3" title="vCore 최소값"/>
												</td>
												<td>
													<input name= "reqDfltCpuVcoreQty" type="number" class="form-control onlyInteger" title="vCore 기본값" value="${rsrcReqVmCreInfo.reqCpuVcoreQty }" readonly />
												</td>
												<td>
													<form:input path="reqMaxCpuVcoreQty" type="number" class="form-control onlyInteger" value="" step="1" min="1" max="128" onblur="fn_checkData();" maxlength="3" title="vCore 최대값"/>
												</td>
											</tr>
											<tr>
											  <th>
													<label for="memAsgnCapa"><span class="text-red">*</span>메모리(GB)</label>
												</th>
												<td>
													<form:input path="reqMinMemAsgnCapa" type="number" class="form-control onlyInteger" value="" step="1" min="1" max="128" onblur="fn_checkData();" maxlength="3" title="메모리(GB) 최소값"/>
												</td>
												<td>
													<input name= "reqDfltMemAsgnCapa"  type="number" class="form-control onlyInteger" title="메모리(GB) 기본값" value="${rsrcReqVmCreInfo.reqMemAsgnCapa }" readonly />
												</td>
												<td>
													<form:input path="reqMaxMemAsgnCapa" type="number" class="form-control onlyInteger" value="" step="1" min="1" max="128" onblur="fn_checkData();" maxlength="3" title="메모리(GB) 최대값"/>
												</td>
											</tr>
											<tr>
											  <th>
													<label for="entDfltVl"><span class="text-red">*</span>Entitlement</label>
												</th>
												<td>
													<form:input path="reqEntMinVl" type="number" class="form-control onlyFloat" value="" step="0.01" min="0.01" max="1.00" onblur="fn_checkData();" maxlength="3" title="Entitlement 최소값"/>
												</td>
												<td>
													<form:input path="reqEntDfltVl" type="number" class="form-control onlyFloat" value="" step="0.01" min="0.01" max="1.00" onblur="fn_checkData();" maxlength="3" title="Entitlement 기본값"/>
												</td>
												<td>
													<form:input path="reqEntMaxVl" type="number" class="form-control onlyFloat" value="" step="0.01" min="0.01" max="1.00" onblur="fn_checkData();" maxlength="3" title="Entitlement 최대값"/>
												</td>
											</tr>

                      </tbody>
                    </table>
                  </td>
              </tr>
          </tbody>
        </table>
       </div>
       <div class="box-footer clearfix">
         <div class="pull-right">
             <button id="procssStatBtn" class="btn btn-sm" onclick="javascript:fn_procssStatOpen('${rsrcReqVmCreInfo.rsrcReqNo}', '${rsrcReqVmCreInfo.rsrcReqSeq}'); return false;"><i class="fa fa-file-o"></i>진행상태조회</button>
             <button id="nTopsReSendBtn" class="btn btn-sm" onclick="javascript:fn_resendNtops(); return false;"><i class="fa fa-file-o"></i>nTOPS 결과 재전송</button>
         </div>
       </div><!-- /box-footer -->
     </div><!-- /box -->
		</form:form>
  </div><!-- /col -->

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
					<c:if test="${curParam.key ne 'schRsrcReqNo'}">
						<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
					</c:if>
				</c:forEach>
			</c:url>

	    <div class="pull-left btns">
	      <button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
	    </div>

	    <div id="btnArea" class="pull-right btns">
	    	<menu:authorize authType="act" onlyOprAdm="true">
	    	  <button id = "saveRsrcReqBtn" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="설정" onclick="javascript:fn_execRsrcReq('S')"><i class="fa fa-check"></i></button>
		      <button id = "saveCancelRsrcReqBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="" data-original-title="설정취소" onclick="javascript:fn_saveCancelRsrcReq();"><i class="fa fa-undo"></i></button>
		      <button id = "manualRsrcReqBtn" class="btn btn-sm btn-hover-green" onclick="javascript:fn_execRsrcReq('M')"  data-toggle="tooltip" title="" data-original-title="수동완료"><i class="fa fa-arrow-circle-o-right"></i></button>
		      <button id = "execRsrcReqBtn" class="btn btn-sm btn-hover-green" onclick="javascript:fn_execRsrcReq('E')"  data-toggle="tooltip" title="" data-original-title="실행"><i class="fa fa-play-circle"></i></button>
		      <button id = "rjctRsrcReqBtn" class="btn btn-sm btn-hover-red" onclick="javascript:fn_rjctRsrcReq()" data-toggle="tooltip" title="" data-original-title="반려"><i class="fa fa-times"></i></button>
	    	</menu:authorize>

	    	<menu:modAuthorize regId="${rsrcReqVmCreInfo.regUserId }">
	    		<button id = "deleteRsrcReqBtn" class="btn btn-sm btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="javascript:fn_deleteRsrcReq()"><i class="fa fa-minus"></i></button>
	    	</menu:modAuthorize>
	    </div>

    </div><!-- /page-btn-group -->
  </div><!-- /col -->

<script type="text/javascript">

$(function() {
	fn_formInit();
});

//폼화면 셋팅
function fn_formInit() {

	var rsrcStatCd = $("#rsrcReqPrcssStatCd").val(); //자원요청상태코드
	var exeStatCd = $("#exeStatCd").val(); //설정상태코드
	var haYn = $("#haYn").val(); //HA여부
	var testYn = "${rsrcReqVmCreInfo.testYn }"; //테스트여부

	$("#saveRsrcReqBtn").hide(); //설정 버튼을 감춘다.
	$("#saveCancelRsrcReqBtn").hide(); //설정취소 버튼을 감춘다.

	if(testYn != 'Y') {
		$("#deleteRsrcReqBtn").hide();  //삭제버튼을 감춘다.
	}

	//IBM PVM 인경우
	if($('#vrCnvrSwTyCd').val() == '04') {
		document.getElementById('specMaxMinDiv').style.display = ""; //스펙 허용범위 선택영역을 보여준다.
	}

	//HA요청건이 아니고 자원요청상태가 요청 상태가 아닐경우) || HA요청건이고 설정이 모두 완료되었을 경우
	if((haYn != 'Y' && rsrcStatCd != '01') || (haYn == 'Y' && exeStatCd == '02')) {

		$('select').each(function(){
				try{
					$(this).parent().children().attr('disabled','disabled');
					$(this).parent().next().children().attr('disabled','disabled');
				}catch(e){}
		});


		//스펙해용범위 영역 disabled 처리
		$('#specMaxMinTable tbody tr input').each(function() {
		//$("input").each(function(){
			try{
				$(this).attr('disabled','disabled');
			}catch(e){}
		});


		$("#rsrcPoolNm").val("${rsrcReqVmCreInfo.regionNm }"+"/"+"${rsrcReqVmCreInfo.zoneNm }"+"/"+"${rsrcReqVmCreInfo.netNm }"+"/"+"${rsrcReqVmCreInfo.rsrcPoolNm }");

		$("#manualRsrcReqBtn").hide(); //수동실행버튼을 숨긴다.
		$("#execRsrcReqBtn").hide(); //실행버튼을 숨긴다.
		$("#rjctRsrcReqBtn").hide(); //반려버튼을 숨긴다.
		$("#tmplatBtn").hide(); //템플릿선택 버튼을 숨긴다.
		$("#pmBtn").hide(); //물리서버선택 버튼을 숨긴다.
		$("#asgnVrDskBtn").hide(); //스토리지선택 버튼을 숨긴다.
		$("#initPmBtn").hide(); //물리서버선택 초기화 버튼을 숨긴다.
		$("#initStrgBtn").hide(); //스토리지선택 초기화 버튼을 숨긴다.
		$("#nTopsReSendBtn").hide(); //nTOPS 재전송  버튼을 활성화한다.

		$("#procssStatBtn").show(); //진행상태 버튼을 활성화한다

		if(rsrcStatCd == '01' || rsrcStatCd == '04' || rsrcStatCd == '07' ){  //요청상태 , 반려상태 , 수동완료상태인 경우
			$("#procssStatBtn").hide(); //진행상태 버튼을 숨긴다.
		}

		if(rsrcStatCd == '03' ||  rsrcStatCd == '07' ){  // 수동완료상태인 경우
			$("#nTopsReSendBtn").show(); //nTOPS 재전송  버튼을 활성화한다.
		}

	}else {
		if($("#clstrSeq").val() == '') {  //저장된 클러스터 정보가 없을경우 해당 템플릿에대한 클러스터 정보를 셋팅한다.
			fn_getClstrInfo();
		}

		$("#procssStatBtn").hide(); //진행상태 버튼을 숨긴다.
		$("#nTopsReSendBtn").hide(); //nTOPS 재전송  버튼을 숨긴다.
	}

	//HA인 경우
	if(haYn == 'Y') {
		var execRsrcReqBtnViewFlag = ""; //설정완료여부
		var execYn = ""; //실행여부

		$("#procssStatBtn").hide(); //HA요청건인 경우는 프로세스 진행 버튼은 상단에서 따로 보여줌(HA목록에서 보여줌)

		document.getElementById('haDiv').style.display = ""; //상단의 HA영역을 보여준다.

		//HA목록에서 해당 자원요청번호에 대한 라디오 버튼 체크한다.
		$("input:radio[name='haRdo']").each(function(index) {
			if( $(this).val() == $("#schRsrcReqNo").val()) {
				$(this).prop("checked", true);
			}
		});


		//HA목록 정보를 통해 설정완료여부 및 실행여부를 확인한다.
		<c:forEach var="rsrcReqHaVm" items="${rsrcReqHaVmList}">
			<c:if test="${rsrcReqHaVm.exeStatCd ne '02'}">
			execRsrcReqBtnViewFlag = "N"; //설정완료여부
			</c:if>

			<c:if test="${rsrcReqHaVm.procssStatCd eq '01' || rsrcReqHaVm.procssStatCd eq '02' || rsrcReqHaVm.procssStatCd eq '04'}">
			execYn = "Y"; //실행여부
			</c:if>
		</c:forEach>


		//버튼제어
		if(exeStatCd == '02') {  //설정상태가 설정완료인 경우
			$("#saveRsrcReqBtn").hide(); //설정 버튼을 감춘다.
			$("#saveCancelRsrcReqBtn").hide(); //설정취소 버튼을 감춘다.
			if(execYn != "Y" && execRsrcReqBtnViewFlag != 'N') {  //실행상태는 아니고, 모두 설정완료했을 경우
				$("#saveRsrcReqBtn").hide(); //설정 버튼을 감춘다.
				$("#saveCancelRsrcReqBtn").show(); //설정취소 버튼을 보여준다.
				$("#manualRsrcReqBtn").show(); //수동실행버튼을 보여준다.
				$("#execRsrcReqBtn").show();  //실행 버튼을 보여준다.
			}
		}else {
			$("#saveRsrcReqBtn").show();
			$("#manualRsrcReqBtn").hide(); //수동실행버튼을 숨긴다.
			$("#execRsrcReqBtn").hide();
			$("#saveCancelRsrcReqBtn").hide();
		}
	}
}

//조건에 맞는 클러스터 선택 콤보박스를 셋팅한다.
function fn_getClstrInfo() {
	var rsrcPoolId = $("#rsrcPoolId").val(); //자원풀ID
	var prposClCd = $("#prposClCd").val(); //용도

	$.ajax({
		type : "POST"
		,url : "<c:url value='/cpt/opr/req/rsrcreq/selectClstrList.do'/>"
		,data : "rsrcPoolId="+rsrcPoolId
		,beforeSend: function() {}
		,error: function(xhr, textStatus, errorThrown){
			alert('오류 발생!');
		}
		,success :
			function(data) {
					//alert(JSON.stringify(data));
					var dataObj = data.data;
					var selectTag = "";
					if(dataObj!="") {
						var selectTag = "";
						$.each(dataObj,function(i){
							if(dataObj[i].prposClCd == prposClCd ) { //동일한 용도의 클러스터 정보만 셋팅
								selectTag+='<option value="'+dataObj[i].clstrSeq+'">'+dataObj[i].clstrNm+'</option>';
							}

						});

						$("#clstrSeq").html(selectTag);

					}
			}
	});
}

//템플릿선택 버튼 클릭 시
function fn_tmplatOpen(){
	var regionId = $("#regionId").val();  //센터
	var netClCd = $("#netClCd").val();  //망
	var prposClCd  = $("#prposClCd").val();  //용도코드
	var osTyCd  = $("#osTyCd").val();  //OS 타입 코드
	var params = { prposCd: prposClCd   ,  regionId: regionId , netClCd : netClCd, osTyCd : osTyCd};
	var args = {key:"selectRsrcReqTmplatP", width:1280 , height: 720};
	windowOpen('selectRsrcReqTmplatP.do', params, args);

	return false;
}


//물리서버선택 버튼 클릭 시
function fn_pSrvrOpen(){

	if(!fn_validateCheck()){
		jAlert("템플릿을 선택 후 진행해 주세요.");
		return;
	}

	//HP Integrity VM 인경우 스토리지 변경 API를 지원하지 않기때문에 리턴처리.
	if($('#vrCnvrSwTyCd').val() == '03') {
		jAlert("선택하신 템플릿(HP Integrity VM)은 물리서버를 변경할 수 없습니다.");
		return;
	}

	var regionId = $('#regionId').val();
	var zoneId =  $('#zoneId').val();
	var netId =  $('#netId').val();
	var vrCnvrSwTyCd = $('#vrCnvrSwTyCd').val();
	var rsrcPoolId = $('#rsrcPoolId').val();
	var clstrSeq = $('#clstrSeq').val();
	var clstrNm = $('#clstrSeq').text();

	var params = { searchRegionId: regionId, searchZoneId : zoneId , searchNetId : netId
					, searchVrCnvrSwTyCd : vrCnvrSwTyCd , searchRsrcPoolId: rsrcPoolId
					, searchClstrSeq : clstrSeq, searchClstrNm : clstrNm };
	var args = {key:"selectRsrcReqPhySrvrP", width:1280 , height:720};
	windowOpen('selectRsrcReqPhySrvrP.do', params, args);
}


//스토리지선택 버튼 클릭 시
function fn_asgnVrDskNmOpen(){

	if(!fn_validateCheck()){
		jAlert("템플릿을 선택 후 진행해 주세요.");
		return;
	}


	//HP Integrity VM, IBM Power VM 인경우 스토리지 변경 API를 지원하지 않기때문에 리턴처리.
	if($('#vrCnvrSwTyCd').val() == '03' || $('#vrCnvrSwTyCd').val() == '04') {
		jAlert("선택하신 템플릿은 스토리지를 변경할 수 없습니다.");
		return;
	}

	var regionId = $('#regionId').val();
	var zoneId =$('#zoneId').val();
	var netId = $('#netId').val();
	var poolId = $('#rsrcPoolId').val();

	var params = { searchRegionId: regionId, searchZoneId : zoneId , searchNetId : netId , searchRsrcPoolId : poolId };
	var args = {key:"selectRsrcReqStrgP", width:1280 , height:720};
	windowOpen('selectRsrcReqStrgP.do', params, args);
}

/**
 * 하위 선택 검사
 */
function fn_validateCheck(){

	if( $('#tmplatSeq').val() == null ||  $('#tmplatSeq').val() == ''
		|| $('#regionId').val() == null ||  $('#regionId').val() == ''
		|| $('#zoneId').val() == null ||  $('#zoneId').val() == ''
		|| $('#netId').val() == null ||  $('#netId').val() == ''
		|| $('#rsrcPoolId').val() == null ||  $('#rsrcPoolId').val() == ''
		|| $('#vrCnvrSwTyCd').val() == null ||  $('#vrCnvrSwTyCd').val() == '' ){
		return false;
	}
	return true;
}

//IP선택 버튼 클릭 시
function fn_ipOpen(id) {
	if(!fn_validateCheck()){
		jAlert("템플릿을 선택 후 진행해 주세요.");
		return;
	}

	if( $("#ipAutoAsgnYn"+id).val() != 'N'){
		jAlert("자동할당여부가 N 이여야 선택할 수 있습니다.");
		return ;
	}

	var netClCd = $("#netClCd").val(); //망구분 코드
	var zoneId = $("#zoneId").val(); //존ID
	var institutionId =$("#useGvDprtId").val();  //기관ID
	var prposClCd  = $("#prposClCd").val();  //용도코드
	var nicPrposCd = $('#nicPrposCd'+id).val(); //nic

	var natYn =  $("#natYn"+id).val();

	var params = {institutionId: institutionId
					, prposClCd: prposClCd
					, nicPrposCd:nicPrposCd
					, netClCd : netClCd
					, zoneId : zoneId
					, idIndex: id
					, natYn : natYn
					, searchRegion : $('#regionId').val() };
	var args = {key:"selectRsrcReqIpAddrP", width:800 , height:720};
	windowOpen('selectRsrcReqIpAddrP.do', params, args);
}

function fn_ip_validation()
{
	var idx = 0;
	do{
		if($("#ipAutoAsgnYn"+idx).val() == 'Y' || $("#ipDelYn"+idx).val() == 'Y') {
			$("#ip"+idx).val("");
		}else{
			if($("#ip"+idx).val() == '') {
				jAlert("조회하기 버튼을 클릭하여 선택"+(idx+1) +"의 IP를 수동할당 하시기 바랍니다.");
				return false;
			}
		}
		idx++;
	}
	while($("#ipAutoAsgnYn"+idx).val() != undefined );

	return true;
}


//실행 버튼 클릭 시
function fn_execRsrcReq(btnFlag) {

	var haYn = $('#haYn').val(); //HA요청여부
	var confirmMsg  = "실행 하시겠습니까?";

	if(!fn_form_validation("rsrcReqVmCreFrm")){
		return;
	}

	if(!fn_ip_validation())
	{
		return;
	}

	var tmp = $.trim($("#rsrcReqVmCreFrm input[name='vmId']").val());
	if(tmp != '') $("#rsrcReqVmCreFrm input[name='vmId']").val(tmp);

	if(!fn_makeVmId()) {
		jAlert("가상서버ID를 입력해주세요.");
		return;
	}

	if( $('#vrCnvrSwTyCd').val() == '04' && !fn_chdckEntitle())
	{
		jAlert("스펙허용범위 정보를 입력해주세요.");
		return;
	}

	if(btnFlag == 'S') { //설정완료 버튼 클릭 시
		var vmNm = "${rsrcReqVmCreInfo.vmNm }";
		confirmMsg = "["+vmNm+"] 설정을 완료하시겠습니까?";
	}else { //실행 버튼 클릭 시
		if(haYn == 'Y') {
			$('#exeType').val("E");
		}
		// 수동 실행 버튼 클릭시
		if(btnFlag == 'M') {
			$('#exeType').val(btnFlag);
		}
	}

	jConfirm(confirmMsg, function(){
		$.ncmsLoding.startFullScreen();
		$.post('formRsrcReqVmCreExec.do', $('#rsrcReqVmCreFrm').serialize(), fn_callbackRsrcReqVmCre, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

/**
* nTOPS 결과 재전송
*/
function fn_resendNtops(){
	var rsrcReqNo = $('#rsrcReqVmCreFrm #rsrcReqNo').val();
	var rsrcReqTyCd = $('#rsrcReqVmCreFrm #rsrcReqTyCd').val();

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


// 설정취소 버튼 클릭 시
function fn_saveCancelRsrcReq() {
	jConfirm('설정취소시 입력하신 설정정보는 모두 초기화 됩니다.\n-설정을 취소하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('formRsrcReqVmCancelExec.do', $('#rsrcReqVmCreFrm').serialize(), fn_callbackRsrcReqVmCre, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

//삭제 버튼 클릭 시
function fn_deleteRsrcReq() {
	jConfirm('삭제 하시겠습니까?', function(){
		$.ncmsLoding.startFullScreen();
		$.post('updateRsrcReqDeleteYn.do', $('#rsrcReqVmCreFrm').serialize(), function(result) {

			jInfo(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, 'json').always(function(){$.ncmsLoding.remove();});
	});
}

//실행 후
function fn_callbackRsrcReqVmCre(result){
	if(result.success){
		jInfo(result.messageList, function() {
			fn_reloadPage();
		});
	}else{
		jAlert(result.messageList);
	}
}


//화면 리로딩
function fn_reloadPage(){
	location.reload();
	//$("#rsrcReqVmCreFrm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/selectRsrcReqVmCre.do'/>");
	//$("#rsrcReqVmCreFrm").submit();
}


//가상서버ID를 구성후 셋팅한다.
function fn_makeVmId() {
	//가상서버ID 생성 Rule : 부처ID 앞3자리 + 망ID + 업무ID 앞3자리 + 용도명 앞1자리 + 순번3자리(채번테이블을 통해 별도로 구성)
	if($('#vmIdAutoYn').val() != 'N') {  //직접입력이 아닐경우
		var insttCdStr = $("#useGvDprtId").val().substring(0,3); //부처ID
		var netStr = $("#netClCd").val(); //망구분코드
		var useJobId = $("#useJobId").val().substring(0,3); //업무ID
		var prposNm = "${rsrcReqVmCreInfo.prposNm }".substring(0,1); //용도명
		$("#vmId").val(insttCdStr+"_"+netStr+"_"+useJobId+"_"+prposNm);
	}

	if($("#vmId").val() == "") {
		return false;
	}else {
		return true;
	}
}

function fn_chdckEntitle()
{
	if($("#reqMinCpuVcoreQty").val() == "") {
		return false;
	}
	if($("#reqDfltCpuVcoreQty").val() == "") {
		return false;
	}
	if($("#reqMaxCpuVcoreQty").val() == "") {
		return false;
	}

	if($("#reqMinMemAsgnCapa").val() == "") {
		return false;
	}
	if($("#reqDfltMemAsgnCapa").val() == "") {
		return false;
	}
	if($("#reqMaxMemAsgnCapa").val() == "") {
		return false;
	}

	if($("#reqEntMinVl").val() == "") {
		return false;
	}
	if($("#reqEntDfltVl").val() == "") {
		return false;
	}
	if($("#reqEntMaxVl").val() == "") {
		return false;
	}

	return true;
}


//자동할당여부 변경 시
function fn_ipAutoAsgnYn(idx) {
	if($("#ipAutoAsgnYn"+idx).val() == 'Y') {
		$("#ip"+idx).val("");
	}else {
		if($("#ip"+idx).val() == '') {
			//alert("조회하기 버튼을 클릭하여 IP를 수동할당 하시기 바랍니다.");
			//$("#ipAutoAsgnYn"+idx).val("Y");
			fn_ipOpen(idx);
		}
	}
}

//반려버튼 클릭 시
function fn_rjctRsrcReq() {
	/**
	* TODO : alert("자원요청 가상서버 상태 만 반려 상태로 변경 - 비지니스 로직이 필요할 경우 추가 ");
	*/
	var params = { rsrcReqNo : $('#rsrcReqNo').val() , rsrcReqSeq : $('#rsrcReqSeq').val(), rsrcReqTyCd: $('#rsrcReqTyCd').val() };

	var width = 740;
	var height = 290;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {key:"RsrcReqRjct", width:width , height:height, posX : posX , posY : posY};

	windowOpen('selectRsrcReqRjctP.do', params, args)
}

/**
 * ip선택 callback
 */
function fn_selectedIPAddr(ipAddr, ipBndSeq , id){
	$("#ip"+id).val(ipAddr);
	$("#ipBndSeq"+id).val(ipBndSeq);
}
/**
 *
 *  템플릿 선택(응답)
 */
function fn_selectedTmplat(tmplat){

	$('#tmplatSeq').val(tmplat.tmplatSeq);
	$('#tmplatNm').val(tmplat.tmplatNm);
	$('#regionId').val(tmplat.regionId);
	$('#zoneId').val(tmplat.zoneId);
	$('#netId').val(tmplat.netId);
	$('#rsrcPoolId').val(tmplat.rsrcPoolId);
	$('#rsrcPoolNm').val(tmplat.regionNm +"/"+ tmplat.zoneNm +"/"+ tmplat.netClNm+"/" + tmplat.rsrcPoolNm);
	$('#vrCnvrSwTyCd').val(tmplat.vrlzSwTyCd);
	$('#strgAsgnCapa').val(tmplat.strgAsgnCapa);

	fn_getClstrInfo(); //콤보셋팅

	//IBM PVM 인경우
	if($('#vrCnvrSwTyCd').val() == '04') {
		document.getElementById('specMaxMinDiv').style.display = ""; //스펙 허용범위 선택영역을 보여준다.
	}else {
		document.getElementById('specMaxMinDiv').style.display = "none";
	}

}

/**
 * 물리서버 응답
 */
function fn_selectedPhySrvr(pmSeq, pmNm){
	$('#pmSeq').val(pmSeq);
	$('#pmNm').val(pmNm);
}

/**
 * 스토리지 선택 callback
 */
function fn_selectedStrg(strg){
	$('#reqStrgDmnNm').val(strg.strgDmnNm);
	$('#reqStrgDmnSeq').val(strg.strgDmnSeq);
}

/**
 *  실행내역
 */
function fn_procssStatOpen(rsrcReqNoVal, rsrcReqSeqVal){


	procssInstSeq = $('#rsrcReqVmCreFrm #procssInstSeq').val();

	if(procssInstSeq == null || procssInstSeq =='' || procssInstSeq <=0){
		jAlert("진행상태 정보가 없습니다.");
		return;
	}

	//var params = { rsrcReqNo : $('#rsrcReqNo').val() , rsrcReqSeq : $('#rsrcReqSeq').val()};
	var params = { rsrcReqNo : rsrcReqNoVal , rsrcReqSeq : rsrcReqSeqVal};
	var args = {key:"selectRsrcReqExeListP", width: 1280 , height: 720 };

	windowOpen('selectRsrcReqExeListP.do', params, args);
}

//가상서버ID 입력체크
function fn_vmIdCheck(){

	if(!fn_validateCheck()){
		jAlert("템플릿을 선택 후 진행해 주세요.");
		$('#vmIdCheck').prop("checked", false);
		return;
	}

	if($('#vmIdCheck').prop("checked")==true){

		if($('#vrCnvrSwTyCd').val() == '04') {  //IBM PVM 인경우
			jAlert("선택하신 템플릿은 가상서버 ID를 변경할 수 없습니다.(가상서버ID는 호스트명으로 설정됩니다.)");
			$('#vmIdCheck').prop("checked", false);
			return;
		}

		$("#vmId").val("");
		$("#vmId").attr('readonly',false);
		$("#vmIdAutoYn").val("N");

	}else{
		$("#vmId").val("");
		$("#vmId").attr('readonly',true);
		$("#vmIdAutoYn").val("Y");
	}
}

//물리서버 및 스토리지 선택 초기화
function fn_clear(target){
	if(target == 'PM'){
		$('#pmSeq').val('');
		$('#pmNm').val('');
	}else if(target=='STRG'){
		$('#reqStrgDmnNm').val('');
		$('#reqStrgDmnSeq').val('');
	}
}

//템플릿 선택 변경 이벤트
function fn_clstrSelected(){
	fn_clear('PM');
	fn_clear('STRG');
}


//HA목록 클릭 시
$('#haListTable tr').click(function(e){
	var $target = $(this).find("td input");
	if( $target.attr("type") == "radio" ) {

		$target.prop("checked", true);

		if($("#schRsrcReqNo").val() != $target.val()) {
			$("#schRsrcReqNo").val($target.val());
			$("#rsrcReqVmCreFrm").attr("action", "<c:url value='/cpt/opr/req/rsrcreq/selectRsrcReqVmCre.do'/>");
			$("#rsrcReqVmCreFrm").submit();
		}

	} else {
		var checked = $target.prop("checked");
		$target.prop("checked", !checked);
	}
});


//스펙 허용범위 체크
function fn_checkData(){

	var rtnFlag = true;

	if(parseInt($('#reqMinCpuVcoreQty').val()) > parseInt($('#reqMaxCpuVcoreQty').val()) ||
		 parseInt($('#reqMinMemAsgnCapa').val()) > parseInt($('#reqMaxMemAsgnCapa').val()) ||
		 parseFloat($('#reqEntMaxVl').val()) < parseFloat($('#reqEntMinVl').val())) {

		jAlert("스펙 허용범위의 최소값은 최대값보다 클 수 없습니다.");
		rtnFlag = false;
	}

	if((parseInt($('#reqMinCpuVcoreQty').val()) > 128 || parseInt($('#reqMaxCpuVcoreQty').val()) <= 0) ||
		 (parseInt($('#reqMinMemAsgnCapa').val()) > 128 || parseInt($('#reqMaxMemAsgnCapa').val()) <= 0)) {
		jAlert("CPU vCore, 메모리의 스펙 허용범위는 1 ~ 128 사이의 값으로 설정해주세요.");
		rtnFlag = false;
	}

	if((parseFloat($('#reqEntMaxVl').val()) > 1.00 || parseFloat($('#reqEntMaxVl').val()) <= 0) ||
		 (parseFloat($('#reqEntMinVl').val()) > 1.00 || parseFloat($('#reqEntMinVl').val()) <= 0) ||
		 (parseFloat($('#reqEntDfltVl').val()) > 1.00 || parseFloat($('#reqEntDfltVl').val()) <= 0)){
		jAlert("Entitlement 값은 0.01 ~ 1.00 사이의 값으로 설정해주세요.");
		rtnFlag = false;
	}

	if(parseFloat($('#reqEntMaxVl').val()) < parseFloat($('#reqEntDfltVl').val())){
		jAlert("Entitlement 기본값은 최대값보다 클 수 없습니다.");
		rtnFlag = false;
	}

	return rtnFlag;
}


//네트워크 인터페이스 삭제
function fn_deleteRsrcReqNetwkIntfc(obj, nicPrposCd, idx) {
	if(nicPrposCd == "01") {
		jAlert("Service 인터페이스는 삭제하실 수 없습니다.");
		return;
	}else {
		jConfirm("선택하신 네트워크 인터페이스를 삭제하시겠습니까?", function(){

			$("#ipDelYn"+idx).val("Y");
			var tr = $(obj).parent().parent();
			tr.remove();
		});
	}
}


</script>
