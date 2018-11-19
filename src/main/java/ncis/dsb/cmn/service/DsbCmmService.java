package ncis.dsb.cmn.service;

import ncis.dsb.cmn.vo.MainCvo;
import ncis.dsb.cmn.vo.MainSearchVo;


public interface DsbCmmService {

	/**
	 * 검색 조건에 해당하는 게시판 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 * @throws Exception
	 */
	MainCvo selectMainList(MainSearchVo searchVo) throws Exception;

	MainCvo selectMainIncList(MainSearchVo searchVo) throws Exception;
	
	MainCvo selectMainListByOnnara(MainSearchVo searchVo) throws Exception;

	MainCvo selectMainIncListByOnnara(MainSearchVo searchVo) throws Exception;

}
