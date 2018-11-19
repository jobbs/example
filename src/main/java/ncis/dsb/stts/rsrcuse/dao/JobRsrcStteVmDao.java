/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * JobRsrcStteVmDao.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 10. 10
 * @lastmodified2016. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.stts.rsrcuse.dao;

import java.util.List;

import ncis.cmn.entity.RnSlb;
import ncis.cmn.entity.RnSlbIp;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.rsrc.atmscl.vo.ServcPodVo;
import ncis.cpt.rsrc.atmscl.vo.ServcVo;
import ncis.dsb.stts.rsrcuse.vo.JobRsrcStteVmSearchVo;
import ncis.dsb.stts.rsrcuse.vo.VmVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("jobRsrcStteVmDao")
public class JobRsrcStteVmDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 업무조회
	 * */
	public JobRsrcStteVmSearchVo selectJobNm(JobRsrcStteVmSearchVo vmSearchVo){

		return sqlSession.selectOne("ncis.sql.dsb.stts.jobRsrcStteVm.selectJobNm",vmSearchVo);
	}

	/**
	 * ip대역 정보 조회
	 * */
	public List<IpBndVo> selectIpBnd(String institutionId){

		return sqlSession.selectList("ncis.sql.dsb.stts.jobRsrcStteVm.selectIpBnd",institutionId);
	}

	/**
	 * 컴퓨팅 건수 조회
	 * */
	public int selectVmTotCnt(JobRsrcStteVmSearchVo vmSearchVo) {

        return sqlSession.selectOne("ncis.sql.dsb.stts.jobRsrcStteVm.selectVmTotCnt", vmSearchVo);

    }

	/**
	 * 컴퓨팅 조회
	 * */
	public List<VmVo> selectVmList(JobRsrcStteVmSearchVo vmSearchVo) {

	        return sqlSession.selectList("ncis.sql.dsb.stts.jobRsrcStteVm.selectVmList", vmSearchVo);

	  }

	/**
	 * SLB 설정정보
	 * */

	 public List<RnSlb> selectSlbList(JobRsrcStteVmSearchVo vmSearchVo) {

	        return sqlSession.selectList("ncis.sql.dsb.stts.jobRsrcStteVm.selectSlbList", vmSearchVo);

	  }

	 /**
		 * SLB 적용대상 정보
		 * */
	 public List<RnSlbIp> selectSlbIpList(JobRsrcStteVmSearchVo vmSearchVo) {

	        return sqlSession.selectList("ncis.sql.dsb.stts.jobRsrcStteVm.selectSlbIpList", vmSearchVo);

	  }

	/**서비스 목록
	 * @param searchVo
	 * @return
	 */
	public List<ServcVo> selectServcList(JobRsrcStteVmSearchVo searchVo) {
		 return sqlSession.selectList("ncis.sql.dsb.stts.jobRsrcStteVm.selectServcList", searchVo);
	}

	/**pod목록
	 * @param searchVo
	 * @return
	 */
	public List<ServcPodVo> selectPodList(JobRsrcStteVmSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.dsb.stts.jobRsrcStteVm.selectPodList", searchVo);
	}

}
