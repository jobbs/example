package ncis.cmn.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 물리스토리지_NAS Entity - 공통 Entity(등록/수정/삭제용)
 *
 * @author ShinKeeBong
 */

public class RsPStrgNas {

    /**
     * 물리스토리지ID
     */
    @NotEmpty(message = "물리스토리지ID는(은) 필수입력 항목입니다.")
    private String phyStrgId;

    public String getPhyStrgId() {
        return phyStrgId;
    }

    public void setPhyStrgId(String phyStrgId) {
        this.phyStrgId = phyStrgId;
    }

}
