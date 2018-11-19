package ncis.cpt.rsrc.atmscl.service;

import java.util.List;

import ncis.cpt.rsrc.atmscl.vo.PreDistrbSearchVo;
import ncis.cpt.rsrc.atmscl.vo.PreDistrbVo;



/**
 * @author x
 *
 */
public interface PreDistrbService {

	/**
	 * 사전 배포 목록 조회
	 * @param  PreDistrbVo
	 * @return
	 */
	List<PreDistrbVo> selectPreDistrbList(PreDistrbSearchVo preDistrbSearchVo);

	/**
	 * 사전 배포 이미지팝업 조회
	 * @param  PreDistrbVo
	 * @return
	 */
	List<PreDistrbVo> selectPreDistrbListP(PreDistrbSearchVo preDistrbSearchVo);

	/**
	 * 사전배포 이미지 내역 생성
	 * @param preDistrbVo
	 * @return
	 */
	void insertPreDistrb(PreDistrbVo preDistrbVo);

	/**
	 * 사전배포 상세
	 * @param servcAreaSeq
	 * @param preDistrbReqSeq
	 */
	PreDistrbVo updatePreDistrb(Integer servcAreaSeq, Integer preDistrbReqSeq) throws Exception;

	/**
	 * @param preDistrbVo
	 */
	void updatePreDistrbStat(PreDistrbVo preDistrbVo) throws Exception;

	/**
	 * @param preDistrbVo
	 */
	void updateRePreDistrb(PreDistrbVo preDistrbVo);





}

