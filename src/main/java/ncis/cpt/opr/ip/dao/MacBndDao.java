/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MacBndDao.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.dao;

import java.util.List;

import ncis.cpt.opr.ip.vo.MacBndIntfcAsgnVo;
import ncis.cpt.opr.ip.vo.MacBndSvo;
import ncis.cpt.opr.ip.vo.MacBndVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 송승규
 *
 */
@Repository("macBndDao")
public class MacBndDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int selectMacBndTotCnt(MacBndSvo svo){

		return sqlSession.selectOne("ncis.sql.cpt.macBnd.selectMacBndTotCnt", svo);
	}

	public List<MacBndVo> selectMacBndList(MacBndSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.macBnd.selectMacBndList", svo);
	}


	/**
	 * @param svo
	 * @return
	 */
	public MacBndVo selectMacBnd(MacBndSvo svo) {
		return sqlSession.selectOne("ncis.sql.cpt.macBnd.selectMacBnd", svo);
	}

	public List<MacBndVo> selectMacBndDetail(MacBndSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.macBnd.selectMacBndDetail", svo);
	}

	public int selectMacBndDetailCnt(MacBndSvo svo){

		return sqlSession.selectOne("ncis.sql.cpt.macBnd.selectMacBndDetailCnt", svo);
	}

	public List<MacBndIntfcAsgnVo> selectMacBndDetailList(MacBndSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.macBnd.selectMacBndDetailList", svo);
	}

	public List<MacBndIntfcAsgnVo> selectMacBndIpList(MacBndSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.macBnd.selectMacBndIpList", svo);
	}

	public List<MacBndIntfcAsgnVo> selectNetIntfcIpList(MacBndSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.macBnd.selectNetIntfcIpList", svo);
	}

}
