package ncis.dsb.thrd.evnt.service;

import java.util.List;

import ncis.dsb.thrd.evnt.vo.EvntNtceHistVo;
import ncis.dsb.thrd.evnt.vo.EvntNtceHistSearchVo;

public interface EvntNtceHistService {

	/**
	 * 이벤트 통보이력 목록조회
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public List<EvntNtceHistVo> selectEvntNtceHistList(EvntNtceHistSearchVo searchVo)throws Exception;



}
