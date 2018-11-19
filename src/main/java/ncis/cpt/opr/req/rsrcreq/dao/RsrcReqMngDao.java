package ncis.cpt.opr.req.rsrcreq.dao;

import java.util.List;

import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("rsrcReqMngDao")
public class RsrcReqMngDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 자원요청수 조회
	 * @param   searchVo
	 * @return
	 */
	public int selectRsrcReqTotCnt(RsrcReqMngSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.selectRsrcReqTotCnt",searchVo);
	}

	/**
	 * 검색조건에 해당하는 자원요청 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqMngVo> selectRsrcReqList(RsrcReqMngSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.selectRsrcReqList",searchVo);
	}

	/**
	 * 자원요청 상세 - 기본정보 조회
	 * @param resReqId
	 * @return
	 */
	public RsrcReqVo selectRsrcReqDtl(RsrcReqMngSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.dtl.selectRsrcReqInfo",searchVo);
	}

	/**
	 * 검색조건에 해당하는 자원요청 Excel 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqMngVo> selectRsrcReqExcelList(RsrcReqMngSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.selectRsrcReqExcelList",searchVo);
	}

	/**
	 * 검색조건에 해당하는 포틀릿 자원요청 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqMngVo> selectRsrcReqPortletList(String rsrcReqPrcssStatCd) {
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.selectRsrcReqPortletList",rsrcReqPrcssStatCd);
	}

	/**
	 * 자원요청  - 조회
	 * @param resReqId
	 * @return
	 */
	public RsrcReqMngVo selectRsrcReq(String rsrcReqNo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.selectRsrcReq",rsrcReqNo);
	}

	/**
	 * 자원요청 파일정보  - 조회
	 * @param rsrcReqNo
	 * @return
	 */
	public RsrcReqMngVo selectRsrcReqFileInfo(String rsrcReqNo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.selectRsrcReqFileInfo",rsrcReqNo);
	}

	/**
	 * 리전 목록 조회
	 * @param regUserId
	 * @return
	 */
	public List<RsrcReqMngVo> selectRegionList(String regUserId) {
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.selectRegionList",regUserId);
	}
}
