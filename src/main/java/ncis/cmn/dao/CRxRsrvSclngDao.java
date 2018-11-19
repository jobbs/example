package ncis.cmn.dao;



import ncis.cmn.entity.RxRsrvSclng;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("cRxRsrvSclngDao")
public class CRxRsrvSclngDao {

	@Autowired SqlSessionTemplate sqlSession;


	/**
	 * 스케일예약설정 등록
	 * @param rsrvSclngVo
	 */
	public void insertRsrvSclng(RxRsrvSclng rxRsrvSclng) {
		sqlSession.insert("ncis.sql.cmn.rxRsrvSclng.insertRrRsrcReq", rxRsrvSclng);
	}


	/**
	 * 스케일예약설정 수정
	 * @param rxRsrvSclng
	 */
	public void udtAtmSclRsrvSclng(RxRsrvSclng rxRsrvSclng) {
		sqlSession.update("ncis.sql.cmn.rxRsrvSclng.udtAtmSclRsrvSclng", rxRsrvSclng);
	}


	/**
	 * @param rxScl
	 */
	public void deleteSclYn(RxRsrvSclng rxScl) {
		sqlSession.delete("ncis.sql.cmn.rxRsrvSclng.deleteSclYn", rxScl);

	}


}
