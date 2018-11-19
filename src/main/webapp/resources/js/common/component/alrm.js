/**
 * 1분에 한번씩 이벤트가 발생하였는지 서버를 확인한다.
*/
function doCheckAlrm() {

	try {

		var alrmFlag =  $.cookie("alrmFlag");
		if (alrmFlag!=null || alrmFlag == 'false') {
			if(window.console) console.log('alrmFlg: ' + alrmFlg);
			if (typeof _timer != 'undefined') {
				window.clearInterval(_timer);
			}
			return;
		}

		$(".alrm_label").hide();

		var url = contextPath+'/cmn/component/alrm/selectTopAlrmList.do';

		$.ajax({
			type: "get",
			url : url,
			beforeSend : function(x, s) {
				x.url = url;
			},
			success : function(result) {

				if( result.success ) {

					var cookieTime = $.cookie("alrmCookie");
					var alrms = result.data;
					var alrm = null;

					$(".alrm_dropdown").html("");
					if( alrms != null ) {

						for( var i=0; i < alrms.length; i++ ) {
							alrm = alrms[i];

							$(".alrm_dropdown").append(
									'<li><a href="javascript:void(0)" onclick="goTopAlrmRead(' + alrm.alrmSeq + ', \'' + alrm.trgtUrl + '\')">' +
									((alrm.statCd == "E")?'<i class="fa fa-warning red"></i> ':'<i class="fa fa-warning green"></i> ') +
									alrm.alrmSbjct +
									'</a></li>'
								);

							if( cookieTime == undefined || cookieTime < alrm.regDttm ) {
								$("#alertsDiv").append(
										'<a href="#" class="alert ' + ((alrm.statCd == "E")?'alert-green':'alert-red') + ' in" role="alert"><i class="fa fa-volume-up aqua"></i> ' + alrm.alrmSbjct + '</a>'
									);
							}

							if( i == 5 ) break;
						}

						$(".alrm_header").html( alrms.length + "개의 알림이 있습니다!!");
						$(".alrm_count").html(alrms.length);

						if( alrms.length > 0 ) {
							$(".alrm_label").show();
						} else {
							$(".alrm_label").hide();
						}
					}
				}

				$("#alertsDiv > a").each(function() {
					var $this = $(this);
					$(this).fadeOut(3000, "linear", function() {
						$this.remove();
					});
				});

				$.cookie("alrmCookie", Date.now());
			}
		});

	} catch ( err ) {
		console.log( "Check Alram Error " + log );
	}
}

function goTopAlrmRead(alrmSeq, targetUrl) {

	var url = contextPath+'/cmn/component/alrm/updateTopAlrm.do';
	$.post(url, {"alrmSeq" : alrmSeq }, function(result) {
		location.href = contextPath + targetUrl;
	});


}

doCheckAlrm();
var _timer = setInterval(doCheckAlrm, (60*1000));
