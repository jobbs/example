/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename BtchWrkServiceImpl.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.sys.btch.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CCmBtchWrkDao;
import ncis.cmn.service.CommonService;
import ncis.cpt.sys.btch.dao.BtchWrkDao;
import ncis.cpt.sys.btch.service.BtchWrkService;
import ncis.cpt.sys.btch.vo.BtchWrkSearchVo;
import ncis.cpt.sys.btch.vo.BtchWrkVo;

import org.springframework.stereotype.Service;

/**
 * @author 박봉춘
 *
 */
@Service("btchWrkService")
public class BtchWrkServiceImpl implements BtchWrkService{

	@Resource(name="BtchWrkDao") private BtchWrkDao btchwrkDao;
	@Resource(name="cCmBtchWrkDao") private CCmBtchWrkDao cBtchWrkDao;
	@Resource(name="commonService") private CommonService commonService;

	@Override
	public List<BtchWrkVo> selectBtchWrkList(BtchWrkSearchVo searchVo) {

		List<BtchWrkVo> list = null;

		int totalCount = btchwrkDao.selectBtchWrkTotCnt(searchVo);

		if(totalCount > 0){
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = btchwrkDao.selectBtchWrkList(searchVo);
		}

		return list;
	}

	public BtchWrkVo selectBtchWrk(Long btchWrkSeq){
		return btchwrkDao.selectBtchWrk(btchWrkSeq);
	}

	@Override
	public void insertBtchWrk(BtchWrkVo btchWrkVo) {

		btchWrkVo.setExeRsrvDttm("".equals(btchWrkVo.getExeRsrvDttm())?null:btchWrkVo.getExeRsrvDttm());
		btchWrkVo.setStopRsrvDttm("".equals(btchWrkVo.getStopRsrvDttm())?null:btchWrkVo.getStopRsrvDttm());

		cBtchWrkDao.insertCmBtchWrk(btchWrkVo);
	}

	@Override
	public void updateBtchWrk(BtchWrkVo btchWrkVo) {

		btchWrkVo.setExeRsrvDttm("".equals(btchWrkVo.getExeRsrvDttm())?null:btchWrkVo.getExeRsrvDttm());
		btchWrkVo.setStopRsrvDttm("".equals(btchWrkVo.getStopRsrvDttm())?null:btchWrkVo.getStopRsrvDttm());

		cBtchWrkDao.updateCmBtchWrk(btchWrkVo);
	}

	@Override
	public void deleteBtchWrk(Long btchWrkSeq) {
		cBtchWrkDao.deleteCmBtchWrk(btchWrkSeq);
	}

	@Override
	public List<BtchWrkVo> selectBtchWrkListXlsDwnl(BtchWrkSearchVo searchVo) {
		List<BtchWrkVo> list = btchwrkDao.selectBtchWrkListXlsDwnl(searchVo);
		for (BtchWrkVo vo : list) {

			//주기 직접입력 체크
			String cycle = "";
			cycle = vo.getCycle();
			if("write".equals(cycle)){
				vo.setCycleNm(vo.getCycleDirectWrite());
			}
			//시점 체크
			String exeTime = "";
			if( null != vo.getExeTimeMonth() && !"".equals(vo.getExeTimeMonth() )){
				exeTime += vo.getExeTimeMonth() + "월 ";
			}
			if(null != vo.getExeTimeDay() && !"".equals(vo.getExeTimeDay() )){
				exeTime += vo.getExeTimeDay() + "일 ";
			}
			 if( null != vo.getExeTimeHour() && !"".equals(vo.getExeTimeHour() ) ) {
				exeTime += vo.getExeTimeHour() + "시 ";
			}
			 if( null != vo.getExeTimeMinute() && !"".equals(vo.getExeTimeMinute() ) ) {
				exeTime += vo.getExeTimeMinute() + "분 ";
			}

			 //엑셀 출력 설정
			if("C".equals(vo.getTimeType())){
					vo.setCycleExeTime("(주기)" + vo.getCycleNm());
			}
			else if("E".equals(vo.getTimeType())){
				vo.setCycleExeTime("(시점)" + exeTime);
			} else{
				vo.setCycleExeTime("미설정");
			}

		}
		return list;
	}

	public int selectBtchWrkIdCnt(Long btchWrkSeq, String btchWrkId){
		return btchwrkDao.selectBtchWrkIdCnt(btchWrkSeq, btchWrkId);
	}
}
