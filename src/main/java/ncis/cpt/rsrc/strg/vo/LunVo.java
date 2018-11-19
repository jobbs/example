/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename LunVo.java
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 10. 31.
 * @lastmodified 2016. 10. 31.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 31.     신재훈         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.strg.vo;

import ncis.cmn.entity.RsLun;

/**
 * @author 신재훈
 *
 */
public class LunVo extends RsLun {
    private String clstrCompId; // 클러스터 구성 ID
    private String clstrNm; // 클러스터 명
    private String pmCompId; // 물리서버 구성 ID
    private String pmNm; // 물리서버 명
    private String strgTyCdNm; // 스토리지 구분 코드
    private String phyStrgNm; // 물리스토리지 명
    private String phyStrgAsgnCapa; // 물리스토리지 할당용량

    public String getClstrCompId() {
        return clstrCompId;
    }

    public void setClstrCompId(String clstrCompId) {
        this.clstrCompId = clstrCompId;
    }

    public String getClstrNm() {
        return clstrNm;
    }

    public void setClstrNm(String clstrNm) {
        this.clstrNm = clstrNm;
    }

    public String getPmCompId() {
        return pmCompId;
    }

    public void setPmCompId(String pmCompId) {
        this.pmCompId = pmCompId;
    }

    public String getPmNm() {
        return pmNm;
    }

    public void setPmNm(String pmNm) {
        this.pmNm = pmNm;
    }

    public String getPhyStrgNm() {
        return phyStrgNm;
    }

    public void setPhyStrgNm(String phyStrgNm) {
        this.phyStrgNm = phyStrgNm;
    }

    public String getPhyStrgAsgnCapa() {
        return phyStrgAsgnCapa;
    }

    public void setPhyStrgAsgnCapa(String phyStrgAsgnCapa) {
        this.phyStrgAsgnCapa = phyStrgAsgnCapa;
    }

    public String getStrgTyCdNm() {
        return strgTyCdNm;
    }

    public void setStrgTyCdNm(String strgTyCdNm) {
        this.strgTyCdNm = strgTyCdNm;
    }

}
