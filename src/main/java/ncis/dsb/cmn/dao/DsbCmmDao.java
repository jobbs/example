package ncis.dsb.cmn.dao;

import java.util.List;
import java.util.Map;

import ncis.cmn.vo.TreeNode;

import ncis.dsb.cmn.vo.MainSearchVo;
import ncis.dsb.cmn.vo.ManagerSttsVo;
import ncis.dsb.cmn.vo.PmResSttsVo;
import ncis.dsb.cmn.vo.PodResSttsVo;
import ncis.dsb.cmn.vo.RtVo;
import ncis.dsb.cmn.vo.NetTrficVo;
import ncis.dsb.cmn.vo.VmInfoVo;
import ncis.dsb.cmn.vo.PodInfoVo;
import ncis.dsb.thrd.evnt.vo.InstitutionToVmVo;
import ncis.dsb.thrd.evnt.vo.InstitutionToAxVo;
import ncis.dsb.thrd.evnt.vo.RegionToPmVo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dsbCmmDao")
public class DsbCmmDao {

	@Autowired SqlSession sqlSession;


	/**
	 * 물리서버의 Core, Memory, 정보를 조회한다
	 * @param searchVo
	 * @return
	 */
	public PmResSttsVo selectPmResInfo(MainSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectPmResInfo",SearchVo);
	}

	/**
	 * 물리서버의 Core, Memory, 정보를 수집이 안될때 RCPM에서 조회한다
	 * @param searchVo
	 * @return
	 */
	public PmResSttsVo selectRcPmResInfo(MainSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectRcPmResInfo",SearchVo);
	}

	/**
	 * 자동확장의 Core, Memory, 스토리지, 이용기관, 이용업무, Pod수
	 * @param searchVo
	 * @return
	 */
	public PodResSttsVo selectPodResInfo(MainSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectPodResInfo",SearchVo);
	}

	/**
	 * 물리서버의 Core, Memory, 조회 건수
	 * @param searchVo
	 * @return
	 */
	public int selectPmResCnt(MainSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectPmResCnt",SearchVo);
	}

	/**
	 * 이용부처건수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectUseGovDeptCnt(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectUseGovDeptCnt", SearchVo);

	}

	/**
	 * 이용업무 건수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectUseJobCnt(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectUseJobCnt", SearchVo);


	}

	/**
	 * vCore건수조회
	 * @param searchVo
	 * @return
	 */

	public int selectVcoreCnt(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectVcoreCnt", SearchVo);

	}

	/**
	 * 수집이 안될때 RC_VM에서 vCore건수조회
	 * @param searchVo
	 * @return
	 */


	public int selectRcVcoreCnt(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectRcVcoreCnt", SearchVo);

	}

	/**
	 * 10분단위 cpu사용율, 가상화율 조회
	 * @param searchVo
	 * @return
	 */

	public List<RtVo> selectCpuUseRt10(MainSearchVo SearchVo){
		List<RtVo> list=  sqlSession.selectList("ncis.sql.dsb.cmm.selectCpuUseRt10",SearchVo);
		if(list.size() <= 0 ){
			list.add(new RtVo());
		}
		return list;

	}

	/**
	 * 10분단위 메모리 사용율, 가상화율 조회
	 * @param searchVo
	 * @return
	 */

	public List<RtVo> selectMemUseRt10(MainSearchVo SearchVo){
		List<RtVo> list = sqlSession.selectList("ncis.sql.dsb.cmm.selectMemUseRt10",SearchVo);
		if(list.size() <= 0 ){
			list.add(new RtVo());
		}
		return list;
	}


	/**
	 * 10분단위 스토리지 사용율
	 * @param searchVo
	 * @return
	 */

	public List<NetTrficVo> selectNetTrfic10(MainSearchVo SearchVo){
		List<NetTrficVo> list = sqlSession.selectList("ncis.sql.dsb.cmm.selectNetTrfic10",SearchVo);
		if(list.size() <= 0 ){
			list.add(new NetTrficVo());
		}
		return list;
	}


	/**
	 * 매니저 종류별 통계
	 * @param searchVo
	 * @return
	 */

	public List<ManagerSttsVo> selectManagerKndStts(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectManagerKndStts",SearchVo);

	}


	/**
	 * 가상서버 목록조회
	 * @param searchVo
	 * @return
	 */

	public List<VmInfoVo> selectVmList(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectVmList", SearchVo);
		//return null;

	}

	/**
	 * Pod 목록조회
	 * @param searchVo
	 * @return
	 */

	public List<PodInfoVo> selectPodList(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectPodList", SearchVo);
		//return null;

	}
	/**
	 * 가상서버 건수 조회
	 *
	 * @param searchVo
	 * @return
	 */

	public int selectVmTotCnt(MainSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectVmTotCnt", searchVo);
		//return 0;

	}


	/**
	 * 기관별 Core, Memory, 정보를 조회한다
	 * @param searchVo
	 * @return
	 */
	public PmResSttsVo selectPmResInfoInc(MainSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectPmResInfoInc",SearchVo);
	}

	/**
	 * 기관별이용부처건수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectUseGovDeptCntInc(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectUseGovDeptCntInc", SearchVo);

	}

	/**
	 * 기관별이용업무 건수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectUseJobCntInc(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectUseJobCntInc", SearchVo);
	}

	/**
	 * 기관별 vCore건수조회
	 * @param searchVo
	 * @return
	 */

	public int selectVcoreCntInc(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectVcoreCntInc", SearchVo);

	}

	/**
	 * 기관별 vCore건수 여부
	 * @param searchVo
	 * @return
	 */

	public int selectVcoreCntIncCnt(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectVcoreCntIncCnt", SearchVo);

	}

	/**
	 * 기관별 vCore건수 Vm 조회
	 * @param searchVo
	 * @return
	 */

	public int selectVcoreVmCntInc(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectVcoreVmCntInc", SearchVo);

	}


	/**
	 * 기관별 10분단위 cpu사용율, 가상화율 조회
	 * @param searchVo
	 * @return
	 */

	public List<RtVo> selectCpuUseRt10Inc(MainSearchVo SearchVo){
		List<RtVo> list = sqlSession.selectList("ncis.sql.dsb.cmm.selectCpuUseRt10Inc",SearchVo);
		if(list.size() <= 0 ){
			list.add(new RtVo());
		}
		return list;

	}

	/**
	 * 기관별 분단위 메모리 사용율, 가상화율 조회
	 * @param searchVo
	 * @return
	 */

	public List<RtVo> selectMemUseRt10Inc(MainSearchVo SearchVo){
		List<RtVo> list = sqlSession.selectList("ncis.sql.dsb.cmm.selectMemUseRt10Inc",SearchVo);
		if(list.size() <= 0 ){
			list.add(new RtVo());
		}
		return list;
	}


	/**
	 *기관별  10분단위 스토리지 사용율
	 * @param searchVo
	 * @return
	 */

	public List<NetTrficVo> selectNetTrfic10Inc(MainSearchVo SearchVo){
		List<NetTrficVo> list = sqlSession.selectList("ncis.sql.dsb.cmm.selectNetTrfic10Inc",SearchVo);
		if(list.size() <= 0 ){
			list.add(new NetTrficVo());
		}
		return list;
	}


	/**
	 * 기관별 매니저 종류별 통계
	 * @param searchVo
	 * @return
	 */

	public List<ManagerSttsVo> selectManagerKndSttsInc(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectManagerKndSttsInc",SearchVo);

	}


	/**
	 * 기관별 가상서버 목록조회
	 * @param searchVo
	 * @return
	 */

	public List<VmInfoVo> selectVmIncList(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectVmList", SearchVo);
		//return null;

	}

	/**
	 * 기관별 Pod 목록조회
	 * @param searchVo
	 * @return
	 */

	public List<PodInfoVo> selectPodIncList(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectPodList", SearchVo);
		//return null;

	}

	/**
	 * 기관별 가상서버 건수조회
	 * @param searchVo
	 * @return
	 */
	public int selectVmIncTotCnt(MainSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectVmTotCnt", searchVo);
		//return 0;

	}

	/**
	 * 물리서버 트리
	 * @param param
	 * @return
	 */
	public List<TreeNode<String, RegionToPmVo>> selectRegionToPmTree(Map<String, Object> param){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectRegionToPmTree",param);
	}
	/**
	 * 가상서버 트리
	 * @param param
	 * @return
	 */
	public List<TreeNode<String, InstitutionToVmVo>> selectInstitutionToVmTree(Map<String, Object> param){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectInstitutionToVmTree",param);
	}

	/**
	 * 자동확장 트리
	 * @param param
	 * @return
	 */
	public List<TreeNode<String, InstitutionToAxVo>> selectInstitutionToAxTree(Map<String, Object> param){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectInstitutionToAxTree",param);
	}


	/**
	 * 2017.10.31 온나라 전용 코드
	 * @param param
	 * @return
	 */

	public List<TreeNode<String, RegionToPmVo>> selectRegionToPmTreeByOnnara(Map<String, Object> param){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectRegionToPmTreeByOnnara",param);
	}

	public List<TreeNode<String, InstitutionToVmVo>> selectInstitutionToVmTreeByOnnara(Map<String, Object> param){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectInstitutionToVmTreeByOnnara",param);
	}

	/**
	 * 가상서버 목록조회
	 * @param searchVo
	 * @return
	 */

	public List<VmInfoVo> selectVmListByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectVmListByOnnara", SearchVo);
		//return null;

	}

	/**
	 * Pod 목록조회
	 * @param searchVo
	 * @return
	 */

	public List<PodInfoVo> selectPodListByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectPodListByOnnara", SearchVo);
		//return null;

	}

	/**
	 * 물리서버의 Core, Memory, 정보를 수집이 안될때 RCPM에서 조회한다
	 * @param searchVo
	 * @return
	 */
	public PmResSttsVo selectRcPmResInfoByOnnara(MainSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectRcPmResInfoByOnnara",SearchVo);
	}

	/**
	 * 수집이 안될때 RC_VM에서 vCore건수조회
	 * @param searchVo
	 * @return
	 */


	public int selectRcVcoreCntByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectRcVcoreCntByOnnara", SearchVo);

	}

	/**
	 * 이용부처건수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectUseGovDeptCntByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectUseGovDeptCntByOnnara", SearchVo);

	}

	/**
	 * 이용업무 건수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectUseJobCntByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectUseJobCntByOnnara", SearchVo);


	}

	/**
	 * 기관별 가상서버 목록조회
	 * @param searchVo
	 * @return
	 */

	public List<VmInfoVo> selectVmIncListByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectVmIncListByOnnara", SearchVo);
	}

	/**
	 * 기관별 Pod 목록조회
	 * @param searchVo
	 * @return
	 */

	public List<PodInfoVo> selectPodIncListByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectPodListByOnnara", SearchVo);
	}

	/**
	 * 자동확장의 Core, Memory, 스토리지, 이용기관, 이용업무, Pod수
	 * @param searchVo
	 * @return
	 */
	public PodResSttsVo selectPodResInfoByOnnara(MainSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectPodResInfoByOnnara",SearchVo);
	}

	/**
	 * 물리서버의 Core, Memory, 조회 건수
	 * @param searchVo
	 * @return
	 */
	public int selectPmResCntByOnnara(MainSearchVo SearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectPmResCntByOnnara",SearchVo);
	}

	/** 기관별이용부처건수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectUseGovDeptCntIncByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectUseGovDeptCntIncByOnnara", SearchVo);

	}

	/**
	 * 기관별이용업무 건수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectUseJobCntIncByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectUseJobCntIncByOnnara", SearchVo);
	}

	/**
	 * 기관별 vCore건수 Vm 조회
	 * @param searchVo
	 * @return
	 */

	public int selectVcoreVmCntIncByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectOne("ncis.sql.dsb.cmm.selectVcoreVmCntIncByOnnara", SearchVo);

	}


	/**
	 * 기관별 10분단위 cpu사용율, 가상화율 조회
	 * @param searchVo
	 * @return
	 */

	public List<RtVo> selectCpuUseRt10IncByOnnara(MainSearchVo SearchVo){
		List<RtVo> list = sqlSession.selectList("ncis.sql.dsb.cmm.selectCpuUseRt10IncByOnnara",SearchVo);
		if(list.size() <= 0 ){
			list.add(new RtVo());
		}
		return list;

	}

	/**
	 * 기관별 분단위 메모리 사용율, 가상화율 조회
	 * @param searchVo
	 * @return
	 */

	public List<RtVo> selectMemUseRt10IncByOnnara(MainSearchVo SearchVo){
		List<RtVo> list = sqlSession.selectList("ncis.sql.dsb.cmm.selectMemUseRt10IncByOnnara",SearchVo);
		if(list.size() <= 0 ){
			list.add(new RtVo());
		}
		return list;
	}


	/**
	 *기관별  10분단위 스토리지 사용율
	 * @param searchVo
	 * @return
	 */

	public List<NetTrficVo> selectNetTrfic10IncByOnnara(MainSearchVo SearchVo){
		List<NetTrficVo> list = sqlSession.selectList("ncis.sql.dsb.cmm.selectNetTrfic10IncByOnnara",SearchVo);
		if(list.size() <= 0 ){
			list.add(new NetTrficVo());
		}
		return list;
	}

	/**
	 * 10분단위 cpu사용율, 가상화율 조회
	 * @param searchVo
	 * @return
	 */

	public List<RtVo> selectCpuUseRt10ByOnnara(MainSearchVo SearchVo){
		List<RtVo> list=  sqlSession.selectList("ncis.sql.dsb.cmm.selectCpuUseRt10ByOnnara",SearchVo);
		if(list.size() <= 0 ){
			list.add(new RtVo());
		}
		return list;

	}

	/**
	 * 10분단위 메모리 사용율, 가상화율 조회
	 * @param searchVo
	 * @return
	 */

	public List<RtVo> selectMemUseRt10ByOnnara(MainSearchVo SearchVo){
		List<RtVo> list = sqlSession.selectList("ncis.sql.dsb.cmm.selectMemUseRt10ByOnnara",SearchVo);
		if(list.size() <= 0 ){
			list.add(new RtVo());
		}
		return list;
	}


	/**
	 * 10분단위 스토리지 사용율
	 * @param searchVo
	 * @return
	 */

	public List<NetTrficVo> selectNetTrfic10ByOnnara(MainSearchVo SearchVo){
		List<NetTrficVo> list = sqlSession.selectList("ncis.sql.dsb.cmm.selectNetTrfic10ByOnnara",SearchVo);
		if(list.size() <= 0 ){
			list.add(new NetTrficVo());
		}
		return list;
	}

	/**
	 * 매니저 종류별 통계
	 * @param searchVo
	 * @return
	 */

	public List<ManagerSttsVo> selectManagerKndSttsByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectManagerKndSttsByOnnara",SearchVo);

	}

	/**
	 * 기관별 매니저 종류별 통계
	 * @param searchVo
	 * @return
	 */

	public List<ManagerSttsVo> selectManagerKndSttsIncByOnnara(MainSearchVo SearchVo){
		return sqlSession.selectList("ncis.sql.dsb.cmm.selectManagerKndSttsIncByOnnara",SearchVo);

	}

}
