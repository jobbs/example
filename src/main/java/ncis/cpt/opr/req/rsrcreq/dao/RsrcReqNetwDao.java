/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqNetwDao.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 10.
 * @lastmodified 2016. 10. 10.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 10.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.opr.req.rsrcreq.dao;

import java.util.List;

import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqMngSearchVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkSlbConfIpReqVo;
import ncis.cpt.opr.req.rsrcreq.vo.RsrcReqNetwkVo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.com.vo.VmVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 자원요청상세 -네트워크Dao
 * @author 김봉민
 *
 */
@Repository("rsrcReqNetwDao")
public class RsrcReqNetwDao {

	@Autowired SqlSessionTemplate sqlSession;

	private final Logger logger = LoggerFactory.getLogger(RsrcReqNetwDao.class);
	/**
	 * 자원요청상세_네트워크 정보 조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqNetwkVo> selectRsrcReqNetwkList(RsrcReqMngSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.netwk.selectRsrcReqNetwkList" ,searchVo);
	}


	/**
	 * 자원요청상세_SLB설정 정보  조회
	 * @param searchVo
	 * @return
	 */
	public List<RsrcReqNetwkSlbConfIpReqVo> selectRsrcReqNetwkSlbConfIpReqList(RsrcReqMngSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.netwk.selectRsrcReqNetwkSlbConfIpReqList" ,searchVo);
	}




	/**
	 * SID 조회 ( 요청 부처를 기준으로 네트워크 스위치에 있는 L4 vm를 조회하여 해당 nsSid, nfSid를 조회한다.)
	 * @param searchVo
	 * @return
	 */
	public VmVo selectNetwkSrvcSids(VmSearchVo searchVo){
		List<VmVo> resultList= sqlSession.selectList("ncis.sql.cpt.opr.req.rsrcreq.netwk.selectNetwkSrvcSids" ,searchVo);
		if(resultList != null && resultList.size()>0){
			if(resultList.size()>1){
				logger.warn("NS SID, NF SID는  조회 수 = " +  resultList.size() + ", 부처 ="+ searchVo.getInstitutionId() );
				for(VmVo aVo : resultList){
					logger.warn("NS_SID = "+ aVo.getNsSid() +" , NF_SID="+aVo.getNfSid());
				}
			}
			return resultList.get(0);
		}
		return null;
	}


}
