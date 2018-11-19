<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     양정순         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="col-box-100 search-col">
	<div class="box box-search">
		<div class="box-header">
			<h3 class="box-title">검색조건</h3>
			<div class="box-tools pull-right">
				<!-- 접기 버튼 -->
				<button type="button" class="btn btn-sm" data-toggle="collapse" data-target=".search-collapse">
					<i class="fa fa-chevron-up" data-toggle="tooltip" title="" data-original-title="접어두기"></i>
				</button>
			</div>
		</div>
		<!-- /box-header -->
		<div class="box-body collapse in search-collapse">
			<div class="form-group">

				<div class="form-cell form-cell-25 col-lay-25">
					<div class="cell-title">
						<label>부처명</label>
					</div>
					<div class="cell-title">
						<label><c:out value="${cmJob.institutionNm }" /></label>

					</div>
				</div>

				<div class="form-cell form-cell-25 col-lay-25">
					<div class="cell-title">
						<label>업무명</label>
					</div>
					<div class="cell-title">
						<label><c:out value="${cmJob.jobNm }" /> </label>

					</div>
				</div>

			</div>
		</div>
		<!-- /box-body -->
		<div class="box-footer collapse in search-collapse"></div>
		<!-- /box-footer -->
	</div>
	<!-- /box(검색조건) -->
</div>
<!-- /col -->

<div class="col-box-100 detail-col">
	<div class="detail-list-box box">
		<div class="box-header">
			<h3 class="box-title">
				IP대역 정보
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
		</div>

		<c:choose>

			<c:when test="${ IpBndList eq null or empty IpBndList }">
				<div class="box-body no-padding">
					<table class="table table-horizon">
						<caption>IP대역 정보</caption>
						<colgroup>
							<col class="col15">
							<col class="col35">
							<col class="col15">
							<col class="col35">
						</colgroup>
						<tbody>
							<tr>
								<td colspan="4">검색된 데이터가 없습니다.</td>
							</tr>
						</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>

				<c:forEach var="vo" items="${IpBndList}" varStatus="ri">
					<div class="box-body no-padding">
						<table class="table table-horizon ">
							<caption>IP대역 정보</caption>
							<colgroup>
								<col class="col15">
								<col class="col35">
								<col class="col15">
								<col class="col35">
								<col class="col15">
							</colgroup>
							<tbody>

								<tr>
									<th>IP 대역명</th>
									<td><c:out value="${vo.ipBndNm }" /></td>
									<th>망구분</th>
									<td><c:out value="${vo.netNm }" /></td>
								</tr>
								<tr>
									<th>시작 IP</th>
									<td><c:out value="${vo.bndStrtIp }" /></td>
									<th>종료 IP</th>
									<td><c:out value="${vo.bndEndIp }" /></td>
								</tr>
								<tr>
									<th>서브넷 마스크</th>
									<td><c:out value="${vo.subnetMask }" /></td>
									<th>게이트웨이</th>
									<td><c:out value="${vo.gtwyIpAddr }" /></td>
								</tr>
								<tr>
									<th>VLAN</th>
									<td><c:out value="${vo.vlan }" /></td>
									<th>Block IP수</th>
									<td><c:out value="${vo.blkIpQty }" /></td>
								</tr>
								<tr>
									<th>사용부처</th>
									<td><c:out value="${vo.institutionNm }" /></td>
									<th>용도</th>
									<td><c:out value="${vo.prposNm }" /></td>
								</tr>

							</tbody>
						</table>
					</div>
					<br>
				</c:forEach>

			</c:otherwise>
		</c:choose>


		<!-- /box-body -->
		<!-- box-footer -->
		<div class="box-footer clearfix">
			<div class="pull-right">
				<!-- 			         <button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="엑셀다운로드"><i class="fa fa-arrow-down"></i></button> -->
			</div>
		</div>
	</div>
	<!-- /box -->

	<div class="detail-list-box box">
		<div class="box-header">
			<h3 class="box-title">
				컴퓨팅
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-vertical">
				<caption>컴퓨팅</caption>
				<colgroup>
					<col class="colAuto">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col7">
					<col class="col7">
					<col class="col5">
					<col class="col5">
					<col class="col10">
					<col class="col5">
					<col class="col5">
					<col class="col10">
					<col class="col7">
					<col class="col7">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">상태</th>
						<th rowspan="2">센터</th>
						<th rowspan="2">존</th>
						<th rowspan="2">망</th>
						<th rowspan="2">자원풀</th>
						<th rowspan="2">클러스터</th>
						<th rowspan="2">물리서버 구성ID</th>
						<th rowspan="2">가상서버 구성ID</th>
						<th rowspan="2">IP주소</th>
						<th rowspan="2">OS타입</th>
						<th colspan="3">CPU</th>
						<th colspan="2">메모리</th>
						<th rowspan="2">스토리지 (TB)</th>
					</tr>
					<tr>
						<th>사용률</th>
						<th>Ent.</th>
						<th>vCore</th>
						<th>사용률</th>
						<th>할당량 (GB)</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ vmVoList eq null or empty vmVoList }">
							<tr>
								<td colspan="16">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vmVo" items="${vmVoList}" varStatus="ri">

								<tr>
									<td><span><nobr> <c:out value="${vmVo.statCdNm }" /></nobr></span></td>
									<td><nobr><c:out value="${vmVo.regionNm }" /></nobr></td>
									<td><nobr><c:out value="${vmVo.zoneNm }" /></nobr></td>
									<td><nobr><c:out value="${vmVo.netNm }" /></nobr></td>
									<td><nobr><c:out value="${vmVo.rsrcPoolNm }" /></td>
									<td><nobr><c:out value="${vmVo.clstrNm }" /></nobr></td>
									<td><a href="<c:url value="/cpt/rsrc/com/pm/selectPm.do?pmSeq="/><c:out value="${vmVo.pmSeq }"/>" title="<c:choose><c:when test="${empty vmVo.vmCompId}">물리서버 구성ID</c:when><c:otherwise><c:out value="${vmVo.pmCompId }" /></c:otherwise></c:choose>"><nobr></nobr><c:out value="${vmVo.pmCompId }" /></nobr></a></td>
									<td><a href="<c:url value="/cpt/rsrc/com/vm/selectVm.do?vmSeq="/><c:out value="${vmVo.vmSeq }"/>" title="<c:choose><c:when test="${empty vmVo.vmCompId}">가상서버 구성ID</c:when><c:otherwise><c:out value="${vmVo.vmCompId }" /></c:otherwise></c:choose>"><nobr><c:out value="${vmVo.vmCompId }" /></nobr></a></td>
									<td><nobr> <c:out value="${vmVo.rprsntIpAddr }" /></td>
									<td><nobr><c:out value="${vmVo.osTyCdNm }" /></nobr></td>
									<td><span class="label label-green"><fmt:formatNumber value="${vmVo.cpuUseRt}" pattern="0" />%</span>
										<div class="progress">
											<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${vmVo.cpuUseRt}" pattern="0"/>%"></div>
										</div>
									</td>
									<td><nobr><c:out value="${vmVo.cpuEnt }" /></nobr></td>
									<td><nobr><c:out value="${vmVo.cpuVcoreQty }" /></nobr></td>
									<td><span class="label label-green"><fmt:formatNumber value="${vmVo.memUseRt}" pattern="0" />%</span>
										<div class="progress">
											<div class="progress-bar progress-bar-green"
												style="width: <fmt:formatNumber value="${vmVo.memUseRt}" pattern="0"/>%"></div>
										</div>
									</td>
									<td><nobr><fmt:formatNumber value="${vmVo.memAsgnCapa}" pattern="0" /></nobr></td>
									<td><nobr><fmt:formatNumber value="${vmVo.strgAsgnCapa}" pattern="0" /></nobr></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>


				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<!-- box-footer -->
		<div class="box-footer clearfix">
			<div class="pull-right">
				<!-- 			         <button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="엑셀다운로드"><i class="fa fa-arrow-down"></i></button> -->
			</div>
		</div>
	</div>
	<!-- /box -->

	<div class="detail-list-box box">
		<div class="box-header">
			<h3 class="box-title">
				네트워크
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-vertical">
				<caption>네트워크</caption>
				<colgroup>
					<col class="colAuto">
					<col class="col4">
					<col class="col4">
					<col class="col4">
					<col class="col8">
					<col class="col8">
					<col class="col8">
					<col class="col5">
					<col class="col7">
					<col class="col4">
					<col class="col4">
					<col class="col7">
					<col class="col7">
					<col class="col9">
					<col class="col7">
					<col class="col7">
				</colgroup>
				<thead>
					<tr>
						<th rowspan="2">상태</th>
						<th rowspan="2">네트워크유형</th>
						<th rowspan="2">망</th>

						<th rowspan="2">물리서버 구성ID</th>
						<th rowspan="2">가상서버 구성ID</th>
						<th rowspan="2">IP주소</th>
						<th rowspan="2">OS타입</th>
						<th colspan="3">CPU</th>
						<th colspan="2">메모리</th>
						<th rowspan="2">스토리지 (TB)</th>
						<th colspan="2">네트워크</th>

					</tr>
					<tr>
						<th>사용률</th>
						<th>Ent.</th>
						<th>vCore</th>
						<th>사용률</th>
						<th>할당량 (GB)</th>
						<th>In (KB/Sec)</th>
						<th>Out (KB/Sec)</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ NetVmVo eq null or empty NetVmVo }">
							<tr>
								<td colspan="15">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="netVmVo" items="${NetVmVo}" varStatus="ri">
								<c:url var="detailUrl" value="/cpt/rsrc/net/vm/selectNetVm.do">
									<c:param name="vmSeq" value="${netVmVo.vmSeq }" />
									<c:forEach var="curParam" items="${param}">
										<c:param name="${curParam.key}" value="${curParam.value}" />
									</c:forEach>
								</c:url>
								<tr>
									<td><span><c:out value="${netVmVo.statCdNm }" /></span></td>
									<td><c:out value="${netVmVo.netwkTyClCdNm }" /></td>
									<td><c:out value="${netVmVo.netNm }" /></td>
									<td><a title="<c:out value="${netVmVo.pmCompId }" />" href="<c:url value="/cpt/rsrc/net/pm/selectNetPm.do?pmSeq="/><c:out value="${netVmVo.pmSeq }"/>"><c:out value="${netVmVo.pmCompId }" /></a></td>
									<td><a href="<c:url value="/cpt/rsrc/net/vm/selectNetVm.do?vmSeq="/><c:out value="${netVmVo.vmSeq }"/>" title="<c:out value="${netVmVo.vmNm }"/>"><c:out value="${netVmVo.vmId }" /></a></td>
									<td><c:out value="${netVmVo.rprsntIpAddr }" /></td>
									<td><c:out value="${netVmVo.osTyCdNm }" /></td>
									<td><span class="label label-green"><fmt:formatNumber value="${netVmVo.cpuUseRt}" pattern="0" />%</span>
										<div class="progress">
											<div class="progress-bar progress-bar-green"
												style="width: <fmt:formatNumber value="${netVmVo.cpuUseRt}" pattern="0"/>%"></div>
										</div>
									</td>
									<td><c:out value="${netVmVo.cpuEnt }" /></td>
									<td><c:out value="${netVmVo.cpuVcoreQty }" /></td>
									<td><span class="label label-green"><fmt:formatNumber value="${netVmVo.memUseRt}" pattern="0" />%</span>
										<div class="progress">
											<div class="progress-bar progress-bar-green"
												style="width: <fmt:formatNumber value="${netVmVo.memUseRt}" pattern="0"/>%"></div>
										</div>
									</td>
									<td><fmt:formatNumber value="${netVmVo.memAsgnCapa}" pattern="0" /></td>
									<td><fmt:formatNumber value="${netVmVo.strgAsgnCapa}" pattern="0" /></td>
									<td><fmt:formatNumber value="${netVmVo.netwkIn }" pattern="0.0" /></td>
									<td><fmt:formatNumber value="${netVmVo.netwkOut }" pattern="0.0" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
		</div>
		<!-- /box-body -->
		<!-- box-footer -->
		<div class="box-footer clearfix">
			<div class="pull-right">
				<!-- 			         <button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="엑셀다운로드"><i class="fa fa-arrow-down"></i></button> -->
			</div>
		</div>
	</div>
	<!-- /box -->

	<div class="detail-list-box box">
		<div class="box-header">
			<h3 class="box-title">
				SLB 설정정보
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-vertical">
				<caption>SLB 설정정보</caption>
				<colgroup>
					<col class="col10">
					<col class="col10">
					<col class="col10">
					<col class="colAuto">
					<col class="col7">
					<col class="col7">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col5">
					<col class="col10">
				</colgroup>
				<tbody>
					<tr>
						<th rowspan="2">VIP</th>
						<th colspan="2">리스너 정보</th>
						<th colspan="3">풀 정보</th>
						<th colspan="5">모니터링 정보</th>

					</tr>
					<tr>
						<th>프로토콜</th>
						<th>포트</th>
						<th>유형</th>
						<th>세션 유지유형</th>
						<th>세션 유지값</th>
						<th>상태확인</th>
						<th>상태확인<br>주기(초)
						</th>
						<th>상태확인<br> 타임아웃(초)
						</th>
						<th>최대시도<br>횟수
						</th>
						<th>상태확인 HTTP URL</th>
					</tr>
					<c:choose>
						<c:when test="${ rnSlbList eq null or empty rnSlbList }">
							<tr>
								<td colspan="11">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="rnSlbList" items="${rnSlbList}" varStatus="ri">
								<tr>
									<td><c:out value="${rnSlbList.vipAddr }" /></td>
									<td class="alignC"><c:out value="${rnSlbList.prtcl }" /></td>
									<td class="alignC"><c:out value="${rnSlbList.port }" /></td>
									<td class="alignC"><c:out value="${rnSlbList.slbTyCd }" /></td>
									<td class="alignC"><c:out value="${rnSlbList.sessMntncTyCd }" /></td>
									<td class="alignL"><c:out value="${rnSlbList.sessMntncVl }" /></td>
									<td class="alignC"><c:out value="${rnSlbList.statConfrm }" /></td>
									<td class="alignC"><c:out value="${rnSlbList.statConfrmCycle }" /></td>
									<td class="alignC"><c:out value="${rnSlbList.statConfrmTOut }" /></td>
									<td class="alignC"><c:out value="${rnSlbList.maxTryCnt }" /></td>
									<td class="alignL"><c:out value="${rnSlbList.statConfrmHttpUrl }" /></td>
								</tr>

							</c:forEach>
						</c:otherwise>
					</c:choose>
			</table>
		</div>
		<!-- /box-body -->
		<!-- box-footer -->
		<div class="box-footer clearfix">
			<div class="pull-right">
				<!-- 			         <button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="엑셀다운로드"><i class="fa fa-arrow-down"></i></button> -->
			</div>
		</div>
	</div>
	<!-- /box -->

	<div class="detail-list-box box">
		<div class="box-header">
			<h3 class="box-title">
				SLB 적용대상 정보
				<!-- <small>1 / 1, 총 1건</small>-->
			</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-vertical">
				<caption>SLB 적용대상 정보</caption>
				<colgroup>
					<col class="col5">
					<col class="col15">
					<col class="col15">
					<col class="col15">
					<col class="col15">
					<col class="colAuto">
				</colgroup>
				<tbody>
					<tr>
						<th>No.</th>
						<th>VIP</th>
						<th>IP</th>
						<th>포트</th>
						<th>가중치(로드밸런싱)</th>
						<th>설명</th>
					</tr>
					<c:choose>
						<c:when test="${ rnSlbIpList eq null or empty rnSlbIpList }">
							<tr>
								<td colspan="6">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="rnSlbIpList" items="${rnSlbIpList}" varStatus="ri">
								<tr>
									<td class="alignC"><c:out value="${ri.count}" /></td>
									<td><c:out value="${rnSlbIpList.vipAddr }" /></td>
									<td><c:out value="${rnSlbIpList.ipAddr }" /></td>
									<td class="alignC"><c:out value="${rnSlbIpList.port }" /></td>
									<td class="alignC"><c:out value="${rnSlbIpList.wvl }" /></td>
									<td class="alignL"><c:out value="${rnSlbIpList.dc }" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
			</table>
		</div>
		<!-- /box-body -->
		<!-- box-footer -->
		<div class="box-footer clearfix">
			<div class="pull-right">
				<!-- 			         <button class="btn btn-hover-green" data-toggle="tooltip" data-original-title="엑셀다운로드"><i class="fa fa-arrow-down"></i></button> -->
			</div>
		</div>
	</div>
	<!-- /box -->
	<div class="detail-list-box box">
		<div class="box-header">
			<h3 class="box-title">
				자동확장 서비스 목록
			</h3>
		</div>

		<div class="box-body no-padding">
				<table class="table table-vertical" id="servcTable">
					<caption>서비스 목록 테이블</caption>
					<thead>
                      <tr>
                        <th>No.</th>
                        <th>부처</th>
                        <th>업무</th>
                        <th>센터</th>
                        <th>존</th>
                        <th>망구분</th>
                        <th>자원풀</th>
                        <th>서비스명</th>
                        <th>Pod수</th>
						<th>CPU<br>Core</th>
						<th>CPU<br>사용률(%)</th>
						<th>메모리<br>할당량(GB)</th>
						<th>메모리<br>사용률(%)</th>
						<th>네트워크<br>In(KB/Sec)</th>
						<th>네트워크 <br>Out(KB/Sec)</th>
						<th>생성일자</th>
                      </tr>
                    </thead>

					<tbody>
					<c:choose>
						<c:when test="${ selectServcList eq null or empty selectServcList }">
							<tr>
								<td colspan="16">검색된 데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${selectServcList }" varStatus="i">
							<tr>
								<c:url var="detailUrl" value="selectServc.do">
									<c:forEach var="curParam" items="${param }">
										<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
									</c:forEach>
									<c:param name="servcSeq" value="${vo.servcSeq }" />
								</c:url>

								<td class="alignC"><c:out value="${(fn:length(selectServcList)-i.count)+1}" /></td>
								<td class="alignL"><c:out value="${vo.institutionNm}" /></td>
								<td class="alignC"><c:out value="${vo.jobNm}" /></td>
		                        <td class="alignL"><c:out value="${vo.regionNm}" /></td>
		                        <td class="alignL"><c:out value="${vo.zoneNm}" /></td>
		                        <td class="alignL"><c:out value="${vo.netNm}" /></td>
		                        <td class="alignC"><c:out value="${vo.rsrcPoolNm}" /></td>
		                        <td class="alignL">
<%-- 		                               <a href="<c:url value="${detailUrl }" />" title="<c:out value="${vo.servcNm}"/> 상세 화면이동">
		                               </a>
 --%>		                               <c:out value="${vo.servcNm}" />
		                        </td>
		                        <td class="alignC"><c:out value="${vo.podQty}" /></td>

		                        <c:if test="${vo.servcTyCd eq '01' }">
									<td class="alignC"><c:out value="${vo.sumCpuCorQty}" /></td>
									<td class="notellipsis">
										<span title="<fmt:formatNumber value="${vo.avgCpuUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${vo.avgCpuUseRt}" pattern="0"/></span>
										<div title="<fmt:formatNumber value="${vo.avgCpuUseRt}" pattern="0"/>" class="progress">
											<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${vo.avgCpuUseRt}" pattern="0"/>%"></div>
										</div>
									</td>
									<td class="alignC"><c:out value="${vo.sumMemAsgnCapa}" /></td>
									<td class="notellipsis">
										<span title="<fmt:formatNumber value="${vo.avgMemUseRt}" pattern="0"/>" class="label label-green"><fmt:formatNumber value="${vo.avgMemUseRt}" pattern="0"/></span>
										<div title="<fmt:formatNumber value="${vo.avgMemUseRt}" pattern="0"/>" class="progress">
											<div class="progress-bar progress-bar-green" style="width: <fmt:formatNumber value="${vo.avgMemUseRt}" pattern="0"/>%"></div>
										</div>
									</td>
								</c:if>

								<c:if test="${vo.servcTyCd ne '01' }">
									<td class="alignC">-</td>
									<td class="alignC">-</td>
									<td class="alignC">-</td>
									<td class="alignC">-</td>
								</c:if>

								<td class="alignC"><c:out value="${vo.netwkIn}" /></td>
								<td class="alignC"><c:out value="${vo.netwkOut}" /></td>
								<td class="alignC"><c:out value="${vo.creDttm}" /></td>
		                       </tr>
						</c:forEach>
						</c:otherwise>
					</c:choose>

					</tbody>
				</table>
		</div>
	</div>

<div class="detail-list-box box">
		<div class="box-header">
			<h3 class="box-title">
				자동확장 Pod 목록
			</h3>
		</div>
	<div class="box-body no-padding">
		<table class="table table-vertical">
			<caption>Pod 목록 테이블</caption>
			<colgroup>
				<col class="col5">
				<col class="col20">
				<col class="col5">
				<col class="col10">
				<col class="col10">
				<col class="col10">
				<col class="col10">
				<col class="col10">
				<col class="col10">
				<col class="col10">
			</colgroup>
			<thead>
			<tr>
				<th>No.</th>
				<th>Pod명</th>
				<th>상태</th>
				<th>CPU<br>Core</th>
				<th>CPU<br>사용률(%)</th>
				<th>메모리<br>할당량(GB)</th>
				<th>메모리<br>사용률(%)</th>
				<th>네트워크<br>In(KB/Sec)</th>
				<th>네트워크<br>Out(KB/Sec)</th>
				<th>생성일시</th>
			</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${selectPodList eq null or empty selectPodList }">
						<tr>
							<td colspan="10">Pod 정보가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="pod" items="${selectPodList }" varStatus="i">
				          <tr>
				          	<td class="alignC"><c:out value="${(fn:length(selectPodList)-i.count)+1}" /></td>
				          	<td class="alignL"><c:out value="${pod.podNm }" /></td>
							<td class="alignC">
								<!-- 진행중 01: 완료:02, 실패 03: New: 04 , Pending:05, 기타:06 -->
		                		<span class="status <c:choose>
		                								<c:when test="${'01' eq pod.statCd}"><c:out value="status-blue"/></c:when>
		                								<c:when test="${'02' eq pod.statCd}"><c:out value="status-green"/></c:when>
		                								<c:when test="${'03' eq pod.statCd}"><c:out value="status-red"/></c:when>
														<c:otherwise><c:out value="status-gray"/></c:otherwise>
		                							</c:choose>
		                			status-red "><c:out value="${pod.statCdNm}"/>
		                		</span>
							</td>
							<td class="alignR"><c:out value="${pod.cpuCorQty }" /></td>
							<td class="alignR"><c:out value="${pod.cpuUseRt }" /></td>
							<td class="alignR"><c:out value="${pod.memAsgnCapa }" /></td>
							<td class="alignR"><c:out value="${pod.memUseRt }" /></td>
							<td class="alignR"><c:out value="${pod.netwkIn }" /></td>
							<td class="alignR"><c:out value="${pod.netwkOut }" /></td>
							<td><c:out value="${pod.creDttm }" /></td>
				          </tr>
				        </c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>

</div>






</div>
<!-- /col -->

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
			<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="fn_selectJobRsrcStteList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<!-- 				        <button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="" data-original-title="실행"><i class="fa fa-play-circle"></i></button> -->
			<!-- 				        <button class="btn btn-sm btn-hover-red" data-toggle="tooltip" title="" data-original-title="반려"><i class="fa fa-times"></i></button> -->
		</div>
	</div>
</div>

<script type="text/javascript">
//뒤로
function fn_selectJobRsrcStteList(){
	location.href = '<c:url value="selectJobRsrcStteList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'jobId' && pageParam.key ne 'institutionId' && pageParam.key ne 'jobNm'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}
</script>


