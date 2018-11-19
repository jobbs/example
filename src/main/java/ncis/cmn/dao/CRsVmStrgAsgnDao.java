package ncis.cmn.dao;

import ncis.cmn.entity.RsVmStrgAsgn;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상서버스토리지할당 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRsVmStrgAsgnDao")
public class CRsVmStrgAsgnDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상서버스토리지할당 등록
	 * @param rsVmStrgAsgn
	 */
	public void insertRsVmStrgAsgn(RsVmStrgAsgn rsVmStrgAsgn) {
		sqlSession.insert("ncis.sql.cmn.rsVmStrgAsgn.insertRsVmStrgAsgn", rsVmStrgAsgn);
	}

	/**
	 * 가상서버스토리지할당 수정
	 * @param rsVmStrgAsgn
	 */
	public void updateRsVmStrgAsgn(RsVmStrgAsgn rsVmStrgAsgn) {
		sqlSession.update("ncis.sql.cmn.rsVmStrgAsgn.updateRsVmStrgAsgn", rsVmStrgAsgn);
	}

	/**
	 * 가상서버스토리지할당 삭제
	 * @param rsVmStrgAsgn
	 */
	public void deleteRsVmStrgAsgn(RsVmStrgAsgn rsVmStrgAsgn) {
		sqlSession.update("ncis.sql.cmn.rsVmStrgAsgn.deleteRsVmStrgAsgn", rsVmStrgAsgn);
	}

}
