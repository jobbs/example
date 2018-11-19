/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqNetwkServiceImpl.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 10.
 * @lastmodified 2016. 10. 10.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRnSlbDao;
import ncis.cmn.dao.CRnSlbIpDao;
import ncis.cmn.dao.CRrRsrcReqDao;
import ncis.cmn.dao.CRrRsrcReqDtlNetwkDao;
import ncis.cmn.entity.RnSlb;
import ncis.cmn.entity.RnSlbIp;
import ncis.cmn.entity.RrRsrcReq;
import ncis.cmn.entity.RrRsrcReqDtlNetwk;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cpt.opr.req.rsrcreq.dao.RsrcReqMngDao;
import ncis.cpt.opr.req.rsrcreq.dao.RsrcReqNetwDao;
import ncis.cpt.opr.req.rsrcreq.service.RsrcReqNetwkService;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkSlbConfIpReqVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.intfc.netwkstack.service.NetwkStackService;
import ncis.intfc.netwkstack.vo.HealthMonitorVO;
import ncis.intfc.netwkstack.vo.LbBodyVO;
import ncis.intfc.netwkstack.vo.ListenerVO;
import ncis.intfc.netwkstack.vo.LoadbalancerVO;
import ncis.intfc.netwkstack.vo.MemberBodyVo;
import ncis.intfc.netwkstack.vo.MemberVO;
import ncis.intfc.netwkstack.vo.PoolVO;
import ncis.intfc.netwkstack.vo.SessionPersistenceVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import com.google.gson.Gson;


/**
 * 자원요청상세_네트워크
 * @author 김봉민
 *
 */
@Service("rsrcReqNetwkService")
public class RsrcReqNetwkServiceImpl implements  RsrcReqNetwkService{

	private final Logger logger = LoggerFactory.getLogger(RsrcReqNetwkServiceImpl.class);

	@Resource(name = "rsrcReqMngDao")
	private RsrcReqMngDao rsrcReqMngDao;

	@Resource(name = "rsrcReqNetwDao")
	private RsrcReqNetwDao rsrcReqNetwDao;

	@Resource(name="cRrRsrcReqDao")
	private CRrRsrcReqDao cRrRsrcReqDao;

	@Resource(name="cRrRsrcReqDtlNetwkDao")
	private CRrRsrcReqDtlNetwkDao cRrRsrcReqDtlNetwkDao;

	@Resource(name="netwkStackService")
	private NetwkStackService netwkStackService;

	@Resource(name="commonService")
	private CommonService commonService;

	@Resource(name="cRnSlbDao")
	private CRnSlbDao cRnSlbDao;

	@Resource(name="cRnSlbIpDao")
	private CRnSlbIpDao cRnSlbIpDao;

	/**
	 * 자원요청상세 조회
	 */
	@Override
	public RsrcReqVo selectRsrcReqInfo(String rsrcReqNo) {
		RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
		searchVo.setRsrcReqNo(rsrcReqNo);
		return rsrcReqMngDao.selectRsrcReqDtl(searchVo);

	}

	/**
	 * 자원요청상세_네트워크 조회
	 */
	@Override
	public RsrcReqNetwkVo selectRsrcReqNetwk(RsrcReqMngSearchVo searchVo){
		List<RsrcReqNetwkVo> resultList = selectRsrcReqNetwkList(searchVo);
		if(resultList != null && resultList.size()>0){
			return resultList.get(0);
		}
		return null;
	}

	/**
	 * 자원요청상세_네트워크 조회
	 */
	@Override
	public List<RsrcReqNetwkVo> selectRsrcReqNetwkList(RsrcReqMngSearchVo searchVo) {
		return this.rsrcReqNetwDao.selectRsrcReqNetwkList(searchVo);
	}

	/**
	 * 자원요청상세_SLB설정 IP요청 목록 조회
	 */
	@Override
	public List<RsrcReqNetwkSlbConfIpReqVo> selectRsrcReqNetwkSlbConfIpReqList(RsrcReqMngSearchVo searchVo) {
		return this.rsrcReqNetwDao.selectRsrcReqNetwkSlbConfIpReqList(searchVo);
	}

	/**
	 *자원요청상세_네트워크 상태 업데이트 및 프로세스 처리(실행/반려 처리)
	 */
	@Override
	public String updateRsrcReqNetwkSlbExe(RsrcReqNetwkVo netwkVo, String exeUserId)  throws Exception{
		RsrcReqVo rsrcReqVo = selectRsrcReqInfo(netwkVo.getRsrcReqNo());
		String resultmessage = rsrcReqVo.getRsrcReqTyNm() +" " +  OprConstant.RSRC_EXEC_FAIL_MSG;
		try{
			if(exeSlbProcess(rsrcReqVo , netwkVo )){
				updateRsrcReqNetwkPrcssStat(netwkVo, exeUserId);
				resultmessage = rsrcReqVo.getRsrcReqTyNm() +" " + OprConstant.RSRC_EXEC_SUCC_MSG;
			}
		}catch(Exception e){
			throw e;
		}
		return resultmessage;
	}

	/**
	 * 실행
	 * @param rsrcReqNo
	 * @return
	 */
	private boolean exeSlbProcess(RsrcReqVo rsrcReqVo ,RsrcReqNetwkVo netwkVo) throws Exception{

		try{
			RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
			searchVo.setRsrcReqNo(rsrcReqVo.getRsrcReqNo());

			//네트워크 상세 정보 조회
			List<RsrcReqNetwkVo> netwkVoList = this.rsrcReqNetwDao.selectRsrcReqNetwkList(searchVo);
			if(netwkVoList !=null){
				for(RsrcReqNetwkVo aVo : netwkVoList){
					// 요청 부처를 기준으로 네트워크 스위치에 있는 L4 vm를 조회하여 해당 nsSid, nfSid를 조회한다.
					VmSearchVo vmSearchVo = new VmSearchVo();
					vmSearchVo.setInstitutionId(rsrcReqVo.getReqInstitutionId());
					vmSearchVo.setEqualsRsrcPoolId(aVo.getRsrcPoolId());
					VmVo vmVo = rsrcReqNetwDao.selectNetwkSrvcSids(vmSearchVo);

					if(vmVo ==null){
						throw new Exception(OprConstant.RSRC_EXEC_NEED_SET_L3L4_INSTITUTIN_MSG);
					}

					String nsSid = vmVo.getNsSid();		//nsSid
					String nfSid = vmVo.getNfSid();		//nfSid

					if(nsSid == null
							|| nsSid.equals("")
							|| nfSid == null
							|| nfSid.equals("")) {
						throw new Exception(OprConstant.RSRC_EXEC_SID_NULL_MSG +" [NS_SID:"+ nsSid + ", NF_SID:"+ nfSid+"]");
					}

					String rsrcPoolId = vmVo.getRsrcPoolId();
					String regionId = vmVo.getRegionId();
					String zoneId =vmVo.getZoneId();
					String netId = vmVo.getNetClCd(); // vmVo.getNetId(); 망구분코드로 설정

					rsrcReqVo.setRegionId(regionId);
					aVo.setZoneId(zoneId);
					aVo.setNetId(netId);

					RestHeaders headers = new RestHeaders();	//headers
					headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					headers.setAreaId(rsrcReqVo.getRegionId());
					headers.setZoneId(aVo.getZoneId());
					headers.setNetworkId(aVo.getNetId());
					headers.setManagerId(rsrcPoolId);

					// healthMonitors
					HealthMonitorVO healthMonitor = new HealthMonitorVO();
					healthMonitor.setType(aVo.getStatConfrm());							// "HTTP");
					healthMonitor.setDelay(aVo.getStatConfrmCycle().intValue());		//10
					healthMonitor.setTimeOut(aVo.getStatConfrmTOut().intValue());		//10
					healthMonitor.setMaxRetries(aVo.getMaxTryCnt().intValue());			//5
					healthMonitor.setUrlPath(aVo.getStatConfrmHttpUrl()); 				// "/index.html");

					//listener
					ListenerVO listener = new ListenerVO();
					listener.setProtocol(aVo.getPrtclNm()); 							//HTTP
					listener.setPort(Integer.parseInt(aVo.getPort()));					// port  80
					listener.setVip(aVo.getVipAddr());									// vip  "192.168.101.121"
					listener.setDefaultTlsContainerRef("");
					//TLS인증서

					List<PoolVO> pools = new ArrayList<PoolVO>();
					PoolVO pool = new PoolVO();
					pool.setLbAlgorithm(aVo.getSlbTyNm());  								//부하분산 알고리즘
					SessionPersistenceVO sessionPersistenceVO = new SessionPersistenceVO();
					sessionPersistenceVO.setType(aVo.getSessMntncTyNm());
					sessionPersistenceVO.setCookieName(aVo.getSessMntncVl()); 				// "cookie1");//
					pool.setSessionPersistence(sessionPersistenceVO);
					pools.add(pool);

					LoadbalancerVO loadbalancerVOParam = new LoadbalancerVO();	//loadbalancerVOParam
					loadbalancerVOParam.setId(""); 								//--필요 없음.
					loadbalancerVOParam.setHealthMonitor(healthMonitor);		// healthMonitors
					loadbalancerVOParam.setListener(listener);					//listers
					loadbalancerVOParam.setPool(pool);							//pools

					logger.debug("nsSID = "+  nsSid + ", nfSid="+nfSid);
					logger.debug(toTextRestHeaders(headers));
					printResult("request loadbalancerVOParam " , loadbalancerVOParam);


					Gson gson = new Gson();
					logger.debug("################ JSON ################" );
					logger.debug(gson.toJson(loadbalancerVOParam));

					LbBodyVO loadbalancerVO =  netwkStackService.insertL4LB(nsSid, nfSid, headers, loadbalancerVOParam);

					printResult("response param" , loadbalancerVO.getLoadbalancer());

					List<RsrcReqNetwkSlbConfIpReqVo> slbVoList = this.rsrcReqNetwDao.selectRsrcReqNetwkSlbConfIpReqList(searchVo);
					String loadbalancerId = loadbalancerVO.getLoadbalancer().getId();

					RestHeaders innerHeader = new RestHeaders();	//headers
					innerHeader.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
					innerHeader.setAreaId(rsrcReqVo.getRegionId());
					innerHeader.setZoneId(aVo.getZoneId());
					innerHeader.setNetworkId(aVo.getNetId());
					innerHeader.setManagerId(rsrcPoolId);

					MemberBodyVo bodyVo = new MemberBodyVo();
					if(slbVoList !=null){
						List<MemberVO> list = new ArrayList<MemberVO>();
						for(RsrcReqNetwkSlbConfIpReqVo aSlbVo : slbVoList){
							MemberVO memberVO = new MemberVO();	//우선 노드(ip)만 전달
							memberVO.setNode(aSlbVo.getIpAddr());
							memberVO.setPort(Integer.parseInt(aSlbVo.getPort()));
							memberVO.setWeight(aSlbVo.getWvl().intValue());
							memberVO.setDescription(aSlbVo.getDc());

							logger.debug("loadbalancerId="+loadbalancerId);
							logger.debug(toTextRestHeaders(innerHeader));
							logger.debug(toTextMemberVO(memberVO));
							list.add(memberVO);
						}
						bodyVo.setMember(list);

						logger.debug("################ member >>>>> JSON ################" );
						logger.debug(gson.toJson(bodyVo));

						netwkStackService.insertL4Member(nsSid, nfSid, loadbalancerId, innerHeader, bodyVo);
					}

					mergeSlbInfo(aVo, rsrcReqVo.getReqInstitutionId(), vmVo.getVmSeq() );
				}
			}else{
				return false;
			}
			return true;
		}catch(HttpServerErrorException e){
			throw new Exception(e.getResponseBodyAsString());
		}catch(HttpStatusCodeException e){
			throw new Exception(e.getResponseBodyAsString());
		}catch(Exception e){
			throw e;
		}
	}

	/**
	 *  slb 정보 추가 및 업데이트
	 * @param vo
	 * @param institutionId
	 * @param vmSeq
	 */
	private void mergeSlbInfo(RsrcReqNetwkVo vo, String institutionId, BigDecimal vmSeq){

		//step.1 - merge slb
		RnSlb rnSlb = new RnSlb();
		rnSlb.setVipAddr(vo.getVipAddr());
		rnSlb.setPrtcl(vo.getPrtcl());
		rnSlb.setPort(vo.getPort());
		rnSlb.setSlbTyCd(vo.getSlbTyCd());
		rnSlb.setSessMntncTyCd(vo.getSessMntncTyCd());
		rnSlb.setSessMntncVl(vo.getSessMntncVl());
		rnSlb.setStatConfrm(vo.getStatConfrm());
		rnSlb.setStatConfrmCycle(vo.getStatConfrmCycle());
		rnSlb.setStatConfrmTOut(vo.getStatConfrmTOut());
		rnSlb.setMaxTryCnt(vo.getMaxTryCnt());
		rnSlb.setStatConfrmHttpUrl(vo.getStatConfrmHttpUrl());
		rnSlb.setInstitutionId(institutionId);
		rnSlb.setVmSeq(vmSeq);
		this.cRnSlbDao.mergeRnSlb(rnSlb);

		//step.2 - merge slb conf ip
		RsrcReqMngSearchVo searchVo = new RsrcReqMngSearchVo();
		searchVo.setRsrcReqNo(vo.getRsrcReqNo());
		List<RsrcReqNetwkSlbConfIpReqVo>  list = this.selectRsrcReqNetwkSlbConfIpReqList(searchVo);
		if(list != null){
			for(RsrcReqNetwkSlbConfIpReqVo aSlbConfVo : list){
				RnSlbIp rnSlbIp = new RnSlbIp();
				rnSlbIp.setVmSeq(vmSeq);
				rnSlbIp.setVipAddr(vo.getVipAddr());
				rnSlbIp.setIpAddr(aSlbConfVo.getIpAddr());
				rnSlbIp.setPort(aSlbConfVo.getPort());
				rnSlbIp.setWvl(aSlbConfVo.getWvl());
				rnSlbIp.setDc(aSlbConfVo.getDc());
				this.cRnSlbIpDao.mergeRnSlbIp(rnSlbIp);
			}
		}
	}


	private final String ENTER ="\n";


	private void printResult(String title, LoadbalancerVO loadbalancerVO){
		String msg = "############################ "+ title+" (START) ############################" +ENTER;

		msg += "getId=" + loadbalancerVO.getId() +ENTER;
		msg += "getHealthMonitor=" + loadbalancerVO.getHealthMonitor() +ENTER;
		if(loadbalancerVO.getHealthMonitor() != null){
				msg += toTextHealthMonitorVO(loadbalancerVO.getHealthMonitor() ) +ENTER;
		}

		msg += loadbalancerVO.getListener() +ENTER;
		if(loadbalancerVO.getListener() != null){
				msg +=toTextListenerVO(loadbalancerVO.getListener()) +ENTER;
		}

		msg += loadbalancerVO.getPool()+ENTER;
		if(loadbalancerVO.getPool() != null){
				msg += toTextPoolVO(loadbalancerVO.getPool())+ENTER;
		}
		msg += "############################ "+title+" (END  ) ############################" +ENTER;

		logger.debug(msg);
	}

	private String toTextRestHeaders(RestHeaders vo){
		String msg = "";
		msg += "getSeq = " + vo.getSeq()+ENTER;
		msg +=  "getAreaId =" +  vo.getAreaId()+ ENTER;
		msg +=  "getZoneId =" + vo.getZoneId()+ ENTER;
		msg +=  "getNetworkId =" + vo.getNetworkId()+ ENTER;
		msg +=  "getManagerId =" + vo.getManagerId()+ ENTER;
		return msg;

	}

	private String toTextPoolVO(PoolVO vo){
		String msg ="";
		msg += "getLbAlgorithm="+ vo.getLbAlgorithm() +ENTER;
		if(vo.getSessionPersistence()!=null){
				msg += "type="+ vo.getSessionPersistence().getType() +ENTER;
				msg += "cookieName="+ vo.getSessionPersistence().getCookieName() +ENTER;
		}
		return msg;
	}
	private String toTextHealthMonitorVO(HealthMonitorVO vo){
		String msg ="";
		msg += "type="+ vo.getType() +ENTER;
		msg += "delay="+ vo.getDelay() +ENTER;
		msg += "timeOut="+ vo.getTimeOut() +ENTER;
		msg += "maxRetries="+ vo.getMaxRetries() +ENTER;
		msg += "urlPath="+ vo.getUrlPath() +ENTER;
		return msg;
	}

	private String toTextListenerVO(ListenerVO vo){
		String msg ="";
		msg += "protocol="+ vo.getProtocol() +ENTER;
		msg += "port =" +vo.getPort()+ENTER;
		msg += "getVipAddress=" +vo.getVip() +ENTER;
		msg += "defaultTlsContainerRef = "+ vo.getDefaultTlsContainerRef() +ENTER;
		return msg;
	}

	private String toTextMemberVO(MemberVO memberVO){
		String msg ="";
		msg += "node ="+memberVO.getNode()  +ENTER;
		msg += "description =" + memberVO.getDescription() +ENTER;
		msg += "pot = " + memberVO.getPort() +ENTER;
		msg += "weight =" + memberVO.getWeight() +ENTER;
		return msg;
	}


	/**
	 * 자원요청상세_네트워크 반려
	 */
	@Override
	public String updateRsrcReqNetwkRjct(RsrcReqNetwkVo vo, String exeUserId)  throws Exception{

		RsrcReqVo resultVo =  selectRsrcReqInfo(vo.getRsrcReqNo());

		String resultmessage = resultVo.getRsrcReqTyNm() + " " +  OprConstant.RSRC_EXEC_FAIL_MSG;

		try{
			updateRsrcReqNetwkPrcssStat(vo, exeUserId);
			resultmessage = resultVo.getRsrcReqTyNm() + OprConstant.RSRC_EXEC_SUCC_MSG;
		}catch(Exception e){
			throw e;
		}
		return resultmessage;
	}

	/**
	 * 자원요청상세- 네트워크 상태 업데이트
	 * @param vo
	 * @param exeUserId
	 */
	private void updateRsrcReqNetwkPrcssStat(RsrcReqNetwkVo vo, String exeUserId) {
		//네트워크 상태
		RrRsrcReqDtlNetwk rrRsrcReqDtlPRsrc = new RrRsrcReqDtlNetwk();
		rrRsrcReqDtlPRsrc.setRsrcReqNo(vo.getRsrcReqNo());
		rrRsrcReqDtlPRsrc.setRsrcReqPrcssStatCd(vo.getRsrcReqPrcssStatCd());
		rrRsrcReqDtlPRsrc.setRjctTyCd(vo.getRjctTyCd());
		rrRsrcReqDtlPRsrc.setRjctReasn(vo.getRjctReasn());
		rrRsrcReqDtlPRsrc.setProcssInstSeq(vo.getProcssInstSeq());
		cRrRsrcReqDtlNetwkDao.updateRsrcReqNetwkPrcssStatCd(rrRsrcReqDtlPRsrc);

		//자원요청 상태 업데이트
		RrRsrcReq rrRsrcReq = new RrRsrcReq();
		rrRsrcReq.setRsrcReqNo(vo.getRsrcReqNo());
		rrRsrcReq.setExeUserId(exeUserId);
		rrRsrcReq.setRsrcReqPrcssStatCd(vo.getRsrcReqPrcssStatCd());
		cRrRsrcReqDao.updateRrRsrcReqExeInfo(rrRsrcReq);
	}
}
