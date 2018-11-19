/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqService.java
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
package ncis.cpt.rsrc.com.service;

import ncis.cpt.rsrc.com.vo.RsrcReqVo;

/**
 * @author 심원보
 *
 */
public interface RsrcReqService {

    /**
     * 자원요청 클러스터 생성 요청 추가
     *
     * @param rsrcReqVo
     */
    void insertRsrcReqClstrCreReq(RsrcReqVo rsrcReqVo);

    /**
     * 자원요청 클러스터 삭제 요청 추가
     *
     * @param rsrcReqVo
     */
    void insertRsrcReqClstrDelReq(RsrcReqVo rsrcReqVo);

    /**
     * 자원요청 가상서버 생성 요청 추가
     *
     * @param rsrcReqVo
     */
    void insertRsrcReqVmCreReq(RsrcReqVo rsrcReqVo);

    /**
     * 자원요청 가상서버 스펙변경 요청 추가
     *
     * @param rsrcReqVo
     */
    void insertRsrcReqVmSpecModReq(RsrcReqVo rsrcReqVo);

    /**
     * 자원요청 가상서버 스토리지추가 요청 추가
     *
     * @param rsrcReqVo
     */
    void insertRsrcReqVmStrgAddReq(RsrcReqVo rsrcReqVo);

    /**
     * 자원요청 가상서버 스토리지삭제 요청 추가(사용안함)
     *
     * @param rsrcReqVo
     */
    /*
     * void insertRsrcReqVmStrgDelReq(RsrcReqVo rsrcReqVo);
     */

    /**
     * 자원요청 가상서버 삭제 요청 추가
     *
     * @param rsrcReqVo
     */
    void insertRsrcReqVmDelReq(RsrcReqVo rsrcReqVo);

    /**
     * 자원요청 물리서버 삭제 요청 추가
     *
     * @param rsrcReqVo
     */
    void insertRsrcReqPmDelReq(RsrcReqVo rsrcReqVo);

    /**
     * 자원요청 물리서버 생성 요청 추가
     *
     * @param rsrcReqVo
     */
    void insertRsrcReqPmCreReq(RsrcReqVo rsrcReqVo);

}
