/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * SanAsgnYmDao.java
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

package ncis.dsb.stts.asgn.dao;

import java.util.List;

import ncis.dsb.stts.asgn.vo.SanAsgnYmSearchVo;
import ncis.dsb.stts.asgn.vo.SanAsgnYmVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("sanAsgnYmDao")
public class SanAsgnYmDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 자원 보유 및 할당 현황 상세- SAN 스토리지 조회
	 * @param searchVo
	 * @return
	 */
	public List<SanAsgnYmVo> selectSanAsgnYmList(SanAsgnYmSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.asgn.sanAsgnYm.selectSanAsgnYmList", searchVo);
	}

	/**
	 * 자원 보유 및 할당 현황 상세- SAN 스토리지
	 * @param searchVo
	 * @return
	 */

	public List<SanAsgnYmVo> selectSanAsgnRsrcList(SanAsgnYmSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.asgn.sanAsgnYm.selectSanAsgnRsrcList", searchVo);
	}


	/**
	 *  자원 보유 및 할당 현황 상세- SAN 스토리지
	 * @param searchVo
	 * @return
	 */
	public List<SanAsgnYmVo> selectSanAsgnView(SanAsgnYmSearchVo searchVo){
		return sqlSession.selectList("ncis.sql.dsb.stts.asgn.sanAsgnYm.selectSanAsgnView", searchVo);
	}


	/**
	 * 자원 보유 및 할당 현황 상세- SAN 스토리지 입력 또는 수정
	 * @return
	 */
	public void insertSanAsgn(SanAsgnYmVo insertVo){
		sqlSession.selectList("ncis.sql.dsb.stts.asgn.sanAsgnYm.insertSanAsgn", insertVo);
	}

	/**
	 * 자원 보유 및 할당 현황 상세- SAN 스토리지 삭제
	 */
	public void deleteSanAsgn(SanAsgnYmVo vo) throws Exception{
		sqlSession.insert("ncis.sql.dsb.stts.asgn.sanAsgnYm.deleteSanAsgn",vo);
	}

}
