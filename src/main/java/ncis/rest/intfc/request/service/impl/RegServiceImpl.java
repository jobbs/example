/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RegServiceImpl.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.rest.intfc.request.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CRrHaCompDao;
import ncis.cmn.dao.CRrNetwkIntfcReqListDao;
import ncis.cmn.dao.CRrRsrcReqDao;
import ncis.cmn.dao.CRrRsrcReqDtlNetwkDao;
import ncis.cmn.dao.CRrRsrcReqDtlPRsrcDao;
import ncis.cmn.dao.CRrRsrcReqDtlVmDao;
import ncis.cmn.dao.CRrSlbConfIpReqListDao;
import ncis.cmn.dao.CRrStrgDelReqListDao;
import ncis.cmn.entity.RcClstr;
import ncis.cmn.entity.RcPm;
import ncis.cmn.entity.RcVm;
import ncis.cmn.entity.RrHaComp;
import ncis.cmn.entity.RrNetwkIntfcReqList;
import ncis.cmn.entity.RrRsrcReq;
import ncis.cmn.entity.RrRsrcReqDtlNetwk;
import ncis.cmn.entity.RrRsrcReqDtlPRsrc;
import ncis.cmn.entity.RrRsrcReqDtlVm;
import ncis.cmn.entity.RrSlbConfIpReqList;
import ncis.cmn.entity.RrStrgDelReqList;
import ncis.cmn.service.CommonService;
import ncis.cmn.util.DateUtil;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.cpt.sys.user.service.UserService;
import ncis.cpt.sys.user.vo.UserVo;
import ncis.rest.intfc.request.dao.RegDao;
import ncis.rest.intfc.request.service.RegService;
import ncis.rest.intfc.request.vo.CreateClusterClusterInfoVO;
import ncis.rest.intfc.request.vo.CreateClusterVO;
import ncis.rest.intfc.request.vo.CreatePmPmInfoVO;
import ncis.rest.intfc.request.vo.CreatePmVO;
import ncis.rest.intfc.request.vo.CreateSLBVO;
import ncis.rest.intfc.request.vo.CreateSLBVmInfoVO;
import ncis.rest.intfc.request.vo.CreateVmVO;
import ncis.rest.intfc.request.vo.CreateVmVmInfoVO;
import ncis.rest.intfc.request.vo.IpInfoVO;
import ncis.rest.intfc.request.vo.ModifyVmVO;
import ncis.rest.intfc.request.vo.ModifyVmVmInfoVO;
import ncis.rest.intfc.request.vo.RemoveClusterClusterInfoVO;
import ncis.rest.intfc.request.vo.RemoveClusterVO;
import ncis.rest.intfc.request.vo.RemovePmPmInfoVO;
import ncis.rest.intfc.request.vo.RemovePmVO;
import ncis.rest.intfc.request.vo.RemoveReqVO;
import ncis.rest.intfc.request.vo.RemoveVmVO;
import ncis.rest.intfc.request.vo.RemoveVmVmInfoVO;
import ncis.rest.intfc.request.vo.ReqResultVO;

import org.springframework.stereotype.Service;

/**
 * 요청정보수신 Service Implement
 *
 * @author ShinKeeBong
 *
 */

@Service("regService")
public class RegServiceImpl implements RegService {


	@Resource(name="regDao")
	private RegDao regDao;

	@Resource(name="cRrRsrcReqDao")
	private CRrRsrcReqDao cRrRsrcReqDao;                  //자원요청 DAO

	@Resource(name="cRrRsrcReqDtlVmDao")
	private CRrRsrcReqDtlVmDao cRrRsrcReqDtlVmDao;        //자원요청상세_가상서버 DAO

	@Resource(name="cRrHaCompDao")
	private CRrHaCompDao cRrHaCompDao;                    //HA구성 DAO

	@Resource(name="cRrStrgDelReqListDao")
	private CRrStrgDelReqListDao cRrStrgDelReqListDao;    //스토리지삭제요청목록 DAO

	@Resource(name="cRrRsrcReqDtlPRsrcDao")
	private CRrRsrcReqDtlPRsrcDao cRrRsrcReqDtlPRsrcDao;  //자원요청상세_물리자원 DAO


	@Resource(name="cRrRsrcReqDtlNetwkDao")
	private CRrRsrcReqDtlNetwkDao cRrRsrcReqDtlNetwkDao;



	@Resource(name="cRrSlbConfIpReqListDao")
	private CRrSlbConfIpReqListDao cRrSlbConfIpReqListDao;

	//RR_RSRC_REQ_DTL_NETWK

	@Resource(name="userService")
	UserService userService;

	@Resource(name="commonService")
	CommonService commonService;


	@Resource(name="cRrNetwkIntfcReqListDao")
	private CRrNetwkIntfcReqListDao cRrNetwkIntfcReqListDao;
	/**
	 * 가상서버 생성 요청정보 수신
	 * @param vo
	 * @return
	 *
	 */
	@SuppressWarnings("unused")
	@Override
	public ReqResultVO createVM(CreateVmVO vo) throws Exception {
		/*
		 * 자원요청유형코드
		 *
		 * 01:가상서버생성
		 * 02:가상서버삭제
		 * 03:가상서버스펙변경
		 * 05:물리서버추가
		 * 06:물리서버삭제
		 * 07:클러스터추가
		 * 08:클러스터삭제
		 * 04:SLB설정
		 */
		String rsrcReqTyCd = "01";
		String rsrcReqPrcssStatCd = "01";// 자원요청진행상태코드 01:요청
		RrRsrcReq mst= null;
		RrRsrcReqDtlVm dtl = null;
		String rsrcReqNo=null;
		IpInfoVO iivo=null;
		RrNetwkIntfcReqList rrNetwkIntfcReq=null;

		if(vo !=null){

			CreateVmVmInfoVO cvvivo = null;
			UserVo user = userService.selectUser(vo.getReqUserId());

			String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");

			RcVm rcVm = null;
			for(int i=0; i < vo.getVmInfos().size();i++){

				rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);

				mst = new RrRsrcReq();
				mst.setRsrcReqNo(rsrcReqNo);
				mst.setRsrcReqUserId(vo.getReqUserId());
				mst.setTicktNo(vo.getReqId());
				mst.setSbjct(vo.getSubject());
				mst.setRegionId(vo.getCenterId());
				mst.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
				mst.setRsrcReqTyCd(rsrcReqTyCd);
				mst.setReqInstitutionId(user !=null?user.getInstitutionId():null);
				mst.setRegUserId(vo.getReqUserId());                    // 등록자ID
				mst.setRsrcReqDttm(vo.getReqDate());//요청일시 현재 now()로 처리됨.

				cRrRsrcReqDao.insertRrRsrcReq(mst);

				if(rsrcReqNo !=null){
					dtl = new RrRsrcReqDtlVm();
					cvvivo = null;
					rcVm = null;
					cvvivo = vo.getVmInfos().get(i);
					dtl.setRsrcReqNo(rsrcReqNo);
					dtl.setRsrcReqSeq(new BigDecimal(1));
					dtl.setRsrcReqTyCd(rsrcReqTyCd);
					dtl.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청

					dtl.setVmCompId(cvvivo.getVmConfId());                 //가상서버구성ID
					dtl.setRsrcReqTyCd(rsrcReqTyCd);               //자원요청유형코드
					dtl.setVmNm(cvvivo.getVmName());                   //가상서버명

					dtl.setHstNm(cvvivo.getHostNm());                  //호스트명
					dtl.setPrposClCd(cvvivo.getPurposeCode());           //용도코드
					dtl.setUseGvDprtId(cvvivo.getCustId());            //사용부처ID
					dtl.setUseJobId(cvvivo.getApplId());               //사용업무ID
					//dtl.setIpAddr(cvvivo);               //IP주소
					dtl.setOsTyCd(cvvivo.getOsCode());                 //OS유형코드
					dtl.setServcStrtDt(cvvivo.getLeaseStartDate());    //서비스시작일자
					dtl.setServcEndDt(cvvivo.getLeaseExpiredDate());   //서비스종료일자

					dtl.setReqCpuVcoreQty(cvvivo.getVcore());             //요청CPU(vCore)
					dtl.setReqMemAsgnCapa(cvvivo.getMemory());                 //요청메모리(GB)
					dtl.setReqSpecSeq(new Integer(String.valueOf(cvvivo.getInstanceTypeId())));      //요청스펙ID
					dtl.setTmplatSeq(new Integer(String.valueOf(cvvivo.getTemplateId())));           //템플릿ID

					/*SwSeq 가 맞는지 확인필요*/
					dtl.setSwSeq(new Integer(String.valueOf(cvvivo.getTemplateSwId())));				//템플릿 SW ID


					dtl.setShareYn(cvvivo.getIsShare());               //공유여부
					dtl.setNetClCd(cvvivo.getNetworkCode());           //망구분코드
					dtl.setOprChargerId(cvvivo.getOpr1UserId());       //운영담당자ID
					dtl.setOprBusnssOperId(cvvivo.getOprMainId());     //운영사업자ID

					//dtl.setClstrSeq(new BigDecimal(i));
					//dtl.setRsrcReqSeq(new BigDecimal(i));sequence로 자동입력됨.
					rcVm  = regDao.selectRcVmByVmCompId(cvvivo.getVmConfId());
					//dtl.setZoneId(vo.getCenterId());
					BigDecimal rsrcReqSeq = cRrRsrcReqDtlVmDao.insertRrRsrcReqDtlVm(dtl);
					rrNetwkIntfcReq = null;
					if(cvvivo.getIpInfos() != null){
						for(int j=0; j < cvvivo.getIpInfos().size();j++){
							iivo = null;
							iivo=cvvivo.getIpInfos().get(j);
							rrNetwkIntfcReq = new RrNetwkIntfcReqList();
							rrNetwkIntfcReq.setRsrcReqNo(rsrcReqNo);
							rrNetwkIntfcReq.setRsrcReqSeq(rsrcReqSeq);
							rrNetwkIntfcReq.setNicPrposCd(iivo.getNicTypeCode());//용도코드는 중복되면 안됨.
							rrNetwkIntfcReq.setIpBndSeq(Integer.valueOf(iivo.getIpBndSeq()));
							rrNetwkIntfcReq.setIpAddr(iivo.getIpAddress());
							rrNetwkIntfcReq.setNatYn("N");//어떤값이 올지 아직 미정.
							cRrNetwkIntfcReqListDao.insertRrNetwkIntfcReqList(rrNetwkIntfcReq);
						}
					}

					//HA구성
					RrHaComp rrHaComp = new RrHaComp();
					rrHaComp.setHaCompYn(cvvivo.getIsHa());                 //HA구성여부
					rrHaComp.setHaStatCd(cvvivo.getHaState());              //HA상태코드
					rrHaComp.setHaGrpCd(cvvivo.getHaGroupId());             //HA그룹코드
					rrHaComp.setHaGrpNm(cvvivo.getHaGroupNm());             //HA그룹명
					rrHaComp.setHaStrgCapa(cvvivo.getHaStorageSize().intValue());      //HA스토리지용량
					rrHaComp.setHaVmNm(cvvivo.getHaVmName());                               //HA가성서버명
					rrHaComp.setHaHstNm(cvvivo.getHaHostNm());                              //HA호스트명

					//HA구성 테이블 insert
					rrHaComp.setRsrcReqNo(rsrcReqNo);                   //자원요청번호
					rrHaComp.setRsrcReqSeq(rsrcReqSeq);                 //자원요청일련번호
					cRrHaCompDao.insertRrHaComp(rrHaComp);

				}else{
					//return new ReqResultVO(vo.getReqId(), "0000", "실패하였습니다.");실패 관련 코드는 어디에 정의 되어 있는지....?
				}
			}
		}
		return new ReqResultVO(rsrcReqNo, "IFM0000", "성공하였습니다.");
	}

	/**
	 * 가상서버 스펙변경 요청정보 수신
	 * @param vo
	 * @return
	 */
	@Override
	public ReqResultVO modifyVM(ModifyVmVO vo) throws Exception {
		/*
		 * 자원요청유형코드
		 *
		 * 01:가상서버생성
		 * 02:가상서버삭제
		 * 03:가상서버스펙변경
		 * 05:물리서버추가
		 * 06:물리서버삭제
		 * 07:클러스터추가
		 * 08:클러스터삭제
		 * 04:SLB설정
		 */
		String rsrcReqTyCd = "03";
		String rsrcReqPrcssStatCd = "01";// 자원요청진행상태코드 01:요청
		RrRsrcReq mst= null;
		RrRsrcReqDtlVm dtl = null;
		String rsrcReqNo=null;
		if(vo !=null){
			ModifyVmVmInfoVO mvvivo = null;
			UserVo user = userService.selectUser(vo.getReqUserId());
			RcVm rcVm = null;
			BigDecimal rsrcReqSeq = null;

			String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");

			for(int i=0; i < vo.getVmInfos().size();i++){

				rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);

				mst = new RrRsrcReq();
				mst.setRsrcReqNo(rsrcReqNo);
				mst.setRsrcReqUserId(vo.getReqUserId());
				mst.setTicktNo(vo.getReqId());
				mst.setSbjct(vo.getSubject());
				mst.setRegionId(vo.getCenterId());
				mst.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
				mst.setRsrcReqTyCd(rsrcReqTyCd);
				mst.setReqInstitutionId(user !=null?user.getInstitutionId():null);
				mst.setRegUserId(vo.getReqUserId());                    // 등록자ID
				mst.setRsrcReqDttm(vo.getReqDate());//요청일시 현재 now()로 처리됨.
				cRrRsrcReqDao.insertRrRsrcReq(mst);

				if(rsrcReqNo !=null){

					dtl = new RrRsrcReqDtlVm();
					dtl.setRsrcReqNo(rsrcReqNo);
					dtl.setRsrcReqSeq( new BigDecimal(1) );
					dtl.setRsrcReqTyCd(rsrcReqTyCd);
					dtl.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
					mvvivo = null;
					rcVm = null;
					mvvivo = vo.getVmInfos().get(i);
					//dtl.setClstrSeq(new BigDecimal(i));
					//dtl.setRsrcReqSeq(new BigDecimal(i));sequence로 자동입력됨.
					rcVm  = regDao.selectRcVmByVmCompId(mvvivo.getVmConfId());
					dtl.setVmCompId(mvvivo.getVmConfId());
					/*아래 두개의 필드는 통합해야 할 것으로 판단, 어떤것을 사용할지에 따라 추가 수정이 필요하다.*/
					dtl.setReqSpecSeq(new Integer(String.valueOf(mvvivo.getSpecId())));
					dtl.setChngReqSpecSeq(new Integer(String.valueOf(mvvivo.getSpecId())));

					dtl.setChngReqCpuVcoreQty(new Integer(String.valueOf(mvvivo.getVcore())));          //변경요청CPU(vCore)
					dtl.setChngReqMemAsgnCapa(new Integer(String.valueOf(mvvivo.getMemory())));         //변경요청메모리할당량(GB)
					dtl.setChngReqStrgAsgnCapa(new Integer(String.valueOf(mvvivo.getAddDiskSize())));   //변경요청스토리지할당량(GB), 추가디스크사이즈

					/*변경전 spec이 필요한지 확인이 필요함.*/
					//dtl.setChngPreSpecSeq(rcVm.get);
					dtl.setChngPreCpuVcoreQty(rcVm.getCpuVcoreQty());  //변경전CPU(vCore)
					dtl.setChngPreMemAsgnCapa(rcVm.getMemAsgnCapa());  //변경전메모리할당량(GB)
					dtl.setChngPreStrgAsgnCapa(rcVm.getStrgAsgnCapa());//변경전스토리지할당량(GB)
					dtl.setVmSeq(rcVm.getVmSeq());
					//dtl.setZoneId(vo.getCenterId());
					dtl.setShareYn(mvvivo.getIsShare());
					rsrcReqSeq = cRrRsrcReqDtlVmDao.insertRrRsrcReqDtlVm(dtl);

					if(mvvivo.getvDiskId()!=null) // 제거할 가상디스크ID가 넘어왔을 경우
					{
						//스토리지삭제요청목록
						RrStrgDelReqList rrStrgDelReqVo = new RrStrgDelReqList();
						rrStrgDelReqVo.setRsrcReqNo(rsrcReqNo);
						rrStrgDelReqVo.setVrDskId(mvvivo.getvDiskId().intValue());     //제거할 가상디스크ID

						//스토리지삭제요청목록 테이블 insert
						rrStrgDelReqVo.setRsrcReqSeq(rsrcReqSeq);
						cRrStrgDelReqListDao.insertRrStrgDelReqList(rrStrgDelReqVo);
					}
				}else{
					//return new ReqResultVO(vo.getReqId(), "0000", "실패하였습니다.");실패 관련 코드는 어디에 정의 되어 있는지....?
				}
			}
		}
		return new ReqResultVO(vo.getReqId(), "IFM0000", "성공하였습니다.");
	}

	/**
	 * 가상서버 삭제 요청정보 수신
	 * @param vo
	 * @return
	 */
	@Override
	public ReqResultVO removeVM(RemoveVmVO vo) throws Exception {
		/*
		 * 자원요청유형코드
		 *
		 * 01:가상서버생성
		 * 02:가상서버삭제
		 * 03:가상서버스펙변경
		 * 05:물리서버추가
		 * 06:물리서버삭제
		 * 07:클러스터추가
		 * 08:클러스터삭제
		 * 04:SLB설정
		 */
		String rsrcReqTyCd = "02";       // 자원요청유형코드 06:물리서버추가
		String rsrcReqPrcssStatCd = "01";// 자원요청진행상태코드 01:요청
		RrRsrcReq mst= null;
		RrRsrcReqDtlVm dtl = null;
		String rsrcReqNo=null;
		if(vo !=null){

			RemoveVmVmInfoVO cppivo = null;
			UserVo user = userService.selectUser(vo.getReqUserId());
			RcVm rcVm = null;

			String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");

			for(int i=0; i < vo.getVmInfos().size();i++){

				rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);

				mst = new RrRsrcReq();
				mst.setRsrcReqNo(rsrcReqNo);
				mst.setRsrcReqUserId(vo.getReqUserId());
				mst.setTicktNo(vo.getReqId());
				mst.setSbjct(vo.getSubject());
				mst.setRegionId(vo.getCenterId());
				mst.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
				mst.setRsrcReqTyCd(rsrcReqTyCd);
				mst.setReqInstitutionId(user !=null?user.getInstitutionId():null);
				mst.setRegUserId(vo.getReqUserId());                    // 등록자ID
				mst.setRsrcReqDttm(vo.getReqDate());//요청일시 현재 now()로 처리됨.
				cRrRsrcReqDao.insertRrRsrcReq(mst);

				if(rsrcReqNo !=null){
					dtl = new RrRsrcReqDtlVm();
					dtl.setRsrcReqNo(rsrcReqNo);
					dtl.setRsrcReqSeq( new BigDecimal(1) );
					dtl.setRsrcReqTyCd(rsrcReqTyCd);
					dtl.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
					cppivo = null;
					rcVm = null;
					cppivo = vo.getVmInfos().get(i);
					//dtl.setClstrSeq(new BigDecimal(i));
					//dtl.setRsrcReqSeq(new BigDecimal(i));sequence로 자동입력됨.
					rcVm  = regDao.selectRcVmByVmCompId(cppivo.getVmConfId());
					dtl.setVmCompId(cppivo.getVmConfId());
					dtl.setVmSeq(rcVm.getVmSeq());
					//dtl.setZoneId(vo.getCenterId());
					cRrRsrcReqDtlVmDao.insertRrRsrcReqDtlVm(dtl);
				}else{
					//return new ReqResultVO(vo.getReqId(), "0000", "실패하였습니다.");실패 관련 코드는 어디에 정의 되어 있는지....?
				}
			}
		}
		return new ReqResultVO(vo.getReqId(), "IFM0000", "성공하였습니다.");
	}


	/**
	 * 물리서버 생성 요청정보 수신
	 * @param vo
	 * @return
	 */
	@Override
	public ReqResultVO createPM(CreatePmVO vo) throws Exception {
		/*
		 * 자원요청유형코드
		 *
		 * 01:가상서버생성
		 * 02:가상서버삭제
		 * 03:가상서버스펙변경
		 * 05:물리서버추가
		 * 06:물리서버삭제
		 * 07:클러스터추가
		 * 08:클러스터삭제
		 * 04:SLB설정
		 */
		String rsrcReqTyCd = "05";       // 자원요청유형코드 06:물리서버추가
		String rsrcReqPrcssStatCd = "01";// 자원요청진행상태코드 01:요청
		RrRsrcReq mst= null;
		RrRsrcReqDtlPRsrc dtl = null;
		String rsrcReqNo=null;

		if(vo !=null){

			CreatePmPmInfoVO cppivo = null;
			UserVo user = userService.selectUser(vo.getReqUserId());

			String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");

			for(int i=0; i < vo.getPmInfos().size();i++){

				rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);

				mst = new RrRsrcReq();
				mst.setRsrcReqNo(rsrcReqNo);
				mst.setRsrcReqUserId(vo.getReqUserId());
				mst.setTicktNo(vo.getReqId());
				mst.setSbjct(vo.getSubject());
				mst.setRegionId(vo.getCenterId());
				mst.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
				mst.setRsrcReqTyCd(rsrcReqTyCd);
				mst.setReqInstitutionId(user !=null?user.getInstitutionId():null);
				mst.setRegUserId(vo.getReqUserId());                    // 등록자ID
				mst.setRsrcReqDttm(vo.getReqDate());//요청일시 현재 now()로 처리됨.

				cRrRsrcReqDao.insertRrRsrcReq(mst);

				if(rsrcReqNo !=null){
					dtl = new RrRsrcReqDtlPRsrc();
					dtl.setRsrcReqNo(rsrcReqNo);
					dtl.setRsrcReqTyCd(rsrcReqTyCd);
					dtl.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
					cppivo = null;
					cppivo = vo.getPmInfos().get(i);
					//dtl.setClstrSeq(new BigDecimal(i));
					dtl.setRsrcReqSeq(new BigDecimal(1));
					dtl.setPmCompId(cppivo.getPmConfId());
					dtl.setClstrCompId(cppivo.getClusterConfId());
					dtl.setPmNm(cppivo.getPmName());
					//dtl.setZoneId(vo.getCenterId());
					cRrRsrcReqDtlPRsrcDao.insertRrRsrcReqDtlPRsrc(dtl);
				}else{
					//return new ReqResultVO(vo.getReqId(), "0000", "실패하였습니다.");실패 관련 코드는 어디에 정의 되어 있는지....?
				}
			}
		}
		return new ReqResultVO(vo.getReqId(), "IFM0000", "성공하였습니다.");
	}


	/**
	 * 물리서버 삭제 요청정보 수신
	 * @param vo
	 * @return
	 */
	@Override
	public ReqResultVO removePM(RemovePmVO vo) throws Exception {
		/*
		 * 자원요청유형코드
		 *
		 * 01:가상서버생성
		 * 02:가상서버삭제
		 * 03:가상서버스펙변경
		 * 05:물리서버추가
		 * 06:물리서버삭제
		 * 07:클러스터추가
		 * 08:클러스터삭제
		 * 04:SLB설정
		 */
		String rsrcReqTyCd = "06";       // 자원요청유형코드 06:물리서버삭제
		String rsrcReqPrcssStatCd = "01";// 자원요청진행상태코드 01:요청
		RrRsrcReq mst= null;
		RrRsrcReqDtlPRsrc dtl = null;
		String rsrcReqNo=null;
		if(vo !=null){

			String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");

			RemovePmPmInfoVO rppivo = null;
			UserVo user = userService.selectUser(vo.getReqUserId());
			RcPm rcPm = null;
			for(int i=0; i < vo.getPmInfos().size();i++){

				rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);

				mst = new RrRsrcReq();
				mst.setRsrcReqNo(rsrcReqNo);
				mst.setRsrcReqUserId(vo.getReqUserId());
				mst.setTicktNo(vo.getReqId());
				mst.setSbjct(vo.getSubject());
				mst.setRegionId(vo.getCenterId());
				mst.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
				mst.setRsrcReqTyCd(rsrcReqTyCd);
				mst.setReqInstitutionId(user !=null?user.getInstitutionId():null);
				mst.setRegUserId(vo.getReqUserId());                    // 등록자ID
				mst.setRsrcReqDttm(vo.getReqDate());//요청일시 현재 now()로 처리됨.
				cRrRsrcReqDao.insertRrRsrcReq(mst);

				if(rsrcReqNo !=null){
					dtl = new RrRsrcReqDtlPRsrc();
					dtl.setRsrcReqNo(rsrcReqNo);
					dtl.setRsrcReqTyCd(rsrcReqTyCd);
					dtl.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
					rppivo = null;
					rppivo = vo.getPmInfos().get(i);
					dtl.setRsrcReqSeq(new BigDecimal(1));
					dtl.setPmCompId(rppivo.getPmConfId());
					rcPm = regDao.selectRcPmByPmCompId(rppivo.getPmConfId());
					dtl.setPmSeq(rcPm.getPmSeq());
					cRrRsrcReqDtlPRsrcDao.insertRrRsrcReqDtlPRsrc(dtl);
				}else{
					//return new ReqResultVO(vo.getReqId(), "0000", "실패하였습니다.");실패 관련 코드는 어디에 정의 되어 있는지....?
				}
			}
		}
		return new ReqResultVO(vo.getReqId(), "IFM0000", "성공하였습니다.");
	}


	/**
	 * 클러스터 생성 요청정보 수신
	 * @param vo
	 * @return
	 */
	@Override
	public ReqResultVO createCluster(CreateClusterVO vo) throws Exception {
		RrRsrcReq mst= null;
		RrRsrcReqDtlPRsrc dtl = null;
		String rsrcReqNo=null;

		if(vo !=null){

			CreateClusterClusterInfoVO cccivo = null;
			UserVo user = userService.selectUser(vo.getReqUserId());

			String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");

			for(int i=0; i < vo.getClusterInfos().size();i++){

				rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);

				mst = new RrRsrcReq();
				mst.setRsrcReqNo(rsrcReqNo);
				mst.setRsrcReqUserId(vo.getReqUserId());
				mst.setTicktNo(vo.getReqId());
				mst.setSbjct(vo.getSubject());
				mst.setRegionId(vo.getCenterId());
				mst.setRsrcReqPrcssStatCd("01");//자원요청 진행상태코드 01:요청
				mst.setRsrcReqTyCd("07");//추가요청
				mst.setReqInstitutionId(user !=null?user.getInstitutionId():null);//api상에서는 존재하지 않는 파람으로 pk정리되면 주석처리 해야 함.

				cRrRsrcReqDao.insertRrRsrcReq(mst);

				if(rsrcReqNo !=null){
					dtl = new RrRsrcReqDtlPRsrc();
					dtl.setRsrcReqNo(rsrcReqNo);
					dtl.setRsrcReqTyCd("07");//추가요청
					dtl.setRsrcReqPrcssStatCd("01");//자원요청 진행상태코드 01:요청
					cccivo = null;
					cccivo = vo.getClusterInfos().get(i);
					//dtl.setClstrSeq();등록의 경우는 입력되지 않음.
					dtl.setRsrcReqSeq(new BigDecimal(1)); //sequence로 자동입력됨.
					dtl.setClstrCompId(cccivo.getClusterConfId());
					//dtl.setZoneId(vo.getCenterId());
					dtl.setClstrNm(cccivo.getClusterName());
					dtl.setNetClCd(cccivo.getNetworkCode());
					/* 해당 칼름 없음.
						purposeCode	클러스터용도코드
					 * */
					cRrRsrcReqDtlPRsrcDao.insertRrRsrcReqDtlPRsrc(dtl);
				}else{
					//return new ReqResultVO(vo.getReqId(), "0000", "실패하였습니다.");실패 관련 코드는 어디에 정의 되어 있는지....?
				}
			}
		}
		return new ReqResultVO(vo.getReqId(), "IFM0000", "성공하였습니다.");
	}


	/**
	 * 클러스터 삭제 요청정보 수신
	 * @param vo
	 * @return
	 */
	@Override
	public ReqResultVO removeCluster(RemoveClusterVO vo) throws Exception {

		RrRsrcReq mst= null;
		RrRsrcReqDtlPRsrc dtl = null;
		String rsrcReqNo=null;

		if(vo !=null){

			RemoveClusterClusterInfoVO rccivo = null;
			UserVo user = userService.selectUser(vo.getReqUserId());
			RcClstr rcClstr = null;

			String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");

			for(int i=0; i < vo.getClusterInfos().size();i++){

				rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);

				mst = new RrRsrcReq();
				mst.setRsrcReqNo(rsrcReqNo);
				mst.setRsrcReqUserId(vo.getReqUserId());
				mst.setTicktNo(vo.getReqId());
				mst.setSbjct(vo.getSubject());
				mst.setRegionId(vo.getCenterId());
				mst.setRsrcReqPrcssStatCd("01");//자원요청 진행상태코드 01:요청
				mst.setRsrcReqTyCd("08");//삭제요청
				mst.setReqInstitutionId(user != null ? user.getInstitutionId():null);//api상에서는 존재하지 않는 파람으로 pk정리되면 주석처리 해야 함.
				cRrRsrcReqDao.insertRrRsrcReq(mst);
				if(rsrcReqNo !=null){
					dtl = new RrRsrcReqDtlPRsrc();
					dtl.setRsrcReqNo(rsrcReqNo);
					dtl.setRsrcReqSeq(new BigDecimal(1));
					dtl.setRsrcReqTyCd("08");//삭제요청
					dtl.setRsrcReqPrcssStatCd("01");//자원요청 진행상태코드 01:요청
					rccivo = null;
					rcClstr = null;
					rccivo = vo.getClusterInfos().get(i);
					rcClstr = regDao.selectRcClstrByClusterCompId(rccivo.getClusterConfId());
					dtl.setClstrSeq(rcClstr.getClstrSeq());
					//dtl.setRsrcReqSeq(new BigDecimal(i));sequence로 자동입력됨.
					dtl.setClstrCompId(rccivo.getClusterConfId());
					cRrRsrcReqDtlPRsrcDao.insertRrRsrcReqDtlPRsrc(dtl);
				}else{
					//return new ReqResultVO(vo.getReqId(), "0000", "실패하였습니다.");실패 관련 코드는 어디에 정의 되어 있는지....?
				}

			}
		}
		return new ReqResultVO(vo.getReqId(), "IFM0000", "성공하였습니다.");
	}


	/**
	 * SLB 생성 요청정보 수신
	 * @param vo
	 * @return
	 */
	@Override
	public ReqResultVO createSLB(CreateSLBVO vo) throws Exception {
		/*
		 * 자원요청유형코드
		 *
		 * 01:가상서버생성
		 * 02:가상서버삭제
		 * 03:가상서버스펙변경
		 * 05:물리서버추가
		 * 06:물리서버삭제
		 * 07:클러스터추가
		 * 08:클러스터삭제
		 * 04:SLB설정
		 */
		String rsrcReqTyCd = "04";
		String rsrcReqPrcssStatCd = "01";// 자원요청진행상태코드 01:요청
		RrRsrcReq mst= null;
		RrRsrcReqDtlNetwk dtl = null;
		String rsrcReqNo=null;

		RrSlbConfIpReqList rrSlbConfIpReqList = null;

		if(vo !=null){

			String seqNumPrefix = "R" + DateUtil.getCurrentDate("yyyyMMdd");
			rsrcReqNo = commonService.selectSeqNum("RR_RSRC_REQ", seqNumPrefix);

			CreateSLBVmInfoVO cslbvico = null;
			UserVo user = userService.selectUser(vo.getReqUserId());
			mst = new RrRsrcReq();
			mst.setRsrcReqNo(rsrcReqNo);
			mst.setRsrcReqUserId(vo.getReqUserId());
			mst.setTicktNo(vo.getReqId());
			mst.setSbjct(vo.getSubject());
			mst.setRegionId(vo.getCenterId());
			mst.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
			mst.setRsrcReqTyCd(rsrcReqTyCd);
			mst.setReqInstitutionId(user !=null?user.getInstitutionId():null);
			mst.setRegUserId(vo.getReqUserId());                    // 등록자ID
			mst.setRsrcReqDttm(vo.getReqDate());//요청일시 현재 now()로 처리됨.
			RcVm rcVm = null;
			RsrcPoolVo rsrcPoolVo = null;

			cRrRsrcReqDao.insertRrRsrcReq(mst);

			if(rsrcReqNo !=null){
				dtl = new RrRsrcReqDtlNetwk();
				dtl.setRsrcReqNo(rsrcReqNo);
				dtl.setRsrcReqSeq(new BigDecimal(1));
				dtl.setRsrcReqTyCd(rsrcReqTyCd);
				dtl.setRsrcReqPrcssStatCd(rsrcReqPrcssStatCd);//자원요청 진행상태코드 01:요청
				//dtl.vmCNT	가상서버 개수
				dtl.setVipAddr(vo.getVip());//VIP
				dtl.setPort(vo.getLbPort());//	LB포트
				//lbMethod	LB메소드
				dtl.setSessMntncTyCd(vo.getSessionType());//세션유지유형
				dtl.setSessMntncVl(vo.getSessionValue());//	세션유지값
				dtl.setStatConfrm(vo.getStatusCheck());//	상태확인
				dtl.setStatConfrmCycle(BigDecimal.valueOf(vo.getStatusPeriod()));//	상태확인주기(초)
				dtl.setStatConfrmTOut(BigDecimal.valueOf(vo.getStatusTimeout()));//	상태확인타임아웃(초)
				dtl.setMaxTryCnt(BigDecimal.valueOf(vo.getRetryCnt()));//	최대시도회수
				dtl.setStatConfrmHttpUrl(vo.getHttpUrl());//상탱확인	HTTP URL

				rcVm  = regDao.selectRcVmByVmCompId(vo.getVmInfos().get(0).getVmConfId());
				rsrcPoolVo = regDao.selectRsrcPoolByClstrSeq(rcVm.getClstrSeq());
				dtl.setZoneId(rsrcPoolVo.getZoneId());
				dtl.setNetId(rsrcPoolVo.getNetId());
				rcVm = null;

				//dtl.setZoneId(zoneId); 필수
				//dtl.setNetId(netId);필수

				//dtl.setPort(Integer.toString(cslbvico.getPort()));

				//dtl.setVmCompId(cslbvico.getVmConfId());
				//dtl.setClstrCompId(cslbvico.getClusterConfId());
				//dtl.setVmNm(cslbvico.getVmName());

				BigDecimal rsrcReqSeq = cRrRsrcReqDtlNetwkDao.insertRrRsrcReqDtlNetwk(dtl);
				if(rsrcReqSeq != null){
					for(int i=0; i < vo.getVmInfos().size();i++){
						cslbvico = null;
						cslbvico = vo.getVmInfos().get(i);
						//SLB설정IP요청목록
						//RR_SLB_CONF_IP_REQ_LIST
						rrSlbConfIpReqList = new RrSlbConfIpReqList();
						rrSlbConfIpReqList.setRsrcReqNo(rsrcReqNo);
						rrSlbConfIpReqList.setRsrcReqSeq(rsrcReqSeq);
						rcVm= null;
						rcVm  = regDao.selectRcVmByVmCompId(cslbvico.getVmConfId());
						rrSlbConfIpReqList.setVmSeq(rcVm.getVmSeq());
						rrSlbConfIpReqList.setIpAddr(cslbvico.getRealIp());
						rrSlbConfIpReqList.setPort(String.valueOf(cslbvico.getPort().intValue()));
						rrSlbConfIpReqList.setWvl(BigDecimal.valueOf(cslbvico.getLbPoint().intValue()));
						rrSlbConfIpReqList.setVmSeq(rcVm.getVmSeq());
						cRrSlbConfIpReqListDao.insertRrSlbConfIpReqList(rrSlbConfIpReqList);

					}
				}
			}else{
				//return new ReqResultVO(vo.getReqId(), "0000", "실패하였습니다.");실패 관련 코드는 어디에 정의 되어 있는지....?
			}
		}
		return new ReqResultVO(vo.getReqId(), "IFM0000", "성공하였습니다.");
	}



	/**
	 * 요청(취소)삭제 요청정보 수신
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("unused")
	@Override
	public ReqResultVO removeReq(RemoveReqVO vo) throws Exception {

		List<RrRsrcReq> rrRsrcReqList = regDao.selectRrRsrcReqListByTicketNoAndRegionId(vo);
		int mstUpdCnt=0;
		RrNetwkIntfcReqList rrNetwkIntfcReq = null;
		vo.setRsrcReqPrcssStatCd("06");//자원요청진행상태코드 06:요청삭제
		if(rrRsrcReqList !=null && rrRsrcReqList.size()>0){
			for(RrRsrcReq tmpReq:rrRsrcReqList){
				mstUpdCnt = regDao.updateRsrcReqPrcssStatByTicktNo(vo);
				//상세테이블의 변경요청이 있을때 아래에 해당 테이블 update 로직 추가 예정.
	    		switch(tmpReq.getRsrcReqTyCd()){//자원요청유형코드 확인.
		    		case "01": //가상서버생성
		    			rrNetwkIntfcReq = new RrNetwkIntfcReqList();
						rrNetwkIntfcReq.setRsrcReqNo(tmpReq.getRsrcReqNo());
		    			cRrNetwkIntfcReqListDao.deleteRrNetwkIntfcReqList(rrNetwkIntfcReq);
		    			break;
		    		case "02": //가상서버삭제
		    			break;
		    		case "03": //가상서버스펙변경
		    			break;
		    		case "04": //SLB설정
		    			break;
		    		case "05": //물리서버추가
		    			break;
		    		case "06": //물리서버삭제
		    			break;
		    		case "07": //클러스터추가
		    			break;
		    		case "08": //클러스터삭제
		    			break;
		    		default :
		    			break;
	    		}
			}

		}
		return new ReqResultVO(vo.getReqId(), "IFM0000", "성공하였습니다.");
	}

}
