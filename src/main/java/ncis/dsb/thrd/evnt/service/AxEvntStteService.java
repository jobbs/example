package ncis.dsb.thrd.evnt.service;

import java.util.List;

import ncis.dsb.thrd.evnt.vo.AxEvntStteSearchVo;
import ncis.dsb.thrd.evnt.vo.AxEvntStteVo;

/**
 * @author 양정순
 *
 */
public interface AxEvntStteService {

	/**
	 * 자동확장 이벤트 현황 목록조회
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public List<AxEvntStteVo> selectAxEvntStteList(AxEvntStteSearchVo searchVo);

	/**
	 * 자동확장 이벤트 확인처리
	 * @param evntSeq
	 * @throws Exception
	 */
	public void updateAxEvntConfrm(String evntSeq);

	/**
	 * 자동확장 이벤트 확인취소
	 * @param evntSeq
	 * @throws Exception
	 */
	public void updateAxEvntConfrmCncl(String evntSeq);




}
