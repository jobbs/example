/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * ClstResStteServiceImpl.java
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 11. 30
 * @lastmodified2016. 11. 30
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 30   김동훈         v1.0             최초생성
 *
 */

package ncis.dsb.stts.reqPrcssStte.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.exception.CommonException;
import ncis.dsb.stts.reqPrcssStte.dao.CludReqPrcssStteDao;
import ncis.dsb.stts.reqPrcssStte.service.CludReqPrcssStteService;
import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteSearchVo;
import ncis.dsb.stts.reqPrcssStte.vo.ReqPrcssStteVo;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service("cludReqPrcssStteService")
public class CludReqPrcssStteServiceImpl implements CludReqPrcssStteService {

	@Resource(name="cludReqPrcssStteDao")
	private CludReqPrcssStteDao cludReqPrcssStteDao;

	/**
	 * 클라우드 요청 처리현황 목록 조회
	 */
	public List<ReqPrcssStteVo> selectCludReqPrcssStteList(ReqPrcssStteSearchVo searchVo) throws Exception{
		return cludReqPrcssStteDao.selectCludReqPrcssStteList(searchVo);
	}
	/**
	 * 클라우드 요청 처리현황 상세 조회
	 */
	public List<ReqPrcssStteVo> selectCludReqPrcssStteDtl(ReqPrcssStteSearchVo searchVo) throws Exception{
		return cludReqPrcssStteDao.selectCludReqPrcssStteDtl(searchVo);
	}
	/**
	 * 클라우드 요청 처리현황 상세 등록
	 */
	public void insertCludReqPrcssStte(List<ReqPrcssStteVo> list) throws Exception{
		int i=1;
		for(ReqPrcssStteVo vo : list){
			int cnt = cludReqPrcssStteDao.selectSanWithDrawStteCnt(vo);
			if(cnt>0){
				throw new CommonException(i+"행의 데이터는 이미 등록된 데이터입니다.");
			}
			//이미 등록된 데이터가 존재하는지 확인하여 exception
			cludReqPrcssStteDao.insertCludReqPrcssStte(vo);
			i++;
		}
	}
	/**
	 * 클라우드 요청 처리현황 수정
	 */
	public void updateCludReqPrcssStte(List<ReqPrcssStteVo> list) throws Exception{
		ReqPrcssStteVo vo = list.get(0);
		ReqPrcssStteVo copyVo = new ReqPrcssStteVo();
		BeanUtils.copyProperties(vo, copyVo);
		copyVo.setInstitutionId(null);//자원풀 단위로 삭제하기 위해
		deleteCludReqPrcssStte(copyVo);
		insertCludReqPrcssStte(list);
	}
	/**
	 * 클라우드 요청 처리현황 삭제
	 */
	public void deleteCludReqPrcssStte(ReqPrcssStteVo vo) throws Exception{
		cludReqPrcssStteDao.deleteCludReqPrcssStte(vo);
	}
	/**
	 * SAN 제외 현황 조회
	 */
	public List<ReqPrcssStteVo> selectSanWithdrawStte(ReqPrcssStteSearchVo searchVo) throws Exception{
		return cludReqPrcssStteDao.selectSanWithdrawStte(searchVo);
	}
}
