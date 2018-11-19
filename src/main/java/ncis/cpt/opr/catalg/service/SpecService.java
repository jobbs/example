/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SpecService.java
 *
 * @author 송승규
 * @lastmodifier 송승규
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     송승규         v1.0             최초생성
 *
 */
package ncis.cpt.opr.catalg.service;

import java.util.List;

import ncis.cmn.vo.ProcResultVo;
import ncis.cpt.opr.catalg.vo.SpecSvo;
import ncis.cpt.opr.catalg.vo.SpecVo;

/**
 * @author 송승규
 *
 */
public interface SpecService {

	/**
	 * 스펙 목록조회
	 * @param svo
	 * @return SpecSvo
	 */
	public List<SpecVo> selectSpecList(SpecSvo svo);

	/**
	 * 스펙 상세조회
	 * @param svo
	 * @return SpecVo
	 */
	public SpecVo selectSpecDetail(SpecVo vo);

	/**
	 * 스펙 저장
	 * @param svo
	 * @return ProcResultVo
	 */
	public ProcResultVo updateSpecDetail(SpecVo vo) throws Exception;

	/**
	 * 스펙 생성
	 * @param svo
	 * @return ProcResultVo
	 */
	public ProcResultVo insertSpec(SpecVo vo) throws Exception;

	/**
	 * 스펙 삭제 (
	 * @param svo
	 * @return
	 */
	public void deleteSpec(SpecSvo svo) throws Exception;
}
