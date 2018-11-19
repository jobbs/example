/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RegService.java
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
package ncis.rest.intfc.request.service;

import ncis.rest.intfc.request.vo.CreateClusterVO;
import ncis.rest.intfc.request.vo.CreatePmVO;
import ncis.rest.intfc.request.vo.CreateSLBVO;
import ncis.rest.intfc.request.vo.CreateVmVO;
import ncis.rest.intfc.request.vo.ModifyVmVO;
import ncis.rest.intfc.request.vo.RemoveClusterVO;
import ncis.rest.intfc.request.vo.RemovePmVO;
import ncis.rest.intfc.request.vo.RemoveReqVO;
import ncis.rest.intfc.request.vo.RemoveVmVO;
import ncis.rest.intfc.request.vo.ReqResultVO;

/**
 * 요청정보수신 Service
 *
 * @author ShinKeeBong
 *
 */
public interface RegService {

	/**
	 * 가상서버 생성 요청정보 수신
	 * @param vo
	 * @return
	 */
	ReqResultVO createVM(CreateVmVO vo) throws Exception;


	/**
	 * 가상서버 변경 요청정보 수신
	 * @param vo
	 * @return
	 */
	ReqResultVO modifyVM(ModifyVmVO vo) throws Exception;


	/**
	 * 가상서버 삭제 요청정보 수신
	 * @param vo
	 * @return
	 */
	ReqResultVO removeVM(RemoveVmVO vo) throws Exception;


	/**
	 * 물리서버 생성 요청정보 수신
	 * @param vo
	 * @return
	 */
	ReqResultVO createPM(CreatePmVO vo) throws Exception;


	/**
	 * 물리서버 삭제 요청정보 수신
	 * @param vo
	 * @return
	 */
	ReqResultVO removePM(RemovePmVO vo) throws Exception;


	/**
	 * 클러스터 생성 요청정보 수신
	 * @param vo
	 * @return
	 */
	ReqResultVO createCluster(CreateClusterVO vo) throws Exception;


	/**
	 * 클러스터 삭제 요청정보 수신
	 * @param vo
	 * @return
	 */
	ReqResultVO removeCluster(RemoveClusterVO vo) throws Exception;


	/**
	 * SLB 생성 요청정보 수신
	 * @param vo
	 * @return
	 */
	ReqResultVO createSLB(CreateSLBVO vo) throws Exception;

	/**
	 * 요청취소 요청정보 수신
	 * @param vo
	 * @return
	 */ 
	ReqResultVO removeReq(RemoveReqVO vo) throws Exception;

}
