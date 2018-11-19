/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ConfigService.java
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
package ncis.rest.intfc.conf.service;

import java.util.List;

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

/**
 * 구성정보 제공 Service
 *
 * @author ShinKeeBong
 *
 */
public interface ConfigService {

	/**
	 * 존 구성정보 목록 조회
	 * @return List<ZoneVO>
	 */

	List<ZoneVO> selectZoneInfoList() throws Exception;

	/**
	 * 클러스터 구성정보 목록 조회
	 * @return List<ClusterVO>
	 */
	List<ClusterVO> selectClusterInfoList() throws Exception;

	/**
	 * 물리서버 구성정보 목록 조회
	 * @return List<PmVO>
	 */
	List<PmVO> selectPmInfoList() throws Exception;

	/**
	 * 가상서버 구성정보 목록 조회
	 * @return List<VmVO>
	 */
	List<VmVO> selectVmInfoList() throws Exception;

	/**
	 * 가상서버템플릿 구성정보 목록 조회
	 * @return List<TemplateVO>
	 */
	List<TemplateVO> selectTemplateInfoList() throws Exception;

	/**
	 * 소프트웨어 구성정보 목록 조회
	 * @return List<SoftwareVO>
	 */
	List<SoftwareVO> selectSoftwareInfoList() throws Exception;

	/**
	 * 템플릿소프트웨어 구성정보 목록 조회
	 * @return List<TemplateSwVO>
	 */
	List<TemplateSwVO> selectTemplateSwInfoList() throws Exception;

	/**
	 * 스펙정보 구성정보 목록 조회
	 * @return List<SpecInfoVO>
	 */
	List<SpecInfoVO> selectSpecInfoList() throws Exception;

	/**
	 * 구분코드 구성정보 목록 조회
	 * @return List<CategoryCodeVO>
	 */
	List<CategoryCodeVO> selectCategoryCodeInfoList() throws Exception;

	/**
	 * 업무정보 구성정보 목록 조회
	 * @return  List<ApplInfoVO>
	 */
	List<ApplInfoVO> selectApplInfoList() throws Exception;

	/**
	 * 서비스영역 구성정보 목록 조회
	 * @return List<CfServcNsVO>
	 */

	List<CfServcNsVO> selectServcnsInfoList(CfServcNsVO vo) throws Exception;

	/**
	 * 서비스 구성정보 목록 조회
	 * @return List<CfServcVO>
	 */
	List<CfServcVO> selectServcInfoList() throws Exception;

	/**
	 * 빌드 구성정보 목록 조회
	 * @return List<CfServcVO>
	 */
	List<CfBldConfVO> selectBuildInfoList() throws Exception;

	/**
	 * 디플로이 구성정보 목록 조회
	 * @return List<CfServcVO>
	 */
	List<CfDistrbConfVO> selectDeployInfoList() throws Exception;

	/**
	 * 오토스케일링 구성정보 목록 조회
	 * @return List<CfServcSclngVO>
	 */
	List<CfServcSclngVO> selectAutoScalerInfoList() throws Exception;

	/**
	 * 베이스이미지 구성정보 목록 조회
	 * @return List<CfImgVO>
	 */
	List<CfImgVO> selectImgInfoList() throws Exception;
}
