/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmThrdConfDao.java
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

import ncis.cmn.entity.CmUsr;
import ncis.cpt.sys.user.vo.UserVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfPSearchVo;
import ncis.dsb.thrd.thrdConf.vo.UserSearchVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("pmThrdConfDao")
public class PmThrdConfDao {

	@Autowired SqlSessionTemplate sqlSession;

	public List<PmThrdConfVo> selectPmThrdConfList(PmThrdConfSearchVo paramVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.pmThrdConf.selectPmThrdConfList",paramVo);
	}

	public List<PmThrdConfVo> selectAxThrdConfList(PmThrdConfSearchVo paramVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.pmThrdConf.selectAxThrdConfList",paramVo);
	}
	public int selectPmThrdConfListCount(PmThrdConfSearchVo paramVo){
		return sqlSession.selectOne("ncis.sql.dsb.thrd.pmThrdConf.selectPmThrdConfListCount",paramVo);
	}
	//장비권한여부
	public String selectEqpAuthrDspthYn(PmThrdConfPSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.thrd.pmThrdConf.selectEqpAuthrDspthYn",searchVo);
	}
	//통보형식
	public List<String> selectDspthFormList(PmThrdConfPSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.pmThrdConf.selectDspthFormList",searchVo);
	}
	//통보등급
	public List<String> selectDspthGrdList(PmThrdConfPSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.pmThrdConf.selectDspthGrdList",searchVo);
	}
	//통보대상자
	public List<CmUsr> selectEvntDspthChargerList(PmThrdConfPSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.pmThrdConf.selectEvntDspthChargerList",searchVo);
	}
	public List<UserVo> selectUserList(UserSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.thrd.pmThrdConf.selectUserList",searchVo);
	}

}
