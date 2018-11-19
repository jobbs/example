/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetPmServiceImpl.java
 *
 * @author 최경철
 * @lastmodifier 최경철
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     최경철         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CRcPmDao;
import ncis.cpt.rsrc.net.dao.NetPmDao;
import ncis.cpt.rsrc.net.service.NetPmService;
import ncis.cpt.rsrc.net.vo.NetPmSearchVo;
import ncis.cpt.rsrc.net.vo.NetPmVo;

import org.springframework.stereotype.Service;

/**
 * @author 최경철
 *
 */
@Service("netPmService")
public class NetPmServiceImpl implements NetPmService {

    @Resource(name = "cRcPmDao")
    private CRcPmDao cRcPmDao;

    @Resource(name = "netPmDao")
    private NetPmDao netPmDao;


    /*
     * 네트워크 물리서버 목록 조회
     */
    @Override
    public List<NetPmVo> selectNetPmList(NetPmSearchVo netPmSearchVo, boolean isPagination) {

        List<NetPmVo> netPmList = null;

        int netPmTotalCount = netPmDao.selectNetPmTotCnt(netPmSearchVo);

        if(isPagination && netPmTotalCount > 0) {
            netPmSearchVo.getPaginationInfo().setTotalRecordCount(netPmTotalCount); // 페이지 처리위한 count
        }
        else if(!isPagination){
            netPmSearchVo.setPaginationInfo(null);
        }

        if(netPmTotalCount > 0){
            netPmList = netPmDao.selectPmList(netPmSearchVo);
        }

        return netPmList;

    }

    /*
     * 네트워크 물리서버 상세 조회
     */
    @Override
    public NetPmVo selectNetPm(BigDecimal pmSeq) {

        return netPmDao.selectNetPm(pmSeq);

    }

    /*
     * 물리서버 정보 수정
     */
	@Override
	public void updateNetPm(NetPmVo netPmVo) {
		cRcPmDao.updateRcPmCompId(netPmVo);
	}

	/*
	 * 물리서버 구성ID 존재 여부
	 */
	@Override
	public boolean isExistsPmCompId(String pmCompId) {

		if (netPmDao.selectPmTotCntByPmCompId(pmCompId) == 0) {
            return false;
        }
        else {
            return true;
        }
	}

}
