/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BaseController.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.metadata.ConstraintDescriptor;

import ncis.cmn.security.vo.UserVo;
import ncis.cmn.util.MessageUtil;
import ncis.cmn.util.RequestUtils;
import ncis.cmn.vo.ProcResultVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired(required=true)
	private Validator validator;

	@Resource
	protected MessageUtil messageUtil;


	/**
	 * <pre>
	 * 포털에서 사용
	 * 요청 URL 패턴과 동일한 타일즈 뷰 URL을 리턴한다.
	 * </pre>
	 *
	 * @param request
	 * @return
	 */
	protected String portalTilesView(HttpServletRequest request){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){0}/*$)", "")+".portal";
	}

	/** <pre>
	 * 포털에서 사용
	 * 타일즈 뷰 URL 을 리턴한다.
	 * </pre>
	 *
	 * @param path
	 * @return
	 */
	protected String portalTilesView(String path){
		return path+".portal";
	}

	/**
	 * 포털에서 사용
	 * 요청 URL 패턴과 동일한 타일즈를 호출 하되 마지막 경로를 지정할 수 있도록 한다.
	 * ex> test/insert.do --> test/form.do
	 * @param request
	 * @param lastPath
	 * @return
	 */
	protected String portalTilesView(HttpServletRequest request, String lastPath){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){1}/*$)", "")+"/"+ lastPath +".portal";
	}

	/**
	 * Index 형태의 view 호출
	 * @param request
	 * @return
	 */
	protected String dashIndexTilesView(HttpServletRequest request){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){0}/*$)", "")+".dashIndex";
	}

	/**
	 * <pre>
	 * deshboard에서 사용
	 * 요청 URL 패턴과 동일한 타일즈 뷰 URL을 리턴한다.
	 * </pre>
	 *
	 * @param request
	 * @return
	 */
	protected String dashTilesView(HttpServletRequest request){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){0}/*$)", "")+".dash";
	}

	/** <pre>
	 * deshboard에서 사용
	 * 타일즈 뷰 URL 을 리턴한다.
	 * </pre>
	 *
	 * @param path
	 * @return
	 */
	protected String dashTilesView(String path){
		return path+".dash";
	}

	/**
	 * deshboard에서 사용
	 * 요청 URL 패턴과 동일한 타일즈를 호출 하되 마지막 경로를 지정할 수 있도록 한다.
	 * ex> test/insert.do --> test/form.do
	 * @param request
	 * @param lastPath
	 * @return
	 */
	protected String dashTilesView(HttpServletRequest request, String lastPath){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){1}/*$)", "")+"/"+ lastPath +".dash";
	}

	/**
	 * <pre>
	 * API-Gateway에서 사용
	 * 요청 URL 패턴과 동일한 타일즈 뷰 URL을 리턴한다.
	 * </pre>
	 *
	 * @param request
	 * @return
	 */
	protected String apiTilesView(HttpServletRequest request){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){0}/*$)", "")+".api";
	}

	/** <pre>
	 * API-Gateway에서 사용
	 * 타일즈 뷰 URL 을 리턴한다.
	 * </pre>
	 *
	 * @param path
	 * @return
	 */
	protected String apiTilesView(String path){
		return path+".api";
	}

	/**
	 * API-Gateway에서 사용
	 * 요청 URL 패턴과 동일한 타일즈를 호출 하되 마지막 경로를 지정할 수 있도록 한다.
	 * ex> test/insert.do --> test/form.do
	 * @param request
	 * @param lastPath
	 * @return
	 */
	protected String apiTilesView(HttpServletRequest request, String lastPath){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){1}/*$)", "")+"/"+ lastPath +".api";
	}

	/**
	 * <pre>
	 * 요청 URL 패턴과 동일한 JSTL 뷰 네임을 리턴한다.
	 * </pre>
	 *
	 * @param request
	 * @return
	 */
	protected String jstlView(HttpServletRequest request){
		return jstlView(request,0);
	}

	/** <pre>
	 * 뷰를 팝업창으로 보여주기 위한 타일즈 뷰 URL을 리턴한다.
	 * </pre>
	 *
	 * @param request
	 * @return
	 */
	protected String popup(HttpServletRequest request){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){0}/*$)", "")+".popup";
	}

	protected String popup(HttpServletRequest request, String lastPath){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){1}/*$)", "")+"/"+ lastPath +".popup";
	}


	protected String popup(String path){
		return path+".popup";
	}

	/** <pre>
	 * 요청 URL 패턴과 동일한 JSTL 뷰 네임을 리턴한다.
	 * Depth를 주어 URL의 삭제 깊이를 설정한다.
	 * 예 :
	 * Depth = 1 : /test/submenu/index -> /test/submenu
	 * Depth = 2 : /test/submenu/index -> /test
	 * </pre>
	 *
	 * @param request
	 * @param depth
	 * @return
	 */
	protected String jstlView(HttpServletRequest request, int depth){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){"+depth+"}/*$)", "");
	}

	protected String jstlView(HttpServletRequest request, String lastPath){
		return request.getRequestURI().replaceAll("(^" + request.getContextPath() + "/)|((\\.[^\\.]*)$)|((/[^/]+){1}/*$)", "")+"/"+ lastPath;
	}

	protected String jstlView(String path){
		return path;
	}

	/** <pre>
	 * 입력된 경로로 리다이렉트
	 * </pre>
	 *
	 * @param path
	 * @return
	 */
	protected String redirect(String path){
		return "redirect:"+path;
	}

	/** <pre>
	 * 입력된 경로로 포워드
	 * </pre>
	 *
	 * @param path
	 * @return
	 */
	protected String forward(String path){
		return "forward:"+path;
	}

	/** <pre>
	 * Validation 을 체크한다.
	 * </pre>
	 *
	 * @param target Validation 을 체크할 Model 객체
	 * @param errors
	 * @param groups
	 * @return
	 */
	public boolean isNotValid(Object target, Errors errors, Class<?>... groups) {
		String prefix = target.getClass().getName().split("\\.")[2];
		Set<ConstraintViolation<Object>> result = validator.validate(target, groups);
		for (ConstraintViolation<Object> violation : result) {
			String field = violation.getPropertyPath().toString();
			FieldError fieldError = errors.getFieldError(field);
			if (fieldError == null || !fieldError.isBindingFailure()) {
				ConstraintDescriptor<?> constraintDescriptor = violation.getConstraintDescriptor();
				errors.rejectValue( field, constraintDescriptor.getAnnotation().annotationType().getSimpleName(), getArgumentsForConstraint(prefix, errors.getObjectName(), field, constraintDescriptor), violation.getMessage());
			}
		}
		return errors.hasErrors();
	}

	private Object[] getArgumentsForConstraint(String prefix, String objectName, String field, ConstraintDescriptor<?> descriptor) {
		List<Object> arguments = new LinkedList<Object>();
		String[] codes = new String[] {prefix+Errors.NESTED_PATH_SEPARATOR+objectName + Errors.NESTED_PATH_SEPARATOR + field, objectName + Errors.NESTED_PATH_SEPARATOR + field, field };
		arguments.add(new DefaultMessageSourceResolvable(codes, field));
		Map<String, Object> attributesToExpose = new TreeMap<String, Object>();
		for (Map.Entry<String, Object> entry : descriptor.getAttributes().entrySet()) {
			String attributeName = entry.getKey();
			Object attributeValue = entry.getValue();
			if (!"message".equals(attributeName)  && !"groups".equals(attributeName) && !"payload".equals(attributeName)) {
				attributesToExpose.put(attributeName, attributeValue);
			}
		}
		arguments.addAll(attributesToExpose.values());
		return arguments.toArray(new Object[arguments.size()]);
	}

	/** <pre>
	 * Validation 체크 후 Validation 결과를 담아 리턴한다.
	 * </pre>
	 *
	 * @param target
	 * @param errors
	 * @param groups
	 * @return
	 */
	public ProcResultVo getBindingResult(Object target, Errors errors, Class<?>... groups){
		ProcResultVo procResultVO = new ProcResultVo();
		if(isNotValid(target,errors,groups)){
			procResultVO.setSuccess(false);
			procResultVO.setMessageList(messageUtil.getFieldErrorMessageList(errors));
		}else{
			procResultVO.setSuccess(true);
		}
		return procResultVO;
	}

	/** <pre>
	 * 바인딩 결과를 리턴한다.
	 * </pre>
	 *
	 * @param errors
	 * @return
	 */
	public ProcResultVo getBindingResult(Errors errors){
		ProcResultVo procResultVO = new ProcResultVo();
		if(errors.hasErrors()){
			procResultVO.setSuccess(false);
			procResultVO.setMessageList(messageUtil.getFieldErrorMessageList(errors));
		}else{
			procResultVO.setSuccess(true);
		}
		return procResultVO;
	}

	/** <pre>
	 * 현재 로그인 된 사용자의 ID 정보를 리턴한다.
	 * </pre>
	 *
	 * @return
	 */
	public String getUserId(){
		return RequestUtils.getUserId();
	}

	/** <pre>
	 * 로그인한 사용자 정보를 리턴한다.
	 * </pre>
	 *
	 * @return
	 */
	public UserVo getUser(){

		return RequestUtils.getUser();
	}

	/** <pre>
	 * 현재 로그인한 사용자의 이름정보를 리턴한다.
	 * </pre>
	 *
	 * @return
	 */
	public String getUserName(){
		return RequestUtils.getUserName();
	}

	public List<String> selectUserRoleList() {
		return RequestUtils.selectUserRoleList();
	}

	public boolean isSysAdm() {
    	return getUser().isSysAdm();
    }

    public boolean isOprAdm() {
    	return getUser().isOprAdm();
    }

    public boolean isOprChr() {
    	return getUser().isOprChr();
    }

	/** <pre>
	 * 처리 성공시  결과를 리턴한다.
	 * </pre>
	 *
	 * @return
	 */
	public ProcResultVo getSuccessProcResult(){
		return getSuccessProcResult(null, null, null);
	}

	/**
	 * 처리 성공 시 실행 타입에 의한 결과 리턴
	 * @param procType
	 * @return
	 */
	public ProcResultVo getSuccessProcResult(String procType){
		return getSuccessProcResult(null, procType, null);
	}

	/** <pre>
     * 처리 성공시  결과를 리턴한다.
     * 메시지 코드에 해당하는 메시지를 메시지리스트에 넣어준다
     * </pre>
     *
     * @param messageCode messageCode 메시지 키 값
     * @param procType procType
     * @return
     */
    public ProcResultVo getSuccessProcResult(String message, String procType){
        ProcResultVo procResultVO = new ProcResultVo();
        procResultVO.setSuccess(true);
        if(message != null){
            procResultVO.addMessage(message);
        }
        procResultVO.setProcType(procType);
        return procResultVO;
    }

	/** <pre>
	 * 처리 성공시  결과를 리턴한다.
	 * 메시지 코드에 해당하는 메시지를 메시지리스트에 넣어준다
	 * </pre>
	 *
	 * @param messageCode messageCode 메시지 키 값
	 * @param procType procType
	 * @param data 데이타
	 * @return
	 */
	public ProcResultVo getSuccessProcResult(String message, String procType, Object data){
		ProcResultVo procResultVO = new ProcResultVo();
		procResultVO.setSuccess(true);
		if(message != null){
			procResultVO.addMessage(message);
		}
		procResultVO.setProcType(procType);
		procResultVO.setData(data);
		return procResultVO;
	}

	public ProcResultVo getFailProcResult(String message){
		return getFailProcResult(message, null, null);
	}

	/** <pre>
     * 처리 실패시  결과를 리턴한다.
     * 메시지 코드에 해당하는 메시지를 메시지리스트에 넣어준다.
     * </pre>
     *
     * @param messageCode 메시지 키 값
     * @param procType procType
     * @return
     */
    public ProcResultVo getFailProcResult(String message, String procType){
        ProcResultVo procResultVO = new ProcResultVo();
        procResultVO.setSuccess(false);
        if(message != null){
        	logger.error("BaseController : " + message);
            procResultVO.addMessage(message);
        }
        procResultVO.setProcType(procType);
        return procResultVO;
    }

	/** <pre>
	 * 처리 실패시  결과를 리턴한다.
	 * 메시지 코드에 해당하는 메시지를 메시지리스트에 넣어준다.
	 * </pre>
	 *
	 * @param messageCode 메시지 키 값
	 * @param procType procType
	 * @param data 데이타
	 * @return
	 */
	public ProcResultVo getFailProcResult(String message, String procType, Object data){
		ProcResultVo procResultVO = new ProcResultVo();
		procResultVO.setSuccess(false);
		if(message != null){
			procResultVO.addMessage(message);
		}
		procResultVO.setProcType(procType);
		procResultVO.setData(data);

		System.out.println( procResultVO.toString() );

		return procResultVO;
	}

}
