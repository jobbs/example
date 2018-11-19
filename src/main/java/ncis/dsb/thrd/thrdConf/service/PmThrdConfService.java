package ncis.dsb.thrd.thrdConf.service;

import java.util.List;

import ncis.dsb.thrd.thrdConf.vo.UserSearchVo;
import ncis.cpt.sys.user.vo.UserVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfCvo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfPSearchVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.PmThrdConfVo;
import ncis.dsb.thrd.thrdConf.vo.AxThrdConfSearchVo;

public interface PmThrdConfService {

	public List<PmThrdConfVo> selectPmThrdConfList(PmThrdConfSearchVo paramVo)throws Exception;

	public void updateNtceConf(PmThrdConfCvo pmThrdConfCvo) throws Exception;
	public void deleteNtceConf(AxThrdConfSearchVo searchVo) throws Exception;

	public void updateThrdConf(PmThrdConfVo pmThrdConfVo) throws Exception;
	public void deleteThrdConf(AxThrdConfSearchVo searchVo) throws Exception;

	public PmThrdConfCvo selectNtceConf(PmThrdConfPSearchVo searchVo) throws Exception;
	public List<UserVo> selectUserList(UserSearchVo searchVo) throws Exception;
	public PmThrdConfVo selectPmThrdConf(PmThrdConfSearchVo paramVo) throws Exception ;
	public PmThrdConfVo selectAxThrdConf(PmThrdConfSearchVo paramVo) throws Exception ;


}
