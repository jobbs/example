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

<div class="col-box-100 detail-col">
	<div class="box">
		<div class="box-body no-padding">
			<table class="table table-vertical table-layout-fixed">
				<caption>존 트리 목록 테이블</caption>
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
<div class="col-box-100">
	<div class="button">
		<button type="button" class="btn btn-dark" onclick="selectZone()">선택</button>
		<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/common/component/entity.js" />"></script>

<script type="text/javascript">
$(function() {
	$("#tree").dynatree({
		persist : false,
		minExpandLevel : 3,
		clickFolderMode : 1,
		autoFocus: false,
		onActivate : function(node) {
		},
		initAjax : {
			url : 'selectZoneListTree.do'
		},
		onPostInit : function(isReloading, isError) {
			this.activateKey(this.persistence.activeKey);
			this.reactivate(true);
		},
		onDblClick : function() {
			this.activeNode.toggleExpand();
		}
	});

});

function selectZone(){

	var data = null;

	var node = $("#tree").dynatree("getActiveNode");

	if( null != node ) {

		var level = node.getLevel();
		var key = node.data.key;

		//,로 구분되어 잇는 키를 ,로 split 하여 마지막 항목을 ID로 한다.
		var cmnIds = key.split(",");
		var id = cmnIds.pop();

		var data = new EntityZone();

		console.log( level );
		if( level == "1" ) {
			data.regionNm = node.data.title;
			data.regionId = id;
		} else if( level == "2" ) {
			data.zoneNm = node.data.title;
			data.zoneId = id;
		} else if( level == "3" ) {
			data.netNm = node.data.title;
			data.netId = id;
		}

		data.level = level;

		var evt = jQuery.Event('selectZone', {
			"procType" : "selectZone",
			"datas" : data
	    });

	    var _parent = window.opener;
	    _parent.jQuery(_parent.document).trigger(evt);
	    window.close();
	} else {
		jAlert("존을 선택하여 주시기 바랍니다.");
	}

}
</script>