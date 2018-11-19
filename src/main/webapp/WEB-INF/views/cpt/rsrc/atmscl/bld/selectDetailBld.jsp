<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>
 	빌드 상세 조회
 </pre>
 *
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     최경철         v1.0             최초생성
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


<div class="col-box-100">
	<div class="col-info server <c:choose>
									<c:when test='${"01" eq bldVo[0].bldStatCd}'><c:out value="server-inprogress"/></c:when>
									<c:when test='${"02" eq bldVo[0].bldStatCd}'><c:out value="server-up"/></c:when>
									<c:when test='${"03" eq bldVo[0].bldStatCd}'><c:out value="server-exception"/></c:when>
									<c:when test='${"04" eq bldVo[0].bldStatCd}'><c:out value="server-maintain"/></c:when>
									<c:when test='${"05" eq bldVo[0].bldStatCd}'><c:out value="server-maintain"/></c:when>
									<c:when test='${"06" eq bldVo[0].bldStatCd}'><c:out value="server-maintain"/></c:when>
									<c:when test='${"07" eq bldVo[0].bldStatCd}'><c:out value="server-exception"/></c:when>
									<c:when test='${"08" eq bldVo[0].bldStatCd}'><c:out value="server-maintain"/></c:when>
									<c:otherwise></c:otherwise></c:choose>">
		<div class="col-info-body alignL">
			<div class="col-info-box alignL">
				<span class="label"></span>
				<h4 class="stat">${bldVo[0].bldStatNm}</h4>
					<button type="button" class="btn btn-sm btn-refresh vm-sync" onclick="javascript:fn_refresh();">새로고침</button>
			</div>
			<div class="col-info-box alignR">
				<div class="col-info-btn">
				<c:if test="${'Y' eq bldVo[0].ctlTrgtYn }">
					<menu:authorize authType="act">
						<button type="button" class="btn vm-start" title="빌드"  onclick="fn_bldRun();"><i class="fa fa-play-circle"></i><span>빌드</span></button>
					</menu:authorize>
				</c:if>
             	</div>
            </div>
		</div>
	</div>
</div>
<div class="col-box-100 detail-col">
	<form:form commandName="bldVo">
		<input type="hidden" title="서비스영역SEQ" name="servcAreaSeq" id="servcAreaSeq" value="${bldVo[0].servcAreaSeq }" />
		<input type="hidden" title="서비스SEQ" name="servcSeq" id="servcSeq" value="${bldVo[0].servcSeq }" />
		<input type="hidden" title="서비스영역ID" name="servcAreaId" id="servcAreaId" value="${bldVo[0].servcAreaId }"/>
		<input type="hidden" title="서비스ID" name="servcId" id="servcId" value="${bldVo[0].servcId }"/>
		<input type="hidden" title="빌드ID" name="bldId" id="bldId" value="${bldVo[0].bldId }"/>
		<input type="hidden" title="센터" name="regionId" id="regionId" value="${bldVo[0].regionId }" />
		<input type="hidden" title="존" name="zoneId" id="zoneId" value="${bldVo[0].zoneId }"/>
		<input type="hidden" title="망" name="netClCd" id="netClCd" value="${bldVo[0].netClCd }"/>
		<input type="hidden" title="자원풀" name="rsrcPoolId" id="rsrcPoolId" value="${bldVo[0].rsrcPoolId }"/>
	 	<input type="hidden" title="베이스이미지ID" name="basImgId" id="basImgId" value="${bldVo[0].basImgId }"/>
		<input type="hidden" title="베이스이미지버전" name="basImgVer" id="basImgVer" value="${bldVo[0].basImgVer }"/>
		<input type="hidden" title="베이스이미지서비스영역ID" name="basImgServcAreaId" id="basImgServcAreaId" value="${bldVo[0].basImgServcAreaId }"/>
		<input type="hidden" title="생성이미지ID" name="creImgId" id="creImgId" value="${bldVo[0].creImgId }"/>
		<input type="hidden" title="생성이미지명" name="creImgNm" id="creImgNm" value="${bldVo[0].creImgNm }"/>
		<input type="hidden" title="이미지태그" name="imgTag" id="imgTag" value="${bldVo[0].imgTag }"/>
		<input type="hidden" title="생성자" name="creUserId" id="creUserId" value="${bldVo[0].creUserId }"/>
		<input type="hidden" title="최종빌드버전" name="lastBldVer" id="lastBldVer" value="${bldVo[0].lastBldVer }"/>
		<input type="hidden" title="최종빌드일시" name="lastBldDttm" id="lastBldDttm" value="${bldVo[0].lastBldDttm }"/>
		<input type="hidden" title="빌드이력Id" name="bldHstryId" id="bldHstryId" value="${bldVo[0].bldHstryId }"/>
		<input type="hidden" title="빌드명" name="bldNm" id="bldNm" value="${bldVo[0].bldNm }"/>
		<input type="hidden" title="저장소유형코드" name="repoTyCd" id="repoTyCd" value="${bldVo[0].repoTyCd }"/>
		<input type="hidden" title="빌드상태코드" name="bldStatCd" id="bldStatCd" value="${bldVo[0].bldStatCd }"/>
		 <!--기존값  -->
		<input type="hidden" title="기존베이스이미지ID" name="originBasImgId" id="originBasImgId" value="${bldVo[0].basImgId }"/>
		<input type="hidden" title="기존git저장소" name="originRepoAddr" id="originRepoAddr" value="${bldVo[0].repoAddr }"/>
		<input type="hidden" title="기존Git보안키" name="originScrtkyId" id="originScrtkyId" value="${bldVo[0].scrtkyId }"/>
		<input type="hidden" title="기존Git브랜치" name="originGitBrnchNm" id="originGitBrnchNm" value="${bldVo[0].gitBrnchNm }"/>
		<input type="hidden" title="기존Git빌드최상위 경로" name="originGitBestPath" id="originGitBestPath" value="${bldVo[0].gitBestPath }"/>
	<!-- 수평형 테이블 -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
	  		<table class="table table-horizon">
	  		<caption>빌드 기본 정보 테이블</caption>
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
						<th>부처</th>
						<td><c:out value="${bldVo[0].institutionNm }" /></td>
						<th>업무</th>
						<td><c:out value="${bldVo[0].jobNm }" /></td>
						<th>센터</th>
						<td><c:out value="${bldVo[0].regionNm }" /></td>
						<th>존</th>
						<td><c:out value="${bldVo[0].zoneNm }" /></td>
					</tr>
					<tr>
						<th>망구분</th>
						<td><c:out value="${bldVo[0].netNm }" /></td>
						<th>자원풀</th>
						<td><c:out value="${bldVo[0].rsrcPoolNm }" /></td>
						<th>서비스명</th>
						<td><c:out value="${bldVo[0].servcNm }" /></td>
						<th>빌드이미지명</th>
						<td><c:out value="${bldVo[0].creImgNm }" /></td>
					</tr>
					<tr>
						<th>빌드버전</th>
						<td><c:out value="${bldVo[0].lastBldVer}" /></td>
						<th>빌드상태</th>
						<td>
						<c:choose>
								<c:when test="${bldVo[0].bldStatCd eq '01'}">
									<span title="${bldVo[0].bldStatNm }" class="status status-blue"><c:out value="${bldVo[0].bldStatNm}"/></span>
								</c:when>
								<c:when test="${bldVo[0].bldStatCd eq '02'}">
									<span title="${bldVo[0].bldStatNm }" class="status status-green"><c:out value="${bldVo[0].bldStatNm}"/></span>
								</c:when>
								<c:when test="${bldVo[0].bldStatCd eq '03'}">
									<span title="${bldVo[0].bldStatNm }" class="status status-red"><c:out value="${bldVo[0].bldStatNm}"/></span>
								</c:when>
								<c:when test="${bldVo[0].bldStatCd eq '04'}">
									<span title="${bldVo[0].bldStatNm }" class="status status-aqua"><c:out value="${bldVo[0].bldStatNm}"/></span>
								</c:when>
								<c:when test="${bldVo[0].bldStatCd eq '07'}">
									<span title="${bldVo[0].bldStatNm }" class="status status-red"><c:out value="${bldVo[0].bldStatNm}"/></span>
								</c:when>
								<c:otherwise><span title="${bldVo[0].bldStatNm }" class="status status-aqua"><c:out value="${bldVo[0].bldStatNm}"/></span></c:otherwise>
							</c:choose>
						</td>
						<th>생성자</th>
						<td><c:out value="${bldVo[0].creUserNm }" /></td>
						<th>생성일시</th>
						<td><c:out value="${bldVo[0].creDttm }" /></td>
					</tr>
					<tr>
						<th>수정자</th>
						<td colspan="3"><c:out value="${bldVo[0].updtUserNm }" /></td>
						<th>수정일시</th>
						<td colspan="3"><c:out value="${bldVo[0].updtDttm }" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="box">
		<div class="box-header">
			<h3 class="box-title">설정 정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<table class="table table-horizon">
			<caption>빌드 설정 정보 테이블</caption>
				<colgroup>
					<col class="col10">
					<col class="col15">
					<col class="col10">
					<col class="col15">
				</colgroup>
				<tbody>
					<tr>
						<th><label for="repoAddr"><span class="text-red">*</span>Git 저장소 URL경로</label></th>
						<td>
							<input id="repoAddr" name="repoAddr" title="Git저장소URL경로" Class="form-control essential" value="${bldVo[0].repoAddr }"/>
						</td>
						<th><label for="scrtkyId"><span class="text-red">*</span>Git 보안키</label></th>
						<td>
						<div class="input-group">
							<select id="scrtkyId" name="scrtkyId" class="form-control input-sm essential" >
								<c:forEach var="vo" items="${selectScrtky}">
									<c:choose>
										<c:when test='${bldVo[0].scrtkyId eq vo.scrtkyId}'><option value="${vo.scrtkyId }" selected="selected">${vo.scrtkyId }</option></c:when>
										<c:when test='${bldVo[0].scrtkyId ne vo.scrtkyId}'><option value="${vo.scrtkyId }">${vo.scrtkyId }</option></c:when>
									</c:choose>
								</c:forEach>
							</select>
							<div class="input-group-btn">
								<button class="btn btn-sm btn-function" onclick="openScrtkySearch();return false;">보안키 생성</button>
							</div>
						</div>
						</td>
					</tr>
					<tr>
						<th><label for="gitBrnchNm">Git 브랜치</label></th>
						<td><input id="gitBrnchNm" name="gitBrnchNm" title="Git브랜치" Class="form-control" value="${bldVo[0].gitBrnchNm }"/></td>
						<th><label for="gitBestPath">Git 빌드 최상위 경로</label></th>
						<td><input id="gitBestPath" name="gitBestPath" title="Git 빌드 최상위 경로" Class="form-control" value="${bldVo[0].gitBestPath }"/></td>
					</tr>
					<tr>
					<th><label for="basImgNm"><span class="text-red">*</span>베이스이미지</label></th>
	                    <td colspan="3">
	                        <div class="input-group">
	                            <input type="text" name="basImgNm" id="basImgNm" class="form-control" placeholder="베이스이미지를 선택해주세요" disabled="disabled" value="${bldVo[0].basImgNm}" title="베이스이미지" />
	                            <div class="input-group-btn">
	                                <button type="button" class="btn" data-toggle="tooltip" title="검색" data-original-title="검색" onclick="fn_openBaseImgSearch();">
	                                    <i class="fa fa-search"></i>
	                                </button>
	                            </div>
	                        </div>
	                    </td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</form:form>
	<!-- 수평형 테이블 -->
	<div class="box detail-list-box">
		<div class="box-header">
			<h3 class="box-title">빌드 이력</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>
		<!-- box-body -->
		<div class="box-body no-padding detail-list-body" >
			<table class="table table-vertical table-layout-fixed" id="bldHstryTable">
			<caption>빌드 이력 테이블</caption>
				<colgroup>
					<col class="col5">
					<col class="col5">
					<col class="col10">
					<col class="col20">
					<col class="col5">
					<col class="col15">
				</colgroup>
				<thead>
					<tr>
						<th>No.</th>
						<th>상태</th>
						<th>버전</th>
						<th>빌드이미지명</th>
						<th>최신여부</th>
						<th>생성일시</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bldList" items="${bldVo}" varStatus="i">
						<tr>
							<td class="alignC">
							<%-- <c:out value="${i.count }" /> --%>

							<c:out value="${(fn:length(bldVo)-i.count)+1}" />
							</td>
							<td class="alignC">
							<c:choose>
								<c:when test="${bldList.bldStatCd eq '01'}">
									<span title="${bldList.bldStatNm }" class="status status-blue"><c:out value="${bldList.bldStatNm}"/></span>
								</c:when>
								<c:when test="${bldList.bldStatCd eq '02'}">
									<span title="${bldList.bldStatNm }" class="status status-green"><c:out value="${bldList.bldStatNm}"/></span>
								</c:when>
								<c:when test="${bldList.bldStatCd eq '03'}">
									<span title="${bldList.bldStatNm }" class="status status-red"><c:out value="${bldList.bldStatNm}"/></span>
								</c:when>
								<c:when test="${bldList.bldStatCd eq '04'}">
									<span title="${bldList.bldStatNm }" class="status status-aqua"><c:out value="${bldList.bldStatNm}"/></span>
								</c:when>
								<c:when test="${bldList.bldStatCd eq '07'}">
									<span title="${bldList.bldStatNm }" class="status status-red"><c:out value="${bldList.bldStatNm}"/></span>
								</c:when>
								<c:otherwise><span title="${bldList.bldStatNm }" class="status status-aqua"><c:out value="${bldList.bldStatNm}"/></span></c:otherwise>
							</c:choose>

							</td>
							<td class="alignC"><c:out value="${bldList.bldVer}" /></td>
							<td class="alignL"><c:out value="${bldList.creImgNm}" /></td>
							<c:choose>
								<c:when test='${bldList.bldVer eq bldList.lastBldVer}'>
									<td><c:out value="Y" /></td>
								</c:when>
								<c:when test='${bldList.bldVer ne bldList.lastBldVer }'>
									<td><c:out value="N" /></td>
								</c:when>
							</c:choose>

		                    <td class="alignC"><c:out value="${bldList.creDttm}" /></td>
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
			<button type="button" class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="" data-original-title="뒤로" onclick="fn_selectBldList();"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<c:if test="${'Y' eq bldVo[0].ctlTrgtYn }">
				<menu:authorize>
					<button class="btn btn-sm btn-hover-blue" data-toggle="tooltip"  data-original-title="저장"  onclick="fn_updateBld();"><i class="fa fa-check"></i></button>
				</menu:authorize>
			</c:if>
		</div>
	</div>
</div>

<script type="text/javascript">
//빌드 상태조회
$(function() {
	var stat = "${ bldVo[0].bldStatCd}";
 	if(stat == '01' || "" == stat) setInterval(function(){ fn_selectBldStat(); }, 30*1000);
});

function fn_selectBldStat(){

	var options = {
			type: 'get',
			dataType: 'json',
			success: selectBldStatResultHandler,
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
 	$('#bldVo').attr('action', '<c:url value="selectBldStat.do"/>');
	$('#bldVo').ajaxSubmit(options);
}
function selectBldStatResultHandler(result){
	if(result.success){
		if(result.procType == "update") {
			location.reload();
		}
	}
	else{
		jAlert(result.messageList);
	}
}
//뒤로
function fn_selectBldList(){
	location.href = '<c:url value="selectBldList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'servcSeq' && pageParam.key ne 'bldId' && pageParam.key ne 'servcAreaSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}
//베이스이미지 선택 팝업
function fn_openBaseImgSearch(){

	if($('#servcAreaId').val()=='') {
		jAlert("서비스영역을 선택해 주세요.");
		return;
	}

	var params = {
		      "regionId" : $('#regionId').val(),
		      "zoneId" : $('#zoneId').val(),
		      "netClCd" : $('#netClCd').val(),
		      "rsrcPoolId" : $('#rsrcPoolId').val()};

	var url = contextPath+'/cpt/rsrc/atmscl/servc/selectBaseImgListPView.do';
	var width = 1000;
	var height = 620;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, params, args);
}

//베이스이미지 선택 콜백
function fn_selectedBaseImg(baseImg){

	$('#basImgId').val(baseImg.imgId);
	$('#basImgVer').val(baseImg.imgVer);
	$('#basImgNm').val(baseImg.imgNm);
}
//보안키 생성 팝업화면 호출
function openScrtkySearch() {

	var servcAreaSeq = $('#servcAreaSeq').val();
	var servcAreaId = $('#servcAreaId').val();
	var regionId = $('#regionId').val();
	var zoneId = $('#zoneId').val();
	var netClCd = $('#netClCd').val();
	var rsrcPoolId = $('#rsrcPoolId').val();

	var params = {"servcAreaSeq" : servcAreaSeq,
			      "servcAreaId" : servcAreaId,
			      "regionId" : regionId,
			      "zoneId" : zoneId,
			      "netClCd" : netClCd,
			      "rsrcPoolId" : rsrcPoolId};

	var url = contextPath+'/cpt/rsrc/atmscl/servc/insertScrtkyP.do';
	var width = 1000;
	var height = 400;
	var posY  = (screen.width - width) / 2;
	var posX =  (screen.height - height) / 2;
	var args = {width:width , height:height, posX : posX , posY : posY};
	windowOpen(url, params, args);
}

//보안키 정보를 셋팅힌다.
function fn_setScrtky(servcAreaSeq) {
	location.reload();
}


function fn_bldRun(){
	if(!fn_form_validation("bldVo")){
		return;
	}

	jConfirm('빌드 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: bldRunResultHandler,
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

		$('#bldVo').attr('action', '<c:url value="bldRun.do"/>');
		$('#bldVo').ajaxSubmit(options);

	});
}
//빌드 결과 콜백
function bldRunResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			location.reload();
		});
	}
	else{
		alert_message(result.messageList)
	}
}
$("#bldHstryTable").DataTable( {
	dom: 'Zlfrtip',
	paging : false,
	searching : false,
	info : false,
	bAutoWidth : false,
	aoColumns : [
		{sWidth : "30px" }, //No
		{sWidth : "80px" }, //상태
		{sWidth : "130px" }, //빌드이미지명
		{sWidth : "50px" }, //최신여부
		{sWidth : "50px" },//버전
		{sWidth : "80px" }//생성일자
	],
    order : [ [ 2, "desc" ] ]

});
function fn_refresh(){
	location.reload();
}

function fn_updateBld(){
	if(!fn_form_validation("bldVo")){
		return;
	}

	jConfirm('저장 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: bldUpdateResultHandler,
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

		$('#bldVo').attr('action', '<c:url value="updateBld.do"/>');
		$('#bldVo').ajaxSubmit(options);

	});
}
//저장 결과 콜백
function bldUpdateResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			location.reload();
		});
	}
	else{
		alert_message(result.messageList)
	}
}
</script>