function fn_dataTable(id,orderNum,autoColumns){
	//debugger;
	var order = 0;
	if(orderNum){
		order = orderNum;
	}

	if(!autoColumns){
		var len = $("#"+id+" thead tr:last th").length;
		autoColumns=[];
		autoColumns.length = len;
	}
	$("#"+id).DataTable( {
		dom: 'Zlfrtip',
		paging : false,
		searching : false,
		info : false,
		bAutoWidth : false,
		aoColumns:autoColumns
		,order : [[order, "desc"]]
	} );
}

function fn_setRegion2PoolCombo(searchRegionId, searchZoneId, searchNetId, searchRsrcPoolId){
	$('#'+searchRegionId).on('change', function(){
		setSearchCondition(searchRegionId, searchZoneId, searchNetId, searchRsrcPoolId,'1');
	});
	$('#'+searchZoneId).on('change', function(){
		setSearchCondition(searchRegionId, searchZoneId, searchNetId, searchRsrcPoolId,'2');
	});
	$('#'+searchNetId).on('change', function(){
		setSearchCondition(searchRegionId, searchZoneId, searchNetId, searchRsrcPoolId,'3');
	});
	$('#'+searchRsrcPoolId).on('change', function(){
		setSearchCondition(searchRegionId, searchZoneId, searchNetId, searchRsrcPoolId,'4');
	});
	setSearchCondition(searchRegionId, searchZoneId, searchNetId, searchRsrcPoolId);
}
//리전, 존, 망, 자원풀 선택
function setSearchCondition(searchRegionId, searchZoneId, searchNetId, searchRsrcPoolId,gubun){
	var regionId = $('#'+searchRegionId).val();
	if(gubun=="1"){
		if(regionId){
			$('select .region').addClass('hide');
			$('select .region.regionId_'+regionId).removeClass('hide');
		}
		else{
			$('select .region').removeClass('hide');
		}
	}


	if(gubun=="2"){
		var zoneId = $('#'+searchZoneId).val();
		if(zoneId){
			$('select .zone').addClass('hide');
			$('select .zone.zoneId_'+zoneId).removeClass('hide');
		}
		else{
			$('.box-search select .zone').removeClass('hide');
		}
	}
	if(gubun=="3"){
		var netId = $('#'+searchNetId).val();
		if(netId){
			$('select .net').addClass('hide');
			$('select .net.netId_'+netId).removeClass('hide');
		}
		else{
			$('select .net').removeClass('hide');
		}
	}

	if($('#'+searchZoneId+' option[value="'+$('#'+searchZoneId).val()+'"]').hasClass('hide')){
		$('#'+searchZoneId).val('');
	}

	if($('#'+searchRsrcPoolId+' option[value="'+$('#'+searchRsrcPoolId).val()+'"]').hasClass('hide')){
		$('#'+searchRsrcPoolId).val('');
	}
}

function getContainerData(container){
	var json={};
	$(":input", container).each(function(){
		var $el =$(this),
			name =$el.attr("name"), value =$el.val();

		if(name){
			switch(this.tagName.toLowerCase()){
				case "input" :
					switch($el.attr("type")){
						case "button" :case "submit" : case "image" : case "reset" :
							break;
						case "checkbox" :
							value = $el.is(":checked")? value:"";
							if(json[name]){
								if(value){
									if($.isArray(json[name])) json[name].push(value);
									else json[name] = [json[name],value];
								}
							} else json[name] = value;
							break;
						case "radio":
							if(json[name] ===undefined)
								json[name] =$el.is(":checked")?value:"";
							else
								$el.is(":checked") && (json[name] =value);
							break;
						default://text
							json[name] = value;
					}
					break;
				case "select" :
					var $options =$el.children("option:selected");
					if($options.size() >1){
						json[name]= {};
						$options.each(function() { json[name].push($(this).val());});
					}else json[name] =$options.val();
					break;
				case "textarea" :
					json[name] = value;
					break;
			}
		}
	});
	return json;
}

function setChartColor(data,type){
	for(var i=0; i<data.datasets.length;i++){
		var color="";
		if(i%20==0){
			color="#FF9E9E";
		}else if(i%20==1){
			color="#C4C780";
		}else if(i%20==2){
			color="#CACCCF";
		}else if(i%20==3){
			color="#2288e1";
		}else if(i%20==4){
			color="#00b15c";
		}else if(i%20==5){
			color="#f7684f";
		}else if(i%20==6){
			color="#ffa60c";
		}else if(i%20==7){
			color="#00c0ef";
		}else if(i%20==8){
			color="#798A00";
		}else if(i%20==9){
			color="#FA46D1";
		}else if(i%20==10){
			color="#9D66BB";
		}else if(i%20==11){
			color="#D00";
		}else if(i%20==12){
			color="#9100F1";
		}else if(i%20==13){
			color="#161A83";
		}else if(i%20==14){
			color="#00753D";
		}else if(i%20==15){
			color="#815800";
		}else if(i%20==16){
			color="#026C9E";
		}else if(i%20==17){
			color="#A1CEFF";
		}else if(i%20==18){
			color="#FFCB6E";
		}else if(i%20==19){
			color="#80C7C4";
		}
		if(type=='line'){
			data.datasets[i].fillColor= "rgba(0,0,0,0)";
		}else{
			data.datasets[i].fillColor= color;
		}


        data.datasets[i].strokeColor= color;
        data.datasets[i].pointColor= color;
        data.datasets[i].pointStrokeColor= "rgba(0,0,0,0)";
        data.datasets[i].pointHighlightFill= "#fff";
        data.datasets[i].pointHighlightStroke= color;
	}
}