/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename GatewayService.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 9. 23.
 * @lastmodified 2016. 9. 23.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 23.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.gateway.service;

import java.util.List;
import ncis.cpt.sys.gateway.vo.GatewaySearchVo;
import ncis.cpt.sys.gateway.vo.GatewayVo;

/**
 * @author 박봉춘
 *
 */
public interface GatewayService {

	/**
	 * 검색 조건에 해당하는 API-Gateway 접속정보 관리 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<GatewayVo> selectGatewayList(GatewaySearchVo searchVo);

	/**
	 * Sequence에 해당하는 API-Gateway 접속정보 관리 정보 조회(API-Gateway 접속정보 상세조회)
	 * @param gatewaySeq
	 * @return
	 */
	GatewayVo selectGateway(Long gatewaySeq);

	/**
	 * API-Gateway 접속정보 등록
	 * @param gatewayVo
	 */
	void insertGateway(GatewayVo gatewayVo);

	/**
	 * API-Gateway 접속정보 수정
	 * @param gatewayVo
	 */
	void updateGateway(GatewayVo gatewayVo);

	/**
	 * 센터 중복 체크
	 * @param regionId
	 * @return
	 */
	int selectRegionCnt(String regionId, Long gatewaySeq);

	/**
	 * API-Gateway 접속정보 삭제
	 * @param gatewayvo
	 */
	void deleteGateway(Long gatewaySeq);

    /**
     * @param regionId
     * @return
     */
	List<GatewayVo> selectGatewayHealthCheck(String regionId) throws Exception;


}