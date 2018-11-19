/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * UsefulServiceImpl.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.asgnUseful.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.dsb.stts.asgnUseful.dao.UsefulDao;
import ncis.dsb.stts.asgnUseful.service.UsefulService;
import ncis.dsb.stts.asgnUseful.vo.UsefulSearchVo;
import ncis.dsb.stts.asgnUseful.vo.UsefulVo;

import org.springframework.stereotype.Service;

@Service("usefulService")
public class UsefulServiceImpl implements UsefulService {

	@Resource(name="usefulDao")
	private UsefulDao usefulDao;

	/**
	 * 가상서버 생성 가용량 조회
	 */
	@Override
	public List<UsefulVo> selectUsefulList(UsefulSearchVo searchVo) throws Exception {
		List<UsefulVo> list = null;
		if(searchVo.getNow() != null && searchVo.getNow().equals("now")){
			list = usefulDao.selectUsefulNowList(searchVo);
			searchVo.getPaginationInfo().setTotalRecordCount(list.size());
		}else{
			list = usefulDao.selectUsefulList(searchVo);
			searchVo.getPaginationInfo().setTotalRecordCount(list.size());
		}
		return list;
	}

	/**
	 * 가상서버 생성 가용량 조회
	 */
	@Override
	public List<UsefulVo> selectUsefulAdd(UsefulSearchVo searchVo) throws Exception {
		List<UsefulVo> list = null;

		list = usefulDao.selectUsefulAdd(searchVo);
		searchVo.getPaginationInfo().setTotalRecordCount(list.size());

		return list;
	}

	/**
	 * 가상서버 생성 가용량 상세조회
	 */
	@Override
	public List<UsefulVo> selectUsefulView(UsefulSearchVo searchVo) throws Exception {
		List<UsefulVo> list = null;
		list = usefulDao.selectUsefulView(searchVo);

		return list;
	}

	/**
	 * 가상서버 생성 가용량 등록 수정
	 */
	@Override
	public void insertUseful(List<UsefulVo> list) throws Exception {
		for(UsefulVo vo : list){
			usefulDao.insertUseful(vo);
		}
	}

	/**
	 * 가상서버 생성 가용량 삭제
	 */
	@Override
	public void deleteUseful(List<UsefulVo> list)throws Exception{
		for(UsefulVo vo : list){
			usefulDao.deleteUseful(vo);
		}
	}

}
