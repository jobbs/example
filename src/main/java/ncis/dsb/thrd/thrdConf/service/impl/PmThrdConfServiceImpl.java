/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * PmThrdConfServiceImpl.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   김동훈         v1.0             최초생성
 * 2017. 06. 10   양정순         v2.0             자동확장 추가
 *
 */
package ncis.dsb.thrd.thrdConf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.CStDspthConfDao;
import ncis.cmn.dao.CStDspthFormDao;
import ncis.cmn.dao.CStDspthGrdDao;
import ncis.cmn.dao.CStEvntDspthChargerDao;
import ncis.cmn.dao.CStTrgtSrvrThresConfDao;
import ncis.cmn.entity.CmUsr;
import ncis.cpt.sys.user.vo.UserVo;
import ncis.dsb.thrd.thrdConf.dao.PmThrdConfDao;
import ncis.dsb.thrd.thrdConf.service.PmThrdConfService;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfCvo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfDspthVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfPSearchVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfVo;
import ncis.dsb.thrd.thrdConf.vo.UserSearchVo;
import ncis.dsb.thrd.thrdConf.vo.AxThrdConfSearchVo;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service("pmThrdConfService")
@SuppressWarnings({"unchecked","rawtypes"})
public class PmThrdConfServiceImpl implements PmThrdConfService {

	@Resource(name="pmThrdConfDao")
	private PmThrdConfDao pmThrdConfDao;

	@Resource(name="cStEvntDspthChargerDao")
	private CStEvntDspthChargerDao cStEvntDspthChargerDao;

	@Resource(name="cStDspthFormDao")
	private CStDspthFormDao cStDspthFormDao;

	@Resource(name="cStDspthGrdDao")
	private CStDspthGrdDao cStDspthGrdDao;

	@Resource(name="cStDspthConfDao")
	private CStDspthConfDao cStDspthConfDao;

	@Resource(name="cStTrgtSrvrThresConfDao")
	private CStTrgtSrvrThresConfDao cStTrgtSrvrThresConfDao;

	/* 물리서버임계치설정 목록조회
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.thrdConf.service.PmThrdConfService#selectPmThrdConfList(ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo)
	 */
	@Override
	public List<PmThrdConfVo> selectPmThrdConfList(PmThrdConfSearchVo paramVo) throws Exception {
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
				paramVo.setClstrSeq(new Long(ids[4]));
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
		int cnt =pmThrdConfDao.selectPmThrdConfListCount(paramVo);

		if( cnt > 0 ) {
			paramVo.getPaginationInfo().setTotalRecordCount(cnt);	// 페이지 처리위한 count
			return  pmThrdConfDao.selectPmThrdConfList(paramVo);
		}
		return null;
	}

	public PmThrdConfVo selectPmThrdConf(PmThrdConfSearchVo paramVo) throws Exception {
		if(paramVo.getPmSeq()==null){//전체 적용인경우.
			return new PmThrdConfVo();
		}
		List<PmThrdConfVo> list = pmThrdConfDao.selectPmThrdConfList(paramVo);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;

	}

	public PmThrdConfVo selectAxThrdConf(PmThrdConfSearchVo paramVo) throws Exception {
		if(paramVo.getServcSeq()==null){//전체 적용인경우.
			return new PmThrdConfVo();
		}
		List<PmThrdConfVo> list = pmThrdConfDao.selectAxThrdConfList(paramVo);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;

	}

	/**
	 *  통보설정 수정
	 */
	@Override
	public void updateNtceConf(PmThrdConfCvo cvo) throws Exception {

		Long pmSeq = cvo.getPmSeq();
		Long vmSeq = cvo.getVmSeq();
		Long servcSeq = cvo.getServcSeq();
		Long thresTrgtSrvrSeq = cvo.getThresTrgtSrvrSeq();//대상서버ID 추후 seq로 변경해야함.
		String trgtSrvrClCd = cvo.getTrgtSrvrClCd();

		List<String> dspthGrdCdList = cvo.getDspthGrdCdList();
		List<CmUsr> dspthTrgtList = cvo.getDspthTrgtList();
		List<String> dspthTyCdList = cvo.getDspthTyCdList();

		PmThrdConfSearchVo paramVo = new PmThrdConfSearchVo();
		PmThrdConfDspthVo insertVo = new PmThrdConfDspthVo();
		BeanUtils.copyProperties(cvo, paramVo);
		BeanUtils.copyProperties(cvo, insertVo);

		if("02".equals(trgtSrvrClCd)){//물리서버
			//4개 테이블 삭제처리
			//4개테이블 등록
			if(thresTrgtSrvrSeq!=null){
				pmSeq=thresTrgtSrvrSeq;
				paramVo.setPmSeq(pmSeq);
				insertVo.setPmSeq(pmSeq);
			}
			cStEvntDspthChargerDao.deleteStEvntDspthChargerPm(paramVo);//이벤트통보대상자  삭제

			cStDspthFormDao.deleteStDspthFormPm(paramVo);//통보형식 삭제

			cStDspthGrdDao.deleteStDspthGrdPm(paramVo);//통보등급 삭제

			cStDspthConfDao.deleteStDspthConfPm(paramVo);//통보설정 삭제

			cStDspthConfDao.insertStDspthConfPm(insertVo);//통보설정 등록
			for(String dspthGrdCd :dspthGrdCdList){
				insertVo.setDspthGrdCd(dspthGrdCd);
				cStDspthGrdDao.insertStDspthGrdPm(insertVo);//통보등급 등록
			}
			for(CmUsr cmUsr :dspthTrgtList){
				insertVo.setDspthTrgtId(cmUsr.getUserId());
				cStEvntDspthChargerDao.insertStEvntDspthChargerPm(insertVo);
			}
			for(String dspthTyCd :dspthTyCdList){
				insertVo.setDspthTyCd(dspthTyCd);
				cStDspthFormDao.insertStDspthFormPm(insertVo);//통보등급 등록
			}

		}else if("01".equals(trgtSrvrClCd)){//가상서버
			if(thresTrgtSrvrSeq!=null){
				vmSeq=thresTrgtSrvrSeq;
				paramVo.setVmSeq(vmSeq);
				insertVo.setVmSeq(vmSeq);
			}
			cStEvntDspthChargerDao.deleteStEvntDspthChargerVm(paramVo);//이벤트통보대상자  삭제

			cStDspthFormDao.deleteStDspthFormVm(paramVo);//통보형식 삭제

			cStDspthGrdDao.deleteStDspthGrdVm(paramVo);//통보등급 삭제

			cStDspthConfDao.deleteStDspthConfVm(paramVo);//통보설정 삭제

			cStDspthConfDao.insertStDspthConfVm(insertVo);//통보설정 등록
			for(String dspthGrdCd :dspthGrdCdList){
				insertVo.setDspthGrdCd(dspthGrdCd);
				cStDspthGrdDao.insertStDspthGrdVm(insertVo);//통보등급 등록
			}
			for(CmUsr cmUsr :dspthTrgtList){
				insertVo.setDspthTrgtId(cmUsr.getUserId());
				cStEvntDspthChargerDao.insertStEvntDspthChargerVm(insertVo);
			}
			for(String dspthTyCd :dspthTyCdList){
				insertVo.setDspthTyCd(dspthTyCd);
				cStDspthFormDao.insertStDspthFormVm(insertVo);//통보등급 등록
			}
		}else if("03".equals(trgtSrvrClCd)){//자동확장
			if(thresTrgtSrvrSeq!=null){
				servcSeq=thresTrgtSrvrSeq;
				paramVo.setServcSeq(servcSeq);
				insertVo.setServcSeq(servcSeq);
			}
			cStEvntDspthChargerDao.deleteStEvntDspthChargerAx(paramVo);//이벤트통보대상자  삭제

			cStDspthFormDao.deleteStDspthFormAx(paramVo);//통보형식 삭제

			cStDspthGrdDao.deleteStDspthGrdAx(paramVo);//통보등급 삭제

			cStDspthConfDao.deleteStDspthConfAx(paramVo);//통보설정 삭제

			cStDspthConfDao.insertStDspthConfAx(insertVo);//통보설정 등록
			for(String dspthGrdCd :dspthGrdCdList){
				insertVo.setDspthGrdCd(dspthGrdCd);
				cStDspthGrdDao.insertStDspthGrdAx(insertVo);//통보등급 등록
			}
			for(CmUsr cmUsr :dspthTrgtList){
				insertVo.setDspthTrgtId(cmUsr.getUserId());
				cStEvntDspthChargerDao.insertStEvntDspthChargerAx(insertVo);
			}
			for(String dspthTyCd :dspthTyCdList){
				insertVo.setDspthTyCd(dspthTyCd);
				cStDspthFormDao.insertStDspthFormAx(insertVo);//통보등급 등록
			}
		}
	}


	/**
	 *  통보설정 삭제
	 */
	@Override
	public void deleteNtceConf(AxThrdConfSearchVo searchVo) throws Exception {
		String servcSeq = searchVo.getServcSeq();

		PmThrdConfSearchVo paramVo = new PmThrdConfSearchVo();
		if(servcSeq != null && !"".equals(servcSeq)){
			paramVo.setServcSeq(new Long(searchVo.getServcSeq()));
		}
		paramVo.setInstitutionId(searchVo.getInstitutionId());
		paramVo.setJobId(searchVo.getJobId());

		cStEvntDspthChargerDao.deleteStEvntDspthChargerAx(paramVo);//이벤트통보대상자  삭제
		cStDspthFormDao.deleteStDspthFormAx(paramVo);//통보형식 삭제
		cStDspthGrdDao.deleteStDspthGrdAx(paramVo);//통보등급 삭제
		cStDspthConfDao.deleteStDspthConfAx(paramVo);//통보설정 삭제


	}

	/**
	 *  임계치 설정 수정
	 */
	@Override
	public void updateThrdConf(PmThrdConfVo pmThrdConfVo) throws Exception {
		String trgtSrvrClCd = pmThrdConfVo.getTrgtSrvrClCd();
		Long thresTrgtSrvrSeq = pmThrdConfVo.getThresTrgtSrvrSeq();

		if("02".equals(trgtSrvrClCd)){//물리서버
			Long profId = pmThrdConfVo.getProfId();

			if(thresTrgtSrvrSeq!=null){//물리서버를 선택하여 팝업창 호출인경우
				pmThrdConfVo.setPmSeq(thresTrgtSrvrSeq);
			}
			cStTrgtSrvrThresConfDao.deleteStTrgtSrvrThresConfPm(pmThrdConfVo);

			if(profId!=null){//프로파일 선택
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfPmProf(pmThrdConfVo);
			}else{//직접입력
				PmThrdConfVo insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("0");//지표항목 : 서버상태
				insertParam.setThresGrdId("01");//임계등급
				insertParam.setConfCmprStdr(pmThrdConfVo.getServerStatCmprStdr());//비교기준
				insertParam.setThresConfVl(null);//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getServerStatContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfPm(insertParam); //서버 지표 등록

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("11");		//지표항목 : CPU사용률
				insertParam.setThresGrdId("02");						//임계등급  : Critical
				insertParam.setConfCmprStdr(pmThrdConfVo.getCriticalCpuUseRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getCriticalCpuUseRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getCriticalCpuUseRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfPm(insertParam); //CPU사용률 Critical

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("11");		//지표항목 : CPU사용률
				insertParam.setThresGrdId("03");						//임계등급  : Major
				insertParam.setConfCmprStdr(pmThrdConfVo.getMajorCpuUseRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getMajorCpuUseRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getMajorCpuUseRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfPm(insertParam); //CPU사용률 Major

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("12");		//지표항목 : CPU가상화율
				insertParam.setThresGrdId("02");						//임계등급  : Critical
				insertParam.setConfCmprStdr(pmThrdConfVo.getCriticalCpuVrlzRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getCriticalCpuVrlzRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getCriticalCpuVrlzRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfPm(insertParam); //CPU가상화율 Critical

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("12");		//지표항목 : CPU가상화율
				insertParam.setThresGrdId("03");						//임계등급  : Major
				insertParam.setConfCmprStdr(pmThrdConfVo.getMajorCpuVrlzRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getMajorCpuVrlzRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getMajorCpuVrlzRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfPm(insertParam); //CPU가상화율 Major

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("21");		//지표항목 : Mem사용률
				insertParam.setThresGrdId("02");						//임계등급  : Critical
				insertParam.setConfCmprStdr(pmThrdConfVo.getCriticalMemUseRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getCriticalMemUseRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getCriticalMemUseRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfPm(insertParam); //Mem사용률 Critical

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("21");		//지표항목 : Mem사용률
				insertParam.setThresGrdId("03");						//임계등급  : Major
				insertParam.setConfCmprStdr(pmThrdConfVo.getMajorMemUseRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getMajorMemUseRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getMajorMemUseRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfPm(insertParam); //Mem사용률 Major

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("22");		//지표항목 : Mem가상화율
				insertParam.setThresGrdId("02");						//임계등급  : Critical
				insertParam.setConfCmprStdr(pmThrdConfVo.getCriticalMemVrlzRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getCriticalMemVrlzRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getCriticalMemVrlzRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfPm(insertParam); //Mem가상화율 Critical

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("22");		//지표항목 : Mem가상화율
				insertParam.setThresGrdId("03");						//임계등급  : Major
				insertParam.setConfCmprStdr(pmThrdConfVo.getMajorMemVrlzRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getMajorMemVrlzRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getMajorMemVrlzRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfPm(insertParam); //Mem가상화율 Major
			}
		}else if("01".equals(trgtSrvrClCd)){//가상서버
			Long profId = pmThrdConfVo.getProfId();

			if(thresTrgtSrvrSeq!=null){//물리서버를 선택하여 팝업창 호출인경우
				pmThrdConfVo.setVmSeq(thresTrgtSrvrSeq);
			}
			cStTrgtSrvrThresConfDao.deleteStTrgtSrvrThresConfVm(pmThrdConfVo);

			if(profId!=null){//프로파일 선택
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfVmProf(pmThrdConfVo);
			}else{//직접입력
				PmThrdConfVo insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("0");//지표항목 : 서버상태
				insertParam.setThresGrdId("01");//임계등급
				insertParam.setConfCmprStdr(pmThrdConfVo.getServerStatCmprStdr());//비교기준
				insertParam.setThresConfVl(null);//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getServerStatContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfVm(insertParam); //서버 지표 등록

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("11");		//지표항목 : CPU사용률
				insertParam.setThresGrdId("02");						//임계등급  : Critical
				insertParam.setConfCmprStdr(pmThrdConfVo.getCriticalCpuUseRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getCriticalCpuUseRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getCriticalCpuUseRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfVm(insertParam); //CPU사용률 Critical

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("11");		//지표항목 : CPU사용률
				insertParam.setThresGrdId("03");						//임계등급  : Major
				insertParam.setConfCmprStdr(pmThrdConfVo.getMajorCpuUseRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getMajorCpuUseRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getMajorCpuUseRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfVm(insertParam); //CPU사용률 Major

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("12");		//지표항목 : CPU가상화율
				insertParam.setThresGrdId("02");						//임계등급  : Critical
				insertParam.setConfCmprStdr(pmThrdConfVo.getCriticalCpuVrlzRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getCriticalCpuVrlzRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getCriticalCpuVrlzRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfVm(insertParam); //CPU가상화율 Critical

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("12");		//지표항목 : CPU가상화율
				insertParam.setThresGrdId("03");						//임계등급  : Major
				insertParam.setConfCmprStdr(pmThrdConfVo.getMajorCpuVrlzRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getMajorCpuVrlzRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getMajorCpuVrlzRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfVm(insertParam); //CPU가상화율 Major

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("21");		//지표항목 : Mem사용률
				insertParam.setThresGrdId("02");						//임계등급  : Critical
				insertParam.setConfCmprStdr(pmThrdConfVo.getCriticalMemUseRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getCriticalMemUseRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getCriticalMemUseRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfVm(insertParam); //Mem사용률 Critical

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("21");		//지표항목 : Mem사용률
				insertParam.setThresGrdId("03");						//임계등급  : Major
				insertParam.setConfCmprStdr(pmThrdConfVo.getMajorMemUseRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getMajorMemUseRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getMajorMemUseRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfVm(insertParam); //Mem사용률 Major

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("22");		//지표항목 : Mem가상화율
				insertParam.setThresGrdId("02");						//임계등급  : Critical
				insertParam.setConfCmprStdr(pmThrdConfVo.getCriticalMemVrlzRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getCriticalMemVrlzRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getCriticalMemVrlzRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfVm(insertParam); //Mem가상화율 Critical

				insertParam = new PmThrdConfVo();
				BeanUtils.copyProperties(pmThrdConfVo, insertParam);
				insertParam.setIdxItmId("22");		//지표항목 : Mem가상화율
				insertParam.setThresGrdId("03");						//임계등급  : Major
				insertParam.setConfCmprStdr(pmThrdConfVo.getMajorMemVrlzRtCmprStdr());	//비교기준
				insertParam.setThresConfVl(pmThrdConfVo.getMajorMemVrlzRtVl());							//서버는 기준값 없음.
				insertParam.setConfContCnt(pmThrdConfVo.getMajorMemVrlzRtContCnt());//연속횟수
				cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfVm(insertParam); //Mem가상화율 Major
			}

		}else if("03".equals(trgtSrvrClCd)){//자동확장
			@SuppressWarnings("unused")
			Long profId = pmThrdConfVo.getProfId();

			if(thresTrgtSrvrSeq!=null){//서비스를 선택하여 팝업창 호출인경우
				pmThrdConfVo.setServcSeq(thresTrgtSrvrSeq);
			}
			cStTrgtSrvrThresConfDao.deleteStTrgtSrvrThresConfAx(pmThrdConfVo);

			PmThrdConfVo insertParam = new PmThrdConfVo();
			BeanUtils.copyProperties(pmThrdConfVo, insertParam);
			insertParam.setIdxItmId("0");//지표항목 : Scaled
			insertParam.setThresGrdId("04");//임계등급
			insertParam.setConfCmprStdr(pmThrdConfVo.getServerStatCmprStdr());//비교기준
			insertParam.setThresConfVl(null);//Scaled는 기준값 없음.
			insertParam.setConfContCnt(pmThrdConfVo.getServerStatContCnt());//연속횟수
			cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfAx(insertParam); //서버 지표 등록

			BeanUtils.copyProperties(pmThrdConfVo, insertParam);
			insertParam.setIdxItmId("1");//지표항목 : Warning
			insertParam.setThresGrdId("05");//임계등급
			insertParam.setConfCmprStdr(pmThrdConfVo.getWarningStatCmprStdr());//비교기준
			insertParam.setThresConfVl(null);//Warning는 기준값 없음.
			insertParam.setConfContCnt(pmThrdConfVo.getWarningStatContCnt());//연속횟수
			cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfAx(insertParam); //서버 지표 등록

			BeanUtils.copyProperties(pmThrdConfVo, insertParam);
			insertParam.setIdxItmId("11");		//지표항목 : CPU사용률
			insertParam.setThresGrdId("02");						//임계등급  : Critical
			insertParam.setConfCmprStdr(pmThrdConfVo.getCriticalCpuUseRtCmprStdr());	//비교기준
			insertParam.setThresConfVl(pmThrdConfVo.getCriticalCpuUseRtVl());							//서버는 기준값 없음.
			insertParam.setConfContCnt(pmThrdConfVo.getCriticalCpuUseRtContCnt());//연속횟수
			cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfAx(insertParam); //CPU사용률 Critical

			insertParam = new PmThrdConfVo();
			BeanUtils.copyProperties(pmThrdConfVo, insertParam);
			insertParam.setIdxItmId("11");		//지표항목 : CPU사용률
			insertParam.setThresGrdId("03");						//임계등급  : Major
			insertParam.setConfCmprStdr(pmThrdConfVo.getMajorCpuUseRtCmprStdr());	//비교기준
			insertParam.setThresConfVl(pmThrdConfVo.getMajorCpuUseRtVl());							//서버는 기준값 없음.
			insertParam.setConfContCnt(pmThrdConfVo.getMajorCpuUseRtContCnt());//연속횟수
			cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfAx(insertParam); //CPU사용률 Major

			insertParam = new PmThrdConfVo();
			BeanUtils.copyProperties(pmThrdConfVo, insertParam);
			insertParam.setIdxItmId("21");		//지표항목 : Mem사용률
			insertParam.setThresGrdId("02");						//임계등급  : Critical
			insertParam.setConfCmprStdr(pmThrdConfVo.getCriticalMemUseRtCmprStdr());	//비교기준
			insertParam.setThresConfVl(pmThrdConfVo.getCriticalMemUseRtVl());							//서버는 기준값 없음.
			insertParam.setConfContCnt(pmThrdConfVo.getCriticalMemUseRtContCnt());//연속횟수
			cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfAx(insertParam); //Mem사용률 Critical

			insertParam = new PmThrdConfVo();
			BeanUtils.copyProperties(pmThrdConfVo, insertParam);
			insertParam.setIdxItmId("21");		//지표항목 : Mem사용률
			insertParam.setThresGrdId("03");						//임계등급  : Major
			insertParam.setConfCmprStdr(pmThrdConfVo.getMajorMemUseRtCmprStdr());	//비교기준
			insertParam.setThresConfVl(pmThrdConfVo.getMajorMemUseRtVl());							//서버는 기준값 없음.
			insertParam.setConfContCnt(pmThrdConfVo.getMajorMemUseRtContCnt());//연속횟수
			cStTrgtSrvrThresConfDao.insertStTrgtSrvrThresConfAx(insertParam); //Mem사용률 Major

		}

	}

	/**
	 *  임계치 설정 초기화
	 */
	@Override
	public void deleteThrdConf(AxThrdConfSearchVo searchVo) throws Exception {
		String servcSeq = searchVo.getServcSeq();

		PmThrdConfVo paramVo = new PmThrdConfVo();
		if(servcSeq != null && !"".equals(servcSeq)){
			paramVo.setServcSeq(new Long(searchVo.getServcSeq()));
		}
		paramVo.setInstitutionId(searchVo.getInstitutionId());
		paramVo.setJobId(searchVo.getJobId());
		cStTrgtSrvrThresConfDao.deleteStTrgtSrvrThresConfAx(paramVo);


	}
	/* 임계치 설정 조회
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.thrdConf.service.PmThrdConfService#selectNtceConf(ncis.dsb.thrd.thrdConf.vo.PmThrdConfPSearchVo)
	 */
	public PmThrdConfCvo selectNtceConf(PmThrdConfPSearchVo searchVo) throws Exception{
		PmThrdConfCvo cvo = new PmThrdConfCvo();
		String yn = pmThrdConfDao.selectEqpAuthrDspthYn(searchVo);
		List dspthTyCdList = pmThrdConfDao.selectDspthFormList(searchVo);
		List grdList = pmThrdConfDao.selectDspthGrdList(searchVo);
		List dspthTrgtList = pmThrdConfDao.selectEvntDspthChargerList(searchVo);
		cvo.setEqpAuthrDspthYn(yn);
		cvo.setDspthGrdCdList(grdList);
		cvo.setDspthTrgtList(dspthTrgtList);
		cvo.setDspthTyCdList(dspthTyCdList);

		return cvo;
	}
	/* 사용자목록조회
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.thrdConf.service.PmThrdConfService#selectUserList(ncis.dsb.thrd.thrdConf.vo.UserSearchVo)
	 */
	public List<UserVo> selectUserList(UserSearchVo searchVo){
		return pmThrdConfDao.selectUserList(searchVo);
	}
}
