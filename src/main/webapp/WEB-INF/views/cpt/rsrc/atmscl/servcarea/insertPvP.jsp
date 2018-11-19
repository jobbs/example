<%--
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre>스토리지 추가 화면</pre>
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
 * 2017. 05. 13.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="listParam" value="${cf:queryString(param, 'paginationInfo.currentPageNo') }"></c:set>

<div class="col-box-100">
	<form:form id="pvVo" commandName="pvVo">
		<form:hidden path="servcAreaSeq" title="서비스영역SEQ"  />
		<form:hidden path="rsrcPoolId" title="자원풀ID"  />
		<div class="box">
			<div class="box-body no-padding" style="overflow-x:auto;">
				<table class="table table-horizon">
                        <caption>스토리지 정보</caption>
                        <colgroup>
                            <col class="col10">
							<col class="col40">
							<col class="col10">
							<col class="col40">
                        </colgroup>
                        <tbody>
                        <tr>
                        	<th>
                        		<label for="strgClCd"><span class="text-red">*</span>스토리지 구분</label>
                        	</th>
                            <td>
                               	<div class="cell-body">
			                		<nform:selectCode
			                            parentCd="305"
			                            parentGrpCd="104"
			                            name="strgClCd"
			                            id="strgClCd"
			                            whole="true"
			                            wholeText="선택해주세요."
			                            cssClass="form-control input-sm essential"
			                            title="스토리지 구분"
			                            value="${pvVo.strgClCd}" />
			            		</div>
			            	</td>
                        	<th><label for="pvNm"><span class="text-red">*</span>스토리지명</label></th>
						    <td>
						    	<form:input path="pvNm" title="스토리지명" cssClass="form-control essential" value="" maxlength="50"/>
							</td>
						</tr>
						<tr>
                            <th>
                            	<label for="accssModeClCd"><span class="text-red">*</span>접근 모드</label>
                            </th>
                            <td>
                            	<div class="cell-body">
			                		<nform:selectCode
			                            parentCd="306"
			                            parentGrpCd="105"
			                            name="accssModeClCd"
			                            id="accssModeClCd"
			                            whole="true"
			                            wholeText="선택해주세요."
			                            cssClass="form-control input-sm essential"
			                            title="접근 모드"
			                            value="${pvVo.accssModeClCd}" />
			            		</div>
			            	</td>
                          	<th><label for="strgAsgnCapa"><span class="text-red">*</span>스토리지 용량</label></th>
						    <td>
						    	<form:input path="strgAsgnCapa" title="스토리지명" cssClass="form-control essential" value="" maxlength="50"/>
							</td>
                        </tr>
                    </tbody>
                </table>
			</div>


		<!-- /box-body -->
	</div>
	</form:form>
</div>
<!-- popup 버튼 -->
<div class="col-box-100">
  <div class="button">
  	<button type="button" class="btn btn-dark" onclick="fn_createPV()">추가</button>
  	<button type="button" class="btn close-window" >닫기</button>
   </div>
</div>
<!-- /popup 버튼 -->

<script type="text/javascript">

function fn_createPV() {

	if(!fn_form_validation("pvVo")){
		return;
	}

	var pvVo = {
			'strgClCd' : $("#strgClCd").val()
			,'strgClCdNm' : $("#strgClCd option:selected").text()
			, 'pvNm' : $("#pvNm").val()
			, 'accssModeClCd' : $("#accssModeClCd").val()
			, 'accssModeClCdNm' : $("#accssModeClCd option:selected").text()
			, 'strgAsgnCapa': $("#strgAsgnCapa").val()
			, 'rsrcPoolId' : $("#rsrcPoolId").val()
	};

	var options = {
		url : '<c:url value="insertPv.do" />',
		data : JSON.stringify(data),
		type : 'POST',
		dataType : 'json',
		contentType : "application/json;charset=UTF-8",
		success : function(result) {
			if (result.success) {
				jAlert('저장 되었습니다.', function() {
					opener.location.reload(true);
					self.close();
				});
			} else {
				jAlert('저장 중 오류가 발생하였습니다.');
			}
		},
		beforeSend : function() {
			$.ncmsLoding.startFullScreen();
		},
		complete : function() {
			$.ncmsLoding.remove();
		},
		error : function(xhr, textStatus, errorThrown) {
			jAlert('오류가 발생하였습니다.');
		}
	};
	jConfirm('서비스영역관리 화면에서 입력중인 데이터가 있을경우 반영되지 않습니다. \n스토리지를 생성 하시겠습니까?)', function() {
		$.ajax(options);
	});



	/*
	var dspthGrdCdList = [];
		var dspthTyCdList = [];
		var dspthTrgtList = [];
		var user = {};
		var dqpQuthrDspthYn = $('input:checkbox[name=dqpQuthrDspthYn]:checked')
				.val();
		$('input:checkbox[name="dspthGrdCdList"]:checked').each(function() {
			dspthGrdCdList.push(this.value);
		});
		if (dspthGrdCdList.length == 0) {
			jAlert('통보등급을 선택하시기 바랍니다.');
			return false;
		}
		$('input:checkbox[name="dspthTyCdList"]:checked').each(function() {
			dspthTyCdList.push(this.value);
		});
		if (dspthTyCdList.length == 0) {
			jAlert('통보형식을 선택하시기 바랍니다.');
			return false;
		}
		$('input:checkbox', '#dspthTable').each(function() {
			user = {
				'userId' : this.value
			};
			dspthTrgtList.push(user);
		});
		if (dspthTrgtList.length == 0) {
			jAlert('통보대상을 입력 바랍니다.');
			return false;
		}
		var data = {
			'dspthGrdCdList' : dspthGrdCdList,
			'dspthTyCdList' : dspthTyCdList,
			'dspthTrgtList' : dspthTrgtList,
			'dqpQuthrDspthYn' : dqpQuthrDspthYn,
			'trgtSrvrClCd' : $('#trgtSrvrClCd').val(),
			'thresTrgtSrvrSeq' : $('#thresTrgtSrvrSeq').val(),
			'id' : $('#id').val(),
			'gubun' : "PM",
			'regionId' : $('#regionId').val(),
			'netId' : $('#netId').val(),
			'zoneId' : $('#zoneId').val(),
			'rsrcPoolId' : $('#rsrcPoolId').val(),
			'clstrSeq' : $('#clstrSeq').val(),
			'pmSeq' : $('#pmSeq').val(),
			'vmSeq' : $('#vmSeq').val(),
			'jobId' : $('#jobId').val(),
			'institutionId' : $('#institutionId').val(),
			'eqpAuthrDspthYn' : $(':checkbox[name=eqpAuthrDspthYn]:checked')
					.val()
		};

		var options = {
			url : '<c:url value="updateNtceConf.do" />',
			data : JSON.stringify(data),
			type : 'POST',
			dataType : 'json',
			contentType : "application/json;charset=UTF-8",
			success : function(result) {
				if (result.success) {
					jAlert('저장 되었습니다.', function() {
						opener.location.reload(true);
						self.close();
					});
				} else {
					jAlert('저장 중 오류가 발생하였습니다.');
				}
			},
			beforeSend : function() {
				$.ncmsLoding.startFullScreen();
			},
			complete : function() {
				$.ncmsLoding.remove();
			},
			error : function(xhr, textStatus, errorThrown) {
				jAlert('오류가 발생하였습니다.');
			}
		};
		jConfirm('저장하시겠습니까?', function() {
			$.ajax(options);
		});
	*/


	/*
	var pvVo = {
			strgClCd : $("#strgClCd").val()
			,strgClCdNm : $("#strgClCd option:selected").text()
			, pvNm : $("#pvNm").val()
			, accssModeClCd : $("#accssModeClCd").val()
			, accssModeClCdNm : $("#accssModeClCd option:selected").text()
			, strgAsgnCapa: $("#strgAsgnCapa").val()
	};
	window.opener.fn_selectedPv(pvVo);
	self.close();
	*/



}


</script>