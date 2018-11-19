/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PmServiceImpl.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CRcPmDao;
import ncis.cpt.rsrc.com.dao.PmDao;
import ncis.cpt.rsrc.com.service.PmService;
import ncis.cpt.rsrc.com.vo.PmSearchVo;
import ncis.cpt.rsrc.com.vo.PmVo;

import org.springframework.stereotype.Service;

/**
 * @author 심원보
 *
 */
@Service("pmService")
public class PmServiceImpl implements PmService {

    @Resource(name = "cRcPmDao")
    private CRcPmDao cRcPmDao;

    @Resource(name = "pmDao")
    private PmDao pmDao;

    /*
     * 물리서버 목록 조회
     */
    @Override
    public List<PmVo> selectPmList(PmSearchVo pmSearchVo, boolean isPagination) {

        List<PmVo> pmList = null;

        int pmTotalCount = pmDao.selectPmTotCnt(pmSearchVo);

        if (isPagination && pmTotalCount > 0) {
            pmSearchVo.getPaginationInfo().setTotalRecordCount(pmTotalCount); // 페이지 처리위한 count
        }
        else if (!isPagination) {
            pmSearchVo.setPaginationInfo(null);
        }

        if (pmTotalCount > 0) {
            pmList = pmDao.selectPmList(pmSearchVo);
        }

        return pmList;

    }

   /*
    * 물리서버 상세조회
    */
    @Override
    public PmVo selectPm(BigDecimal pmSeq) {

        return pmDao.selectPm(pmSeq);

    }

   /*
    * 물리서버 정보 수정
    */
    @Override
    public void updatePm(PmVo pmVo) {
        cRcPmDao.updateRcPmCompId(pmVo);
    }

   /*
    * 물리서버 구성ID 존재 여부
    */
    @Override
    public boolean isExistsPmCompId(String pmCompId) {

        if (pmDao.selectPmTotCntByPmCompId(pmCompId) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

   /*
    * IP주소를 통한 pmSeq 조회
    */
	@Override
	public BigDecimal selectPmSeqByIpAddr(String ipAddr) {
		return pmDao.selectPmSeqByIpAddr(ipAddr);
	}



	/**
	 * 물리섭서 상태 수정
	 */
	@Override
	public void updateRcPmStat(PmVo pmVo) {
		cRcPmDao.updateRcPmStat(pmVo);

	}



}
