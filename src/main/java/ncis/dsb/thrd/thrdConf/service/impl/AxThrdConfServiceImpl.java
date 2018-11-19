/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * AxThrdConfServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2017. 10. 10
 * @lastmodified2017. 10. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 10. 10   양정순         v1.0             최초생성
 *
 */
package ncis.dsb.thrd.thrdConf.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.dsb.thrd.thrdConf.dao.AxThrdConfDao;
import ncis.dsb.thrd.thrdConf.service.AxThrdConfService;
import ncis.dsb.thrd.thrdConf.vo.AxThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.AxThrdConfVo;
import org.springframework.stereotype.Service;

@Service("axThrdConfService")
public class AxThrdConfServiceImpl implements AxThrdConfService {

	@Resource(name="axThrdConfDao")
	private AxThrdConfDao axThrdConfDao;

	/* 자동확장임계치설정 목록조회
	 * (non-Javadoc)
	 * @see ncis.dsb.thrd.thrdConf.service.PmThrdConfService#selectPmThrdConfList(ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo)
	 */
	@Override
	public List<AxThrdConfVo> selectAxThrdConfList(AxThrdConfSearchVo paramVo) throws Exception {
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

			}else if(len==3){//AX
				paramVo.setGubun("AX");
				paramVo.setInstitutionId(ids[0]);
				paramVo.setJobId(ids[1]);
				paramVo.setServcSeq(ids[2]);
			}
		}
		int cnt =axThrdConfDao.selectAxThrdConfListCount(paramVo);

		if( cnt > 0 ) {
			paramVo.getPaginationInfo().setTotalRecordCount(cnt);	// 페이지 처리위한 count
			return  axThrdConfDao.selectAxThrdConfList(paramVo);
		}
		return null;
	}

}
