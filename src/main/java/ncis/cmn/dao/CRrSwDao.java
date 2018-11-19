package ncis.cmn.dao;

import java.math.BigDecimal;

import ncis.cmn.entity.RrSw;
import ncis.cpt.opr.catalg.vo.SwVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 소프트웨어 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrSwDao")
public class CRrSwDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 소프트웨어 등록
	 * @param rrSw
	 */
	public void insertRrSw(RrSw rrSw) {
		sqlSession.insert("ncis.sql.cmn.rrSw.insertRrSw", rrSw);
	}

	/**
	 * 소프트웨어 수정
	 * @param rrSw
	 */
	public void updateRrSw(RrSw rrSw) {
		sqlSession.update("ncis.sql.cmn.rrSw.updateRrSw", rrSw);
	}

	/**
	 * 소프트웨어 삭제
	 * @param rrSw
	 */
	public void deleteRrSw(SwVo swVo) {
		sqlSession.delete("ncis.sql.cmn.rrSw.deleteRrSw", swVo);
	}

	/**
	 * 소프트웨어 삭제
	 * @param rrSw
	 */
	public void deleteSw(BigDecimal swSeq) {
		sqlSession.delete("ncis.sql.cmn.rrSw.deleteSw", swSeq);
	}

}
