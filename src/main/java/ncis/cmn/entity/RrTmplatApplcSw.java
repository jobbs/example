package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 템플릿적용소프트웨어 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrTmplatApplcSw {

    /**
     * 소프트웨어ID
     */
    @NotEmpty(message = "소프트웨어SEQ는(은) 필수입력 항목입니다.")
    private Integer swSeq;

    /**
     * 템플릿ID
     */
    @NotEmpty(message = "템플릿SEQ는(은) 필수입력 항목입니다.")
    private Integer tmplatSeq;

	/**
	 * @return the swSeq
	 */
	public Integer getSwSeq() {
		return swSeq;
	}

	/**
	 * @param swSeq the swSeq to set
	 */
	public void setSwSeq(Integer swSeq) {
		this.swSeq = swSeq;
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
}
