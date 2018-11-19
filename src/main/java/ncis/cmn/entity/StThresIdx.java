package ncis.cmn.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 임계지표 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class StThresIdx {

	/**
	* 지표항목ID
	*/
	@NotEmpty(message="지표항목ID는(은) 필수입력 항목입니다.")
    private BigDecimal idxItmId;

	/**
	* 지표항목명
	*/
	@NotEmpty(message="지표항목명는(은) 필수입력 항목입니다.")
    private String idxItmNm;

    public BigDecimal getIdxItmId() {
        return idxItmId;
    }

    public void setIdxItmId(BigDecimal idxItmId) {
        this.idxItmId = idxItmId;
    }

    public String getIdxItmNm() {
        return idxItmNm;
    }

    public void setIdxItmNm(String idxItmNm) {
        this.idxItmNm = idxItmNm;
    }






}


