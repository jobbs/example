/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SeoaServiceImpl.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.seoa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.seoa.service.SeoaService;
import ncis.intfc.seoa.vo.DeployConfigVO;
import ncis.intfc.seoa.vo.DeployResultVO;
import ncis.intfc.seoa.vo.PackageVO;
import ncis.intfc.seoa.vo.TargetVmInsertDataVO;
import ncis.intfc.seoa.vo.TargetVmVO;
import ncis.intfc.seoa.vo.VmPackageVO;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * @author ShinKeeBong
 *
 */
@Service("seoaService")
public class SeoaServiceImpl implements SeoaService {

	@Resource(name="restSender") private RestSender restSender;

	/**
	 * 가상서버별 패키지 조회
	 * @param machineIp
	 * @param header
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * --------------------------------------------------------------------------------------------
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * @return
	 */
	@Override
	public List<PackageVO> installedPackage(String machineIp, RestHeaders headers)
			throws Exception {

		String url = "/SeoaApi/installedPackage?machineIp="+machineIp;

		return restSender.send(url, headers, VmPackageVO.class, HttpMethod.GET).getBody().getPackages();
	}

	/**
	 * 가상서버 설정파일 배포
	 * @param header
	 * @param deployConfigVO
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * --------------------------------------------------------------------------------------------
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * @return
	 */
	@Override
	public DeployResultVO deployVmConfigFile(RestHeaders headers, DeployConfigVO deployConfigVO)
			throws Exception {

		String url = "/SeoaApi/distribute";

		return restSender.send(url, deployConfigVO, headers, DeployResultVO.class, HttpMethod.POST).getBody();
	}

	/**
	 * TargetVM 등록
	 * @param header
	 * @param targetVmInsertDataVO
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * --------------------------------------------------------------------------------------------
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * @return
	 */
	@Override
	public DeployResultVO insertTargetVM(RestHeaders headers,
			TargetVmInsertDataVO targetVmInsertDataVO) throws Exception {

		String url = "/SeoaApi/ManagementVm";

	//	headers.setContentType("application/json");

		return restSender.send(url, targetVmInsertDataVO, headers, DeployResultVO.class, HttpMethod.POST).getBody();
	}

	/**
	 * TargetVM 삭제
	 * @param machineIp
	 * @param header
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * --------------------------------------------------------------------------------------------
	 *          machineIp	       TargetVM 의 아이피	                      String		Y
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * @return
	 */
	@Override
	public DeployResultVO deleteTargetVM(String machineIp, RestHeaders headers)
			throws Exception {

		String url = "/SeoaApi/ManagementVm/" + machineIp +"/";

		return restSender.send(url, headers, DeployResultVO.class, HttpMethod.DELETE).getBody();
	}

	/**
	 * TargetVM 업데이트
	 * @param header
	 * @param targetVmVO
	 *
	 * 분류     항목               항목명	                                  타입		   필수여부
	 * --------------------------------------------------------------------------------------------
	 *          machineIp	       TargetVM 의 아이피	                      String		Y
	 *
	 * Header	areaId	           지역ID	                                  String		Y
	 * Header	zoneId	           존 ID	                                  String		Y
	 * Header	networkId	       망 ID	                                  String		Y
	 * Header	managerId	       매니저 ID                                  String		Y
	 *
	 * @return
	 */
	@Override
	public DeployResultVO updateTargetVM(RestHeaders headers, TargetVmVO targetVmVO) throws Exception {

		String url = "/SeoaApi/ManagementVm/" + targetVmVO.getMachineIp();

		return restSender.send(url, targetVmVO, headers, DeployResultVO.class, HttpMethod.POST).getBody();
	}
}
