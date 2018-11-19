package ncis.cmn.dao;

import ncis.cmn.entity.RrUnitJobRelate;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 단위업무관계 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrUnitJobRelateDao")
public class CRrUnitJobRelateDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 단위업무관계 등록
	 * @param rrUnitJobRelate
	 */
	public void insertRrUnitJobRelate(RrUnitJobRelate rrUnitJobRelate) {
		sqlSession.insert("ncis.sql.cmn.rrUnitJobRelate.insertRrUnitJobRelate", rrUnitJobRelate);
	}

	/**
	 * 단위업무관계 수정
	 * @param rrUnitJobRelate
	 */
	public void updateRrUnitJobRelate(RrUnitJobRelate rrUnitJobRelate) {
		sqlSession.update("ncis.sql.cmn.rrUnitJobRelate.updateRrUnitJobRelate", rrUnitJobRelate);
	}

	/**
	 * 단위업무관계 삭제
	 * @param rrUnitJobRelate
	 */
	public void deleteRrUnitJobRelate(RrUnitJobRelate rrUnitJobRelate) {
		sqlSession.update("ncis.sql.cmn.rrUnitJobRelate.deleteRrUnitJobRelate", rrUnitJobRelate);
	}

}
