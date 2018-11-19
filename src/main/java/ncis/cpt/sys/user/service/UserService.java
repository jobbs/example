/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserService.java
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
package ncis.cpt.sys.user.service;

import java.util.List;
import ncis.cmn.entity.CmInsttUser;
import ncis.cmn.entity.CmJobUser;
import ncis.cmn.entity.CmRsrcPoolUser;
import ncis.cpt.sys.user.vo.UserInsttVo;
import ncis.cpt.sys.user.vo.UserJobVo;
import ncis.cpt.sys.user.vo.UserPoolVo;
import ncis.cpt.sys.user.vo.UserRoleVo;
import ncis.cpt.sys.user.vo.UserSearchVo;
import ncis.cpt.sys.user.vo.UserVo;

public interface UserService {

	/**
	 * 사용자 목록 조회
	 * @param searchVo
	 * @return
	 */
	List<UserVo> selectUserList(UserSearchVo searchVo);

	/**
	 * 사용자 상세 조회
	 * @param userId
	 * @return
	 */
	UserVo selectUser(String userId);

	/**
	 * 사용자의 롤정보 조회
	 * @param userId
	 * @return
	 */
	List<UserRoleVo> selectUserRoleList(String userId);

	/**
	 * 사용자에 롤 맵핑
	 * @param userVo
	 */
	void insertUserRole(UserVo userVo);

	/**
	 * 사용자에 맵핑된 롤정보 삭제
	 * @param roleUser
	 */
	void deleteUserRole(UserRoleVo roleUser);

	/**
	 * 권한이 존재 있는지 여부를 확인한다.
     * @param userId
     * @param roleTyCd
     * @return
     */
    boolean selectUserRoleByCodeType(String userId, String roleTyCd);

    /**
     * 사용자의 업무 목록 조회
     * @param userId
     * @return
     */
    List<UserJobVo> selectUserJobList(String userId);

    /**
     * 사용자에 업무 맵핑
     * @param userVo
     */
    void insertUserJob(UserVo userVo);

    /**
     * 사용자에 맵핑된 업무 삭제
     * @param userJob
     */
    void deleteUserJob(CmJobUser userJob);

    /**
     * 사용자가 가지고 있는 자원풀 권한 목록을 조회한다.
     * @param userId
     * @return
     */
    List<UserPoolVo> selectUserPoolList(String userId);

    /**
     * @param userVo
     */
    void insertUserPool(UserVo userVo);

    /**
     * @param userPool
     */
    void deleteUserPool(CmRsrcPoolUser userPool);

    /**
     * @param searchVo
     * @return
     */
    List<UserVo> selectDownloadUser(UserSearchVo searchVo);

    /**
     * @param crtfctKey
     * @return
     */
    UserVo selectUserByDn(String crtfctKey);

    /**
     * @param user
     */
    void updateUserDn(UserVo user);

	/**
	 * @param userVo
	 */
	void insertUser(UserVo userVo);

	/**
	 * @param userVo
	 */
	void updateUser(UserVo userVo);

	/**
	 * @param userId
	 */
	void deleteUser(String userId);

	/**
	 * @param userId
	 */
	boolean selectUserId(String userId);

	/**
	 * @param userId
	 * @return
	 */
	List<UserInsttVo> selectUserInsttList(String userId);

	/**
	 * @param userVo
	 */
	void insertUserInstt(UserVo userVo);

	/**
	 * @param userInstt
	 */
	void deleteUserInstt(CmInsttUser InsttUser);



}
