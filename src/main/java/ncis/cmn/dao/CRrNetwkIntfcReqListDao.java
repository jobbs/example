package ncis.cmn.dao;

import java.util.List;

import ncis.cmn.entity.RrNetwkIntfcReqList;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkIntfcVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 네트워크인터페이스요청목록 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrNetwkIntfcReqListDao")
public class CRrNetwkIntfcReqListDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 네트워크인터페이스요청목록 등록
	 * @param rrNetwkIntfcReqList
	 */
	public void insertRrNetwkIntfcReqList(RrNetwkIntfcReqList rrNetwkIntfcReqList) {
		sqlSession.insert("ncis.sql.cmn.rrNetwkIntfcReqList.insertRrNetwkIntfcReqList", rrNetwkIntfcReqList);
	}

	/**
	 * 네트워크인터페이스요청목록 수정
	 * @param rrNetwkIntfcReqList
	 */
	public void updateRrNetwkIntfcReqList(RrNetwkIntfcReqList rrNetwkIntfcReqList) {
		sqlSession.update("ncis.sql.cmn.rrNetwkIntfcReqList.updateRrNetwkIntfcReqList", rrNetwkIntfcReqList);
	}

	/**
	 * 네트워크인터페이스요청 IP 수정
	 * @param rrNetwkIntfcReqList
	 */
	public void updateRrNetwkIntfcReqIp(RrNetwkIntfcReqList rrNetwkIntfcReqList) {
		sqlSession.update("ncis.sql.cmn.rrNetwkIntfcReqList.updateRrNetwkIntfcReqIp", rrNetwkIntfcReqList);
	}


	/**
	 * 네트워크인터페이스요청목록 삭제
	 * @param rrNetwkIntfcReqList
	 */
	public void deleteRrNetwkIntfcReqList(RrNetwkIntfcReqList rrNetwkIntfcReqList) {
		sqlSession.update("ncis.sql.cmn.rrNetwkIntfcReqList.deleteRrNetwkIntfcReqList", rrNetwkIntfcReqList);
	}

	/**
	 * @param rsrcReqNetwkIntfcVo
	 */
	public void updateRrNetwkIntfcReqIp(RsrcReqNetwkIntfcVo rsrcReqNetwkIntfcVo)
	{
		sqlSession.update("ncis.sql.cmn.rrNetwkIntfcReqList.updateRrNetwkIntfcReqIp", rsrcReqNetwkIntfcVo);
	}
}
