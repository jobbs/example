package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 임계등급 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StThresGrd {

	/**
	* 임계등급ID
	*/
	@NotEmpty(message="임계등급ID는(은) 필수입력 항목입니다.")
    private BigDecimal thresGrdId;

	/**
	* 등급명
	*/
	@NotEmpty(message="등급명는(은) 필수입력 항목입니다.")
    private String grdNm;

	/**
	* 등급구분코드
	*/
	@NotEmpty(message="등급구분코드는(은) 필수입력 항목입니다.")
    private String grdClCd;

    public BigDecimal getThresGrdId() {
        return thresGrdId;
    }

    public void setThresGrdId(BigDecimal thresGrdId) {
        this.thresGrdId = thresGrdId;
    }

    public String getGrdNm() {
        return grdNm;
    }

    public void setGrdNm(String grdNm) {
        this.grdNm = grdNm;
    }

    public String getGrdClCd() {
        return grdClCd;
    }

    public void setGrdClCd(String grdClCd) {
        this.grdClCd = grdClCd;
    }






}


