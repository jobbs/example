/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IPBndServiceImpl.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.opr.ip.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cmn.dao.CRnIpBndDao;
import ncis.cmn.dao.CRnIpBndInstDao;
import ncis.cmn.dao.CRnIpBndPrposDao;
import ncis.cmn.dao.CRnIpDao;
import ncis.cmn.dao.CRnSRoutDao;
import ncis.cmn.dao.CRnVrSwtchAsgnDao;
import ncis.cmn.util.RequestUtils;
import ncis.cpt.opr.catalg.service.impl.SwServiceImpl;
import ncis.cpt.opr.ip.config.IpBndConstants;
import ncis.cpt.opr.ip.dao.RnIpBndDao;
import ncis.cpt.opr.ip.dao.RnIpBndInstDao;
import ncis.cpt.opr.ip.dao.RnIpBndPrposDao;
import ncis.cpt.opr.ip.dao.RnIpDao;
import ncis.cpt.opr.ip.dao.RnVrSwtchAsgnDao;
import ncis.cpt.opr.ip.service.IpBndService;
import ncis.cpt.opr.ip.vo.IpBndInstSearchVo;
import ncis.cpt.opr.ip.vo.IpBndInstVo;
import ncis.cpt.opr.ip.vo.IpBndPrposSearchVo;
import ncis.cpt.opr.ip.vo.IpBndPrposVo;
import ncis.cpt.opr.ip.vo.IpBndSearchVo;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.opr.ip.vo.IpVo;
import ncis.cpt.opr.ip.vo.SRoutVo;
import ncis.cpt.opr.ip.vo.VrSwtchAsgnSearchVo;
import ncis.cpt.opr.ip.vo.VrSwtchAsgnVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

/**
 * @author 신재훈
 *
 */

@Service("ipBndService")
public class IpBndServiceImpl implements IpBndService {
    @Resource(name = "cRnIpBndDao")
    private CRnIpBndDao cRnIpBndDao;

    @Resource(name = "rnIpBndDao")
    private RnIpBndDao rnIpBndDao;

    @Resource(name = "cRnIpDao")
    private CRnIpDao cRnIpDao;

    @Resource(name = "rnIpDao")
    private RnIpDao rnIpDao;

    @Resource(name = "rnIpBndPrposDao")
    private RnIpBndPrposDao rnIpBndPrposDao;

    @Resource(name = "cRnIpBndPrposDao")
    private CRnIpBndPrposDao cRnIpBndPrposDao;

    @Resource(name = "cRnSRoutDao")
    private CRnSRoutDao cRnSRoutDao;

    @Resource(name = "rnVrSwtchAsgnDao")
    private RnVrSwtchAsgnDao rnVrSwtchAsgnDao;

    @Resource(name = "cRnVrSwtchAsgnDao")
    private CRnVrSwtchAsgnDao cRnVrSwtchAsgnDao;

    @Resource(name = "rnIpBndInstDao")
    private RnIpBndInstDao rnIpBndInstDao;

    @Resource(name = "cRnIpBndInstDao")
    private CRnIpBndInstDao cRnIpBndInstDao;

    private static final Logger logger = LoggerFactory.getLogger(SwServiceImpl.class);
    /**
     * IP대역 검색
     */
    @Override
    public List<IpBndVo> selectIpBndList(IpBndSearchVo searchVo) {
        List<IpBndVo> list = null;
        int totalCount = rnIpBndDao.selectIpBndTotCnt(searchVo); // 전체 수량 구하기
        if (totalCount > 0) { // 전체수량이 0보다 클때만 조회
            searchVo.getPaginationInfo().setTotalRecordCount(totalCount); // 페이지 처리위한 count
            list = rnIpBndDao.selectIpBndList(searchVo);
        }
        return list;
    }

    /**
     * IP대역 상세조회
     */
    @Override
    public IpBndVo selectIpBnd(BigDecimal ipBndSeq) {
        IpBndVo ipBndVo = rnIpBndDao.selectIpBnd(ipBndSeq);
        return ipBndVo;
    }

    /**
     * IP대역 동기화
     */
    @Override
    public void updateIpBndSync(IpBndSearchVo searchVo) {
        IpVo ipVo = new IpVo();

        ipVo.setUpdtUserId(RequestUtils.getUser().getUserId());
        ipVo.setIpStatCd(IpBndConstants.IP_BND_STAT_CD_BLK);
        ipVo.setCheckBndIds(searchVo.getCheckBndIps()); // bndSeq 목록

        cRnIpDao.updateIpSyncronize(ipVo);

        // 동기화가 끝나면 선택한 IP대역(들)의 할당/미할당/블락 정보를 갱신시켜줘야 한다.
        for (int i = 0; i < searchVo.getCheckBndIps().size(); i++) {
            cRnIpBndDao.updateRnIpBndIpQty(searchVo.getCheckBndIps().get(i));
        }
    }

    public void updateIpList(List<IpVo> ipList){
		for (IpVo ipVo : ipList) {
			ipVo.setUpdtUserId(RequestUtils.getUser().getUserId());
			ipVo.setBndSeq(ipVo.getBndSeq());
           cRnIpDao.updateIpList(ipVo);
       }
    }

    /**
     * 할당해제
     */
    @Override
    public void updateAsgnToUnasgnIps(IpVo ipVo) {
        IpVo info = null;
        for (int i = 0; i < ipVo.getCheckIps().size(); i++) {
        	info = new IpVo();
            info.setUpdtUserId(RequestUtils.getUser().getUserId());
            info.setIpStatCd(IpBndConstants.IP_BND_STAT_CD_UNASGN);
            info.setIpAddr(ipVo.getCheckIps().get(i));  // IP SEQ 목록
            info.setBndSeq(ipVo.getSelectBndSeq().intValue());
            cRnIpDao.updateIpList(info);
        }
    }

    /**
     * 블락해제
     */
    @Override
    public void updateBlkToUnasgnIps(IpVo ipVo) {
    	IpVo info = null;
        for (int i = 0; i < ipVo.getCheckIps().size(); i++) {
        	info = new IpVo();
            info.setUpdtUserId(RequestUtils.getUser().getUserId());
            info.setIpStatCd(IpBndConstants.IP_BND_STAT_CD_UNASGN);
            info.setIpAddr(ipVo.getCheckIps().get(i)); // IP SEQ 목록
            info.setBndSeq(ipVo.getSelectBndSeq().intValue());
            cRnIpDao.updateIpListByBlkToUnasgn(info);
        }
    }

    /**
     * 수동할당
     */
    @Override
    public void updateUnasgnToAsgnIps(BigDecimal netwkIntfcSeq, IpVo ipVo ) {
    	IpVo info = null;
            for (int i = 0; i < ipVo.getCheckIps().size(); i++) {
            	info = new IpVo();
                info.setUpdtUserId(RequestUtils.getUser().getUserId());
                info.setIpStatCd(IpBndConstants.IP_BND_STAT_CD_ASGN);
                info.setIpAddr(ipVo.getCheckIps().get(i)); // IP SEQ 목록
                info.setBndSeq(ipVo.getSelectBndSeq().intValue());
                info.setNetwkIntfcSeq(netwkIntfcSeq);
                cRnIpDao.updateIpList(info);
            }
    }

    /**
     * 블락설정
     */
    @Override
    public void updateUnasgnToBlkIps(IpVo ipVo) {
        IpVo info = null;
        for (int i = 0; i < ipVo.getCheckIps().size(); i++) {
        	info = new IpVo();
            info.setUpdtUserId(RequestUtils.getUser().getUserId());
            info.setIpStatCd(IpBndConstants.IP_BND_STAT_CD_BLK);
            info.setIpAddr(ipVo.getCheckIps().get(i)); // IP SEQ 목록
            info.setBndSeq(ipVo.getSelectBndSeq().intValue());

            cRnIpDao.updateIpList(info);
        }
    }

    /**
     * IP 목록 가져오기 (할당,미할당,블락)
     */
    @Override
    public List<IpVo> selectIp(BigDecimal ipBndSeq, String ipStatCd) {
        return rnIpBndDao.selectIp(ipBndSeq, ipStatCd);
    }

    /**
     * IP대역 - 상세 (기본정보) 수정
     */
    @Override
    public void updateRnIpBndInfo(IpBndVo ipBndVo, List<IpBndPrposVo> ipBndPrposVoList, List<VrSwtchAsgnVo> vrSwtchAsgnVoList, List<IpBndInstVo> ipBndInstVoList) {
        // 1. IP대역 업데이트
        ipBndVo.setUpdtUserId(RequestUtils.getUser().getUserId());
        cRnIpBndDao.updateRnIpBndInfo(ipBndVo);

        // 2. 부처 업데이트
        IpBndInstSearchVo ipBndInstSearchVo = new IpBndInstSearchVo();
        ipBndInstSearchVo.setSearchBndSeq(ipBndVo.getBndSeq());

        List<IpBndInstVo> ipBndInstVoListForDelete = rnIpBndInstDao.selectIpBndInstList(ipBndInstSearchVo);

        for (IpBndInstVo ipBndInstVoForInsert : ipBndInstVoList) {
            boolean contains = false;
            for (IpBndInstVo ipBndInstVoForDelete : ipBndInstVoListForDelete) {
                if (ipBndInstVoForDelete.getInstitutionId().equals(ipBndInstVoForInsert.getInstitutionId())) {
                    contains = true;
                    ipBndInstVoListForDelete.remove(ipBndInstVoForDelete);
                    break;
                }
            }
            if (!contains) {
                cRnIpBndInstDao.insertRnIpBndInst(ipBndInstVoForInsert);
            }
        }

        for (IpBndInstVo ipBndInstVoForDelete : ipBndInstVoListForDelete) {
            cRnIpBndInstDao.deleteRnIpBndInst(ipBndInstVoForDelete);
        }

        // 3. 용도 업데이트
        IpBndPrposSearchVo ipBndPrposSearchVo = new IpBndPrposSearchVo();
        ipBndPrposSearchVo.setSearchBndSeq(ipBndVo.getBndSeq());

        List<IpBndPrposVo> ipBndPrposVoListForDelete = rnIpBndPrposDao.selectIpBndPrposList(ipBndPrposSearchVo);

        for (IpBndPrposVo ipBndPrposVoForInsert : ipBndPrposVoList) {
            boolean contains = false;
            for (IpBndPrposVo ipBndPrposVoForDelete : ipBndPrposVoListForDelete) {
                if (ipBndPrposVoForDelete.getPrposClCd().equals(ipBndPrposVoForInsert.getPrposClCd())) {
                    contains = true;
                    ipBndPrposVoListForDelete.remove(ipBndPrposVoForDelete);
                    break;
                }
            }
            if (!contains) {
                cRnIpBndPrposDao.insertRnIpBndPrpos(ipBndPrposVoForInsert);
            }
        }

        for (IpBndPrposVo ipBndPrposVoForDelete : ipBndPrposVoListForDelete) {
            cRnIpBndPrposDao.deleteRnIpBndPrpos(ipBndPrposVoForDelete);
        }

        // 4. 가상 스위치 업데이트
        if (null != vrSwtchAsgnVoList) {
            VrSwtchAsgnSearchVo vrSwtchAsgnSearchVo = new VrSwtchAsgnSearchVo();
            vrSwtchAsgnSearchVo.setSearchBndSeq(ipBndVo.getBndSeq());

            List<VrSwtchAsgnVo> vrSwtchAsgnVoListForDelete = rnVrSwtchAsgnDao.selectVrSwtchAsgnList(vrSwtchAsgnSearchVo);

            for (VrSwtchAsgnVo vrSwtchAsgnListForInsert : vrSwtchAsgnVoList) {
                boolean contains = false;
                for (VrSwtchAsgnVo vrSwtchAsgnVoForDelete : vrSwtchAsgnVoListForDelete) {
                    if (vrSwtchAsgnVoForDelete.getVrSwtchSeq().equals(vrSwtchAsgnListForInsert.getVrSwtchSeq())) {
                        contains = true;
                        vrSwtchAsgnVoListForDelete.remove(vrSwtchAsgnVoForDelete);
                        break;
                    }
                }
                if (!contains) {
                    cRnVrSwtchAsgnDao.insertRnVrSwtchAsgn(vrSwtchAsgnListForInsert);
                }
            }
            for (VrSwtchAsgnVo vrSwtchAsgnVoForDelete : vrSwtchAsgnVoListForDelete) {
                cRnVrSwtchAsgnDao.deleteRnVrSwtchAsgn(vrSwtchAsgnVoForDelete);
            }
        }
    }

    /**
     * Ip대역 추가
     */
    @Override
    public void insertIpBnd(IpBndVo ipBndVo) {
        // 1. IP대역 추가
        cRnIpBndDao.insertRnIpBnd(ipBndVo);

        // 2. 용도 추가
        for (String prposClCd : ipBndVo.getPrposClCdList()) {
            IpBndPrposVo ipBndPrposVoForInsert = new IpBndPrposVo();
            ipBndPrposVoForInsert.setBndSeq(ipBndVo.getBndSeq());
            ipBndPrposVoForInsert.setPrposClCd(prposClCd);
            cRnIpBndPrposDao.insertRnIpBndPrpos(ipBndPrposVoForInsert);
        }

        // 3. 부처 추가
        if (ipBndVo.getIpBndInstVoList() != null) {
            for (IpBndInstVo vo : ipBndVo.getIpBndInstVoList()) {
                IpBndInstVo ipBndInstVoForInsert = new IpBndInstVo();
                ipBndInstVoForInsert.setBndSeq(ipBndVo.getBndSeq());
                ipBndInstVoForInsert.setInstitutionId(vo.getInstitutionId());
                cRnIpBndInstDao.insertRnIpBndInst(ipBndInstVoForInsert);
            }
        }

        // 4. 가상스위치 설정
        if (ipBndVo.getVrSwtchList() != null && ipBndVo.getVrSwtchList().size() > 0) {
            for (int i = 0; i < ipBndVo.getVrSwtchList().size(); i++) {
                VrSwtchAsgnVo vrSwtchAsgnVo = new VrSwtchAsgnVo();
                vrSwtchAsgnVo.setBndSeq(ipBndVo.getBndSeq());
                vrSwtchAsgnVo.setVrSwtchSeq(ipBndVo.getVrSwtchList().get(i).getVrSwtchSeq());
                cRnVrSwtchAsgnDao.insertRnVrSwtchAsgn(vrSwtchAsgnVo);
            }
        }
        // 5. 스태틱라우터 설정
        if (ipBndVo.getsRoutLists() != null && ipBndVo.getsRoutLists().size() > 0) {
            for (int i = 0; i < ipBndVo.getsRoutLists().size(); i++) {
                SRoutVo sRoutVo = new SRoutVo();
                sRoutVo.setBndSeq(ipBndVo.getBndSeq());
                sRoutVo.setIpBndAddr(ipBndVo.getsRoutLists().get(i).getIpBndAddr());
                sRoutVo.setGtwyNm(ipBndVo.getsRoutLists().get(i).getGtwyNm());
                sRoutVo.setSubnetMask(ipBndVo.getsRoutLists().get(i).getSubnetMask());
                cRnSRoutDao.insertRnSRout(sRoutVo);
            }
        }
        // 6. 아이피 생성
        String[] strtIpArr = ipBndVo.getBndStrtIp().split("\\.");
        String[] endIpArr = ipBndVo.getBndEndIp().split("\\.");

        int range = Integer.parseInt(endIpArr[3]) - Integer.parseInt(strtIpArr[3]);

        String frontIp = strtIpArr[0] + "." + strtIpArr[1] + "." + strtIpArr[2] + ".";

        IpVo ipVo = null;
        for (int i = 0; i < range + 1; i++) {
            ipVo = new IpVo();
            String ip = frontIp + String.valueOf(Integer.parseInt(strtIpArr[3]) + i);
            ipVo.setIpAddr(ip);
            ipVo.setBndSeq(ipBndVo.getBndSeq().intValue());
            ipVo.setIpStatCd(IpBndConstants.IP_BND_STAT_CD_UNASGN);
            ipVo.setVipYn("N");
            ipVo.setNatIpAddr("");
            ipVo.setRmk("");
            ipVo.setUpdtUserId(RequestUtils.getUser().getUserId());

            cRnIpDao.insertRnIp(ipVo);
        }
    }

    /**
     * IP대역 삭제
     */
    @Override
    public void deleteIpBnd(BigDecimal bndSeq) {
        cRnIpDao.deleteIpBndWidth(bndSeq); // IP대역 삭제에 앞서, 해당 IP대역에 속한 IP목록들도 삭제시켜준다.
        cRnIpBndPrposDao.deleteRnIpBndPrposByBndSeq(bndSeq); // IP대역 용도 삭제
        cRnVrSwtchAsgnDao.deleteRnVrSwtchAsgnByBndSeq(bndSeq);
        cRnIpBndDao.deleteRnIpBnd(bndSeq); // IP대역 삭제
    }

    /**
     * IP 범위 조회
     */
    @Override
    public List<IpVo> selectCheckIpRange(String strtIp, String endIp, String regionId, String netId, List<String> prposClCdList) {
        // 선택한 용도가 WEB이나 WAS일 경우에는 묶어서 중복검사를 수행한다.
        List<String> customPrposClCdList = new ArrayList<String>();
        for (String clcd : prposClCdList) {
            if (clcd.equals("01") || clcd.equals("02") || clcd.equals("03")) {
                customPrposClCdList.add("01"); // WEB
                customPrposClCdList.add("02"); // WAS
                customPrposClCdList.add("03"); // DB
                break;
            }
            else if (clcd.equals("05") || clcd.equals("06")) {
                customPrposClCdList.add("05"); // WEB_BACKUP_NAS
                customPrposClCdList.add("06"); // WAS_BACKUP_NAS
                break;
            }
        }

        if (customPrposClCdList.size() > 0) {
            return rnIpBndDao.selectCheckIpRange(strtIp, endIp, regionId, netId, customPrposClCdList);
        }
        else {
            return rnIpBndDao.selectCheckIpRange(strtIp, endIp, regionId, netId, prposClCdList);
        }
    }

    /**
     * IP목록 엑셀다운로드
     */
    @Override
    public List<IpBndVo> selectIpBndListXlsDwnl(IpBndSearchVo searchVo) {
        searchVo.setPaginationInfo(null);
        return rnIpBndDao.selectIpBndList(searchVo);
    }

    /**
     * IP대역관리 샘플 다운로드
     * @return
     */
    @Override
    public void exampleFileDwnLoad(HttpServletRequest request, HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException  {

    	String dftpath = request.getSession().getServletContext().getRealPath("/WEB-INF/views/cpt/opr/catalg/tmplat/");
    	File file = new File(dftpath+"/IPCsvUpLoadSample.x");
    	String fileNm = "IP대역관리양식 샘플";
    	response.reset();

    	response.setContentType("application/vnd.ms-excel");
    	response.setContentLength((int) file.length());
    	response.setHeader("Content-Disposition", "attachment; filename=\"" + new String((fileNm).getBytes("KSC5601"),"8859_1") + ".csv\"");
    	response.setHeader("Content-Transfer-Encoding", "binary");

    	FileInputStream fis = null;
    	OutputStream out = null;

    	try{
    		fis = new FileInputStream(file);
    		out = response.getOutputStream();

    		byte b[] = new byte[1024];
    		int data = 0;

    		while((data=(fis.read(b, 0, b.length))) != -1){
    			out.write(b, 0, data);
    		}
    		FileCopyUtils.copy(fis, out);

    		out.flush();
    		out.close();
    		fis.close();
    	}catch(FileNotFoundException fe){
    		logger.error("FileNotFoundException", fe);
    	}catch(IOException ie){
    		logger.error("IOException", ie);
    	}catch(Exception e){
    		logger.error("Exception", e);
    	}
    }

    /**
     * IP대역관리 엑셀(CSV) 파일 업로드
     */
    @Override
    public boolean fileUpLoadForm(File newFile){
	boolean bool = true;

	return bool;
    }


}
