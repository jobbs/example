/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CodeDao.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 29.
 * @lastmodified 2016. 9. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 29.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.code.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ncis.cmn.vo.TreeNode;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("codeDao")
public class CodeDao {

	@Autowired SqlSession sqlSession;

    /**
     * @param searchVo
     * @return
     */
    public List<CodeVo> selectCodeChildList(CodeSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.code.selectCodeChildList",searchVo);
    }

    /**
     * @param searchVo
     * @param state
     * @return
     */
    public List<TreeNode<String, CodeVo>> selectCodeListTree(String parentCd, String parentGrpCd, String state) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parentCd", parentCd);
        params.put("parentGrpCd", parentGrpCd);
        params.put("state", state);
        return sqlSession.selectList("ncis.sql.cpt.code.selectCodeListTree",params);
    }

    /**
     * @param cd
     * @param grpCd
     * @return
     */
    public CodeVo selectCode(String cd, String grpCd) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("cd", cd);
        params.put("grpCd", grpCd);
        return sqlSession.selectOne("ncis.sql.cpt.code.selectCode",params);
    }

    /**
     * 그룹에 같은
     * @param cd
     * @param grpCd
     * @return
     */
    public int selectExistsCd(String cd, String grpCd) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("cd", cd);
        params.put("grpCd", grpCd);
        return sqlSession.selectOne("ncis.sql.cpt.code.selectExistsCd", params);
    }

    /**
     * 저장하기 전에 잡아 놓기 위해 필요한 쿼리
     */
    public void selectSelectForUpdate(CodeVo code) {
        sqlSession.selectOne("ncis.sql.cpt.code.selectForUpdate");
    }

    /**
     * @param searchVo
     * @return
     */
    public int selectCodeTotCnt(CodeSearchVo searchVo) {
        return sqlSession.selectOne("ncis.sql.cpt.code.selectCodeTotCnt", searchVo);
    }

    /**
     * @param searchVo
     * @return
     */
    public List<CodeVo> selectCodeList(CodeSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.code.selectCodeList", searchVo);
    }

    /**
     * @param parentCd
     * @param parentGrpCd
     * @return
     */
    public Integer selectMaxOrder(String parentCd, String parentGrpCd) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parentCd", parentCd);
        params.put("parentGrpCd", parentGrpCd);
        return sqlSession.selectOne("ncis.sql.cpt.code.selectMaxOrder", params);
    }

	/**
	 * 코드검색목록 다운로드
	 * @param searchVo
	 * @return
	 */
	public List<CodeVo> selectCodeListXlsDwnl(CodeSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.code.selectCodeListXlsDwnl", searchVo);
	}



}
