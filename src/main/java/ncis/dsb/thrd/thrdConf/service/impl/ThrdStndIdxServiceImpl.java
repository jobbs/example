/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ThrdStndIdxServiceImpl.java
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
 *
 */
package ncis.dsb.thrd.thrdConf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.dao.CStProfDao;
import ncis.cmn.dao.CStThresDfltConfDao;
import ncis.cmn.entity.StProf;
import ncis.cmn.entity.StThresDfltConf;
import ncis.cmn.vo.Tree;
import ncis.cmn.vo.TreeNode;
import ncis.dsb.cmn.dao.DsbCmmDao;
import ncis.dsb.thrd.evnt.vo.InstitutionToVmVo;
import ncis.dsb.thrd.evnt.vo.InstitutionToAxVo;
import ncis.dsb.thrd.evnt.vo.RegionToPmVo;
import ncis.dsb.thrd.thrdConf.dao.ThrdStndIdxDao;
import ncis.dsb.thrd.thrdConf.service.ThrdStndIdxService;
import ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxSearchVo;
import ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxVo;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service("thrdStndIdxService")
public class ThrdStndIdxServiceImpl implements ThrdStndIdxService {

	@Resource(name="thrdStndIdxDao")
	private ThrdStndIdxDao thrdStndIdxDao;

	@Resource(name="cStProfDao")
	private CStProfDao cStProfDao;

	@Resource(name="cStThresDfltConfDao")
	private CStThresDfltConfDao cStThresDfltConfDao;

	@Resource(name="dsbCmmDao")
	private DsbCmmDao dsbCmmDao;





	/* 표준 임계치 목록조회
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.thrdConf.service.ThrdStndIdxService#selectThrdStndIdxList(ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxSearchVo)
	 */
	@Override
	public List<ThrdStndIdxVo> selectThrdStndIdxList(ThrdStndIdxSearchVo searchVo) throws Exception {
		List<ThrdStndIdxVo> list = null;
		int totalCount = thrdStndIdxDao.selectThrdStndIdxTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list= thrdStndIdxDao.selectThrdStndIdxList(searchVo);
		}
		return list;
	}

	/* 표준임계치 조회
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.thrdConf.service.ThrdStndIdxService#selectThrdStndIdx(ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxSearchVo)
	 */
	@Override
	public ThrdStndIdxVo selectThrdStndIdx(ThrdStndIdxSearchVo searchVo)
			throws Exception {
		return thrdStndIdxDao.selectThrdStndIdx(searchVo);
	}


	/* 표준 임계치 수정
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.thrdConf.service.ThrdStndIdxService#updateThrdStndIdx(ncis.dsb.thrd.thrdConf.vo.ThrdStndIdxVo)
	 */
	@Override
	public void updateThrdStndIdx(ThrdStndIdxVo vo) throws Exception {
		Long profId = vo.getProfId();
		/** 수정 */
		if(profId!=null){
			deleteThrdStndIdx(profId);
		}
		StProf stProfVo = new StProf();

		BeanUtils.copyProperties(vo, stProfVo);
		cStProfDao.insertStProf(stProfVo);
		profId = stProfVo.getProfId();//insert 한 key

		StThresDfltConf stThresDfltConfVo = new StThresDfltConf();
		stThresDfltConfVo.setProfId(profId);
		stThresDfltConfVo.setIdxItmId(Long.parseLong("0"));//지표항목 : 서버상태
		stThresDfltConfVo.setThresGrdId("01");//임계등급
		stThresDfltConfVo.setCmprStdr(vo.getServerStatCmprStdr());//비교기준
		stThresDfltConfVo.setDfltThresVl(null);//서버는 기준값 없음.
		stThresDfltConfVo.setThresDfltContCnt(vo.getServerStatContCnt());//연속횟수
		cStThresDfltConfDao.insertStThresDfltConf(stThresDfltConfVo); //서버 지표 등록

		stThresDfltConfVo = new StThresDfltConf();
		stThresDfltConfVo.setProfId(profId);
		stThresDfltConfVo.setIdxItmId(Long.parseLong("11"));		//지표항목 : CPU사용률
		stThresDfltConfVo.setThresGrdId("02");						//임계등급  : Critical
		stThresDfltConfVo.setCmprStdr(vo.getCriticalCpuUseRtCmprStdr());	//비교기준
		stThresDfltConfVo.setDfltThresVl(vo.getCriticalCpuUseRtVl());							//서버는 기준값 없음.
		stThresDfltConfVo.setThresDfltContCnt(vo.getCriticalCpuUseRtContCnt());//연속횟수
		cStThresDfltConfDao.insertStThresDfltConf(stThresDfltConfVo); //CPU사용률 Critical

		stThresDfltConfVo = new StThresDfltConf();
		stThresDfltConfVo.setProfId(profId);
		stThresDfltConfVo.setIdxItmId(Long.parseLong("11"));		//지표항목 : CPU사용률
		stThresDfltConfVo.setThresGrdId("03");						//임계등급  : Major
		stThresDfltConfVo.setCmprStdr(vo.getMajorCpuUseRtCmprStdr());	//비교기준
		stThresDfltConfVo.setDfltThresVl(vo.getMajorCpuUseRtVl());							//서버는 기준값 없음.
		stThresDfltConfVo.setThresDfltContCnt(vo.getMajorCpuUseRtContCnt());//연속횟수
		cStThresDfltConfDao.insertStThresDfltConf(stThresDfltConfVo); //CPU사용률 Major

		stThresDfltConfVo = new StThresDfltConf();
		stThresDfltConfVo.setProfId(profId);
		stThresDfltConfVo.setIdxItmId(Long.parseLong("12"));		//지표항목 : CPU가상화율
		stThresDfltConfVo.setThresGrdId("02");						//임계등급  : Critical
		stThresDfltConfVo.setCmprStdr(vo.getCriticalCpuVrlzRtCmprStdr());	//비교기준
		stThresDfltConfVo.setDfltThresVl(vo.getCriticalCpuVrlzRtVl());							//서버는 기준값 없음.
		stThresDfltConfVo.setThresDfltContCnt(vo.getCriticalCpuVrlzRtContCnt());//연속횟수
		cStThresDfltConfDao.insertStThresDfltConf(stThresDfltConfVo); //CPU가상화율 Critical

		stThresDfltConfVo = new StThresDfltConf();
		stThresDfltConfVo.setProfId(profId);
		stThresDfltConfVo.setIdxItmId(Long.parseLong("12"));		//지표항목 : CPU가상화율
		stThresDfltConfVo.setThresGrdId("03");						//임계등급  : Major
		stThresDfltConfVo.setCmprStdr(vo.getMajorCpuVrlzRtCmprStdr());	//비교기준
		stThresDfltConfVo.setDfltThresVl(vo.getMajorCpuVrlzRtVl());							//서버는 기준값 없음.
		stThresDfltConfVo.setThresDfltContCnt(vo.getMajorCpuVrlzRtContCnt());//연속횟수
		cStThresDfltConfDao.insertStThresDfltConf(stThresDfltConfVo); //CPU가상화율 Major

		stThresDfltConfVo = new StThresDfltConf();
		stThresDfltConfVo.setProfId(profId);
		stThresDfltConfVo.setIdxItmId(Long.parseLong("21"));		//지표항목 : Mem사용률
		stThresDfltConfVo.setThresGrdId("02");						//임계등급  : Critical
		stThresDfltConfVo.setCmprStdr(vo.getCriticalMemUseRtCmprStdr());	//비교기준
		stThresDfltConfVo.setDfltThresVl(vo.getCriticalMemUseRtVl());							//서버는 기준값 없음.
		stThresDfltConfVo.setThresDfltContCnt(vo.getCriticalMemUseRtContCnt());//연속횟수
		cStThresDfltConfDao.insertStThresDfltConf(stThresDfltConfVo); //Mem사용률 Critical

		stThresDfltConfVo = new StThresDfltConf();
		stThresDfltConfVo.setProfId(profId);
		stThresDfltConfVo.setIdxItmId(Long.parseLong("21"));		//지표항목 : Mem사용률
		stThresDfltConfVo.setThresGrdId("03");						//임계등급  : Major
		stThresDfltConfVo.setCmprStdr(vo.getMajorMemUseRtCmprStdr());	//비교기준
		stThresDfltConfVo.setDfltThresVl(vo.getMajorMemUseRtVl());							//서버는 기준값 없음.
		stThresDfltConfVo.setThresDfltContCnt(vo.getMajorMemUseRtContCnt());//연속횟수
		cStThresDfltConfDao.insertStThresDfltConf(stThresDfltConfVo); //Mem사용률 Major

		stThresDfltConfVo = new StThresDfltConf();
		stThresDfltConfVo.setProfId(profId);
		stThresDfltConfVo.setIdxItmId(Long.parseLong("22"));		//지표항목 : Mem가상화율
		stThresDfltConfVo.setThresGrdId("02");						//임계등급  : Critical
		stThresDfltConfVo.setCmprStdr(vo.getCriticalMemVrlzRtCmprStdr());	//비교기준
		stThresDfltConfVo.setDfltThresVl(vo.getCriticalMemVrlzRtVl());							//서버는 기준값 없음.
		stThresDfltConfVo.setThresDfltContCnt(vo.getCriticalMemVrlzRtContCnt());//연속횟수
		cStThresDfltConfDao.insertStThresDfltConf(stThresDfltConfVo); //Mem가상화율 Critical

		stThresDfltConfVo = new StThresDfltConf();
		stThresDfltConfVo.setProfId(profId);
		stThresDfltConfVo.setIdxItmId(Long.parseLong("22"));		//지표항목 : Mem가상화율
		stThresDfltConfVo.setThresGrdId("03");						//임계등급  : Major
		stThresDfltConfVo.setCmprStdr(vo.getMajorMemVrlzRtCmprStdr());	//비교기준
		stThresDfltConfVo.setDfltThresVl(vo.getMajorMemVrlzRtVl());							//서버는 기준값 없음.
		stThresDfltConfVo.setThresDfltContCnt(vo.getMajorMemVrlzRtContCnt());//연속횟수
		cStThresDfltConfDao.insertStThresDfltConf(stThresDfltConfVo); //Mem가상화율 Major
	}

	/* 표준임계치 삭제
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.thrdConf.service.ThrdStndIdxService#deleteThrdStndIdx(java.lang.Long)
	 */
	@Override
	public void deleteThrdStndIdx(Long profId) throws Exception {
		int cnt = cStThresDfltConfDao.deleteStThresDfltConf(profId);
		if(cnt<1){
			throw new Exception("삭제 중 에러가 발생했습니다.");
		}
		cnt = cStProfDao.deleteStProf(profId);
		if(cnt<1){
			throw new Exception("삭제 중 에러가 발생했습니다.");
		}

	}
	/* 센터~물리서버 트리구조 조회
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.thrdConf.service.ThrdStndIdxService#selectRegionToPmTree(java.util.Map)
	 */
	@Override
	public Tree<String,RegionToPmVo> selectRegionToPmTree(Map<String, Object> param)throws Exception{

		Tree<String, RegionToPmVo> tree = new Tree<String, RegionToPmVo>(new TreeNode<String,RegionToPmVo>((String)param.get("parentId"),"root",null),false);
		List<TreeNode<String, RegionToPmVo>> a = dsbCmmDao.selectRegionToPmTree(param);
		tree.addChilds(a);
		return tree;

	}
	@Override
	public Tree<String,InstitutionToVmVo> selectInstitutionToVmTree(Map<String, Object> param)throws Exception{

		Tree<String, InstitutionToVmVo> tree = new Tree<String, InstitutionToVmVo>(new TreeNode<String,InstitutionToVmVo>((String)param.get("parentId"),"root",null),false);
		List<TreeNode<String, InstitutionToVmVo>> a = dsbCmmDao.selectInstitutionToVmTree(param);
		tree.addChilds(a);
		return tree;

	}

	@Override
	public Tree<String,InstitutionToAxVo> selectInstitutionToAxTree(Map<String, Object> param)throws Exception{

		Tree<String, InstitutionToAxVo> tree = new Tree<String, InstitutionToAxVo>(new TreeNode<String,InstitutionToAxVo>((String)param.get("parentId"),"root",null),false);
		List<TreeNode<String, InstitutionToAxVo>> a = dsbCmmDao.selectInstitutionToAxTree(param);
		tree.addChilds(a);
		return tree;

	}

	
	// 2017.10.31 온나라 테스트
	@Override
	public Tree<String, RegionToPmVo> selectRegionToPmTreeByOnnara(	Map<String, Object> param) throws Exception {
		Tree<String, RegionToPmVo> tree = new Tree<String, RegionToPmVo>(new TreeNode<String,RegionToPmVo>((String)param.get("parentId"),"root",null),false);
		List<TreeNode<String, RegionToPmVo>> a = dsbCmmDao.selectRegionToPmTreeByOnnara(param);
		tree.addChilds(a);
		return tree;
	}

	@Override
	public Tree<String, InstitutionToVmVo> selectInstitutionToVmTreeByOnnara(Map<String, Object> param) throws Exception {
		Tree<String, InstitutionToVmVo> tree = new Tree<String, InstitutionToVmVo>(new TreeNode<String,InstitutionToVmVo>((String)param.get("parentId"),"root",null),false);
		List<TreeNode<String, InstitutionToVmVo>> a = dsbCmmDao.selectInstitutionToVmTreeByOnnara(param);
		tree.addChilds(a);
		return tree;
	}


}
