/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename MngmObjVmServiceImpl.java
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
package ncis.cpt.opr.patch.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.COaVmInstlPackgDao;
import ncis.cmn.entity.OaPackg;
import ncis.cmn.entity.OaPackgVer;
import ncis.cmn.entity.OaVmInstlPackg;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.util.ObjectUtils;
import ncis.cpt.opr.patch.dao.MngmObjVmDao;
import ncis.cpt.opr.patch.service.MngmObjVmService;
import ncis.cpt.opr.patch.vo.MngmObjVmSearchVo;
import ncis.cpt.opr.patch.vo.MngmObjVmVo;
import ncis.cpt.rsrc.com.service.VmService;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.intfc.seoa.service.SeoaService;
import ncis.intfc.seoa.vo.PackageVO;
import ncis.intfc.seoa.vo.TargetVmInsertDataVO;
import ncis.intfc.seoa.vo.TargetVmVO;

import org.springframework.stereotype.Service;

/**
 * @author 최경철
 *
 */
/**
 * @author 최경철
 *
 */
@Service("mngmObjVmService")
public class MngmObjVmServiceImpl implements MngmObjVmService {

	@Resource(name="mngmObjVmDao")
	private MngmObjVmDao mngmObjVmDao;

	@Resource(name = "cOaVmInstlPackgDao")
    private COaVmInstlPackgDao cOaVmInstlPackgDao;  // 가상서버설치패키지 DAO

	@Resource(name = "vmService")
    VmService vmService;

	@Resource(name = "seoaService")
	SeoaService seoaService;

	/*
	 * 관리대상 가상서버 목록 조회
	 */
	@Override
	public List<MngmObjVmVo> selectMngmObjVmList(MngmObjVmSearchVo mngmObjVmSearchVo, boolean isPagination) {

		List<MngmObjVmVo> mngmObjVmVoList = null;
        int totalCount = mngmObjVmDao.selectMngmObjVmTotCnt(mngmObjVmSearchVo);

        if(isPagination && totalCount > 0) {
        	mngmObjVmSearchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
        }
        else if(!isPagination){
        	mngmObjVmSearchVo.setPaginationInfo(null);
        }

        if(totalCount > 0){
        	mngmObjVmVoList = mngmObjVmDao.selectMngmObjVmList(mngmObjVmSearchVo);
        }

        return mngmObjVmVoList;
	}

	/*
	 * 관리대상 가상서버 상세정보 조회
	 */
	@Override
	public MngmObjVmVo selectMngmObjVm(MngmObjVmSearchVo mngmObjVmSearchVo) {
		return mngmObjVmDao.selectMngmObjVm(mngmObjVmSearchVo);
	}

	/*
	 * 관리대상 가상서버 요청정보 조회
	 */
	@Override
	public MngmObjVmVo selectMngmObjVmReq(BigDecimal vmSeq) {
		return mngmObjVmDao.selectMngmObjVmReq(vmSeq);
	}

	/*
	 * 가상서버 패키지관리대상 등록 및 삭제
	 */
	@Override
	public void updateMngmObjVm(MngmObjVmSearchVo mngmObjVmSearchVo) throws Exception {

		List<BigDecimal> updtCheck = mngmObjVmSearchVo.getUpdtCheck();

		if("Y".equals(mngmObjVmSearchVo.getSearchPackgMngTrgtYn())) {

			for (BigDecimal vmSeq : updtCheck) {

				// 패키지관리대상에서 삭제 할 가상서버 요청정보 조회
				MngmObjVmVo selectMngmObjVmReq = mngmObjVmDao.selectMngmObjVmReq(vmSeq);
				VmVo vmVo = new VmVo();
				vmVo.setVmSeq(vmSeq);
				vmVo.setPackgMngTrgtYn("N");

				RestHeaders headers = new RestHeaders();
				headers.setAreaId(selectMngmObjVmReq.getRegionId());
				headers.setZoneId(selectMngmObjVmReq.getZoneId());
				headers.setNetworkId(selectMngmObjVmReq.getNetClCd());
				headers.setManagerId(selectMngmObjVmReq.getRsrcPoolId());
				headers.setMachineIp(selectMngmObjVmReq.getRprsntIpAddr());

				// 패키지관리대상 삭제 요청
				seoaService.deleteTargetVM(selectMngmObjVmReq.getRprsntIpAddr(), headers);

				// 가상서버 패키지 대상여부값 변경
				vmService.updateRcVmPackgMngTrgtYn(vmVo);
			}

		}
		else {

			RestHeaders headers = new RestHeaders();
			List<TargetVmVO> insertData = new ArrayList<TargetVmVO>();

			for (BigDecimal vmSeq : updtCheck) {

				// 패키지관리대상으로 등록 할 가상서버 요청정보 조회
				MngmObjVmVo selectMngmObjVmReq = mngmObjVmDao.selectMngmObjVmReq(vmSeq);
				VmVo vmVo = new VmVo();
				vmVo.setVmSeq(vmSeq);
				vmVo.setPackgMngTrgtYn("Y");

				if(null == headers.getAreaId() || "".equals(headers.getAreaId()))
					headers.setAreaId(selectMngmObjVmReq.getRegionId());
				if(null == headers.getZoneId() || "".equals(headers.getZoneId()))
					headers.setZoneId(selectMngmObjVmReq.getZoneId());
				if(null == headers.getNetworkId() || "".equals(headers.getNetworkId()))
					headers.setNetworkId(selectMngmObjVmReq.getNetClCd());
				if(null == headers.getManagerId() || "".equals(headers.getManagerId()))
					headers.setManagerId(selectMngmObjVmReq.getRsrcPoolId());

				TargetVmVO targetVmVO = new TargetVmVO();
				targetVmVO.setMachineIp(selectMngmObjVmReq.getRprsntIpAddr());
				targetVmVO.setOrganizationId(selectMngmObjVmReq.getInstitutionId());
				targetVmVO.setVmUuid(selectMngmObjVmReq.getUuid());

				insertData.add(targetVmVO);

				// 가상서버 패키지 대상여부값 변경
				vmService.updateRcVmPackgMngTrgtYn(vmVo);

			}

			// 패키지관리대상 등록 요청
			TargetVmInsertDataVO targetVmInsertDataVO = new TargetVmInsertDataVO();
			targetVmInsertDataVO.setInsertData(insertData);

			seoaService.insertTargetVM(headers, targetVmInsertDataVO);

		}

	}

	/*
	 * 가상서버 패키지 동기화
	 */
	@Override
	public void updateMngmObjVmSync(MngmObjVmSearchVo mngmObjVmSearchVo) throws Exception {

		List<BigDecimal> updtCheck = mngmObjVmSearchVo.getUpdtCheck();

		for (BigDecimal vmSeq : updtCheck) {

			// 패키지 동기화 할 가상서버 요청정보 조회
			MngmObjVmVo selectMngmObjVmReq = mngmObjVmDao.selectMngmObjVmReq(vmSeq);

			RestHeaders headers = new RestHeaders();
			headers.setAreaId(selectMngmObjVmReq.getRegionId());
			headers.setZoneId(selectMngmObjVmReq.getZoneId());
			headers.setNetworkId(selectMngmObjVmReq.getNetClCd());
			headers.setManagerId(selectMngmObjVmReq.getRsrcPoolId());


//			headers.setAreaId("DJ");
//			headers.setZoneId("03");
//			headers.setNetworkId("I");
//			headers.setManagerId("DJ_03_I_OPR_SEOA_1.0_001");

//			seoaService.installedPackage("10.182.239.28", headers);
			// 가상서버 패키지 정보 조회
			List<PackageVO> packageVoList = seoaService.installedPackage(selectMngmObjVmReq.getRprsntIpAddr(), headers);

			if(!ObjectUtils.isEmpty(packageVoList)) {

				for (PackageVO packageVO : packageVoList) {

					OaVmInstlPackg vmInstlPackgEntity = new OaVmInstlPackg();
					vmInstlPackgEntity.setVer(packageVO.getVersion());           // 패키지버전
					vmInstlPackgEntity.setPackgNm(packageVO.getName());   // 패키지명
					vmInstlPackgEntity.setInstlDt(packageVO.getInstallDate());   // 설치일자
					vmInstlPackgEntity.setRelease(packageVO.getRelease());   // 릴리즈
					vmInstlPackgEntity.setVmSeq(vmSeq); // 가상서버SEQ
					vmInstlPackgEntity.setDelYn("N");
					vmInstlPackgEntity.setDelDttm(null);
					vmInstlPackgEntity.setDelUserId(null);

					// 패키지 삭제여부 Y가 아닌 데이터 조회
					OaPackg oaPackg = new OaPackg();
					oaPackg.setPackgNm(packageVO.getName());      // 패키지명
					oaPackg = mngmObjVmDao.selectOaPackgDeleted(oaPackg);

					// 3. 패키지가 존재하면 동기화 진행
					if (oaPackg != null) {

						// 패키지버전 삭제여부 Y가 아닌 데이터 조회
						OaPackgVer oaPackgVer = new OaPackgVer();
						oaPackgVer.setPackgSeq(oaPackg.getPackgId());  // 패키지SEQ
						oaPackgVer.setVer(packageVO.getVersion());      // 패키지 버전
						oaPackgVer.setRelease(packageVO.getRelease());       // 릴리즈
						oaPackgVer = mngmObjVmDao.selectOaPackgVerDeleted(oaPackgVer);

						// 4. 패키지버전이 존재하면 동기화 진행
						if (oaPackgVer != null) {
							vmInstlPackgEntity.setPackgSeq(oaPackg.getPackgId()); // 패키지SEQ

							// 가상서버패키지 조회
							OaVmInstlPackg oaVmInstlPackg = mngmObjVmDao.selectOaVmInstlPackg(vmInstlPackgEntity);

							// 5. 가상서버패키지가 존재하지 않으면 추가, 존재하면 삭제여부 확인 후 업데이트
							if (oaVmInstlPackg == null) {
								cOaVmInstlPackgDao.insertOaVmInstlPackg(vmInstlPackgEntity);            // 가상서버설치패키지 추가
							}
							else {
								// 가상서버설치패키지 삭제여부가 Y가 아니면 업데이트 진행
								cOaVmInstlPackgDao.updateOaVmInstlPackg(vmInstlPackgEntity);    // 가상서버설치패키지 업데이트

							}

						}

					}

				}
			}


		}


	}


}
