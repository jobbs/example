/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetwkStackService.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 21.
 * @lastmodified 2016. 10. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 21.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.service;

import java.util.List;

import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.BuildConfigsIfVo;
import ncis.intfc.atmscl.vo.DeploymentConfigsIfVo;
import ncis.intfc.atmscl.vo.ImagestreamsIfVo;
import ncis.intfc.atmscl.vo.PodIfVo;
import ncis.intfc.atmscl.vo.RoutesIfVo;
import ncis.intfc.atmscl.vo.SecretsIfVo;
import ncis.intfc.atmscl.vo.ServicesIfVo;

/**
 * @author x
 *
 */
public interface ServcAPIService {

	/**
	 * 보안키 생성
	 * @param header
	 * @param secretsIfVo
	 * @return
	 */
	AtmSclResultIfVo secretsPost(RestHeaders headers, SecretsIfVo secretsIfVo) throws Exception;


	/**
	 * 서비스 생성
	 * @param header
	 * @param secretsIfVo
	 * @return
	 */
	AtmSclResultIfVo servicesPost(RestHeaders headers, ServicesIfVo secretsIfVo) throws Exception;


	/**
	 * 서비스 수정
	 * @param header
	 * @param secretsIfVo
	 * @return
	 */
	AtmSclResultIfVo servicesPut(RestHeaders headers, ServicesIfVo secretsIfVo) throws Exception;


	/**
	 * 라우트 생성
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	AtmSclResultIfVo routesPost(RestHeaders headers, RoutesIfVo routesIfVo) throws Exception;


	/**
	 * 이미지스트립 생성
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	AtmSclResultIfVo imagestreamsPost(RestHeaders headers, ImagestreamsIfVo imagestreamsIfVo) throws Exception;


	/**
	 * 빌드설정 생성
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	AtmSclResultIfVo buildconfigsPost(RestHeaders headers, BuildConfigsIfVo buildConfigsIfVo) throws Exception;

	/**
	 * 빌드설정 수정
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	AtmSclResultIfVo buildconfigsPut(RestHeaders headers, BuildConfigsIfVo buildConfigsIfVo) throws Exception;


	/**
	 * 빌드 생성
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	AtmSclResultIfVo instantiatePost(RestHeaders headers, BuildConfigsIfVo buildConfigsIfVo) throws Exception;


	/**
	 * 배포설정 생성
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	AtmSclResultIfVo deploymentConfigsPost(RestHeaders headers, DeploymentConfigsIfVo deploymentConfigsIfVo) throws Exception;


	/**
	 * 배포설정 수정
	 * @param header
	 * @param namespaceVO
	 * @return
	 */
	AtmSclResultIfVo deploymentConfigsPut(RestHeaders headers, DeploymentConfigsIfVo deploymentConfigsIfVo) throws Exception;


	/**
	 * 서비스 삭제
	 * @param header
	 * @param servicesIfVo
	 * @return
	 */
	AtmSclResultIfVo servicesDelete(RestHeaders headers, ServicesIfVo servicesIfVo) throws Exception;



	/**
	 * Pod정보 조회
	 * @param header
	 * @param deploymentConfigsIfVo
	 * @return
	 */
	List<PodIfVo> podsGet(RestHeaders headers, DeploymentConfigsIfVo vo) throws Exception;


	/**
	 * 빌드상태 조회
	 * @param header
	 * @param deploymentConfigsIfVo
	 * @return
	 */
	AtmSclResultIfVo buildsGet(RestHeaders headers, BuildConfigsIfVo buildConfigsIfVo) throws Exception;


	/**
	 * 배포상태 조회
	 * @param header
	 * @param deploymentConfigsIfVo
	 * @return
	 */
	AtmSclResultIfVo replicationcontrollersStatGet(RestHeaders headers, DeploymentConfigsIfVo deploymentConfigsIfVo) throws Exception;


	/**
	 * Pod상태 조회
	 * @param header
	 * @param deploymentConfigsIfVo
	 * @return
	 */
	AtmSclResultIfVo podsStatGet(RestHeaders headers, DeploymentConfigsIfVo deploymentConfigsIfVo) throws Exception;


	/**
	 * 라우터 삭제
	 * @param header
	 * @param routesIfVo
	 * @return
	 */
	void routesDelete(RestHeaders headers, String namespaceId, String name) throws Exception;


	/**
	 * 이미지스트림 삭제
	 * @param header
	 * @param imagestreamsIfVo
	 * @return
	 */
	void imagestreamsDelete(RestHeaders headers, String namespaceId, String name) throws Exception;


	/**
	 * 빌드설정 삭제
	 * @param header
	 * @param buildConfigsIfVo
	 * @return
	 */
	void buildconfigsDelete(RestHeaders headers, String namespaceId, String name) throws Exception;


	/**
	 * 배포설정 삭제
	 * @param header
	 * @param deploymentConfigsIfVo
	 * @return
	 */
	void deploymentConfigsDelete(RestHeaders headers, String namespaceId, String name) throws Exception;


	/**
	 * 배포이력 삭제
	 * @param header
	 * @param deploymentConfigsIfVo
	 * @return
	 */
	void replicationcontrollersDelete(RestHeaders headers, String namespaceId, String name) throws Exception;



	/**
	 * 빌드이력 삭제
	 * @param namespaceId
	 * @param name
	 * @return
	 */
	void buildsDelete(RestHeaders headers, String namespaceId, String name) throws Exception;


	/**
	 * Pod 삭제
	 * @param namespaceId
	 * @param name
	 * @return
	 */
	void podsDelete(RestHeaders headers, String namespaceId, String name) throws Exception;

}
