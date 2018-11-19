/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserConnRecDao.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.hist.dao;

import java.util.List;

import ncis.cpt.sys.hist.vo.UserConnHistSearchVo;
import ncis.cpt.sys.hist.vo.UserConnHistVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userConnHistDao")
public class UserConnHistDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 조건에 맞는 접속이령 조회 카운트
	 * @param searchVo
	 * @return
	 */
	public int selectUserConnHistTotCnt(UserConnHistSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.userconnhist.selectUserConnHistTotCnt", searchVo);
	}

	/**
	 * 접속이력 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<UserConnHistVo> selectUserConnHistList(UserConnHistSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.userconnhist.selectUserConnHistList", searchVo);
	}

	/**
	 * 접속이력 상세조회
	 * @param operateLogSeq
	 * @return
	 */
	public UserConnHistVo selectUserConnHist(Long connectSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.userconnhist.selectUserConnHist", connectSeq);
	}

	/**
	 * 접속이력 엑셀파일 다운로드
	 * @param searchVo
	 * @return
	 */
	public List<UserConnHistVo> selectDownloadUserConnHist(UserConnHistSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.userconnhist.selectDownloadUserConnHist", searchVo);
	}

}
