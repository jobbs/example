/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename WordDicaryService.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.worddicary.service;

import java.util.List;

import ncis.cpt.worddicary.vo.WordDicarySearchVo;
import ncis.cpt.worddicary.vo.WordDicaryVo;

public interface WordDicaryService {

	/**
	 * 검색 조건에 해당하는 용어사전 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	List<WordDicaryVo> selectWordDicaryList(WordDicarySearchVo searchVo);

	/**
	 * Sequence에 해당하는 용어사전 정보 조회(용어사전 상세 조회)
	 * @param WordDicarySeq
	 * @return
	 */
	WordDicaryVo selecWordDicary(Long WordDicarySeq);

	/**
	 * 용어사전 등록
	 * @param WordDicaryVo 용어사전 내용
	 */
	void insertWordDicary(WordDicaryVo WordDicaryVo);

	/**
	 * 용어사전 업데이트
	 * @param WordDicaryVo	용어사전 내용
	 */
	void updateWordDicary(WordDicaryVo WordDicaryVo);

	/**
	 * 용어사전 삭제
	 * @param WordDicaryVo	용어사전 내용
	 */
	void deleteWordDicary(Long wordSeq);
}
