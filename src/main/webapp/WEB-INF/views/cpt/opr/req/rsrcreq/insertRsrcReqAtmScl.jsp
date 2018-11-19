<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자동확장 요청 화면</pre>
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 04. 28.
 * @lastmodified 2017. 04. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     x         v1.0             최초생성
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

<script type="text/javascript" src="<c:url value="/resources/js/common/validation.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/FileUtils.js" />" charset="UTF-8"></script>

<form:form commandName="rsrcReqMngVo" enctype="multipart/form-data">
<form:hidden path="testYn" title="테스트여부" />
<form:hidden path="rsrcReqUserId" title="요청자ID" />
<form:hidden path="reqInstitutionId" title="요청자부서ID" />
<!-- 등록/상세 영역 -->
<div class="col-box-100 detail-col">

    <!--  기본정보 시작  -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">기본정보</h3>
			<div class="box-tools">
				<div class="pull-right">
				</div>
			</div>
		</div>

		<div class="box-body no-padding">
	        <table class="table table-hover table-horizon">
				<caption>자동확장 기본정보</caption>
				<colgroup>
					<col class="col15">
					<col class="col35">
					<col class="col15">
					<col class="col35">
				</colgroup>
				<tbody>
					<tr>
					    <th><label for=sbjct><span class="text-red">*</span>제목</label></th>
					    <td>
					        <form:input path="sbjct" title="제목" cssClass="form-control essential" value="" maxlength="100"/>
					    </td>
					    <th><label for="rsrcReqTyCd"><span class="text-red">*</span>요청유형</label></th>
                        <td>
                            <div class="input-group">
                               <div class="cell-body">
                                    <nform:selectCode
                                                parentCd="107"
                                                parentGrpCd="008"
                                                extra1="02"
                                                name="rsrcReqTyCd"
                                                id="rsrcReqTyCd"
                                                whole="true"
                                                wholeText="선택하세요"
                                                value="${searchVo.rsrcReqTyCd}"
                                                cssClass="form-control input-sm essential" title="요청유형" />
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="rsrcReqUserNm"><span class="text-red">*</span>요청자</label></th>
                        <td>
                            <div class="input-group">
                            	<form:input path="rsrcReqUserNm" title="요청자" cssClass="form-control essential" value="" maxlength="50" readonly="true"/>

                                <div class="input-group-btn">
                                    <button type="button" class="btn" data-toggle="tooltip" title="" data-original-title="검색" onclick="openUserSearch();">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </td>
                        <th><label for="ticktNo"><span class="text-red">*</span>티켓번호</label></th>
                        <td>
                            <form:input path="ticktNo" title="티켓번호" cssClass="form-control essential" value="" maxlength="50"/>
                        </td>
					</tr>
	            </tbody>
		    </table>
	    </div>
    </div>
	<!--  기본정보 끝  -->

	<!--  상세정보 시작  -->
	<div class="box">
        <div class="box-header">
            <h3 class="box-title">상세정보</h3>
        </div>

		<div class="box-body no-padding">
		    <table class="table table-horizon">
				<caption>자동확장요청 상세 정보</caption>
				<colgroup>
					<col class="col15">
                    <col class="col85">
				</colgroup>
				<tbody>
					<tr>
						<th><span class="text-red">*</span>센터</th>
						<td>

							<form:select path="regionId" cssClass="form-control essential input-sm">
				              	<c:forEach var="rv" items="${regionList}" varStatus="regionVal">
				              		<form:option value="${rv.regionId}">${rv.regionNm}</form:option>
				              	</c:forEach>
							</form:select>
						</td>
					</tr>
					<tr>
					  <th><span class="text-red">*</span>요청내용</th>
                      <td>
                          <form:textarea path="reqCn" cssClass="form-control essential" title="요청내용" rows="5" maxlength="1000" />
                      </td>
					</tr>
					<tr>
                        <th><span class="text-red">*</span>파일첨부</th>
                        <td>
                            <div class="file-form" id="fileSigleDiv"></div>
                            <script type="text/javascript">
                                $("#fileSigleDiv").createSelectboxFile({multiType : 'single' } );
                            </script>
                        </td>
                    </tr>
				</tbody>
			</table>
		</div>
	</div>
	<!--  쿼터정보 끝  -->

</div>
</form:form>

<!-- 페이지 버튼 영역 -->
<div class="col-box-100">
	<div class="edit-btn-group">
		<div class="pull-left btns">
			<button class="btn btn-sm btn-hover-gray" data-toggle="tooltip" title="뒤로" data-original-title="뒤로" onclick="fn_selectRsrcReqMngList()"><i class="fa fa-arrow-left"></i></button>
		</div>
		<div class="pull-right btns">
			<menu:authorize onlyOprAdm="true">
				<button class="btn btn-sm btn-hover-green" data-toggle="tooltip" title="요청" data-original-title="요청"  onclick="fn_insertRsrcReqMngAtmScl()"><i class="fa fa-check"></i></button>
			</menu:authorize>
		</div>
	</div>
</div>

<script type="text/javascript">


// 뒤로 버튼 클릭 시
function fn_selectRsrcReqMngList(){
	location.href = '<c:url value="selectRsrcReqList.do"><c:forEach var="pageParam" items="${param}"><c:if test="${pageParam.key ne 'servcAreaSeq'}"><c:param name="${pageParam.key}" value="${pageParam.value}" /></c:if></c:forEach></c:url>';
}

// 생성 버튼 클릭 시
function fn_insertRsrcReqMngAtmScl(){

	if(!fn_form_validation("rsrcReqMngVo")){
		return;
	}

	if($('#atchFile').val()==''){
		jAlert("첨부파일을(nTOPS에서 해당 티켓요청시 첨부한 파일) 등록해주세요.");
		return;
	}



	$('#testYn').val("N");

	jConfirm('요청 하시겠습니까?', function(){

		var options = {
			type: 'post',
			dataType: 'json',
			success: fn_insertRsrcReqMngAtmSclResultHandler,
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

		$('#rsrcReqMngVo').attr('action', '<c:url value="insertRsrcReqMngAtmScl.do"/>');
		$('#rsrcReqMngVo').ajaxSubmit(options);

	});
}

// 생성 결과 콜백
function fn_insertRsrcReqMngAtmSclResultHandler(result){

	if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

	if(result.success){
		jInfo(result.messageList, function(){
			fn_selectRsrcReqMngList();
		});
	}
	else{
		alert_message(result.messageList)
	}
}


//사용자에 대한 단일 선택
$(document).bind('selectUser',setSelectUser);
//부처에 대한 단일 선택 이벤터 함수
function setSelectUser(evt) {
    var val = evt.datas;
    var userInfo = val.institutionNm + "/"+ val.userNm;
    $('#rsrcReqMngVo input[name="rsrcReqUserNm"]').val(userInfo);
    $('#rsrcReqMngVo input:hidden[name="rsrcReqUserId"]').val(val.userId);
    $('#rsrcReqMngVo input:hidden[name="reqInstitutionId"]').val(val.institutionId);

}

</script>
