/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename IpBndService.java
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
package ncis.cpt.opr.ip.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ncis.cpt.opr.ip.vo.IpBndInstVo;
import ncis.cpt.opr.ip.vo.IpBndPrposVo;
import ncis.cpt.opr.ip.vo.IpBndSearchVo;
import ncis.cpt.opr.ip.vo.IpBndVo;
import ncis.cpt.opr.ip.vo.IpVo;
import ncis.cpt.opr.ip.vo.VrSwtchAsgnVo;

/**
 * @author 신재훈
 *
 */
public interface IpBndService {

    /**
     * IP대역 목록조회
     *
     * @param searchVo
     * @return
     */
    List<IpBndVo> selectIpBndList(IpBndSearchVo searchVo);

    /**
     * IP대역 엑셀다운로드
     *
     * @param searchVo
     * @return
     */
    List<IpBndVo> selectIpBndListXlsDwnl(IpBndSearchVo searchVo);

    /**
     * IP대역 상세조회
     *
     * @param ipBndSeq
     * @return
     */
    IpBndVo selectIpBnd(BigDecimal ipBndSeq);

    /**
     * IP 동기화
     */
    void updateIpBndSync(IpBndSearchVo searchVo);

    /**
     * IP대역 추가
     *
     * @param ipBndVo
     */
    void insertIpBnd(IpBndVo ipBndVo);

    /**
     * IP대역 수정
     *
     * @param ipBndVo
     */
    void updateRnIpBndInfo(IpBndVo ipBndVo, List<IpBndPrposVo> ipBndPrposVoList, List<VrSwtchAsgnVo> vrSwtchAsgnVoList, List<IpBndInstVo> ipBndInstVoList);

    /**
     * 할당해제
     *
     * @param ipVo
     */
    void updateAsgnToUnasgnIps(IpVo ipVo);

    /**
     * 블락해제
     *
     * @param ipVo
     */
    void updateBlkToUnasgnIps(IpVo ipVo);

    /**
     * 수동할당
     *
     * @param ipVo
     */
    void updateUnasgnToAsgnIps(BigDecimal netwkIntfcSeq, IpVo ipVo);

    /**
     * 블락설정
     *
     * @param ipVo
     */
    void updateUnasgnToBlkIps(IpVo ipVo);

    /**
     * IP대역 삭제
     *
     * @param ipBndVo
     */
    void deleteIpBnd(BigDecimal bndSeq);
    
    /**
     * IP 할당/미할당/Block 변경된 정보저장
     * @param ipList
     */
    void updateIpList(List<IpVo> ipList);

    /**
     * IP 목록 가져오기 (할당,미할당,블락)
     *
     * @param ipBndSeq
     * @param string
     * @return
     */
    List<IpVo> selectIp(BigDecimal ipBndSeq, String string);

    /**
     * IP 조회 (범위)
     *
     * @param starIp
     * @param endIp
     * @return
     */
    List<IpVo> selectCheckIpRange(String strtIp, String endIp, String regionId, String netId, List<String> prposClCdList);

    /**
     * IP대역관리 샘플 다운로드
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public void exampleFileDwnLoad(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;

    /**
     * IP대역(csv) 업로드
     * @param newFile
     * @return
     */
    boolean fileUpLoadForm(File newFile);
}
