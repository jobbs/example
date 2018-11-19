package ncis.cmn.dao;

import ncis.cmn.entity.SeqNumInfo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 채번정보 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cSeqNumInfoDao")
public class CSeqNumInfoDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 채번정보 등록
	 * @param seqNumInfo
	 */
	public void insertSeqNumInfo(SeqNumInfo seqNumInfo) {
		sqlSession.insert("ncis.sql.cmn.seqNumInfo.insertSeqNumInfo", seqNumInfo);
	}

	/**
	 * 채번정보 수정
	 * @param seqNumInfo
	 */
	public void updateSeqNumInfo(SeqNumInfo seqNumInfo) {
		sqlSession.update("ncis.sql.cmn.seqNumInfo.updateSeqNumInfo", seqNumInfo);
	}

	/**
	 * 채번정보 삭제
	 * @param seqNumInfo
	 */
	public void deleteSeqNumInfo(SeqNumInfo seqNumInfo) {
		sqlSession.update("ncis.sql.cmn.seqNumInfo.deleteSeqNumInfo", seqNumInfo);
	}

}
