/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ZoneMngService.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 12.
 * @lastmodified 2016. 10. 12.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 12.     최진호         v1.0             최초생성
 *
 */
package ncis.cpt.sys.zone.service;

import java.util.List;
import ncis.cmn.vo.Tree;
import ncis.cpt.sys.zone.vo.NetVo;
import ncis.cpt.sys.zone.vo.RegionVo;
import ncis.cpt.sys.zone.vo.RsrcPoolVo;
import ncis.cpt.sys.zone.vo.ZoneVo;

/**
 * @author 최진호
 *
 */
public interface ZoneMngService {

    /**
     * 존 관리 트리 정보 호출(POOL 포함)
     * @param parentId
     * @param reqType
     * @param isLazy
     * @return
     */
    Tree<String, ZoneVo> selectZoneAndPoolListTree();

    /**
     * 존 관리 트리 정보 호출(POOL 제외)
     * @param parentId
     * @param reqType
     * @param isLazy
     * @return
     */
    Tree<String, ZoneVo> selectZoneListTree();

    /**
     * 센터 정보 조회
     * @param regionId
     * @return
     */
    RegionVo selectRegion(String regionId);

    /**
     * 센터 정보 등록
     * @param region
     */
    void insertRegion(RegionVo region);

    /**
     * 센터 정보 수정
     * @param region
     */
    void updateRegion(RegionVo region);

    /**
     * 센터의 하위 존이 존재하는지 여부 확인
     * @param regionId
     * @return
     */
    boolean selectExistZoneByRegion(String regionId);

    /**
     * 센터 삭제
     * @param regionId
     */
    void deleteRegion(String regionId);


    /**
     * 존 상제 섲보 조회
     * @param zoneId
     * @return
     */
    ZoneVo selectZone(String zoneId);

    /**
     * 존 정보 등록
     * @param zone
     */
    void insertZone(ZoneVo zone);

    /**
     * 존 정보 수정
     * @param zone
     */
    void updateZone(ZoneVo zone);

    /**
     * 존의 하위 망이 존재하는지 여부 확인
     * @param zoneId
     * @return
     */
    boolean selectExistNetByZone(String zoneId);

    /**
     * 존의 하위 망이 목록 조회
     * @param zoneId
     * @param netClCd
     * @return
     */
    List<NetVo> selectNetListByPool(String zoneId, String netClCd);

    /**
     * 존 삭제
     * @param zoneId
     */
    void deleteZone(String zoneId);

    /**
     * 망 정보 등록
     * @param zoneNet
     */
    void insertNet(NetVo net);

    /**
     * 망 정보 수정
     * @param zoneNet
     */
    void updateNet(NetVo net);

    /**
     * 망정보 조회
     * @param netId
     * @return
     */
    NetVo selectNet(String netId);

    /**
     * 망의 하위 자원풀이 존재하는지 여부 확인
     * @param zoneId
     * @param netId
     * @return
     */
    boolean selectExistPoolByNet(String netId);

    /**
     * 망 삭제
     * @param regionId
     * @param netId
     */
    void deleteNet(String netId);

    /**
     * 자원풀 정보 조회
     * @param rsrcPoolId
     * @return
     */
    RsrcPoolVo selectPool(String rsrcPoolId);

    /**
     * 자원풀 위치 이동
     * @param netId
     * @param poolId
     */
    void updateMoveRsrcPool(String netId, String poolId);

	/**
	 * 자원풀 정보 수정
	 * @param poolVo
	 */
	void updatePool(RsrcPoolVo poolVo);

}
