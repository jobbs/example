package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 템플릿용도 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RrTmplatPrpos {

    /**
     * 템플릿ID
     */
    @NotEmpty(message = "템플릿ID는(은) 필수입력 항목입니다.")
    private Integer tmplatSeq;

    /**
     * 용도일련번호 parent_cd = '118', parent_grp_cd = '019'
     */
    @NotEmpty(message = "용도일련번호는(은) 필수입력 항목입니다.")
    private Integer prposSeq;

    /**
     * 용도내용
     */
    private String prposCd;

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
	 * @return the prposSeq
	 */
	public Integer getPrposSeq() {
		return prposSeq;
	}

	/**
	 * @param prposSeq the prposSeq to set
	 */
	public void setPrposSeq(Integer prposSeq) {
		this.prposSeq = prposSeq;
	}

	/**
	 * @return the prposCn
	 */
	public String getPrposCd() {
		return prposCd;
	}

	/**
	 * @param prposCn the prposCn to set
	 */
	public void setPrposCn(String prposCd) {
		this.prposCd = prposCd;
	}
}
