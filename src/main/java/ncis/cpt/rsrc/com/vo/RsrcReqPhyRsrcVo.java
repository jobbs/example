/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqPhyRsrcVo.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.vo;

import java.util.ArrayList;
import ncis.cmn.entity.RrRsrcReqDtlPRsrc;
import ncis.cpt.rsrc.com.validation.InsertClstrCreReqValidation;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 심원보
 *
 */
public class RsrcReqPhyRsrcVo extends RrRsrcReqDtlPRsrc {

    @NotEmpty(message = "클러스터 용도를 선택해주세요.", groups = { InsertClstrCreReqValidation.class })
    private ArrayList<String> clstrPrposCdList;

    public ArrayList<String> getClstrPrposCdList() {
        return clstrPrposCdList;
    }

    public void setClstrPrposCdList(ArrayList<String> clstrPrposCdList) {
        this.clstrPrposCdList = clstrPrposCdList;
    }

}
