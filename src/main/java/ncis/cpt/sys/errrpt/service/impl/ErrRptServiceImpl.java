/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ErrRptService.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.errrpt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.ZErrRptDao;
import ncis.cmn.dao.ZErrRptProcssDao;
import ncis.cmn.util.ObjectUtils;
import ncis.cmn.vo.CommonFileVo;
import ncis.cpt.sys.errrpt.dao.ErrRptDao;
import ncis.cpt.sys.errrpt.service.ErrRptService;
import ncis.cpt.sys.errrpt.vo.ErrRptFileVo;
import ncis.cpt.sys.errrpt.vo.ErrRptProcssVo;
import ncis.cpt.sys.errrpt.vo.ErrRptSearchVo;
import ncis.cpt.sys.errrpt.vo.ErrRptVo;
import org.springframework.stereotype.Service;

/**
 * @author 최진호
 *
 */
@Service("errRptService")
public class ErrRptServiceImpl implements ErrRptService {

    @Resource(name="errRptDao") private ErrRptDao errRptDao;

    @Resource(name="zErrRptDao") private ZErrRptDao zErrRptDao;

    @Resource(name="zErrRptProcssDao") private ZErrRptProcssDao zErrRptProcssDao;

    @Override
    public List<ErrRptVo> selectErrRptList(ErrRptSearchVo searchVo) {

        List<ErrRptVo> list = null;

        int totalCount = errRptDao.selectErrRptTotCnt(searchVo);

        if( totalCount > 0 ) {
            searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
            list = errRptDao.selectErrRptList(searchVo);
        }

        return list;
    }

    @Override
    public void insertErrRpt(ErrRptVo errRptVo) {

        zErrRptDao.insertZErrRpt(errRptVo);

        if (!ObjectUtils.isEmpty(errRptVo.getErrRptFiles())) {
            int fileSize = errRptVo.getErrRptFiles().size();
            for (int i = 0; i < fileSize; i++) {
                ErrRptFileVo file = errRptVo.getErrRptFiles().get(i);
                file.setErrRptSeq(errRptVo.getErrRptSeq());
                file.setOrder(i + 1);
                file.setRegId(errRptVo.getRegUsrId());

                zErrRptDao.insertZErrRptFile(file);
            }
        }
    }

    @Override
    public ErrRptVo selectErrRpt(Long errRptSeq) {
        return errRptDao.selectErrRpt(errRptSeq);
    }

    @Override
    public void deleteErrRpt(Long errRptSeq) {
        //파일삭제
        ErrRptVo errRptVo = new ErrRptVo();
        errRptVo.setErrRptSeq(errRptSeq);
        zErrRptDao.deleteZErrRptFiles(errRptVo);
        //프로세스 삭제
        zErrRptProcssDao.deleteZErrRptProcssByParent(errRptSeq);

        zErrRptDao.deleteZErrRpt(errRptSeq);
    }


    @Override
    public void updateErrRpt(ErrRptVo errRptVo) {

        zErrRptDao.updateZErrRpt(errRptVo);

        // 삭제된 파일이 있으면
        if (!ObjectUtils.isEmpty(errRptVo.getDeleteFile())) {
            zErrRptDao.deleteZErrRptFiles(errRptVo);
        }

        // 첨부된 파일이 있으면
        if (!ObjectUtils.isEmpty(errRptVo.getErrRptFiles())) {
            int fileSize = errRptVo.getErrRptFiles().size();
            for (int i = 0; i < fileSize; i++) {
                ErrRptFileVo file = errRptVo.getErrRptFiles().get(i);

                if (file.getSeq() == null) {
                    file.setErrRptSeq(errRptVo.getErrRptSeq());
                    file.setOrder(i + 1);
                    file.setRegId(errRptVo.getRegUsrId());

                    zErrRptDao.insertZErrRptFile(file);
                }
            }
        }
    }

    @Override
    public CommonFileVo selectErrRptFile(Long seq) {
        return errRptDao.selectErrRptFile(seq);
    }

    @Override
    public void insertErrRptProcss(ErrRptProcssVo errRptProcss) {

        //보고서의 상태도 변경한다.
        zErrRptDao.updateZerrRptStat(errRptProcss.getErrRptSeq(), errRptProcss.getProcssStatCd());
        zErrRptProcssDao.insertZErrRptProcss(errRptProcss);
    }

    /* (non-Javadoc)
     * @see ncis.cpt.sys.errrpt.service.ErrRptService#selectErrRptProcss(java.lang.Long)
     */
    @Override
    public ErrRptProcssVo selectErrRptProcss(Long errRptProcssSeq) {
        return errRptDao.selectErrRptProcss(errRptProcssSeq);
    }

    @Override
    public void updateErrRptProcss(ErrRptProcssVo errRptProcss) {
        //보고서의 상태도 변경한다.
        zErrRptDao.updateZerrRptStat(errRptProcss.getErrRptSeq(), errRptProcss.getProcssStatCd());
        zErrRptProcssDao.updateZErrRptProcss(errRptProcss);
    }

    @Override
    public void deleteErrRptProcss(Long errRptProcssSeq) {
        zErrRptProcssDao.deleteZErrRptProcss(errRptProcssSeq);
    }
}
