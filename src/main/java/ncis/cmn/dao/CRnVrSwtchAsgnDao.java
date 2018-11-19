package ncis.cmn.dao;

import java.math.BigDecimal;
import ncis.cmn.entity.RnVrSwtchAsgn;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 가상스위치(VLAN)할당 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRnVrSwtchAsgnDao")
public class CRnVrSwtchAsgnDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 가상스위치(VLAN)할당 등록
	 * @param rnVrSwtchAsgn
	 */
	public void insertRnVrSwtchAsgn(RnVrSwtchAsgn rnVrSwtchAsgn) {
		sqlSession.insert("ncis.sql.cmn.rnVrSwtchAsgn.insertRnVrSwtchAsgn", rnVrSwtchAsgn);
	}

	/**
	 * 가상스위치(VLAN)할당 삭제 (개별)
	 * @param rnVrSwtchAsgn
	 */
	public void deleteRnVrSwtchAsgn(RnVrSwtchAsgn rnVrSwtchAsgn) {
		sqlSession.delete("ncis.sql.cmn.rnVrSwtchAsgn.deleteRnVrSwtchAsgn", rnVrSwtchAsgn);
	}

	/**
     * 가상스위치(VLAN)할당 삭제 (전체)
     * @param rnVrSwtchAsgn
     */
    public void deleteRnVrSwtchAsgnByBndSeq(BigDecimal bndSeq) {
        sqlSession.delete("ncis.sql.cmn.rnVrSwtchAsgn.deleteRnVrSwtchAsgnByBndSeq", bndSeq);
    }

}
