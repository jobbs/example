/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetVmDao.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.dao;

import java.math.BigDecimal;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ncis.cmn.entity.RnSlb;
import ncis.cpt.rsrc.net.vo.NetVmSlbIpVo;
import ncis.cpt.rsrc.net.vo.NetVmSvo;
import ncis.cpt.rsrc.net.vo.NetVmVo;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;

/**
 * @author 송승규
 *
 */
@Repository("netVmDao")
public class NetVmDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int selectNetVmTotCnt(NetVmSvo svo){

		return sqlSession.selectOne("ncis.sql.cpt.netVm.selectNetVmTotCnt",svo);
	}

	public List<NetVmVo> selectNetVmList(NetVmSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.netVm.selectNetVmList", svo);
	}

	public NetVmVo selectNetVm(BigDecimal vmSeq){

		return sqlSession.selectOne("ncis.sql.cpt.netVm.selectNetVmDetail",vmSeq);
	}

	public List<RnSlb> selectSlbList(NetVmSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.netVm.selectSlbList",svo);
	}

	public List<NetVmSlbIpVo> selectSlbIpList(NetVmSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.netVm.selectSlbIpList",svo);
	}

	public List<RsrcPoolVo> selectNetRsrcPoolList(NetVmSvo svo){

		return sqlSession.selectList("ncis.sql.cpt.netVm.selectNetVmRsrcPoolList",svo);
	}

	public int isExistsVmCompId(String vmCompId){

		return sqlSession.selectOne("ncis.sql.cpt.netVm.isExistsVmCompId",vmCompId);
	}


}
