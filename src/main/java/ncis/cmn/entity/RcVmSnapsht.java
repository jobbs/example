package ncis.cmn.entity;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

import ncis.cmn.validation.groups.UpdateProc;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 가상서버스냅샷 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RcVmSnapsht {

    /**
     * 스냅샷ID
     */
    @NotEmpty(message = "스냅샷SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal snapshtSeq;

    /**
     * 스냅샷명
     */
    @NotEmpty(message = "스냅샷명는(은) 필수입력 항목입니다.", groups = { UpdateProc.class })
    @Size(message = "스냅샷명은 {max}자 이내로 입력해주세요.", min = 0, max = 60, groups = { UpdateProc.class })
    private String snapshtNm;

    /**
     * 스냅샷생성일시
     */
    @NotEmpty(message = "스냅샷생성일시는(은) 필수입력 항목입니다.")
    private String snapshtCreDt;

    /**
     * 상태코드
     */
    @NotEmpty(message = "상태코드는(은) 필수입력 항목입니다.")
    private String statCd;

    /**
     * 유형코드
     */
    private String tyCd;

    /**
     * 디스크번호
     */
    private String dskNo;

    /**
     * 비고
     */
    @Size(message="비고는 {max}자 이내로 입력해주세요.", min=0, max=1000, groups={UpdateProc.class})
    private String rmk;

    /**
     * 가상서버SEQ
     */
    @NotEmpty(message = "가상서버SEQ는(은) 필수입력 항목입니다.")
    private BigDecimal vmSeq;

    private String uuid;

    /**
     * 스냅샷 용량
     */
    private Double snapshtAsgnCapa;

    public BigDecimal getSnapshtSeq() {
        return snapshtSeq;
    }

    public void setSnapshtSeq(BigDecimal snapshtSeq) {
        this.snapshtSeq = snapshtSeq;
    }

    public String getSnapshtNm() {
        return snapshtNm;
    }

    public void setSnapshtNm(String snapshtNm) {
        this.snapshtNm = snapshtNm;
    }

    public String getSnapshtCreDt() {
        return snapshtCreDt;
    }

    public void setSnapshtCreDt(String snapshtCreDt) {
        this.snapshtCreDt = snapshtCreDt;
    }

    public String getStatCd() {
        return statCd;
    }

    public void setStatCd(String statCd) {
        this.statCd = statCd;
    }

    public String getTyCd() {
        return tyCd;
    }

    public void setTyCd(String tyCd) {
        this.tyCd = tyCd;
    }

    public String getDskNo() {
        return dskNo;
    }

    public void setDskNo(String dskNo) {
        this.dskNo = dskNo;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    public BigDecimal getVmSeq() {
        return vmSeq;
    }

    public void setVmSeq(BigDecimal vmSeq) {
        this.vmSeq = vmSeq;
    }

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Double getSnapshtAsgnCapa() {
		return snapshtAsgnCapa;
	}

	public void setSnapshtAsgnCapa(Double snapshtAsgnCapa) {
		this.snapshtAsgnCapa = snapshtAsgnCapa;
	}

}
