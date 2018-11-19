/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmLogDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.log.vmLog.dao;

import java.util.List;

import ncis.dsb.stts.log.vmLog.vo.VmLogSearchVo;
import ncis.dsb.stts.log.vmLog.vo.VmLogVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("vmLogDao")
public class VmLogDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 가상서버 로그 조회
	 * */
	public int selectVmLogTotCnt(VmLogSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.vmlog.selectVmLogTotCnt",searchVo);
	}

	public List<VmLogVo> selectVmLogList(VmLogSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.vmlog.selectVmLogList",searchVo);
	}

}
