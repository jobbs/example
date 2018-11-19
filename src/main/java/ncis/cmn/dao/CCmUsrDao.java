/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CCmUsrDao.java
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
package ncis.cmn.dao;

import ncis.cmn.entity.CmInsttUser;
import ncis.cmn.entity.CmJobUser;
import ncis.cmn.entity.CmRsrcPoolUser;
import ncis.cmn.entity.CmUsr;
import ncis.cmn.entity.CmUsrRole;
import ncis.cpt.sys.user.vo.UserVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 사용자 DAO - 공통(등록/수정/삭제)
 *
 * @author ShinKeeBong
 */

@Repository("cCmUsrDao")
public class CCmUsrDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 사용자 등록
	 * @param cmUsr
	 */
	public void insertCmUsr(CmUsr cmUsr) {
		sqlSession.insert("ncis.sql.cmn.cmusr.insertCmUsr", cmUsr);
	}

	/**
	 * 사용자 수정
	 * @param cmUsr
	 */
	public void updateCmUsr(CmUsr cmUsr) {
		sqlSession.update("ncis.sql.cmn.cmusr.updateCmUsr", cmUsr);
	}

	/**
	 * 사용자 삭제
	 * @param cmUsr
	 */
	public void deleteCmUsr(CmUsr cmUsr) {
		sqlSession.update("ncis.sql.cmn.cmusr.deleteCmUsr", cmUsr);
	}

	/**
     * 사용자에 롤 맵핑
     * @param roleUserVo
     */
    public void insertUserRole(CmUsrRole roleUserVo) {
        sqlSession.insert("ncis.sql.cmn.cmusr.insertCmUsrRole",roleUserVo);
    }

    /**
     * 사용자에 맵핑된 롤정보 삭제
     * @param roleUser
     */
    public void deleteUserRole(CmUsrRole roleUser) {
        sqlSession.delete("ncis.sql.cmn.cmusr.deleteCmUsrRole",roleUser);
    }

    /**
     * 사용자에 맵핑된 전체 롤정보 삭제
	 * @param userId
	 */
	public void deleteUsrAllRole(String userId) {
		sqlSession.delete("ncis.sql.cmn.cmusr.deleteUsrAllRole",userId);
	}

    /**
     * 사용자에 업무를 맵핑한다.
     * @param jobUser
     */
    public void insertUserJob(CmJobUser jobUser) {
        sqlSession.insert("ncis.sql.cmn.cmusr.insertCmUsrJob",jobUser);
    }

    /**
     * 맵핑된 업무를 삭제 한다.
     * @param userJob
     */
    public void deleteUserJob(CmJobUser jobUser) {
        sqlSession.delete("ncis.sql.cmn.cmusr.deleteCmJobUser",jobUser);
    }

    /**
     * 사용자의 맵핑된 업무를 모두 삭제 한다.
     * @param userId
     */
    public void deleteUserAllJob(String userId) {
        sqlSession.delete("ncis.sql.cmn.cmusr.deleteUserAllJob",userId);
    }

    /**
     * @param userPool
     */
    public void insertUserPool(CmRsrcPoolUser userPool) {
        sqlSession.insert("ncis.sql.cmn.cmusr.insertCmRsrcPoolUser",userPool);
    }

    /**
     * @param userPool
     */
    public void deleteUserPool(CmRsrcPoolUser userPool) {
        sqlSession.delete("ncis.sql.cmn.cmusr.deleteUserPool",userPool);
    }

    /**
     * 사용자의 맵핑된 자원풀을 모두 삭제 한다.
     * @param userId
     */
    public void deleteUserAllPool(String userId) {
        sqlSession.delete("ncis.sql.cmn.cmusr.deleteUserAllPool",userId);
    }

    /**
     * @param user
     */
    public void updateUserDn(UserVo user) {
        sqlSession.update("ncis.sql.cmn.cmusr.updateUserDn", user);
    }

	/**
	 * 사용자를 추가한다.
	 * @param userVo
	 */
	public void insertCmUser(UserVo user) {
		sqlSession.update("ncis.sql.cmn.cmusr.insertCmUsr", user);
	}

	/**
	 * 사용자 정보를 수정한다.
	 * @param userVo
	 */
	public void updateCmUser(UserVo user) {
		sqlSession.update("ncis.sql.cmn.cmusr.updateCmUsr", user);
	}

	/**
	 * 사용자 정보를 삭제한다.
	 * @param userId
	 */
	public void deleteCmUser(String userId) {
		sqlSession.delete("ncis.sql.cmn.cmusr.deleteCmUsr", userId);
	}

	/**
	 * 사용자 부처를 맵핑한다.
	 * @param insttUser
	 */
	public void insertUserInstt(CmInsttUser insttUser) {
		sqlSession.insert("ncis.sql.cmn.cmusr.insertCmUsrInstt", insttUser);
	}

	/**
	 * 사용자 부처를 삭제한다.
	 * @param userInstt
	 */
	public void deleteUserInstt(CmInsttUser insttUser) {
		sqlSession.delete("ncis.sql.cmn.cmusr.deleteCmUsrInstt",insttUser);
	}

	/**
     * 사용자의 맵핑된 부처를 모두 삭제 한다.
     * @param userId
     */
    public void deleteUserAllInstt(String userId) {
        sqlSession.delete("ncis.sql.cmn.cmusr.deleteUserAllInstt",userId);
    }

	/**
	 * 부처에 관련된 업무를 추가한다.
	 * @param insttUser
	 */
	public void insertJobByInstt(CmInsttUser insttUser) {
		sqlSession.insert("ncis.sql.cmn.cmusr.insertCmJobByInstt", insttUser);
	}

	/**
	 * 사용자 부처에 따른 업무를 삭제한다.
	 * @param userInstt
	 */
	public void deleteJobByInstt(CmInsttUser insttUser) {
		sqlSession.delete("ncis.sql.cmn.cmusr.deleteCmJobByInstt",insttUser);
	}



}
