package ncis.cmn.dao;

import java.util.HashMap;
import java.util.Map;
import ncis.cmn.entity.RcRsrcPool;
import ncis.cpt.sys.zone.vo.RsrcPoolVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 자원풀(가상화매니저) DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcRsrcPoolDao")
public class CRcRsrcPoolDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 자원풀(가상화매니저) 등록
	 * @param rcRsrcPool
	 */
	public void insertRcRsrcPool(RcRsrcPool rcRsrcPool) {
		sqlSession.insert("ncis.sql.cmn.rcRsrcPool.insertRcRsrcPool", rcRsrcPool);
	}

	/**
	 * 자원풀(가상화매니저) 수정
	 * @param rcRsrcPool
	 */
	public void updateRcRsrcPool(RcRsrcPool rcRsrcPool) {
		sqlSession.update("ncis.sql.cmn.rcRsrcPool.updateRcRsrcPool", rcRsrcPool);
	}

	/**
	 * 자원풀(가상화매니저) 삭제
	 * @param rcRsrcPool
	 */
	public void deleteRcRsrcPool(RcRsrcPool rcRsrcPool) {
		sqlSession.update("ncis.sql.cmn.rcRsrcPool.deleteRcRsrcPool", rcRsrcPool);
	}

    /**
     * @param netId
     * @param poolId
     */
    public void updateMoveRsrcPool(String netId, String poolId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("netId", netId);
        params.put("poolId", poolId);
        sqlSession.update("ncis.sql.cmn.rcRsrcPool.updateMoveRsrcPool", params);
    }

	/**
	 * @param poolVo
	 */
	public void updatePool(RsrcPoolVo poolVo) {
		sqlSession.update("ncis.sql.cmn.rcRsrcPool.updatePool", poolVo);
	}

}
