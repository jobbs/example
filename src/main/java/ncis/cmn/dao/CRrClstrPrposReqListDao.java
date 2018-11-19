package ncis.cmn.dao;

import ncis.cmn.entity.RrClstrPrposReqList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 자원요청클러스터용도 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrClstrPrposReqListDao")
public class CRrClstrPrposReqListDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 자원요청클러스터용도 등록
	 * @param rrClstrPrposReqList
	 */
	public void insertRrClstrPrposReqList(RrClstrPrposReqList rrClstrPrposReqList) {
		sqlSession.insert("ncis.sql.cmn.rrClstrPrposReqList.insertRrClstrPrposReqList", rrClstrPrposReqList);
	}

	/**
	 * 자원요청클러스터용도 수정
	 * @param rrClstrPrposReqList
	 */
	public void updateRrClstrPrposReqList(RrClstrPrposReqList rrClstrPrposReqList) {
		sqlSession.update("ncis.sql.cmn.rrClstrPrposReqList.updateRrClstrPrposReqList", rrClstrPrposReqList);
	}

	/**
	 * 자원요청클러스터용도 삭제
	 * @param rrClstrPrposReqList
	 */
	public void deleteRrClstrPrposReqList(RrClstrPrposReqList rrClstrPrposReqList) {
		sqlSession.update("ncis.sql.cmn.rrClstrPrposReqList.deleteRrClstrPrposReqList", rrClstrPrposReqList);
	}

}
