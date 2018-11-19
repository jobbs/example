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

<div class="col-box-100">
	<div class="info">
		<h2>실행스크립트 입력 시 아래의 문자를 사용하시면 해당 정보로 변환됩니다.</h2>
		<p>- {destination} : 목지지 IP주소</p>
		<p>- {gateway} : 게이트웨이 IP주소</p>
		<p>- {mask} : 서브넷마스크</p>
		<p>- {nic} : 네트워크인터페이스명</p>
		<p style="padding: 10px; background-color:#f5f5f5; border: 1px solid #d8d8d8">
			예시1) echo "{destination}/24 via {gateway} dev {nic}" >> /etc/sysconfig/network-script/route-"+{nic}<br />
			예시2) route -p add {destination} mask {mask} {gateway}
		</p>
	</div>
</div>

<div class="col-box-100 detail-col">
	<div class="box detail-list-box">
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>기본정보</caption>
	    		<colgroup>
					<col class="col12">
					<col class="col22">
					<col class="col12">
					<col class="col22">
					<col class="col12">
					<col class="col22">
				</colgroup>
				<tbody>
	  			<tr>
	    			<th>OS유형</th>
	    			<td><c:out value="${vo.osTyNm}"/></td>
					<th>OS버전</th>
					<td><c:out value="${vo.osVer}"/></td>
					<th>사용여부</th>
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
				</tr>
				<tr>
					<th>실행스크립트</th>
					<td colspan="5"><c:out value="${vo.script}"/></td>
				</tr>
				<tr>
	  				<th>비고</th>
	  				<td colspan="5"><c:out value="${vo.dc}"/></td>
				</tr>
	    		</tbody>
	  		</table>
		</div><!-- /box-body -->
    </div>

</div><!-- /col -->

<div class="col-box-100">
	<div class="edit-btn-group">

		<c:url var="updateUrl" value="updateScript.do">
			<c:forEach var="curParam" items="${param }">
				<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
			</c:forEach>
		</c:url>
		<c:url var="listUrl" value="selectScriptList.do">
			<c:forEach var="curParam" items="${param }">
				<c:if test="${curParam.key ne 'sRoutingScriptSeq'}">
					<c:param name="${curParam.key }" value="${curParam.value }"></c:param>
				</c:if>
			</c:forEach>
		</c:url>
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')"><i class="fa fa-arrow-left"></i></button>
		</div>

		<menu:modAuthorize regId="${vo.regUserId }">
			<div class="pull-right">
				<button class="btn btn-hover-yellow" data-toggle="tooltip" data-original-title="수정" onclick="goToUrl('${updateUrl}')"><i class="fa fa-eraser"></i></button>
				<button class="btn btn-hover-red" data-toggle="tooltip" data-original-title="삭제" onclick="doDelete()"><i class="fa fa-times"></i></button>
			</div>
		</menu:modAuthorize>
	</div>
</div>


<script type="text/javascript">

function doDelete(){

	jConfirm("스태틱라우팅 스크립트를을 삭제하시겠습니까?", function() {

		//로딩바 시작
		$.ncmsLoding.startFullScreen();
		$.post("deleteScript.do", {"sRoutingScriptSeq": ${vo.sRoutingScriptSeq}}, function(result) {

			alert_message(result.messageList, function() {
				if( result.success) {
					goToUrl('${listUrl}');
				}
			});

		}, "json").always(function() {
			//로딩바 종료
			$.ncmsLoding.remove();
		});
	});

}
</script>