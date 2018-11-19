package ncis.cpt.rsrc.atmscl.service;

import java.util.List;

import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbSearchVo;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.DistrbEnvConfVo;
import ncis.cpt.rsrc.atmscl.vo.PvcVo;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;



/**
 * @author x
 *
 */
public interface AtmsclDistrbService {

	/**
	 * 배포 목록 조회
	 * @param  distrbVo
	 * @return
	 */
	List<AtmsclDistrbVo> selectAtmsclDistrbList(AtmsclDistrbSearchVo atmsclDistrbSearchVo);

	/**
	 * 배포 이력 및 설정정보
	 * @param atmsclDistrbVo
	 * @return
	 */
	List<AtmsclDistrbVo> selectDetailAtmsclDistrb(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * Pod 정보
	 * @param atmsclDistrbVo
	 * @return
	 */
	List<AtmsclDistrbVo> selectDistrbPodInfo(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * 오토스케일링 정보
	 * @param atmsclDistrbVo
	 * @return
	 */
	List<AtmsclDistrbVo> selectRsrvSclInfo(AtmsclDistrbVo atmsclDistrbVo);

	/**
	 * 스토리지 조회
	 * @param AtmsclDistrbSearchVo
	 */
	List<AtmsclDistrbVo> selectAtmsclStrgP(AtmsclDistrbSearchVo atmsclDistrbVo);

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	AtmSclResultIfVo insertPvcStrgAdd(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**자원확장 가능여부
	 * @param atmsclDistrbVo
	 */
	Integer selectAutoSclingCheck(AtmsclDistrbVo atmsclDistrbVo);

	/** 자원확장 생성
	 * @param atmsclDistrbVo
	 * @return
	 */
	AtmSclResultIfVo insertReplicasAdd(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	AtmSclResultIfVo updateRsrcLt(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * @param atmsclDistrbVo
	 */
	List<DistrbEnvConfVo> selectDistrbEnvConfInfo(AtmsclDistrbVo atmsclDistrbVo);

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	AtmSclResultIfVo updateDistrbConf(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * @param atmsclDistrbVo
	 */
	void insertDistrbAutoConf(AtmsclDistrbVo atmsclDistrbVo) throws Exception;;

	/**
	 * @param atmsclDistrbVo
	 */
	AtmSclResultIfVo selectDistrbStat(AtmsclDistrbVo atmsclDistrbVo)throws Exception;

	/**
	 * 스케일 배포 목록 조회
	 * @param  distrbVo
	 * @return
	 */
	List<AtmsclDistrbVo> selectAtmsclDistrbListP(AtmsclDistrbSearchVo atmsclDistrbSearchVo);

	/**
	 * @param atmsclDistrbVo
	 */
	List<PvcVo> selectDistrbPvc(AtmsclDistrbVo atmsclDistrbVo);

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	void updateDistrbConfSave(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * @param atmsclDistrbVo
	 */
	void updateDistrbAutoSclConf(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * @param atmsclDistrbVo
	 */
	void deleteDistrbAutoSclConf(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	AtmsclDistrbVo selectPodQuata(AtmsclDistrbVo atmsclDistrbVo) throws Exception;


	/**
	 * @param atmsclDistrbVo
	 * @return
	 */
	AtmSclResultIfVo updateInitRsrcLt(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * @param atmsclDistrbVo
	 */
	AtmSclResultIfVo deletePvc(AtmsclDistrbVo atmsclDistrbVo) throws Exception;

	/**
	 * @param atmsclDistrbVo
	 */
	int selectDitrbStatCnt(AtmsclDistrbVo atmsclDistrbVo)throws Exception;


}

