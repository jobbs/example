/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WebVstrDao.java
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
package ncis.dsb.stts.etc.dao;

import java.util.List;

import ncis.dsb.stts.etc.vo.GcamsSearchVo;
import ncis.dsb.stts.etc.vo.WebReqPageQtyVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("webReqPageIncrDao")
public class WebReqPageIncrDao {

	@Autowired SqlSessionTemplate slaveSqlSession;

	/**
	 * 요청페이지수 조회
	 * */
	public List<WebReqPageQtyVo> selectWebReqPageIncrList(GcamsSearchVo searchVo){
		return slaveSqlSession.selectList("ncis.sql.dsb.stts.gcams.selectWebReqPageIncrList",searchVo);
	}
	/**일자 목록 조회
	 * */
	public List<String> selectWebReqPageIncrDateList(GcamsSearchVo vo){
		return slaveSqlSession.selectList("ncis.sql.dsb.stts.gcams.selectWebReqPageIncrDateList",vo);
	}
	/**
	 * OBJ 목록 조회
	 * */
	public List<String> selectWebReqPageIncrObjList(GcamsSearchVo vo){
		return slaveSqlSession.selectList("ncis.sql.dsb.stts.gcams.selectWebReqPageIncrObjList",vo);
	}
}
