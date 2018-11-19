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

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dynatree/ui.dynatree.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.dynatree.js" />"></script>

<c:url var="selectTreeUrl" value="selectMenuListTree.do"></c:url>
<c:url var="selectRoleUrl" value="selectMenuRoleList.do"></c:url>
<c:url var="updateCopyMenuRoleUrl" value="updateCopyMenuRole.do" />

<div class="col-box-30 no-padding-right">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-vertical">
				<caption>메뉴 트리 목록 테이블</caption>
				<tbody>
				<tr>
					<td class="alignL">
						<div class="tree-resource" id="tree-resource">
							<div class="tree-box" id="tree">
							</div>
						</div>
					</td>
				</tr>
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
		//persist:true,
		minExpandLevel:3,
		clickFolderMode:1,
		onActivate: function(node){
			loadSelectRole(node.data.key);
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

function loadSelectRole(key){
	var url = '${selectRoleUrl}';
	var menuSeq = null;
	if(key){
		menuSeq = key;
	}else{
		var node = $("#tree").dynatree("getActiveNode");
		if( node != null )
			menuSeq = node.data.key;
	}

	if( menuSeq != null )
		$.get(url,{'menuSeq':menuSeq},loadSuccessHandler,'html');
}

function loadSuccessHandler(data){
	$('.tree_content_area').html(data);
}

function doCopyRole() {

	jConfirm("해당 권한을 복제하시겠습니까?", function() {
		var url = "${updateCopyMenuRoleUrl}";
		var targetMenuSeq = ${vo.menuSeq};
		var node = $("#tree").dynatree("getActiveNode");

		if( node != null ) {
			var sourceMenuSeq = node.data.key;

			$.ncmsLoding.startFullScreen();
			$.post(url,
					{"sourceMenuSeq":sourceMenuSeq, "targetMenuSeq":targetMenuSeq},
					loadCopySuccessHandler,
					"json"
				).always(function() {
					$.ncmsLoding.remove();
				});
		}
	});


}

function loadCopySuccessHandler(result) {
	alert_message(result.messageList, function() {
		if(result.success){
			opener.reloadTree();
		    window.close();
		}
	});
}
</script>