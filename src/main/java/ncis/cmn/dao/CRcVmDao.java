package ncis.cmn.dao;

import ncis.cmn.entity.RcVm;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상서버 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRcVmDao")
public class CRcVmDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상서버 등록
	 * @param rcVm
	 */
	public void insertRcVm(RcVm rcVm) {
		sqlSession.insert("ncis.sql.cmn.rcVm.insertRcVm", rcVm);
	}

	/**
	 * 가상서버 수정
	 * @param rcVm
	 */
	public void updateRcVm(RcVm rcVm) {
		sqlSession.update("ncis.sql.cmn.rcVm.updateRcVm", rcVm);
	}

	/**
     * 가상서버 상태동기화
     * @param rcVm
     */
    public void updateRcVmStatSync(RcVm rcVm) {
        sqlSession.update("ncis.sql.cmn.rcVm.updateRcVmStatSync", rcVm);
    }

	/**
	 * 가상서버 삭제
	 * @param rcVm
	 */
	public void deleteRcVm(RcVm rcVm) {
		sqlSession.update("ncis.sql.cmn.rcVm.deleteRcVm", rcVm);
	}

	/**
	 * 가상서버 패키지 대상여부 수정
	 * @param rcVm
	 */
	public void updateRcVmPackgMngTrgtYn(RcVm rcVm) {
		sqlSession.update("ncis.sql.cmn.rcVm.updateRcVmPackgMngTrgtYn", rcVm);
	}

}
