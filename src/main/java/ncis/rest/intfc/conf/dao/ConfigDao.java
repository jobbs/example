/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ConfigDao.java
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
package ncis.rest.intfc.conf.dao;

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

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 구성정보 제공 DAO
 *
 * @author ShinKeeBong
 *
 */

@Repository("configDao")
public class ConfigDao {

	@Autowired
	private SqlSessionTemplate sqlSession;


	/**
	 * 존 구성정보 목록 조회
	 * @return List<ZoneVO>
	 */
	public List<ZoneVO> selectZoneInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectZoneInfoList");
	}


	/**
	 * 클러스터 구성정보 목록 조회
	 * @return List<ClusterVO>
	 */
	public List<ClusterVO> selectClusterInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectClusterInfoList");
	}


	/**
	 * 물리서버 구성정보 목록 조회
	 * @return List<PmVO>
	 */
	public List<PmVO> selectPmInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectPmInfoList");
	}


	/**
	 * 가상서버 구성정보 목록 조회
	 * @return List<VmVO>
	 */
	public List<VmVO> selectVmInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectVmInfoList");
	}


	/**
	 * 가상서버템플릿 구성정보 목록 조회
	 * @return List<TemplateVO>
	 */
	public List<TemplateVO> selectTemplateInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectTemplateInfoList");
	}


	/**
	 * 소프트웨어 구성정보 목록 조회
	 * @return List<SoftwareVO>
	 */
	public List<SoftwareVO> selectSoftwareInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectSoftwareInfoList");
	}


	/**
	 * 템플릿소프트웨어 구성정보 목록 조회
	 * @return List<TemplateSwVO>
	 */
	public List<TemplateSwVO> selectTemplateSwInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectTemplateSwInfoList");
	}



	/**
	 * 스펙정보 구성정보 목록 조회
	 * @return List<SpecInfoVO>
	 */
	public List<SpecInfoVO> selectSpecInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectSpecInfoList");
	}



	/**
	 * 구분코드 구성정보 목록 조회
	 * @return List<CategoryCodeVO>
	 */
	public List<CategoryCodeVO> selectCategoryCodeInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectCategoryCodeInfoList");
	}


	/**
	 * 업무정보 구성정보 목록 조회
	 * @return  List<ApplInfoVO>
	 */
	public List<ApplInfoVO> selectApplInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectApplInfoList");
	}

	/**
	 * 서비스영역 구성정보 목록 조회
	 * @return List<CfServcNsVO>
	 */
	public List<CfServcNsVO> selectServcnsInfoList(CfServcNsVO vo) {

		return sqlSession.selectList("ncis.sql.rest.config.selectServcnsInfoList",vo);
	}


	/**
	 * 서비스 구성정보 목록 조회
	 * @return List<CfServcVO>
	 */
	public List<CfServcVO> selectServcInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectServcInfoList");
	}

	/**
	 * 빌드 구성정보 목록 조회
	 * @return List<CfBldConfVO>
	 */
	public List<CfBldConfVO> selectBuildInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectBuildInfoList");
	}

	/**
	 * 디플로이 구성정보 목록 조회
	 * @return List<CfDistrbConfVO>
	 */
	public List<CfDistrbConfVO> selectDeployInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectDistrbInfoList");
	}

	/**
	 * 디플로이 구성정보 목록 조회
	 * @return List<CfDistrbConfVO>
	 */
	public List<CfServcSclngVO> selectAutoScalerInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectAutoScalerInfoList");
	}

	/**
	 * 베이스이미지 구성정보 목록 조회
	 * @return List<CfImgVO>
	 */
	public List<CfImgVO> selectImgInfoList() {

		return sqlSession.selectList("ncis.sql.rest.config.selectImgInfoList");
	}

}
