/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobResStteServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 17
 * @lastmodified2016. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17   양정순         v1.0             최초생성
 *
 */
package ncis.cmn.component.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import ncis.cmn.component.service.MonitorService;
import ncis.cmn.dao.CCmMonitorDao;
import ncis.cmn.util.DateUtil;
import ncis.cmn.util.ObjectUtils;
import ncis.cmn.vo.LineChartVo;
import ncis.cmn.vo.MonitorSearchVo;
import ncis.cpt.rsrc.com.vo.PmVo;
import ncis.cpt.rsrc.com.vo.VmVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("monitorService")
public class MonitorServiceImpl implements MonitorService {

	private final Logger logger = LoggerFactory.getLogger(MonitorServiceImpl.class);
	@Resource(name="monitorDao")
	private CCmMonitorDao monitorDao;

	/**
	 * 자원 사용률
	 */
	@Override
	public List<LineChartVo> selectMonitorVmList(MonitorSearchVo searchVo)
			throws Exception {

		List<LineChartVo> vmList = null;

		vmList = monitorDao.selectVmLineChartList(searchVo);
		if(ObjectUtils.isEmpty(vmList)){
			vmList = new ArrayList<LineChartVo>();
			return null;
		}

		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());

		String searchTrmCd = searchVo.getSearchTrmCd();
		String searchQqCd = searchVo.getSearchQqCd();
		String searchHhCd = searchVo.getSearchHhCd();


		List<LineChartVo> tmpList = null;
		tmpList = new ArrayList<LineChartVo>();
		if(searchVo.getColctCd().equals("MI")
			&& vmList.size() < 24 * 6 ){  // 데이터 개수가 일치하지 않는 경우 빈 데이터를 채우기 위해 동작한다.

			String tmp_date = searchVo.getDate().replaceAll("-", "");
			String tmp_hour = "";
			String tmp_mi = "";
			String timeTmp = null;
			boolean hasVal = false;
			LineChartVo tmpVo = null;
			for(int ii=0; ii<24; ii++){
				if(ii < 10) tmp_hour = "0"+ii;
				else tmp_hour = String.valueOf(ii);

				for(int j=0; j<60; j=j+10){
					hasVal = false;

					if(j < 10) tmp_mi = "0"+j;
					else tmp_mi = String.valueOf(j);

					timeTmp = tmp_date + " " + tmp_hour+":"+tmp_mi;
					for(LineChartVo tmp: vmList){
						if(timeTmp.equals(tmp.getTime())){  // 해당 시간의 수집 데이터가 있으면 추가.
							tmpList.add(tmp);
							hasVal = true;
							break;
						}
					}
					if(!hasVal){   // 해당 시간의 수집 데이터가 없으면 0.0 으로 세팅하여 추가.
						tmpVo = new LineChartVo();
						tmpVo.setTime(timeTmp);
						tmpVo.setCpuUseRatio("0.0");
						tmpVo.setMemUseRatio("0.0");
						tmpVo.setSanUseRatio("0.0");
						tmpVo.setInTrafficUsed("0.00");
						tmpVo.setOutTrafficUsed("0.00");
						tmpList.add(tmpVo);
					}
				}
			}
		}else if(searchVo.getColctCd().equals("HH")
				&& vmList.size() < 24 ){  // 데이터 개수가 일치하지 않는 경우 빈 데이터를 채우기 위해 동작한다.

			String tmp_date = searchVo.getDate().replaceAll("-", "");
			String tmp_hour = "";
			String timeTmp = null;
			boolean hasVal = false;
			LineChartVo tmpVo = null;
			for(int ii=0; ii<24; ii++){
				if(ii < 10) tmp_hour = "0"+ii;
				else tmp_hour = String.valueOf(ii);

				timeTmp = tmp_date + " " + tmp_hour;

				hasVal = false;
				for(LineChartVo tmp: vmList){
					if(timeTmp.equals(tmp.getTime())){  // 해당 시간의 수집 데이터가 있으면 추가.
						tmpList.add(tmp);
						hasVal = true;
						break;
					}
				}
				if(!hasVal){   // 해당 시간의 수집 데이터가 없으면 0.0 으로 세팅하여 추가.
					tmpVo = new LineChartVo();
					tmpVo.setTime(timeTmp);
					tmpVo.setCpuUseRatio("0.0");
					tmpVo.setMemUseRatio("0.0");
					tmpVo.setSanUseRatio("0.0");
					tmpVo.setInTrafficUsed("0.00");
					tmpVo.setOutTrafficUsed("0.00");
					tmpList.add(tmpVo);
				}
			}
		}else if(searchVo.getColctCd().equals("DD")){

			String startDt = null;
			String endDt = null;
			if("DI".equals(searchTrmCd)){
				startDt = searchVo.getStrtDt().replaceAll("-", "");
			    endDt = searchVo.getEndDt().replaceAll("-", "");
			}
			else
			{
				startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), Integer.valueOf(searchVo.getSearchMmCd()), "yyyyMMdd");
				endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), Integer.valueOf(searchVo.getSearchMmCd()), "yyyyMMdd");
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
			Date strtD =sdf.parse(startDt);
			Date endD =sdf.parse(endDt);
			Calendar strtC = Calendar.getInstance();

			Calendar endC = Calendar.getInstance();
			strtC.setTime(strtD);
			endC.setTime(endD);

			int cnt = (int)(DateUtil.diffOfDate(startDt, endDt));
			if(cnt != vmList.size() )
			{
				String timeTmp = null;
				boolean hasVal = false;
				LineChartVo tmpVo = null;

				for(int i = 0 ; i <= cnt ; i++)
				{
					timeTmp = DateUtil.dateToString(strtC.getTime(),"yyyyMMdd");

					hasVal = false;
					for(LineChartVo tmp: vmList){
						if(timeTmp.equals(tmp.getTime())){  // 해당 시간의 수집 데이터가 있으면 추가.
							tmpList.add(tmp);
							hasVal = true;
							break;
						}
					}
					if(!hasVal){   // 해당 시간의 수집 데이터가 없으면 0.0 으로 세팅하여 추가.
						tmpVo = new LineChartVo();
						tmpVo.setTime(timeTmp);
						tmpVo.setCpuUseRatio("0.0");
						tmpVo.setMemUseRatio("0.0");
						tmpVo.setSanUseRatio("0.0");
						tmpVo.setInTrafficUsed("0.00");
						tmpVo.setOutTrafficUsed("0.00");
						tmpList.add(tmpVo);
					}
					strtC.add(Calendar.DATE, 1);
				}
			}
		}else if(searchVo.getColctCd().equals("MM")){

			String startDt = null;
			String endDt = null;
			int cnt = 0;

			if("MM".equals(searchTrmCd)){
				startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), Integer.valueOf(searchVo.getSearchMmCd()), "yyyyMMdd");
				endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), Integer.valueOf(searchVo.getSearchMmCd()), "yyyyMMdd");
				cnt = Integer.valueOf(searchVo.getSearchMmCd()) - Integer.valueOf(searchVo.getSearchMmCd());
			}else if("QQ".equals(searchTrmCd)){
				if("01".equals(searchQqCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 1, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 3, "yyyyMMdd");
				}else if("02".equals(searchQqCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 4, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 6, "yyyyMMdd");
				}else if("03".equals(searchQqCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 7, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 9, "yyyyMMdd");
				}else if("04".equals(searchQqCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 10, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 12, "yyyyMMdd");
				}
				cnt = 3;
			}else if("HH".equals(searchTrmCd)){
				if("01".equals(searchHhCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 1, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 6, "yyyyMMdd");
				}else if("02".equals(searchHhCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 7, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 12, "yyyyMMdd");
				}
				cnt = 6;
			}else if("YY".equals(searchTrmCd)){
				startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 1, "yyyyMMdd");
				endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 12, "yyyyMMdd");
				cnt = 12;
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM", Locale.getDefault());
			Date strtD =sdf.parse(startDt);
			Date endD =sdf.parse(endDt);
			Calendar strtC = Calendar.getInstance();

			Calendar endC = Calendar.getInstance();
			strtC.setTime(strtD);
			endC.setTime(endD);

			if(cnt != vmList.size() )
			{
				String timeTmp = null;
				boolean hasVal = false;
				LineChartVo tmpVo = null;

				for(int i = 0 ; i <= cnt ; i++)
				{
					timeTmp = DateUtil.dateToString(strtC.getTime(),"yyyyMM");

					hasVal = false;
					for(LineChartVo tmp: vmList){
						if(timeTmp.equals(tmp.getTime())){  // 해당 시간의 수집 데이터가 있으면 추가.
							tmpList.add(tmp);
							hasVal = true;
							break;
						}
					}
					if(!hasVal){   // 해당 시간의 수집 데이터가 없으면 0.0 으로 세팅하여 추가.
						tmpVo = new LineChartVo();
						tmpVo.setTime(timeTmp);
						tmpVo.setCpuUseRatio("0.0");
						tmpVo.setMemUseRatio("0.0");
						tmpVo.setSanUseRatio("0.0");
						tmpVo.setInTrafficUsed("0.00");
						tmpVo.setOutTrafficUsed("0.00");
						tmpList.add(tmpVo);
					}
					strtC.add(Calendar.MONTH, 1);
				}
			}
		}
		else
		{
			tmpList.addAll(vmList);
		}

		return tmpList;
	}

	/* (non-Javadoc)
	 * @see ncis.cmn.component.service.MonitorService#selectVmInfo(ncis.cmn.vo.MonitorSearchVo)
	 */
	@Override
	public VmVo selectVmInfo(MonitorSearchVo searchVo)
	{
		return monitorDao.selectVmInfo(searchVo);
	}

	/* (non-Javadoc)
	 * @see ncis.cmn.component.service.MonitorService#selectMonitorPmList(ncis.cmn.vo.MonitorSearchVo)
	 */
	@Override
	public List<LineChartVo> selectMonitorPmList(MonitorSearchVo searchVo) throws Exception
	{
		List<LineChartVo> pmList = null;

		pmList = monitorDao.selectPmLineChartList(searchVo);
		if(ObjectUtils.isEmpty(pmList)){
			return null;
		}

		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());

		String searchTrmCd = searchVo.getSearchTrmCd();
		String searchQqCd = searchVo.getSearchQqCd();
		String searchHhCd = searchVo.getSearchHhCd();


		List<LineChartVo> tmpList = null;
		tmpList = new ArrayList<LineChartVo>();
		if(searchVo.getColctCd().equals("MI")
			&& pmList.size() < 24 * 6 ){  // 데이터 개수가 일치하지 않는 경우 빈 데이터를 채우기 위해 동작한다.

			String tmp_date = searchVo.getDate().replaceAll("-", "");
			String tmp_hour = "";
			String tmp_mi = "";
			String timeTmp = null;
			boolean hasVal = false;
			LineChartVo tmpVo = null;
			for(int ii=0; ii<24; ii++){
				if(ii < 10) tmp_hour = "0"+ii;
				else tmp_hour = String.valueOf(ii);

				for(int j=0; j<60; j=j+10){
					hasVal = false;

					if(j < 10) tmp_mi = "0"+j;
					else tmp_mi = String.valueOf(j);

					timeTmp = tmp_date + " " + tmp_hour+":"+tmp_mi;
					for(LineChartVo tmp: pmList){
						if(timeTmp.equals(tmp.getTime())){  // 해당 시간의 수집 데이터가 있으면 추가.
							tmpList.add(tmp);
							hasVal = true;
							break;
						}
					}
					if(!hasVal){   // 해당 시간의 수집 데이터가 없으면 0.0 으로 세팅하여 추가.
						tmpVo = new LineChartVo();
						tmpVo.setTime(timeTmp);
						tmpVo.setCpuUseRatio("0.0");
						tmpVo.setMemUseRatio("0.0");
						tmpVo.setSanUseRatio("0.0");
						tmpVo.setInTrafficUsed("0.00");
						tmpVo.setOutTrafficUsed("0.00");
						tmpList.add(tmpVo);
					}
				}
			}
		}else if(searchVo.getColctCd().equals("HH")
				&& pmList.size() < 24 ){  // 데이터 개수가 일치하지 않는 경우 빈 데이터를 채우기 위해 동작한다.

			String tmp_date = searchVo.getDate().replaceAll("-", "");
			String tmp_hour = "";
			String timeTmp = null;
			boolean hasVal = false;
			LineChartVo tmpVo = null;
			for(int ii=0; ii<24; ii++){
				if(ii < 10) tmp_hour = "0"+ii;
				else tmp_hour = String.valueOf(ii);

				timeTmp = tmp_date + " " + tmp_hour;

				hasVal = false;
				for(LineChartVo tmp: pmList){
					if(timeTmp.equals(tmp.getTime())){  // 해당 시간의 수집 데이터가 있으면 추가.
						tmpList.add(tmp);
						hasVal = true;
						break;
					}
				}
				if(!hasVal){   // 해당 시간의 수집 데이터가 없으면 0.0 으로 세팅하여 추가.
					tmpVo = new LineChartVo();
					tmpVo.setTime(timeTmp);
					tmpVo.setCpuUseRatio("0.0");
					tmpVo.setMemUseRatio("0.0");
					tmpVo.setSanUseRatio("0.0");
					tmpVo.setInTrafficUsed("0.00");
					tmpVo.setOutTrafficUsed("0.00");
					tmpList.add(tmpVo);
				}
			}
		}else if(searchVo.getColctCd().equals("DD")){

			String startDt = null;
			String endDt = null;
			if("DI".equals(searchTrmCd)){
				startDt = searchVo.getStrtDt().replaceAll("-", "");
			    endDt = searchVo.getEndDt().replaceAll("-", "");
			}
			else
			{
				startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), Integer.valueOf(searchVo.getSearchMmCd()), "yyyyMMdd");
				endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), Integer.valueOf(searchVo.getSearchMmCd()), "yyyyMMdd");
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
			Date strtD =sdf.parse(startDt);
			Date endD =sdf.parse(endDt);
			Calendar strtC = Calendar.getInstance();

			Calendar endC = Calendar.getInstance();
			strtC.setTime(strtD);
			endC.setTime(endD);

			int cnt = (int)(DateUtil.diffOfDate(startDt, endDt));
			if(cnt != pmList.size() )
			{
				String timeTmp = null;
				boolean hasVal = false;
				LineChartVo tmpVo = null;

				for(int i = 0 ; i <= cnt ; i++)
				{
					timeTmp = DateUtil.dateToString(strtC.getTime(),"yyyyMMdd");

					hasVal = false;
					for(LineChartVo tmp: pmList){
						if(timeTmp.equals(tmp.getTime())){  // 해당 시간의 수집 데이터가 있으면 추가.
							tmpList.add(tmp);
							hasVal = true;
							break;
						}
					}
					if(!hasVal){   // 해당 시간의 수집 데이터가 없으면 0.0 으로 세팅하여 추가.
						tmpVo = new LineChartVo();
						tmpVo.setTime(timeTmp);
						tmpVo.setCpuUseRatio("0.0");
						tmpVo.setMemUseRatio("0.0");
						tmpVo.setSanUseRatio("0.0");
						tmpVo.setInTrafficUsed("0.00");
						tmpVo.setOutTrafficUsed("0.00");
						tmpList.add(tmpVo);
					}
					strtC.add(Calendar.DATE, 1);
				}
			}
		}else if(searchVo.getColctCd().equals("MM")){

			String startDt = null;
			String endDt = null;
			int cnt = 0;

			if("MM".equals(searchTrmCd)){
				startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), Integer.valueOf(searchVo.getSearchMmCd()), "yyyyMMdd");
				endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), Integer.valueOf(searchVo.getSearchMmCd()), "yyyyMMdd");
				cnt = Integer.valueOf(searchVo.getSearchMmCd()) - Integer.valueOf(searchVo.getSearchMmCd());
			}else if("QQ".equals(searchTrmCd)){
				if("01".equals(searchQqCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 1, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 3, "yyyyMMdd");
				}else if("02".equals(searchQqCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 4, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 6, "yyyyMMdd");
				}else if("03".equals(searchQqCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 7, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 9, "yyyyMMdd");
				}else if("04".equals(searchQqCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 10, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 12, "yyyyMMdd");
				}
				cnt = 3;
			}else if("HH".equals(searchTrmCd)){
				if("01".equals(searchHhCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 1, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 6, "yyyyMMdd");
				}else if("02".equals(searchHhCd)){
					startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 7, "yyyyMMdd");
					endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 12, "yyyyMMdd");
				}
				cnt = 6;
			}else if("YY".equals(searchTrmCd)){
				startDt = DateUtil.getFirstDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 1, "yyyyMMdd");
				endDt = DateUtil.getLastDayStrOfMonth(Integer.valueOf(searchVo.getYear()), 12, "yyyyMMdd");
				cnt = 12;
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM", Locale.getDefault());
			Date strtD =sdf.parse(startDt);
			Date endD =sdf.parse(endDt);
			Calendar strtC = Calendar.getInstance();

			Calendar endC = Calendar.getInstance();
			strtC.setTime(strtD);
			endC.setTime(endD);

			if(cnt != pmList.size() )
			{
				String timeTmp = null;
				boolean hasVal = false;
				LineChartVo tmpVo = null;

				for(int i = 0 ; i <= cnt ; i++)
				{
					timeTmp = DateUtil.dateToString(strtC.getTime(),"yyyyMM");

					hasVal = false;
					for(LineChartVo tmp: pmList){
						if(timeTmp.equals(tmp.getTime())){  // 해당 시간의 수집 데이터가 있으면 추가.
							tmpList.add(tmp);
							hasVal = true;
							break;
						}
					}
					if(!hasVal){   // 해당 시간의 수집 데이터가 없으면 0.0 으로 세팅하여 추가.
						tmpVo = new LineChartVo();
						tmpVo.setTime(timeTmp);
						tmpVo.setCpuUseRatio("0.0");
						tmpVo.setMemUseRatio("0.0");
						tmpVo.setSanUseRatio("0.0");
						tmpVo.setInTrafficUsed("0.00");
						tmpVo.setOutTrafficUsed("0.00");
						tmpList.add(tmpVo);
					}
					strtC.add(Calendar.MONTH, 1);
				}
			}
		}
		else
		{
			tmpList.addAll( pmList );
		}

		return tmpList;
	}

	/* (non-Javadoc)
	 * @see ncis.cmn.component.service.MonitorService#selectPmInfo(ncis.cmn.vo.MonitorSearchVo)
	 */
	@Override
	public PmVo selectPmInfo(MonitorSearchVo searchVo)
	{
		return monitorDao.selectPmInfo(searchVo);
	}
}
