/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TestServiceImpl.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.test.service;

import javax.annotation.Resource;

import ncis.cmn.entity.CmUsr;
import ncis.cmn.rest.RestSender;
import ncis.cmn.rest.vo.RestHeaders;
import ncis.cmn.service.CommonService;
import ncis.cmn.vo.ProcResultVo;
import ncis.cpt.sys.user.vo.UserVo;
import ncis.test.dao.TestDao;
import ncis.test.vo.ComputingStackVo;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource(name="restSender") RestSender restSender;

	@Resource(name="commonService") CommonService commonService;

	@Resource(name="testDao") TestDao testDao;

	@Override
	public void insertSequenceTest() {
		for( int i = 0; i < 500; i++ ) {
			testDao.insertSequenceTest(i);
		}
	}

	@Override
	public ProcResultVo selectRest() {

		ProcResultVo result = new ProcResultVo();
		try {

		    RestHeaders headers = new RestHeaders();
		    headers.setAreaId("DJ");
		    headers.setZoneId("ZoneId");
		    headers.setManagerId("ManagerId");
		    headers.setNetworkId("NetworkId");


			ResponseEntity<UserVo> user = restSender.send("/ncms/test/rest/user/admin", headers, UserVo.class, HttpMethod.GET);
			result.setData(user.getBody());
		}catch (RestClientException re) {
			result.addMessage(re.getMessage());
			result.setSuccess(false);
		}catch (RuntimeException e) { // NOPMD
			result.addMessage(e.getMessage());
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ProcResultVo insertRest() {

		ProcResultVo result = new ProcResultVo();
		try {

		    RestHeaders headers = new RestHeaders();
            headers.setAreaId("DJ");
            headers.setZoneId("ZoneId");
            headers.setManagerId("ManagerId");
            headers.setNetworkId("NetworkId");

			CmUsr user = new CmUsr();
			user.setUserId("admin");
			user.setUserNm("관리자");

			result = restSender.send("/ncms/test/rest/user", user, getHeaders(), ProcResultVo.class, HttpMethod.POST).getBody();

		}catch (RestClientException re) {
			result.addMessage(re.getMessage());
			result.setSuccess(false);
		}catch (RuntimeException e) { // NOPMD
			result.addMessage(e.getMessage());
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ProcResultVo updateRest() {

		ProcResultVo result = new ProcResultVo();
		try {

		    RestHeaders headers = new RestHeaders();
            headers.setAreaId("DJ");
            headers.setZoneId("ZoneId");
            headers.setManagerId("ManagerId");
            headers.setNetworkId("NetworkId");

			CmUsr user = new CmUsr();
			user.setUserId("admin11");
			user.setUserNm("관리자11");


			result = restSender.send("/ncms/test/rest/user", user, getHeaders(), ProcResultVo.class, HttpMethod.PUT).getBody();
		}catch (RestClientException re) {
			result.addMessage(re.getMessage());
			result.setSuccess(false);
		}catch (RuntimeException e) { // NOPMD
			result.addMessage(e.getMessage());
			result.setSuccess(false);
		}

		return result;

	}

	@Override
	public ProcResultVo deleteRest() {
		ProcResultVo result = new ProcResultVo();
		try {

		    RestHeaders headers = new RestHeaders();
            headers.setAreaId("DJ");
            headers.setZoneId("ZoneId");
            headers.setManagerId("ManagerId");
            headers.setNetworkId("NetworkId");

			result = restSender.send("/ncms/test/rest/user/admin", getHeaders(), ProcResultVo.class, HttpMethod.DELETE).getBody();

		}catch (RestClientException re) {
			result.addMessage(re.getMessage());
			result.setSuccess(false);
		}catch (RuntimeException e) { // NOPMD
			result.addMessage(e.getMessage());
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ProcResultVo selectMachineList() {

		ProcResultVo result = new ProcResultVo();
		try {

		    RestHeaders headers = new RestHeaders();
            headers.setAreaId("DJ");
            headers.setZoneId("ZoneId");
            headers.setManagerId("ManagerId");
            headers.setNetworkId("NetworkId");

			ResponseEntity<ComputingStackVo> computingStack = restSender.send("/machines?manerId=RHEV-01", getHeaders(), ComputingStackVo.class, HttpMethod.GET);
			result.setData(computingStack.getBody());

		}catch (RestClientException re) {
			result.addMessage(re.getMessage());
			result.setSuccess(false);
		}catch (RuntimeException e) { // NOPMD
			result.addMessage(e.getMessage());
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ProcResultVo selectMachine() {

		ProcResultVo result = new ProcResultVo();
		try {

		    RestHeaders headers = new RestHeaders();
            headers.setAreaId("DJ");
            headers.setZoneId("ZoneId");
            headers.setManagerId("ManagerId");
            headers.setNetworkId("NetworkId");

			ResponseEntity<ComputingStackVo> computingStack = restSender.send("/machines?manerId=RHEV-01", getHeaders(), ComputingStackVo.class, HttpMethod.GET);
			result.setData(computingStack.getBody());

		}catch (RestClientException re) {
			result.addMessage(re.getMessage());
			result.setSuccess(false);
		}catch (RuntimeException e) { // NOPMD
			result.addMessage(e.getMessage());
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ProcResultVo selectNtops() {

	    ProcResultVo result = new ProcResultVo();
        try {

            RestHeaders headers = new RestHeaders();
            headers.setAreaId("DJ");
            headers.setZoneId("ZoneId");
            headers.setManagerId("ManagerId");
            headers.setNetworkId("NetworkId");

            ResponseEntity<ComputingStackVo> computingStack = restSender.send("/ifm/openapi/openapi/apisvc/retrieveApiSvc.do?svcid=NTOPCOM001", getHeaders(), ComputingStackVo.class, HttpMethod.GET);
            result.setData(computingStack.getBody());

        }catch (RestClientException re) {
			result.addMessage(re.getMessage());
			result.setSuccess(false);
		}catch (RuntimeException e) { // NOPMD
            result.addMessage(e.getMessage());
            result.setSuccess(false);
        }

        return result;
	}

	private RestHeaders getHeaders() {
	    RestHeaders headers = new RestHeaders();
        headers.setAreaId("DJ");
        headers.setZoneId("ZoneId");
        headers.setManagerId("ManagerId");
        headers.setNetworkId("NetworkId");
        return headers;
	}

	@Override
	public String selectSeqNum(String classfy, String prefix) {
	    return commonService.selectSeqNum(classfy, prefix);
	}

}
