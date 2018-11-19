package ncis.cpt.opr.req.rsrcreq.dao;

import java.math.BigDecimal;
import java.util.List;

import ncis.cmn.entity.RcNetwkIntfc;
import ncis.cmn.entity.RcVmJob;
import ncis.cmn.entity.RnIp;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqDtlVmVo;
import ncis.cpt.rsrc.com.vo.VmVo;
import ncis.cpt.rsrc.strg.vo.VrDskVo;
import ncis.intfc.ntops.vo.NTopsSendVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("rsrcRcVmDao")
public class RcVmDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 기 생성된 가상서버가 있는지 확인한다.
	 * @param rsrcReqDtlVmVo
	 * @return
	 */
	public VmVo selectPreMakedVmInfo(RsrcReqDtlVmVo rsrcReqDtlVmVo)
	{
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rcvm.selectPreMakedVmInfo",rsrcReqDtlVmVo);
	}

	/**
	 * nTops 결과전송 정보를 조회한다.
	 * @param rsrcReqNo
	 * @return
	 */
	public NTopsSendVo selectNTopsSendInfo(String rsrcReqNo) {
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rcvm.selectNTopsSendInfo", rsrcReqNo);
	}

	/**
	 * 가상서버정보를 update한다.
	 *
	 * @param preMakedVm
	 */
	public void updateManualCreRcVm(VmVo preMakedVm)
	{
		sqlSession.update("ncis.sql.cpt.opr.req.rcvm.updateManualCreRcVm", preMakedVm);
	}

	/**
	 * @param vmSeq
	 * @param useJobId
	 */
	public void insertRcVmJob(BigDecimal vmSeq, String jobId)
	{
		RcVmJob tmp = new RcVmJob();
		tmp.setVmSeq(vmSeq);
		tmp.setJobId(jobId);

		sqlSession.insert("ncis.sql.cpt.opr.req.rcvm.insertRcVmJob", tmp);
	}


	/**
	 * 가상서버정보를 update한다.
	 *
	 * @param preMakedVm
	 */
	public void updateManualChgRcVm(VmVo vmVo)
	{
		sqlSession.update("ncis.sql.cpt.opr.req.rcvm.updateManualChgRcVm", vmVo);
	}


	/**
	 * 가상서버정보를 update한다.
	 *
	 * @param preMakedVm
	 */
	public void updateManualRemoveRcVm(VmVo vmVo)
	{
		sqlSession.update("ncis.sql.cpt.opr.req.rcvm.updateManualRemoveRcVm", vmVo);
	}

	/**
	 * @param vmCompId
	 * @return
	 */
	public List<VrDskVo> selectAsgnDiskList(BigDecimal vmSeq)
	{
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rcvm.selectAsgnDiskList",vmSeq);
	}

	/**
	 * @param vmCompId
	 * @return
	 */
	public VmVo selectVmInfoByVmSeq(BigDecimal vmSeq)
	{
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rcvm.selectVmInfoByVmSeq",vmSeq);
	}


	/**
	 * 가상서버정보를 update한다.
	 *
	 * @param preMakedVm
	 */
	public void updateManualRemoveStrgDm(VrDskVo diskVo)
	{
		sqlSession.update("ncis.sql.cpt.opr.req.rcvm.updateManualRemoveStrgDm", diskVo);
	}


	/**
	 * 가상서버정보를 update한다.
	 *
	 * @param preMakedVm
	 */
	public void updateManualRemoveStrgAsgn(VrDskVo diskVo)
	{
		sqlSession.update("ncis.sql.cpt.opr.req.rcvm.updateManualRemoveStrgAsgn", diskVo);
	}
	/**
	 * 가상서버정보를 update한다.
	 *
	 * @param preMakedVm
	 */
	public void updateManualRemoveVrDisk(VrDskVo diskVo)
	{
		sqlSession.update("ncis.sql.cpt.opr.req.rcvm.updateManualRemoveVrDisk", diskVo);
	}

	public List<RcNetwkIntfc> selectVmRcNetwkIntfc(BigDecimal vmSeq)
	{
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rcvm.selectVmRcNetwkIntfc",vmSeq);
	}


	public void updateAllocateRnIp(RnIp rnIp)
	{
		sqlSession.update("ncis.sql.cpt.opr.req.rcvm.updateAllocateRnIp", rnIp);
	}

	public void updateDeleteNetwkIntfc(RcNetwkIntfc intfc)
	{
		sqlSession.update("ncis.sql.cpt.opr.req.rcvm.updateDeleteNetwkIntfc", intfc);
	}

	public void updateReleaseRnIp(RnIp rnIp)
	{
		sqlSession.update("ncis.sql.cpt.opr.req.rcvm.updateReleaseRnIp", rnIp);
	}

	/**
	 * @param vmSeq
	 * @return
	 */
	public int selectHaCnt(BigDecimal vmSeq)
	{
		return sqlSession.selectOne("ncis.sql.cpt.opr.req.rcvm.selectHaCnt",vmSeq);
	}
}
