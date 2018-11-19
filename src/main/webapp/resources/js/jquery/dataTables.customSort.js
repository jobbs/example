/**
 * author 심원보
 */
function getInnerHtml(str){if(str!=null&&str.indexOf('<')!=-1){return getInnerHtml($(str).html());}else{return str;}}

jQuery.extend(jQuery.fn.dataTableExt.oSort, {
	'ip-address-pre':function(a){a=getInnerHtml(a);var i,item;var m=a.split('.'),n=a.split(':'),x='';xa='';if(m.length==4){for(i=0;i<m.length;i++){item=m[i];if(item.length==1){x+='00'+item;}else if(item.length==2){x+='0'+item;}else{x+=item;}}}else if(n.length>0){var count=0;for(i=0;i<n.length;i++){item=n[i];if(i>0){xa+=':';}if(item.length==0){count+=0;}else if(item.length==1){xa+='000'+item;count+=4;}else if(item.length==2){xa+='00'+item;count+=4;}else if(item.length==3){xa+='0'+item;count+=4;}else{xa+=item;count+=4;}}n=xa.split(':');var paddDone=0;for(i=0;i<n.length;i++){item=n[i];if(item.length===0&&paddDone===0){for(var padding=0;padding<(32-count);padding++){x+='0';paddDone=1;}}else{x+=item;}}}return x},
	'ip-address-asc':function(a,b){return ((a<b)?-1:((a>b)?1:0));},
	'ip-address-desc':function(a,b){return ((a<b)?1:((a>b)?-1:0));},
});

jQuery.extend(jQuery.fn.dataTableExt.oSort, {
	'uptime-pre':function(a){a=getInnerHtml(a);if(null==a||""==a||""==a.trim()){return -1;}var n=0; m=a.split(' ');m.forEach(function(item,index){var x=item.match(/[0-9, \.]+/g);if(item.endsWith('년')){n+=x*365*24*60*60;}else if(item.endsWith('일')){n+=x*24*60*60;}else if(item.endsWith('시간')){n+=x*60*60;}else if(item.endsWith('분')){n+=x*60;}else if(item.endsWith('초')){n+=x;}});return n;},
	'uptime-asc':function(a,b){return ((a<b)?-1:((a>b)?1:0));},
	'uptime-desc':function(a,b){return ((a<b)?1:((a>b)?-1:0));},
});