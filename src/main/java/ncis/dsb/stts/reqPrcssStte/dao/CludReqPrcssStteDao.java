/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstResStteDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 17
 * @lastmodified2016. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.reqPrcssStte.dao;

import java.util.List;

import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteSearchVo;
import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cludReqPrcssStteDao")
public class CludReqPrcssStteDao {

	@Autowired SqlSessionTemplate sqlSession;
	/**
	 * 클라우드 요청 처리현황 목록 조회
	 */
	public List<ReqPrcssStteVo> selectCludReqPrcssStteList(ReqPrcssStteSearchVo searchVo) throws Exception{

		return sqlSession.selectList("ncis.sql.dsb.stts.reqPrcssStte.selectCludReqPrcssStteList",searchVo);
	}
	/**
	 * 클라우드 요청 처리현황 목록 조회
	 */
	public List<ReqPrcssStteVo> selectCludReqPrcssStteDtl(ReqPrcssStteSearchVo searchVo) throws Exception{

		return sqlSession.selectList("ncis.sql.dsb.stts.reqPrcssStte.selectCludReqPrcssStteDtl",searchVo);
	}
	/**
	 * 클라우드 요청 처리현황 상세 등록
	 */
	public void insertCludReqPrcssStte(ReqPrcssStteVo vo) throws Exception{
		sqlSession.insert("ncis.sql.cmn.stSanWithdrawStte.insertStSanWithdrawStte",vo);
	}
	/**
	 * 클라우드 요청 처리현황 삭제
	 */
	public void deleteCludReqPrcssStte(ReqPrcssStteVo vo) throws Exception{
		sqlSession.insert("ncis.sql.cmn.stSanWithdrawStte.deleteStSanWithdrawStte",vo);
	}
	/**
	 * SAN 제외 현황 건수 조회
	 */
	public int selectSanWithDrawStteCnt(ReqPrcssStteVo vo) throws Exception{
		return sqlSession.selectOne("ncis.sql.dsb.stts.reqPrcssStte.selectSanWithDrawStteCnt",vo);
	}
	/**
	 * SAN 제외 현황 조회
	 */
	public List<ReqPrcssStteVo> selectSanWithdrawStte(ReqPrcssStteSearchVo searchVo)throws Exception{
		return sqlSession.selectList("ncis.sql.dsb.stts.reqPrcssStte.selectSanWithdrawStte",searchVo);

	}
}
