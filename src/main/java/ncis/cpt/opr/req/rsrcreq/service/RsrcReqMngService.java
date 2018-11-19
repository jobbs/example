package ncis.cpt.opr.req.rsrcreq.service;

import java.util.List;

import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqVo;

public interface RsrcReqMngService {

	/**
	 * 자원요청 목록 조회
	 * @param  searchVo
	 * @return
	 */
	List<RsrcReqMngVo> selectRsrcReqList(RsrcReqMngSearchVo searchVo);

	/**
	 * 자원요청 상세 조회
	 * @param  resReqId
	 * @return
	 */
	RsrcReqVo selectRsrcReqDtl(String rsrcReqNo);

	/**
	 * 자원요청 Excel 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<RsrcReqMngVo> selectRsrcReqExcelList(RsrcReqMngSearchVo searchVo);

	/**
	 *  자원요청 상세 조회 (센터, 존, 망, uuid, 자원풀 정보 조회)
	 * @param rsrcReqNo
	 * @return
	 */
	RsrcReqVo selectRsrcReqDtlPoolInfo(String rsrcReqNo) throws Exception;

	/**
	 *  자원요청 삭제여부 수정
	 * @param vo
	 * @return
	 */
	void updateRsrcReqDeleteYn(RsrcReqMngVo vo) throws Exception;


	/**
	 *  자동확장 요청 생성
	 * @param vo
	 * @return
	 */
	String insertRsrcReqAtmScl(RsrcReqMngVo vo) throws Exception;

	/**
	 * 자원요청 정보 조회
	 * @param  rsrcReqNo
	 * @return
	 */
	RsrcReqMngVo selectRsrcReq(String rsrcReqNo);

	/**
	 *  자원요청 실행정보 수정
	 * @param vo
	 * @return
	 */
	void updateRsrcReqExeInfo(RsrcReqMngVo vo) throws Exception;

	/**
	 *  자원요청 첨부파일정보 조회
	 * @param vo
	 * @return
	 */
	RsrcReqMngVo selectRsrcReqFileInfo(String rsrcReqNo);

	/**
	 * 리전 목록 조회
	 * @param regUserId
	 * @return
	 */
	List<RsrcReqMngVo> selectRegionList(String regUserId);

}
