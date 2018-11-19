package ncis.cmn.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상디스크 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author 심원보
 */

public class RsVrDsk {

    /**
     * 가상디스크SEQ
     */
    @NotEmpty(message = "가상디스크SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vrDskSeq;

    /**
     * 가상디스크명
     */
    @NotEmpty(message = "가상디스크명는(은) 필수입력 항목입니다.")
    private String vrDskNm;

    /**
     * 가상디스크UUID
     */
    private String vrDskUuid;

    /**
     * 용도코드
     */
    @NotEmpty(message = "용도코드는(은) 필수입력 항목입니다.")
    private String prpos;

    /**
     * 생성일자
     */
    private Date creDt;

    /**
     * 디스크상태코드
     */
    private String dskStatCd;

    /**
     * 디스크유형코드
     */
    private String dskTyCd;

    /**
     * 디스크할당용량(GB)
     */
    private BigDecimal dskAsgnCapa;

    /**
     * 디스크초기설치위치
     */
    private String dskEryyInstlLoca;

    /**
     * 스토리지도메인SEQ
     */
    @NotEmpty(message = "스토리지도메인SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal strgDmnSeq;

    /**
     * 삭제 사용자ID
     */
    private String delUserId;

    /**
     * 삭제시간
     */
    private Timestamp delDttm;

    /**
     * 삭제여부
     */
    private String delYn;

    /**
     * 비고
     */
    private String rmk;


    private String vrDskId;


    private String dskClCd;


    /**
	 * @return the vrDskId
	 */
	public String getVrDskId() {
		return vrDskId;
	}

	/**
	 * @param vrDskId the vrDskId to set
	 */
	public void setVrDskId(String vrDskId) {
		this.vrDskId = vrDskId;
	}

	public String getVrDskNm() {
        return vrDskNm;
    }

    public void setVrDskNm(String vrDskNm) {
        this.vrDskNm = vrDskNm;
    }

    public String getVrDskUuid() {
        return vrDskUuid;
    }

    public void setVrDskUuid(String vrDskUuid) {
        this.vrDskUuid = vrDskUuid;
    }

    public String getPrpos() {
        return prpos;
    }

    public void setPrpos(String prpos) {
        this.prpos = prpos;
    }

    public Date getCreDt() {
        return creDt;
    }

    public void setCreDt(Date creDt) {
        this.creDt = creDt;
    }

    public String getDskStatCd() {
        return dskStatCd;
    }

    public void setDskStatCd(String dskStatCd) {
        this.dskStatCd = dskStatCd;
    }

    public String getDskTyCd() {
        return dskTyCd;
    }

    public void setDskTyCd(String dskTyCd) {
        this.dskTyCd = dskTyCd;
    }

    public BigDecimal getDskAsgnCapa() {
        return dskAsgnCapa;
    }

    public void setDskAsgnCapa(BigDecimal dskAsgnCapa) {
        this.dskAsgnCapa = dskAsgnCapa;
    }

    public String getDskEryyInstlLoca() {
        return dskEryyInstlLoca;
    }

    public void setDskEryyInstlLoca(String dskEryyInstlLoca) {
        this.dskEryyInstlLoca = dskEryyInstlLoca;
    }

    public BigDecimal getVrDskSeq() {
        return vrDskSeq;
    }

    public void setVrDskSeq(BigDecimal vrDskSeq) {
        this.vrDskSeq = vrDskSeq;
    }

    /**
	 * @return the dskClCd
	 */
	public String getDskClCd()
	{
		return dskClCd;
	}

	/**
	 * @param dskClCd the dskClCd to set
	 */
	public void setDskClCd(String dskClCd)
	{
		this.dskClCd = dskClCd;
	}

	public BigDecimal getStrgDmnSeq() {
        return strgDmnSeq;
    }

    public void setStrgDmnSeq(BigDecimal strgDmnSeq) {
        this.strgDmnSeq = strgDmnSeq;
    }

    public String getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(String delUserId) {
        this.delUserId = delUserId;
    }

    public Timestamp getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(Timestamp delDttm) {
        this.delDttm = delDttm;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

}
