/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackgAlrmServiceImpl.java
 *
 * @author 이화영
 * @lastmodifier 이화영
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 26.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 26.     이화영         v1.0             최초생성
 *
 */
package ncis.cpt.opr.patch.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import ncis.cmn.dao.COaAlrmTrgtDao;
import ncis.cmn.entity.OaAlrmTrgt;
import ncis.cpt.opr.patch.dao.PackgAlrmDao;
import ncis.cpt.opr.patch.service.PackgAlrmService;
import ncis.cpt.opr.patch.vo.PackgAlrmInfoVo;
import ncis.cpt.opr.patch.vo.PackgAlrmSearchVo;
import ncis.cpt.opr.patch.vo.PackgAlrmVo;

import org.springframework.stereotype.Service;

/**
 * @author 이화영
 *
 */
@Service("packgAlrmService")
public class PackgAlrmServiceImpl implements PackgAlrmService {

	@Resource(name="packgAlrmDao") private PackgAlrmDao packgAlrmDao;
	@Resource(name="cOaAlrmTrgtDao") private COaAlrmTrgtDao cOaAlrmTrgtDao;

	/**
	 * 검색 조건에 해당하는 패치알림 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	@Override
	public List<PackgAlrmVo> selectPackgAlrmList(PackgAlrmSearchVo searchVo) {

		List<PackgAlrmVo> list = null;

		int totalCount = packgAlrmDao.selectPackgAlrmListTotCnt(searchVo);

		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);	// 페이지 처리위한 count
			list = packgAlrmDao.selectPackgAlrmList(searchVo);
		}
		return list;
	}

	/**
	 * 패치알림  Excel 목록 조회
	 * @param searchVo	검색조검 VO
	 * @return
	 */
	@Override
	public List<PackgAlrmVo> selectPackgAlrmExcelList(PackgAlrmSearchVo searchVo) {

		List<PackgAlrmVo> list = null;
		list = packgAlrmDao.selectPackgAlrmExcelList(searchVo);
		return list;
	}

	/**
     * 패치알림 상세 조회
     * @param packgAlrmVo
     * @return
     */
	@Override
    public PackgAlrmInfoVo selectPackgAlrm(PackgAlrmVo packgAlrmVo) {
        return packgAlrmDao.selectPackgAlrm(packgAlrmVo);
    }

	/**
     * 패치알림확인
     * @param searchVo
     * @return
     */
	@Override
	public void updatePackgAlrm(PackgAlrmSearchVo packgAlrmSearchVo){
		OaAlrmTrgt oaAlrmTrgt = new OaAlrmTrgt();
		for(int i = 0; i < packgAlrmSearchVo.getPackgAlrmList().size(); i++) {
			oaAlrmTrgt.setPatchAlrmSeq(new BigDecimal(packgAlrmSearchVo.getPackgAlrmList1().get(i)));//패치알림SEQ
			oaAlrmTrgt.setVmSeq(new BigDecimal(packgAlrmSearchVo.getPackgAlrmList().get(i)));//가상서버SEQ
			oaAlrmTrgt.setConfrmYn("Y");
			oaAlrmTrgt.setChargerId(packgAlrmSearchVo.getPackgAlrmList2().get(i));//담당자id
			cOaAlrmTrgtDao.updateOaAlrmTrgt(oaAlrmTrgt);
		}
	}

}
