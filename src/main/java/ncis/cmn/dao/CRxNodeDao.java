/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CRxImgDao.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 5. 19.
 * @lastmodified 2017. 5. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 5. 19.     이호성         v1.0             최초생성
 *
 */
package ncis.cmn.dao;

import ncis.cmn.entity.RxNode;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 이미지 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxNodeDao")
public class CRxNodeDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 노드 등록
	 * @param rxImg
	 */
	public void insertRxNode(RxNode rxNode) {
		sqlSession.insert("ncis.sql.cmn.rxNode.insertRxNode", rxNode);
	}

	/**
	 * 노드 수정
	 * @param rxImg
	 */
	public void updateRxNode(RxNode rxNode) {
		sqlSession.update("ncis.sql.cmn.rxNode.updateRxNode", rxNode);
	}

}
