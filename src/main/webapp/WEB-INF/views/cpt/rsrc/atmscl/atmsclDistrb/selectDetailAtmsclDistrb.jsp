<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>배포 상세 화면</pre>
 *
 * @author 안수근
 * @lastmodifier 안수근
 * @created 2017. 7. 17.
 * @lastmodified 2017. 7. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 7. 17.     안수근         v1.0             최초생성
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



<div class="col-box-100">
	<div class="col-info server <c:choose>
									<c:when test='${"01" eq distrbHstry[0].statCd}'><c:out value="server-inprogress"/></c:when>
									<c:when test='${"02" eq distrbHstry[0].statCd}'><c:out value="server-up"/></c:when>
									<c:when test='${"03" eq distrbHstry[0].statCd}'><c:out value="server-exception"/></c:when>
									<c:when test='${"04" eq distrbHstry[0].statCd}'><c:out value="server-maintain"/></c:when>
									<c:when test='${"05" eq distrbHstry[0].statCd}'><c:out value="server-maintain"/></c:when>
									<c:when test='${"06" eq distrbHstry[0].statCd}'><c:out value="server-maintain"/></c:when>
									<c:when test='${"07" eq distrbHstry[0].statCd}'><c:out value="server-maintain"/></c:when>
									<c:otherwise></c:otherwise></c:choose>">
		<div class="col-info-body alignL">
			<div class="col-info-box alignL">
				<span class="label"></span>
				<h4 class="stat">
				<c:choose>
					<c:when test='${empty distrbHstry[0].statCd}'>${selectCodeList[7].cdNm}</c:when>
					<c:otherwise>${distrbHstry[0].statNm}</c:otherwise>
				</c:choose>


				</h4>

				<button type="button" class="btn btn-sm btn-refresh vm-sync" onclick="javascript:fn_refresh();">새로고침</button>
			</div>
			<div class="col-info-box alignR">
				<div class="col-info-btn">

				<c:if test="${'Y' eq distrbHstry[0].ctlTrgtYn }">
					<c:choose>

						<c:when test="${'02' eq distrbHstry[0].servcAreaClCd}">
						   <c:if test="${'02' eq distrbHstry[0].bldStatCd}">
							   <menu:authorize authType="act">
									<button type="button" class="btn vm-start" title="배포" onclick="fn_Distrb(${distrbHstry[0].statCd});"><i class="fa fa-play-circle"></i><span>배포</span></button>
								</menu:authorize>
						   </c:if>
						  	 <c:if test="${'02' ne distrbHstry[0].bldStatCd}">
								<button type="button" class="btn vm-start" title="배포" onclick="fn_alert('02');"><i class="fa fa-play-circle"></i><span>배포</span></button>
							</c:if>
							<button type="button" class="btn vm-stop" title="스토리지" onclick="openDistrbStrgAdd();" ><i class="fa fa-cog"></i><span>스토리지</span></button>
							<button type="button" class="btn vm-stop" title="오토스케일" onclick="openDistrbAutoSclp();" ><i class="fa fa-cog"></i><span>오토스케일</span></button>
		                    <button type="button" class="btn vm-stop" title="자원제한" onclick="openDistrbRsrcLtp();" ><i class="fa fa-sign-in"></i><span>자원제한</span></button>
		                    <c:if test="${0 eq selectAutoSclingCheck}">
	                    		<button type="button" class="btn vm-shutdown" title="자원확장" onclick="openDistrbReplica();"><i class="fa fa-plus-square-o"></i><span>자원확장</span></button>
	                  		</c:if>
	                  		<c:if test="${selectAutoSclingCheck > 0}">
	                   			<button type="button" class="btn vm-shutdown" title="자원확장" onclick="fn_alert('01');"><i class="fa fa-plus-square-o"></i><span>자원확장</span></button>
	                   		</c:if>
						</c:when>

						<c:otherwise>
						  <button type="button" class="btn vm-start" title="배포" disabled="disabled"><i class="fa fa-play-circle"></i><span>배포</span></button>
		                  <button type="button" class="btn vm-stop" title="스토리지"  disabled="disabled" ><i class="fa fa-cog"></i><span>스토리지</span></button>
		                  <button type="button" class="btn vm-stop" title="오토스케일"  disabled="disabled" ><i class="fa fa-cog"></i><span>오토스케일</span></button>
		                  <button type="button" class="btn vm-stop" title="자원제한"  disabled="disabled" ><i class="fa fa-sign-in"></i><span>자원제한</span></button>
		                  <button type="button" class="btn vm-shutdown" title="자원확장" disabled="disabled"><i class="fa fa-plus-square-o"></i><span>자원확장</span></button>
						</c:otherwise>
					</c:choose>
				</c:if>


             	</div>
            </div>
		</div>
	</div>
</div>

<div class="col-box-100 search-col">
	<form:form commandName="atmsclDistrbVo">
	<form:hidden path="rsrcPoolId" title="자원풀ID"/>
	<form:hidden path="servcAreaSeq" title="서비스영역Seq"/>
	<form:hidden path="servcAreaId" title="서비스영역ID"/>
	<form:hidden path="servcSeq" title="서비스Seq"/>
	<form:hidden path="distrbConfId" title="배포설정ID"/>
	<form:hidden path="regionId" title="센터ID"/>
	<form:hidden path="zoneId" title="존ID"/>
	<form:hidden path="netClCd" title="망구분코드"/>
	<form:hidden path="reqCpuCorQty" title="요청CPU"/>
	<form:hidden path="lmttCpuCorQty" title="제한CPU"/>
	<form:hidden path="reqMemCapa" title="요청MEM" />
	<form:hidden path="lmttMemCapa" title="제한MEM"/>
	<form:hidden path="distrbId" title="배포ID"/>
	<form:hidden path="servcId" title="서비스ID"/>
	<form:hidden path="lastDistrbVer" title="최종 배포 버전"/>
	<form:hidden path="updtUserId" title="수정자ID"/>
	<form:hidden path="reqCpuCorQty" title="요청CPU"/>
	<form:hidden path="lmttCpuCorQty" title="제한CPU"/>
	<form:hidden path="reqMemCapa" title="요청MEM"/>
	<form:hidden path="lmttMemCapa" title="제한MEM"/>
	<form:hidden path="reStrtPolicyClCd" title="재기동정책구분코드"/>
	<form:hidden path="dnsPolicyClCd" title="DNS정책구분코드"/>
	<form:hidden path="rplcaQty" title="복제수"/>
	<form:hidden path="tmplatNm" title="템플릿명"/>
	<form:hidden path="pvcId" title="pvcId"/>
	<form:hidden path="pvId" title="pvId"/>
	<form:hidden path="volumeNm" title="볼륨명"/>


	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  		<caption>배포 상세정보 테이블</caption>
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
						<th>센터</th>
						<td><c:out value="${distrbHstry[0].regionNm }" /></td>
						<th>존</th>
						<td><c:out value="${distrbHstry[0].zoneNm }" /></td>
						<th>망구분</th>
						<td><c:out value="${distrbHstry[0].netNm }" /></td>
						<th>자원풀</th>
						<td><c:out value="${distrbHstry[0].rsrcPoolNm }" /></td>

					</tr>
					<tr>
						<th>부처</th>
						<td><c:out value="${distrbHstry[0].institutionNm }" /></td>
						<th>업무</th>
						<td><c:out value="${distrbHstry[0].jobNm }" /></td>
						<th>서비스영역명</th>
						<td><c:out value="${distrbHstry[0].servcAreaNm }" /></td>
						<th>서비스명</th>
						<td><c:out value="${distrbHstry[0].servcNm }" /></td>
					</tr>
					<tr>
						<th>배포이미지명</th>
						<td><c:out value="${distrbHstry[0].imgNm }" /></td>
						<th>배포버전</th>
						<td><c:out value="${distrbHstry[0].lastDistrbVer }" /></td>
						<th>배포상태</th>
						<td>
						<c:choose>
									<c:when test="${distrbHstry[0].statCd eq '01'}">
										<span title="${distrbHstry[0].statNm }" class="status status-blue"><c:out value="${distrbHstry[0].statNm}"/></span>
									</c:when>
									<c:when test="${distrbHstry[0].statCd eq '02'}">
										<span title="${distrbHstry[0].statNm }" class="status status-green"><c:out value="${distrbHstry[0].statNm}"/></span>
									</c:when>
									<c:when test="${distrbHstry[0].statCd eq '03'}">
										<span title="${distrbHstry[0].statNm }" class="status status-red"><c:out value="${distrbHstry[0].statNm}"/></span>
									</c:when>
									<c:when test="${distrbHstry[0].statCd eq '04'}">
										<span title="${distrbHstry[0].statNm }" class="status status-aqua"><c:out value="${distrbHstry[0].statNm}"/></span>
									</c:when>
									<c:when test="${empty distrbHstry[0].statCd}">
										<span title="${selectCodeList[7].cdNm}" class="status status-aqua"><c:out value="${selectCodeList[7].cdNm}"/></span>
									</c:when>
									<c:otherwise><span title="${distrbHstry[0].statNm }" class="status status-aqua"><c:out value="${distrbHstry[0].statNm}"/></span></c:otherwise>
							</c:choose>
						</td>
						<th>Pod 수 </th>
						<td><c:out value="${nowPod}" /></td>
					</tr>
					<tr>
						<th>생성자</th>
						<td><c:out value="${distrbHstry[0].creUserNm }" /></td>
						<th>생성일자</th>
						<td><c:out value="${distrbHstry[0].creDttm }" /></td>
						<th>수정자</th>
						<td><c:out value="${distrbHstry[0].updtUserNm }" /></td>
						<th>수정일자 </th>
						<td><c:out value="${distrbHstry[0].updtDttm}" /></td>
					</tr>
					<tr>
						<th><label for="textareaRmk">비고</label></th>
			            <td colspan="7">
			            	<form:hidden path="rmk" title="비고" value="${distrbHstry[0].rmk }"/>
			             	<textarea id="textareaRmk" title="비고" Class="form-control" rows="3" maxlength="1000" ><c:out value="${distrbHstry[0].rmk }"/></textarea>
			            </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">Pod 자원 제한(Resource Limit) 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  		<caption>자원제한 정보 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
				</colgroup>
				<tbody>

					<tr>
						<th>요청CPU</th>
						<c:choose>
							<c:when test="${distrbHstry[0].reqCpuCorQty eq 0}">
									<td>Core</td>
							</c:when>
							<c:otherwise>
								<td><c:out value="${distrbHstry[0].reqCpuCorQty }" /> Core</td>
								<fmt:parseNumber var="lmttCpu" integerOnly="true" type="number" value="${distrbHstry[0].lmttCpuCorQty }"/>
							</c:otherwise>
						</c:choose>

						<th>제한CPU</th>
						<c:choose>
							<c:when test="${lmttCpu eq 0}">
									<td>Core</td>
							</c:when>
							<c:otherwise>
								<td><c:out value="${lmttCpu}" /> Core </td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th>요청 메모리</th>
						<c:choose>
							<c:when test="${distrbHstry[0].reqMemCapa eq 0 }">
									<td>GB</td>
							</c:when>
							<c:otherwise>
								<td><c:out value="${distrbHstry[0].reqMemCapa }" /> GB</td>
							</c:otherwise>
						</c:choose>

						<th>제한 메모리</th>
								<c:choose>
							<c:when test="${distrbHstry[0].lmttMemCapa  eq 0}">
									<td>GB</td>
							</c:when>
							<c:otherwise>
								<fmt:parseNumber var="lmttMem" integerOnly="true" type="number" value="${distrbHstry[0].lmttMemCapa }"/>
								<td><c:out value="${lmttMem}" /> GB </td>
							</c:otherwise>
						</c:choose>

					</tr>
				</tbody>
			</table>
		</div>
	</div>


	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">오토스케일(Autoscale) 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  		<caption>오토스케일 정보 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
				</colgroup>
				<tbody>
					<tr>
						<th>최소 Pod수</th>
						<td><c:out value="${autoSclInfo[0].minPodQty }" /></td>
						<th>최대 Pod수</th>
						<td><c:out value="${autoSclInfo[0].maxPodQty }" /></td>
					</tr>
					<tr>
						<th>CPU 사용량</th>
						<td>
							<input type="hidden" id="thresClCdCpu" title="CPU임계치" value="${thresClCdCpu}"/>
							<c:out value="${thresClCdCpu}" /> %
						</td>
						<th>메모리 사용량</th>
						<td>
						<input type="hidden" id="thresClCdMem" title="MEM임계치" value="${thresClCdMem}"/>
								<c:out value="${thresClCdMem}" /> %
						</td>
					</tr>
					<tr>
						<th>네트워크 (IN)</th>
						<td colspan="3">
								<c:out value="${thresClCdNet}" /> KB/Sec
						</td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>
	<!-- 수평형 테이블 -->
	<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title">스토리지 할당 정보</h3>
				<div class="box-tools">
					<div class="pull-right">
					</div>
				</div>
			</div>
			<!-- box-body -->
			<div class="box-body no-padding detail-list-body" >
				<table class="table table-vertical table-layout-fixed" id="pvcInfoTable">
				<caption>스토리지 테이블</caption>
					<thead>
						<tr>
							<th>No.</th>
							<th>볼륨명</th>
							<th>마운트 경로</th>
							<th>용량(GB)</th>
							<th>할당일시</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pvcInfoList" items="${selectDistrbPvc}" varStatus="i">
							<tr>
								<td><c:out value="${i.count }" /></td>
								<td class="alignL"><c:out value="${pvcInfoList.volumNm}" /></td>
								<td class="alignL"><c:out value="${pvcInfoList.mountPath}" /></td>
								<td class="alignR"><c:out value="${pvcInfoList.strgAsgnCapa}" /> </td>
								<td class="alignC"><c:out value="${pvcInfoList.creDttm}" /></td>
								<td>
									<button type="button" class="btn btn-sm btn-function" title="PVC삭제" name="btnDelPvc" onclick="fn_delPvc('${pvcInfoList.distrbConfId}','${pvcInfoList.servcAreaSeq}','${pvcInfoList.servcSeq}','${pvcInfoList.pvcId}','${pvcInfoList.pvId }','${pvcInfoList.volumNm}');" >삭제</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


	<br>
	<!-- 환경변수 시작  -->
	<div class="box detail-list-box">

		<div class="info">
				<h2>환경변수 입력 유의사항</h2>
				<p>- 첫글자는 영문 대문자 또는 소문자만 입력 가능합니다. (한글 불가)</p>
				<p>- 특수문자는 '_' 만 사용가능합니다.</p>
		</div>

        <div class="box-header">
            <h3 class="box-title">환경변수 정보</h3>
            <div class="box-tools">
				<div class="pull-right">
						<button type="button" class="btn btn-sm btn-function" onclick="fn_insertEnv()" title="환경변수 추가">추가</button>
				</div>
			</div>
        </div>

		<div class="box-body no-padding">
		    <table class="table table-vertical table-layout-fixed" id="envTable">
				<caption>환경변수 추가</caption>
				<colgroup>
					<col class="col40">
					<col class="col50">
					<col class="col10">
				</colgroup>
				<thead>
					<tr>
						<th>변수명</th>
						<th>변수값</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="sEnvListTBody">
				<c:forEach var="disConf" items="${distrbEnvList}">
					<tr>
						<td>
							<input type="text" name="distrbEnvConfList[].envVarNm" title="환경변수명" class="form-control" value="${disConf.envVarNm}" maxlength="100" />
						</td>
						<td>
							<input type="text" name="distrbEnvConfList[].envVarVl" title="환경변수값" class="form-control" value="${disConf.envVarVl}" maxlength="100"/>
						</td>
						<td>
								<button type="button" class="btn btn-sm btn-function" name="btnInsertEnv" onclick="fn_deleteEnv(this)" title="환경변수삭제">삭제</button>
						</td>
				   </tr>
				</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	<!-- 환경변수 끝  -->
	<!-- 수평형 테이블 -->
	<div class="box detail-list-box">
			<div class="box-header">
				<h3 class="box-title">Pods 정보</h3>
				<div class="box-tools">
					<div class="pull-right">
					</div>
				</div>
			</div>
			<!-- box-body -->
			<div class="box-body no-padding detail-list-body" >
				<table class="table table-vertical table-layout-fixed" id="podInfoTable">
				<caption>Pods 정보 테이블</caption>
					<thead>
						<tr>
							<th>No.</th>
							<th>상태</th>
							<th>POD명</th>
							<th>CPU(Core)</th>
							<th>CPU사용률(%)</th>
							<th>메모리(GB)	</th>
							<th>메모리사용률(%)</th>
							<th>네트워크 In(KB/Sec)</th>
							<th>네트워크 Out(KB/Sec)</th>
							<th>생성일시</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="podInfoList" items="${podInfo}" varStatus="i">
							<tr>
								<td><c:out value="${(fn:length(podInfo)-i.count)+1}" /></td>
								<td>
								<c:choose>
										<c:when test="${podInfoList.statCd eq '01'}">
											<span title="${podInfoList.statNm }" class="status status-blue"><c:out value="${podInfoList.statNm}"/></span>
										</c:when>
										<c:when test="${podInfoList.statCd eq '02'}">
											<span title="${podInfoList.statNm }" class="status status-green"><c:out value="${podInfoList.statNm}"/></span>
										</c:when>
										<c:when test="${podInfoList.statCd eq '03'}">
											<span title="${podInfoList.statNm }" class="status status-red"><c:out value="${podInfoList.statNm}"/></span>
										</c:when>
										<c:when test="${podInfoList.statCd eq '04'}">
											<span title="${podInfoList.statNm }" class="status status-aqua"><c:out value="${podInfoList.statNm}"/></span>
										</c:when>
										<c:when test="${podInfoList.statCd eq '05'}">
											<span title="${podInfoList.statNm }" class="status status-gray"><c:out value="${podInfoList.statNm}"/></span>
										</c:when>
										<c:when test="${podInfoList.statCd eq '06'}">
											<span title="${podInfoList.statNm }" class="status status-yellow"><c:out value="${podInfoList.statNm}"/></span>
										</c:when>
								</c:choose>
								</td>
								<td class="alignL"><c:out value="${podInfoList.podNm}" /></td>
								<td class="alignR"><c:out value="${podInfoList.cpuCorQty}" /></td>
								<td class="alignR"><c:out value="${podInfoList.cpuUseRt}" /></td>
								<td class="alignR"><c:out value="${podInfoList.memAsgnCapa}" /></td>
								<td class="alignR"><c:out value="${podInfoList.memUseRt}" /></td>
								<td class="alignR"><c:out value="${podInfoList.netwkIn}" /></td>
								<td class="alignR"><c:out value="${podInfoList.netwkOut}" /></td>
								<td class="alignC"><c:out value="${podInfoList.creDttm}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<input type="hidden" id = "avgMemUseRt" title="평균메모리사용량" value="${podInfo[0].avgMemUseRt}">
			<input type="hidden" id = "avgCpuUseRt" title="평균CPU사용량" value="${podInfo[0].avgCpuUseRt}">
		</div>
</form:form>
<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">배포 이력</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<!-- box-body -->
		<div class="box-body no-padding detail-list-body" >
			<table class="table table-hover table-vertical table-layout-fixed" id="distrbHstryTable">
			<caption>배포 이력 테이블</caption>
				<thead>
					<tr>
						<th>No.</th>
						<th>상태</th>
						<th>버전</th>
						<th>배포 이미지명</th>
						<th>최신여부</th>
						<th>생성일시</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="distrbList" items="${distrbHstry}" varStatus="i">
						<tr>
							<td><c:out value="${(fn:length(distrbHstry)-i.count)+1}" /></td>
							<td>
							<c:choose>
									<c:when test="${distrbList.distrbStatCd eq '01'}">
										<span title="${distrbList.distrbStatNm }" class="status status-blue"><c:out value="${distrbList.distrbStatNm}"/></span>
									</c:when>
									<c:when test="${distrbList.distrbStatCd eq '02'}">
										<span title="${distrbList.distrbStatNm }" class="status status-green"><c:out value="${distrbList.distrbStatNm}"/></span>
									</c:when>
									<c:when test="${distrbList.distrbStatCd eq '03'}">
										<span title="${bldList.distrbStatNm }" class="status status-red"><c:out value="${distrbList.distrbStatNm}"/></span>
									</c:when>
									<c:when test="${distrbList.distrbStatCd eq '04'}">
										<span title="${distrbList.distrbStatNm }" class="status status-aqua"><c:out value="${distrbList.distrbStatNm}"/></span>
									</c:when>
									<c:when test="${empty distrbList.distrbStatCd}">
										<span title="${selectCodeList[7].cdNm}" class="status status-aqua"><c:out value="${selectCodeList[7].cdNm}"/></span>
									</c:when>
									<c:otherwise><span title="${distrbList.distrbStatNm }" class="status status-aqua"><c:out value="${distrbList.distrbStatNm }"/></span></c:otherwise>
							</c:choose>
							</td>
		                    <td class="alignR"><c:out value="${distrbList.distrbVer}" /></td>
							<td class="alignL"><c:out value="${distrbList.imgNm}" /></td>
							<c:choose>
								<c:when test='${distrbList.distrbVer eq distrbList.lastDistrbVer}'>
									<td><c:out value="Y" /></td>
								</c:when>
					 			<c:when test='${distrbList.distrbVer ne distrbList.lastDistrbVer}'>
									<td><c:out value="N" /></td>
								</c:when>
							</c:choose>
		                    <td class="alignC"><c:out value="${distrbList.distrbDttm}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="fn_selectDistrbList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<c:if test="${'Y' eq distrbHstry[0].ctlTrgtYn }">
				<menu:authorize authType="act">
					<button class="btn btn-sm btn-hover-blue" data-toggle="tooltip"  data-original-title="저장"  onclick="fn_updateDistrb();"><i class="fa fa-check"></i></button>
				</menu:authorize>
			</c:if>
		</div>
	</div>
</div>

<script type="text/javascript">
 $(function() {
	fnLayoutConf200();
	var stat = "${ distrbHstry[0].statCd}";
 	if(stat == '01' || "" == stat) setInterval(function(){ fn_selectDistrbStat(); }, 30*1000);
	});

function fn_selectDistrbStat(){
	fn_form_rename("distrbEnvConfList", "envVarNm,envVarVl");
	var options = {
			type: 'get',
			dataType: 'json',
			success: selectDistrbStatResultHandler,
			beforeSend: function() {
				/* $.ncmsLoding.startFullScreen(); */
			},
			complete : function() {
				/* $.ncmsLoding.remove(); */
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};
 	$('#atmsclDistrbVo').attr('action', '<c:url value="selectDistrbStat.do"/>');
	$('#atmsclDistrbVo').ajaxSubmit(options);
}
function selectDistrbStatResultHandler(result){
	if(result.procType == "update") {
		if(result.success){
			location.reload();
		}
	}
}
//뒤로
function fn_selectDistrbList(){
	location.href = '<c:url value="selectAtmsclDistrbList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'servcSeq' && pageParam.key ne 'rsrcPoolId' && pageParam.key ne 'distrbConfId' && pageParam.key ne 'imgId' && pageParam.key ne 'servcAreaId' && pageParam.key ne 'servcAreaSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}
//배포 버튼 클릭 시
function fn_Distrb(stat){

	if(!fn_form_validation("atmsclDistrbVo")){
		return;
	}

	if(!fn_checkEnvList()) {
		return;
	}
	fn_form_rename("distrbEnvConfList", "envVarNm,envVarVl");
	$('#rmk').val($('#textareaRmk').val());

	jConfirm('배포 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: distrbResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#atmsclDistrbVo').attr('action', '<c:url value="updateDistrbConf.do"/>');
		$('#atmsclDistrbVo').ajaxSubmit(options);

	});
}

//저장 결과 콜백
function distrbResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		if(result.procType == "update") {
			jInfo(result.messageList, function(){
				location.reload();
			});
		}
	}
	else{
		alert_message(result.messageList)
	}
}

//스토리지 추가 호출 (팝업)
function openDistrbStrgAdd() {
	var url = '<c:url value="atmsclDistrbStrgAddP.do"/>';
	var width = 800;
	var height = 300;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};


	var rsrcPool = $("#rsrcPoolId").val();
	var servcAreaSeq = $("#servcAreaSeq").val();
	var servcSeq = $("#servcSeq").val();
	var regionId = $("#regionId").val();
	var zoneId = $("#zoneId").val();
	var netClCd = $("#netClCd").val();
	var distrbConfId = $("#distrbConfId").val();
	var servcAreaId = $("#servcAreaId").val();

	var param = {"rsrcPoolId":rsrcPool
				 ,"searchType" : "S"
				 ,"servcAreaSeq":servcAreaSeq
				 ,"servcSeq":servcSeq
				 ,"regionId":regionId
				 ,"zoneId":zoneId
				 ,"netClCd":netClCd
				 ,"distrbConfId":distrbConfId
				 ,"servcAreaId":servcAreaId};
	windowOpen(url,param, args);
}
//자원확장 호출 (팝업)
function openDistrbReplica() {
	var url = '<c:url value="atmsclDistrbReplicasP.do"/>';
	var width = 800;
	var height = 400;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};

	var rsrcPool = $("#rsrcPoolId").val();
	var servcAreaSeq = $("#servcAreaSeq").val();
	var servcSeq = $("#servcSeq").val();
	var regionId = $("#regionId").val();
	var zoneId = $("#zoneId").val();
	var netClCd = $("#netClCd").val();
	var distrbConfId = $("#distrbConfId").val();
	var servcAreaId = $("#servcAreaId").val();
	var avgMemUseRt = parseFloat($("#avgMemUseRt").val());
	var avgCpuUseRt = parseFloat($("#avgCpuUseRt").val());

	var param = {"rsrcPoolId":rsrcPool
				 ,"searchType" : "S"
				 ,"servcAreaSeq":servcAreaSeq
				 ,"servcSeq":servcSeq
				 ,"regionId":regionId
				 ,"zoneId":zoneId
				 ,"netClCd":netClCd
				 ,"distrbConfId":distrbConfId
				 ,"servcAreaId":servcAreaId
				 ,"avgMemUseRt":avgMemUseRt
				 ,"avgCpuUseRt":avgCpuUseRt};
	windowOpen(url,param, args);
}

//자원제한 호출 (팝업)
function openDistrbRsrcLtp() {
	var url = '<c:url value="atmsclDistrbRsrcLtP.do"/>';
	var args = {key:"자원제한", width:800,height:500};

	var rsrcPool = $("#rsrcPoolId").val();
	var servcAreaSeq = $("#servcAreaSeq").val();
	var servcSeq = $("#servcSeq").val();
	var regionId = $("#regionId").val();
	var zoneId = $("#zoneId").val();
	var netClCd = $("#netClCd").val();
	var distrbConfId = $("#distrbConfId").val();
	var servcAreaId = $("#servcAreaId").val();
	var reqCpuCorQty = $("#reqCpuCorQty").val();
	var lmttCpuCorQty = $("#lmttCpuCorQty").val();
	var reqMemCapa = $("#reqMemCapa").val();
	var lmttMemCapa = $("#lmttMemCapa").val();
	var distrbId = $("#distrbId").val();

	var param = {"rsrcPoolId":rsrcPool
				 ,"searchType" : "S"
				 ,"servcAreaSeq":servcAreaSeq
				 ,"servcSeq":servcSeq
				 ,"regionId":regionId
				 ,"zoneId":zoneId
				 ,"netClCd":netClCd
				 ,"distrbConfId":distrbConfId
				 ,"servcAreaId":servcAreaId
				 ,"reqMemCapa":reqMemCapa
				 ,"lmttMemCapa":lmttMemCapa
				 ,"reqCpuCorQty":reqCpuCorQty
				 ,"lmttCpuCorQty":lmttCpuCorQty
				 ,"distrbId":distrbId};
	windowOpen(url,param, args);
}

//환경변수 추가
function fn_insertEnv() {

	// 행 추가 한다.
	var html = null;
	html = '<tr>'
			+ '<td>'
			+ '<input type="text" name="distrbEnvConfList[].envVarNm" class="form-control" value="" maxlength="100" />'
			+ '</td>'
			+ '<td>'
			+ '<input type="text" name="distrbEnvConfList[].envVarVl" class="form-control" value="" maxlength="100"/>'
			+ '</td>'
			+ '<td>'
			+ '<button type="button" class="btn btn-sm btn-function" name="btnInsertEnv" onclick="fn_deleteEnv(this)" title="환경변수삭제">삭제</button>'
			+ '</td>'
			+ '</tr>';

	$("#envTable tbody").append(html);
}


//환경변수 삭제
function fn_deleteEnv(obj) {
	var tr = $(obj).parent().parent();
	tr.remove();
}
//오토스케일링
function openDistrbAutoSclp(){

	var reqCpuCorQty = $("#reqCpuCorQty").val();
	var lmttCpuCorQty = $("#lmttCpuCorQty").val();
	var reqMemCapa = $("#reqMemCapa").val();
	var lmttMemCapa = $("#lmttMemCapa").val();
	var reqCpuCorQtyF = parseFloat(reqCpuCorQty);
	var lmttCpuCorQtyF = parseFloat(lmttCpuCorQty);
	var reqMemCapaF = parseFloat(reqMemCapa);
	var lmttMemCapaF = parseFloat(lmttMemCapa);
	var total = reqCpuCorQtyF + lmttCpuCorQtyF + reqMemCapaF + lmttMemCapaF;
	if(total == 0 ){
		jAlert('자원제한이 설정이 필요한 기능입니다.');
		return;
	}
	var url = '<c:url value="atmsclDistrbAutoScP.do"/>';
	var width = 800;
	var height = 500;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};

	var rsrcPool = $("#rsrcPoolId").val();
	var servcAreaSeq = $("#servcAreaSeq").val();
	var servcSeq = $("#servcSeq").val();
	var regionId = $("#regionId").val();
	var zoneId = $("#zoneId").val();
	var netClCd = $("#netClCd").val();
	var distrbConfId = $("#distrbConfId").val();
	var servcAreaId = $("#servcAreaId").val();
	var servcId = $("#servcId").val();

	var param = {"rsrcPoolId":rsrcPool
				 ,"searchType" : "S"
				 ,"servcAreaSeq":servcAreaSeq
				 ,"servcSeq":servcSeq
				 ,"servcId":servcId
				 ,"regionId":regionId
				 ,"zoneId":zoneId
				 ,"netClCd":netClCd
				 ,"distrbConfId":distrbConfId
				 ,"servcAreaId":servcAreaId
				};
	windowOpen(url,param, args);

}

$("#podInfoTable").DataTable({
    dom : 'Zlfrtip',
    paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
    aoColumns : [
          {sWidth : "40px" },	// No
          {sWidth : "60px" },	// 상태
          {sWidth : "185px" }, 	// POD명
          {sWidth : "65px" }, 	// CPU
          {sWidth : "85px" }, 	// CPU사용률
          {sWidth : "70px" },	// MEM
          {sWidth : "92px" },	// MEM사용률
          {sWidth : "114px" },	// NETin
          {sWidth : "126px" },	// NETo
          {sWidth : "135px" }	// 생성일
    ],
    order : [ [ 0, "desc" ] ]
});

$("#pvcInfoTable").DataTable({
    dom : 'Zlfrtip',
    paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
    aoColumns : [
          /* {sWidth : "20px" },	// 선택 */
          {sWidth : "40px" },	// No
          {sWidth : "200px" },	// 상태
          {sWidth : "150px" }, 	// POD명
          {sWidth : "70px" }, 	// CPU
          {sWidth : "160px" }, 	// CPU사용률
          {sWidth : "40px" },	// 삭제
    ],
    order : [ [ 0, "desc" ] ]
});

function fn_refresh(){
	location.reload();
};
//저장 버튼 클릭시
function fn_updateDistrb(){
	if(!fn_form_validation("atmsclDistrbVo")){
		return;
	}

	if(!fn_checkEnvList()) {
		return;
	}
	fn_form_rename("distrbEnvConfList", "envVarNm,envVarVl");
	$('#rmk').val($('#textareaRmk').val());
	 jConfirm('저장 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: distrbSaveResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#atmsclDistrbVo').attr('action', '<c:url value="updateDistrbConfSave.do"/>');
		$('#atmsclDistrbVo').ajaxSubmit(options);

	});
};
//저장 결과 콜백
function distrbSaveResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		if(result.procType == "update") {
			jInfo(result.messageList, function(){
				location.reload();
			});
		}
	}
	else{
		alert_message(result.messageList)
	}
}
function fn_alert(ch){
	if(ch == "01"){
		jAlert('오토스케일 설정이 되어있으면 사용 불가능합니다.');
		return;
	}else{
		var servNm = '${distrbHstry[0].servcNm }';
		jAlert('서비스('+servNm+')의 빌드가 완료되어야 배포를 할 수 있습니다.');
		return;
	}
}


//환경변수 체크
function fn_checkEnvConfListStr(checkstr) {
	var reg = /^[A-Za-z_][A-Za-z0-9_]*$/
	return reg.test(checkstr);
}

//환경변수 체크

function fn_checkEnvList(){
	var checkCnt = $("input[name='distrbEnvConfList[].envVarNm']").length;

	for( var i=0; i < checkCnt; i++ ) {
		if( !fn_checkEnvConfListStr($("input[name='distrbEnvConfList[].envVarNm']").eq(i).val()) ) {
			jAlert("환경변수명을 다시 입력해 주세요.\n(배포 환경변수 입력 유의사항을 확인해 주세요.)", function() {
				$("input[name='distrbEnvConfList[].envVarNm']").eq(i).focus();
			});
			return false;
		}
	}
	return true;
}

function fn_delPvc(distrbConfId,servcAreaSeq,servcSeq,pvcId,pvId,volumeNm){
	if(!fn_form_validation("atmsclDistrbVo")){
		return;
	}
	$("#distrbConfId").val(distrbConfId);
	$("#servcAreaSeq").val(servcAreaSeq);
	$("#servcSeq").val(servcSeq);
	$("#pvcId").val(pvcId);
	$("#pvId").val(pvId);
	$("#volumeNm").val(volumeNm);

	fn_form_rename("distrbEnvConfList", "envVarNm,envVarVl");
	$('#rmk').val($('#textareaRmk').val());

	jConfirm('스토리지를 삭제 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: strgDeleteeResultHandler,
			beforeSend: function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				jAlert('오류가 발생하였습니다.');
			}
		};

		$('#atmsclDistrbVo').attr('action', '<c:url value="deletePvc.do"/>');
		$('#atmsclDistrbVo').ajaxSubmit(options);

	});
}

//저장 결과 콜백
function strgDeleteeResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		if(result.procType == "delete") {
			jInfo(result.messageList, function(){
				location.reload();
			});
		}
	}
	else{
		alert_message(result.messageList)
	}
}

$("#distrbHstryTable").DataTable({
	dom: 'Zlfrtip' ,
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	scrollY: "300px",
	scrollCollapse: true,
	scrollX: true,
    aoColumns : [
          {sWidth : "50px" }, 	//No
          {sWidth : "60px" },  	//상태
          {sWidth : "71px" },  	//버전
          {sWidth : "366px"}, 	//배포 이미지명
          {sWidth : "75px" }, 	//최신여부
          {sWidth : "330px"}  	//생성일시
    ],
    order : [ [ 0, "desc" ] ]
});


$(window).bind("resize", fnLayoutConf200);

function fnLayoutConf200() {
	$("#distrbHstryTable").css("width", "100%");
	$("#distrbHstryTable").DataTable().columns.adjust().draw();
}
function fnLayoutConf201() {
	fnLayoutConf200();
}
</script>
