/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetSwtchDao.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.dao;

import java.util.List;

import ncis.cpt.rsrc.net.vo.NetSwtchSvo;
import ncis.cpt.rsrc.net.vo.NetSwtchVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 송승규
 *
 */
@Repository("netSwtchDao")
public class NetSwtchDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int selectNetSwtchTotCnt(NetSwtchSvo svo){

		return sqlSession.selectOne("ncis.sql.cpt.netSwtch.selectNetSwtchTotCnt",svo);
	}

	public List<NetSwtchVo> selectNetSwtchList(NetSwtchSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.netSwtch.selectNetSwtchList", svo);
	}
}
