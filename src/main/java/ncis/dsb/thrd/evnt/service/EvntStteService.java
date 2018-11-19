package ncis.dsb.thrd.evnt.service;

import java.util.List;

import ncis.dsb.thrd.evnt.vo.EvntStteSearchVo;
import ncis.dsb.thrd.evnt.vo.EvntStteVo;

/**
 * @author Kim Dong Hoon
 *
 */
public interface EvntStteService {

	/**
	 * 이벤트 현황 목록조회
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public List<EvntStteVo> selectEvntStteList(EvntStteSearchVo searchVo);

	/**
	 * 이벤트 확인처리
	 * @param evntSeq
	 * @throws Exception
	 */
	public void updateEvntConfrm(String evntSeq);

	/**
	 * 이벤트 확인취소
	 * @param evntSeq
	 * @throws Exception
	 */
	public void updateEvntConfrmCncl(String evntSeq);




}
