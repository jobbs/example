/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename WordDicaryServiceImpl.java
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
package ncis.cpt.worddicary.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ncis.cmn.dao.CWordDicaryDao;
import ncis.cpt.worddicary.dao.WordDicaryDao;
import ncis.cpt.worddicary.service.WordDicaryService;
import ncis.cpt.worddicary.vo.WordDicarySearchVo;
import ncis.cpt.worddicary.vo.WordDicaryVo;

@Service("wordDicaryService")
public class WordDicaryServiceImpl implements WordDicaryService {

	@Resource(name="cWordDicaryDao") private CWordDicaryDao cWordDicaryDao;
	@Resource(name="wordDicaryDao") private WordDicaryDao wordDicaryDao;

	@Override
	public List<WordDicaryVo> selectWordDicaryList(WordDicarySearchVo searchVo) {

		List<WordDicaryVo> list = null;

		int totalCount = wordDicaryDao.selectWordDicaryTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = wordDicaryDao.selectWordDicaryList(searchVo);
		}
		return list;
	}

	@Override
	public WordDicaryVo selecWordDicary(Long wordSeq) {
		return wordDicaryDao.selectWordDicary(wordSeq);
	}

	@Override
	public void insertWordDicary(WordDicaryVo WordDicaryVo) {
		cWordDicaryDao.insertWordDicary(WordDicaryVo);
	}

	@Override
	public void updateWordDicary(WordDicaryVo WordDicaryVo) {
		cWordDicaryDao.updateWordDicary(WordDicaryVo);
	}

	@Override
	public void deleteWordDicary(Long wordSeq) {
		cWordDicaryDao.deleteWordDicary(wordSeq);
	}

}
