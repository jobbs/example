package ncis.cmn.dao;

import ncis.cpt.opr.catalg.vo.TmplatVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 템플릿 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cRrTmplatDao")
public class CRrTmplatDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 템플릿 사용 수정
	 * @param svo
	 */
	public void updateTmplatUseY(Integer tmplatSeq){

		sqlSession.update("ncis.sql.cmn.rrTmplat.updateRrTmplatUseY", tmplatSeq);
	}

	/**
	 * 템플릿 미사용 수정
	 * @param svo
	 */
	public void updateTmplatUseN(Integer tmplatSeq){

		sqlSession.update("ncis.sql.cmn.rrTmplat.updateRrTmplatUseN", tmplatSeq);
	}

	/**
	 * 템플릿수정
	 * @param tmplatVo
	 */
	public void updateRrTmplat(TmplatVo tmplatVo) {

		sqlSession.update("ncis.sql.cmn.rrTmplat.updateRrTmplat", tmplatVo);
	}

	/**
	 * 자원요청 템플릿 사용여부 수정
	 * @param tmplatVo
	 */
	public void updateRrTmplatRsrcReqInit(String rsrcReqNo) {

		sqlSession.update("ncis.sql.cmn.rrTmplat.updateRrTmplatRsrcReqInit", rsrcReqNo);
	}

}
