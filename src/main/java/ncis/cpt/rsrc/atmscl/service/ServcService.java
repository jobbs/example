package ncis.cpt.rsrc.atmscl.service;


import java.util.List;

import ncis.cpt.opr.catalg.vo.BaseImgVo;
import ncis.cpt.rsrc.atmscl.vo.AtmsclDistrbVo;
import ncis.cpt.rsrc.atmscl.vo.BldVo;
import ncis.cpt.rsrc.atmscl.vo.ScrtkyVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPortVo;
import ncis.cpt.rsrc.atmscl.vo.ServcRouteVo;
import ncis.cpt.rsrc.atmscl.vo.ServcSclngVo;
import ncis.cpt.rsrc.atmscl.vo.ServcSearchVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;


/**
 * @author x
 *
 */
public interface ServcService {

	/**
	 * 서비스 목록 조회
	 * @param  searchVo
	 * @return
	 */
	List<ServcVo> selectServcList(ServcSearchVo searchVo);


	/**
	 * 서비스 상세조회
	 * @param  searchVo
	 * @return
	 */
	ServcVo selectServc(int servcSeq);


	/**
	 * 서비스 생성
	 * @param vo
	 * @return ProcResultVo
	 */
	public String insertServc(ServcVo vo) throws Exception;


	/**
	 * 서비스 수정
	 * @param vo
	 * @return ProcResultVo
	 */
	public String updateServc(ServcVo vo) throws Exception;


	/**
	 * 보안키 목록 조회
	 * @param vo
	 * @return servcAreaSeq
	 */
	public List<ScrtkyVo> selectScrtKyList(int servcAreaSeq) throws Exception;


	/**
	 * 보안키 생성
	 * @param vo
	 * @return ProcResultVo
	 */
	public String insertScrtky(ScrtkyVo vo) throws Exception;


	/**
	 * 대상포트 조회
	 * @param rsrcPoolId
	 * @param imgId
	 * @return List
	 */
	public List<BaseImgVo> selectTargetPortList(String rsrcPoolId, String imgId, Integer servcAreaSeq) throws Exception;


	/**
	 * 빌드이력 생성
	 * @param vo
	 * @return ProcResultVo
	 */
	public String insertBldHstry(ServcVo vo) throws Exception;


	/**
	 * Pod 목록 조회
	 * @param  servcSeq
	 * @return
	 */
	List<ServcPodVo> selectServcPodList(Integer servcSeq);


	/**
	 * 라우트 목록 조회
	 * @param  servcSeq
	 * @return
	 */
	List<ServcRouteVo> selectServcRouteList(Integer servcSeq);


	/**
	 * 서비스 포트 목록 조회
	 * @param  servcSeq
	 * @return
	 */
	List<ServcPortVo> selectServcPortList(Integer servcSeq);


	/**
	 * 라우트 생성
	 * @param  servcSeq
	 * @return
	 */
	public String insertServcRoute(ServcRouteVo vo) throws Exception;


	/**
	 * 배포 실행
	 * @param  vo
	 * @return
	 */
	public String updateDeploymentConfig(ServcVo vo) throws Exception;


	/**
	 * 제한조회
	 * @param  servcSeq
	 * @return
	 */
	public AtmsclDistrbVo selectLimit(Integer servcSeq);


	/**
	 * 빌드 조회
	 * @param  servcSeq
	 * @return
	 */
	public List<BldVo> selectBldList(Integer servcSeq);


	/**
	 * 배포 조회
	 * @param  servcSeq
	 * @return
	 */
	public List<AtmsclDistrbVo> selectDistrbList(Integer servcSeq);


	/**
	 * 이미지 조회
	 * @param  servcSeq
	 * @return
	 */
	public List<BaseImgVo> selectImgList(Integer servcSeq);

	/**
	 * 스케일 조회
	 * @param  servcSeq
	 * @return
	 */
	public List<ServcSclngVo> selecServcSclngList(Integer servcSeq);


	/**
	 * 서비스 삭제
	 * @param  vo
	 * @return
	 */
	public String deleteServc(ServcVo vo) throws Exception;


	/**
	 * 서비스 상태반영
	 * @param  vo
	 * @return
	 */
	public String updateServcStat(ServcVo vo) throws Exception;


	/**
	 * 라우트 삭제
	 * @param  vo
	 * @return
	 */
	public String deleteServcRoute(ServcRouteVo vo) throws Exception;


}

