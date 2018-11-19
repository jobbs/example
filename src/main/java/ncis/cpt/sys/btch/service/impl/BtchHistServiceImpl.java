/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchHistServiceImpl.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 12. 9.
 * @lastmodified 2016. 12. 9.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 9.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.service.CommonService;
import ncis.cpt.sys.btch.dao.BtchHistDao;
import ncis.cpt.sys.btch.service.BtchHistService;
import ncis.cpt.sys.btch.vo.BtchHistSearchVo;
import ncis.cpt.sys.btch.vo.BtchHistVo;

import org.springframework.stereotype.Service;

/**
 * @author 박봉춘
 *
 */
@Service("btchHistService")
public class BtchHistServiceImpl implements BtchHistService{

		@Resource(name="BtchHistDao") private BtchHistDao btchhistDao;
		@Resource(name="commonService") private CommonService commonService;

	public List<BtchHistVo> selectBtchHistList(BtchHistSearchVo searchVo) {

		List<BtchHistVo> list = null;

		int totalCount = btchhistDao.selectBtchHistTotCnt(searchVo);

		if(totalCount > 0){
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = btchhistDao.selectBtchHistList(searchVo);
		}

		return list;
	}

	@Override
	public List<BtchHistVo> selectBtchHistListXlsDwnl(BtchHistSearchVo searchVo) {

		return btchhistDao.selectBtchHistListXlsDwnl(searchVo);
	}

	@Override
	public BtchHistVo selectBtchHist(int jobExecutionId) {

		BtchHistVo btchHistVo = new BtchHistVo();
		btchHistVo.setJobExecutionId(jobExecutionId);

		return btchhistDao.selectBtchHist(btchHistVo);
	}

	@Override
	public List<BtchHistVo> selectBtchJobHistList(int jobExecutionId) {

		BtchHistVo btchHistVo = new BtchHistVo();
		btchHistVo.setJobExecutionId(jobExecutionId);

		return btchhistDao.selectBtchJobHistList(btchHistVo);
	}

	@Override
	public BtchHistVo selectBtchHistById(String jobNm) {
		BtchHistVo btchHistVo = new BtchHistVo();
		btchHistVo.setBtchWrkNm(jobNm);

		return btchhistDao.selectBtchHist(btchHistVo);
	}

	@Override
	public String selectExitMessage(long stepExecutionId) {
		return btchhistDao.selectExitMessage(stepExecutionId);
	}

}
