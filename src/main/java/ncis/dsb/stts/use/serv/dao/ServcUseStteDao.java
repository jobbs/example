/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ServcUseStteDao.java
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
package ncis.dsb.stts.use.serv.dao;

import java.util.List;

import ncis.dsb.stts.use.serv.vo.ServcUseStteSearchVo;
import ncis.dsb.stts.use.serv.vo.ServcUseStteVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("servcUseStteDao")
public class ServcUseStteDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 클라우드 서비스 이용 현황 목록(가상서버)
	 * */
	public List<ServcUseStteVo> selectServcUseStteList(ServcUseStteSearchVo searchVo){
		//return null;
		return sqlSession.selectList("ncis.sql.dsb.stts.serv.selectServcUseStteList",searchVo);
	}
	/**
	 * 클라우드 서비스 이용 현황 건수
	 * */
	public int selectServcUseStteTotCnt(ServcUseStteSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.serv.selectServcUseStteTotCnt",searchVo);
	}


	/**
	 * 클라우드 서비스 이용 현황 목록(자동확장)
	 * */
	public List<ServcUseStteVo> selectServcUseStteAtmSclList(ServcUseStteSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.serv.selectServcUseStteAtmSclList",searchVo);
	}


}
