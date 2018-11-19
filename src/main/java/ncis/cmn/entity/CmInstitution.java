package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 기관 Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class CmInstitution {

	/**
	* 기관ID
	*/
	@NotEmpty(message="부처ID는(은) 필수입력 항목입니다.")
    private String institutionId;

	/**
	* 기관명
	*/
	@NotEmpty(message="부처명은 필수입력 항목입니다.")
    private String institutionNm;

    /**
     * 사용여부
     */
    private String useYn;

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionNm() {
        return institutionNm;
    }

    public void setInstitutionNm(String institutionNm) {
        this.institutionNm = institutionNm;
    }

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}


}


