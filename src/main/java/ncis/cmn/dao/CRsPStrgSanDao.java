package ncis.cmn.dao;

import ncis.cmn.entity.RsPStrgSan;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 물리스토리지_SAN DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRsPStrgSanDao")
public class CRsPStrgSanDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 물리스토리지_SAN 등록
	 * @param rsPStrgSan
	 */
	public void insertRsPStrgSan(RsPStrgSan rsPStrgSan) {
		sqlSession.insert("ncis.sql.cmn.rsPStrgSan.insertRsPStrgSan", rsPStrgSan);
	}

	/**
	 * 물리스토리지_SAN 수정
	 * @param rsPStrgSan
	 */
	public void updateRsPStrgSan(RsPStrgSan rsPStrgSan) {
		sqlSession.update("ncis.sql.cmn.rsPStrgSan.updateRsPStrgSan", rsPStrgSan);
	}

	/**
	 * 물리스토리지_SAN 삭제
	 * @param rsPStrgSan
	 */
	public void deleteRsPStrgSan(RsPStrgSan rsPStrgSan) {
		sqlSession.update("ncis.sql.cmn.rsPStrgSan.deleteRsPStrgSan", rsPStrgSan);
	}

}
