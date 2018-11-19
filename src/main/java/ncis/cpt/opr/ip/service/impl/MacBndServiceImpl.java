/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MacBndServiceImpl.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CRcMacBndIntfcAsgnDao;
import ncis.cpt.opr.ip.dao.MacBndDao;
import ncis.cpt.opr.ip.service.MacBndService;
import ncis.cpt.opr.ip.vo.MacBndIntfcAsgnVo;
import ncis.cpt.opr.ip.vo.MacBndSvo;
import ncis.cpt.opr.ip.vo.MacBndVo;

import org.springframework.stereotype.Service;

/**
 * @author 송승규
 *
 */
@Service("macBndService")
public class MacBndServiceImpl implements MacBndService{

	@Resource(name="macBndDao") private MacBndDao macBndDao;

	@Resource(name="cRcMacBndIntfcAsgnDao") private CRcMacBndIntfcAsgnDao cMacBndIntfcAsgnDao;

	/**
	 * MAC대역 목록조회
	 * @param svo
	 * @return
	 */
	@Override
	public List<MacBndVo> selectMacBndList(MacBndSvo svo){

		List<MacBndVo> resultList = null;
		int totCnt = macBndDao.selectMacBndTotCnt(svo);

		if(totCnt > 0){
			svo.getPaginationInfo().setTotalRecordCount(totCnt);
			resultList = macBndDao.selectMacBndList(svo);
		}

		return resultList;
	}

	/**
	 * MAC대역 상세조회
	 * @param svo
	 * @return
	 */
	@Override
	public MacBndVo selectMacBnd(MacBndSvo svo){
		return macBndDao.selectMacBnd(svo);
	}

	/**
	 * MAC대역 상세조회
	 * @param svo
	 * @return
	 */
	@Override
	public List<MacBndVo> selectMacBndDetail(MacBndSvo svo){

		List<MacBndVo> resultList = null;

		int totCnt = macBndDao.selectMacBndDetailCnt(svo);

		if(totCnt > 0){
			svo.getPaginationInfo().setTotalRecordCount(totCnt);
			resultList = macBndDao.selectMacBndDetail(svo);
		}

		return resultList;
	}

	/**
	 * MAC대역 동기화
	 * @param svo
	 */
	@Override
	public void updateMacBndIntfcAsgn(MacBndSvo svo){

		List<MacBndIntfcAsgnVo> macIpList = macBndDao.selectMacBndIpList(svo);
		List<MacBndIntfcAsgnVo> netIntfcIpList = macBndDao.selectNetIntfcIpList(svo);

		// 선택한 MAC대역에 할당가능한? MAC 주소가 있으면
		if(!macIpList.isEmpty()){

			for(int i=0; i<macIpList.size(); i++){

				int cnt = 0;
				MacBndIntfcAsgnVo vo = macIpList.get(i);
				MacBndIntfcAsgnVo compVo = new MacBndIntfcAsgnVo();

				// 선택한 MAC대역의 네트워크 인터페이스 테이블에 IP가 있으면
				if(!netIntfcIpList.isEmpty()){

					for(int j=0; j<netIntfcIpList.size(); j++){

						compVo = netIntfcIpList.get(j);

						// MAC대역 MAC과 네트워크 인터페이스의 MAC 비교, 동일자원풀에 내에서 MAC 주소 체크
						//if(vo.getMacAddr().equals(compVo.getMacAddr())){
						if(vo.getPoolId().equals(compVo.getPoolId()) && vo.getMacAddr().equals(compVo.getMacAddr())){
							cnt++;
							vo.setNetwkIntfcSeq(compVo.getNetwkIntfcSeq());
						}
					}
				}

				if(cnt == 0){
					// 네트워크 인터페이스 테이블에 MAC 주소가 존재하지 않을 경우 할당여부'N', 할당일자 null
					vo.setNetwkIntfcSeq(new BigDecimal(0));	// 미할당일 경우 네트워크인터페이스시퀀스가 디폴트값 : 0;
					vo.setAsgnYn("N");
					vo.setAsgnDt(null);

					cMacBndIntfcAsgnDao.updateRcMacBndIntfcAsgn(vo);
				}else{
					// 네트워크 인터페이스 테이블에 MAC 주소가 존재할 경우 할당여부'Y', 할당일자가 있으면 pass, 할당일자가 없으면 현재시간
					vo.setAsgnYn("Y");
					if(vo.getAsgnDt() == null || ("").equals(vo.getAsgnDt())){
						vo.setAsgnDt(new Date());
					}

					cMacBndIntfcAsgnDao.updateRcMacBndIntfcAsgn(vo);
				}
			}
		}
	}
}
