/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RoleDao.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.role.dao;

import java.util.List;

import ncis.cpt.sys.role.vo.RoleMenuVo;
import ncis.cpt.sys.role.vo.RoleSearchVo;
import ncis.cpt.sys.role.vo.RoleVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 검색 조건에 해당하는 전체 롤 수
	 * @param searchVo
	 * @return
	 */
	public int selectRoleTotCnt(RoleSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.role.selectRoleTotCnt", searchVo);
	}

    /**
     * @param searchVo
     * @return
     */
    public List<RoleVo> selectRoleAllList(RoleSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.role.selectRoleAllList", searchVo);
    }

	/**
	 * 검색 조건에 해당하는 전체 롤 조회
	 * @param searchVo
	 * @return
	 */
	public List<RoleVo> selectRoleList(RoleSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.role.selectRoleList", searchVo);
	}

	/**
	 * 롤 상세조회
	 * @param roleCode
	 * @return
	 */
	public RoleVo selectRole(String roleCode) {
		return sqlSession.selectOne("ncis.sql.cpt.role.selectRole", roleCode);
	}

	/**
	 * 롤에 속한 메뉴 정보 호출
	 * @param roleCode
	 * @return
	 */
	public List<RoleMenuVo> selectRoleMenuList(String roleCode) {
		return sqlSession.selectList("ncis.sql.cpt.role.selectRoleMenuList", roleCode);
	}



}
