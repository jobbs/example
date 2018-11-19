/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetVmServiceImpl.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.dao.CRcVmDao;
import ncis.cmn.dao.CRrRsrcReqDao;
import ncis.cmn.dao.CRrRsrcReqDtlNetwkDao;
import ncis.cmn.dao.CRrSlbConfIpReqListDao;
import ncis.cmn.dao.CRrVmWrkHistDao;
import ncis.cmn.entity.RnSlb;
import ncis.cmn.entity.RrRsrcReqDtlNetwk;
import ncis.cmn.entity.RrSlbConfIpReqList;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cpt.rsrc.com.dao.VmDao;
import ncis.cpt.rsrc.com.vo.VmResHistVo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.net.dao.NetVmDao;
import ncis.cpt.rsrc.net.service.NetVmService;
import ncis.cpt.rsrc.net.vo.NetL4VmVo;
import ncis.cpt.rsrc.net.vo.NetVmSlbIpVo;
import ncis.cpt.rsrc.net.vo.NetVmSvo;
import ncis.cpt.rsrc.net.vo.NetVmVo;
import ncis.cpt.rsrc.net.vo.SlbReqVo;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;

import org.springframework.stereotype.Service;

/**
 * @author 송승규
 *
 */
@Service("netVmService")
public class NetVmServiceImpl implements NetVmService {

	@Resource(name="vmDao") private VmDao vmDao;

	@Resource(name="netVmDao") private NetVmDao netVmDao;

	@Resource(name="cRrRsrcReqDao") private CRrRsrcReqDao reqDao;

	@Resource(name="cRrRsrcReqDtlNetwkDao") private CRrRsrcReqDtlNetwkDao reqNetDao;

	@Resource(name="cRrSlbConfIpReqListDao") private CRrSlbConfIpReqListDao reqSlbDao;

	@Resource(name="cRcVmDao") private CRcVmDao cRcVmDao;

	@Resource(name="commonService") private CommonService commonService;

	@Resource(name = "cRrVmWrkHistDao")
    private CRrVmWrkHistDao cRrVmWrkHistDao;



	/**
	 * 네트워크 가상서버 목록조회
	 * @param svo
	 * @return
	 */
	@Override
	public List<NetVmVo> selectNetVmList(NetVmSvo svo, boolean isPagination){

		List<NetVmVo> resultList = null;
		int totCnt = netVmDao.selectNetVmTotCnt(svo);

		if(isPagination && totCnt > 0) {
			svo.getPaginationInfo().setTotalRecordCount(totCnt); // 페이지 처리위한 count
        }
        else if(!isPagination){
        	svo.setPaginationInfo(null);
        }

		if(totCnt > 0){
			resultList = netVmDao.selectNetVmList(svo);
		}

		return resultList;
	}

	/**
	 * 네트워크 가상서버 상세조회
	 * @param svo
	 * @return
	 */
	@Override
	public NetVmVo selectNetVm(NetVmVo vo){

		NetVmVo resultVo = new NetVmVo();

		// 필수값 체크
		if(!("").equals(vo.getVmSeq()) && null != vo.getVmSeq()){

			resultVo = netVmDao.selectNetVm(vo.getVmSeq());
		}

		NetVmSvo svo = new NetVmSvo();
		// 하위 스위치 존재여부
		if(resultVo.getSwtchList().size() > 0){
			// L3
			List<BigDecimal> vmList = new ArrayList<BigDecimal>();

			for(int i=0; i<resultVo.getSwtchList().size(); i++){
				NetL4VmVo l4vo = resultVo.getSwtchList().get(i);
				vmList.add(l4vo.getVmSeq());
			}

			svo.setVmList(vmList);

			List<RnSlb> slbList = netVmDao.selectSlbList(svo);
			List<NetVmSlbIpVo> slbIpList = netVmDao.selectSlbIpList(svo);

			resultVo.setSlbList(slbList);
			resultVo.setSlbIpList(slbIpList);
		}else{
			// L4
			List<BigDecimal> vmList = new ArrayList<BigDecimal>();

			vmList.add(vo.getVmSeq());

			svo.setVmList(vmList);

			List<RnSlb> slbList = netVmDao.selectSlbList(svo);
			List<NetVmSlbIpVo> slbIpList = netVmDao.selectSlbIpList(svo);

			resultVo.setSlbList(slbList);
			resultVo.setSlbIpList(slbIpList);
		}

		return resultVo;
	}


	/**
     * 네트워크 가상서버 구성ID수정
     *
     * @param vo
     * @param vmResHistVo
     * @return
     */
    @Override
    public void updateNetVm(NetVmVo vo, VmResHistVo vmResHistVo) {

        if (null != vmResHistVo) {
            cRrVmWrkHistDao.insertRrVmWrkHist(vmResHistVo);
        }

        cRcVmDao.updateRcVm(vo);

    }

	/**
	 * SLB 요청
	 * @param vo
	 */
	@Override
	public void insertSlb(SlbReqVo vo){

		Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();

		// SLB 설정 정보가 존재
		if(!vo.getReqNetList().isEmpty()){

			String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");
			String rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);

			vo.setRsrcReqNo(rsrcReqNo);
			vo.setRsrcReqPrcssStatCd("01"); // 요청
			vo.setTestYn("N");
			vo.setLinkYn("N");
			vo.setRsrcReqTyCd("04"); // SLB 설정

			reqDao.insertRrRsrcReq(vo);

			map.clear();

			//---------------------------------------------------------
			// SLB 상세
			//---------------------------------------------------------
			for(int i=0;i < vo.getReqNetList().size(); i++){

				RrRsrcReqDtlNetwk netVo = vo.getReqNetList().get(i);

				netVo.setRsrcReqSeq(new BigDecimal( ++i ) );
				netVo.setRsrcReqNo(rsrcReqNo);
				netVo.setRsrcReqCn("SLB 생성요청");
				netVo.setRsrcReqPrcssStatCd("01");
				netVo.setZoneId(vo.getZoneId());
				netVo.setNetId(vo.getNetId());
				netVo.setRsrcReqTyCd("04");
				netVo.setRsrcPoolId(vo.getPoolId());

				reqNetDao.insertRrRsrcReqDtlNetwk(netVo);

				map.put(netVo.getVipAddr(), netVo.getRsrcReqSeq() );
			}

			//---------------------------------------------------------
			// SLB 상세
			// SLB IP 적용정보가 존재
			//---------------------------------------------------------
			if(!vo.getReqSlbList().isEmpty() && !map.isEmpty()){

				for(int i=0; i<vo.getReqSlbList().size(); i++){

					RrSlbConfIpReqList slbVo = new RrSlbConfIpReqList();

					slbVo = vo.getReqSlbList().get(i);
					// SLB 설정정보가 존재
					for(int j=0; j<map.size(); j++){
						// SLB 설정정보에 VIP가 존재
						if(map.get(slbVo.getVipAddr()) != null && !("").equals(map.get(slbVo.getVipAddr()))){

							slbVo.setRsrcReqSeq(map.get(slbVo.getVipAddr()));
						}
					}
					// SLB IP 적용정보에 SLB 설정정보의 시퀀스가 들어있으면 insert
					if(slbVo.getRsrcReqSeq() != null && !("").equals(slbVo.getRsrcReqSeq())){
						slbVo.setRsrcReqNo(rsrcReqNo);

						reqSlbDao.insertRrSlbConfIpReqList(slbVo);
					}
				}
			}
		}
	}

	/**
	 * 자원풀 목록 조회
	 * @param vo
	 * @return
	 */
	@Override
	public List<RsrcPoolVo> selectNetRsrcPoolList(NetVmSvo svo){

		List<RsrcPoolVo> resultList = netVmDao.selectNetRsrcPoolList(svo);

		return resultList;
	}

	/**
	 * SLB 적용 가상서버 IP목록
	 * @param svo
	 * @return
	 */
	@Override
	public List<VmVo> selectComVmList(VmSearchVo svo){

		List<VmVo> list = null;

        int vmTotalCount = vmDao.selectVmTotCnt(svo);

        if (vmTotalCount > 0) {
        	svo.getPaginationInfo().setTotalRecordCount(vmTotalCount); // 페이지 처리위한 count

            list = vmDao.selectVmListPaging(svo);
        }

        return list;
	}

	/**
	 * 가상서버 구성ID 카운트
	 * @param vo
	 * @return
	 */
	@Override
	public boolean isExistsVmCompId(String vmCompId){
		int cnt = netVmDao.isExistsVmCompId(vmCompId);
		if(cnt == 0){
			return false;
		}else{
			return true;
		}
	}

}
