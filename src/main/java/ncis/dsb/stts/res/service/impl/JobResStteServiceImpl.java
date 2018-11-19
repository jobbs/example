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
package ncis.dsb.stts.res.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.util.DateUtil;
import ncis.cmn.util.ObjectUtils;
import ncis.dsb.stts.res.dao.JobResStteDao;
import ncis.dsb.stts.res.service.JobResStteService;
import ncis.dsb.stts.res.vo.JobResSearchVo;
import ncis.dsb.stts.res.vo.JobResStteVo;
import ncis.dsb.stts.res.vo.JobTimeResUseRtVo;
import ncis.dsb.stts.res.vo.JobVmStteVo;
import ncis.dsb.stts.res.vo.JobAxStteVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("jobResStteService")
public class JobResStteServiceImpl implements JobResStteService {

	private final Logger logger = LoggerFactory.getLogger(JobResStteServiceImpl.class);
	@Resource(name="jobResStteDao")
	private JobResStteDao jobResStteDao;

	/**
	 * 업무 자원현황
	 * */
	@Override
	public List<JobResStteVo> selectJobResStteList(JobResSearchVo searchVo) throws Exception {
		List<JobResStteVo> list = null;
		list = jobResStteDao.selectJobResStteList(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());
		return list;
	}

	public List<JobVmStteVo> selectJobVmStteList(JobResSearchVo searchVo)throws Exception{
		return jobResStteDao.selectJobVmStteList(searchVo);
	}

	public List<JobAxStteVo> selectJobAxStteList(JobResSearchVo searchVo)throws Exception{
		return jobResStteDao.selectJobAxStteList(searchVo);
	}

	/**
	* CPU 시간대별 자원사용률
	 */
	@Override
	public List<JobTimeResUseRtVo> selectJobTimeResUseRtCpu(JobResSearchVo searchVo)
			throws Exception {

		return jobResStteDao.selectJobTimeResUseRtCpu(searchVo);
	}

	/**
	 * 메모리 시간대별 자원 사용률
	 */
	@Override
	public List<JobTimeResUseRtVo> selectJobTimeResUseRtMem(JobResSearchVo searchVo)
			throws Exception {
		return jobResStteDao.selectJobTimeResUseRtMem(searchVo);
	}

	/**
	 * SAN 시간대별 자원 사용률
	 */
	@Override
	public List<JobTimeResUseRtVo> selectJobTimeResUseRtSan(JobResSearchVo searchVo)
			throws Exception {
		return jobResStteDao.selectJobTimeResUseRtSan(searchVo);
	}


	/**
	 * 자원 사용률
	 */
	@Override
	public List<Map<String,String>> selectJobTimeResUseRtPivot(JobResSearchVo searchVo)
			throws Exception {
		List<Map<String,String>> vmList = selectJobResStteVmList(searchVo);
		if(ObjectUtils.isEmpty(vmList)){
			return new ArrayList<Map<String,String>>();
		}
		searchVo.setVmList(vmList);
		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());
		List<Map<String,String>> list = jobResStteDao.selectJobTimeResUseRtPivot(searchVo);
		List<Map<String,String>> pivotList = new ArrayList<Map<String,String>>();
		String searchTrmCd = searchVo.getSearchTrmCd();
		String searchQqCd = searchVo.getSearchQqCd();
		String searchHhCd = searchVo.getSearchHhCd();

		if(searchVo.getColctCd().equals("MI")){
			for(int ii=0; ii<24; ii++){
				String tmp_hour = "";
				String hour = "";
				if(ii < 10) tmp_hour = "0"+ii;
				else tmp_hour = String.valueOf(ii);

				for(int j=0; j<60; j=j+10){
					boolean noLoop = false;
					String tmp_mi = "";
					if(j < 10) tmp_mi = "0"+j;
					else tmp_mi = String.valueOf(j);

					HashMap<String,String> map = new HashMap<String,String>();
					for(int k=0; k<list.size(); k++){
						if(!noLoop){
							Map<String,String> mapDt = list.get(k);
							String dt = mapDt.get("dt");
							String[] parts = dt.split(" ",2);
							String dt_tmp = tmp_hour+":"+tmp_mi;
							if(dt_tmp.equals(parts[1])){
								hour = dt;
								noLoop = true;
								map.put("dt", hour);
								for(Map<String, String> vmMap: vmList){
									map.put(getObject2String(vmMap.get("vm_seq")), getObject2String(mapDt.get( getObject2String(vmMap.get("vm_seq")))));
								}
							}else{
								hour=parts[0]+" "+tmp_hour+":"+tmp_mi;
							}
						}
					}
					if(!noLoop){
						map.put("dt", hour);
						for(Map<String, String> vmMap: vmList){
							map.put(getObject2String(vmMap.get("vm_seq")), "");
						}
					}
					logger.debug("hour===>"+hour);
					pivotList.add(map);
				}
			}
		}else if(searchVo.getColctCd().equals("HH")){
			for(int i=0; i<24; i++){
				String tmp = "";
				String hour = "";
				boolean noLoop = false;
				if(i < 10) tmp = "0"+i;
				else tmp = String.valueOf(i);
				HashMap<String,String> map = new HashMap<String,String>();
				for(int j=0; j<list.size(); j++){
					if(!noLoop){
						Map<String,String> mapDt = list.get(j);

						String dt = mapDt.get("dt");
						String[] parts = dt.split(" ",2);
						if(tmp.equals(parts[1])){
							hour = dt;
							noLoop = true;
							map.put("dt", hour);
							for(Map<String, String> vmMap: vmList){
								map.put(getObject2String(vmMap.get("vm_seq")), getObject2String(mapDt.get( getObject2String(vmMap.get("vm_seq")))));
							}
						}else{
							hour=parts[0]+" "+tmp;
						}
					}
				}
				if(!noLoop){
					map.put("dt", hour);
					for(Map<String, String> vmMap: vmList){
						map.put(getObject2String(vmMap.get("vm_seq")), "");
					}
				}
				logger.debug("hour===>"+hour);
				pivotList.add(map);
			}
		}else if(searchVo.getColctCd().equals("DD")){
			if("DI".equals(searchTrmCd)){
				String getStrtDt = searchVo.getStrtDt().replaceAll("-", "");
			    String endDt = searchVo.getEndDt().replaceAll("-", "");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
				Date strtD =sdf.parse(getStrtDt);
				Date endD =sdf.parse(endDt);
				Calendar strtC = Calendar.getInstance();
				Calendar endC = Calendar.getInstance();
				strtC.setTime(strtD);
				endC.setTime(endD);
				while(strtC.compareTo(endC) != 1){
					String day = DateUtil.dateToString(strtC.getTime(),"yyyyMMdd");
					boolean noLoop = false;
					HashMap<String,String> map = new HashMap<String,String>();
					for(int j=0; j<list.size(); j++){
						if(!noLoop){
							Map<String,String> mapDt = list.get(j);
							String dt = mapDt.get("dt");
							if(day.equals(dt)){
								day = dt;
								noLoop = true;
								map.put("dt", day);
								for(Map<String, String> vmMap: vmList){
									map.put(getObject2String(vmMap.get("vm_seq")), getObject2String(mapDt.get( getObject2String(vmMap.get("vm_seq")))));
								}
							}
						}
					}
					if(!noLoop){
						map.put("dt", day);
						for(Map<String, String> vmMap: vmList){
							map.put(getObject2String(vmMap.get("vm_seq")), "");
						}
					}
					logger.debug("day===>"+day);
					pivotList.add(map);
					strtC.add(Calendar.DATE, 1);
				}
			}else{
				int lastDay = DateUtil.getLastDayOfMonth(Integer.parseInt(searchVo.getYear()),Integer.parseInt(searchVo.getSearchMmCd()));
				logger.debug("searchVo.getSearchMmCd()"+searchVo.getSearchMmCd()+":lastDay"+lastDay);
				for(int i=1; i<= lastDay; i++){
					String tmp = "";
					String day = "";
					boolean noLoop = false;
					if(i < 10) tmp = "0"+i;
					else tmp = String.valueOf(i);
					day=searchVo.getYear()+searchVo.getSearchMmCd()+tmp;
					HashMap<String,String> map = new HashMap<String,String>();
					for(int j=0; j<list.size(); j++){
						if(!noLoop){
							Map<String,String> mapDt = list.get(j);
							String dt = mapDt.get("dt");
							if(day.equals(dt)){
								day = dt;
								noLoop = true;
								map.put("dt", day);
								for(Map<String, String> vmMap: vmList){
									map.put(getObject2String(vmMap.get("vm_seq")), getObject2String(mapDt.get( getObject2String(vmMap.get("vm_seq")))));
								}
							}
						}
					}
					if(!noLoop){
						map.put("dt", day);
						for(Map<String, String> vmMap: vmList){
							map.put(getObject2String(vmMap.get("vm_seq")), "");
						}
					}
					logger.debug("day===>"+day);
					pivotList.add(map);
				}
			}

		}else if(searchVo.getColctCd().equals("MM")){
			int startMm=0;
			int endMm=0;
			if("MM".equals(searchTrmCd)){
				startMm=0;
				endMm = 0;
			}else if("QQ".equals(searchTrmCd)){
				if("01".equals(searchQqCd)){
					startMm=1;
					endMm = 3;
				}else if("02".equals(searchQqCd)){
					startMm=4;
					endMm = 6;
				}else if("03".equals(searchQqCd)){
					startMm=7;
					endMm = 9;
				}else if("04".equals(searchQqCd)){
					startMm=10;
					endMm = 12;
				}
			}else if("HH".equals(searchTrmCd)){
				if("01".equals(searchHhCd)){
					startMm=1;
					endMm = 6;
				}else if("02".equals(searchHhCd)){
					startMm=7;
					endMm = 12;
				}
			}else if("YY".equals(searchTrmCd)){
				startMm=1;
				endMm = 12;
			}

			for(int i=startMm; i<= endMm; i++){
				String tmp = "";
				String mm = "";
				boolean noLoop = false;

				if(i < 10) tmp = "0"+i;
				else tmp = String.valueOf(i);
				if("MM".equals(searchTrmCd)){
					mm=searchVo.getYear()+searchVo.getSearchMmCd();
				}else{
					mm=searchVo.getYear()+tmp;
				}
				HashMap<String,String> map = new HashMap<String,String>();
				for(int j=0; j<list.size(); j++){
					if(!noLoop){
						Map<String,String> mapDt = list.get(j);
						String dt = mapDt.get("dt");
						if(mm.equals(dt)){
							mm = dt;
							noLoop = true;
							map.put("dt", mm);
							for(Map<String, String> vmMap: vmList){
								map.put(getObject2String(vmMap.get("vm_seq")), getObject2String(mapDt.get( getObject2String(vmMap.get("vm_seq")))));
							}
						}
					}
				}
				if(!noLoop){
					map.put("dt", mm);
					for(Map<String, String> vmMap: vmList){
						map.put(getObject2String(vmMap.get("vm_seq")), "");
					}
				}
				logger.debug("mm===>"+mm);
				pivotList.add(map);

			}
		}

		return pivotList;
	}

	/**
	 * 자원 사용률
	 */
	@Override
	public List<Map<String,String>> selectAxTimeResUseRtPivot(JobResSearchVo searchVo)
			throws Exception {
		List<Map<String,String>> podList = selectAxResSttePodList(searchVo);
		if(podList.size() <= 0){
			podList = new ArrayList<Map<String,String>>();
		}
		searchVo.setPodList(podList);
		List<Map<String,String>> list=null;
		list = jobResStteDao.selectAxTimeResUseRtPivot(searchVo);
		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());


		return list;
	}

	private String getObject2String(Object o){
		if(o==null){
			return "";
		}
		return o.toString();
	}

	/**
	 * VmList
	 */
	public List<Map<String,String>> selectJobResStteVmList(JobResSearchVo searchVo)
			throws Exception {
		return jobResStteDao.selectJobResStteVmList(searchVo);
	}

	/**
	 * PodList
	 */
	public List<Map<String,String>> selectAxResSttePodList(JobResSearchVo searchVo)
			throws Exception {
		return jobResStteDao.selectAxResSttePodList(searchVo);
	}
	
	public List<JobVmStteVo> selectJobVmStteListByOnnara(JobResSearchVo searchVo)throws Exception{
		return jobResStteDao.selectJobVmStteListByOnnara(searchVo);
	}

	public List<JobAxStteVo> selectJobAxStteListByOnnara(JobResSearchVo searchVo)throws Exception{
		return jobResStteDao.selectJobAxStteListByOnnara(searchVo);
	}
}
