/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CommonService.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 23.
 * @lastmodified 2016. 9. 23.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 23.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.service;

import java.util.List;

import ncis.cmn.entity.CmUserWrkHist;
import ncis.cpt.sys.code.vo.CodeSearchVo;
import ncis.cpt.sys.code.vo.CodeVo;

/**
 * @author 최진호
 *
 */
public interface CommonService {

    /**
     * 채번
     * @param classfy   구분
     * @param prefix    PREFIX( ex : DJ_2016_ )
     * @return
     */
    public String selectSeqNum(String classfy, String prefix );


    /**
     * 자식 코드 목록 호출
     * @param parentGrpCd 부모그룹코드
     * @param parentCd    부모코드
     * @return
     */
    public List<CodeVo> selectCodeList(String parentGrpCd, String parentCd);

    /**
     * 자식 코드 목록 호출
     * @param parentGrpCd 부모그룹코드
     * @param parentCd    부모코드
     * @param isWhole     전체여부
     * @return
     */
    public List<CodeVo> selectCodeList(String parentGrpCd, String parentCd, boolean isWhole);


    /**
     * @param searchVo
     * @return
     */
    public List<CodeVo> selectCodeList(CodeSearchVo searchVo);

    /**
     * 코드 상세 조회
     * @param grpCd
     * @param cd
     * @return
     */
    public CodeVo selectCode(String cd, String grpCd);

    /**
     * 작업이력 등록
     * @param userWrkHist
     */
    public void insertUserWrkHist(CmUserWrkHist userWrkHist);
}
