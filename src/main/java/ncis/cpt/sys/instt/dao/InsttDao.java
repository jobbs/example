/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename DepartDao.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.sys.instt.dao;

import java.util.List;
import ncis.cpt.sys.instt.vo.InsttSearchVo;
import ncis.cpt.sys.instt.vo.InsttVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 최경철
 *
 */
@Repository("insttDao")
public class InsttDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 부처관리 수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectInsttTotCnt(InsttSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.instt.selectInsttTotCnt",searchVo);
	}

	/**
	 * 검색조건에 해당하는 부처관리 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<InsttVo> selectInsttList(InsttSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.instt.selectInsttList",searchVo);
	}

	/**
	 * 부처 상세 조회
	 * @param institutionId
	 * @return
	 */
	public InsttVo selectInstt(String institutionId) {
		return sqlSession.selectOne("ncis.sql.cpt.instt.selectInstt", institutionId);
	}

	/**
	 * 부처 ID 조회
	 * @param institutionNm
	 * @return
	 */
	public String selectInsttId(String institutionNm) {
		return sqlSession.selectOne("ncis.sql.cpt.instt.selectInsttId", institutionNm);
	}

    /**
     * @param searchVo
     * @return
     */
    public List<InsttVo> selectInsttListXlsDwnl(InsttSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.instt.selectInsttListXlsDwnl",searchVo);
    }
    
    /**
	 * 검색조건에 해당하는 전체 부처관리 수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectInsttByOnnaraTotCnt(InsttSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.instt.selectInsttByOnnaraTotCnt",searchVo);
	}

	/**
	 * 검색조건에 해당하는 부처관리 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<InsttVo> selectInsttListByOnnara(InsttSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.instt.selectInsttListByOnnara",searchVo);
	}

}
