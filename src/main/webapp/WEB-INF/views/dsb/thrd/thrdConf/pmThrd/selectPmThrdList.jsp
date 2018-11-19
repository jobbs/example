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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dynatree/ui.dynatree.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dynatree.js" />"></script>

<script>
	function f_openPop(){

		popup('<c:url value="/dsb/thrd/thrdConf/pmThrd/selectNtceConfP.do" />','NtceConfPop',800);
		//$.post('selectNtceConf.do', '', handler_openerreload, 'json');
	}
	function f_openPop1(){
	  //window.open('cri/임계치 설정 수정(UI-PTL-DS-027).html','','width=1020,height=500');
		popup('<c:url value="/dsb/thrd/thrdConf/pmThrd/selectThrdConfP.do" />','NtceConfPop',1020);
	}
</script>
<div class="col-box-20 detail-col no-padding-right">
	<div class="box">
		<div class="box-body no-padding tree-box">
			<table class="table table-vertical table-layout-fixed">
			<caption>자원풀 구성정보</caption>
				<thead>
                  <tr>
                    <th>자원풀 구성정보</th>
                  </tr>
                </thead>
				<tbody>
				<tr>
					<td class="alignL">
						<div class="tree-resource" id="tree-resource">
							<div class="tree-box" id="tree" style="max-height: 600px">
							</div>
						</div>
					</td>
				</tr>
				<!--<tr>
					<td>
						<div class="">
							<div class="btn-group">
								 <button class="btn btn-default tree-open-all" data-target="#tree-resource" onclick="fn_allOpen()">모두열기</button>
						            <button class="btn btn-default tree-close-all" data-target="#tree-resource" onclick="fn_allClose()">모두닫기</button>
							</div>
						</div>
					</td>
				</tr>-->
				</tbody>
			</table>
		</div><!-- /box-body -->
		<div class="box-footer clearfix">
		</div><!-- /box-footer -->
	</div>
</div>



        <!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
        <div class="col-box-80 search-col tree_content_area">
          <!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
          <!-- box(목록조회 테이블) -->
        </div><!-- /col -->



<script type="text/javascript">

$(function() {
	$("#tree").dynatree({
		persist:true,
		minExpandLevel:2,
		clickFolderMode:1,
		onActivate: function(node){
			loadSelectDetail(node.data.key);
		},
		initAjax:{
			url:'<c:url value="/cmn/component/dsb/selectRegionToPmTree.do"/>'
		},
		onPostInit: function(isReloading, isError){
			this.activateKey(this.persistence.activeKey);
			this.reactivate(true);
		},
		onDblClick: function(){
			this.activeNode.toggleExpand();
		}
	});
});
//우측 리스트 화면 호출
function loadSelectDetail(key){
	var url = '<c:url value="selectPmThrdConfList.do"/>';
	var id = null;
	if(key){
		id = key;
	}else{
		var node = $("#tree").dynatree("getActiveNode");
		if( node != null )
			id = node.data.key;
	}

	if( id != null )
		$.get(url,{'id':id},loadSuccessHandler,'html');
}

function loadSuccessHandler(data){
	$('.tree_content_area').html(data);
}

/**
 * 메뉴 등록 폼 호출
 */
 function doInsertForm() {
	 var activeNode = $("#tree").dynatree("getActiveNode");
	if(activeNode == null){
		return;
	}
	$.get('${insertUrl}',{'parentSeq':activeNode.data.key},loadSuccessHandler,'html');
}

function submitSuccessHandler(result){
	alert_message(result.messageList, function() {
		if(result.success){

			if(result.procType == "delete"){
				 $("#tree").dynatree("getTree").activateKey( $("#tree").dynatree("getActiveNode").getParent().data.key );
			}
			reloadTree();
		}
	});

}

function reloadTree(){
	$("#tree").dynatree("getTree").reload();
}

function callbackReloadChildren(tree){
	loadSelectDetail(tree.data.key);
}

function moveSuccessHandler(result){
	if(result.success){
		var activeNode = $("#tree").dynatree("getActiveNode");
		if(result.data == 'before'){
			if(activeNode.getPrevSibling() != null){
				activeNode.move(activeNode.getPrevSibling(),'before');
			}
		}else{
			if(activeNode.getNextSibling() != null){
				activeNode.move(activeNode.getNextSibling(),'after');
			}
		}
	}else{
		if(result.messageList){
			alert(result.messageList.join('\n'));
		}
	}
}
function fn_allOpen(){
	$('.dynatree-folder').addClass('dynatree-exp-e dynatree-ico-ef');
	$('span .dynatree-expander','#tree').trigger('click');
	$('span .dynatree-expander','#tree').trigger('click');
	$('span .dynatree-expander','#tree').trigger('click');
	$('span .dynatree-expander','#tree').trigger('click');
	$('span .dynatree-expander','#tree').trigger('click');
	$('span .dynatree-expander','#tree').trigger('click');
	$('span .dynatree-expander','#tree').trigger('click');
	$('ul','#tree').show();
}
function fn_allClose(){
	//$('ul','#tree').hide();
}
</script>