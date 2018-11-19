package ncis.cmn.dao;

import ncis.cmn.entity.RxScrtky;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 보안키 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxScrtkyDao")
public class CRxScrtkyDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 보안키 생성
	 * @param rxScrtky
	 */
	public void insertRxScrtky(RxScrtky rxScrtky) {
		sqlSession.insert("ncis.sql.cmn.rxScrtky.insertRxScrtky", rxScrtky);
	}
}
