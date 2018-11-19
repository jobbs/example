/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchWrkDao.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ncis.cpt.sys.btch.vo.BtchWrkSearchVo;
import ncis.cpt.sys.btch.vo.BtchWrkVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 박봉춘
 *
 */
@Repository("BtchWrkDao")
public class BtchWrkDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 배치 수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectBtchWrkTotCnt(BtchWrkSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.btchwrk.selectBtchWrkTotCnt", searchVo);
	}

	/**
	 * 검색조건에 해당하는 접속정보 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<BtchWrkVo> selectBtchWrkList(BtchWrkSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.btchwrk.selectBtchWrkList", searchVo);
	}

	/**
	 * 해당 배치정보의 정보 조회
	 * @param btchWrkSeq
	 * @return
	 */
	public BtchWrkVo selectBtchWrk(Long btchWrkSeq){
		return sqlSession.selectOne("ncis.sql.cpt.btchwrk.selectBtchWrk", btchWrkSeq);
	}

    /**
     * 사용중인 모든 배치 정보 호출
     * @return
     */
    public List<BtchWrkVo> selectBtchWrkAllList() {
        return sqlSession.selectList("ncis.sql.cpt.btchwrk.selectBtchWrkAllList");
    }

	/**
	 * 배치관리 엑셀 다운로드
	 * @param searchVo
	 * @return
	 */
	public List<BtchWrkVo> selectBtchWrkListXlsDwnl(BtchWrkSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.btchwrk.selectBtchWrkListXlsDwnl", searchVo);
	}

	/**
	 * 배치아이디 포함되어 있는 수 조회
	 * @param btchWrkVo
	 * @return
	 */
	public int selectBtchWrkIdCnt(Long btchWrkSeq, String btchWrkId ) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("btchWrkId", btchWrkId);
		param.put("btchWrkSeq", btchWrkSeq);
		return sqlSession.selectOne("ncis.sql.cpt.btchwrk.selectBtchWrkIdCnt", param);
	}
}
