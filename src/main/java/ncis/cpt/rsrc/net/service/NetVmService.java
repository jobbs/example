/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetVmService.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 24.
 * @lastmodified 2016. 10. 24.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 24.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.net.service;

import java.util.List;

import ncis.cpt.rsrc.com.vo.VmResHistVo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.net.vo.NetVmSvo;
import ncis.cpt.rsrc.net.vo.NetVmVo;
import ncis.cpt.rsrc.net.vo.SlbReqVo;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;

/**
 * @author 송승규
 *
 */
public interface NetVmService {

	/**
	 * 네트워크 가상서버 목록조회
	 * @param svo
	 * @return
	 */
	public List<NetVmVo> selectNetVmList(NetVmSvo svo, boolean isPagination);

	/**
	 * 네트워크 가상서버 상세조회
	 * @param svo
	 * @return
	 */
	public NetVmVo selectNetVm(NetVmVo vo);

	/**
	 * 네트워크 가상서버 구성ID 수정
	 * @param svo
	 * @return
	 */
	public void updateNetVm(NetVmVo vo, VmResHistVo vmResHistVo);

	/**
	 * SLB 요청
	 * @param vo
	 */
	public void insertSlb(SlbReqVo vo);

	/**
	 * 자원풀 목록 조회
	 * @param vo
	 * @return
	 */
	public List<RsrcPoolVo> selectNetRsrcPoolList(NetVmSvo svo);

	/**
	 * SLB 적용 가상서버 IP목록
	 * @param svo
	 * @return
	 */
	public List<VmVo> selectComVmList(VmSearchVo svo);

	/**
	 * 가상서버 구성아이디 카운트
	 * @param vo
	 * @return
	 */
	public boolean isExistsVmCompId(String vmCompId);
}
