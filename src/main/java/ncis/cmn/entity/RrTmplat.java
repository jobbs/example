package ncis.cmn.entity;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 템플릿 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrTmplat {

    /**
     * 템플릿ID
     */
    @NotEmpty(message = "템플릿ID는(은) 필수입력 항목입니다.")
    private String tmplatId;

    /**
     * 템플릿명
     */
    @NotEmpty(message = "템플릿명는(은) 필수입력 항목입니다.")
    private String tmplatNm;

    /**
     * 템플릿구분코드
     */
    @NotEmpty(message = "템플릿구분코드는(은) 필수입력 항목입니다.")
    private String tmplatClCd;

    /**
     * 사용여부
     */
    @NotEmpty(message = "사용여부는(은) 필수입력 항목입니다.")
    private String useYn;

    /**
     * 비고
     */
    private String rmk;
    /**
	 * 기존 유효ID
	 */
    private String tmplatValidId;

    /**
     * 가상화SW유형코드
     */
    @NotEmpty(message = "가상화SW유형코드는(은) 필수입력 항목입니다.")
    private String vrlzSwTyCd;

    /**
     * 운영체제유형코드
     */
    private String osTyCd;

    /**
     * 운영체제명
     */
    private String osNm;

    /**
     * 운영체제버전
     */
    private String osVer;

    /**
     * 플랫폼
     */
    private String pltfrm;

    /**
     * 운영체제비트
     */
    private String osBit;

    /**
     * 커널버전
     */
    private String krnlVer;

    /**
     * 언어
     */
    private String lang;

    /**
     * 스토리지할당용량(GB)
     */
    private Integer strgAsgnCapa;

    /**
     * 템플릿버전
     */
    private String tmplatVer;

    /**
     * 자원풀ID
     */
    private String rsrcPoolId;

    /**
     * 스태틱라우팅 스크립트 SEQ
     */
    private Long sRoutingScriptSeq;

    /**
     * 등록자ID
     */
    private String regUserId;

    /**
     * 등록일시
     */
    private Timestamp regDttm;

    /**
     * 수정자ID
     */
    private String updtUserId;

    /**
     * 수정일시
     */
    private Timestamp updtDttm;

    /**
     * 템플릿시퀀스
     */
    @NotEmpty(message = "템플릿시퀀스는(은) 필수입력 항목입니다.")
    private Integer tmplatSeq;

    /**
     * 가상서버생성진행여부
     */
    private String vmCrePrcssYn;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 삭제자ID
     */
    private String delUserId;

    /**
     * 삭제일시
     */
    private Timestamp delDttm;

    /**
     * 삭제여부
     */
    private String delYn;

    /**
     * 스토리지도메인SEQ
     */
    private Integer strgDmnSeq;

	/**
	 * @return the tmplatId
	 */
	public String getTmplatId() {
		return tmplatId;
	}

	/**
	 * @param tmplatId the tmplatId to set
	 */
	public void setTmplatId(String tmplatId) {
		this.tmplatId = tmplatId;
	}

	/**
	 * @return the tmplatNm
	 */
	public String getTmplatNm() {
		return tmplatNm;
	}

	/**
	 * @param tmplatNm the tmplatNm to set
	 */
	public void setTmplatNm(String tmplatNm) {
		this.tmplatNm = tmplatNm;
	}

	/**
	 * @return the tmplatClCd
	 */
	public String getTmplatClCd() {
		return tmplatClCd;
	}

	/**
	 * @param tmplatClCd the tmplatClCd to set
	 */
	public void setTmplatClCd(String tmplatClCd) {
		this.tmplatClCd = tmplatClCd;
	}

	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}

	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	/**
	 * @return the rmk
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * @param rmk the rmk to set
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	/**
	 * @return the vrlzSwTyCd
	 */
	public String getVrlzSwTyCd() {
		return vrlzSwTyCd;
	}

	/**
	 * @param vrlzSwTyCd the vrlzSwTyCd to set
	 */
	public void setVrlzSwTyCd(String vrlzSwTyCd) {
		this.vrlzSwTyCd = vrlzSwTyCd;
	}

	/**
	 * @return the osTyCd
	 */
	public String getOsTyCd() {
		return osTyCd;
	}

	/**
	 * @param osTyCd the osTyCd to set
	 */
	public void setOsTyCd(String osTyCd) {
		this.osTyCd = osTyCd;
	}

	/**
	 * @return the osNm
	 */
	public String getOsNm() {
		return osNm;
	}

	/**
	 * @param osNm the osNm to set
	 */
	public void setOsNm(String osNm) {
		this.osNm = osNm;
	}

	/**
	 * @return the osVer
	 */
	public String getOsVer() {
		return osVer;
	}

	/**
	 * @param osVer the osVer to set
	 */
	public void setOsVer(String osVer) {
		this.osVer = osVer;
	}

	/**
	 * @return the pltfrm
	 */
	public String getPltfrm() {
		return pltfrm;
	}

	/**
	 * @param pltfrm the pltfrm to set
	 */
	public void setPltfrm(String pltfrm) {
		this.pltfrm = pltfrm;
	}

	/**
	 * @return the osBit
	 */
	public String getOsBit() {
		return osBit;
	}

	/**
	 * @param osBit the osBit to set
	 */
	public void setOsBit(String osBit) {
		this.osBit = osBit;
	}

	/**
	 * @return the krnlVer
	 */
	public String getKrnlVer() {
		return krnlVer;
	}

	/**
	 * @param krnlVer the krnlVer to set
	 */
	public void setKrnlVer(String krnlVer) {
		this.krnlVer = krnlVer;
	}

	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * @return the strgAsgnCapa
	 */
	public Integer getStrgAsgnCapa() {
		return strgAsgnCapa;
	}

	/**
	 * @param strgAsgnCapa the strgAsgnCapa to set
	 */
	public void setStrgAsgnCapa(Integer strgAsgnCapa) {
		this.strgAsgnCapa = strgAsgnCapa;
	}

	/**
	 * @return the tmplatVer
	 */
	public String getTmplatVer() {
		return tmplatVer;
	}

	/**
	 * @param tmplatVer the tmplatVer to set
	 */
	public void setTmplatVer(String tmplatVer) {
		this.tmplatVer = tmplatVer;
	}

	/**
	 * @return the rsrcPoolId
	 */
	public String getRsrcPoolId() {
		return rsrcPoolId;
	}

	/**
	 * @param rsrcPoolId the rsrcPoolId to set
	 */
	public void setRsrcPoolId(String rsrcPoolId) {
		this.rsrcPoolId = rsrcPoolId;
	}

	/**
	 * @return the regUserId
	 */
	public String getRegUserId() {
		return regUserId;
	}

	/**
	 * @param regUserId the regUserId to set
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}

	/**
	 * @return the regDttm
	 */
	public Date getRegDttm() {
		return regDttm;
	}

	/**
	 * @param regDttm the regDttm to set
	 */
	public void setRegDttm(Timestamp regDttm) {
		this.regDttm = regDttm;
	}

	/**
	 * @return the updtUserId
	 */
	public String getUpdtUserId() {
		return updtUserId;
	}

	/**
	 * @param updtUserId the updtUserId to set
	 */
	public void setUpdtUserId(String updtUserId) {
		this.updtUserId = updtUserId;
	}

	/**
	 * @return the updtDttm
	 */
	public Date getUpdtDttm() {
		return updtDttm;
	}

	/**
	 * @param updtDttm the updtDttm to set
	 */
	public void setUpdtDttm(Timestamp updtDttm) {
		this.updtDttm = updtDttm;
	}

	/**
	 * @return the tmplatSeq
	 */
	public Integer getTmplatSeq() {
		return tmplatSeq;
	}

	/**
	 * @param tmplatSeq the tmplatSeq to set
	 */
	public void setTmplatSeq(Integer tmplatSeq) {
		this.tmplatSeq = tmplatSeq;
	}

	/**
	 * @return the vmCrePrcssYn
	 */
	public String getVmCrePrcssYn() {
		return vmCrePrcssYn;
	}

	/**
	 * @param vmCrePrcssYn the vmCrePrcssYn to set
	 */
	public void setVmCrePrcssYn(String vmCrePrcssYn) {
		this.vmCrePrcssYn = vmCrePrcssYn;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the delUserId
	 */
	public String getDelUserId() {
		return delUserId;
	}

	/**
	 * @param delUserId the delUserId to set
	 */
	public void setDelUserId(String delUserId) {
		this.delUserId = delUserId;
	}

	/**
	 * @return the delDttm
	 */
	public Timestamp getDelDttm() {
		return delDttm;
	}

	/**
	 * @param delDttm the delDttm to set
	 */
	public void setDelDttm(Timestamp delDttm) {
		this.delDttm = delDttm;
	}

	/**
	 * @return the delYn
	 */
	public String getDelYn() {
		return delYn;
	}

	/**
	 * @param delYn the delYn to set
	 */
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	/**
	 * @return the strgDmnSeq
	 */
	public Integer getStrgDmnSeq() {
		return strgDmnSeq;
	}

	/**
	 * @param strgDmnSeq the strgDmnSeq to set
	 */
	public void setStrgDmnSeq(Integer strgDmnSeq) {
		this.strgDmnSeq = strgDmnSeq;
	}

	/**
	 * @return the tmplatValidId
	 */
	public String getTmplatValidId() {
		return tmplatValidId;
	}

	/**
	 * @param tmplatValidId the tmplatValidId to set
	 */
	public void setTmplatValidId(String tmplatValidId) {
		this.tmplatValidId = tmplatValidId;
	}

	/**
	 * @return the sRoutingScriptSeq
	 */
	public Long getsRoutingScriptSeq() {
		return sRoutingScriptSeq;
	}

	/**
	 * @param sRoutingScriptSeq the sRoutingScriptSeq to set
	 */
	public void setsRoutingScriptSeq(Long sRoutingScriptSeq) {
		this.sRoutingScriptSeq = sRoutingScriptSeq;
	}
}
