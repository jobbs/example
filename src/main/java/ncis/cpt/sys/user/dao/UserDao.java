/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserDao.java
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
package ncis.cpt.sys.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ncis.cpt.sys.user.vo.UserInsttVo;
import ncis.cpt.sys.user.vo.UserJobVo;
import ncis.cpt.sys.user.vo.UserPoolVo;
import ncis.cpt.sys.user.vo.UserRoleVo;
import ncis.cpt.sys.user.vo.UserSearchVo;
import ncis.cpt.sys.user.vo.UserVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {

	@Autowired SqlSessionTemplate sqlSession;

	/**
	 * 검색조건에 해당하는 전체 사용자 수 조회
	 * @param searchVo
	 * @return
	 */
	public int selectUserTotCnt(UserSearchVo searchVo) {
		return sqlSession.selectOne("ncis.sql.cpt.user.selectUserTotCnt",searchVo);
	}

	/**
	 * 검색조건에 해당하는 사용자 목록 조회
	 * @param searchVo
	 * @return
	 */
	public List<UserVo> selectUserList(UserSearchVo searchVo) {
		return sqlSession.selectList("ncis.sql.cpt.user.selectUserList",searchVo);
	}

	/**
	 * 해당 유저의 정보 조회
	 * @param userId
	 * @return
	 */
	public UserVo selectUser(String userId) {
		return sqlSession.selectOne("ncis.sql.cpt.user.selectUser",userId);
	}


    /**
     * @param crtfctKey
     * @return
     */
    public UserVo selectUserByDn(String crtfctKey) {
        return sqlSession.selectOne("ncis.sql.cpt.user.selectUserByDn",crtfctKey);
    }


	/**
	 * 사용자의 롤 정보 조회
	 * @param userId
	 * @return
	 */
	public List<UserRoleVo> selectUserRoleList(String userId) {
		return sqlSession.selectList("ncis.sql.cpt.user.selectUserRoleList",userId);
	}

    /**
     * 사용자의 업무 정보 조회
     * @param userId
     * @return
     */
    public List<UserJobVo> selectUserJobList(String userId) {
        return sqlSession.selectList("ncis.sql.cpt.user.selectUserJobList",userId);
    }

    /**
     * 사용자가 해당권한을 보유하고 잇는지 여부확인 하기 위한 요청
     * @param userId
     * @param roleCd
     * @return
     */
    public int selectUserRoleByCodeType(String userId, String roleTyCd) {
           Map<String, String> params = new HashMap<String, String>();
           params.put("userId", userId);
           params.put("roleTyCd", roleTyCd);
        return sqlSession.selectOne("ncis.sql.cpt.user.selectUserRoleByCodeType",params);
    }

    /**
     * 사용자가 가지고 있는 자원풀 권한 목록을 조회한다.
     * @param userId
     * @return
     */
    public List<UserPoolVo> selectUserPoolList(String userId) {
        return sqlSession.selectList("ncis.sql.cpt.user.selectUserPoolList",userId);
    }

    /**
     * @param searchVo
     * @return
     */
    public List<UserVo> selectDownloadUser(UserSearchVo searchVo) {
        return sqlSession.selectList("ncis.sql.cpt.user.selectDownloadUser",searchVo);
    }

	/**
	 * @param userId
	 */
	public int selectUserId(String userId) {
		return sqlSession.selectOne("ncis.sql.cpt.user.selectUserId", userId);

	}

	/**
	 * @param userId
	 * @return
	 */
	public List<UserInsttVo> selectUserInsttList(String userId) {
		return sqlSession.selectList("ncis.sql.cpt.user.selectUserInsttList", userId);
	}

}
