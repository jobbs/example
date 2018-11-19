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

import ncis.cmn.entity.RxImg;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 이미지 DAO - 공통(등록/수정/삭제)
 *
 * @author x
 */

@Repository("cRxImgDao")
public class CRxImgDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 이미지 등록
	 * @param rxImg
	 */
	public void insertRxImg(RxImg rxImg) {
		sqlSession.insert("ncis.sql.cmn.rxImg.insertRxImg", rxImg);
	}

	/**
	 * 이미지 수정
	 * @param rxImg
	 */
	public void updateRxImg(RxImg rxImg) {
		sqlSession.update("ncis.sql.cmn.rxImg.updateRxImg", rxImg);
	}

	/**
	 * 이미지 삭제
	 * @param rxImg
	 */
	public void deleteRxImg(RxImg rxImg) {
		sqlSession.update("ncis.sql.cmn.rxImg.deleteRxImg", rxImg);
	}

}
