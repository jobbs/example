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


<div class="col-box-100">
  <form:form commandName="atmsclDistrbVo">
  <input type="hidden" title="서비스영역ID" name="servcAreaId" id="servcAreaId" value="${servcAreaId }" />
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

<div class="box">

  <div class="box-body no-padding">
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
                <input type="text" name="autoMinPodQtyIn" id="autoMinPodQtyIn" class="form-control essential" title="최소 Pod 수"  onkeydown="return numCheck(event);" maxlength="2"/>
              </td>
            </tr>
            <tr>
              <th><span class="text-red">*</span>최대 Pod수</th>
              <td colspan="3">
                <input type="text" name="autoMaxPodQtyIn" id="autoMaxPodQtyIn" class="form-control essential"  title="최대 Pod수"  onkeydown="return numCheck(event);" maxlength="2"/>
              </td>
            </tr>
            <tr>
              <th><span class="text-red">*</span>CPU사용량 (%)</th>
              <td colspan="3">
              	<input type="text" name="endThresVlIn" id="endThresVlIn" class="form-control essential" title="CPU사용량 (%)" onkeydown="return numCheck(event);" maxlength="3"/>
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
                <input type="text" name="multiMinPodQtyIn" id="multiMinPodQtyIn" class="form-control essential" title="최소 Pod 수" onkeypress="return numCheck(event)"  maxlength="2"/>
              </td>
            </tr>
            <tr>
              <th><span class="text-red">*</span>최대 Pod수</th>
              <td colspan="2">
                <input type="text" name="multiMaxPodQtyIn" id="multiMaxPodQtyIn" class="form-control essential"  title="최대 Pod수"  onkeypress="return numCheck(event)" maxlength="2"/>
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
        </colgroup>
        <thead>
          <tr>
            <th>스케일 그룹코드</th>
            <th>임계치 구분코드</th>
            <th>임계치 사용량 (%)</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>

              <select name="distrbMultiSclList[].sclGrpCd" title="스케일 그룹코드" class="form-control essential" onchange="fn_sclGrp(this);">
              		<option value="">선택</option>
              		<c:forEach var="grpCdList" items="${selCodeSclGrpList }">
	              		<option value="${grpCdList.cd}">${grpCdList.cdNm }</option>
					</c:forEach>
               </select>
            </td>
            <td>
              <select name="distrbMultiSclList[].thresClCd" title="임계치 구분코드" class="form-control essential" onchange="fn_thresClCd(this);">
                 	<option value="">선택</option>
              		<c:forEach var="thresCdList" items="${selCodeThresConfList }">
	              		<option value="${thresCdList.cd}">${thresCdList.cdNm }</option>
					</c:forEach>
               </select>
            </td>
            <td>
              <input type="text" name="distrbMultiSclList[].endThresVl" class="form-control" title="임계치 사용량" maxlength="3"/>
            </td>
            <td>
              <button type="button" class="btn btn-sm btn-function" name="btnDelScl" onclick="fn_deleteEnv(this)" title="다차원 스케일변수 삭제">삭제</button>
            </td>
          </tr>
        </tbody>
      </table>
  </div>
  </div>

</div>
</div>
</form:form>
<div class="col-box-100">
  <div class="button">
  	<menu:authorize>
    	<button type="button" class="btn btn-dark" onclick="sclRun();">설정</button>
    </menu:authorize>
    <button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>
<script type="text/javascript">
  $(document).ready(function() {



  });
  var  multiCheck = 1;
  function numCheck(evt){

	  if(window.event){
		var keyVal = window.event.keyCode;
	  }else{
		var keyVal = evt.which;
	  }

	  if( (keyVal >= 48) && (keyVal <= 57) || (keyVal == 46) || (keyVal == 8)){
		  window.event.returnValue = true;
		  return;
	  }else{
		  if(window.event){
			  window.event.returnValue = false;

		  }else{
			evt.preventDefault();
		  }
		  jAlert("숫자만 입력해주세요.");
	  }
  }
  function selectedScl(selectedValue){
	multiCheck = 1;
    if($(selectedValue).val() == '01'){
   		$("#endThresVl").val("");
  		$("#minPodQty").val("");
  		$("#maxPodQty").val("");
  		$("#multiMinPodQtyIn").val("");
  		$("#multiMaxPodQtyIn").val("");
		var initTr = $('#multiSclTable tbody tr:first').clone().html();
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
    }
    if($(selectedValue).val() == ''){
      $('#atmsclDistrbAutoSclTable').hide();
      $('#atmsclDistrbMultiSclTable').hide();
    }



    /////


  }


    function sclRun(){


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

      	   if($("select[name='distrbMultiSclList[].sclGrpCd']").val() == ""){
      		 jAlert("스케일 그룹코드를 선택해주세요.");
      		 return;
           }

    	   if($("select[name='distrbMultiSclList[].thresClCd']").val() == ""){
        		 jAlert("임계치 구분코드를 선택해주세요.");
        		 return;
            }
    	   if($("input[name='distrbMultiSclList[].endThresVl']").val() == ""){
        		 jAlert("임계치 사용량(%)을 입력해주세요.");
        		 return;
            }

      	   if($("input[name='distrbMultiSclList[].endThresVl']").val() < 0 ||
      			   $("input[name='distrbMultiSclList[].endThresVl']").val() > 100 ){
      		 jAlert("1~100사이의 값을 입력해주세요.");
      		 return;
          }

      }else{
          jAlert("스케일 구분을 선택해주세요.");
          return;
      }

      if($("#minPodQty").val() > $("#maxPodQty").val() && $("#minPodQty").val() > 0 ){
    	     jAlert("최소Pod수 와 최대 Pod수를 확인해주세요.");
             return;
      }
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

      $('#atmsclDistrbVo').attr('action', contextPath+'/cpt/rsrc/atmscl/atmsclDistrb/insertDistrbAutoSclConf.do');
      $('#atmsclDistrbVo').ajaxSubmit(options);

    });
    }
  //생성 결과 콜백
    function insertDistrbAutoSclResultHandler(result){

      if(result.messageList != null && result.messageList.length > 0) result.messageList.sort();

      if(result.success){
        jInfo(result.messageList, function(){
          window.close();
        });
      }
      else{
        alert_message(result.messageList)
      }
    }

  //다차원 스케일 변수 추가
    function fn_insertMultiScl() {
			if( multiCheck < 3){
				 var appendTr = $('#multiSclTable tbody tr:first').clone().html();
			     // 행 추가 한다.
			     var html = "<tr>"+appendTr+"</tr>";
			    /*  html = '<tr>'
			         + '<td>'
			         + '<select name="distrbMultiSclList[].sclGrpCd" title="스케일 그룹코드" class="form-control essential">'
			         +		'<option value="">선택</option>'
			         +		'<c:forEach var="grpCdList" items="${selCodeSclGrpList }">'
			         +		'<option value="${grpCdList.cd}">${grpCdList.cdNm }</option>'
			         +		'</c:forEach>'
			         + '</select>'
			         + '</td>'
			         + '<td>'
			         + '<select name="distrbMultiSclList[].thresClCd" title="임계치구분코드" class="form-control essential">'
			         +		'<option value="">선택</option>'
			         +		'<c:forEach var="thresCdList" items="${selCodeThresConfList }">'
			         +		'<option value="${thresCdList.cd}">${thresCdList.cdNm }</option>'
			         +		'</c:forEach>'
			         + '</select>'
			         + '</td>'
			         + '<td>'
			         + 		'<input type="text" name="distrbMultiSclList[].endThresVl" class="form-control" title="임계치 사용량" maxlength="100"/>'
			         + '</td>'
			         + '<td>'
			         + 		'<button type="button" class="btn btn-sm btn-function" name=""btnDelScl"" onclick="fn_deleteEnv(this)" title="다차원 스케일변수 삭제">삭제</button>'
			         + '</td>'
			         + '</tr>'; */

			     $("#multiSclTable tbody").append(html);
			     multiCheck++;

			}else{
				jAlert('최대 3행까지 추가가능합니다.');
				return;
			}
        }


    //환경변수 삭제
    function fn_deleteEnv(obj) {
    	if(multiCheck > 1){
    		var tr = $(obj).parent().parent();
    	      tr.remove();
    	      multiCheck--;
    	}else{
			jAlert('행을 삭제할수 없습니다.');
			return;
		}

    }

</script>
