/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * VmThrdConfServiceImpl.java
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
import javax.annotation.Resource;
import ncis.dsb.thrd.thrdConf.dao.VmThrdConfDao;
import ncis.dsb.thrd.thrdConf.service.VmThrdConfService;
import ncis.dsb.thrd.thrdConf.vo.VmThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.VmThrdConfVo;
import org.springframework.stereotype.Service;

@Service("vmThrdConfService")
public class VmThrdConfServiceImpl implements VmThrdConfService {

	@Resource(name="vmThrdConfDao")
	private VmThrdConfDao vmThrdConfDao;

	/* 물리서버임계치설정 목록조회
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.thrdConf.service.PmThrdConfService#selectPmThrdConfList(ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo)
	 */
	@Override
	public List<VmThrdConfVo> selectVmThrdConfList(VmThrdConfSearchVo paramVo) throws Exception {
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
		int cnt =vmThrdConfDao.selectVmThrdConfListCount(paramVo);

		if( cnt > 0 ) {
			paramVo.getPaginationInfo().setTotalRecordCount(cnt);	// 페이지 처리위한 count
			return  vmThrdConfDao.selectVmThrdConfList(paramVo);
		}
		return null;
	}

}
