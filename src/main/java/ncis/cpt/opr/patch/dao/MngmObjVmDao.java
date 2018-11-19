/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MngmObjVmDao.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.dao;

import java.math.BigDecimal;
import java.util.List;

import ncis.cmn.entity.OaPackg;
import ncis.cmn.entity.OaPackgVer;
import ncis.cmn.entity.OaVmInstlPackg;
import ncis.cpt.opr.patch.vo.MngmObjVmSearchVo;
import ncis.cpt.opr.patch.vo.MngmObjVmVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 최경철
 *
 */
@Repository("mngmObjVmDao")
public class MngmObjVmDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
     * 관리대상 가상서버 목록 수 조회
     *
     * @param mngmObjVmSearchVo
     * @return
     */
    public int selectMngmObjVmTotCnt(MngmObjVmSearchVo mngmObjVmSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.opr.patch.mngmObjVm.selectMngmObjVmTotCnt", mngmObjVmSearchVo);

    }

    /**
     * 관리대상 가상서버 목록 조회
     *
     * @param mngmObjVmSearchVo
     * @return
     */
    public List<MngmObjVmVo> selectMngmObjVmList(MngmObjVmSearchVo mngmObjVmSearchVo) {

        return sqlSession.selectList("ncis.sql.cpt.opr.patch.mngmObjVm.selectMngmObjVmList", mngmObjVmSearchVo);

    }

    /**
     * 관리대상 가상서버 상세 정보 조회
     *
     * @param mngmObjVmSearchVo
     * @return
     */
    public MngmObjVmVo selectMngmObjVm(MngmObjVmSearchVo mngmObjVmSearchVo) {

        return sqlSession.selectOne("ncis.sql.cpt.opr.patch.mngmObjVm.selectMngmObjVm", mngmObjVmSearchVo);

    }

    /**
     * 관리대상 가상서버 요청 정보 조회
     * @param vmSeq
     * @return
     */
    public MngmObjVmVo selectMngmObjVmReq(BigDecimal vmSeq) {

        return sqlSession.selectOne("ncis.sql.cpt.opr.patch.mngmObjVm.selectMngmObjVmReq", vmSeq);

    }

    /**
     * 패키지 삭제여부 Y가 아닌 데이터 조회
     * @param oaPackg
     */
    public OaPackg selectOaPackgDeleted(OaPackg oaPackg) {
        return sqlSession.selectOne("ncis.sql.cpt.opr.patch.mngmObjVm.selectOaPackgDeleted", oaPackg);
    }

    /**
     * 패키지버전 삭제여부 Y가 아닌 데이터 조회
     * @param oaPackgVer
     */
    public OaPackgVer selectOaPackgVerDeleted(OaPackgVer oaPackgVer) {
        return sqlSession.selectOne("ncis.sql.cpt.opr.patch.mngmObjVm.selectOaPackgVerDeleted", oaPackgVer);
    }

    /**
	 * 가상서버설치패키지 조회
	 * @param oaVmInstlPackg
	 */
	public OaVmInstlPackg selectOaVmInstlPackg(OaVmInstlPackg oaVmInstlPackg) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.patch.mngmObjVm.selectOaVmInstlPackg", oaVmInstlPackg);
	}

}
