package ncis.cpt.rsrc.atmscl.service;

import java.util.List;

import ncis.cpt.rsrc.atmscl.vo.RsrvSclngSearchVo;
import ncis.cpt.rsrc.atmscl.vo.RsrvSclngVo;



/**
 * @author x
 *
 */
public interface RsrvSclngService {

	/**
	 * 스케일 예약설정 목록 조회
	 * @param  rsrvSclngVo
	 * @return
	 */
	List<RsrvSclngVo> selectRsrvSclngList(RsrvSclngSearchVo rsrvSclngSearchVo);

	/**
	 * 스케일 예약설정 생성
	 * @param rsrvSclngVo
	 * @return
	 */
	public String insertRsrvSclng(RsrvSclngVo rsrvSclngVo);

	/**
	 * 스케일 예약설정 상세
	 * @param servcSeq
	 * @param scalrId
	 */
	public RsrvSclngVo selectAtmSclRsrvSclng(Integer servcSeq, String scalrId) throws Exception;

	/**
	 * 스케일 예약설정 수정
	 * @param rsrvSclngVo
	 */
	void updateAtmSclRsrvSclng(RsrvSclngVo rsrvSclngVo) throws Exception;

	/**
	 * @param rsrvSclngVo
	 */
	RsrvSclngVo selectRsrvSclngCheck(RsrvSclngVo rsrvSclngVo) throws Exception;

	/**
	 * @param rsrvSclngVo
	 * @return
	 */
	String deleteSclYn(RsrvSclngVo rsrvSclngVo) throws Exception;




}

