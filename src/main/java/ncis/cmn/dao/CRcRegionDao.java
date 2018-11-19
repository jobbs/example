package ncis.cmn.dao;

import ncis.cmn.entity.RcRegion;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 리전 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcRegionDao")
public class CRcRegionDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 리전 등록
	 * @param rcRegion
	 */
	public void insertRcRegion(RcRegion rcRegion) {
		sqlSession.insert("ncis.sql.cmn.rcRegion.insertRcRegion", rcRegion);
	}

	/**
	 * 리전 수정
	 * @param rcRegion
	 */
	public void updateRcRegion(RcRegion rcRegion) {
		sqlSession.update("ncis.sql.cmn.rcRegion.updateRcRegion", rcRegion);
	}

    /**
     * 센터 정보 삭제
     * @param regionId
     */
    public void deleteRcRegion(String regionId) {
        sqlSession.delete("ncis.sql.cmn.rcRegion.deleteRcRegion", regionId);
    }
}
