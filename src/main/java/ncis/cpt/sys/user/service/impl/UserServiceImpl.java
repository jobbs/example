/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename UserServiceImpl.java
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
package ncis.cpt.sys.user.service.impl;

import java.util.List;
import javax.annotation.Resource;
import ncis.cmn.dao.CCmUsrDao;
import ncis.cmn.entity.CmInsttUser;
import ncis.cmn.entity.CmJobUser;
import ncis.cmn.entity.CmRsrcPoolUser;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.cpt.sys.user.dao.UserDao;
import ncis.cpt.sys.user.service.UserService;
import ncis.cpt.sys.user.vo.UserInsttVo;
import ncis.cpt.sys.user.vo.UserJobVo;
import ncis.cpt.sys.user.vo.UserPoolVo;
import ncis.cpt.sys.user.vo.UserRoleVo;
import ncis.cpt.sys.user.vo.UserSearchVo;
import ncis.cpt.sys.user.vo.UserVo;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="cCmUsrDao") private CCmUsrDao cCmUsrDao;
	@Resource(name="userDao") private UserDao userDao;

	@Override
	public List<UserVo> selectUserList(UserSearchVo searchVo) {

		List<UserVo> list = null;

		int totalCount = userDao.selectUserTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = userDao.selectUserList(searchVo);
		}


		return list;
	}

	@Override
	public UserVo selectUser(String userId) {
		return userDao.selectUser(userId);
	}

	@Override
	public UserVo selectUserByDn(String crtfctKey) {
	    return userDao.selectUserByDn(crtfctKey);
	}

	@Override
	public List<UserRoleVo> selectUserRoleList(String userId) {
		return userDao.selectUserRoleList(userId);
	}

	@Override
	public void insertUserRole(UserVo userVo) {

		for (UserRoleVo roleUserVo : userVo.getUserRoles()) {
			roleUserVo.setUserId(userVo.getUserId());
			cCmUsrDao.insertUserRole(roleUserVo);
		}
	}

	@Override
	public void deleteUserRole(UserRoleVo roleUser) {
	    //RODE CODE 가 운영자 일경우 자원풀의 권한도 같이 삭제 한다.
	    if( roleUser.getRoleTyCd().equals("OPRADM")) {
	        cCmUsrDao.deleteUserAllPool(roleUser.getUserId());

	      //RODE CODE 가 담당자(OPRCHR) 일경우 업무 권한도 같이 삭제 한다.
	    } else if( roleUser.getRoleTyCd().equals("OPRCHR")) {
	        cCmUsrDao.deleteUserAllJob(roleUser.getUserId());
	        cCmUsrDao.deleteUserAllInstt(roleUser.getUserId());
	    }
		cCmUsrDao.deleteUserRole(roleUser);
	}

	@Override
	public boolean selectUserRoleByCodeType(String userId, String roleTyCd) {
	    return userDao.selectUserRoleByCodeType(userId, roleTyCd) > 0 ? true:false;
	}

	@Override
	public List<UserJobVo> selectUserJobList(String userId) {
	    return userDao.selectUserJobList(userId);
	}

	@Override
	public void insertUserJob(UserVo userVo) {

	    CmJobUser jobUser = null;
	    for (UserJobVo userJobVo : userVo.getUserJobs()) {
	        jobUser = new CmJobUser();
	        jobUser.setUserId(userJobVo.getUserId());
	        jobUser.setJobId(userJobVo.getJobId());
            cCmUsrDao.insertUserJob(jobUser);
        }
	}

	@Override
	public void deleteUserJob(CmJobUser userJob) {
	    cCmUsrDao.deleteUserJob(userJob);
	}

	@Override
	public List<UserPoolVo> selectUserPoolList(String userId) {
	    return userDao.selectUserPoolList(userId);
	}

	@Override
	public void insertUserPool(UserVo userVo) {
	    CmRsrcPoolUser userPool = null;
        for (RsrcPoolVo userPoolVo : userVo.getUserPools()) {
            userPool = new CmRsrcPoolUser();
            userPool.setUserId(userPoolVo.getUserId());
            userPool.setRsrcPoolId(userPoolVo.getRsrcPoolId());
            userPool.setRegionId(userPoolVo.getRegionId());
            cCmUsrDao.insertUserPool(userPool);
        }
	}

	@Override
	public void deleteUserPool(CmRsrcPoolUser userPool) {
	    cCmUsrDao.deleteUserPool(userPool);
	}

	@Override
	public List<UserVo> selectDownloadUser(UserSearchVo searchVo) {
		List<UserVo> list = userDao.selectDownloadUser(searchVo);
	    return list;
	}

	@Override
	public void updateUserDn(UserVo user) {
	    cCmUsrDao.updateUserDn(user);
	}


	@Override
	public void insertUser(UserVo userVo) {
		cCmUsrDao.insertCmUser(userVo);

	}

	@Override
	public void updateUser(UserVo userVo) {
		cCmUsrDao.updateCmUser(userVo);

	}

	@Override
	public void deleteUser(String userId) {
		//사용자 롤 삭제
		cCmUsrDao.deleteUsrAllRole(userId);

		//사용자 부처 삭제
		cCmUsrDao.deleteUserAllInstt(userId);

		//사용자 업무 삭제
		cCmUsrDao.deleteUserAllJob(userId);

		//사용자 자원풀 삭제
		cCmUsrDao.deleteUserAllPool(userId);

		//사용자 삭제
		cCmUsrDao.deleteCmUser(userId);
	}

	@Override
	public boolean selectUserId(String userId) {
		return userDao.selectUserId(userId) >= 1 ? true : false;
	}

	@Override
	public List<UserInsttVo> selectUserInsttList(String userId) {
		return userDao.selectUserInsttList(userId);
	}

	@Override
	public void insertUserInstt(UserVo userVo) {

		CmInsttUser insttUser = null;
	    for (UserInsttVo userInsttVo : userVo.getUserInstts()) {
	    	insttUser = new CmInsttUser();
	    	insttUser.setUserId(userInsttVo.getUserId());
	    	insttUser.setInstitutionId(userInsttVo.getInstitutionId());
            cCmUsrDao.insertUserInstt(insttUser);
            cCmUsrDao.insertJobByInstt(insttUser);
        }
	}

	@Override
	public void deleteUserInstt(CmInsttUser insttUser) {
		cCmUsrDao.deleteUserInstt(insttUser);
		cCmUsrDao.deleteJobByInstt(insttUser);
	}
}
