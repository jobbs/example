/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RestInterceptor.java
 *
 * @author 이해룡
 * @lastmodifier 이해룡
 * @created 2016. 12. 01.
 * @lastmodified 2016. 12. 01.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 01.     이해룡         v1.0             최초생성
 *
 */
package ncis.cmn.rest.interceptors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ncis.cmn.util.DateUtil;
import ncis.rest.intfc.cmm.ResultMessage;
import ncis.rest.intfc.cmm.service.KeyCertService;
import ncis.rest.intfc.cmm.vo.ResultVO;
import ncis.rest.intfc.request.vo.ReqResultVO;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProviderRestInterceptor extends HandlerInterceptorAdapter {

	@Resource(name="keyCertService")
	private KeyCertService keyCertService;

    @Override
    @SuppressWarnings("rawtypes")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    	response.setContentType("application/json");

    	String authorization = request.getHeader("authorization");

        //System.out.println("authorization="+authorization);

        ObjectMapper mapper = new ObjectMapper();
        if(StringUtils.isEmpty(authorization) ) {
        	response.setCharacterEncoding("UTF-8");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            if(request.getMethod().equals("GET")){
	    		ResultVO errorVO = new ResultVO();
	    		String resultCode="IFM1002";
	    		errorVO.setResultCode(resultCode);
	    		errorVO.setResultCnt(0);
	    		errorVO.setGatherDate(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
	    		errorVO.setMessage(ResultMessage.Message(resultCode));
	            response.getWriter().write(mapper.writeValueAsString(errorVO));
            }else if(request.getMethod().equals("POST")){
            	String jsonBody = getJsonBody(request);
    			ReqResultVO errorVO = new ReqResultVO();
    			String reqId=null;
    			if(jsonBody !=null){
    				JSONObject jo =new JSONObject(jsonBody);
    				reqId=jo.getString("reqId");
    			}
    			if(reqId != null){
	    			errorVO.setReqId(reqId);
	    			request.setAttribute("reqId", reqId);
    			}
    			String resultCode = "IFM1002"; // 유효하지 않은 인증키
    			errorVO.setResultCode(resultCode);
    			errorVO.setMessage(ResultMessage.Message(resultCode));
    			response.getWriter().write(mapper.writeValueAsString(errorVO));
            }
            return false;
        }

        // OpenApi 토큰 인증 부분
        // 2017.02.06 주석처리 후 연계 테스트 진행
/*
        if(!keyCertService.isCertifiedKey(authorization))
		{
			response.setCharacterEncoding("UTF-8");
            if(request.getMethod().equals("GET")){//Config api
	    		ResultVO errorVO = new ResultVO();
	    		String resultCode="IFM1002";
	    		errorVO.setResultCode(resultCode);
	    		errorVO.setResultCnt(0);
	    		errorVO.setGatherDate(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
	    		errorVO.setMessage(ResultMessage.Message(resultCode));
	            response.getWriter().write(mapper.writeValueAsString(errorVO));
            }else if(request.getMethod().equals("POST")){//Req api
    			String jsonBody = getJsonBody(request);
    			//System.out.println("jsonBody="+jsonBody);
    			ReqResultVO errorVO = new ReqResultVO();

    			String reqId=null;
    			if(jsonBody !=null){
    				JSONObject jo =new JSONObject(jsonBody);
    				reqId=jo.getString("reqId");
    			}
    			if(reqId != null){
	    			errorVO.setReqId(reqId);
	    			request.setAttribute("reqId", reqId);
    			}
    			String resultCode = "IFM1002"; // 유효하지 않은 인증키
    			errorVO.setResultCode(resultCode);
    			errorVO.setMessage(ResultMessage.Message(resultCode));
    			response.getWriter().write(mapper.writeValueAsString(errorVO));
            }
            return false;
		}
*/
        return true;
    }

    /**
     * json형식의 body를 String형태로 가져 온다.
     * @param req
     * @return
     * @throws IOException
     */
    public String getJsonBody(HttpServletRequest req) throws IOException{
    	String body="";
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = null;
    	InputStream in = null;
    	try{
    		in = req.getInputStream();
    		if(in !=null){
    			br = new BufferedReader(new InputStreamReader(in));
    			char[] cBuff = new char[1024];
    			int readBytes=-1;
    			while((readBytes = br.read(cBuff))>0){
    				sb.append(cBuff, 0, readBytes);
    			}
    		}
    	}catch(IOException ex){
    		throw ex;
    	}finally{
    		if(br !=null){
    			try{
    				br.close();
    			}catch(IOException ex){
    				throw ex;
    			}
    		}
    	}
    	body= sb.toString();
    	return body;
    }
}
