package ncis.dsb.thrd.thrdConf.service;

import java.util.List;

import ncis.dsb.thrd.thrdConf.vo.AxThrdConfSearchVo;
import ncis.dsb.thrd.thrdConf.vo.AxThrdConfVo;

public interface AxThrdConfService {

	public List<AxThrdConfVo> selectAxThrdConfList(AxThrdConfSearchVo paramVo)throws Exception;


}
