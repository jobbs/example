package ncis.cmn.dao;

import ncis.cmn.entity.StThresIdx;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 임계지표 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cStThresIdxDao")
public class CStThresIdxDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 임계지표 등록
	 * @param stThresIdx
	 */
	public void insertStThresIdx(StThresIdx stThresIdx) {
		sqlSession.insert("ncis.sql.cmn.stThresIdx.insertStThresIdx", stThresIdx);
	}

	/**
	 * 임계지표 수정
	 * @param stThresIdx
	 */
	public void updateStThresIdx(StThresIdx stThresIdx) {
		sqlSession.update("ncis.sql.cmn.stThresIdx.updateStThresIdx", stThresIdx);
	}

	/**
	 * 임계지표 삭제
	 * @param stThresIdx
	 */
	public void deleteStThresIdx(StThresIdx stThresIdx) {
		sqlSession.update("ncis.sql.cmn.stThresIdx.deleteStThresIdx", stThresIdx);
	}

}
