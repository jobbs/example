/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PStrgServiceImpl.java
 *
 * @author 김봉민
 * @lastmodifier 김봉민
 * @created 2016. 10. 26.
 * @lastmodified 2016. 10. 27.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 25.     김봉민         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.dao.CRsPStrgCommDao;
import ncis.cmn.entity.RsPStrgComm;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cpt.rsrc.strg.dao.PhyStrgDao;
import ncis.cpt.rsrc.strg.service.PhyStrgService;
import ncis.cpt.rsrc.strg.vo.PhyStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.PhyStrgVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.cpt.rsrc.strg.vo.VrStrgVo;

import org.springframework.stereotype.Service;

/**
 * @author 김봉민
 *
 */
@Service("phyStrgService")
public class PhyStrgServiceImpl implements PhyStrgService{

	@Resource(name = "phyStrgDao")
	private PhyStrgDao pStrgDao;
	@Resource(name="cRsPStrgCommDao")
	private CRsPStrgCommDao  cRsPStrgCommDao;


	@Override
	public List<PhyStrgVo> selectPhyStrgList(PhyStrgSearchVo searchVo) {
		List<PhyStrgVo> list = null;
		int totalCount = pStrgDao.selectPStrgListTotCnt(searchVo);
		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = pStrgDao.selectPStrgList(searchVo);
		}
		return list;
	}


	/**
	 * 엑셀 저장
	 */
	@Override
	public List<CustomSheet> makePhyStrgListExcelSheets(PhyStrgSearchVo searchVo){
		searchVo.setPaginationInfo(null);	//페이지 처리 제외
		List<PhyStrgVo> list =  pStrgDao.selectPStrgList(searchVo);

		List<CustomSheet> sheets = new ArrayList<CustomSheet>();

		Map<String, String> header = new LinkedHashMap<String, String>();
		header.put("regionNm", "센터");
		header.put("zoneNm", "존");
		header.put("netClNm", "망구분");
		header.put("rsrcPoolNm", "자원풀");
		header.put("strgTyNm", "분류");
		header.put("phyStrgNm", "물리스토리지명");
		header.put("compId", "물리스토리지구성 ID");
		header.put("vrlzSwTyNm", "가상화SW");
		header.put("strgAsgnCapa", "할당량(GB)");
		header.put("strgUsefulCapa", "사용량(GB)");
		header.put("strgUseCapa", "가용량(GB)");


		CustomSheet sheet = new CustomSheet();
		sheet.setSheetName("스토리지 물리스토리지");
		sheet.setDatas(list);
		sheet.setHreader(header);
		sheets.add(sheet);

		return sheets;
	}

	/**
	 * 가상스트로지 용량 조회 - 물리서버별
	 */
	@Override
	public List<VrStrgVo> selectVrStrgCapaList(VrStrgSearchVo searchVo) {
		List<VrStrgVo> list = null;
		int totalCount = pStrgDao.selectVrStrgCapaListTotCnt(searchVo);
		if( totalCount > 0 ) {
			searchVo.getPaginationInfo().setTotalRecordCount(totalCount);
			list = this.pStrgDao.selectVrStrgCapaList(searchVo);
		}
		return list;
	}

	/**
	 *가상스토리지 용량 엑셀 다운로드
	 */
	@Override
	public List<CustomSheet> makeVrStrgListInPhyStrgExcelSheets(VrStrgSearchVo searchVo) {
		searchVo.setPaginationInfo(null);	//페이지 처리 제외
		List<VrStrgVo> list =  pStrgDao.selectVrStrgCapaList(searchVo);

		List<CustomSheet> sheets = new ArrayList<CustomSheet>();

		Map<String, String> header = new LinkedHashMap<String, String>();
		header.put("regionNm", "센터");
		header.put("zoneNm", "존");
		header.put("netNm", "망");
		header.put("rsrcPoolNm", "자원풀");
		header.put("vrlzSwTyCdNm", "가상화SW");
		header.put("strgDmnNm", "스토리지도메인명");
		header.put("sumWholeAsgnCapa", "전체량(GB)");
		header.put("sumStrgUseCapa", "사용량(GB)");
		header.put("sumVmAsgnCapa", "VM할당량(GB)");
		header.put("sumStrMrgnCapa", "여유량(GB)");

		CustomSheet sheet = new CustomSheet();
		sheet.setSheetName("스토리지 가상스토리지");
		sheet.setDatas(list);
		sheet.setHreader(header);
		sheets.add(sheet);

		return sheets;
	}

	@Override
	public void updatePhyStrgCommInfo(PhyStrgVo vo) {
		RsPStrgComm rsPStrgComm = new RsPStrgComm();
		rsPStrgComm.setPhyStrgId(vo.getPhyStrgId());
		rsPStrgComm.setPhyStrgNm(vo.getPhyStrgNm());
		rsPStrgComm.setCompClCd(vo.getCompClCd());
		rsPStrgComm.setRegionId(vo.getRegionId());
		rsPStrgComm.setAssetsId(vo.getAssetsId());
		rsPStrgComm.setCompId(vo.getCompId());
		rsPStrgComm.setCompRsrcNm(vo.getCompRsrcNm());
		rsPStrgComm.setUpperCompId(vo.getUpperCompId());
		rsPStrgComm.setModlCd(vo.getModlCd());
		rsPStrgComm.setMnfctCoCd(vo.getMnfctCoCd());
		rsPStrgComm.setSerialNo(vo.getSerialNo());
		rsPStrgComm.setEqpUniqIdNo(vo.getEqpUniqIdNo());
		rsPStrgComm.setUseDeptId(vo.getUseDeptId());
		rsPStrgComm.setOprStatCd(vo.getOprStatCd());
		rsPStrgComm.setOprChargerId(vo.getOprChargerId());
		rsPStrgComm.setCnsgnOprUserId(vo.getCnsgnOprUserId());
		rsPStrgComm.setStrgAsgnCapa(vo.getStrgAsgnCapa());
		rsPStrgComm.setStrgUseCapa(vo.getStrgUseCapa());
		rsPStrgComm.setStrgUsefulCapa(vo.getStrgUsefulCapa());
		this.cRsPStrgCommDao.updateRsPStrgCommSelected(rsPStrgComm);
	}
}
