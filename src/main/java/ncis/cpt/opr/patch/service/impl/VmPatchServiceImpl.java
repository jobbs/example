/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename VmPatchServiceImpl.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ncis.cpt.opr.patch.dao.VmPatchDao;
import ncis.cpt.opr.patch.service.VmPatchService;
import ncis.cpt.opr.patch.vo.VmPatchPackgVo;
import ncis.cpt.opr.patch.vo.VmPatchSearchVo;
import ncis.cpt.opr.patch.vo.VmPatchVo;

import org.springframework.stereotype.Service;

/**
 * @author 이화영
 *
 */
@Service("vmPatchService")
public class VmPatchServiceImpl implements VmPatchService {

	@Resource(name="vmPatchDao") private VmPatchDao vmPatchDao;

	@Override
	public List<VmPatchVo> selectVmPatchList(VmPatchSearchVo searchVo) {

		List<VmPatchVo> list = null;

		int totalCount = vmPatchDao.selectVmPatchListTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = vmPatchDao.selectVmPatchList(searchVo);
		}
		return list;
	}

	@Override
    public VmPatchVo selectVmPatch(VmPatchVo vmPatchVo) {
        return vmPatchDao.selectVmPatch(vmPatchVo);

    }

	@Override
	public List<VmPatchPackgVo> selectVmPatchPackgList(VmPatchVo vmPatchVo) {
		List<VmPatchPackgVo> list = null;

		int totalCount = vmPatchDao.selectVmPatchPackgListTotCnt(vmPatchVo);

		if( totalCount > 0 ) {
			list = vmPatchDao.selectVmPatchPackgList(vmPatchVo);
		}
		return list;
	}

	@Override
	public List<VmPatchVo> selectVmPatchExcelList(VmPatchSearchVo searchVo) {

		List<VmPatchVo> list = null;

		list = vmPatchDao.selectVmPatchExcelList(searchVo);

		return list;
	}


}
