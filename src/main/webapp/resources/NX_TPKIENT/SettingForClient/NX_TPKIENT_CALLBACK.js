///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// NX_TPKIENT 클라이언트를 사용하기 위한 Callback 함수
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// WebSocket Connect 대기
function WaitForSocketConnection(CallBackFunc)
{
	var object = arguments;
	var result = setInterval(
	function()
	{
		if(WEBSOCKET.readyState == 1)
		{
			console.log("websocket state connected.");
			CallBackFunc(object);
			clearInterval(result);
		}
	}, 10);
}

function CALLBACK_SetUpdateManager()
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "SetUpdateManager";
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_StartAgent()
{
	var params = new Object();
	params.funcname = "StartAgent";
	params.productcode = "PKI_ENT";
	params.agentversion = TPKIENT_NX_VERSION;
	params.setupurl = TPKIENT_EXE;
	if(SET_UPDATEMANAGER == "ON")
	{
		params.updater = "used";
	}
	else
	{
		params.updater = "unused";
	}
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIInit(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIInit";
	params.servicename = args[1];
	params.serverurl = args[2];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_SetParam(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "SetParam";
	params.key = args[1];
	params.value = args[2];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWISignData(args)
{						
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWISignData";
	params.incontent = args[1];
	params.dnfilters = args[2];
	params.cafilters = args[3];
	params.data = args[4];
	params.storagetype = args[5];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIVerifyData(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIVerifyData";
	params.spffile = args[1];
	params.indata = args[2];
	params.signdata = args[3];
	params.originaldata = args[4];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIGetCertInfoFromSignedData(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIGetCertInfoFromSignedData";
	params.signdata = args[1];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWISessionRequestWithSignature(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWISessionRequestWithSignature";
	params.spffile = args[1];
	params.indata = args[2];
	params.dnfilters = args[3];
	params.cafilters = args[4];
	params.sessionid = args[5];
	params.algid = args[6];
	params.storagetype = args[7];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_SessionDestroy(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWISessionDestroy";
	params.sessionid = args[1];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWISessionEncrypt(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWISessionEncrypt";
	params.sessionid = args[1];
	params.plaindata = args[2];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWISessionDecrypt(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWISessionDecrypt";
	params.sessionid = args[1];
	params.encdata = args[2];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIGenSymKey(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIGenSymKey";
	params.algid = args[1];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIEncryptData(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIEncryptData";
	params.algid = args[1];
	params.base64key = args[2];
	params.plaindata = args[3];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIDecryptData(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIDecryptData";
	params.algid = args[1];
	params.base64key = args[2];
	params.encdata = args[3];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIEnvelopData(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIEnvelopData";
	params.epffile = args[1];
	params.plaindata = args[2];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIDevelopData(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIDevelopData";
	params.epffile = args[1];
	params.encdata = args[2];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIRequestCheckUserID(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIRequestCheckUserID";
	params.dnfilters = args[1];
	params.cafilters = args[2];
	params.userid = args[3];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIHash(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIHash";
	params.algid = args[1];
	params.endcodeflag = args[2];
	params.data = args[3];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIBase64Encode(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIBase64Encode";
	params.plaindata = args[1];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIBase64Decode(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIBase64Decode";
	params.encodedata = args[1];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWISignFile(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWISignFile";
	params.indata = args[1];
	params.dnfilters = args[2];
	params.cafilters = args[3];
	params.originfile = args[4];
	params.signfile = args[5];
	params.storagetype = args[6];
	params.createdirflag = args[7];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIGetSelectedCertDN()
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIGetSelectedCertDN";
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIRequestCheckUserIDWithFlag(args)
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIRequestCheckUserIDWithFlag";
	params.dnfilters = args[1];
	params.cafilters = args[2];
	params.userid = args[3];
	params.usersaveinfo = args[4];
	WEBSOCKET.send(JSON.stringify(params));
}

function CALLBACK_CQWIDeleteUserInfo()
{
	var params = new Object();
	params.productcode = "PKI_ENT";
	params.funcname = "CQWIDeleteUserInfo";
	WEBSOCKET.send(JSON.stringify(params));
}