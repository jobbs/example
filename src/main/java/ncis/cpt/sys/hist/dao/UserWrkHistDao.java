/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserWrkHistDao.java
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

import ncis.cpt.sys.hist.vo.UserWrkHistSearchVo;
import ncis.cpt.sys.hist.vo.UserWrkHistVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userWrkHistDao")
public class UserWrkHistDao {

	@Autowired SqlSessionTemplate sqlSession;

	public int selectUserWrkHistTotCnt(UserWrkHistSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.userwrkhist.selectUserWrkHistTotCnt", searchVo);
	}

	/**
	 * 작업로그 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<UserWrkHistVo> selectUserWrkHistList(UserWrkHistSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.userwrkhist.selectUserWrkHistList", searchVo);
	}

	/**
	 * 작업로그 상세조회
	 * @param userwrkhistSeq
	 * @return
	 */
	public UserWrkHistVo selectUserWrkHist(Long userwrkhistSeq) {
		return sqlSession.selectOne("ncis.sql.cpt.userwrkhist.selectUserWrkHist", userwrkhistSeq);
	}

	/**
	 * 작업로그 엑셀파일 다운로드
	 * @param searchVo
	 * @return
	 */
	public List<UserWrkHistVo> selectDownloadUserWrkHist(UserWrkHistSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.userwrkhist.selectDownloadUserWrkHist", searchVo);
	}

}
