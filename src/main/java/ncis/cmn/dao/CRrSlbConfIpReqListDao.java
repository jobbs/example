package ncis.cmn.dao;

import ncis.cmn.entity.RrSlbConfIpReqList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * SLB설정IP요청목록 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrSlbConfIpReqListDao")
public class CRrSlbConfIpReqListDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * SLB설정IP요청목록 등록
	 * @param rrSlbConfIpReqList
	 */
	public void insertRrSlbConfIpReqList(RrSlbConfIpReqList rrSlbConfIpReqList) {
		sqlSession.insert("ncis.sql.cmn.rrSlbConfIpReqList.insertRrSlbConfIpReqList", rrSlbConfIpReqList);
	}

	/**
	 * SLB설정IP요청목록 수정
	 * @param rrSlbConfIpReqList
	 */
	public void updateRrSlbConfIpReqList(RrSlbConfIpReqList rrSlbConfIpReqList) {
		sqlSession.update("ncis.sql.cmn.rrSlbConfIpReqList.updateRrSlbConfIpReqList", rrSlbConfIpReqList);
	}

	/**
	 * SLB설정IP요청목록 삭제
	 * @param rrSlbConfIpReqList
	 */
	public void deleteRrSlbConfIpReqList(RrSlbConfIpReqList rrSlbConfIpReqList) {
		sqlSession.update("ncis.sql.cmn.rrSlbConfIpReqList.deleteRrSlbConfIpReqList", rrSlbConfIpReqList);
	}

}
