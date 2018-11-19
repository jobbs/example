/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PhyStrgDao.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 25.
 * @lastmodified 2016. 10. 25.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.dao;

import java.util.List;

import ncis.cpt.rsrc.strg.vo.PhyStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.PhyStrgVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 김봉민
 *
 */
@Repository("phyStrgDao")
public class PhyStrgDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    /**
     * 물리스토리지 조회 count
     * @param searchVo
     * @return
     */
    public Integer selectPStrgListTotCnt(PhyStrgSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.strg.phystrg.selectPStrgListTotCnt", searchVo);
	}

    /**
     * 물리스토리지 조회
     * @param searchVo
     * @return
     */
	public List<PhyStrgVo> selectPStrgList(PhyStrgSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.rsrc.strg.phystrg.selectPStrgList", searchVo);
	}


	/**
	 * 가상스토리지별 용량 총수량 조회
	 * @param searchVo
	 * @return
	 */
	public Integer selectVrStrgCapaListTotCnt(VrStrgSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.strg.phystrg.selectVrStrgCapaListTotCnt", searchVo);
	}

	/**
	 * 가상스토리지별 용량 조회
	 * @param searchVo
	 * @return
	 */
	public List<VrStrgVo> selectVrStrgCapaList(VrStrgSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.rsrc.strg.phystrg.selectVrStrgCapaList", searchVo);
	}


}
