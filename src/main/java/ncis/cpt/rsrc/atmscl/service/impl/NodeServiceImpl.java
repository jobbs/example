package ncis.cpt.rsrc.atmscl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.config.OprConstant;
import ncis.cmn.dao.CRxNodeDao;
import ncis.cmn.entity.RxNode;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cpt.rsrc.atmscl.dao.NodeDao;
import ncis.cpt.rsrc.atmscl.service.NodeService;
import ncis.cpt.rsrc.atmscl.vo.NodeSearchVo;
import ncis.cpt.rsrc.atmscl.vo.NodeVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.intfc.atmscl.service.NodeAPIService;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.NodeIfVo;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Service("nodeService")
public class NodeServiceImpl implements NodeService {

	@Resource(name="nodeDao")
	private NodeDao nodeDao;

	@Resource(name="cRxNodeDao")
	private CRxNodeDao cRxNodeDao;

	@Resource(name="commonService")
	private CommonService commonService;

	@Resource(name="nodeAPIService")
	private NodeAPIService nodeAPIService;


	@Override
	public List<NodeVo> selectNodeList(NodeSearchVo searchVo) {

		List<NodeVo> list = null;
		int totalCount = nodeDao.selectNodeTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한   count
			list = nodeDao.selectNodeList(searchVo);
		}

		return list;
	}

	@Override
	public List<NodeVo> selectExcelNodeList(NodeSearchVo searchVo) {

		List<NodeVo> list = null;
		int totalCount = nodeDao.selectNodeTotCnt(searchVo);

		if( totalCount > 0 ) {
			// 노드관리 엑셀다운로드시 검색결과 건수 수정
			list = nodeDao.selectExcelNodeList(searchVo);
		}

		return list;
	}


	/**
	 * 노드 생성
	 * @param vo
	 * @return
	 */
	@Override
	public String insertNode(NodeVo vo) throws Exception{

		AtmSclResultIfVo atmSclResultIfVo = null;
		String resultmessage = OprConstant.RX_CRE_FAIL_MSG;
		String uid = null;
		//String seoaRsrcPoolId = null;
		//String openShiftRsrcPoolId = null;
		boolean succFlag = false;
		boolean nodeGetFlag = false;

		try{
			vo.setRsrcPoolClCd("04");

			//OpenShift가 설치된 망에 해당되는 SEOA 정보를 조회
			NodeVo nodeVo = new NodeVo();
			nodeVo = nodeDao.selectSeoaRsrcPoolId(vo);
			//seoaRsrcPoolId = nodeDao.selectSeoaRsrcPoolId(vo);

			RestHeaders headers = new RestHeaders();
			headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
			headers.setAreaId(nodeVo.getRegionId());
			headers.setZoneId(nodeVo.getZoneId());
			headers.setNetworkId(nodeVo.getNetClCd());
			headers.setManagerId(nodeVo.getRsrcPoolId());
			/*
			headers.setAreaId(vo.getRegionId());
			headers.setZoneId(vo.getZoneId());
			headers.setNetworkId(vo.getNetClCd());
			headers.setManagerId(seoaRsrcPoolId);
			*/

			//서비스 영역 생성에 필요한 데이터 셋팅
			NodeIfVo nodeIfVo = new NodeIfVo();
			nodeIfVo.setLoginId(OprConstant.VM_ROOT_ID);//설치프로그램 계정ID
			nodeIfVo.setLoginPassword(vo.getVmRootPassWd()); //설치프로그램 계정PW
			nodeIfVo.setMachineIp(vo.getAtmsclNodeIpAddr()); //레지스트리 IP
			nodeIfVo.setTargetNodeDomainName(vo.getAtmsclNodeNm());
			nodeIfVo.setTargetNodeIp(vo.getRprsntIpAddr());  //VM IP

			//노드생성 생성 API호출
			atmSclResultIfVo = nodeAPIService.addOSNodesPost(headers, nodeIfVo);

			//노드가 정상적으로 생성되었을 경우
			if("Y".equals(atmSclResultIfVo.getSuccYn())) {
				succFlag = true;

				headers.setAreaId(vo.getRegionId());
				headers.setZoneId(vo.getZoneId());
				headers.setNetworkId(vo.getNetClCd());
				headers.setManagerId(vo.getRsrcPoolId());

				//노드조회 API호출
				headers.setSeq(commonService.selectSeqNum(OprConstant.SEQ_CRE_CLASSFY, OprConstant.SEQ_CRE_PREFIX));
				//openShiftRsrcPoolId = nodeDao.selectSeoaRsrcPoolId(vo);
				//vo.setRsrcPoolClCd("05");
				//headers.setManagerId(openShiftRsrcPoolId);
				atmSclResultIfVo = nodeAPIService.nodesGet(headers, nodeIfVo);

				//노드가 정상적으로 조회되었을 경우
				if("Y".equals(atmSclResultIfVo.getSuccYn())) {
					nodeGetFlag = true;
					uid = atmSclResultIfVo.getUid();
				}
			}

			if(succFlag) {
				RxNode rxNode = new RxNode();
				BeanUtils.copyProperties(rxNode, vo);

				rxNode.setAtmsclNodeTyCd("04");
				rxNode.setStatCd("01");
				rxNode.setAtmsclNodeUid("N");
				rxNode.setAtmsclNodeIpAddr(vo.getRprsntIpAddr());
				rxNode.setAtmsclNodeId(vo.getAtmsclNodeNm());

				if(nodeGetFlag) {
					rxNode.setAtmsclNodeUid(uid);
				}

				cRxNodeDao.insertRxNode(rxNode); //노드 정보 insert
				resultmessage =  OprConstant.RX_CRE_SUCC_MSG;
			}else {
				resultmessage = resultmessage+"\n"+atmSclResultIfVo.getMessage();
			}

		}catch(HttpServerErrorException e){
			throw new Exception(e.getResponseBodyAsString());
		}catch(HttpStatusCodeException e){
			throw new Exception(e.getResponseBodyAsString());
		}

		return resultmessage;
	}


	/**
	 * 노드 상세조회
	 * @param rsrcPoolId
	 * @param atmsclNodeId
	 * @return NodeVo
	 */
	@Override
	public NodeVo selectNode(String rsrcPoolId, String atmsclNodeId) {
		NodeVo nodeVo = new NodeVo();
		nodeVo.setAtmsclNodeId(atmsclNodeId);
		nodeVo.setRsrcPoolId(rsrcPoolId);
		return nodeDao.selectNode(nodeVo);
	}

	/**
	 * 노드 상세조회
	 * @param vo
	 * @return
	 */
	@Override
	public void updateNode(NodeVo vo) throws Exception{
		RxNode rxNode = new RxNode();
		rxNode.setRsrcPoolId(vo.getRsrcPoolId());
		rxNode.setAtmsclNodeId(vo.getAtmsclNodeId());
		rxNode.setAtmsclNodeNm(vo.getAtmsclNodeNm());
		rxNode.setUpdtUserId(vo.getUpdtUserId());
		rxNode.setRmk(vo.getRmk());
		cRxNodeDao.updateRxNode(rxNode);
	}


	/**
	 * Pod 목록 조회
	 * @param rsrcPoolId
	 * @param atmsclNodeId
	 * @return List<ServcPodVo>
	 */
	@Override
	public List<ServcPodVo> selectServcPodList(String rsrcPoolId, String atmsclNodeId) {

		ServcPodVo servcPodVo = new ServcPodVo();
		servcPodVo.setRsrcPoolId(rsrcPoolId);
		servcPodVo.setAtmsclNodeId(atmsclNodeId);

		List<ServcPodVo> list = null;
		list = nodeDao.selectServcPodList(servcPodVo);
		return list;
	}

	/**
	 * 자원풀 목록 조회
	 * @param rsrcPoolClCd
	 * @param vrlzSwTyCd
	 * @return List<NodeVo>
	 */
	@Override
	public List<NodeVo> selectAtmSclRsrcPoolList(String rsrcPoolClCd, String vrlzSwTyCd) {

		NodeVo nodeVo = new NodeVo();
		nodeVo.setRsrcPoolClCd(rsrcPoolClCd);
		nodeVo.setVrlzSwTyCd(vrlzSwTyCd);

		List<NodeVo> list = null;
		list = nodeDao.selectAtmSclRsrcPoolList(nodeVo);

		return list;
	}

}
