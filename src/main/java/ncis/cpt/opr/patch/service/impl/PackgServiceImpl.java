/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgServiceImpl.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.COaAlrmTrgtDao;
import ncis.cmn.dao.COaPackgAlrmDao;
import ncis.cmn.dao.COaPatchAlrmRelateVerDao;
import ncis.cmn.dao.COaVmPatchAlrmDao;
import ncis.cmn.entity.OaAlrmTrgt;
import ncis.cmn.entity.OaPackgAlrm;
import ncis.cmn.entity.OaPackgReposit;
import ncis.cmn.entity.OaPatchAlrmRelateVer;
import ncis.cmn.entity.OaVmPatchAlrm;
import ncis.cmn.exception.JsonException;
import ncis.cmn.util.RequestUtils;
import ncis.cpt.opr.patch.dao.PackgDao;
import ncis.cpt.opr.patch.service.PackgService;
import ncis.cpt.opr.patch.vo.PackgInfoVo;
import ncis.cpt.opr.patch.vo.PackgSearchVo;
import ncis.cpt.opr.patch.vo.PackgVo;

import org.springframework.stereotype.Service;

/**
 * @author 이화영
 *
 */
@Service("packgService")
public class PackgServiceImpl implements PackgService {

	@Resource(name="packgDao")
	private PackgDao packgDao;

	@Resource(name="cOaPatchAlrmRelateVerDao")
	private COaPatchAlrmRelateVerDao cOaPatchAlrmRelateVerDao;

	@Resource(name="cOaPackgAlrmDao")
	private COaPackgAlrmDao cOaPackgAlrmDao;

	@Resource(name="cOaVmPatchAlrmDao")
	private COaVmPatchAlrmDao cOaVmPatchAlrmDao;

	@Resource(name="cOaAlrmTrgtDao")
	private COaAlrmTrgtDao cOaAlrmTrgtDao;

	/**
	 * 검색 조건에 해당하는 패키지 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	@Override
	public List<PackgVo> selectPackgList(PackgSearchVo searchVo) {

		List<PackgVo> list = null;

		int totalCount = packgDao.selectPackgListTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = packgDao.selectPackgList(searchVo);
		}
		return list;
	}

	/**
	 * 패키지 Excel 목록 조회
	 * @param searchVo
	 * @return
	 */
	@Override
	public List<PackgVo> selectPackgExcelList(PackgSearchVo searchVo){
		List<PackgVo> list = null;

		list = packgDao.selectPackgExcelList(searchVo);

		return list;

	}

	/**
     * 리전 리스트 조회
     * @return

	@Override
	public List<RcRegion> selectRegionList() {
		return packgDao.selectRegionList();
	}*/

	/**
	 * 망 리스트 조회
     * @param regionId
     * @return

	@Override
    public List<RcNet> selectPackgNetListByRegion(String regionId) {
        return packgDao.selectPackgNetListByRegion(regionId);
    }*/

	/**
	 * 레파지토리 리스트 조회
     * @param regionId
     * @return
     */
	@Override
    public List<OaPackgReposit> selectPackgRepositListByNet(PackgSearchVo searchVo) {
        return packgDao.selectPackgRepositListByNet(searchVo);
    }

	 /**
     * 패키지 상세 조회
     * @param packgVo
     * @return
     */
	@Override
    public PackgInfoVo selectPackg(PackgVo packgVo) {
        return packgDao.selectPackg(packgVo);
    }

	 /**
     * 패키지 상세 조회(패치대상 가상서버 목록)
     * @param searchVo
     * @return
     */
	@Override
	public List<PackgVo> selectPatchTrgtList(PackgSearchVo searchVo) {

		List<PackgVo> list = null;

		int totalCount = packgDao.selectPatchTrgtListTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = packgDao.selectPatchTrgtList(searchVo);
		}
		return list;
	}

	 /**
     * 패키지 이전 버전 조회 화면 호출
     * @param searchVo
     * @return
     */
	@Override
	public List<PackgVo> selectPackgVerList(PackgSearchVo searchVo) {

		List<PackgVo> list = null;

		int totalCount = packgDao.selectPackgVerListTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = packgDao.selectPackgVerList(searchVo);
		}
		return list;
	}


	/**
	 * 알림등록
	 * @param packgVo
	 * @return
	 */
	@Override
	public void insertPatchAlrm(PackgVo packgVo) throws Exception{
		try {
		//패치알림 등록
		OaPackgAlrm oaPackgAlrm = new OaPackgAlrm();
		oaPackgAlrm.setPatchAlrmNm(packgVo.getPatchAlrmNm());//패치알림명
		oaPackgAlrm.setPatchAlrmTyCd(packgVo.getPatchAlrmTyCd());//패치알림유형코드
		oaPackgAlrm.setPatchAlrmDspthId(RequestUtils.getUserId());//패치알림통보자ID
		oaPackgAlrm.setPatchAlrmCn(packgVo.getPatchAlrmCn());//패치알림내용
		cOaPackgAlrmDao.insertOaPackgAlrm(oaPackgAlrm);

		//패치알림관련패키지버전 등록
		OaPatchAlrmRelateVer oaPatchAlrmRelateVer = new OaPatchAlrmRelateVer();

		//대상패키지 등록 의사결정 후 삭제 예정 임시 주석
		/*oaPatchAlrmRelateVer.setPackgSeq(new BigDecimal(packgVo.getTrgPackgSeq()));//패키지seq
		oaPatchAlrmRelateVer.setVer(packgVo.getTrgPackgVer());//패키지버전
		oaPatchAlrmRelateVer.setRelease(packgVo.getTrgRelease());//릴리즈
		oaPatchAlrmRelateVer.setPatchAlrmSeq(oaPackgAlrm.getPatchAlrmSeq());//패치알림seq
		oaPatchAlrmRelateVer.setCompPackgClCd("01");//구성패키지구분코드
		cOaPatchAlrmRelateVerDao.insertOaPatchAlrmRelateVer(oaPatchAlrmRelateVer);
*/
		//적용패키지 등록
		oaPatchAlrmRelateVer.setPackgSeq(new BigDecimal(packgVo.getApplcPackgSeq()));//패키지seq
		oaPatchAlrmRelateVer.setVer(packgVo.getApplcPackgVer());//패키지버전
		oaPatchAlrmRelateVer.setRelease(packgVo.getApplcRelease());//릴리즈
		oaPatchAlrmRelateVer.setPatchAlrmSeq(oaPackgAlrm.getPatchAlrmSeq());//패치알림seq
		oaPatchAlrmRelateVer.setCompPackgClCd("02");//구성패키지구분코드
		cOaPatchAlrmRelateVerDao.insertOaPatchAlrmRelateVer(oaPatchAlrmRelateVer);

		//가상서버SEQ, 가상서버구성ID 구하기
		List<PackgVo> vmInfoList = packgDao.selectVmInfoList(packgVo);


		//가상서버별패치알림 등록
		for (PackgVo vmInfo  : vmInfoList) {
			OaVmPatchAlrm oaVmPatchAlrm = new OaVmPatchAlrm();
			oaVmPatchAlrm.setPatchAlrmSeq(oaPackgAlrm.getPatchAlrmSeq());//패치알림seq
			oaVmPatchAlrm.setVmSeq(vmInfo.getVmSeq());//가상서버Seq
			oaVmPatchAlrm.setApplcYn("N");//적용여부
			oaVmPatchAlrm.setPackgSeq(new BigDecimal(packgVo.getApplcPackgSeq()));//패키지seq
			oaVmPatchAlrm.setVer(vmInfo.getVer());//버전
			oaVmPatchAlrm.setRelease(vmInfo.getRelease());//릴리즈
			cOaVmPatchAlrmDao.insertOaVmPatchAlrm(oaVmPatchAlrm);


			OaAlrmTrgt oaAlrmTrgt = new OaAlrmTrgt();
			if(!"".equals(vmInfo.getVmCompId()) && null != vmInfo.getVmCompId()){
				List<PackgVo> vmChargerList = packgDao.selectVmChargerList(vmInfo.getVmCompId());

				if(null != vmChargerList && vmChargerList.size() > 0){
					//알림대상자 등록
					for (PackgVo vmCharger  : vmChargerList) {
						oaAlrmTrgt.setPatchAlrmSeq(oaPackgAlrm.getPatchAlrmSeq());//패치알림seq
						oaAlrmTrgt.setVmSeq(vmInfo.getVmSeq());//가상서버seq
						oaAlrmTrgt.setChargerId(vmCharger.getUserId());//담당자id
						oaAlrmTrgt.setChargerClCd(vmCharger.getRelaterClCd());//담당자구분코드
						oaAlrmTrgt.setConfrmYn("N");
						cOaAlrmTrgtDao.insertOaAlrmTrgt(oaAlrmTrgt);
					}
				}else{
					List<PackgVo> jobChargerList = packgDao.selectJobChargerList(vmInfo.getVmSeq());

					if(null != jobChargerList && jobChargerList.size() > 0){
						//알림대상자 등록
						for (PackgVo jobCharger  : jobChargerList) {
							oaAlrmTrgt.setPatchAlrmSeq(oaPackgAlrm.getPatchAlrmSeq());//패치알림seq
							oaAlrmTrgt.setVmSeq(vmInfo.getVmSeq());//가상서버seq
							oaAlrmTrgt.setChargerId(jobCharger.getUserId());//담당자id
							oaAlrmTrgt.setChargerClCd(jobCharger.getUserClCd());//담당자구분코드
							oaAlrmTrgt.setConfrmYn("N");
							cOaAlrmTrgtDao.insertOaAlrmTrgt(oaAlrmTrgt);
						}
					}else{
						throw new Exception("패치대상 가상서버에 담당자가 존재하지 않습니다.");
					}
				}
			}else{
				List<PackgVo> jobChargerList = packgDao.selectJobChargerList(vmInfo.getVmSeq());

				if(null != jobChargerList && jobChargerList.size() > 0){
					//알림대상자 등록
					for (PackgVo jobCharger  : jobChargerList) {
						oaAlrmTrgt.setPatchAlrmSeq(oaPackgAlrm.getPatchAlrmSeq());//패치알림seq
						oaAlrmTrgt.setVmSeq(vmInfo.getVmSeq());//가상서버seq
						oaAlrmTrgt.setChargerId(jobCharger.getUserId());//담당자id
						oaAlrmTrgt.setChargerClCd(jobCharger.getRelaterClCd());//담당자구분코드
						oaAlrmTrgt.setConfrmYn("N");
						cOaAlrmTrgtDao.insertOaAlrmTrgt(oaAlrmTrgt);
					}
				}else{
					throw new Exception("패치대상 가상서버에 담당자가 존재하지 않습니다.");
				}
			}
		}

	} catch (Exception e) {
		throw new JsonException(e.getMessage());
	}
}

}
