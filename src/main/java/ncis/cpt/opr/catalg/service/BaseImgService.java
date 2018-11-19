package ncis.cpt.opr.catalg.service;

import java.util.List;

import ncis.cpt.opr.catalg.vo.BaseImgSearchVo;
import ncis.cpt.opr.catalg.vo.BaseImgVo;

public interface BaseImgService {

	/**
	 * 베이스이미지 목록 조회
	 * @param  searchVo
	 * @return
	 */
	List<BaseImgVo> selectBaseImgList(BaseImgSearchVo searchVo);

	/**
	 * 베이스이미지 상세 조회
	 * @param  resReqId
	 * @return
	 */
	BaseImgVo selectBaseImg(String rsrcPoolId, String imgId, int servcAreaSeq);


	/**
	 *  베이스이미지 수정
	 * @param vo
	 * @return
	 */
	void updateBaseImg(BaseImgVo vo) throws Exception;


	/**
	 * 베이스이미지 포트  조회
	 * @param  searchVo
	 * @return
	 */
	List<BaseImgVo> selectBaseImgPortList(BaseImgVo baseImgVo);

}
