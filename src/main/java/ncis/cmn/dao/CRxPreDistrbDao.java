package ncis.cmn.dao;



import ncis.cmn.entity.RxPreDistrb;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("cRxPreDistrbDao")
public class CRxPreDistrbDao {

	@Autowired SqlSessionTemplate sqlSession;


	/**
	 * 사전배포 등록
	 * @param rsrvSclngVo
	 */
	public void insertPreDistrb(RxPreDistrb rxPreDistrb) {
		sqlSession.insert("ncis.sql.cmn.rxPreDistrb.insertPreDistrb", rxPreDistrb);
	}


	/**
	 * 사전배포 상태 수정
	 * @param rxPreDistrb
	 */
	public void updatePreDistrbStat(RxPreDistrb rxPreDistrb) {
		sqlSession.update("ncis.sql.cmn.rxPreDistrb.updatePreDistrbStat", rxPreDistrb);
	}


	/**사전 재배포
	 * @param rxPreDistrb
	 */
	public void updateRePreDistrb(RxPreDistrb rxPreDistrb) {
		sqlSession.update("ncis.sql.cmn.rxPreDistrb.updateRePreDistrb", rxPreDistrb);
	}


}
