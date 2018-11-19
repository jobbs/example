package ncis.dsb.thrd.thrdConf.service;

import java.util.List;
import java.util.Map;

import ncis.cmn.vo.Tree;
import ncis.dsb.thrd.evnt.vo.InstitutionToVmVo;
import ncis.dsb.thrd.evnt.vo.InstitutionToAxVo;
import ncis.dsb.thrd.evnt.vo.RegionToPmVo;
import ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxSearchVo;
import ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxVo;

public interface ThrdStndIdxService {

	/**
	 * 표준 임계치 목로곶회
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public List<ThrdStndIdxVo> selectThrdStndIdxList(ThrdStndIdxSearchVo searchVo)throws Exception;
	/**
	 * 표준 임계치 조회
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public ThrdStndIdxVo selectThrdStndIdx(ThrdStndIdxSearchVo searchVo)throws Exception;
	/**
	 * 표준 임계치 수정
	 * @param vo
	 * @throws Exception
	 */
	public void updateThrdStndIdx(ThrdStndIdxVo vo)throws Exception;
	/**
	 * 임계치 표준 삭제
	 * @param profId
	 * @throws Exception
	 */
	public void deleteThrdStndIdx(Long profId)throws Exception;
	/**
	 * 센터~물리서버까지 트리 구조
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Tree<String,RegionToPmVo> selectRegionToPmTree(Map<String,Object> param)throws Exception;

	/**
	 * 기관~가상서버까지 트리 구조
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Tree<String,InstitutionToVmVo> selectInstitutionToVmTree(Map<String,Object> param)throws Exception;

	/**
	 * 기관~자동확장까지 트리 구조
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Tree<String,InstitutionToAxVo> selectInstitutionToAxTree(Map<String,Object> param)throws Exception;
	
	// 2017.10.31 온나라 테스트 
	/**
	 * 센터~물리서버까지 트리 구조 (by Onnara)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Tree<String,RegionToPmVo> selectRegionToPmTreeByOnnara(Map<String,Object> param)throws Exception;
	
	/**
	 * 기관~가상서버까지 트리 구조 (by Onnara)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Tree<String,InstitutionToVmVo> selectInstitutionToVmTreeByOnnara(Map<String,Object> param)throws Exception;
	
}
