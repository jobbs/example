<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 11. 15.
 * @lastmodified 2016. 11. 15.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 15.     박봉춘         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<c:url var="detailUrl" value="selectUser.do">
	<c:forEach var="curParam" items="${param }">
		<c:param name="${curParam.key }" value="${curParam.value }">
		</c:param>
	</c:forEach>
</c:url>

<c:url var="listUrl" value="selectUserList.do">
	<c:forEach var="curParam" items="${param }">
		<c:if test="${curParam.key ne 'userId'}">
			<c:param name="${curParam.key }" value="${curParam.value}"></c:param>
		</c:if>
	</c:forEach>
</c:url>


<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/sedit2/js/HuskyEZCreator.js" />" charset="UTF-8"></script>


<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<form:form commandName="vo">
				<form:hidden path="institutionId"/>
				<table class="table table-horizon">
					<caption>사용자 관리 등록 테이블</caption>
					<colgroup>
						<col class="col20">
						<col class="col30">
						<col class="col20">
						<col class="col30">
					</colgroup>
					<tbody>
						<tr>
							<th><span class="text-red">*</span> 사용자ID</th>
							<td colspan="3">
							<c:choose>
								<c:when test="${vo.userId eq null }">
									<div class="input-group">
										<form:input path="userId" cssClass="form-control essential" title="사용자ID" maxlength="30" />
										<div class="input-group-btn">
											<button type="button" class="btn btn-function"  onclick="checkuserId()">중복검사</button>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<c:out value="${vo.userId}"/>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
						<tr>
							<th><c:if test="${vo.userId eq null }"><span class="text-red">*</span></c:if> 비밀번호</th>
							<td colspan="3">
								<input name="passwd" id="passwd" type="password" class="form-control<c:if test="${vo.userId eq null }"> essential</c:if>" title="비밀번호" maxlength="200"/>
								<c:if test="${vo.userId ne null }">
								<p class="comment">비밀번호 변경시 입력 바랍니다.</p>
								</c:if>
							</td>
						</tr>
						<tr>
							<th><span class="text-red">*</span> 사용자명</th>
							<td colspan="3"><form:input path="userNm" cssClass="form-control essential" title="사용자명" maxlength="30"/></td>
						</tr>
						<tr>
							<th>부처</th>
							<td colspan="3">
								<div class="input-group">
									<form:input path="institutionNm" cssClass="form-control" title="부처" maxlength="100" onclick="openInsttSearch()"/>
									<div class="input-group-btn">
										<button type="button" class="btn btn-function"  onclick="openInsttSearch()">부처조회</button>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<th> 조직</th>
							<td><form:input path="orgnztNm" cssClass="form-control" title="조직" maxlength="100" /></td>
							<th> 직위</th>
							<td ><form:input path="ofcpsNm" cssClass="form-control" title="직위" maxlength="200" /></td>
						</tr>
						<tr>
							<th><span class="text-red">*</span> 이메일</th>
							<td colspan="3"><form:input path="email" cssClass="form-control onlyEmail essential input-sm" title="이메일" maxlength="200" /></td>
						</tr>
						<tr>
							<th> 전화번호</th>
							<td><form:input path="telno" cssClass="form-control onlyPhone" title="전화번호" maxlength="20" /></td>
							<th>내선 전화번호</th>
							<td><form:input path="lxtnNo" cssClass="form-control onlyPhone" title="내선 전화번호" maxlength="20" /></td>
						</tr>
						<tr>
							<th>핸드폰</th>
							<td colspan="3"><form:input path="mobile" cssClass="form-control onlyPhone" title="핸드폰" maxlength="20" /></td>
						</tr>
						<tr>
							<th>관리센터</th>
							<td>
								<nform:selectRegion
									name="mngRegionId"
									id="mngRegionId"
									wholeText="선택"
									value="${vo.mngRegionId }"
									cssClass="form-control" />
							</td>
							<th>사용자구분</th>
							<td>
								<form:hidden path="userClNm"/>
								<nform:selectCode
									parentCd="USRCL"
									parentGrpCd="088"
									name="userClCd"
									id="userClCd"
									wholeText="선택"
									value="${vo.userClCd }"
									cssClass="form-control"
									onchange="doChangeUserClcd()" />
							</td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</div>
</div>

<!-- 페이지 버튼 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<c:choose>
				<c:when test="${vo.userId ne null }">
					<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"
						title="" data-original-title="뒤로"
						onclick="goToUrl('${detailUrl}')">
						<i class="fa fa-arrow-left"></i>
					</button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip"
						title="" data-original-title="뒤로" onclick="goToUrl('${listUrl}')">
						<i class="fa fa-arrow-left"></i>
					</button>
				</c:otherwise>
			</c:choose>
		</div>

		<div class="pull-right btns">
			<button class="btn btn-sm btn-hover-green" data-toggle="tooltip"
				title="" data-original-title="저장"
				onclick="doSubmit()">
				<i class="fa fa-check"></i>
			</button>
		</div>
	</div>
</div>

<script type="text/javascript">
	var idCheckYn = false;

	$(document).bind('selectInstitution',setInstitution);
	function setInstitution(evt) {
		var job = evt.datas;
		$("#institutionNm").val( job.institutionNm);
		$("#institutionId").val( job.institutionId);
	}

	function doSubmit(result) {
		if (!fn_form_validation("vo")) {
			return;
		}
		if(!idCheckYn && ${vo.userId eq null }){
			jAlert('아이디 중복체크를 해주시기 바랍니다.');
			return;
		}
		jConfirm('사용자 정보를 저장하시겠습니까?', function() {
			var options = {
					type : 'post',
					dataType : 'json',
					success : function(result) {

						alert_message(result.messageList, function() {
							if (result.success) {
								if (result.procType == "insert") {
									location.href = "selectUserList.do";
								} else {
									location.href = "${detailUrl}";
								}
							}
						},(result.success?"INFO":""));
					},
					error : function(xhr, textStatus, errorThrown) {
						jAlert('오류 발생');
					}
			};

			$('#vo').ajaxSubmit(options);
		});
	}

	function checkuserId(){
		 $.post("selectUserIdCheck.do", {"userId": $("#userId").val()}, function(result) {
					if (result.success) {
						if(result.data){
							jAlert("중복된 아이디 입니다.");
							idCheckYn = false;
						}else{
							jAlert("사용가능한 아이디 입니다.");
							idCheckYn = true;
						}
					}
				}, "json");
	}

	function doChangeUserClcd() {
		var optionText = $("#userClCd option:selected").text();

		if( optionText == "전체" ) {
			optionText = "";
		}

		$("#userClNm").val( optionText );
	}

</script>