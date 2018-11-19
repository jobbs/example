/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ConfigServiceImpl.java
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
package ncis.rest.intfc.conf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.rest.intfc.conf.dao.ConfigDao;
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

import org.springframework.stereotype.Service;

/**
 * 구성정보 제공 Service Implement
 *
 * @author ShinKeeBong
 *
 */

@Service("configService")
public class ConfigServiceImpl implements ConfigService {

	@Resource(name="configDao")
	private ConfigDao configDao;

	/**
	 * 존 구성정보 목록 조회
	 * @return List<ZoneVO>
	 */
	@Override
	public List<ZoneVO> selectZoneInfoList() throws Exception {

		return configDao.selectZoneInfoList();
	}

	/**
	 * 클러스터 구성정보 목록 조회
	 * @return List<ClusterVO>
	 */
	@Override
	public List<ClusterVO> selectClusterInfoList() throws Exception {

		return configDao.selectClusterInfoList();
	}

	/**
	 * 물리서버 구성정보 목록 조회
	 * @return List<PmVO>
	 */
	@Override
	public List<PmVO> selectPmInfoList() throws Exception {

		return configDao.selectPmInfoList();
	}

	/**
	 * 가상서버 구성정보 목록 조회
	 * @return List<VmVO>
	 */
	@Override
	public List<VmVO> selectVmInfoList() throws Exception {

		return configDao.selectVmInfoList();
	}

	/**
	 * 가상서버템플릿 구성정보 목록 조회
	 * @return List<TemplateVO>
	 */
	@Override
	public List<TemplateVO> selectTemplateInfoList() throws Exception {

		return configDao.selectTemplateInfoList();
	}

	/**
	 * 소프트웨어 구성정보 목록 조회
	 * @return List<SoftwareVO>
	 */
	@Override
	public List<SoftwareVO> selectSoftwareInfoList() throws Exception {



		return configDao.selectSoftwareInfoList();
	}

	/**
	 * 템플릿소프트웨어 구성정보 목록 조회
	 * @return List<TemplateSwVO>
	 */
	@Override
	public List<TemplateSwVO> selectTemplateSwInfoList() throws Exception {

		return configDao.selectTemplateSwInfoList();
	}

	/**
	 * 스펙정보 구성정보 목록 조회
	 * @return List<SpecInfoVO>
	 */
	@Override
	public List<SpecInfoVO> selectSpecInfoList() throws Exception {

		return configDao.selectSpecInfoList();
	}

	/**
	 * 구분코드 구성정보 목록 조회
	 * @return List<CategoryCodeVO>
	 */
	@Override
	public List<CategoryCodeVO> selectCategoryCodeInfoList() throws Exception {

		return configDao.selectCategoryCodeInfoList();
	}

	/**
	 * 업무정보 구성정보 목록 조회
	 * @return  List<ApplInfoVO>
	 */
	@Override
	public List<ApplInfoVO> selectApplInfoList() throws Exception {

		return configDao.selectApplInfoList();
	}

	/**
	 * 서비스영역 구성정보 목록 조회
	 * @return List<CfServcNsVO>
	 */
	@Override
	public List<CfServcNsVO> selectServcnsInfoList(CfServcNsVO vo) throws Exception {

		return configDao.selectServcnsInfoList(vo);
	}

	/**
	 * 서비스 구성정보 목록 조회
	 * @return List<CfServcVO>
	 */
	@Override
	public List<CfServcVO> selectServcInfoList() throws Exception {

		return configDao.selectServcInfoList();
	}

	/**
	 * 빌드 구성정보 목록 조회
	 * @return List<CfServcVO>
	 */
	@Override
	public List<CfBldConfVO> selectBuildInfoList() throws Exception {

		return configDao.selectBuildInfoList();
	}

	/**
	 * 배포 구성정보 목록 조회
	 * @return List<CfServcVO>
	 */
	@Override
	public List<CfDistrbConfVO> selectDeployInfoList() throws Exception {

		return configDao.selectDeployInfoList();
	}

	/**
	 * 오토스케일링 구성정보 목록 조회
	 * @return List<CfServcSclngVO>
	 */
	@Override
	public List<CfServcSclngVO> selectAutoScalerInfoList() throws Exception {

		return configDao.selectAutoScalerInfoList();
	}



	/**
	 * 베이스이미지 구성정보 목록 조회
	 * @return List<CfImgVO>
	 */
	@Override
	public List<CfImgVO> selectImgInfoList() throws Exception {

		return configDao.selectImgInfoList();
	}

}
