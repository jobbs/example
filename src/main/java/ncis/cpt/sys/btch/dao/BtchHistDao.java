/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchHistDao.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 12. 9.
 * @lastmodified 2016. 12. 9.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 9.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.dao;

import java.util.List;

import ncis.cpt.sys.btch.vo.BtchHistSearchVo;
import ncis.cpt.sys.btch.vo.BtchHistVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 박봉춘
 *
 */
@Repository("BtchHistDao")
public class BtchHistDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 배치수행이력 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<BtchHistVo> selectBtchHistList(BtchHistSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.btchhist.selectBtchHistList", searchVo);
	}

	/**
	 * 배치수행이력 총 개수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectBtchHistTotCnt(BtchHistSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.btchhist.selectBtchHistTotCnt", searchVo);
	}

	/**
	 * 배치수행이력 엑셀 다운로드
	 * @param searchVo
	 * @return
	 */
	public List<BtchHistVo> selectBtchHistListXlsDwnl(BtchHistSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.btchhist.selectBtchHistListXlsDwnl", searchVo);
	}

	/**
	 * 배치수행이력 상세 조회
	 * @param btchHistVo
	 * @return
	 */
	public BtchHistVo selectBtchHist(BtchHistVo btchHistVo) {
		return sqlSession.selectOne("ncis.sql.cpt.btchhist.selectBtchHist", btchHistVo);
	}

	/**
	 * 배치작업이력 목록 조회
	 * @param btchHistVo
	 * @return
	 */
	public List<BtchHistVo> selectBtchJobHistList(BtchHistVo btchHistVo) {
		return sqlSession.selectList("ncis.sql.cpt.btchhist.selectBtchJobHistList", btchHistVo);
	}

	/**
	 * @param stepExecutionId
	 * @return
	 */
	public String selectExitMessage(long stepExecutionId) {
		return sqlSession.selectOne("ncis.sql.cpt.btchhist.selectExitMessage", stepExecutionId);
	}

}
