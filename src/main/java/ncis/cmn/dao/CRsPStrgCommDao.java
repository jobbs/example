package ncis.cmn.dao;

import ncis.cmn.entity.RsPStrgComm;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 물리스토리지_공통 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRsPStrgCommDao")
public class CRsPStrgCommDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 물리스토리지_공통 등록
	 * @param rsPStrgComm
	 */
	public void insertRsPStrgComm(RsPStrgComm rsPStrgComm) {
		sqlSession.insert("ncis.sql.cmn.rsPStrgComm.insertRsPStrgComm", rsPStrgComm);
	}

	/**
	 * 물리스토리지_공통 수정
	 * @param rsPStrgComm
	 */
	public void updateRsPStrgComm(RsPStrgComm rsPStrgComm) {
		sqlSession.update("ncis.sql.cmn.rsPStrgComm.updateRsPStrgComm", rsPStrgComm);
	}

	/**
	 * 물리스토리지_공통 수정 (조건)
	 * @param rsPStrgComm
	 */
	public void updateRsPStrgCommSelected(RsPStrgComm rsPStrgComm){
		sqlSession.update("ncis.sql.cmn.rsPStrgComm.updateRsPStrgCommSelected", rsPStrgComm);
	}


	/**
	 * 물리스토리지_공통 삭제
	 * @param rsPStrgComm
	 */
	public void deleteRsPStrgComm(RsPStrgComm rsPStrgComm) {
		sqlSession.update("ncis.sql.cmn.rsPStrgComm.deleteRsPStrgComm", rsPStrgComm);
	}
}
