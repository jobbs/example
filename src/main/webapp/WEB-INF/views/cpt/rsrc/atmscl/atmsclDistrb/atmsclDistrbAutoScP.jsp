<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
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
 * 2017. 04. 28.     x         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>


<div class="col-box-100" id="test">
  <form:form commandName="atmsclDistrbVo">
  <input type="hidden" title="서비스영역ID" name="servcAreaId" id="servcAreaId" value="${servcAreaId }" />
  <input type="hidden" title="서비스영역SEQ" name="servcAreaSeq" id="servcAreaSeq" value="${servcAreaSeq }" />
  <input type="hidden" title="서비스ID" name="servcId" id="servcId" value="${servcId }" />
  <input type="hidden" title="서비스SEQ" name="servcSeq" id="servcSeq" value="${servcSeq }" />
  <input type="hidden" title="배포설정Id" name="distrbConfId" id="distrbConfId" value="${distrbConfId }" />
  <input type="hidden" title="센터Id" name="regionId" id="regionId" value="${regionId }" />
  <input type="hidden" title="존Id" name="zoneId" id="zoneId" value="${zoneId }" />
  <input type="hidden" title="망구분코드" name="netClCd" id="netClCd" value="${netClCd }" />
  <input type="hidden" title="자원풀ID" name="rsrcPoolId" id="rsrcPoolId" value="${rsrcPoolId }" />
  <input type="hidden" title="등록자ID" name="regUserId" id="regUserId" value="${regUserId }" />
  <input type="hidden" title="현재POD수" name="nowPodQty" id="nowPodQty" value="${nowPodQty }" />
  <input type="hidden" title="최소POD수" name="minPodQty" id="minPodQty"  />
  <input type="hidden" title="최대POD수" name="maxPodQty" id="maxPodQty"  />
  <input type="hidden" title="스케일구분코드" name="sclngClCd" id="sclngClCd"  />
  <input type="hidden" title="CPU사용량" name="endThresVl" id="endThresVl"  />
  <input type="hidden" title="스케일ID" name="scalrId" id="scalrId"  value="${autoSclInfo[0].scalrId}" />

<div class="box">

  <div class="box-body no-padding" style="border-bottom:0px;">
    <table class="table table-hover table-vertical">
            <caption>오토스케일링 테이블</caption>

        <colgroup>
          <col class="col30">
          <col class="col30">
          <col class="col30">
          <col class="col10">
            </colgroup>

        <tbody>
          <tr>
            <th>스케일 구분</th>
            <td colspan="3">
              <select title="스케일 구분" id="sclCheck" class="form-control essential" onchange="selectedScl(this)" >
                <option value="">선택</option>
                <c:forEach var="sclCondition" items="${selCodeSclList}">
                	<c:if test="${sclCondition.cd != '03' }">
	                	<option value="${sclCondition.cd}">${sclCondition.cdNm }</option>
                	</c:if>
                </c:forEach>
              </select>
            </td>
          </tr>
        </tbody>
    </table>
  </div>




  <div class="box-body no-padding" id="atmsclDistrbAutoSclTable" style="display:none">

      <table class="table table-hover table-vertical" >
        <caption>오토스케일링 테이블</caption>

      <colgroup>
          <col class="col30">
          <col class="col30">
          <col class="col30">
          <col class="col10">
          </colgroup>

        <tbody>
            <tr>
              <th><span class="text-red">*</span>현재 Pod수</th>
              <td class="alignL" colspan="3">
                <c:out value="${nowPodQty}"/>
              </td>
            </tr>
            <tr>
              <th><span class="text-red">*</span>최소 Pod수</th>
              <td colspan="3">
                <input type="number" name="autoMinPodQtyIn" id="autoMinPodQtyIn" class="form-control onlyInteger" title="최소 Pod 수"  oninput="maxLengthCheck(this);" pattern="[1-9]{2}"  maxlength="2" min="1" max="99"/>
              </td>
            </tr>
            <tr>
              <th><span class="text-red">*</span>최대 Pod수</th>
              <td colspan="3">
                <input type="number" name="autoMaxPodQtyIn" id="autoMaxPodQtyIn" class="form-control onlyInteger "  title="최대 Pod수"   oninput="maxLengthCheck(this);" pattern="[1-9]{2}"  maxlength="2" min="1" max="99"/>
              </td>
            </tr>
            <tr>
              <th><span class="text-red">*</span>CPU사용률(%) </th>
              <td colspan="3">
              	<input type="number" name="endThresVlIn" id="endThresVlIn" class="form-control onlyInteger " title="CPU사용량 (%)"  oninput="maxLengthCheck(this);" pattern="/^[1-9][0-9]{3}" maxlength="3" min="1" max="100"/>
              </td>
            </tr>
        </tbody>
      </table>
  </div>




  <div class="box-body no-padding" id="atmsclDistrbMultiSclTable" style="display:none" >

      <table class="table table-hover table-vertical" >
        <caption>다차원 스케일링 테이블</caption>

      <colgroup>
          <col class="col30">
          <col class="col30">
          <col class="col30">
          <col class="col10">
          </colgroup>
        <tbody>
            <tr>
              <th><span class="text-red">*</span>현재 Pod수</th>
              <td class="alignL" colspan="2">
                <c:out value="${nowPodQty}"/>
              </td>
            </tr>
            <tr>
              <th><span class="text-red">*</span>최소 Pod수</th>
              <td colspan="2">
                <input type="number" name="multiMinPodQtyIn" id="multiMinPodQtyIn" class="form-control onlyInteger" pattern="[1-9]{2}" title="최소 Pod 수" oninput="maxLengthCheck(this);"  maxlength="2" min="1" max="99" value="${autoSclInfo[0].minPodQty }"/>
              </td>
            </tr>
            <tr>
              <th><span class="text-red">*</span>최대 Pod수</th>
              <td colspan="2">
                <input type="number" name="multiMaxPodQtyIn" id="multiMaxPodQtyIn" class="form-control onlyInteger" pattern="[1-9]{2}"  title="최대 Pod수"  oninput="maxLengthCheck(this);"  maxlength="2" min="1" max="99" value="${autoSclInfo[0].maxPodQty }"/>
              </td>
            </tr>
        </tbody>
      </table>

  <div class="box-body no-padding">
          <div class="box-header">
                <h3 class="box-title">다차원스케일 정보</h3>
                <div class="box-tools">
            <div class="pull-right">
              <button type="button" class="btn btn-sm btn-function" onclick="fn_insertMultiScl()" title="다차원 스케일변수 추가">추가</button>
            </div>
          </div>
            </div>

        <table class="table table-vertical" id="multiSclTable">
        <caption>다차원 스케일링 테이블</caption>
        <colgroup>
          <col class="col30">
          <col class="col30">
          <col class="col30">
          <col class="col10">
          <col class="col10">
        </colgroup>
        <thead>
          <tr>
            <th>스케일 그룹코드</th>
            <th>임계치 구분코드</th>
            <th>임계치 사용량</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
			<c:if test="${not empty autoSclInfo}">
			   <c:forEach var="info" items="${autoSclInfo}">
	          <tr>
	            <td>
	              <select name="distrbMultiSclList[].sclGrpCd" title="스케일 그룹코드" class="form-control essential" >
	              		<option value="">선택</option>
	              		<c:forEach var="grpCdList" items="${selCodeSclGrpList }">
	              		 <c:choose>
							<c:when test='${info.sclGrpCd eq grpCdList.cd}'><option selected="selected" value="${grpCdList.cd}">${grpCdList.cdNm }</option></c:when>
							<c:otherwise><option value="${grpCdList.cd}">${grpCdList.cdNm }</option></c:otherwise>
						</c:choose>
						</c:forEach>
	               </select>
	            </td>
	            <td>
	              <select name="distrbMultiSclList[].thresClCd" title="임계치 구분코드" class="form-control essential" onchange="fn_thresClCd(this);">
	                 	<option value="">선택</option>
	              		<c:forEach var="thresCdList" items="${selCodeThresConfList }">
	              		 <c:choose>
							<c:when test='${info.thresClCd eq thresCdList.cd}'>
								<option selected="selected" value="${thresCdList.cd}">${thresCdList.cdNm }</option>
							</c:when>
							<c:otherwise><option value="${thresCdList.cd}">${thresCdList.cdNm }</option></c:otherwise>
						</c:choose>

						</c:forEach>
	               </select>
	            </td>
	            <td>
	              <input type="number" name="distrbMultiSclList[].endThresVl" class="form-control onlyInteger alignR essential" title="임계치 사용량" oninput="maxLengthCheck(this);" maxlength="2" min="1" max="99"  value="${info.endThresVl}"  />
	            </td>
	            <td>
					<div name="thres" class="input-group-cell">
						<c:choose>
							<c:when test="${info.thresClCd eq '01'}">%</c:when>
							<c:when test="${info.thresClCd eq '02'}">%</c:when>
							<c:when test="${info.thresClCd eq '03'}">(KB/Sec)</c:when>
						</c:choose>
					</div>
	            </td>
	            <td>
	              <button type="button" class="btn btn-sm btn-function" name="btnDelScl" onclick="fn_deleteEnv(this)" title="다차원 스케일변수 삭제">삭제</button>
	            </td>
	          </tr>
	          </c:forEach>
	          </c:if>
			<c:if test="${ empty autoSclInfo }">
				<tr>
	            <td>
	              <select name="distrbMultiSclList[].sclGrpCd" title="스케일 그룹코드" class="form-control essential ">
	              		<option value="">선택</option>
	              		<c:forEach var="grpCdList" items="${selCodeSclGrpList }">
		              		<option value="${grpCdList.cd}">${grpCdList.cdNm }</option>
						</c:forEach>
	               </select>
	            </td>
	            <td>
	              <select name="distrbMultiSclList[].thresClCd" title="임계치 구분코드" class="form-control essential " onchange="fn_thresClCd(this);">
	                 	<option value="">선택</option>
	              		<c:forEach var="thresCdList" items="${selCodeThresConfList }">
		              		<option value="${thresCdList.cd}">${thresCdList.cdNm }</option>
						</c:forEach>
	               </select>
	            </td>
	            <td>
	              <input type="number" name="distrbMultiSclList[].endThresVl"  class="form-control onlyInteger alignR essential" pattern="[0-9]{2}" oninput="maxLengthCheck(this);" title="임계치 사용량"   maxlength="2"  min="1" max="99" />
	              <!-- <input type="number" name="distrbMultiSclList[].endThresVl" class="form-control onlyInteger" oninput="maxLengthCheck(this);" title="임계치 사용량" maxlength="3"/> -->
	            </td>
	            <td>
					<div name="thres" class="input-group-cell"></div>
				</td>
	            <td>
	              <button type="button" class="btn btn-sm btn-function" name="btnDelScl" onclick="fn_deleteEnv(this)" title="다차원 스케일변수 삭제">삭제</button>
	            </td>
	          </tr>
		</c:if>

        </tbody>
      </table>
  </div>
  </div>

</div>
</form:form>
</div>

<div class="col-box-100">
  <div class="button">
      <c:if test="${not empty autoSclInfo }">
	  	<menu:authorize>
	    	<button type="button" id="autoUpdate" class="btn btn-dark" onclick="sclRun(this);">설정</button>
	    </menu:authorize>
	    <menu:authorize>
	    	<button type="button" class="btn btn-dark" onclick="sclDel();">삭제</button>
	    </menu:authorize>
    </c:if>
    <c:if test="${empty autoSclInfo }">
	  	<menu:authorize>
	    	<button type="button" id="autoConf" class="btn btn-dark" onclick="sclRun(this);">설정</button>
	    </menu:authorize>
    </c:if>
    <button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
  </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
	 $(document).ready(function() {
		 fn_selectedInit();
	 });
		var  multiCheck = 1;
		var delCheck = false;
		var tempCheck= "";
	  function fn_changeView(selectedValue){

		   	 if($(selectedValue).val() == '01'){
		   				$('#multiSclTable select,#multiSclTable input').removeClass('essential');
						$("#endThresVl").val("");
						$("#minPodQty").val("");
						$("#maxPodQty").val("");
						$("#multiMinPodQtyIn").val("");
						$("#multiMaxPodQtyIn").val("");
						var initTr = $('#multiSclTable tbody tr:first').clone().find("option").attr("selected",false).end()
						.find("input[name='distrbMultiSclList[].endThresVl']").attr("value"," ").end().html();
						var html = "<tr>"+initTr+"</tr>";
						$("#multiSclTable tbody").empty();
						$("#multiSclTable tbody").append(html);
						if($('#atmsclDistrbMultiSclTable').css("display") != "none"){
						  $('#atmsclDistrbMultiSclTable').hide();
						}
						if($('#atmsclDistrbAutoSclTable').css("display") == "none"){
						  $('#atmsclDistrbAutoSclTable').show();
						}else{
						  $('#atmsclDistrbAutoSclTable').hide();
						}
				    }else if($(selectedValue).val() == '02'){
						$("#endThresVl").val("");
						$("#minPodQty").val("");
						$("#maxPodQty").val("");

						$("#endThresVlIn").val("");
						$("#autoMinPodQtyIn").val("");
						$("#autoMaxPodQtyIn").val("");
						if($('#atmsclDistrbAutoSclTable').css("display") != "none"){
						  $('#atmsclDistrbAutoSclTable').hide();
						}
						if($('#atmsclDistrbMultiSclTable').css("display") == "none"){
						  $('#atmsclDistrbMultiSclTable').show();
						}else{
						  $('#atmsclDistrbMultiSclTable').hide();
						}
				    }else{
				     	$('#atmsclDistrbAutoSclTable').hide();
				    	$('#atmsclDistrbMultiSclTable').hide();
					  	$("#endThresVl").val("");
						$("#minPodQty").val("");
						$("#maxPodQty").val("");
						$("#endThresVlIn").val("");
						$("#autoMinPodQtyIn").val("");
						$("#autoMaxPodQtyIn").val("");
						var initTr = $('#multiSclTable tbody tr:first').clone().find("option").attr("selected",false).end()
						.find("input[name='distrbMultiSclList[].endThresVl']").attr("value"," ").end().html();
						var html = "<tr>"+initTr+"</tr>";
						$("#multiMinPodQtyIn").val("");
						$("#multiMaxPodQtyIn").val("");
						$("#multiSclTable tbody").empty();
						$("#multiSclTable tbody").append(html);
				    }
		   }

	  function selectedScl(selectedValue){
		  if($(selectedValue).val() == ""){
			  fn_changeView(selectedValue);
			  tempCheck = "";
		  }else{
			  if(tempCheck == ""){
				  fn_changeView(selectedValue);
				  tempCheck = $(selectedValue).val();
			  }else{
				  if( $("#sclCheck option:selected").val() == "01" || $("#sclCheck option:selected").val() == "02"){
					  tempCheck = $(selectedValue).val();
					  var dataCheck = "";
					  if(delCheck){
						  dataCheck = "";
					  }else{
						  dataCheck = '${autoSclInfo[0]}';
					  }

					  if(dataCheck == "" || dataCheck == null || dataCheck == "undefined"){
							jConfirm('스케일 구분 변경 시 기존 입력값은 유지되지 않습니다.', function(){
								multiCheck = 1;
								fn_changeView(selectedValue);
						  });
					  }else{
						  jConfirmForCancel('스케일 구분 변경 시 기존 입력값은 삭제됩니다.', function(result){
							if(result){
								if(  $("#sclCheck option:selected").val() == "01"){
									$("#sclngClCd").val($("#sclCheck option:eq(2)").val());
								}else if($("#sclCheck option:selected").val() == "02"){
									$("#sclngClCd").val($("#sclCheck option:eq(1)").val());
								}
									fn_form_rename("distrbMultiSclList", "sclGrpCd,thresClCd,endThresVl");
								 		  var options = {
											        type: 'post',
											        dataType: 'json',
											        success: deleteDistrbAutoSclResultHandler,
											        beforeSend: function() {

											          $.ncmsLoding.startFullScreen();
											        },
											        complete : function(data) {
											          $.ncmsLoding.remove();

											          	multiCheck = 1;
											          	//fn_changeView(selectedValue);


											        },
											        error: function(xhr, textStatus, errorThrown){
											          jAlert('스케일 설정 삭제 시 오류가 발생하였습니다.');
											        }
											      };

											      $('#atmsclDistrbVo').attr('action', '<c:url value="deleteDistrbAutoSclConf.do"/>');
											      $('#atmsclDistrbVo').ajaxSubmit(options);
							}else{

								 if(  $("#sclCheck option:selected").val() == "01"){
									$("#sclCheck").val("02").prop("selected",true);
								}else if($("#sclCheck option:selected").val() == "02"){
									$("#sclCheck").val("01").prop("selected",true);
								}
							}


						  });
					  }


				 }
			  }
		  }
 	  }
    function sclRun(idCheck){
    	if(!fn_form_validation("atmsclDistrbVo")){
    		return;
    	}
      if($("#sclCheck option:selected").val() == "01"){

       		$("#minPodQty").val($("#autoMinPodQtyIn").val());
      		$("#maxPodQty").val($("#autoMaxPodQtyIn").val());
      		$("#sclngClCd").val($("#sclCheck option:selected").val());
      		$("#endThresVl").val($("#endThresVlIn").val());

      		if( $("#minPodQty").val() == "" || $("#maxPodQty").val() == "" || $("#endThresVl").val() == ""){
      			jAlert("값을 입력해주세요.");
      			return;
      		}
      		if($("#endThresVl").val() > 100){
      			 jAlert("1~100사이의 값을 입력해주세요.");
          		 return;
      		}


      }else if($("#sclCheck option:selected").val() == "02"){

        	$("#minPodQty").val($("#multiMinPodQtyIn").val());
      		$("#maxPodQty").val($("#multiMaxPodQtyIn").val());
      		$("#sclngClCd").val($("#sclCheck option:selected").val());
      		var checkCnt = $("select[name='distrbMultiSclList[].sclGrpCd']").length;
    		for (var i = 0; i < checkCnt; i++) {
    			for (var j = 0; j < checkCnt; j++) {
    				if(i != j){
	       				if(  $("select[name='distrbMultiSclList[].thresClCd']").eq(i).val() == $("select[name='distrbMultiSclList[].thresClCd']").eq(j).val() ){
	       					 jAlert("임계치 구분코드 중복입니다.");
	       		      		 return;
	       				}
    				}
    			}
    		}


    	   if($("select[name='distrbMultiSclList[].thresClCd']").val() != "03"){
	      	   if($("input[name='distrbMultiSclList[].endThresVl']").val() < 0 ||
	      			   $("input[name='distrbMultiSclList[].endThresVl']").val() > 100 ){
	      		 jAlert("1~100사이의 값을 입력해주세요.");
	      		 return;
	          }
    	   }

      }else{
          jAlert("스케일 구분을 선택해주세요.");
          return;
      }

      if($("#minPodQty").val() > $("#maxPodQty").val() || $("#minPodQty").val() == 0 ){
    	     jAlert("최소Pod수 와 최대 Pod수를 확인해주세요.");
             return;
      }

	if(idCheck.id == "autoConf"){
		fn_form_rename("distrbMultiSclList", "sclGrpCd,thresClCd,endThresVl");
 	     jConfirm('스케일설정 하시겠습니까?', function(){

	      var options = {
	        type: 'post',
	        dataType: 'json',
	        success: insertDistrbAutoSclResultHandler,
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

	      $('#atmsclDistrbVo').attr('action', '<c:url value="insertDistrbAutoSclConf.do"/>');
	      $('#atmsclDistrbVo').ajaxSubmit(options);

	    });
		}else if(idCheck.id == "autoUpdate"){
			fn_form_rename("distrbMultiSclList", "sclGrpCd,thresClCd,endThresVl");
			    jConfirm('스케일설정을 수정 하시겠습니까?', function(){

				      var options = {
				        type: 'post',
				        dataType: 'json',
				        success: insertDistrbAutoSclResultHandler,
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

				      $('#atmsclDistrbVo').attr('action', '<c:url value="updateDistrbAutoSclConf.do"/>');
				      $('#atmsclDistrbVo').ajaxSubmit(options);

				 });
		}
  }
  //생성 결과 콜백
    function insertDistrbAutoSclResultHandler(result){

      if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

      if(result.success){
        jInfo(result.messageList, function(){
		  location.reload();
		  window.opener.parent.location.reload();
        });
      }else{
        alert_message(result.messageList)
      }
    }

  //다차원 스케일 변수 추가
    function fn_insertMultiScl() {
			if( multiCheck < 3){
				$("select[name='distrbMultiSclList[].thresClCd']").parent().parent().find('td:eq(2)').eq(0).find('div').find('div').html("");
				var ck ="${autoSclInfo[0].sclngClCd}";
				if("02" == ck){
					var appendTr = $('#multiSclTable tbody tr:last').clone().find("option").attr("selected",false).end()
					.find("input[name='distrbMultiSclList[].endThresVl']").attr("value"," ").end().html();
				     // 행 추가 한다.
				     var html = "<tr>"+appendTr+"</tr>";
				     $("#multiSclTable tbody").append(html);
				     multiCheck++;
	    		}else{
	    			var appendTr = $('#multiSclTable tbody tr:first').clone().html();
				     // 행 추가 한다.
				     var html = "<tr>"+appendTr+"</tr>";
				     $("#multiSclTable tbody").append(html);
				     multiCheck++;
	    		}


			}else{
				jAlert('최대 3행까지 추가가능합니다.');
				return;
			}
        }


    //다차원 스케일 변수 삭제
    function fn_deleteEnv(obj) {
    	if(multiCheck > 1){
    		var tr = $(obj).parent().parent();
    	      tr.remove();
    	      multiCheck--;
    	}else{
			jAlert('마지막 행은 삭제할수 없습니다.');
			return;
		}

    }
    function maxLengthCheck(data){
   		if(data.value.length > data.maxLength){
    		data.value = data.value.slice(0,data.maxLength)
    	}
    }

    function fn_selectedInit(){
    	var check ="${autoSclInfo[0].sclngClCd}";
    	if(check != "" || check != null || check != "undefined"){
    		$("#sclCheck").val(check).prop("selected",true);
			tempCheck = check;
        	if("02" == check){
        		$('#atmsclDistrbMultiSclTable').show();
        		<c:forEach var="info" items="${autoSclInfo}" varStatus="i">
        		multiCheck=multiCheck+1;
        		</c:forEach>
        		multiCheck=multiCheck-1;
        		// adding
        		$('select[name*="thresClCd"]').each(function(i) {
        			console.log(i + ',' + this.value);
        			if(this.value=='03')
        				$('input[name="distrbMultiSclList[].endThresVl"]').eq(i).attr('maxlength', 4);
        		});
        	}else if("01" == check){
        		$('#atmsclDistrbAutoSclTable').show();
        		$("#autoMinPodQtyIn").val('${autoSclInfo[0].minPodQty}');
        		$("#autoMaxPodQtyIn").val('${autoSclInfo[0].maxPodQty}');
        		$("#endThresVlIn").val('${autoSclInfo[0].endThresVl}');
        	}
    	}

    }

    function sclDel(){
    	fn_form_rename("distrbMultiSclList", "sclGrpCd,thresClCd,endThresVl");
    	$("#sclngClCd").val($("#sclCheck option:selected").val());
    	 jConfirm('스케일설정을 삭제 하시겠습니까?', function(){

		      var options = {
		        type: 'post',
		        dataType: 'json',
		        success: deleteDistrbAutoSclResultHandler,
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

		      $('#atmsclDistrbVo').attr('action', '<c:url value="deleteDistrbAutoSclConf.do"/>');
		      $('#atmsclDistrbVo').ajaxSubmit(options);

		 });
    }

    //생성 결과 콜백
    function deleteDistrbAutoSclResultHandler(result){

      if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

      if(result.success){
        jInfo(result.messageList, function(){
          location.reload();
          window.opener.parent.location.reload();
        });
      }
      else{
        alert_message(result.messageList)
      }
    }

function fn_thresClCd(data){
	var selIndex = $("select[name='distrbMultiSclList[].thresClCd'] option").index( $("select[name='distrbMultiSclList[].thresClCd'] option:selected") );
	var selTag = $("div[name=thres]");
	if($(data).val() == "01" || $(data).val() == "02"){

		$(data).parent().parent().find('td:eq(3) >div').eq(0).html("");
		$(data).parent().parent().find('td:eq(3) >div').eq(0).html("%");

		$(data).parent().parent().find('td:eq(2) >input').val("");
		$(data).parent().parent().find('td:eq(2) >input').attr('maxlength',2);

	}else{

		$(data).parent().parent().find('td:eq(3) >div').eq(0).html("");
		$(data).parent().parent().find('td:eq(3) >div').eq(0).html("KB/Sec");
		$(data).parent().parent().find('td:eq(2) >input').val("");
		$(data).parent().parent().find('td:eq(2) >input').attr('maxlength',4);
	}

}


</script>
