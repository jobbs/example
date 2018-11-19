<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>가상서버 원격콘솔 화면(spice)</pre>
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     심원보         v1.0             최초생성
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>

<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/spicearraybuffer.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/enums.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/atKeynames.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/utils.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/png.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/lz.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/quic.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/bitmap.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/spicedataview.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/spicetype.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/spicemsg.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/wire.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/spiceconn.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/display.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/main.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/inputs.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/webm.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/playback.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/simulatecursor.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/cursor.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/thirdparty/jsbn.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/thirdparty/rsa.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/thirdparty/prng4.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/thirdparty/rng.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/thirdparty/sha1.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/ticket.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/resize.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/console/spice-html5/filexfer.js"/>"></script>
<style>
#spice-screen canvas{width:100% !important;min-width:600px;max-width:1920px;}
#spice-screen{text-align:center;height:auto !important;}

</style>

<div class="col-box-100">

        <div id="spice-area">
            <div id="spice-screen" class="spice-screen"></div>
        </div>

        <div id="message-div" class="spice-message" style="display:none;"></div>

        <div id="debug-div" style="display:none;"></div>
		<div class="button">
			<button type="button" class="btn btn-dark" onclick="fn_CtrlAltDel()">Ctrl+Alt+Del</button>
			<button type="button" class="btn close-window" onclick="fn_close()">닫기</button>
		</div>
</div>

<script type="text/javascript">

if(!String.prototype.startsWith){
	String.prototype.startsWith = function(searchString, position){
		position = position || 0;
		return this.substr(position, searchString.length) === searchString;
	}
}

$(document).ready(function(){
	$('.popup-content').addClass('no-padding-top');
	$('.popup-header').hide();

	fn_insertVmRcKeyLog(true);
	connect();
});

$(window).unload(function(){
	fn_insertVmRcKeyLog(false);
});

var sc;

function spice_set_cookie(name, value, days) {
    var date, expires;
    date = new Date();
    date.setTime(date.getTime() + (days*24*60*60*1000));
    expires = "; expires=" + date.toGMTString();
    document.cookie = name + "=" + value + expires + "; path=/";
};

function spice_query_var(name, defvalue) {
    var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);
    return match ?decodeURIComponent(match[1].replace(/\+/g, ' ')): defvalue;
}

function spice_error(e)
{
	var err_str = e.toString();
	if(err_str.startsWith("Error: ")){
		err_str = err_str.substring(7);
	}

	if(null != err_str && "" != err_str){
		jAlert(err_str, function(){
			disconnect(true);
		});
	}
	else{
		disconnect(false);
	}
}

function connect()
{
    var scheme, host, port, path, uri, password;

    scheme = "wss://";
    host = spice_query_var("host", '<c:out value="${host}"/>');
    port = spice_query_var("port", '<c:out value="${port}"/>');
    path = spice_query_var("path", '<c:out value="${path}"/>');
    password = spice_query_var("password", '<c:out value="${password}"/>');

    if ((!host) || (!port) || (!path) || (!password)) {
    	jAlert('접속정보가 없습니다.', function(){
        	window.close();
        });
    }

    if (sc) {
        sc.stop();
    }

    uri = scheme + host + ":" + port + "/" + path;

    try
    {
        sc = new SpiceMainConn({uri: uri, screen_id: "spice-screen", dump_id: "debug-div", message_id: "message-div", password: password, onerror: spice_error, onagent: agent_connected });
    }
    catch (e)
    {
    	alert(e.toString());
        disconnect();
    }

}

function disconnect(isError)
{
    console.log(">> disconnect");
    if (sc) {
        sc.stop();
        if(!isError){
        	jAlert('연결이 종료되었습니다.', function(){
            	window.close();
            });
        }
    }
    if(isError){
    	jAlert('브라우저에 <a href="<c:url value='executeVmRcPki.do'><c:param name="vmSeq" value="${vmSeq }" /></c:url>">인증서</a> 설치가 필요하거나, 연결이 만료되었습니다.', function(){
        	window.close();
        });
    }

    console.log("<< disconnect");
}

function agent_connected(sc)
{
    window.addEventListener('resize', handle_resize);
    window.spice_connection = this;

    resize_helper(this);
}

function fn_insertVmRcKeyLog(isConnect){
	$.post('<c:url value="executeVmRcKeyLog.do"/>', {
		vmSeq : parseInt('<c:out value="${vmSeq}"/>')
		,vmId : '<c:out value="${vmId}"/>'
		,vmCompId : '<c:out value="${vmCompId}"/>'
		, cmdCd : (isConnect ? '01' : '02')
	});
}

function fn_executeVmRcKeyLog(keys){
	$.post('<c:url value="executeVmRcKeyLog.do"/>', {
		vmSeq : parseInt('<c:out value="${vmSeq}"/>')
		,vmId : '<c:out value="${vmId}"/>'
		,vmCompId : '<c:out value="${vmCompId}"/>'
		, keys : keys
	});
}

function fn_CtrlAltDel() {
	jConfirm('Ctrl+Alt+Del 요청 하시겠습니까?\n  OS가 Linux의 경우, 재부팅될 수 있습니다!!', function() { sendCtrlAltDel(); });
}

</script>
