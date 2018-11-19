package ncis.intfc.seoa.service;

import java.util.List;

import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.seoa.vo.DeployConfigVO;
import ncis.intfc.seoa.vo.DeployResultVO;
import ncis.intfc.seoa.vo.PackageVO;
import ncis.intfc.seoa.vo.TargetVmInsertDataVO;
import ncis.intfc.seoa.vo.TargetVmVO;

/**
 * @author ShinKeeBong
 *
 */
public interface SeoaService {

	/**
	 * 가상서버별 패키지 조회
	 * @param header
	 * @return
	 */
	List<PackageVO> installedPackage(String machineIp, RestHeaders headers) throws Exception;

	/**
	 * 가상서버 설정파일 배포
	 * @param header
	 * @param deployConfigVO
	 * @return
	 */
	DeployResultVO deployVmConfigFile(RestHeaders headers, DeployConfigVO deployConfigVO) throws Exception;

	/**
	 * TargetVM 등록
	 * @param header
	 * @param targetVmInsertDataVO
	 * @return
	 */
	DeployResultVO insertTargetVM(RestHeaders headers, TargetVmInsertDataVO targetVmInsertDataVO) throws Exception;

	/**
	 * TargetVM 삭제
	 * @param machineIp
	 * @param header
	 * @return
	 */
	DeployResultVO deleteTargetVM(String machineIp, RestHeaders headers) throws Exception;

	/**
	 * TargetVM 업데이트
	 * @param header
	 * @return
	 */
	DeployResultVO updateTargetVM(RestHeaders headers, TargetVmVO targetVmVO) throws Exception;


}
