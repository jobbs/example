/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * UsefulDao.java
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

package ncis.dsb.stts.asgnUseful.dao;

import java.util.List;

import ncis.dsb.stts.asgnUseful.vo.UsefulSearchVo;
import ncis.dsb.stts.asgnUseful.vo.UsefulVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("usefulDao")
public class UsefulDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 가상서버 생성 가용량 조회
	 * @param searchVo
	 * @return
	 */
	public List<UsefulVo> selectUsefulList(UsefulSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.asgnUseful.useful.selectUsefulList", searchVo);
	}

	/**
	 * 가상서버 생성 가용량 추가
	 * @param searchVo
	 * @return
	 */
	public List<UsefulVo> selectUsefulAdd(UsefulSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.asgnUseful.useful.selectUsefulAdd", searchVo);
	}

	/**
	 * 가상서버 생성 가용량 조회
	 * @param searchVo
	 * @return
	 */
	public List<UsefulVo> selectUsefulNowList(UsefulSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.asgnUseful.useful.selectUsefulNowList", searchVo);
	}


	/**
	 * 가상서버 생성 가용량 조회
	 * @param searchVo
	 * @return
	 */
	public List<UsefulVo> selectUsefulView(UsefulSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.asgnUseful.useful.selectUsefulView", searchVo);
	}



	/**
	 * 가상서버 생성 가용량 입력 또는 수정
	 * @return
	 */
	public void insertUseful(UsefulVo insertVo){
		sqlSession.selectList("ncis.sql.dsb.stts.asgnUseful.useful.insertUseful", insertVo);
	}

	/**
	 * 가상서버 생성 가용량 삭제
	 */
	public void deleteUseful(UsefulVo vo) throws Exception{
		sqlSession.insert("ncis.sql.dsb.stts.asgnUseful.useful.deleteUseful",vo);
	}

}
