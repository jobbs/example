<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 05. 17.
 * @lastmodified 2017. 05. 17.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 19.     x         v1.0             최초생성
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

<form:form id="updateBaseImg" commandName="baseImgVo" action="updateBaseImg.do">
	<form:hidden path="rsrcPoolId" title="자원풀ID"  />
	<form:hidden path="imgId" title="이미지ID"  />
	<form:hidden path="servcAreaSeq" title="서비스영역SEQ"  />
	<form:hidden path="basImgYn" title="베이스이미지여부" />

	<div class="col-box-100 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">기본 정보</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>베이스이미지 기본정보</caption>
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
							<td><c:out value="${baseImgVo.regionNm }"/></td>
							<th>존</th>
							<td><c:out value="${baseImgVo.zoneNm }"/></td>
							<th>망구분(망)</th>
							<td><c:out value="${baseImgVo.netNm }"/></td>
							<th>자원풀</th>
							<td><c:out value="${baseImgVo.rsrcPoolNm }"/></td>
						</tr>
						<tr>
							<th><label for="imgNm"><span class="text-red">*</span>이미지명</label></th>
							<td colspan="3">
								<form:input path="imgNm" type="text" class="form-control essential"  title="이미지명" maxlength="50" />
							</td>
							<th><label for="useYn"><span class="text-red">*</span>사용여부</label></th>
							<td colspan="3">
								<form:select path="useYn" cssClass="form-control input-sm">
									<form:option value="Y">사용</form:option>
									<form:option value="N">미사용</form:option>
								</form:select>
							</td>
						</tr>
						<tr>
							<th>생성자</th>
							<td><c:out value="${baseImgVo.creUserNm }"/></td>
							<th>생성일시</th>
							<td><c:out value="${baseImgVo.creDttm }"/></td>
							<th>수정자</th>
							<td><c:out value="${baseImgVo.updtUserNm }"/></td>
							<th>수정일시</th>
							<td><c:out value="${baseImgVo.updtDttm }"/></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="col-box-100 detail-col">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">상세정보</h3>
			</div>
			<div class="box-body no-padding">
				<table class="table table-horizon">
					<caption>상세정보</caption>
					<colgroup>
						<col class="col10">
						<col class="col23">
						<col class="col10">
						<col class="col23">
						<col class="col10">
						<col class="col24">
					</colgroup>
					<tbody>
						<tr>
							<th>
								<label for="imgTyCd"><span class="text-red">*</span>이미지유형</label>
							</th>
							<td>
								<nform:selectCode
			                            parentCd="300"
			                            parentGrpCd="099"
			                            name="imgTyCd"
			                            id="imgTyCd"
			                            title="이미지유형"
			                            whole="true"
			                            wholeText="선택하세요"
			                            cssClass="form-control input-sm essential"
			                            value="${baseImgVo.imgTyCd}"  />
							</td>
					  		<th>
								<label for="imgVer"><span class="text-red">*</span>버전</label>
							</th>
							<td>
								<form:input path="imgVer"  type="text" class="form-control essential"  title="버전" maxlength="10"  />
							</td>
							<th>용량(GB)</th>
							<td class="alignR"><c:out value="${baseImgVo.imgCapa }"/></td>
						</tr>
						<tr>
						  <th><span class="text-red">*</span>비고</th>
	                      <td colspan="5">
	                          <form:textarea path="rmk" cssClass="form-control essential" title="비고" rows="3" maxlength="1000" />
	                      </td>
					</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="col-box-100">
		<div class="edit-btn-group">
			<div class="pull-left btns">
				<button type="button" class="btn btn-hover-gray" data-toggle="tooltip" data-original-title="뒤로" onclick="fn_selectBaseImgList();"><i class="fa fa-arrow-left"></i></button>
			</div>
			<menu:authorize onlyOprAdm="true">
				<div class="pull-right btns">
					<button type="button" class="btn btn-hover-blue" data-toggle="tooltip" data-original-title="저장" onclick="doSubmit();"><i class="fa fa-check"></i></button>
				</div>
			</menu:authorize>
		</div>
	</div>
</form:form>
<script type="text/javascript">

	// 뒤로 이동
	function fn_selectBaseImgList(){
		location.href = '<c:url value="selectBaseImgList.do"><c:forEach var="curParam" items="${param}"><c:if test="${curParam.key ne 'imgId' && curParam.key ne 'servcAreaSeq' && curParam.key ne 'baseImgRsrcPoolId'}"><c:param name="${curParam.key}" value="${curParam.value}" /></c:if></c:forEach></c:url>';
	}

	// submit
	function doSubmit(result){

		if(!fn_form_validation("updateBaseImg")){
			return;
		}

		jConfirm('베이스이미지 정보를 저장하시겠습니까?', fn_updateBaseImg);
	}

	// 베이스이미지 수정 처리
	function fn_updateBaseImg(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_pageMove,
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error: function(xhr, textStatus, errorThrown){
				alert('오류 발생');
			}
		};
		$('#updateBaseImg').ajaxSubmit(options);
	}

	// 콜백 / 화면이동
	function fn_pageMove(result){

		if(result.success){
			jInfo("저장되었습니다.", function(){
				if(result.procType == "update") {
					location.href = '<c:url value="selectBaseImgList.do"/>';
				}
			});
		}else{
			jAlert(result.messageList);
		}
	}

</script>