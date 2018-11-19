(function($) {

	var confUrl = contextPath+'/cmn/component/usruiconf/updateUsrUiConf.do';

	$.ncmsLayout = {

			/**
			 * 최초 초기화( DB에 저장되어 있는 값으로 화면을 셋팅한다.)
			 * @param str
			 */
			init : function(str) {
				var datas = JSON.parse(str);
				var data = null;

				for( var i=0; i < datas.length; i++ ) {
					data = datas[i];

					if( undefined != this["setConf" + data.confCd] ) {
						this["setConf" + data.confCd](data.confVl);
					}
				}
			},

			/**
			 * 코드에 해당하는 화면을 업데이트 한다.
			 * @param code
			 */
			update : function(code) {
				if( undefined != this["updateConf" + code] ) {
					this["updateConf" + code](code);
				}
			},

			/**
			 * 좌측 메뉴 영역 보여주기
			 * @param val
			 */
			setConf200 : function(val) {
				setTimeout(function() {
					var rightSide = $(".right-side");
					//보여주기
					if( val == "Y" ) {
						$('#left-side').width(250).attr('mode','0');
						rightSide.removeClass("sidebar-collapse");

					//가리기
					} else {
						$('#left-side').width(0).attr('mode','1');
						rightSide.addClass("sidebar-collapse");
					}

					//각 페이지별 이벤트 호출
					setTimeout(function() {
						if( typeof fnLayoutConf201 !== "undefined" && typeof fnLayoutConf201 === "function") {
							fnLayoutConf200();
						}
					},200);

				}, 10);
			},

			/**
			 * 좌측 메뉴바 상태 업데이트
			 */
			updateConf200 : function(code) {
				try {
					var toggleStatus = $('#left-side').attr('mode') == "1" ? "Y":"N";
					$.post(confUrl, { "confCd" : code, "confVl" : toggleStatus });
					this.setConf200(toggleStatus);
				} catch( err ) {
					console.log("UI Component 200 Error : " + err );
				}
			},

			/**
			 * 우칙 메뉴바 상태 업데이트
			 * @param val
			 */
			setConf201 : function(val) {

				setTimeout(function() {
					if( $("body").hasClass("skin-potal") ) {

						var rightSide = $(".right-side");
						//보여주기 일 경우
						if( val == "Y" ) {
							if(rightSide.hasClass("infobar-collapse")){
								rightSide.removeClass("infobar-collapse");
							}

						//가리기 일경우
						} else {
							if( !rightSide.hasClass("infobar-collapse") ){
								rightSide.addClass("infobar-collapse");
							}
						}
					}

					//각 페이지별 이벤트 호출
					setTimeout(function() {
						if( typeof fnLayoutConf201 !== "undefined" && typeof fnLayoutConf201 === "function") {
							fnLayoutConf201();
						}
					},200);

				}, 10);

			},

			/**
			 * 우측 메뉴바 상태 업데이트
			 */
			updateConf201 : function(code) {
				try {
					var toggleStatus = $(".right-side").hasClass("infobar-collapse") ? "Y":"N";
					$.post(confUrl, { "confCd" : code, "confVl" : toggleStatus });
					this.setConf201(toggleStatus);



				} catch( err ) {
					console.log("UI Component 201 Error : " + err );
				}


			}

	};


})(jQuery);