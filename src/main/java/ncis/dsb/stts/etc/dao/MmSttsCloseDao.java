/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * MmSttsCloseDao.java
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
 * 2017. 05. 21   양정순         v2.0             자동확장 추가
 *
 */
package ncis.dsb.stts.etc.dao;

import java.util.List;

import ncis.dsb.stts.etc.vo.MmSttsCloseSearchVo;
import ncis.dsb.stts.etc.vo.MmSttsCloseVo;
import ncis.dsb.stts.etc.vo.AxMmSttsCloseVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mmSttsCloseDao")
public class MmSttsCloseDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색 조건에 해당하는 월별통계마감 수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectMmSttsCloseTotCnt(MmSttsCloseSearchVo searchVo) {
		if(searchVo.getSearchServer().equals("PM")){
			return sqlSession.selectOne("ncis.sql.dsb.stts.etc.mmSttsClose.selectPMMmSttsCloseTotCnt", searchVo);
		}else{
			return sqlSession.selectOne("ncis.sql.dsb.stts.etc.mmSttsClose.selectVMMmSttsCloseTotCnt", searchVo);
		}
	}

	/**
	 * 월별통계마감 조회
	 * @param searchVo
	 * @return
	 */
	public List<MmSttsCloseVo> selectMmSttsCloseList(MmSttsCloseSearchVo searchVo){
		if(searchVo.getSearchServer().equals("PM")){
			return sqlSession.selectList("ncis.sql.dsb.stts.etc.mmSttsClose.selectPMMmSttsCloseList", searchVo);
		}else{
			return sqlSession.selectList("ncis.sql.dsb.stts.etc.mmSttsClose.selectVMMmSttsCloseList", searchVo);
		}
	}

	/**
	 * 검색 조건에 해당하는 자동확장 월별통계마감 수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectAxMmSttsCloseTotCnt(MmSttsCloseSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.dsb.stts.etc.mmSttsClose.selectAxMmSttsCloseTotCnt", searchVo);
	}

	/**
	 * 자동확장 월별통계마감 조회
	 * @param searchVo
	 * @return
	 */
	public List<AxMmSttsCloseVo> selectAxMmSttsCloseList(MmSttsCloseSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.etc.mmSttsClose.selectAxMmSttsCloseList", searchVo);
	}

	/**
	 * 검색 조건에 해당하는 VM통계마감 수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectVmCloseTotCnt(MmSttsCloseSearchVo searchVo){
		if(searchVo.getSearchServer().equals("PM")){
			return sqlSession.selectOne("ncis.sql.dsb.stts.etc.mmSttsClose.selectPmCloseTotCnt", searchVo);
		}else{
			return sqlSession.selectOne("ncis.sql.dsb.stts.etc.mmSttsClose.selectVmCloseTotCnt", searchVo);
		}
	}

	/**
	 * VM통계마감 조회
	 * @param searchVo
	 * @return
	 */
	public List<MmSttsCloseVo> selectVmCloseList(MmSttsCloseSearchVo searchVo){
		if(searchVo.getSearchServer().equals("PM")){
			return sqlSession.selectList("ncis.sql.dsb.stts.etc.mmSttsClose.selectPmCloseList", searchVo);
		}else{
			return sqlSession.selectList("ncis.sql.dsb.stts.etc.mmSttsClose.selectVmCloseList", searchVo);
		}
	}

	/**
	 * 검색 조건에 해당하는 자동확장 통계마감 수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectAxCloseTotCnt(MmSttsCloseSearchVo searchVo){
		return sqlSession.selectOne("ncis.sql.dsb.stts.etc.mmSttsClose.selectAxCloseTotCnt", searchVo);
	}

	/**
	 * 자동확장 통계마감 조회
	 * @param searchVo
	 * @return
	 */
	public List<AxMmSttsCloseVo> selectAxCloseList(MmSttsCloseSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.etc.mmSttsClose.selectAxCloseList", searchVo);
	}

}
