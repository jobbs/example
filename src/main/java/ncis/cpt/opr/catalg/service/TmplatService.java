/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TmplatService.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 10. 5.
 * @lastmodified 2016. 10. 5.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 5.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.service;

import java.util.List;

import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.opr.catalg.vo.TmplatSwVo;
import ncis.cpt.opr.catalg.vo.TmplatVo;

/**
 * @author 송승규
 *
 */
public interface TmplatService {

	/**
	 * 템플릿목록조회
	 * @param svo
	 * @return
	 */
	public List<TmplatVo> selectTmplatList(TmplatSvo svo);

	/**
	 * 템플릿상세조회
	 * @param vo
	 * @return
	 */
	public TmplatVo selectTmplatDetail(TmplatVo vo);

	/**
	 * 템플릿 사용 수정
	 * @param svo
	 */
	public void updateTmplatUseY(TmplatSvo svo);

	/**
	 * 템플릿 미사용 수정
	 * @param svo
	 */
	public void updateTmplatUseN(TmplatSvo svo);

	/**
	 * 템플릿수정
	 * @param vo
	 * @return
	 */
	public void updateTmplatDetail(TmplatVo vo);

	/**
	 * 소프트웨어 목록조회
	 * @param svo
	 * @return
	 */
	public List<TmplatSwVo> selectSwList(TmplatSvo svo);

	/**
	 * 자원요청상세-가상서버-템플릿 조회
	 * @param vo
	 * @return
	 */
	public List<TmplatVo> selectRrVmTmplatList(TmplatSvo vo);

	/**
	 * 자원요청 가상서버 생성 진행여부  미사용으로 수정
	 * @param svo
	 */
	public void updateRrTmplatRsrcReqInit(String rsrcReqNo);

}
