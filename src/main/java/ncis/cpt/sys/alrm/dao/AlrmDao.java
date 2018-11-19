/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AlrmDao.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.alrm.dao;

import java.util.List;
import ncis.cpt.sys.alrm.vo.AlrmSearchVo;
import ncis.cpt.sys.alrm.vo.AlrmVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 최진호
 *
 */
@Repository("alrmDao")
public class AlrmDao {

    @Autowired
    private SqlSession sqlSession;

    /**
     * 알림 목록 총 목록 수 조회
     * @param searchVo
     * @return
     */
    public int selectAlrmTotCnt(AlrmSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.alrm.selectAlrmTotCnt", searchVo);
    }

    /**
     * 알림 목록조회
     * @param searchVo
     * @return
     */
    public List<AlrmVo> selectAlrmList(AlrmSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.alrm.selectAlrmList", searchVo);
    }

    /**
     * 알림 조회
     * @param alrmSeq
     * @return
     */
    public AlrmVo selectAlrm(Long alrmSeq) {
        return sqlSession.selectOne("ncis.sql.cpt.alrm.selectAlrm", alrmSeq);
    }

    /**
     * 알림 업데이트
     * @param alrmVo
     */
    public void updateAlrm(AlrmVo alrmVo) {
        sqlSession.update("ncis.sql.cmn.cmAlrm.updateCmAlrm", alrmVo);
    }

	/**
	 * 알림정보 엑셀 다운로드
	 * @param searchVo
	 * @return
	 */
	public List<AlrmVo> selectAlrmListXlsDwnl(AlrmSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.alrm.selectAlrmListXlsDwnl", searchVo);
	}

}
