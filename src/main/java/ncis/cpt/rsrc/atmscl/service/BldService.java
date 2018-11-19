package ncis.cpt.rsrc.atmscl.service;

import java.util.List;

import ncis.cmn.vo.ProcResultVo;
import ncis.cpt.rsrc.atmscl.vo.BldSearchVo;
import ncis.cpt.rsrc.atmscl.vo.BldVo;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;

/**
 * @author x
 *
 */
public interface BldService {

	/**
	 * 빌드 목록 조회
	 * @param  bldVo
	 * @return
	 */
	List<BldVo> selectBldList(BldSearchVo bldSearchVo);

	/** 빌드 상세 조회
	 * @param servcSeq
	 * @param bldId
	 * @return
	 */
	List<BldVo> selectDetailBld(Integer servcSeq, String bldId,String userId) throws Exception;

	/**
	 * 빌드설정 수정
	 * @param bldVo
	 */
	void updateBldConf(BldVo bldVo);

	/**빌드이력 생성
	 * @param bldVo
	 */
	void insertBldHstry(BldVo bldVo);


	/**보안키 조회
	 * @param servcAreaSeq
	 * @return
	 */
	List<BldVo> selectScrtky(Integer servcAreaSeq);

	/**빌드실행
	 * @param bldVo
	 * @throws Exception
	 */
	ProcResultVo bldRun(BldVo bldVo) throws Exception;

	/**
	 * @param bldVo
	 * @return
	 */
	AtmSclResultIfVo selectBldStat(BldVo bldVo) throws Exception;

	/**빌드설정 정보 수정
	 * @param bldVo
	 */
	ProcResultVo updateRxBldConf(BldVo bldVo) throws Exception ;




}

