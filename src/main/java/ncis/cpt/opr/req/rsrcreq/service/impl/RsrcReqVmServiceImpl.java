package ncis.cpt.opr.req.rsrcreq.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRnIpDao;
import ncis.cmn.dao.CRrNetwkIntfcReqListDao;
import ncis.cmn.dao.CRrProcssInstDao;
import ncis.cmn.dao.CRrProcssJobListDao;
import ncis.cmn.dao.CRrProcssVarListDao;
import ncis.cmn.dao.CRrRsrcReqDao;
import ncis.cmn.dao.CRrRsrcReqDtlVmDao;
import ncis.cmn.entity.RcNetwkIntfc;
import ncis.cmn.entity.RnIp;
import ncis.cmn.entity.RrNetwkIntfcReqList;
import ncis.cmn.entity.RrProcssInst;
import ncis.cmn.entity.RrProcssJobList;
import ncis.cmn.entity.RrProcssVarList;
import ncis.cmn.entity.RrRsrcReq;
import ncis.cmn.entity.RrRsrcReqDtlVm;
import ncis.cmn.exception.CommonException;
import ncis.cmn.exception.DataNotFoundException;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cpt.opr.ip.vo.IpBndSearchVo;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.opr.ip.vo.IpSearchVo;
import ncis.cpt.opr.ip.vo.IpVo;
import ncis.cpt.opr.req.rsrcreq.dao.RcVmDao;
import ncis.cpt.opr.req.rsrcreq.dao.RsrcReqVmDao;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqVmService;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkIntfcVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.strg.vo.RsrcPoolVrStrgVo;
import ncis.cpt.rsrc.strg.vo.VrDskVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;
import ncis.intfc.ntops.service.NtopsIntfcService;
import ncis.intfc.ntops.vo.ProcessConstant;
import ncis.intfc.vmintfc.service.VmIntfcService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Service("rsrcReqVmService")
public class RsrcReqVmServiceImpl implements RsrcReqVmService
{

	private final Logger logger = LoggerFactory.getLogger(RsrcReqVmServiceImpl.class);

	@Resource(name = "rsrcRcVmDao")
	private RcVmDao rsrcRcVmDao;
	@Resource(name = "cRrRsrcReqDao")
	private CRrRsrcReqDao cRrRsrcReqDao;
	@Resource(name = "rsrcReqVmDao")
	private RsrcReqVmDao rsrcReqVmDao;
	@Resource(name = "cRrRsrcReqDtlVmDao")
	private CRrRsrcReqDtlVmDao cRrRsrcReqDtlVmDao;
	@Resource(name = "cRnIpDao")
	private CRnIpDao cRnIpDao;
	@Resource(name = "cRrNetwkIntfcReqListDao")
	CRrNetwkIntfcReqListDao cRrNetwkIntfcReqListDao;

	@Resource(name = "cRrProcssInstDao")
	private CRrProcssInstDao cRrProcssInstDao;
	@Resource(name = "cRrProcssJobListDao")
	private CRrProcssJobListDao cRrProcssJobListDao;
	@Resource(name = "cRrProcssVarListDao")
	private CRrProcssVarListDao cRrProcssVarListDao;

	@Resource(name = "vmIntfcService")
	private VmIntfcService vmIntfcService;
	@Resource(name = "commonService")
	private CommonService commonService;

	@Resource(name = "ntopsIntfcService")
	private NtopsIntfcService ntopsService;

	@Override
	public RsrcReqDtlVmVo selectRsrcReqVmCre(String rsrcReqNo) throws Exception
	{
		RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
		searchVo.setRsrcReqNo(rsrcReqNo);
		return rsrcReqVmDao.selectRsrcReqVmCre(searchVo);
	}

	@Override
	public List<RsrcReqNetwkIntfcVo> selectRsrcReqNetwkIntfcList(String rsrcReqNo, String addHB) throws Exception
	{
		List<RsrcReqNetwkIntfcVo> list = null;
		list = rsrcReqVmDao.selectRsrcReqNetwkIntfcList(rsrcReqNo, addHB);
		return list;
	}

	@Override
	public List<RsrcReqDtlVmVo> selectClstrList(String rsrcPoolId) throws Exception
	{
		List<RsrcReqDtlVmVo> list = null;
		list = rsrcReqVmDao.selectClstrList(rsrcPoolId);
		return list;
	}

	@Override
	public void updateRsrcReqVmCreInfo(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception
	{

		List<RsrcReqNetwkIntfcVo> rsrcReqNetwkIntfcList = rsrcReqDtlVmVo.getRsrcReqNetwkIntfc();
		String flag = "";
		String ipAutoAsgnYn = "";
		Integer ipBndSeq = 0;
		String ipAddr = "";
		Integer pmSeq = 0;
		Integer swtchCnt = 0;

		// 템플릿 사용여부 확인
		flag = rsrcReqVmDao.selectTmplatVmCreYN(rsrcReqDtlVmVo);

		if ("Y".equals(flag))
		{
			throw new CommonException("해당 템플릿이 사용중입니다.");
		}

		flag = rsrcReqVmDao.selectVmIdUseYN(rsrcReqDtlVmVo);

		if ("Y".equals(flag))
		{
			throw new CommonException("입력하신 가상서버ID가 이미 사용중입니다.");
		}

		RrNetwkIntfcReqList rrNetwkIntfcReqList = new RrNetwkIntfcReqList();
		rrNetwkIntfcReqList.setRsrcReqNo(rsrcReqDtlVmVo.getRsrcReqNo());
		rrNetwkIntfcReqList.setRsrcReqSeq(rsrcReqDtlVmVo.getRsrcReqSeq());
		cRrNetwkIntfcReqListDao.deleteRrNetwkIntfcReqList(rrNetwkIntfcReqList); // 네트워크인터페이스정보 초기화(Delete)

		// IP 셋팅 시작
		IpVo ipVo = new IpVo();
		for (RsrcReqNetwkIntfcVo rsrcReqNetwkIntfcVo : rsrcReqNetwkIntfcList)
		{
			BeanUtils.copyProperties(rrNetwkIntfcReqList, rsrcReqNetwkIntfcVo);

			rrNetwkIntfcReqList.setRsrcReqNo(rsrcReqDtlVmVo.getRsrcReqNo());
			rrNetwkIntfcReqList.setRsrcReqSeq(rsrcReqDtlVmVo.getRsrcReqSeq());

			if ("01".equals(rsrcReqNetwkIntfcVo.getNicPrposCd()))
			{
				rrNetwkIntfcReqList.setNetwkIntfcNm("eth0");
			} else if ("02".equals(rsrcReqNetwkIntfcVo.getNicPrposCd()))
			{
				rrNetwkIntfcReqList.setNetwkIntfcNm("eth1");
			} else if ("03".equals(rsrcReqNetwkIntfcVo.getNicPrposCd()))
			{
				rrNetwkIntfcReqList.setNetwkIntfcNm("eth2");
			}

			// rrNetwkIntfcReqList.setNetwkIntfcNm(rsrcReqDtlVmVo.getVmId()+"_NIC_"+rsrcReqNetwkIntfcVo.getNicPrposCd());
			ipBndSeq = rsrcReqNetwkIntfcVo.getIpBndSeq();
			ipAddr = rsrcReqNetwkIntfcVo.getIpAddr();
			ipAutoAsgnYn = rsrcReqNetwkIntfcVo.getIpAutoAsgnYn();

			if ("Y".equals(ipAutoAsgnYn) && "".equals(ipAddr))
			{ // 자동할당 선택 시
				rsrcReqDtlVmVo.setNicPrposCd(rsrcReqNetwkIntfcVo.getNicPrposCd()); // NIC용도구분코드
				rsrcReqDtlVmVo.setNatYn(rsrcReqNetwkIntfcVo.getNatYn()); // NAT 여부
				ipVo = rsrcReqVmDao.selectAutoIp(rsrcReqDtlVmVo); // 미할당된 IP 정보를 조회
				if (ipVo != null)
				{
					rrNetwkIntfcReqList.setIpBndSeq(ipVo.getBndSeq());
					rrNetwkIntfcReqList.setIpAddr(ipVo.getIpAddr());

					rsrcReqNetwkIntfcVo.setIpBndSeq(ipVo.getBndSeq());
					rsrcReqNetwkIntfcVo.setIpAddr(ipVo.getIpAddr());
				} else
				{
					throw new DataNotFoundException("자동할당 대상 IP가 없습니다.(인터페이스명:" + rsrcReqNetwkIntfcVo.getNetwkIntfcId() + ")");
				}
			} else
			{ // 자동할당이 아닌경우
				if (rsrcReqNetwkIntfcVo.getIpAddr().isEmpty())
				{
					throw new DataNotFoundException("IP정보가 없습니다.(인터페이스명:" + rsrcReqNetwkIntfcVo.getNetwkIntfcId() + ")");
				} else
				{
					int ipCnt = 0;
					ipCnt = rsrcReqVmDao.selectIpStatCheck(rsrcReqNetwkIntfcVo); // IP가 미할당 상태인지 조회

					if (ipCnt == 0)
					{
						throw new DataNotFoundException("선택하신 IP가 사용중입니다. 미할당 상태의 IP를 다시 선택해 주세요.(인터페이스명:" + rsrcReqNetwkIntfcVo.getNetwkIntfcId() + ")");
					} else
					{
						rrNetwkIntfcReqList.setIpBndSeq(ipBndSeq);
						rrNetwkIntfcReqList.setIpAddr(ipAddr);

						ipVo.setBndSeq(ipBndSeq);
						ipVo.setIpAddr(ipAddr);
					}
				}
			}

			rsrcReqNetwkIntfcVo.setRsrcPoolId(rsrcReqDtlVmVo.getRsrcPoolId());
			swtchCnt = rsrcReqVmDao.selectVrSwtchNetwkId(rsrcReqNetwkIntfcVo);

			if (swtchCnt <= 0)
			{
				throw new DataNotFoundException("해당 IP에 대한 가상스위치 정보가 존재하지 않습니다.(IP:" + ipVo.getIpAddr() + ")");
			}

			ipVo.setUpdtUserId(rsrcReqDtlVmVo.getExeUserId());
			ipVo.setIpStatCd(OprConstant.IP_STAT_CD_01); // 할당
			cRnIpDao.updateIpList(ipVo); // 해당 IP정보를 할당으로 업데이트
			cRrNetwkIntfcReqListDao.insertRrNetwkIntfcReqList(rrNetwkIntfcReqList); // 네트워크인터페이스정보 Insert
		}

		// VMWare인 경우는 물리서버를 선택하지 않았을 경우 자동셋팅 로직이 필요함 (RHEV, IBM Power VM, HP 는 값이 없을경우 매니저에서 자동으로 셋팅함)
		if ("02".equals(rsrcReqDtlVmVo.getVrCnvrSwTyCd()) && rsrcReqDtlVmVo.getPmSeq() == null)
		{
			// 자동 물리서버ID 할당
			if (rsrcReqDtlVmVo.getPmSeq() == null)
			{
				pmSeq = rsrcReqVmDao.selectAutoPmSeq(rsrcReqDtlVmVo);

				if (pmSeq == null)
				{
					throw new NullPointerException();
				} else
				{
					rsrcReqDtlVmVo.setPmSeq(pmSeq);
				}
			}
		}

		// 가상서버 요청정보 업데이트
		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		BeanUtils.copyProperties(rrRsrcReq, rsrcReqDtlVmVo);
		rrRsrcReq.setRsrcReqPrcssStatCd(OprConstant.RSRC_STAT_CD_02);
		cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);

		int prcssInstSeq = executeProcess(rsrcReqDtlVmVo, OprConstant.VM_START_PROCESS_ID, "C"); // 프로세스 정보 생성

		// 가상서버 상세정보 업데이트
		RrRsrcReqDtlVm rrRsrcReqDtlVm = new RrRsrcReqDtlVm();
		BeanUtils.copyProperties(rrRsrcReqDtlVm, rsrcReqDtlVmVo);
		rrRsrcReqDtlVm.setRsrcReqPrcssStatCd(OprConstant.RSRC_STAT_CD_02);
		rrRsrcReqDtlVm.setProcssInstSeq(prcssInstSeq);
		cRrRsrcReqDtlVmDao.updateRrRsrcReqDtlVmCre(rrRsrcReqDtlVm);
	}

	@Override
	public void updateRsrcReqHaVmCreInfo(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception
	{

		List<RsrcReqNetwkIntfcVo> rsrcReqNetwkIntfcList = rsrcReqDtlVmVo.getRsrcReqNetwkIntfc();
		String flag = "";
		String ipAutoAsgnYn = "";
		Integer ipBndSeq = 0;
		String ipAddr = "";
		Integer swtchCnt = 0;

		if ("E".equals(rsrcReqDtlVmVo.getExeType()))
		{ // 실행 버튼 클릭 시
			// 템플릿 사용여부 확인
			flag = rsrcReqVmDao.selectTmplatVmCreYN(rsrcReqDtlVmVo);

			if ("Y".equals(flag))
			{
				throw new CommonException("해당 템플릿이 사용중입니다.");
			}

			// 프로세스 인스턴스 상태를 진행으로 변경
			RrProcssInst rrProcssInst = new RrProcssInst();
			rrProcssInst.setProcssInstSeq(rsrcReqDtlVmVo.getProcssInstSeq());
			rrProcssInst.setStatCd(OprConstant.PROCESS_STAT_CD_01);
			cRrProcssInstDao.updateRrProcssInstStat(rrProcssInst);

		} else if ("M".equals(rsrcReqDtlVmVo.getExeType()))
		{ // 수동 실행 버튼 클릭 시
			// 템플릿 사용여부 확인
			flag = rsrcReqVmDao.selectTmplatVmCreYN(rsrcReqDtlVmVo);

			if ("Y".equals(flag))
			{
				throw new CommonException("해당 템플릿이 사용중입니다.");
			}

			// 프로세스 인스턴스 상태를 진행으로 변경
			RrProcssInst rrProcssInst = new RrProcssInst();
			rrProcssInst.setProcssInstSeq(rsrcReqDtlVmVo.getProcssInstSeq());
			rrProcssInst.setStatCd(OprConstant.PROCESS_STAT_CD_01);
			cRrProcssInstDao.updateRrProcssInstStat(rrProcssInst);

		} else
		{

			flag = rsrcReqVmDao.selectVmIdUseYN(rsrcReqDtlVmVo);

			if ("Y".equals(flag))
			{
				throw new CommonException("입력하신 가상서버ID가 이미 사용중입니다.");
			}

			RrNetwkIntfcReqList rrNetwkIntfcReqList = new RrNetwkIntfcReqList();
			rrNetwkIntfcReqList.setRsrcReqNo(rsrcReqDtlVmVo.getRsrcReqNo());
			rrNetwkIntfcReqList.setRsrcReqSeq(rsrcReqDtlVmVo.getRsrcReqSeq());
			cRrNetwkIntfcReqListDao.deleteRrNetwkIntfcReqList(rrNetwkIntfcReqList); // 네트워크인터페이스정보 초기화(Delete)

			// IP 셋팅 시작
			IpVo ipVo = new IpVo();
			for (RsrcReqNetwkIntfcVo rsrcReqNetwkIntfcVo : rsrcReqNetwkIntfcList)
			{
				if (null != rsrcReqNetwkIntfcVo.getNetwkIntfcId())
				{
					BeanUtils.copyProperties(rrNetwkIntfcReqList, rsrcReqNetwkIntfcVo);

					rrNetwkIntfcReqList.setRsrcReqNo(rsrcReqDtlVmVo.getRsrcReqNo());
					rrNetwkIntfcReqList.setRsrcReqSeq(rsrcReqDtlVmVo.getRsrcReqSeq());

					if ("01".equals(rsrcReqNetwkIntfcVo.getNicPrposCd()))
					{
						rrNetwkIntfcReqList.setNetwkIntfcNm("eth0");
					} else if ("02".equals(rsrcReqNetwkIntfcVo.getNicPrposCd()))
					{
						rrNetwkIntfcReqList.setNetwkIntfcNm("eth1");
					} else if ("03".equals(rsrcReqNetwkIntfcVo.getNicPrposCd()))
					{
						rrNetwkIntfcReqList.setNetwkIntfcNm("eth2");
					} else
					{
						rrNetwkIntfcReqList.setNetwkIntfcNm("etc_eth");
					}

					// rrNetwkIntfcReqList.setNetwkIntfcNm(rsrcReqDtlVmVo.getVmId()+"_NIC_"+rsrcReqNetwkIntfcVo.getNicPrposCd());
					ipBndSeq = rsrcReqNetwkIntfcVo.getIpBndSeq();
					ipAddr = rsrcReqNetwkIntfcVo.getIpAddr();
					ipAutoAsgnYn = rsrcReqNetwkIntfcVo.getIpAutoAsgnYn();

					if ("Y".equals(ipAutoAsgnYn) && "".equals(ipAddr))
					{ // 자동할당 선택 시
						rsrcReqDtlVmVo.setNicPrposCd(rsrcReqNetwkIntfcVo.getNicPrposCd()); // NIC용도구분코드
						rsrcReqDtlVmVo.setNatYn(rsrcReqNetwkIntfcVo.getNatYn()); // NAT 여부
						ipVo = rsrcReqVmDao.selectAutoIp(rsrcReqDtlVmVo); // 미할당된 IP 정보를 조회
						if (ipVo != null)
						{
							rrNetwkIntfcReqList.setIpBndSeq(ipVo.getBndSeq());
							rrNetwkIntfcReqList.setIpAddr(ipVo.getIpAddr());

							rsrcReqNetwkIntfcVo.setIpBndSeq(ipVo.getBndSeq());
							rsrcReqNetwkIntfcVo.setIpAddr(ipVo.getIpAddr());

						} else
						{
							throw new DataNotFoundException("자동할당 대상 IP가 없습니다.(인터페이스명:" + rsrcReqNetwkIntfcVo.getNetwkIntfcId() + ")");
						}
					} else
					{ // 자동할당이 아닌경우
						if (StringUtils.isEmpty(ipAddr))
						{
							throw new DataNotFoundException("IP정보가 없습니다.(인터페이스명:" + rsrcReqNetwkIntfcVo.getNetwkIntfcId() + ")");
						} else
						{
							int ipCnt = 0;
							ipCnt = rsrcReqVmDao.selectIpStatCheck(rsrcReqNetwkIntfcVo); // IP가 미할당 상태인지 조회

							if (ipCnt == 0)
							{
								throw new DataNotFoundException("선택하신 IP가 사용중입니다. 미할당 상태의 IP를 다시 선택해 주세요.(인터페이스명:" + rsrcReqNetwkIntfcVo.getNetwkIntfcId() + ")");
							} else
							{
								rrNetwkIntfcReqList.setIpBndSeq(ipBndSeq);
								rrNetwkIntfcReqList.setIpAddr(ipAddr);

								ipVo.setBndSeq(ipBndSeq);
								ipVo.setIpAddr(ipAddr);
							}
						}
					}

					rsrcReqNetwkIntfcVo.setRsrcPoolId(rsrcReqDtlVmVo.getRsrcPoolId());

					swtchCnt = rsrcReqVmDao.selectVrSwtchNetwkId(rsrcReqNetwkIntfcVo);

					if (swtchCnt <= 0)
					{
						throw new DataNotFoundException("해당 IP에 대한 가상스위치 정보가 존재하지 않습니다.(IP:" + ipVo.getIpAddr() + ")");
					}

					ipVo.setUpdtUserId(rsrcReqDtlVmVo.getExeUserId());
					ipVo.setIpStatCd(OprConstant.IP_STAT_CD_01); // 할당

					cRnIpDao.updateIpList(ipVo); // 해당 IP정보를 할당으로 업데이트
					cRrNetwkIntfcReqListDao.insertRrNetwkIntfcReqList(rrNetwkIntfcReqList); // 네트워크인터페이스정보 Insert
				}
			}

			// 자동 물리서버ID 할당
			Integer pmSeq = null;
			if (rsrcReqDtlVmVo.getPmSeq() == null)
			{
				pmSeq = rsrcReqVmDao.selectAutoPmSeq(rsrcReqDtlVmVo);

				if (pmSeq == null)
				{
					throw new NullPointerException();
				} else
				{
					rsrcReqDtlVmVo.setPmSeq(pmSeq);
				}
			}

			// 가상서버 요청정보 업데이트
			RrRsrcReq rrRsrcReq = new RrRsrcReq();
			BeanUtils.copyProperties(rrRsrcReq, rsrcReqDtlVmVo);
			rrRsrcReq.setRsrcReqPrcssStatCd(OprConstant.RSRC_STAT_CD_02);
			cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);

			int prcssInstSeq = executeProcess(rsrcReqDtlVmVo, OprConstant.VM_START_PROCESS_ID, "C"); // 프로세스 정보 생성

			// 가상서버 상세정보 업데이트
			RrRsrcReqDtlVm rrRsrcReqDtlVm = new RrRsrcReqDtlVm();
			BeanUtils.copyProperties(rrRsrcReqDtlVm, rsrcReqDtlVmVo);
			rrRsrcReqDtlVm.setRsrcReqPrcssStatCd(OprConstant.RSRC_STAT_CD_02);
			rrRsrcReqDtlVm.setProcssInstSeq(prcssInstSeq);
			rrRsrcReqDtlVm.setExeStatCd(OprConstant.RSRC_EXE_STAT_CD_02); // 설정상태코드
			cRrRsrcReqDtlVmDao.updateRrRsrcReqDtlVmCre(rrRsrcReqDtlVm);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see ncis.cpt.opr.req.rsrcreq.service.RsrcReqVmService#updateRsrcReqHaVmCreInfoForManaul(ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo)
	 */
	@Override
	public void updateRsrcReqHaVmCreInfoForManaul(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception
	{
		// 수동 생성된 가상서버가 존재하는지 확인 한다.
		VmVo preMakedVm = rsrcRcVmDao.selectPreMakedVmInfo(rsrcReqDtlVmVo);

		// 가상서버가 생성되지 않은 경우....
		if (null == preMakedVm)
		{
			throw new CommonException("수동완료 요청하신 가상서버가 존재하지 않습니다.");
		}

		List<RsrcReqNetwkIntfcVo> rsrcReqNetwkIntfcList = selectRsrcReqNetwkIntfcList(rsrcReqDtlVmVo.getRsrcReqNo(), "Y");

		if (rsrcReqNetwkIntfcList != null)
		{
			IpVo ipVo = null;
			for (RsrcReqNetwkIntfcVo rsrcReqNetwkIntfcVo : rsrcReqNetwkIntfcList)
			{
				if ("Y".equals(rsrcReqNetwkIntfcVo.getIpAutoAsgnYn()) && "".equals(rsrcReqNetwkIntfcVo.getIpAddr()))
				{ // 자동할당 선택 시
					ipVo = rsrcReqVmDao.selectAutoIp(rsrcReqDtlVmVo); // 미할당된 IP 정보를 조회
					if (ipVo != null)
					{
						rsrcReqNetwkIntfcVo.setIpBndSeq(ipVo.getBndSeq());
						rsrcReqNetwkIntfcVo.setIpAddr(ipVo.getIpAddr());
					} else
					{
						throw new DataNotFoundException("자동할당 대상 IP가 없습니다.(인터페이스명:" + rsrcReqNetwkIntfcVo.getNetwkIntfcId() + ")");
					}

					try
					{
						cRrNetwkIntfcReqListDao.updateRrNetwkIntfcReqIp(rsrcReqNetwkIntfcVo); // 네트워크인터페이스정보 update
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}

			}
		}

		// 기 생성된 가상서버 정보를 업데이트 한다.
		if (null == preMakedVm.getHstNm())
		{
			preMakedVm.setHstNm(rsrcReqDtlVmVo.getHstNm());
		}

		// 기 생성된 가상서버 정보를 업데이트 한다.
		if (null == preMakedVm.getTmplatSeq())
		{
			preMakedVm.setTmplatSeq(new BigDecimal(rsrcReqDtlVmVo.getTmplatSeq()));
		}

		preMakedVm.setVmCompId(rsrcReqDtlVmVo.getVmCompId());
		preMakedVm.setHaGrpId(rsrcReqDtlVmVo.getHaGrpId());
		if (null == rsrcReqDtlVmVo.getHaGrpId())
		{
			preMakedVm.setHaYn("N");
		} else
		{
			preMakedVm.setHaYn("Y");
		}
		preMakedVm.setInstitutionId(rsrcReqDtlVmVo.getReqInstitutionId());

		rsrcRcVmDao.updateManualCreRcVm(preMakedVm);

		Boolean resultBool = ntopsService.sendVmCreateNTopsResult(rsrcReqDtlVmVo.getRsrcReqNo());
		logger.info("sendVmCreateNTopsResult["+rsrcReqDtlVmVo.getRsrcReqNo()+"]=" + resultBool );

		// 가상서버와 업무 매핑정보를 설정한다.
		rsrcRcVmDao.insertRcVmJob(preMakedVm.getVmSeq(), rsrcReqDtlVmVo.getUseJobId());

		// 가상서버 요청 상세정보 업데이트
		RrRsrcReqDtlVm rrRsrcReqDtlVm = new RrRsrcReqDtlVm();
		BeanUtils.copyProperties(rrRsrcReqDtlVm, rsrcReqDtlVmVo);
		rrRsrcReqDtlVm.setVmSeq(preMakedVm.getVmSeq());
		rrRsrcReqDtlVm.setUuid(preMakedVm.getUuid());
		rrRsrcReqDtlVm.setExeStatCd(OprConstant.PROCESS_STAT_CD_03);
		rrRsrcReqDtlVm.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_MANUAL_CMPLT);
		cRrRsrcReqDtlVmDao.updateRrRsrcReqDtlVmCre(rrRsrcReqDtlVm);

		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		BeanUtils.copyProperties(rrRsrcReq, rsrcReqDtlVmVo);
		rrRsrcReq.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_MANUAL_CMPLT);
		cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);

	}

	@Override
	public RsrcReqDtlVmVo selectRsrcReqVmSpecChng(String rsrcReqNo) throws Exception
	{
		RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
		searchVo.setRsrcReqNo(rsrcReqNo);
		return rsrcReqVmDao.selectRsrcReqVmSpecChng(searchVo);
	}

	@Override
	public RsrcReqDtlVmVo selectRsrcReqVmDel(String rsrcReqNo) throws Exception
	{
		RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
		searchVo.setRsrcReqNo(rsrcReqNo);
		return rsrcReqVmDao.selectRsrcReqVmDel(searchVo);
	}

	@Override
	public void updateRsrcReqSpecChngInfo(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception
	{

		int processId = 0;
		if ("01".equals(rsrcReqDtlVmVo.getVmChngClCd()))
		{
			processId = OprConstant.VM_SPECCHNG_PROCESS_ID;
		} else if ("02".equals(rsrcReqDtlVmVo.getVmChngClCd()))
		{
			processId = OprConstant.VM_STRGADD_PROCESS_ID;
		} else if ("03".equals(rsrcReqDtlVmVo.getVmChngClCd()))
		{
			processId = OprConstant.VM_DEL_PROCESS_ID;
		}

		int prcssInstSeq = executeProcess(rsrcReqDtlVmVo, processId, "S"); // 프로세스 정보 생성

		RrRsrcReqDtlVm rrRsrcReqDtlVm = new RrRsrcReqDtlVm();
		BeanUtils.copyProperties(rrRsrcReqDtlVm, rsrcReqDtlVmVo);
		rrRsrcReqDtlVm.setProcssInstSeq(prcssInstSeq);
		rrRsrcReqDtlVm.setRsrcReqPrcssStatCd(OprConstant.RSRC_STAT_CD_02);
		cRrRsrcReqDtlVmDao.updateRrRsrcReqDtlVmSpecChng(rrRsrcReqDtlVm);

		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		BeanUtils.copyProperties(rrRsrcReq, rsrcReqDtlVmVo);
		rrRsrcReq.setRsrcReqPrcssStatCd(OprConstant.RSRC_STAT_CD_02);
		cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);
	}

	/**
	 * 가상서버 실행 처리
	 *
	 * @param rsrcReqDtlVmVo
	 * @param processSeq
	 * @param type
	 * @return
	 */
	private int executeProcess(RsrcReqDtlVmVo rsrcReqDtlVmVo, int processSeq, String type)
	{
		int procssInstSeq = 0;
		String processStatCd = "";

		if ("Y".equals(rsrcReqDtlVmVo.getHaYn()) && "C".equals(type))
		{
			processStatCd = OprConstant.PROCESS_STAT_CD_03;
		} else
		{
			processStatCd = OprConstant.PROCESS_STAT_CD_01;
		}

		if (!"E".equals(rsrcReqDtlVmVo.getExeType()))
		{

			// 프로세스 인스턴스정보 추가
			RrProcssInst rrProcssInst = new RrProcssInst();
			rrProcssInst.setRsrcReqNo(rsrcReqDtlVmVo.getRsrcReqNo());
			rrProcssInst.setProcssSeq(processSeq);
			rrProcssInst.setStatCd(processStatCd);
			cRrProcssInstDao.insertRrProcssInst(rrProcssInst);

			procssInstSeq = rrProcssInst.getProcssInstSeq();

			// 프로세스 업무목록정보 추가
			RrProcssJobList rrProcssJobList = new RrProcssJobList();
			rrProcssJobList.setProcssInstSeq(procssInstSeq);
			rrProcssJobList.setRegUserId(rsrcReqDtlVmVo.getExeUserId());
			rrProcssJobList.setStatCd(OprConstant.PROCESS_STAT_CD_01);
			rrProcssJobList.setProcssSeq(processSeq);
			cRrProcssJobListDao.insertRrProcssJobList(rrProcssJobList);

			// 프로세스 변수목록 추가
			RrProcssVarList rrProcssVarList = new RrProcssVarList();
			rrProcssVarList.setProcssInstSeq(procssInstSeq);
			rrProcssVarList.setProcssSeq(processSeq);
			cRrProcssVarListDao.insertRrProcssVarList(rrProcssVarList);

			if ("C".equals(type))
			{ // 가상서버 생성일 경우
				// VM생성 프로세스일 경우 스토리지 도메인 단위업무 수행여부판단을 위한 프로세스 변수값 셋팅 (RHEV인 경우만)
				rrProcssVarList.setVarNm(OprConstant.RSRC_REQ_STRG_MOVE_VAL_NM);
				if (!"".equals(rsrcReqDtlVmVo.getReqStrgDmnSeq()) && rsrcReqDtlVmVo.getReqStrgDmnSeq() != null && "01".equals(rsrcReqDtlVmVo.getVrCnvrSwTyCd()))
				{

					// TODO 이동요청한 스토리지도메인과 템플릿이 위치한 가상스토리지도메인이 같으면 스토리지도메인 이동을 수행하지 않도록 설정한다.
					if ("Y".equals(rsrcReqVmDao.isEqualStrgDmnSeq(rsrcReqDtlVmVo)))
					{
						rrProcssVarList.setVarVl("N");
					}
					else
					{
						rrProcssVarList.setVarVl("Y");
					}

				}else if("03".equals(rsrcReqDtlVmVo.getVrCnvrSwTyCd()) 
					   ||"04".equals(rsrcReqDtlVmVo.getVrCnvrSwTyCd()) 
					   ||"08".equals(rsrcReqDtlVmVo.getVrCnvrSwTyCd())) { //HP Integrity VM, IBM Power VM 인경우는 가상서버 생성요청 단계에서 네트워크 인터페이스를 생성시킴.
					rrProcssVarList.setVarVl("NS"); //네트워크인터페이스 생성 단계 SKIP처리
				}else if("05".equals(rsrcReqDtlVmVo.getVrCnvrSwTyCd())) {  //Openstack 인 경우는 가상서버 생성요청 단계에서 HA가상볼륨생성요청 단계로 이동.					
					// 2017.07.31 [openstack]
					if("Y".equals(rsrcReqDtlVmVo.getHaYn())) {
						rrProcssVarList.setVarVl("OS");
					}else {
						rrProcssVarList.setVarVl("NS");
					}					
				}else {
					rrProcssVarList.setVarVl("N");
				}

				cRrProcssVarListDao.updateRrProcssVarVl(rrProcssVarList);

				if ("Y".equals(rsrcReqDtlVmVo.getHaYn()))
				{
					rrProcssVarList.setVarNm(OprConstant.RSRC_REQ_HA_VAL_NM);
					rrProcssVarList.setVarVl("Y");
					cRrProcssVarListDao.updateRrProcssVarVl(rrProcssVarList);
				}

			} else if ("S".equals(type) && "Y".equals(rsrcReqDtlVmVo.getVmStopYn()))
			{ // 가상서버 스펙변경이고, 가상서버중지여부가 Y일경우
				rrProcssVarList.setVarNm(OprConstant.RSRC_REQ_VM_STOP_VAL_NM);
				rrProcssVarList.setVarVl(rsrcReqDtlVmVo.getVmStopYn());
				cRrProcssVarListDao.updateRrProcssVarVl(rrProcssVarList);

				// HP인경우 볼륨생성단계를 skip하기위한 프로세스 변수값을 셋팅
				if ("03".equals(rsrcReqDtlVmVo.getVrCnvrSwTyCd()))
				{
					rrProcssVarList.setVarNm(OprConstant.RSRC_REQ_VOLUME_CREATE_VAL_NM);
					rrProcssVarList.setVarVl("N");
					cRrProcssVarListDao.updateRrProcssVarVl(rrProcssVarList);
				}
			} else if ("S".equals(type) && "02".equals(rsrcReqDtlVmVo.getVmChngClCd()))
			{
				// HP인경우 볼륨생성단계를 skip하기위한 프로세스 변수값을 셋팅
				if ("03".equals(rsrcReqDtlVmVo.getVrCnvrSwTyCd()))
				{
					rrProcssVarList.setVarNm(OprConstant.RSRC_REQ_VOLUME_CREATE_VAL_NM);
					rrProcssVarList.setVarVl("N");
					cRrProcssVarListDao.updateRrProcssVarVl(rrProcssVarList);
				}
			}

		} else
		{
			// 프로세스 인스턴스 상태를 진행으로 변경
			RrProcssInst rrProcssInst = new RrProcssInst();
			rrProcssInst.setProcssInstSeq(rsrcReqDtlVmVo.getProcssInstSeq());
			rrProcssInst.setStatCd(OprConstant.PROCESS_STAT_CD_01);
			cRrProcssInstDao.updateRrProcssInstStat(rrProcssInst);
		}

		return procssInstSeq;
	}

	/**
	 * IP 대역 목록 조회
	 */
	@Override
	public List<IpBndVo> selectIpBndList(IpBndSearchVo serarchVo)
	{
		return rsrcReqVmDao.selectIpBndList(serarchVo);
	}

	/**
	 * IP조회
	 */
	@Override
	public List<IpVo> selectUnasgnIpList(IpSearchVo serarchVo)
	{
		serarchVo.setIpStatCd(OprConstant.IP_STAT_CD_02);
		return rsrcReqVmDao.selectIpList(serarchVo);
	}

	/**
	 * 스토리지도메인 목록 조회
	 */
	@Override
	public List<RsrcPoolVrStrgVo> selectStrgDmnList(String rsrcPoolId)
	{
		return rsrcReqVmDao.selectStrgDmnList(rsrcPoolId);
	}

	/**
	 * 가상서버 팝업 - 가상스토리지 조회
	 */
	@Override
	public List<VrStrgVo> selectVrStrgList(VrStrgSearchVo searchVo)
	{
		return rsrcReqVmDao.selectVrStrgList(searchVo);
	}

	/**
	 * 가상서버 반려 처리
	 */
	@Override
	public void updateRsrcReqVmRjct(RsrcReqDtlVmVo rsrcReqDtlVmVo, String exeUserId) throws Exception
	{
		RrRsrcReqDtlVm vo = new RrRsrcReqDtlVm();
		vo.setRsrcReqNo(rsrcReqDtlVmVo.getRsrcReqNo());
		vo.setRsrcReqSeq(rsrcReqDtlVmVo.getRsrcReqSeq());
		vo.setRsrcReqTyCd(rsrcReqDtlVmVo.getRsrcReqTyCd());
		vo.setRsrcReqPrcssStatCd(rsrcReqDtlVmVo.getRsrcReqPrcssStatCd());
		vo.setRjctTyCd(rsrcReqDtlVmVo.getRjctTyCd());
		vo.setRjctReasn(rsrcReqDtlVmVo.getRjctReasn());
		cRrRsrcReqDtlVmDao.updateRrRsrcReqDtlVmSpecChng(vo);

		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		rrRsrcReq.setRsrcReqNo(rsrcReqDtlVmVo.getRsrcReqNo());
		rrRsrcReq.setExeUserId(exeUserId);
		rrRsrcReq.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_RJCT);
		cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);
	}

	/**
	 * 가상서버 실행취소 처리
	 */
	@Override
	public void updateRsrcReqCancelExecInfo(String regionId, String zoneId, String netClCd, String poolId, String uuid) throws Exception
	{
		try
		{
			if (uuid == null || uuid.equals(""))
				throw new Exception("uuid가 존재하지 않습니다.");

			RestHeaders headers = new RestHeaders();
			headers.setAreaId(regionId);
			headers.setZoneId(zoneId);
			headers.setNetworkId(netClCd);
			headers.setManagerId(poolId);
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));

			String msg = "\r\n";
			msg += "getSeq = " + headers.getSeq() + "\r\n";
			msg += "getAreaId =" + headers.getAreaId() + "\r\n";
			msg += "getZoneId =" + headers.getZoneId() + "\r\n";
			msg += "getNetworkId =" + headers.getNetworkId() + "\r\n";
			msg += "getManagerId =" + headers.getManagerId() + "\r\n";
			msg += "uuid = " + uuid + "\r\n";
			logger.debug(msg);

			vmIntfcService.delete(uuid, headers);
		} catch (HttpServerErrorException e)
		{
			logger.error("HttpServerErrorException=" + e.getResponseBodyAsString());
			throw e;
		} catch (HttpStatusCodeException e)
		{
			logger.error("HttpStatusCodeException=" + e.getResponseBodyAsString());
			throw e;
		} catch (Exception e)
		{
			logger.error("Exception=" + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<RsrcReqDtlVmVo> selectHaCompList(String rsrcReqNo) throws Exception
	{
		List<RsrcReqDtlVmVo> list = null;
		list = rsrcReqVmDao.selectHaCompList(rsrcReqNo);
		return list;
	}

	@Override
	public List<RsrcReqDtlVmVo> selectVmHaCompList(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception
	{
		List<RsrcReqDtlVmVo> list = null;
		list = rsrcReqVmDao.selectVmHaCompList(rsrcReqDtlVmVo);
		return list;
	}

	@Override
	public RsrcReqDtlVmVo selectRsrcReqVmCreBaseInfo(String rsrcReqNo) throws Exception
	{
		RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
		searchVo.setRsrcReqNo(rsrcReqNo);
		return rsrcReqVmDao.selectRsrcReqVmCreBaseInfo(searchVo);
	}

	/**
	 * 가상서버 설정취소 처리
	 */
	@Override
	public void updateRsrcReqHaVmInfoInit(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception
	{

		List<RsrcReqDtlVmVo> haVo = rsrcReqVmDao.selectHaCompList(rsrcReqDtlVmVo.getRsrcReqNo()); // HA정보 조회

		for (RsrcReqDtlVmVo fVo : haVo)
		{

			// 자원요청 상태변경
			RrRsrcReq rrRsrcReq = new RrRsrcReq();
			rrRsrcReq.setRsrcReqNo(fVo.getRsrcReqNo());
			rrRsrcReq.setRsrcReqPrcssStatCd(OprConstant.RSRC_STAT_CD_01);
			cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);

			// 자원요청상세 정보 초기화
			RrRsrcReqDtlVm vo = new RrRsrcReqDtlVm();
			vo.setRsrcReqNo(fVo.getRsrcReqNo());
			vo.setExeStatCd("01");
			vo.setRsrcReqPrcssStatCd("01");
			cRrRsrcReqDtlVmDao.updateRrRsrcReqDtlVmHaInit(vo); // HA건 설정정보 초기화

			// 자원요청 네트워크 인터페이스 할당된 IP를 미할당으로 변경
			List<RsrcReqNetwkIntfcVo> rsrcReqNetwkIntfcList = null; // 할당된 IP를 미할당으로 변경
			rsrcReqNetwkIntfcList = rsrcReqVmDao.selectCancelReqNetwkIntfcList(fVo.getRsrcReqNo());
			IpVo ipVo = new IpVo();

			for (RsrcReqNetwkIntfcVo rsrcReqNetwkIntfcVo : rsrcReqNetwkIntfcList)
			{
				ipVo.setUpdtUserId(rsrcReqDtlVmVo.getExeUserId());
				ipVo.setIpStatCd(OprConstant.IP_STAT_CD_02); // 미할당
				ipVo.setBndSeq(rsrcReqNetwkIntfcVo.getIpBndSeq());
				ipVo.setIpAddr(rsrcReqNetwkIntfcVo.getIpAddr());
				cRnIpDao.updateIpList(ipVo); // 해당 IP정보를 미할당으로 업데이트
			}

			// 자원요청 네트워크 인터페이스 정보 초기화
			RrNetwkIntfcReqList rrNetwkIntfcReqList = new RrNetwkIntfcReqList();
			rrNetwkIntfcReqList.setRsrcReqNo(rsrcReqDtlVmVo.getRsrcReqNo());
			cRrNetwkIntfcReqListDao.deleteRrNetwkIntfcReqList(rrNetwkIntfcReqList); // 네트워크인터페이스정보 초기화(Delete)

			// 프로세스 인스턴스 삭제
			RrProcssInst rrProcssInst = new RrProcssInst();
			rrProcssInst.setProcssInstSeq(fVo.getProcssInstSeq());
			cRrProcssInstDao.deleteRrProcssInst(rrProcssInst);

			// 프로세스 업무목록 삭제
			RrProcssJobList rrProcssJobList = new RrProcssJobList();
			rrProcssJobList.setProcssInstSeq(fVo.getProcssInstSeq());
			cRrProcssJobListDao.deleteRrProcssJobListAll(rrProcssJobList);

			// 프로세스 변수삭제
			RrProcssVarList rrProcssVarList = new RrProcssVarList();
			rrProcssVarList.setProcssInstSeq(fVo.getProcssInstSeq());
			cRrProcssVarListDao.deleteRrProcssVarListAll(rrProcssVarList);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see ncis.cpt.opr.req.rsrcreq.service.RsrcReqVmService#updateRsrcReqVmCreInfoForManaul(ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo)
	 */
	@Override
	public void updateRsrcReqVmCreInfoForManaul(RsrcReqDtlVmVo rsrcReqDtlVmVo) throws Exception
	{
		// 수동 생성된 가상서버가 존재하는지 확인 한다.
		VmVo preMakedVm = rsrcRcVmDao.selectPreMakedVmInfo(rsrcReqDtlVmVo);

		// 가상서버가 생성되지 않은 경우....
		if (null == preMakedVm)
		{
			if(!"Y".equals(rsrcReqDtlVmVo.getHaYn()) )
			{
				// 가상서버 할당용 NetworkInterface 정보를 release 한다.
				List<RsrcReqNetwkIntfcVo> rsrcReqNetwkIntfcList = rsrcReqDtlVmVo.getRsrcReqNetwkIntfc();
				RnIp ipInfo = null;
				for (RsrcReqNetwkIntfcVo rsrcReqNetwkIntfcVo : rsrcReqNetwkIntfcList)
				{
					ipInfo = new RnIp();
					ipInfo.setIpAddr(rsrcReqNetwkIntfcVo.getIpAddr());
					ipInfo.setBndSeq(rsrcReqNetwkIntfcVo.getIpBndSeq());
					ipInfo.setUpdtUserId(ProcessConstant.getBatchRegUserId());

					ipInfo.setRmk(rsrcReqDtlVmVo.getTicktNo() + "(" + rsrcReqDtlVmVo.getRsrcReqNo() + "/" + rsrcReqDtlVmVo.getVmCompId() + ")"); // rmk 정보 상단에 티켓정보를 앞부분에 추가한다. 2018.02.19

					rsrcRcVmDao.updateReleaseRnIp(ipInfo); // 가상서버에서 사용한 IP 정보 미할당으로 처리
				}
			}
			throw new CommonException("수동완료 요청하신 가상서버가 존재하지 않습니다.");
		}

		RrNetwkIntfcReqList rrNetwkIntfcReqList = new RrNetwkIntfcReqList();
		rrNetwkIntfcReqList.setRsrcReqNo(rsrcReqDtlVmVo.getRsrcReqNo());
		rrNetwkIntfcReqList.setRsrcReqSeq(rsrcReqDtlVmVo.getRsrcReqSeq());
		cRrNetwkIntfcReqListDao.deleteRrNetwkIntfcReqList(rrNetwkIntfcReqList); // 네트워크인터페이스정보 초기화(Delete)

		List<RsrcReqNetwkIntfcVo> rsrcReqNetwkIntfcList = rsrcReqDtlVmVo.getRsrcReqNetwkIntfc();

		if (rsrcReqNetwkIntfcList != null)
		{
			for (RsrcReqNetwkIntfcVo rsrcReqNetwkIntfcVo : rsrcReqNetwkIntfcList)
			{
				BeanUtils.copyProperties(rrNetwkIntfcReqList, rsrcReqNetwkIntfcVo);

				// 서비스
				if ("01".equals(rsrcReqNetwkIntfcVo.getNicPrposCd()))
				{
					rrNetwkIntfcReqList.setNetwkIntfcNm("eth0");
					preMakedVm.setRprsntIpAddr(rsrcReqNetwkIntfcVo.getIpAddr()); // 대표 IP(서비스 IP) 설정
				} else if ("02".equals(rsrcReqNetwkIntfcVo.getNicPrposCd()))
				{
					rrNetwkIntfcReqList.setNetwkIntfcNm("eth1");
				} else if ("03".equals(rsrcReqNetwkIntfcVo.getNicPrposCd()))
				{
					rrNetwkIntfcReqList.setNetwkIntfcNm("eth2");
				}

				rrNetwkIntfcReqList.setRsrcReqNo(rsrcReqDtlVmVo.getRsrcReqNo());
				rrNetwkIntfcReqList.setRsrcReqSeq(rsrcReqDtlVmVo.getRsrcReqSeq());

				rrNetwkIntfcReqList.setIpBndSeq(rsrcReqNetwkIntfcVo.getIpBndSeq());
				rrNetwkIntfcReqList.setIpAddr(rsrcReqNetwkIntfcVo.getIpAddr());

				try
				{
					cRrNetwkIntfcReqListDao.insertRrNetwkIntfcReqList(rrNetwkIntfcReqList); // 네트워크인터페이스정보 Insert
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		// 기 생성된 가상서버 정보를 업데이트 한다.
		if (null == preMakedVm.getHstNm())
		{
			preMakedVm.setHstNm(rsrcReqDtlVmVo.getHstNm());
		}

		// 기 생성된 가상서버 정보를 업데이트 한다.
		if (null == preMakedVm.getTmplatSeq())
		{
			preMakedVm.setTmplatSeq(new BigDecimal(rsrcReqDtlVmVo.getTmplatSeq()));
		}

		preMakedVm.setVmCompId(rsrcReqDtlVmVo.getVmCompId());
		preMakedVm.setHaGrpId(rsrcReqDtlVmVo.getHaGrpId());
		if (null == rsrcReqDtlVmVo.getHaGrpId())
		{
			preMakedVm.setHaYn("N");
		} else
		{
			preMakedVm.setHaYn("Y");
		}
		preMakedVm.setInstitutionId(rsrcReqDtlVmVo.getReqInstitutionId());

		rsrcRcVmDao.updateManualCreRcVm(preMakedVm);

		// 가상서버와 업무 매핑정보를 설정한다.
		rsrcRcVmDao.insertRcVmJob(preMakedVm.getVmSeq(), rsrcReqDtlVmVo.getUseJobId());

		Boolean resultBool = ntopsService.sendVmCreateNTopsResult(rsrcReqDtlVmVo.getRsrcReqNo());

		logger.info("sendVmCreateNTopsResult["+rsrcReqDtlVmVo.getRsrcReqNo()+"]=" + resultBool );

		// 가상서버 요청 상세정보 업데이트
		RrRsrcReqDtlVm rrRsrcReqDtlVm = new RrRsrcReqDtlVm();
		BeanUtils.copyProperties(rrRsrcReqDtlVm, rsrcReqDtlVmVo);
		rrRsrcReqDtlVm.setVmSeq(preMakedVm.getVmSeq());
		rrRsrcReqDtlVm.setUuid(preMakedVm.getUuid());
		rrRsrcReqDtlVm.setExeStatCd(OprConstant.PROCESS_STAT_CD_03);
		rrRsrcReqDtlVm.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_MANUAL_CMPLT);
		cRrRsrcReqDtlVmDao.updateRrRsrcReqDtlVmCre(rrRsrcReqDtlVm);

		// 가상서버 요청정보 업데이트
		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		BeanUtils.copyProperties(rrRsrcReq, rsrcReqDtlVmVo);
		rrRsrcReq.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_MANUAL_CMPLT);
		cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);
	}

	@Override
	public void updateRsrcReqSpecChngInfoForManaul(RsrcReqDtlVmVo dtlVmVo) throws Exception
	{
		// 수동 생성된 가상서버가 존재하는지 확인 한다.
		BigDecimal vmSeq = dtlVmVo.getVmSeq();

		VmVo vm = rsrcRcVmDao.selectVmInfoByVmSeq(vmSeq);
		if (null == vm)
		{
			throw new CommonException("수동완료 요청하신 가상서버가 존재하지 않습니다.");
		}
		Boolean resultBool = false;
		// 스펙변경
		if ("01".equals(dtlVmVo.getVmChngClCd()))
		{
			vm.setCpuVcoreQty(Integer.valueOf(dtlVmVo.getChngReqCpuVcoreQty()));
			vm.setMemAsgnCapa(Integer.valueOf(dtlVmVo.getChngReqMemAsgnCapa()));

			rsrcRcVmDao.updateManualChgRcVm(vm);
			resultBool = ntopsService.sendVmSpecChangeNTopsResult(dtlVmVo.getRsrcReqNo());
			logger.info("sendVmSpecChangeNTopsResult["+dtlVmVo.getRsrcReqNo()+"]=" + resultBool );
		}
		// 스토리지 추가
		else if ("02".equals(dtlVmVo.getVmChngClCd()))
		{
			int total = Integer.valueOf(dtlVmVo.getChngPreStrgAsgnCapa()) + Integer.valueOf(dtlVmVo.getChngReqStrgAsgnCapa());
			vm.setStrgAsgnCapa(total);

			rsrcRcVmDao.updateManualChgRcVm(vm);
			resultBool = ntopsService.sendVmStorageAddNTopsResult(dtlVmVo.getRsrcReqNo());
			logger.info("sendVmStorageAddNTopsResult["+dtlVmVo.getRsrcReqNo()+"]=" + resultBool );
		}
		// 가상서버 반납
		else if ("03".equals(dtlVmVo.getVmChngClCd()))
		{
			// IP 할당 정보 반납
			// 가상서버 네트워크인터페이스 정보를 삭제처리한다.
			List<RcNetwkIntfc> rcNicList = rsrcRcVmDao.selectVmRcNetwkIntfc(vmSeq); // 가상서버의 네트워크인터페이스 데이터 삭제를 위한 정보를 조회

			if (null != rcNicList && rcNicList.size() > 0)
			{ // 존재하는 네트워크 인터페이스를 삭제한다.
				RnIp ipInfo = null;
				for (RcNetwkIntfc nicInfo : rcNicList)
				{

					ipInfo = new RnIp();
					ipInfo.setIpAddr(nicInfo.getIpAddr());
					ipInfo.setNetwkIntfcSeq(nicInfo.getNetwkIntfcSeq());
					ipInfo.setUpdtUserId(ProcessConstant.getBatchRegUserId());
					ipInfo.setRmk(dtlVmVo.getTicktNo() + "(" + dtlVmVo.getRsrcReqNo() + "/" + vm.getVmCompId() + ")"); // rmk 정보 상단에 티켓정보를 앞부분에 추가한다. 2018.02.19

					nicInfo.setDelUserId(ProcessConstant.getBatchRegUserId());

					rsrcRcVmDao.updateDeleteNetwkIntfc(nicInfo); // 가상서버에서 사용한 네트워크인터페이스 정보 삭제
					rsrcRcVmDao.updateReleaseRnIp(ipInfo); // 가상서버에서 사용한 IP 정보 미할당으로 처리
				}
			}

			// Disk 정보 반납
			List<VrDskVo> diskList = rsrcRcVmDao.selectAsgnDiskList(vmSeq);
			if ("Y".equals(dtlVmVo.getHaYn()))
			{
				int haCnt = rsrcRcVmDao.selectHaCnt(vmSeq);
				// 이중화 가상서버가 존재하지 않으면 모든 디스크를 삭제하고, 가상서버가 존재하면 OS 디스크만 삭제한다.
				if (haCnt == 0)
				{
					for (VrDskVo disk : diskList)
					{
						disk.setDelUserId(ProcessConstant.getBatchRegUserId());
						rsrcRcVmDao.updateManualRemoveVrDisk(disk); // 가상디스크정보 삭제
						rsrcRcVmDao.updateManualRemoveStrgAsgn(disk); // 가상서버스토리지할당정보 삭제
						rsrcRcVmDao.updateManualRemoveStrgDm(disk); // 가상스토리지 할당정보에서 사용량 업데이트
					}
				} else
				{
					for (VrDskVo disk : diskList)
					{
						disk.setDelUserId(ProcessConstant.getBatchRegUserId());
						rsrcRcVmDao.updateManualRemoveVrDisk(disk); // 가상디스크정보 삭제
						rsrcRcVmDao.updateManualRemoveStrgAsgn(disk); // 가상서버스토리지할당정보 삭제
						// OS 용도 확인
						if (disk.getDskClCd().equals("01"))
						{
							rsrcRcVmDao.updateManualRemoveStrgDm(disk); // 가상스토리지 할당정보에서 사용량 업데이트
						}
					}
				}
			} else
			{
				for (VrDskVo disk : diskList)
				{
					disk.setDelUserId(ProcessConstant.getBatchRegUserId());
					rsrcRcVmDao.updateManualRemoveVrDisk(disk); // 가상디스크정보 삭제
					rsrcRcVmDao.updateManualRemoveStrgAsgn(disk); // 가상서버스토리지할당정보 삭제
					rsrcRcVmDao.updateManualRemoveStrgDm(disk); // 가상스토리지 할당정보에서 사용량 업데이트
				}
			}

			rsrcRcVmDao.updateManualRemoveRcVm(vm);

			resultBool = ntopsService.sendVmDeleteNTopsResult(dtlVmVo.getRsrcReqNo());
			logger.info("sendVmDeleteNTopsResult["+dtlVmVo.getRsrcReqNo()+"]=" + resultBool );
		}

		// 가상서버 요청 상세정보 업데이트
		RrRsrcReqDtlVm rrRsrcReqDtlVm = new RrRsrcReqDtlVm();
		ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
		BeanUtils.copyProperties(rrRsrcReqDtlVm, dtlVmVo);
		rrRsrcReqDtlVm.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_MANUAL_CMPLT);

		cRrRsrcReqDtlVmDao.updateRrRsrcReqDtlVmCre(rrRsrcReqDtlVm);

		// 가상서버 요청정보 업데이트
		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		BeanUtils.copyProperties(rrRsrcReq, dtlVmVo);
		rrRsrcReq.setRsrcReqPrcssStatCd(OprConstant.RSRC_REQ_PRCSS_STAT_MANUAL_CMPLT);
		cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);
	}
}
