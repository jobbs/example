/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RegDao.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.request.dao;

import ncis.cmn.entity.RcClstr;
import ncis.cmn.entity.RcPm;
import ncis.cmn.entity.RcVm;
import ncis.cmn.entity.RrRsrcReq;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.rest.intfc.request.vo.RemoveReqVO;

import java.math.BigDecimal;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 요청정보수신 DAO
 *
 * @author ShinKeeBong
 *
 */

@Repository("regDao")
public class RegDao {

	@Autowired
	SqlSessionTemplate sqlSession;


	/**
	 * 가상서버정보 조회
	 * @param vmCompId
	 * @return
	 */
	public RcVm selectRcVmByVmCompId(String vmCompId)
	{
		return sqlSession.selectOne("ncis.sql.rest.reqResource.selectRcVmByVmCompId", vmCompId);
	}
	
	/**
	 * 물리서버정보 조회
	 * @param vmCompId
	 * @return
	 */
	public RcPm selectRcPmByPmCompId(String pmCompId)
	{
		return sqlSession.selectOne("ncis.sql.rest.reqResource.selectRcPmByPmCompId", pmCompId);
	}
	/**
	 * 클러스터정보 조회
	 * @param vmCompId
	 * @return
	 */
	public RcClstr selectRcClstrByClusterCompId(String clusterCompId)
	{
		return sqlSession.selectOne("ncis.sql.rest.reqResource.selectRcClstrByClusterCompId", clusterCompId);
	}
	
	public RsrcPoolVo selectRsrcPoolByClstrSeq(BigDecimal clstrSeq)
	{
		return sqlSession.selectOne("ncis.sql.rest.reqResource.selectRsrcPoolByClstrSeq", clstrSeq);
	}
	
	/**
	 * 삭제(취소)요청에 대응해서 기존 요청이 존재 하는지 확인.
	 * @param removeReqVO
	 * @return
	 */
	public List<RrRsrcReq> selectRrRsrcReqListByTicketNoAndRegionId(RemoveReqVO vo){
		return sqlSession.selectList("ncis.sql.rest.reqResource.selectRrRsrcReqListByTicketNoAndRegionId", vo);
	}
	
	/**
	 * 삭제(취소)요청을 처리한다.
	 * @param removeReqVO
	 * @return
	 */
	public int updateRsrcReqPrcssStatByTicktNo(RemoveReqVO vo){
		return sqlSession.update("ncis.sql.rest.reqResource.updateRsrcReqPrcssStatByTicktNo",vo);
	}
}
