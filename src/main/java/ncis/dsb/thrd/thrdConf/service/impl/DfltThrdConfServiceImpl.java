/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * DfltThrdConfServiceImpl.java
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

import ncis.dsb.thrd.thrdConf.dao.DfltThrdConfDao;
import ncis.dsb.thrd.thrdConf.service.DfltThrdConfService;

import org.springframework.stereotype.Service;


@Service("dfltThrdConfService")
public class DfltThrdConfServiceImpl implements DfltThrdConfService {

	@Resource(name="dfltThrdConfDao")
	private DfltThrdConfDao dfltThrdConfDao;

	@Override
	public List<Object> selectDfltThrdConfList() throws Exception {

		return dfltThrdConfDao.selectDfltThrdConfList();
	}

}
