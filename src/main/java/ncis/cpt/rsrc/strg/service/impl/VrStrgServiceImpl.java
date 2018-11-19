/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename vrStrgServiceImpl.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cpt.opr.catalg.vo.TmplatSvo;
import ncis.cpt.rsrc.com.vo.VmSearchVo;
import ncis.cpt.rsrc.strg.dao.VrStrgDao;
import ncis.cpt.rsrc.strg.service.VrStrgService;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;

import org.springframework.stereotype.Service;

/**
 * @author 신재훈
 *
 */
@Service("vrStrgService")
public class VrStrgServiceImpl implements VrStrgService {
    @Resource(name = "vrStrgDao")
    private VrStrgDao vrStrgDao;

    /**
     * 가상스토리지도메인 상세조회
     */
    @Override
    public VrStrgVo selectVrStrg(VrStrgSearchVo searchVo) {
        return vrStrgDao.selectVrStrg(searchVo);
    }

    /**
     * 가상스토리지 상세 - 가상서버 탭 조회
     */
    @Override
    public List<VrStrgVo> selectVrStrgVm(VmSearchVo searchVo) {
        List<VrStrgVo> list = null;
        int totalCount = vrStrgDao.selectVrStrgVmTotCnt(searchVo);
        if (totalCount > 0) {
            searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
            list = vrStrgDao.selectVrStrgVm(searchVo);
        }
        return list;
    }

    /**
     * 가상스토리지 상세 - 템플릿 탭 조회
     */
    @Override
    public List<VrStrgVo> selectVrStrgTmplat(TmplatSvo searchVo) {
        List<VrStrgVo> list = null;
        int totalCount = vrStrgDao.selectVrStrgTmplatTotCnt(searchVo);
        if (totalCount > 0) {
            searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
            list = vrStrgDao.selectVrStrgTmplat(searchVo);
        }
        return list;
    }

    /**
     * 가상서버가 할당 된 가상스토리지 도메인 가용용량 및 디스크할당용량 조회
     */
	@Override
	public List<VrStrgVo> selectVrStrgAsgnInfoOfVm(BigDecimal vmSeq) {
		return vrStrgDao.selectVrStrgAsgnInfoOfVm(vmSeq);
	}
}
