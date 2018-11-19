/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ReqRestController.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.request.web;

import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.rest.intfc.cmm.ResultMessage;
import ncis.rest.intfc.request.service.RegService;
import ncis.rest.intfc.request.vo.CreateClusterVO;
import ncis.rest.intfc.request.vo.CreatePmVO;
import ncis.rest.intfc.request.vo.CreateSLBVO;
import ncis.rest.intfc.request.vo.CreateVmVO;
import ncis.rest.intfc.request.vo.ModifyVmVO;
import ncis.rest.intfc.request.vo.RemoveClusterVO;
import ncis.rest.intfc.request.vo.RemovePmVO;
import ncis.rest.intfc.request.vo.RemoveReqVO;
import ncis.rest.intfc.request.vo.RemoveVmVO;
import ncis.rest.intfc.request.vo.ReqResultVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 요청정보수신 Controller
 *
 * @author ShinKeeBong
 *
 */

@RestController
@RequestMapping(value="/rest", produces = { "application/json" })
public class ReqRestController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="regService")
	private RegService regService;


	/**
	 * ReqRestController 의 exception Handler
	 * @param req
	 * @param ex
	 * @return
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody ResponseEntity<ReqResultVO> handleInternalServerError(HttpServletRequest req, Exception ex){
		//ex.printStackTrace();
		logger.error(ex.getMessage(), ex);
		ReqResultVO errorVO = new ReqResultVO();
		String resultCode = "IFM0001"; // 시스템 오류
		if(req.getAttribute("reqId") !=null){
			errorVO.setReqId((String)req.getAttribute("reqId"));
		}
		errorVO.setResultCode(resultCode);
		errorVO.setMessage(ResultMessage.Message(resultCode)+":"+ex.getMessage());
		return new ResponseEntity<ReqResultVO>(errorVO, HttpStatus.OK);
	}

	/**
	 * 가상서버 생성 요청정보 수신
	 * @param key
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/createVM", method=RequestMethod.POST)
	@ApiOperation(value = "가상서버 생성 요청정보 수신", notes = "가상서버 생성 요청정보를 수신하여 포탈로 전달한다.", response = ReqResultVO.class)
	public ReqResultVO createVM(HttpServletRequest req, @RequestHeader(required=true) String authorization, @RequestBody CreateVmVO param) throws Exception{
		ReqResultVO reqResultVO = regService.createVM(param);
		return reqResultVO;
	}


	/**
	 * 가상서버 변경 요청정보 수신
	 * @param key
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/modifyVM", method=RequestMethod.POST)
	@ApiOperation(value = "가상서버 변경 요청정보 수신", notes = "가상서버 변경 요청정보를 수신하여 포탈로 전달한다.", response = ReqResultVO.class)
	public ReqResultVO modifyVM(HttpServletRequest req, @RequestHeader(required=true) String authorization, @RequestBody ModifyVmVO param) throws Exception{
		ReqResultVO reqResultVO = regService.modifyVM(param);
		return reqResultVO;
	}

	/**
	 * 가상서버 삭제 요청정보 수신
	 * @param key
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/removeVM", method=RequestMethod.POST)
	@ApiOperation(value = "가상서버 삭제 요청정보 수신", notes = "가상서버 삭제 요청정보를 수신하여 포탈로 전달한다.", response = ReqResultVO.class)
	public ReqResultVO removeVM(HttpServletRequest req, @RequestHeader(required=true) String authorization, @RequestBody RemoveVmVO param) throws Exception{
		ReqResultVO reqResultVO = regService.removeVM(param);
		return reqResultVO;
	}


	/**
	 * 물리서버 생성 요청정보 수신
	 * @param key
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/createPM", method=RequestMethod.POST)
	@ApiOperation(value = "물리서버 생성 요청정보 수신", notes = "물리서버 생성 요청정보를 수신하여 포탈로 전달한다.", response = ReqResultVO.class)
	public ReqResultVO createPM(HttpServletRequest req, @RequestHeader(required=true) String authorization, @RequestBody CreatePmVO param)  throws Exception{
		ReqResultVO reqResultVO = regService.createPM(param);
		return reqResultVO;
	}


	/**
	 * 물리서버 삭제 요청정보 수신
	 * @param key
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/removePM", method=RequestMethod.POST)
	@ApiOperation(value = "물리서버 삭제 요청정보 수신", notes = "물리서버 삭제 요청정보를 수신하여 포탈로 전달한다.", response = ReqResultVO.class)
	public ReqResultVO removePM(HttpServletRequest req, @RequestHeader(required=true) String authorization, @RequestBody RemovePmVO param)  throws Exception{
		ReqResultVO reqResultVO = regService.removePM(param);
		return reqResultVO;
	}


	/**
	 * 클러스터 생성 요청정보 수신
	 * @param key
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/createCluster", method=RequestMethod.POST)
	@ApiOperation(value = "클러스터 생성 요청정보 수신", notes = "클러스터 생성 요청정보 수신하여 포탈로 전달한다.", response = ReqResultVO.class)
	public ReqResultVO createCluster(HttpServletRequest req, @RequestHeader(required=true) String authorization, @RequestBody CreateClusterVO param)  throws Exception{
		ReqResultVO reqResultVO = regService.createCluster(param);
		return reqResultVO;
	}


	/**
	 * 클러스터 삭제 요청정보 수신
	 * @param key
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/removeCluster", method=RequestMethod.POST)
	@ApiOperation(value = "클러스터 삭제 요청정보 수신", notes = "클러스터 삭제요청을 수신하여 포탈로 전달한다.", response = ReqResultVO.class)
	public ReqResultVO removeCluster(HttpServletRequest req, @RequestHeader(required=true) String authorization, @RequestBody RemoveClusterVO param) throws Exception{
		ReqResultVO reqResultVO = regService.removeCluster(param);
		return reqResultVO;
	}


	/**
	 * SLB 생성 요청정보 수신
	 * @param key
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/createSLB", method=RequestMethod.POST)
	@ApiOperation(value = "SLB 요청정보 수신", notes = "SLB 요청을 수신하여 포탈로 전달한다.", response = ReqResultVO.class)
	public ReqResultVO createSLB(HttpServletRequest req, @RequestHeader(required=true) String authorization, @RequestBody CreateSLBVO param) throws Exception{
		ReqResultVO reqResultVO = regService.createSLB(param);
		return reqResultVO;
	}



	/**
	 * 요청취소 요청정보 수신
	 * @param key
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/removeReq", method=RequestMethod.POST)
	@ApiOperation(value = "요청취소 요청정보 수신", notes = "요청취소 요청정보를 수신하여 포탈로 전달한다.", response = ReqResultVO.class)
	public ReqResultVO removeReq(HttpServletRequest req, @RequestHeader(required=true) String authorization, @RequestBody RemoveReqVO param) throws Exception{
		ReqResultVO reqResultVO = regService.removeReq(param);
		return reqResultVO;
	}

}
