/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmThrdConfDao.java
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
package ncis.dsb.thrd.thrdConf.dao;

import java.util.List;

import ncis.dsb.thrd.thrdConf.vo.VmThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.VmThrdConfVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("vmThrdConfDao")
public class VmThrdConfDao {

	@Autowired SqlSessionTemplate sqlSession;

	public List<VmThrdConfVo> selectVmThrdConfList(VmThrdConfSearchVo paramVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.vmThrdConf.selectVmThrdConfList",paramVo);
	}
	public int selectVmThrdConfListCount(VmThrdConfSearchVo paramVo){
		return sqlSession.selectOne("ncis.sql.dsb.thrd.vmThrdConf.selectVmThrdConfListCount",paramVo);
	}

}
