/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetSwtchServiceImpl.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 28.
 * @lastmodified 2016. 10. 28.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 28.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CRnNetwkSwtchDao;
import ncis.cmn.entity.RnNetwkSwtch;
import ncis.cpt.rsrc.net.dao.NetSwtchDao;
import ncis.cpt.rsrc.net.service.NetSwtchService;
import ncis.cpt.rsrc.net.vo.NetSwtchSvo;
import ncis.cpt.rsrc.net.vo.NetSwtchVo;

import org.springframework.stereotype.Service;

/**
 * @author 송승규
 *
 */
@Service("netSwtchService")
public class NetSwtchServiceImpl implements NetSwtchService{

	@Resource(name="netSwtchDao") private NetSwtchDao netSwtchDao;

	@Resource(name="cRnNetwkSwtchDao") private CRnNetwkSwtchDao cNetSwtchDao;

	/**
	 * 부처별 L3/L4 목록 조회
	 * @param svo
	 * @return
	 */
	@Override
	public List<NetSwtchVo> selectNetSwtchList(NetSwtchSvo svo){

		List<NetSwtchVo> resultList = null;

		int totCnt = netSwtchDao.selectNetSwtchTotCnt(svo);

		if(totCnt > 0){
			svo.getPaginationInfo().setTotalRecordCount(totCnt);
			resultList = netSwtchDao.selectNetSwtchList(svo);
		}

		return resultList;
	}

	/**
	 * 부처별 L3/L4 수정
	 * @param svo
	 */
	@Override
	public void updateNetSwtch(NetSwtchVo vo, NetSwtchSvo svo){

		List<NetSwtchVo> list = selectNetSwtchList(svo);
		List<RnNetwkSwtch> compList = vo.getNetSwtchList();

		if(!list.isEmpty()){

			for(int i=0; i<list.size(); i++){

				int cnt = 0;
				NetSwtchVo nsVo = list.get(i);
				RnNetwkSwtch compVo = new NetSwtchVo();

				if(!compList.isEmpty()){

					for(int j=0; j<compList.size(); j++){
						compVo = compList.get(j);

						if(("").equals(nsVo.getInstitutionId()) || null == nsVo.getInstitutionId()){
							cnt++;
						}else{
							if(nsVo.getVmSeq().equals(compVo.getVmSeq()) && !nsVo.getInstitutionId().equals(compVo.getInstitutionId())){
								cnt++;
							}
						}
					}

					if(cnt != 0){
						cNetSwtchDao.updateRnNetwkSwtch(vo.getNetSwtchList().get(i));
					}
					// 2016.12.15 네트워크스위치 L3-L4 관계 설정.
					if ("02".equals(nsVo.getNetwkTyClCd())) {
						cNetSwtchDao.updateRnNetwkSwtchUpperVm(vo.getNetSwtchList().get(i));
					}
				}
			}
		}
	}
}
