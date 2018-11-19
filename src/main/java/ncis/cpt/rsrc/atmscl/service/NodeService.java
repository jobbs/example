package ncis.cpt.rsrc.atmscl.service;


import java.util.List;

import ncis.cpt.rsrc.atmscl.vo.NodeSearchVo;
import ncis.cpt.rsrc.atmscl.vo.NodeVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;


/**
 * @author x
 *
 */
public interface NodeService {

	/**
	 * 노드 목록 조회
	 * @param  searchVo
	 * @return
	 */
	List<NodeVo> selectNodeList(NodeSearchVo searchVo);


	/**
	 * 노드 생성
	 * @param vo
	 * @return ProcResultVo
	 */
	public String insertNode(NodeVo vo) throws Exception;


	/**
	 * 노드 상세 조회
	 * @param  rsrcPoolId
	 * @param  atmsclNodeId
	 * @return
	 */
	NodeVo selectNode(String rsrcPoolId, String atmsclNodeId);


	/**
	 *  노드 수정
	 * @param vo
	 * @return
	 */
	void updateNode(NodeVo vo) throws Exception;

	/**
	 * Pod 목록 조회
	 * @param  searchVo
	 * @return
	 */
	List<ServcPodVo> selectServcPodList(String rsrcPoolId, String atmsclNodeId);

	/**
	 * 자원풀 목록 조회
	 * @param  searchVo
	 * @return
	 */
	List<NodeVo> selectAtmSclRsrcPoolList(String vrlzSwTyCd, String rsrcPoolClCd);


	/**
	 * @param searchVo
	 * @return
	 */
	List<NodeVo> selectExcelNodeList(NodeSearchVo searchVo);


}

