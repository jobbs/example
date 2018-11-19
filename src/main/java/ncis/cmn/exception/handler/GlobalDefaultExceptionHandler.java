/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename GlobalDefaultExceptionHandler.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 11. 25.
 * @lastmodified 2016. 11. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 25.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.exception.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.exception.CommonException;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.exception.DownFileNotFoundException;
import ncis.cmn.exception.ExceptionScriptPrint;
import ncis.cmn.exception.JsonException;
import ncis.cmn.exception.NotAllowedFileExtException;
import ncis.cmn.exception.UploadFileSizeExceededException;
import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.ProcResultVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 최진호
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

	@ExceptionHandler(UploadFileSizeExceededException.class)
	public void handlerUploadFileSizeExceededException(HttpServletRequest request, HttpServletResponse response, UploadFileSizeExceededException e) throws IOException {

		ProcResultVo procResultVo = new ProcResultVo();
	    procResultVo.setSuccess(false);
	    procResultVo.addMessage(e.getMessage());
	    RequestUtils.printJsonObject(response, procResultVo);
	}

	@ExceptionHandler(NotAllowedFileExtException.class)
	public void handlerNotAllowedFileExtException(HttpServletResponse response, NotAllowedFileExtException e) throws IOException {

	    ProcResultVo procResultVo = new ProcResultVo();
	    procResultVo.setSuccess(false);
	    procResultVo.addMessage(e.getMessage());
	    RequestUtils.printJsonObject(response, procResultVo);
	}

	@ExceptionHandler(JsonException.class)
	public void handlerJsoneException(HttpServletRequest request, HttpServletResponse response, JsonException e) throws IOException {

		ProcResultVo procResultVo = new ProcResultVo();
	    procResultVo.setSuccess(false);
	    procResultVo.addMessage(e.getMessage());
	    RequestUtils.printJsonObject(response, procResultVo);
	}

	@ExceptionHandler(DownFileNotFoundException.class)
	public String handlerDownFileNotFoundException(HttpServletRequest request, DownFileNotFoundException e) {
	    logger.error(getExceptionMsg(e));
	    request.setAttribute("message", "대상 파일을 찾을 수 없습니다.");
	    return "error/common";
	}

	@ExceptionHandler(DataNotFoundException.class)
	public String handlerDataNotFoundException(HttpServletRequest request, DataNotFoundException e) {
	    logger.error(getExceptionMsg(e));
	    request.setAttribute("message", e.getMessage());
        return "error/common";
	}

	@ExceptionHandler(CommonException.class)
    public String handlerCommonException(HttpServletRequest request, CommonException e) {
	    logger.error(getExceptionMsg(e));
        request.setAttribute("message", e.getMessage());
        return "error/common";
    }

	@ExceptionHandler(ExceptionScriptPrint.class)
    public void handlerExceptionScriptPrint(HttpServletResponse response, ExceptionScriptPrint e) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        StringBuffer script = new StringBuffer();
        script.append("<script type='text/javascript'>")
        		.append("	alert('" + e.getMessage() + "');");


        switch (e.getActionType()) {
		case CLOSE:
			script.append(" window.close();");
			break;

		case OPENERRELOAD:
			script.append(" opener.location.reload();");
			break;

		case OPENERRELOADCLOSE:
			script.append("	window.close();");
			script.append(" opener.location.reload();");
			break;

		default:
			script.append("	history.back();");
			break;
		}

        script.append("</script>");

        out.print(script.toString());

        out.flush();
        out.close();


    }


	@ExceptionHandler(Exception.class)
    public String handlerException(HttpServletRequest request, Exception e) {
	    logger.error(getExceptionMsg(e));
        return "error/common";
    }

	/**
	 * Exception Handler 에서 사용할 Exception Massage
	 * @param e
	 * @return
	 */
	private String getExceptionMsg(Exception e) {

	    StackTraceElement[] arrSte = e.getStackTrace();
	    StackTraceElement ste = null;

	    int steLen = arrSte.length;

	    StringBuffer errorMsg = new StringBuffer().append("\r\n").append(e.getClass()).append(" : ").append(e.getMessage());

	    for( int i=0; i < steLen; i++ ) {
	        ste = arrSte[i];
	        if( i >= 30 ) {
	            errorMsg
                .append("\r\n\t...")
                .append(" more");

	            break;
	        } else {
	            errorMsg
	                .append("\r\n\tat")
	                .append(ste.toString());
	        }
	    }

	    return errorMsg.toString();
	}

}
