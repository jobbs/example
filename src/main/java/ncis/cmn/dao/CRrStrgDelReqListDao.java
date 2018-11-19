package ncis.cmn.dao;

import ncis.cmn.entity.RrStrgDelReqList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 스토리지삭제요청목록 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrStrgDelReqListDao")
public class CRrStrgDelReqListDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 스토리지삭제요청목록 등록
	 * @param rrStrgDelReqList
	 */
	public void insertRrStrgDelReqList(RrStrgDelReqList rrStrgDelReqList) {
		sqlSession.insert("ncis.sql.cmn.rrStrgDelReqList.insertRrStrgDelReqList", rrStrgDelReqList);
	}

	/**
	 * 스토리지삭제요청목록 수정
	 * @param rrStrgDelReqList
	 */
	public void updateRrStrgDelReqList(RrStrgDelReqList rrStrgDelReqList) {
		sqlSession.update("ncis.sql.cmn.rrStrgDelReqList.updateRrStrgDelReqList", rrStrgDelReqList);
	}

	/**
	 * 스토리지삭제요청목록 삭제
	 * @param rrStrgDelReqList
	 */
	public void deleteRrStrgDelReqList(RrStrgDelReqList rrStrgDelReqList) {
		sqlSession.update("ncis.sql.cmn.rrStrgDelReqList.deleteRrStrgDelReqList", rrStrgDelReqList);
	}

}
