<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     김동훈         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>

<form:form commandName="cvo" method="get">
	<form:hidden path="trgtSrvrClCd" />
	<form:hidden path="thresTrgtSrvrSeq" />

	<form:hidden path="id" />
	<form:hidden path="gubun" />
	<form:hidden path="regionId" />
	<form:hidden path="netId" />
	<form:hidden path="zoneId" />
	<form:hidden path="rsrcPoolId" />
	<form:hidden path="clstrSeq" />
	<form:hidden path="pmSeq" />
	<form:hidden path="vmSeq" />
	<form:hidden path="institutionId" />
	<form:hidden path="jobId" />
</form:form>
<div class="col-box-100">
	<!-- <div class="info">
            <h2>알려드립니다.</h2>
            <p>- 하단 정보를 확인해 주세요.</p>
            <p>- 확인하신 정보가 맞으시면 선택을 눌러주세요.</p>
          </div>-->


	<div class="box">
		<div class="box-header">
			<h3 class="box-title">통보설정</h3>
			<!--<div class="box-tools">
                <div class="pull-right">
                  <button class="btn btn-sm btn-function" data-toggle="tooltip" title="" data-original-title="엑셀다운로드"><i class="fa fa-download"></i></button>
                </div>
              </div>-->
		</div>
		<!-- /box-header -->
		<div class="box-body no-padding">
			<table class="table table-horizon">
				<caption>통보설정</caption>
				<colgroup>
					<col class="col20">
					<col class="col30">
					<col class="colAuto">
				</colgroup>
				<tbody>
					<tr>
						<th>통보등급</th>
						<td><c:forEach var="vo" items="${grdCode }" varStatus="i">
								<input type="checkbox" name="dspthGrdCdList" value="${vo.cd }" id="dspthGrdCdList${vo.cd }"
									<c:if test="${cvo.dspthGrdCdList.contains(vo.cd)}">checked</c:if> />
								<label for="dspthGrdCdList${vo.cd}">${vo.cdNm }</label>
								<br>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<th>통보형식</th>
						<td><c:forEach var="vo" items="${ntceFormCode }" varStatus="i">
								<input type="checkbox" name="dspthTyCdList" value="${vo.cd }" id="dspthTyCdList${vo.cd }"
									<c:if test="${cvo.dspthTyCdList.contains(vo.cd)}">checked</c:if> />
								<label for="dspthTyCdList${vo.cd}">${vo.cdNm }</label>
								<br>
							</c:forEach>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</div>
<!-- /col -->
<!-- 셔틀 영역 -->
<div class="col-box-100 suttle-box suttle-horizon">
	<div class="col-cell-45 no-padding">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">검색</h3>
				<div class="box-tools input-group-box">
					<div class="input-group-cell pad-right-5">
						<div class="input-group">
							<select class="form-control input-sm" name="searchGubun" id="searchGubun" title="검색조건">
								<option value="02">사용자</option>
								<option value="01">ID</option>
							</select>
						</div>
					</div>
					<div class="input-group-cell">
						<div class="input-group">
							<input type="text" name="searchNm" id="searchNm" class="form-control input-sm" placeholder="Search" onKeyDown="fn_searchUserKeyDown(event)" title="검색명">

							<div class="input-group-btn">
								<button class="btn btn-sm" onclick="fn_searchUser();return false;">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="box-body no-padding" style="max-height: 200px; overflow-y: auto;">
				<table class="table table-hover table-vertical" id="searchTable">
					<caption>사용자 목록</caption>
					<colgroup>
						<col class="colAuto">
						<col class="col40">
						<col class="col40">
					</colgroup>
					<thead>
						<tr>
							<th></th>
							<th>ID</th>
							<th>사용자</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="3">데이터 조회를 위해서 검색하시기 바랍니다.</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="col-cell-10 no-padding suttle-btns">
		<div class="suttle-button" id="suttle-button1">
			<div class="btn-group-vertical">
				<button type="button" class="btn" onclick="fn_allRight()">
					<i class="fa fa-angle-double-right"></i>
				</button>
				<button type="button" class="btn" onclick="fn_right()">
					<i class="fa fa-angle-right"></i>
				</button>
				<button type="button" class="btn" onclick="fn_left()">
					<i class="fa fa-angle-left"></i>
				</button>
				<button type="button" class="btn" onclick="fn_allLeft()">
					<i class="fa fa-angle-double-left"></i>
				</button>
			</div>
		</div>
	</div>
	<div class="col-cell-45 no-padding">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">통보대상</h3>
				<div class="box-tools">
					<div class="input-group input-group-check">
						<!-- <input class="input-sm" id="label-set" type="checkbox" name="eqpAuthrDspthYn" id="eqpAuthrDspthYn" value="Y"> -->
						<input type="checkbox" class="input-sm" name="eqpAuthrDspthYn" id="eqpAuthrDspthYn" value="Y"
							<c:if test='${cvo.eqpAuthrDspthYn eq "Y" }'>checked</c:if> /> <label for="eqpAuthrDspthYn">장비권한자 통보</label>
					</div>
				</div>
			</div>
			<div class="box-body no-padding" style="max-height: 200px; overflow-y: auto;">
				<table class="table table-hover table-vertical" id="dspthTable">
					<caption>통보대상 목록</caption>
					<colgroup>
						<col class="colAuto">
						<col class="col40">
						<col class="col40">
					</colgroup>
					<thead>
						<tr>
							<th></th>
							<th>ID</th>
							<th>사용자</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${cvo.dspthTrgtList eq null or empty cvo.dspthTrgtList }">
								<tr>
									<td colspan="3">검색된 데이터가 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="vo" items="${cvo.dspthTrgtList }" varStatus="i">
									<tr>
										<td><input type="checkbox" name="idCheck" value="${vo.userId}" title="${vo.userNm }"></td>
										<td>${vo.userId}</td>
										<td>${vo.userNm}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</div>

<div class="col-box-100">
	<div class="button">
		<menu:authorize>
			<button class="btn btn-dark " onclick="fn_save();return false;">저장</button>
		</menu:authorize>
		<button class="btn close-window">취소</button>

	</div>
</div>
<!-- popup 버튼 -->
<!-- 		 -->
<!-- /popup 버튼 -->

<script>
	function fn_searchUser() {
		$.post(
						'<c:url value="/dsb/thrd/thrdConf/vmThrd/selectUserList.do"/>',
						{
							"searchGubun" : $('#searchGubun').val(),
							"searchNm" : $('#searchNm').val()
						},
						function(result) {
							if (result.success) {
								$('#searchTable tbody').empty();
								var len = result.data.length;
								var str = "";
								if (len > 0) {
									for (var i = 0; len > i; i++) {
										str += "<tr onclick='fn_checkUser(this)'>"
												+ "<td><input type='checkbox' name='idCheck' onclick='fn_clickCheckBox(event);' value='"
												+ result.data[i].userId
												+ "'/></td>"
												+ "<td>"
												+ result.data[i].userId
												+ "</td>"
												+ "<td>"
												+ result.data[i].userNm
												+ "</td></tr>";

									}
								} else {
									str = "<tr><td colspan='3'>검색된 데이터가 없습니다.</td></tr>"
								}
								$('#searchTable tbody').html(str);
							}
						}, "json").always(function() {
					$.ncmsLoding.remove();
				});

		return false;
	}
	function fn_checkUser(tr) {

		if ($(':checkbox', $(tr)).prop('checked') == true) {
			$(':checkbox', $(tr)).prop('checked', false)
		} else {
			$(':checkbox', $(tr)).prop('checked', true)
		}
		//$(':checkbox',$(tr)).trigger('click');

	}
	function fn_allRight() {
		//$('#searchTable checkbox');
		//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
		if ($('input:checkbox', '#dspthTable').length == 0
				&& $('input:checkbox', '#searchTable').length != 0) {//검색된 데이터가 없습니다. 삭제처리
			$('#dspthTable tbody').empty();
		}
		$('input:checkbox', '#searchTable').each(function() {
			var id = this.value;
			var isOK = true;
			$('input:checkbox', '#dspthTable').each(function() {
				if (this.value == id) {
					isOK = false;
					return false;
				}
			});
			if (isOK) {
				$(this).parent().parent().appendTo($('#dspthTable tbody'));
			}
			this.checked = false;
		});
	}
	function fn_right() {
		//$('#searchTable checkbox');
		//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
		if ($('input:checkbox', '#dspthTable').length == 0
				&& $('input:checkbox', '#searchTable').length != 0) {//검색된 데이터가 없습니다. 삭제처리
			$('#dspthTable tbody').empty();
		}
		$('input:checkbox:checked', '#searchTable').each(function() {
			var id = this.value;
			var isOK = true;
			$('input:checkbox', '#dspthTable').each(function() {
				if (this.value == id) {
					isOK = false;
					return false;
				}
			});
			if (isOK) {
				$(this).parent().parent().appendTo($('#dspthTable tbody'));
			}
			this.checked = false;
		});
	}
	function fn_left() {
		//$('#searchTable checkbox');
		//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
		if ($('input:checkbox', '#searchTable').length == 0
				&& $('input:checkbox', '#dspthTable').length != 0) {//검색된 데이터가 없습니다. 삭제처리
			$('#searchTable tbody').empty();
		}
		$('input:checkbox:checked', '#dspthTable').each(function() {
			var id = this.value;
			var isOK = true;
			$('input:checkbox', '#searchTable').each(function() {
				if (this.value == id) {
					isOK = false;
					return false;
				}
			});
			if (isOK) {
				$(this).parent().parent().appendTo($('#searchTable tbody'));
			} else {
				$(this).parent().parent().remove();
			}
			this.checked = false;
		});
	}
	function fn_allLeft() {
		//$('#searchTable checkbox');
		//$('input:checkbox','#searchTable').parent().parent().appendTo($('#dspthTable tbody tr'));
		if ($('input:checkbox', '#searchTable').length == 0
				&& $('input:checkbox', '#dspthTable').length != 0) {//검색된 데이터가 없습니다. 삭제처리
			$('#searchTable tbody').empty();
		}
		$('input:checkbox', '#dspthTable').each(function() {
			var id = this.value;
			var isOK = true;
			$('input:checkbox', '#searchTable').each(function() {
				if (this.value == id) {
					isOK = false;
					return false;
				}
			});
			if (isOK) {
				$(this).parent().parent().appendTo($('#searchTable tbody'));
			} else {
				$(this).parent().parent().remove();
			}
			this.checked = false;
		});
	}
	function fn_save() {

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
					jInfo('저장 되었습니다.', function() {
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

	}
	function fn_getData() {

	}
	function fn_searchUserKeyDown(event) {

		if (event.keyCode == 13) {
			fn_searchUser();
		}

	}
	function fn_clickCheckBox(event) {
		event.stopPropagation();
	}
</script>