/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * DbmsSpaceUseRtDao.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 *
 */
package ncis.dsb.stts.cludSwtchGoalRslt.dao;

import java.util.List;




import ncis.cmn.entity.StYrCludNwUseInstitution;
import ncis.dsb.stts.cludSwtchGoalRslt.vo.CludNewUseInsttVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cludNewUseInsttDao")
public class CludNewUseInsttDao {

	@Autowired SqlSessionTemplate sqlSession;

	public List<CludNewUseInsttVo> selectCludNewUseInsttList()throws Exception{
		return sqlSession.selectList("ncis.sql.dsb.stts.cludSwtchGoalRslt.cludNewUseInstt.selectCludNewUseInsttList");
	}
	public List<CludNewUseInsttVo> selectCludNewUseInsttDtl(StYrCludNwUseInstitution vo)throws Exception{
		return sqlSession.selectList("ncis.sql.dsb.stts.cludSwtchGoalRslt.cludNewUseInstt.selectCludNewUseInsttDtl", vo);
	}
	public int selectCludNewUseInsttCnt(StYrCludNwUseInstitution vo)throws Exception{
		return sqlSession.selectOne("ncis.sql.dsb.stts.cludSwtchGoalRslt.cludNewUseInstt.selectCludNewUseInsttCnt", vo);
	}

	public List<String> selectRegPosblYear()throws Exception{
		return sqlSession.selectList("ncis.sql.dsb.stts.cludSwtchGoalRslt.cludNewUseInstt.selectRegPosblYear");
	}
	public void insertCludNewUseInstt( StYrCludNwUseInstitution vo)throws Exception{
		sqlSession.insert("ncis.sql.cmn.stYrCludNwUseInstitution.insertStYrCludNwUseInstitution", vo);
	}
	public void deleteCludNewUseInstt( StYrCludNwUseInstitution vo)throws Exception{
		sqlSession.insert("ncis.sql.cmn.stYrCludNwUseInstitution.deleteStYrCludNwUseInstitution", vo);
	}

}
