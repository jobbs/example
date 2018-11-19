package ncis.cmn.dao;

import ncis.cmn.entity.RxServcAreaPvAsgn;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 서비스영역 PV할당 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxServcAreaPvAsgnDao")
public class CRxServcAreaPvAsgnDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 서비스영역 PV할당 등록
	 * @param rxServcAreaPvAsgn
	 */
	public void insertRxServcAreaPvAsgn(RxServcAreaPvAsgn rxServcAreaPvAsgn) {
		sqlSession.insert("ncis.sql.cmn.rxServcAreaPvAsgn.insertRxServcAreaPvAsgn", rxServcAreaPvAsgn);
	}


	/**
	 * 서비스영역 PV할당 삭제
	 * @param rxServcAreaPvAsgn
	 */
	public void deleteRxServcAreaPvAsgn(RxServcAreaPvAsgn rxServcAreaPvAsgn) {
		sqlSession.delete("ncis.sql.cmn.rxServcAreaPvAsgn.deleteRxServcAreaPvAsgn", rxServcAreaPvAsgn);
	}

}
