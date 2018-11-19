package ncis.dsb.cmn.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.Resource;

import ncis.cmn.util.DateUtil;
import ncis.cmn.util.PropertiesUtil;
import ncis.dsb.cmn.dao.DsbCmmDao;
import ncis.dsb.cmn.service.DsbCmmService;
import ncis.dsb.cmn.vo.MainCvo;
import ncis.dsb.cmn.vo.MainSearchVo;
import ncis.dsb.cmn.vo.RtVo;
import ncis.dsb.cmn.vo.NetTrficVo;
import ncis.dsb.cmn.vo.VmInfoVo;
import ncis.dsb.cmn.vo.PodInfoVo;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("dsbCmmService")
public class DsbCmmServiceImpl implements DsbCmmService {

	private final Logger logger = LoggerFactory.getLogger(DsbCmmServiceImpl.class);
	@Resource(name="dsbCmmDao")
	private DsbCmmDao dsbCmmDao;

	/**
	 * 메인화면 조회
	 * @param searchVo
	 * @return
	 */

	@SuppressWarnings("unchecked")
	@Override
	public MainCvo selectMainList(MainSearchVo paramVo) throws Exception {
		String id = paramVo.getId();
		paramVo.setTrgtSrvrClCd("02");
		if(id==null || "NIRS".equals(id)){//루트

		}else{
			String[] ids = id.split(",");
			int len = ids.length;
			if(len==1){//리전(센터)
				paramVo.setGubun("REGION");
				paramVo.setRegionId(ids[0]);
			}else if(len==2){//존
				paramVo.setGubun("ZONE");
				paramVo.setRegionId(ids[0]);
				paramVo.setZoneId(ids[1]);
			}else if(len==3){//망
				paramVo.setGubun("NET");
				paramVo.setRegionId(ids[0]);
				paramVo.setZoneId(ids[1]);
				paramVo.setNetId(ids[2]);
			}else if(len==4){//풀
				paramVo.setGubun("RSRC_POOL");
				paramVo.setRegionId(ids[0]);
				paramVo.setZoneId(ids[1]);
				paramVo.setNetId(ids[2]);
				paramVo.setRsrcPoolId(ids[3]);
			}else if(len==5){//클러스터
				paramVo.setGubun("CLSTR");
				paramVo.setRegionId(ids[0]);
				paramVo.setZoneId(ids[1]);
				paramVo.setNetId(ids[2]);
				paramVo.setRsrcPoolId(ids[3]);
				if(isNumber(ids[4])) paramVo.setClstrSeq(new Long(ids[4]));
				else paramVo.setAtmsclNodeId(ids[4]);
			}else if(len==6){//물리서버
				paramVo.setGubun("PM");
				paramVo.setRegionId(ids[0]);
				paramVo.setZoneId(ids[1]);
				paramVo.setNetId(ids[2]);
				paramVo.setRsrcPoolId(ids[3]);
				paramVo.setClstrSeq(new Long(ids[4]));
				paramVo.setPmSeq(new Long(ids[5]));
			}
		}
		/*
		 * 14이전 VM 가져오기
		 */
		String colctDtFull = DateUtil.addMinute("yyyyMMddHHmm", -20);
		String colctDt = colctDtFull.substring(0, 8);
		String colctHour = colctDtFull.substring(8, 10);
		String colctMi = colctDtFull.substring(10, 12);
		paramVo.setColctDt(colctDt);
		paramVo.setColctHour(colctHour);
		paramVo.setColctMi(colctMi);

		MainCvo mainCvo = new MainCvo();

		paramVo.getPaginationInfo().setRecordCountPerPage(15);
		List<VmInfoVo> list=dsbCmmDao.selectVmList(paramVo);
		List<PodInfoVo> listPod=dsbCmmDao.selectPodList(paramVo);

		paramVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count
		paramVo.getPaginationInfo().setRecordCountPerPage(15);

		mainCvo.setVmInfoList(list);
		mainCvo.setPodInfoList(listPod);

		mainCvo.setPmResSttsVo(dsbCmmDao.selectRcPmResInfo(paramVo));
		mainCvo.setPodResSttsVo(dsbCmmDao.selectPodResInfo(paramVo));
        mainCvo.setVcore(dsbCmmDao.selectRcVcoreCnt(paramVo));
		mainCvo.setDept(dsbCmmDao.selectUseGovDeptCnt(paramVo));
		mainCvo.setJob(dsbCmmDao.selectUseJobCnt(paramVo));

		mainCvo.setVmCpuList((List<RtVo>) getMiList(dsbCmmDao.selectCpuUseRt10(paramVo)));
		mainCvo.setVmMemList((List<RtVo>) getMiList(dsbCmmDao.selectMemUseRt10(paramVo)));
		mainCvo.setVmNetTrficList((List<NetTrficVo>) getMiList(dsbCmmDao.selectNetTrfic10(paramVo)));
		mainCvo.setManagerSttsList(dsbCmmDao.selectManagerKndStts(paramVo));

        return  mainCvo;
		//return dsbCmmDao.selectPmResInfo(searchVo);
	}
	/**
	 * 기관별 구성정보
	 *
	 * @param searchVo
	 * @return
	 */

	@SuppressWarnings("unchecked")
	@Override
	public MainCvo selectMainIncList(MainSearchVo paramVo) throws Exception {
		String id = paramVo.getId();
		if(id==null || "NIRS".equals(id)){//루트

		}else{
			String[] ids = id.split(",");
			int len = ids.length;
			if(len==1){//기관(부처)
				paramVo.setGubun("INSTITUTION");
				paramVo.setInstitutionId(ids[0]);
			}else if(len==2){//JOB
				paramVo.setGubun("JOB");
				paramVo.setInstitutionId(ids[0]);
				paramVo.setJobId(ids[1]);
			}else if(len==3){//망
				paramVo.setGubun("VM");
				paramVo.setInstitutionId(ids[0]);
				paramVo.setJobId(ids[1]);
				paramVo.setVmSeq(new Long(ids[2]));
			}
		}
		/*
		 * 14이전 VM 가져오기
		 */
		String colctDtFull = DateUtil.addMinute("yyyyMMddHHmm", -15);
		String colctDt = colctDtFull.substring(0, 8);
		String colctHour = colctDtFull.substring(8, 10);
		String colctMi = colctDtFull.substring(10, 12);
		paramVo.setColctDt(colctDt);
		paramVo.setColctHour(colctHour);
		paramVo.setColctMi(colctMi);

		MainCvo mainCvo = new MainCvo();

		paramVo.getPaginationInfo().setRecordCountPerPage(15);
		List<VmInfoVo> list = dsbCmmDao.selectVmIncList(paramVo);
		List<PodInfoVo> listPod = dsbCmmDao.selectPodIncList(paramVo);
		paramVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count
		mainCvo.setVmInfoList(list);
		mainCvo.setPodInfoList(listPod);


		mainCvo.setPodResSttsVo(dsbCmmDao.selectPodResInfo(paramVo));
		mainCvo.setDept(dsbCmmDao.selectUseGovDeptCntInc(paramVo));
		mainCvo.setJob(dsbCmmDao.selectUseJobCntInc(paramVo));
		mainCvo.setVcore(dsbCmmDao.selectVcoreVmCntInc(paramVo));


		mainCvo.setVmCpuList((List<RtVo>) getMiList(dsbCmmDao.selectCpuUseRt10Inc(paramVo)));//RtVo
		mainCvo.setVmMemList((List<RtVo>) getMiList(dsbCmmDao.selectMemUseRt10Inc(paramVo)));
		mainCvo.setVmNetTrficList((List<NetTrficVo>) getMiList(dsbCmmDao.selectNetTrfic10Inc(paramVo)));//Nt
		mainCvo.setManagerSttsList(dsbCmmDao.selectManagerKndSttsInc(paramVo));

		logger.debug ("cpulist: " + mainCvo.getVmCpuList());

        return  mainCvo;
		//return dsbCmmDao.selectPmResInfo(searchVo);
	}

	private List<?> getMiList(List<?> datas) throws Exception{
		String stMinute = StringUtils.defaultString(PropertiesUtil.getProperty("dashboard.st.minute"), "-80");
		String edMinute = StringUtils.defaultString(PropertiesUtil.getProperty("dashboard.ed.minute"), "-11");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.getDefault());
		String sDtFull = DateUtil.addMinute("yyyyMMddHHmm", Integer.valueOf(stMinute) ); // -80
		PropertiesUtil.getProperty("dashboard.st.minute");
		String sDt = sDtFull.substring(0, 8);
		String sHh = sDtFull.substring(8, 10);
		String sMi = ""+(Integer.parseInt(sDtFull.substring(10, 12))/10*10);
		String strt = sDt+sHh+sMi;

		// 현재, 1, 11, 21에 10분 통계 배치가 수행됨.
		// 10분배치의 수행시간에 따라, edMinute 와 30초에 대한 간격 조정 필요.
		String edBufSec = StringUtils.defaultString(PropertiesUtil.getProperty("dashboard.edbuffer.sec"), "20");

		if (Calendar.getInstance().get(Calendar.SECOND)<Integer.valueOf(edBufSec).intValue()) edMinute = String.valueOf(Integer.valueOf(edMinute).intValue() -1);

		String eDtFull = DateUtil.addMinute("yyyyMMddHHmm",Integer.valueOf(edMinute)); // -20, -11

		String eDt= eDtFull.substring( 0, 8);
		String eHh= eDtFull.substring( 8, 10);
		String eMi= ""+(Integer.parseInt(eDtFull.substring(10, 12))/10*10);
		String end = eDt+eHh+eMi;

		Date sd =sdf.parse(strt);
		Date ed =sdf.parse(end);
		Calendar sc = Calendar.getInstance();
		Calendar ec = Calendar.getInstance();

		sc.setTime(sd);
		ec.setTime(ed);
		List<?> miList = null;
		Object data = datas.get(0);
		Class<? extends Object> dataCls = data.getClass();
		logger.debug("dataCls=>"+dataCls.getName());
		if(dataCls.getName().equals("ncis.dsb.cmn.vo.RtVo")){
			List<RtVo> miListRt = new ArrayList<RtVo>();
			//miList = new ArrayList<RtVo>();
			while(sc.compareTo(ec) != 1){
				RtVo rtVo = new RtVo();
				String hhmi = DateUtil.dateToString(sc.getTime(),"HH:mm");
				String rt = "";
				for(int i=0;i<datas.size();i++) {
						String miVo = ((RtVo) datas.get(i)).getMi();
						if(hhmi.equals(miVo)){
							rt = ((RtVo)datas.get(i)).getRt();
							break;
						}
				}
				rtVo.setMi(hhmi);
				rtVo.setRt(rt);

				miListRt.add(rtVo);
				logger.debug("HH:mm=>"+DateUtil.dateToString(sc.getTime(),"HH:mm") + ", " + rt);

				sc.add(Calendar.MINUTE, 10);
			}
			miList = miListRt;
		}else if(dataCls.getName().equals("ncis.dsb.cmn.vo.NetTrficVo")){
			List<NetTrficVo> miListNetTrfic = new ArrayList<NetTrficVo>();
			//miList = new ArrayList<RtVo>();
			while(sc.compareTo(ec) != 1){
				NetTrficVo netTrficVo = new NetTrficVo();
				String hhmi = DateUtil.dateToString(sc.getTime(),"HH:mm");
				String inTrfic = "";
				String outTrfic = "";
				for(int i=0;i<datas.size();i++) {
						String miVo = ((NetTrficVo) datas.get(i)).getMi();
						if(hhmi.equals(miVo)){
							inTrfic = ((NetTrficVo)datas.get(i)).getAvgInTrfic();
							outTrfic = ((NetTrficVo)datas.get(i)).getAvgOutTrfic();
							break;
						}
				}
				netTrficVo.setMi(hhmi);
				netTrficVo.setAvgInTrfic(inTrfic);
				netTrficVo.setAvgOutTrfic(outTrfic);
				miListNetTrfic.add(netTrficVo);
				logger.debug("HH:mm=>"+DateUtil.dateToString(sc.getTime(),"HH:mm") + ", inTrfic=>" + inTrfic+ ", outTrfic=>" + outTrfic);
				sc.add(Calendar.MINUTE, 10);
			}
			miList = miListNetTrfic;

		}
		return miList;
	}

	private boolean isNumber(String str){
		if(str == null || str.equals(""))
			return false;
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(ch<'0' || ch>'9'){
				return false;
			}
		}
		return true;
	}

	/**
	 * 온나라 전용 메인화면 조회
	 */
	// 자원풀 구성정보
	@SuppressWarnings("unchecked")
	@Override
	public MainCvo selectMainListByOnnara(MainSearchVo paramVo) throws Exception {
		String id = paramVo.getId();
		paramVo.setTrgtSrvrClCd("02");
		if(id==null || "NIRS".equals(id)){//루트

		}else{
			String[] ids = id.split(",");
			int len = ids.length;
			if(len==1){//리전(센터)
				paramVo.setGubun("REGION");
				paramVo.setRegionId(ids[0]);
			}else if(len==2){//존
				paramVo.setGubun("ZONE");
				paramVo.setRegionId(ids[0]);
				paramVo.setZoneId(ids[1]);
			}else if(len==3){//망
				paramVo.setGubun("NET");
				paramVo.setRegionId(ids[0]);
				paramVo.setZoneId(ids[1]);
				paramVo.setNetId(ids[2]);
			}else if(len==4){//풀
				paramVo.setGubun("RSRC_POOL");
				paramVo.setRegionId(ids[0]);
				paramVo.setZoneId(ids[1]);
				paramVo.setNetId(ids[2]);
				paramVo.setRsrcPoolId(ids[3]);
			}else if(len==5){//클러스터
				paramVo.setGubun("CLSTR");
				paramVo.setRegionId(ids[0]);
				paramVo.setZoneId(ids[1]);
				paramVo.setNetId(ids[2]);
				paramVo.setRsrcPoolId(ids[3]);
				if(isNumber(ids[4])) paramVo.setClstrSeq(new Long(ids[4]));
				else paramVo.setAtmsclNodeId(ids[4]);
			}else if(len==6){//물리서버
				paramVo.setGubun("PM");
				paramVo.setRegionId(ids[0]);
				paramVo.setZoneId(ids[1]);
				paramVo.setNetId(ids[2]);
				paramVo.setRsrcPoolId(ids[3]);
				paramVo.setClstrSeq(new Long(ids[4]));
				paramVo.setPmSeq(new Long(ids[5]));
			}
		}
		/*
		 * 14이전 VM 가져오기
		 */
		String colctDtFull = DateUtil.addMinute("yyyyMMddHHmm", -20);
		String colctDt = colctDtFull.substring(0, 8);
		String colctHour = colctDtFull.substring(8, 10);
		String colctMi = colctDtFull.substring(10, 12);
		paramVo.setColctDt(colctDt);
		paramVo.setColctHour(colctHour);
		paramVo.setColctMi(colctMi);

		MainCvo mainCvo = new MainCvo();

		paramVo.getPaginationInfo().setRecordCountPerPage(15);
		List<VmInfoVo> list=dsbCmmDao.selectVmListByOnnara(paramVo);
		List<PodInfoVo> listPod=dsbCmmDao.selectPodListByOnnara(paramVo);

		paramVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count
		paramVo.getPaginationInfo().setRecordCountPerPage(15);

		mainCvo.setVmInfoList(list);
		mainCvo.setPodInfoList(listPod);

		mainCvo.setPmResSttsVo(dsbCmmDao.selectRcPmResInfoByOnnara(paramVo));
		mainCvo.setPodResSttsVo(dsbCmmDao.selectPodResInfoByOnnara(paramVo));
        mainCvo.setVcore(dsbCmmDao.selectRcVcoreCntByOnnara(paramVo));
		mainCvo.setDept(dsbCmmDao.selectUseGovDeptCntByOnnara(paramVo));
		mainCvo.setJob(dsbCmmDao.selectUseJobCntByOnnara(paramVo));

		mainCvo.setVmCpuList((List<RtVo>) getMiList(dsbCmmDao.selectCpuUseRt10ByOnnara(paramVo)));
		mainCvo.setVmMemList((List<RtVo>) getMiList(dsbCmmDao.selectMemUseRt10ByOnnara(paramVo)));
		mainCvo.setVmNetTrficList((List<NetTrficVo>) getMiList(dsbCmmDao.selectNetTrfic10ByOnnara(paramVo)));
		mainCvo.setManagerSttsList(dsbCmmDao.selectManagerKndSttsByOnnara(paramVo));

        return  mainCvo;
		//return dsbCmmDao.selectPmResInfo(searchVo);
	}

	/**
	 * 기관별 구성정보
	 *
	 * @param searchVo
	 * @return
	 */

	@SuppressWarnings("unchecked")
	@Override
	public MainCvo selectMainIncListByOnnara(MainSearchVo paramVo) throws Exception {
		String id = paramVo.getId();
		if(id==null || "NIRS".equals(id)){//루트

		}else{
			String[] ids = id.split(",");
			int len = ids.length;
			if(len==1){//기관(부처)
				paramVo.setGubun("INSTITUTION");
				paramVo.setInstitutionId(ids[0]);
			}else if(len==2){//JOB
				paramVo.setGubun("JOB");
				paramVo.setInstitutionId(ids[0]);
				paramVo.setJobId(ids[1]);
			}else if(len==3){//망
				paramVo.setGubun("VM");
				paramVo.setInstitutionId(ids[0]);
				paramVo.setJobId(ids[1]);
				paramVo.setVmSeq(new Long(ids[2]));
			}
		}
		/*
		 * 14이전 VM 가져오기
		 */
		String colctDtFull = DateUtil.addMinute("yyyyMMddHHmm", -15);
		String colctDt = colctDtFull.substring(0, 8);
		String colctHour = colctDtFull.substring(8, 10);
		String colctMi = colctDtFull.substring(10, 12);
		paramVo.setColctDt(colctDt);
		paramVo.setColctHour(colctHour);
		paramVo.setColctMi(colctMi);

		MainCvo mainCvo = new MainCvo();

		paramVo.getPaginationInfo().setRecordCountPerPage(15);
		List<VmInfoVo> list = dsbCmmDao.selectVmIncListByOnnara(paramVo);
		List<PodInfoVo> listPod = dsbCmmDao.selectPodIncListByOnnara(paramVo);
		paramVo.getPaginationInfo().setTotalRecordCount(list.size());	// 페이지 처리위한 count
		mainCvo.setVmInfoList(list);
		mainCvo.setPodInfoList(listPod);


		mainCvo.setPodResSttsVo(dsbCmmDao.selectPodResInfoByOnnara(paramVo));
		mainCvo.setDept(dsbCmmDao.selectUseGovDeptCntIncByOnnara(paramVo));
		mainCvo.setJob(dsbCmmDao.selectUseJobCntIncByOnnara(paramVo));
		mainCvo.setVcore(dsbCmmDao.selectVcoreVmCntIncByOnnara(paramVo));

		mainCvo.setVmCpuList((List<RtVo>) getMiList(dsbCmmDao.selectCpuUseRt10IncByOnnara(paramVo)));//RtVo
		mainCvo.setVmMemList((List<RtVo>) getMiList(dsbCmmDao.selectMemUseRt10IncByOnnara(paramVo)));
		mainCvo.setVmNetTrficList((List<NetTrficVo>) getMiList(dsbCmmDao.selectNetTrfic10IncByOnnara(paramVo)));//Nt
		mainCvo.setManagerSttsList(dsbCmmDao.selectManagerKndSttsIncByOnnara(paramVo));

		logger.debug ("cpulist: " + mainCvo.getVmCpuList());

        return  mainCvo;
		//return dsbCmmDao.selectPmResInfo(searchVo);
	}
}
