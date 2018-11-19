package ncis.cpt.rsrc.atmscl.dao;

import java.util.List;

import ncis.cpt.rsrc.atmscl.vo.NodeSearchVo;
import ncis.cpt.rsrc.atmscl.vo.NodeVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("nodeDao")
public class NodeDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 노드 수 조회
	 * @param   searchVo
	 * @return
	 */
	public int selectNodeTotCnt(NodeSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.node.selectNodeTotCnt",searchVo);
	}


	/**
	 * 검색조건에 해당하는 노드 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<NodeVo> selectNodeList(NodeSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.node.selectNodeList",searchVo);
	}

	/**
	 * 검색조건에 해당하는 노드 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<NodeVo> selectExcelNodeList(NodeSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.node.selectExcelNodeList",searchVo);
	}


	/**
	 * 노드 상세
	 * @param resReqId
	 * @return
	 */
	public NodeVo selectNode(NodeVo nodeVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.node.selectNode",nodeVo);
	}

	/**
	 * 검색조건에 해당하는 Pod 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<ServcPodVo> selectServcPodList(ServcPodVo servcPodVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.node.selectServcPodList",servcPodVo);
	}

	/**
	 * 자동확장 자원풀 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<NodeVo> selectAtmSclRsrcPoolList(NodeVo nodeVo) {
		return sqlSession.selectList("ncis.sql.cpt.rsrc.atmscl.node.selectAtmSclRsrcPoolList",nodeVo);
	}

	/**
	 * SEOA 자원풀 조회
	 * @param searchVo
	 * @return
	 */
	public NodeVo selectSeoaRsrcPoolId(NodeVo nodeVo) {
		return sqlSession.selectOne("ncis.sql.cpt.rsrc.atmscl.node.selectSeoaRsrcPoolId",nodeVo);
	}

}
