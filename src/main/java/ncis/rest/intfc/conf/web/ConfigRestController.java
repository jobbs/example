/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ConfigRestController.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 21.
 * @lastmodified 2016. 9. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.conf.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ncis.rest.intfc.cmm.ResultMessage;
import ncis.rest.intfc.cmm.vo.ResultVO;
import ncis.rest.intfc.conf.service.ConfigService;
import ncis.rest.intfc.conf.vo.ApplInfoVO;
import ncis.rest.intfc.conf.vo.CategoryCodeVO;
import ncis.rest.intfc.conf.vo.CfImgVO;
import ncis.rest.intfc.conf.vo.CfServcNsVO;
import ncis.rest.intfc.conf.vo.CfServcVO;
import ncis.rest.intfc.conf.vo.CfBldConfVO;
import ncis.rest.intfc.conf.vo.CfDistrbConfVO;
import ncis.rest.intfc.conf.vo.CfServcSclngVO;
import ncis.rest.intfc.conf.vo.ClusterVO;
import ncis.rest.intfc.conf.vo.PmVO;
import ncis.rest.intfc.conf.vo.SoftwareVO;
import ncis.rest.intfc.conf.vo.SpecInfoVO;
import ncis.rest.intfc.conf.vo.TemplateSwVO;
import ncis.rest.intfc.conf.vo.TemplateVO;
import ncis.rest.intfc.conf.vo.VmVO;
import ncis.rest.intfc.conf.vo.ZoneVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 구성정보 제공 Controller
 *
 * @author ShinKeeBong
 *
 */
@Api(value = "Config API")
@RestController
@RequestMapping(value="/rest",  produces = { "application/json" })
public class ConfigRestController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="configService")
	private ConfigService configService;


	/**
	 * ConfigRestController 의 exception Handler
	 * @param req
	 * @param ex
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody ResponseEntity<ResultVO> handleInternalServerError(HttpServletRequest req, Exception ex){
		//ex.printStackTrace();
//		logger.error(ex.getMessage(), ex);
		logger.error(ex.getMessage());
		ResultVO errorVO = new ResultVO();
		String resultCode="IFM0001";
		errorVO.setResultCode(resultCode);
		errorVO.setResultCnt(0);
		errorVO.setMessage(ResultMessage.Message(resultCode)+":"+ex.getMessage());
		return new ResponseEntity<ResultVO>(errorVO, HttpStatus.OK);
	}

	/**
	 * 존 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/zones", method=RequestMethod.GET)
	@ApiOperation(value = "Zone 목록 조회", notes = "Zone 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectZoneInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<ZoneVO> data = configService.selectZoneInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}

	/**
	 * 클러스터 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/clusters", method=RequestMethod.GET)
	@ApiOperation(value = "Cluster 목록 조회", notes = "Cluster 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectClusterInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<ClusterVO> data  = configService.selectClusterInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}


	/**
	 * 물리서버 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/pms", method=RequestMethod.GET)
	@ApiOperation(value = "물리서버 구성정보 목록조회", notes = "물리서버 구성정보의 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectPmInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<PmVO> data  = configService.selectPmInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}


	/**
	 * 가상서버 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/vms", method=RequestMethod.GET)
	@ApiOperation(value = "가성서버 구성정보 목록조회", notes = "가상서버 구성정보의 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectVmInfoList( @RequestHeader(required=true) String authorization) throws Exception
	{
		List<VmVO> data = configService.selectVmInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}


	/**
	 * 가상서버템플릿 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/templates", method=RequestMethod.GET)
	@ApiOperation(value = "가상서버 구성정보 목록조회", notes = "가상서버 구성정보의 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectTemplateInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<TemplateVO> data = configService.selectTemplateInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}


	/**
	 * 소프트웨어 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/sws", method=RequestMethod.GET)
	@ApiOperation(value = "소프트웨어 구성정보 목록조회", notes = "소프트웨어 구성정보의 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectSoftwareInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<SoftwareVO> data = configService.selectSoftwareInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}


	/**
	 * 템플릿소프트웨어 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/templateSws", method=RequestMethod.GET)
	@ApiOperation(value = "템플릿소프트웨어 구성정보 목록조회", notes = "템플릿소프트웨어 구성정보의 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectTemplateSwInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<TemplateSwVO> data = configService.selectTemplateSwInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}


	/**
	 * 스펙정보 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/vmspecs", method=RequestMethod.GET)
	@ApiOperation(value = "스펙정보 구성정보 목록조회", notes = "스펙정보 구성정보의 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectSpecInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<SpecInfoVO> data = configService.selectSpecInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}


	/**
	 * 구분코드 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	@ApiOperation(value = "구분코드 구성정보 목록조회", notes = "구분코드 구성정보의 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectCategoryCodeInfoList( @RequestHeader(required=true) String authorization) throws Exception
	{
		List<CategoryCodeVO> data = configService.selectCategoryCodeInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}


	/**
	 * 업무정보 구성정보 목록 조회
	 * @param model
	 * @return  ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/appls", method=RequestMethod.GET)
	@ApiOperation(value = "업무정보 구성정보 목록조회", notes = "업무정보 구성정보의 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectApplInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<ApplInfoVO> data = configService.selectApplInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}

	/**
	 * 서비스영역 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/servcns", method=RequestMethod.GET)
	@ApiOperation(value = "서비스영역 목록 조회", notes = "서비스영역 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectServcnsInfoList(@RequestHeader(required=true) String authorization,@RequestParam(required = false) String servcAreaCompId) throws Exception
	{
		CfServcNsVO vo = new CfServcNsVO();
		vo.setServcAreaCompId(servcAreaCompId);
		List<CfServcNsVO> data = configService.selectServcnsInfoList(vo);
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}

	/**
	 * 서비스 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/servc", method=RequestMethod.GET)
	@ApiOperation(value = "서비스 목록 조회", notes = "서비스 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectServcInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<CfServcVO> data  = configService.selectServcInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}

	/**
	 * 빌드 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/buildconfigs", method=RequestMethod.GET)
	@ApiOperation(value = "빌드 목록 조회", notes = "빌드 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectBuildInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<CfBldConfVO> data  = configService.selectBuildInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}

	/**
	 * 디플로이 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/deploymentconfigs", method=RequestMethod.GET)
	@ApiOperation(value = "빌드 목록 조회", notes = "빌드 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectDeployInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<CfDistrbConfVO> data  = configService.selectDeployInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}

	/**
	 * 스케일링 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/autoscaler", method=RequestMethod.GET)
	@ApiOperation(value = "스케일링 목록 조회", notes = "스케일링 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectAutoScalerInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<CfServcSclngVO> data  = configService.selectAutoScalerInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}
	/**
	 * 베이스이미지 구성정보 목록 조회
	 * @param model
	 * @return ResponseEntity<ResultVO>
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/img", method=RequestMethod.GET)
	@ApiOperation(value = "베이스이미지 구성정보 목록조회", notes = "베이스이미지 구성정보의 목록을 조회한다.", response = ResultVO.class)
	public ResponseEntity<ResultVO> selectImgInfoList(@RequestHeader(required=true) String authorization) throws Exception
	{
		List<CfImgVO> data  = configService.selectImgInfoList();
		return ResultMessage.SuccessResultVO("IFM0000", data);
	}
}
