package ncis.cpt.rsrc.atmscl.service;


import java.util.List;

import ncis.cpt.rsrc.atmscl.vo.PvSearchVo;
import ncis.cpt.rsrc.atmscl.vo.PvVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaSearchVo;
import ncis.cpt.rsrc.atmscl.vo.ServcAreaVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;


/**
 * @author x
 *
 */
public interface ServcAreaService {

	/**
	 * 서비스영역 목록 조회
	 * @param  searchVo
	 * @return
	 */
	List<ServcAreaVo> selectServcAreaList(ServcAreaSearchVo searchVo);


	/**
	 * 서비스영역 생성
	 * @param vo
	 * @return ProcResultVo
	 */
	public String insertServcArea(ServcAreaVo vo) throws Exception;


	/**
	 * 서비스영역 상세 조회
	 * @param  servcAreaSeq
	 * @return
	 */
	ServcAreaVo selectServcArea(int servcAreaSeq);


	/**
	 * 서비스목록 조회
	 * @param  servcAreaSeq
	 * @return
	 */
	List<ServcVo> selectServcList(int servcAreaSeq);


	/**
	 * PV목록 조회
	 * @param  servcAreaSeq
	 * @return
	 */
	List<PvVo> selectPvList(PvSearchVo pvSearchVo);


	/**
	 * 서비스영역 PV 할당
	 * @param vo
	 * @return String
	 */
	public String updatePv(ServcAreaVo vo) throws Exception;


	/**
	 * 서비스영역 PV 할당 삭제
	 * @param vo
	 * @return String
	 */
	public String deletePv(PvVo vo) throws Exception;


	/**
	 * 서비스영역 수정
	 * @param vo
	 * @return String
	 */
	public String updateServcArea(ServcAreaVo vo) throws Exception;


	/**
	 * 서비스영역 삭제
	 * @param vo
	 * @return String
	 */
	public String updateServcAreaDeleteYn(ServcAreaVo vo) throws Exception;

}

