package ncis.dsb.thrd.thrdConf.service;

import java.util.List;

import ncis.dsb.thrd.thrdConf.vo.VmThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.VmThrdConfVo;

public interface VmThrdConfService {

	public List<VmThrdConfVo> selectVmThrdConfList(VmThrdConfSearchVo paramVo)throws Exception;


}
