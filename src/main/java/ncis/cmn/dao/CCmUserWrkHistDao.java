package ncis.cmn.dao;

import ncis.cmn.entity.CmUserWrkHist;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cUserWrkHistDao")
public class CCmUserWrkHistDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 작업이력 저장
	 * @param operateLogVo
	 */
	public void insertUserWrkHist(CmUserWrkHist userwrkhistVo) {
		sqlSession.insert("ncis.sql.cmn.userwrkhist.insertUserWrkHist", userwrkhistVo);
	}

}
