/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcPoolServiceImpl.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.pool.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ncis.cmn.dao.CRcRsrcPoolDao;
import ncis.cmn.util.excel.CustomSheet;
import ncis.cpt.rsrc.pool.dao.RsrcPoolDao;
import ncis.cpt.rsrc.pool.service.RsrcPoolService;
import ncis.cpt.rsrc.pool.vo.RsrcPoolSearchVo;
import ncis.cpt.rsrc.pool.vo.RsrcPoolVo;
import ncis.cpt.rsrc.strg.vo.RsrcPoolVrStrgVo;
import ncis.cpt.rsrc.strg.vo.VrStrgSearchVo;
import ncis.dsb.stts.etc.vo.OprStatSearchVo;

import org.springframework.stereotype.Service;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @author 심원보
 *
 */
@Service("rsrcPoolService")
public class RsrcPoolServiceImpl implements RsrcPoolService {

    @Resource(name = "cRcRsrcPoolDao")
    private CRcRsrcPoolDao cRcRsrcPoolDao;

    @Resource(name = "rsrcPoolDao")
    private RsrcPoolDao rsrcPoolDao;

    /**
     * 사용자에 속한 자원풀 목록 조회
     */
    @Override
    public List<RsrcPoolVo> selectUserRsrcPoolList(RsrcPoolSearchVo rsrcPoolSearchVo) {

        List<RsrcPoolVo> list = null;

        int totalCnt = rsrcPoolDao.selectUserRsrcPoolTotCnt(rsrcPoolSearchVo);
        if (totalCnt > 0) {
            rsrcPoolSearchVo.getPaginationInfo().setTotalRecordCount(totalCnt);
            list = rsrcPoolDao.selectUserRsrcPoolList(rsrcPoolSearchVo);
        }

        return list;

    }

    /**
     * 자원풀 목록 조회
     */
    @Override
    public List<RsrcPoolVo> selectRsrcPoolList(RsrcPoolSearchVo searchVo) {
        List<RsrcPoolVo> list = null;

        int totalCnt = rsrcPoolDao.selectRsrcPoolTotCnt(searchVo);
        if (totalCnt > 0) {
            searchVo.getPaginationInfo().setTotalRecordCount(totalCnt);
            list = rsrcPoolDao.selectRsrcPoolList(searchVo);
        }

        return list;
    }

    /**
     * 자원풀 목록 조회
     */
    @Override
    public List<RsrcPoolVo> selectRsrcPoolList(OprStatSearchVo searchVo) {
        List<RsrcPoolVo> list = null;

        int totalCnt = rsrcPoolDao.selectRsrcPoolTotCnt(searchVo);
        if (totalCnt > 0) {
            searchVo.getPaginationInfo().setTotalRecordCount(totalCnt);
            list = rsrcPoolDao.selectRsrcPoolList(searchVo);
        }

        return list;
    }

    /**
     * 자원풀에 속한 가상스토리지 용량정보가 포함된 목록 조회
     */
    @Override
    public List<RsrcPoolVrStrgVo> selectVrStrgRsrcPoolList(VrStrgSearchVo searchVo) {
        List<RsrcPoolVrStrgVo> list = null;

        list = rsrcPoolDao.selectVrStrgRsrcPoolList(searchVo);

        if (null != list && list.size() > 0) {
            searchVo.getPaginationInfo().setTotalRecordCount(list.get(0).getRnkCnt());
        }

        return list;
    }

    /**
     * 자원풀에 속한 가상스토리지 용량정보가 포함된 목록 조회 (엑셀다운로드)
     */
    @Override
    public List<CustomSheet> makeVrStrgRsrcPoolListExcelSheets(VrStrgSearchVo searchVo) {
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(1);
        paginationInfo.setRecordCountPerPage(100000000);
        searchVo.setPaginationInfo(paginationInfo);

        List<RsrcPoolVrStrgVo> list = rsrcPoolDao.selectVrStrgRsrcPoolList(searchVo);
        List<CustomSheet> sheets = new ArrayList<CustomSheet>();

        // 첫번째 Sheet Header 생성
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("regionNm", "센터");
        header.put("zoneNm", "존");
        header.put("netNm", "망");
        header.put("rsrcPoolNm", "자원풀");
        header.put("vrlzSwTyCdNm", "가상화SW");

        header.put("sumWholeAsgnCapa", "자원풀(GB)-총 할당량(A)");
        header.put("sumStrgUseCapa", "자원풀(GB)-총 사용량(B)");
        header.put("sumVmAsgnCapa", "자원풀(GB)-총 VM할당량(C)");
        header.put("sumTmplatAsgnCapa", "자원풀(GB)-총 템플릿사용량(D)");
        header.put("sumVmSnapshtAsgnCapa", "자원풀(GB)-총 VM스냅샷할당량(E)");
        header.put("sumStrMrgnCapa", "자원풀(GB)-총 VM가용용량(F = A - C - D - E)");

        header.put("strgDmnNm", "가상스토리지(GB)-스토리지도메인명");
        header.put("wholeAsgnCapa", "가상스토리지(GB)-할당량(G)");
        header.put("strgUseCapa", "가상스토리지(GB)-사용량(H)");
        header.put("vmAsgnCapaSingle", "가상스토리지(GB)-VM할당량(I)");
        header.put("tmplatAsgnCapa", "가상스토리지(GB)-템플릿할당량(J)");
        header.put("vmSnapshtAsgnCapaSingle", "가상스토리지(GB)-템플릿할당량(K)");
        header.put("strMrgnCapa", "가상스토리지(GB)-VM가용여유량(L = G - I - J - K)");

        // Sheet Vo 생성
        List<RsrcPoolVrStrgVo> datas = new ArrayList<RsrcPoolVrStrgVo>();

        // DB에 저장된 값이 아닌 가용용량과 가용여유량은 전체량 - VM할당량 - 템플릿할당량 으로 계산하여 출력한다.
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSumStrMrgnCapa(list.get(i).getSumWholeAsgnCapa().subtract(list.get(i).getSumVmAsgnCapa()).subtract(list.get(i).getSumTmplatAsgnCapa()).subtract(list.get(i).getSumVmSnapshtAsgnCapa()));
            list.get(i).setStrMrgnCapa(list.get(i).getWholeAsgnCapa().subtract(list.get(i).getVmAsgnCapaSingle()).subtract(list.get(i).getTmplatAsgnCapa()).subtract(list.get(i).getVmSnapshtAsgnCapaSingle()));
        }

        datas.addAll(list);

        // Sheet setting
        CustomSheet sheet = new CustomSheet();
        sheet.setSheetName("자원풀-가상스토리지");
        sheet.setDatas(datas);
        sheet.setHreader(header);

        sheets.add(sheet);

        return sheets;
    }

    /**
     * 자원풀 상세 조회
     */
    @Override
    public RsrcPoolVo selectRsrcPool(String rsrcPoolId) {
        return rsrcPoolDao.selectRsrcPool(rsrcPoolId);
    }
}
