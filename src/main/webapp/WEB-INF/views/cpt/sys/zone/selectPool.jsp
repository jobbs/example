<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<c:set var="listSarchParam" scope="request">
	<c:forEach items="${param }" var="curParam">
		<c:if test="${curParam.key ne 'cd' and curParam.key ne 'grpCd' }">
			&<c:out value="${curParam.key }"/>=<c:out value="${curParam.value }"/>
		</c:if>
	</c:forEach>
</c:set>

<c:url var="updateUrl" value="updateCode.do"></c:url>

<div class="box">
	<div class="box-header">
		<h3 class="box-title">자원풀정보</h3>
	</div><!-- /box-header -->

	<div class="box-body no-padding">
		<form id="poolFrm">
		<table class="table table-horizon">
			<caption>자원풀 정보 테이블</caption>
			<colgroup>
				<col class="col20">
				<col class="colAuto">
			</colgroup>
			<tbody>
			<tr>
				<th>자원풀ID</th>
				<td>
					<c:out value="${pool.rsrcPoolId }" />
					<input type="hidden" name="rsrcPoolId" value="${pool.rsrcPoolId }" />
				</td>
			</tr>
			<tr>
				<th>자원풀명</th>
				<td><c:out value="${pool.rsrcPoolNm }" /></td>
			</tr>
            <tr>
				<th>자원풀 버전</th>
				<td>
					<input type="text" name="rsrcPoolVersion" value="${pool.rsrcPoolVersion }" title="버전" maxlength="4" />
				</td>
			</tr>
			<tr>
				<th>가상화SW유형</th>
				<td>
					<c:out value="${pool.vrlzSwTyNm  }" />
				</td>
			</tr>
			<tr>
				<th>데이터센터UUID</th>
				<td><c:out value="${pool.uuid }" /></td>
			</tr>
			<tr>
				<th>센터</th>
				<td><c:out value="${pool.net.zoneNet.zone.region.regionNm  }" /></td>
			</tr>
			<tr>
				<th>존</th>
				<td><c:out value="${pool.net.zoneNet.zone.zoneNm }" /></td>
			</tr>
			<tr>
				<th>망</th>
				<td><c:out value="${pool.net.netNm  }" /></td>
			</tr>
			<tr>
				<th>망구분</th>
				<td><c:out value="${pool.net.netClNm  }" /></td>
			</tr>
			<tr id="strgCompTr">
				<th>스토리지구성방식</th>
				<td>
					<nform:selectCode
							parentCd="VMSWSTRG"
							parentGrpCd="093"
							name="strgCompCd"
							id="strgCompCd"
							wholeText="스토리지구성방식을 선택하세요."
							value="${pool.strgCompCd }"
							title="스토리지구성방식"
							cssClass="form-control" />
				</td>
			</tr>
			<tr>
				<th>제어대상여부</th>
				<td>
					<div class="input-group input-group-radio">
						<c:choose>
							<c:when test="${pool.ctlTrgtYn ne null && pool.ctlTrgtYn eq 'Y'}">
								<input type="radio" id="ctl_trgt1" name="ctlTrgtYn" value="Y" checked="checked" /><label for="ctl_trgt1">사용</label>
								<input type="radio" id="ctl_trgt2" name="ctlTrgtYn" value="N" /><label for="ctl_trgt2">미사용</label>
							</c:when>
							<c:otherwise>
								<input type="radio" id="ctl_trgt1" name="ctlTrgtYn" value="Y" /><label for="ctl_trgt1">사용</label>
								<input type="radio" id="ctl_trgt2" name="ctlTrgtYn" value="N" checked="checked" /><label for="ctl_trgt2">미사용</label>
							</c:otherwise>
						</c:choose>
					</div>
				</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><fmt:formatDate value="${pool.regDttm }" pattern="yyyy-MM-dd" /></td>
			</tr>
			</tbody>
		</table>
		</form>
	</div>
	<menu:authorize>
	<div class="box-footer">
		<div class="btn-group pull-right">
			<button type="button" class="btn" onclick="fn_updatePool()">수정</button>
			<button type="button" class="btn" onclick="searchNetListByZone()">위치이동</button>
		</div>
	</div>


	<script type="text/javascript">

		function fn_updatePool(){

			if(!fn_form_validation("poolFrm")){
				return;
			}

			jConfirm("자원풀정보를 저장하시겠습니까?", function(){
				var url = "updatePool.do";

				$.ncmsLoding.startFullScreen();
				$.post(
						url,
						$('#poolFrm').serialize(),
						successHandler,
						'json'
				).always(function(){
					$.ncmsLoding.remove();
				});
			});
		}

		function successHandler(result){
			alert_message(result.messageList, function(){
				if(result.success){
				}
			})
		}

		function searchNetListByZone() {
			var url = "selectNetListByPoolP.do";
			var params = {"zoneId" : "${pool.net.zoneNet.zone.zoneId}", "netClCd" : "${pool.net.netClCd}" };
			var args = {"width" : 600, "height": 400};
			windowOpen(url, params, args);
		}

		//----------------------------------------------------------------------
		//부처에 대한 단일 선택
		$(document).bind('selectNet',selectNet);
		//업무에 대한 단일 선택 이벤터 함수
		function selectNet(evt) {

			var net = JSON.parse(JSON.stringify(evt.datas));

			jAlert("[" + net.netNm + "]에 해당 자원풀을 이동하시겠습니까?", function() {

				//로딩바 시작
				$.ncmsLoding.startFullScreen();

				$.post("updateMoveRsrcPool.do", {"poolId" : "${pool.rsrcPoolId}","netId" : net.netId}, function(result) {

					alert_message(result.messageList, function() {
						if( result.success ) {

							//선택된 노드를 삭제하고 새로운 노드를 선택된 망정보에 생성한다.
							var targetKey = net.regionId + "," + net.zoneId + "," + net.netId;
							var targetNode = $("#tree").dynatree("getTree").selectKey(targetKey);
							var node = $("#tree").dynatree("getActiveNode");
							var key = node.data.key;
							var cmnIds = key.split(",");
							var id = cmnIds.pop();

							var newNode = {
									"key" : targetNode.data.key + "," + id,
									"title" : node.data.title
							};

							//삭제
							node.remove();
							//추가
							targetNode.addChild(newNode);

							targetNode.activate();
							targetNode.focus();

							$("#tree").dynatree("getActiveNode").sortChildren(function(a, b) {
								a = a.data.title.toLowerCase();
							    b = b.data.title.toLowerCase();
							    return a > b ? 1 : a < b ? -1 : 0;
							}, false);

							$("#tree").dynatree("getActiveNode").expand(true);

							if( $("#tree").dynatree("getActiveNode").data.isFolder == null || !$("#tree").dynatree("getActiveNode").data.isFolder) {
								$("#tree").dynatree("getActiveNode").data.isFolder = true;
								$("#tree").dynatree("getActiveNode").render();
							}
						}
					});
				},"json").always(function() {
					//로딩바 종료
					$.ncmsLoding.remove();
				});
			});
		}
	</script>
	</menu:authorize>
</div>
<script type="text/javascript">
$(function() {
	if( "04" == "${pool.vrlzSwTyCd  }" ) {
		$("#strgCompCd").addClass("essential");
		$("#strgCompTr").show();
	} else {
		$("#strgCompCd").removeClass("essential");
		$("#strgCompTr").hide();
	}
});
</script>