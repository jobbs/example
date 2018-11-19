/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre>자원요청 - 물리자원 DAO</pre>
 *
 * @filename RsrcReqProcssDao.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 01.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.dao;

import java.math.BigDecimal;
import java.util.List;

import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqPhyRsrcSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqPhyRsrcVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 김봉민
 */
@Repository("rsrcReqPhyRsrcDao")
public class RsrcReqPhyRsrcDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자원요청상세 - 물리 자원 정보 조회 (기본)
	 * @param searchVo
	 * @return
	 */
	public RsrcReqPhyRsrcVo selectRsrcReqPhyRsrc(RsrcReqPhyRsrcSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.phyrsrc.selectRsrcReqPhyRsrc" ,searchVo);
	}


	/**
	 * 자원요청상세 - 물리서버 추가  정보 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqPhyRsrcVo> selectRsrcReqPhySrvrAdd(RsrcReqPhyRsrcSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.phyrsrc.selectRsrcReqPhySrvrAdd" ,searchVo);
	}

	/**
	 *  자원요청 상세 - 물리서버 삭제  정보 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqPhyRsrcVo> selectRsrcReqPhySrvrDel(RsrcReqPhyRsrcSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.phyrsrc.selectRsrcReqPhySrvrDel" ,searchVo);
	}

	/**
	 * 자원요청 상세 - 클러스터 추가 정보 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqPhyRsrcVo> selectRsrcReqPhyClstrAdd(RsrcReqPhyRsrcSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.phyrsrc.selectRsrcReqClstrAdd" ,searchVo);
	}

	/**
	 * 자원요청 상세 - 클러스터 삭제 정보 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqPhyRsrcVo> selectRsrcReqClstrDel(RsrcReqPhyRsrcSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.phyrsrc.selectRsrcReqClstrDel" ,searchVo);
	}

	/**
	 * 삭제 불가능한 가상서버 수량 조회
	 * @param pmCompId
	 * @return
	 */
	public Integer selectDisableDeleteVmCnt(BigDecimal pmSeq){
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rsrcreq.phyrsrc.selectDisableDeleteVmCnt" ,pmSeq);
	}

	/**
	 * 자원요청 상세 - 데이터센터목록 조회
	 * @param
	 * @return
	 */
	public List<RsrcReqPhyRsrcVo> selectDataCntrList(){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.phyrsrc.selectDataCntrList");
	}


}
