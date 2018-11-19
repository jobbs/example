<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu" %>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform" %>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dynatree/ui.dynatree.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dynatree.js" />"></script>

<c:url var="selectUrl" value="selectMenu.do"></c:url>
<c:url var="selectTreeUrl" value="selectMenuListTree.do"></c:url>
<c:url var="insertUrl" value="insertMenu.do"></c:url>

<c:url var="deleteUrl" value="deleteMenu.do"></c:url>
<c:url var="updateOrderUpUrl" value="updateMenuOrderUp.do"></c:url>
<c:url var="updateOrderDownUrl" value="updateMenuOrderDown.do"></c:url>

<div class="col-box-30 detail-col no-padding-right">
	<div class="box">
		<div class="box-body no-padding tree-box">
			<table class="table table-vertical table-layout-fixed">
				<caption>메뉴 트리 목록 테이블</caption>
				<tbody>
				<tr>
					<td class="alignL no-padding">
						<div class="tree-resource " id="tree" style="max-height: 600px">
						</div>
					</td>
				</tr>
				<menu:authorize>
				<tr>
					<td>
						<div class="pull-left">
							<div class="btn-group">
								<button class="btn" onclick="onClickMove('${updateOrderUpUrl}')"><i class="fa fa-angle-up"></i></button>
								<button class="btn" onclick="onClickMove('${updateOrderDownUrl}')"><i class="fa fa-angle-down"></i></button>
							</div>
						</div>
						<div class="pull-right">
							<button class="btn btn-blue" onclick="doInsertForm()"><i class="fa fa-plus"></i></button>
						</div>
					</td>
				</tr>
				</menu:authorize>
				</tbody>
			</table>
		</div><!-- /box-body -->
		<div class="box-footer clearfix">
		</div><!-- /box-footer -->
	</div>
</div>
<div class="col-box-70 tree_content_area">
</div>

<script type="text/javascript">
$(function() {
	$("#tree").dynatree({
		persist:true,
		minExpandLevel:3,
		clickFolderMode:1,
		onActivate: function(node){
			loadSelectDetail(node.data.key);
		},
		initAjax:{
			url:'${selectTreeUrl}'
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

function loadSelectDetail(key){
	var url = '${selectUrl}';
	var menuSeq = null;
	if(key){
		menuSeq = key;
	}else{
		var node = $("#tree").dynatree("getActiveNode");
		if( node != null )
			menuSeq = node.data.key;
	}

	if( menuSeq != null ) {
		//$('.tree_content_area').css("position", "relative");
		$.ncmsLoding.start($('.tree_content_area'));
		$.get(url,{'menuSeq':menuSeq},loadSuccessHandler,'html');
	}
}

function loadSuccessHandler(data){
	$.ncmsLoding.remove($('.tree_content_area'));
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

	$.ncmsLoding.start($('.tree_content_area'));
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

function onClickMove(url){

	var activeNode = $("#tree").dynatree("getActiveNode");
	if( activeNode.data.parentKey == null ) {
		alert("최상위 메뉴는 이동이 불가합니다.");
		return;
	}

	$.ncmsLoding.startFullScreen();
	$.post(url,{'menuSeq':activeNode.data.key,'parentSeq':activeNode.data.parentKey},moveSuccessHandler,'json').always(function() {
		$.ncmsLoding.remove();
	});
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
</script>