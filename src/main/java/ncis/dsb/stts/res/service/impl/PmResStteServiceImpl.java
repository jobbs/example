/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * EvntStteSearchVo.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 17
 * @lastmodified2016. 10. 17
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 17   김동훈         v1.0             최초생성
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
import ncis.cmn.util.ObjectUtils;
import ncis.dsb.stts.res.dao.PmResStteDao;
import ncis.dsb.stts.res.service.PmResStteService;
import ncis.dsb.stts.res.vo.PmResSearchVo;
import ncis.dsb.stts.res.vo.PmResStteVo;
import ncis.dsb.stts.res.vo.PmTimeResUseRtVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ncis.cmn.util.DateUtil;
@Service("pmResStteService")
public class PmResStteServiceImpl implements PmResStteService {

	 private final Logger logger = LoggerFactory.getLogger(PmResStteServiceImpl.class);

	@Resource(name="pmResStteDao")
	private PmResStteDao pmResStteDao;

	/**
	 * 물리서버 자원현황
	 * */
	@Override
	public List<PmResStteVo> selectPmResStteList(PmResSearchVo searchVo) throws Exception {

		return pmResStteDao.selectPmResStteList(searchVo);
	}

	/**
	* CPU 시간대별 자원사용률
	 */
	@Override
	public List<PmTimeResUseRtVo> selectPmTimeResUseRtCpu(PmResSearchVo searchVo)
			throws Exception {
		return pmResStteDao.selectPmTimeResUseRtCpu(searchVo);
	}
	/**
	* CPU 시간대별 자원사용률
	 */
	@Override
	public List<Map<String,String>> selectPmTimeResUseRtPivot(PmResSearchVo searchVo)
			throws Exception {
		List<Map<String,String>> vmList = selectPmResStteVmList(searchVo);
		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());

		if(ObjectUtils.isEmpty(vmList)){
			return new ArrayList<Map<String,String>>();
		}
		searchVo.setVmList(vmList);
		List<Map<String,String>> list = pmResStteDao.selectPmTimeResUseRtPivot(searchVo);
		return getPivot(searchVo,vmList,list);

	}

	/**
	* CPU 시간대별 자원사용률
	 */
	@Override
	public List<Map<String,String>> selectClstrTimeResUseRtPivot(PmResSearchVo searchVo)
			throws Exception {
		List<Map<String,String>> vmList = selectClstrResStteVmList(searchVo);
		logger.debug("===================searchVo.getColctCd()"+searchVo.getColctCd());

		if(ObjectUtils.isEmpty(vmList)){
			return new ArrayList<Map<String,String>>();
		}
		searchVo.setVmList(vmList);
		List<Map<String,String>> list = pmResStteDao.selectClstrTimeResUseRtPivot(searchVo);
		return getPivot(searchVo,vmList,list);

	}

	private String getObject2String(Object o){
		if(o==null){
			return "";
		}
		return o.toString();
	}

	private List<Map<String,String>> getPivot(PmResSearchVo searchVo, List<Map<String,String>> vmList, List<Map<String,String>> list) throws Exception{
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
			if(searchTrmCd.equals("DI")){
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
			if(searchTrmCd.equals("MM")){
				startMm=0;
				endMm = 0;
			}else if(searchTrmCd.equals("QQ")){
				if(searchQqCd.equals("01")){
					startMm=1;
					endMm = 3;
				}else if(searchQqCd.equals("02")){
					startMm=4;
					endMm = 6;
				}else if(searchQqCd.equals("03")){
					startMm=7;
					endMm = 9;
				}else if(searchQqCd.equals("04")){
					startMm=10;
					endMm = 12;
				}
			}else if(searchTrmCd.equals("HH")){
				if(searchHhCd.equals("01")){
					startMm=1;
					endMm = 6;
				}else if(searchHhCd.equals("02")){
					startMm=7;
					endMm = 12;
				}
			}else if(searchTrmCd.equals("YY")){
				startMm=1;
				endMm = 12;
			}

			for(int i=startMm; i<= endMm; i++){
				String tmp = "";
				String mm = "";
				boolean noLoop = false;

				if(i < 10) tmp = "0"+i;
				else tmp = String.valueOf(i);
				if(searchTrmCd.equals("MM")){
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
	 * 메모리 시간대별 자원 사용률
	 */
	@Override
	public List<PmTimeResUseRtVo> selectPmTimeResUseRtMem(PmResSearchVo searchVo)
			throws Exception {
		return pmResStteDao.selectPmTimeResUseRtMem(searchVo);
	}

	/**
	 * SAN 시간대별 자원 사용률
	 */
	@Override
	public List<PmTimeResUseRtVo> selectPmTimeResUseRtSan(PmResSearchVo searchVo)
			throws Exception {
		return pmResStteDao.selectPmTimeResUseRtSan(searchVo);
	}

	public List<Map<String,String>> selectPmResStteVmList(PmResSearchVo searchVo)
			throws Exception {
		return pmResStteDao.selectPmResStteVmList(searchVo);
	}

	public List<Map<String,String>> selectClstrResStteVmList(PmResSearchVo searchVo)
			throws Exception {
		return pmResStteDao.selectClstrResStteVmList(searchVo);
	}
}
