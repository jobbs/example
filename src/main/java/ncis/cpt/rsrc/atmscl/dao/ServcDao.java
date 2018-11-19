package ncis.cpt.rsrc.atmscl.dao;

import java.util.List;

import ncis.cpt.opr.catalg.vo.BaseImgVo;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.BldVo;
import ncis.cpt.rsrc.atmscl.vo.ScrtkyVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPortVo;
import ncis.cpt.rsrc.atmscl.vo.ServcRouteVo;
import ncis.cpt.rsrc.atmscl.vo.ServcSclngVo;
import ncis.cpt.rsrc.atmscl.vo.ServcSearchVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("servcDao")
public class ServcDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 서비스 수 조회
	 * @param   searchVo
	 * @return
	 */
	public int selectServcTotCnt(ServcSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.servc.selectServcTotCnt",searchVo);
	}

	/**
	 * 검색조건에 해당하는 서비스 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<ServcVo> selectServcList(ServcSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servc.selectServcList",searchVo);
	}


	/**
	 * 검색조건에 해당하는 서비스 상세 조회
	 * @param searchVo
	 * @return
	 */
	public ServcVo selectServc(ServcVo servcVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.servc.selectServc",servcVo);
	}


	/**
	 * 검색조건에 해당하는 보안키 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<ScrtkyVo> selectScrtKyList(int servcAreaSeq) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servc.selectScrtKyList",servcAreaSeq);
	}


	/**
	 * Pod 목록 조회
	 * @param servcSeq
	 * @return
	 */
	public List<ServcPodVo> selectServcPodList(ServcPodVo servcPodVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servc.selectServcPodList",servcPodVo);
	}


	/**
	 * 라우트 목록 조회
	 * @param servcSeq
	 * @return
	 */
	public List<ServcRouteVo> selectServcRouteList(Integer servcSeq) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servc.selectServcRouteList",servcSeq);
	}


	/**
	 * 포트 목록 조회
	 * @param servcSeq
	 * @return
	 */
	public List<ServcPortVo> selectServcPortList(Integer servcSeq) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servc.selectServcPortList",servcSeq);
	}

	/**
	 * 제한 목록 조회
	 * @param servcSeq
	 * @return
	 */
	public ServcAreaVo selectLimit(Integer servcAreaSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.servc.selectLimit",servcAreaSeq);
	}


	/**
	 * 빌드 목록 조회
	 * @param servcSeq
	 * @return
	 */
	public List<BldVo> selectBldList(Integer servcSeq) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servc.selectBldList",servcSeq);
	}

	/**
	 * 빌드 상세 조회
	 * @param servcSeq
	 * @return
	 */
	public BldVo selectBldConf(Integer servcSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.servc.selectBldConf",servcSeq);
	}


	/**
	 * 배포 목록 조회
	 * @param servcSeq
	 * @return
	 */
	public List<AtmsclDistrbVo> selectDistrbList(Integer servcSeq) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servc.selectDistrbList",servcSeq);
	}


	/**
	 * 이미지 목록 조회
	 * @param servcSeq
	 * @return
	 */
	public List<BaseImgVo> selectImgList(Integer servcSeq) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servc.selectImgList",servcSeq);
	}


	/**
	 * 스케일링 목록 조회
	 * @param servcSeq
	 * @return
	 */
	public List<ServcSclngVo> selecServcSclngList(Integer servcSeq) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servc.selecServcSclngList",servcSeq);
	}


	/**
	 * 배포 상세 조회
	 * @param servcSeq
	 * @return
	 */
	public AtmsclDistrbVo selectDistrb(Integer servcSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.servc.selectDistrb",servcSeq);
	}

}
