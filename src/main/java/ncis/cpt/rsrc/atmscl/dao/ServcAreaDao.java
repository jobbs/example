package ncis.cpt.rsrc.atmscl.dao;

import java.util.List;
import java.util.Map;

import ncis.cpt.rsrc.atmscl.vo.PvSearchVo;
import ncis.cpt.rsrc.atmscl.vo.PvVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaSearchVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("servcAreaDao")
public class ServcAreaDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 서비스영역 수 조회
	 * @param   searchVo
	 * @return
	 */
	public int selectServcAreaTotCnt(ServcAreaSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.servcArea.selectServcAreaTotCnt",searchVo);
	}

	/**
	 * 검색조건에 해당하는 서비스영역 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<ServcAreaVo> selectServcAreaList(ServcAreaSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servcArea.selectServcAreaList",searchVo);
	}

	/**
	 * 검색조건에 해당하는 서비스영역 상세 조회
	 * @param servcAreaVo
	 * @return
	 */
	public ServcAreaVo selectServcArea(ServcAreaVo servcAreaVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.servcArea.selectServcArea",servcAreaVo);
	}

	/**
	 * 서비스 목록 조회
	 * @param servcAreaSeq
	 * @return
	 */
	public List<ServcVo> selectServcList(int servcAreaSeq) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servcArea.selectServcList", servcAreaSeq);
	}


	/**
	 * PV 목록 조회
	 * @param servcAreaSeq
	 * @return
	 */
	public List<PvVo> selectPvList(PvSearchVo pvSearchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.servcArea.selectPvList", pvSearchVo);
	}

	/**
	 * PV 목록 수 조회
	 * @param   searchVo
	 * @return
	 */
	public int selectPvListTotCnt(PvSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.servcArea.selectPvTotCnt", searchVo);
	}


	/**
	 * 서비스 수 조회
	 * @param   servcAreaVo
	 * @return
	 */
	public int selectServcCnt(ServcAreaVo servcAreaVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.servcArea.selectServcCnt", servcAreaVo);
	}


	/**
	 * 포탈메인 요약정보 조회
	 * @param   servcAreaVo
	 * @return
	 */
	public Map<String, Object> selectAtmsclSttsByUser(ServcAreaSearchVo servcAreaSearchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.servcArea.selectAtmsclSttsByUser", servcAreaSearchVo);
	}


}
