/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RsrcReqVo.java
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

import javax.validation.Valid;

import ncis.cmn.entity.RrHaComp;
import ncis.cmn.entity.RrRsrcReq;

public class RsrcReqVo extends RrRsrcReq {

    @Valid
    private ArrayList<RsrcReqPhyRsrcVo> rsrcReqPhyRsrcVoList;

    @Valid
    private ArrayList<RsrcReqVmVo> rsrcReqVmVoList;

    @Valid
    private ArrayList<RsrcReqPmVo> rsrcReqPmVoList;

    private RrHaComp haComp;


    public ArrayList<RsrcReqPhyRsrcVo> getRsrcReqPhyRsrcVoList() {
        return rsrcReqPhyRsrcVoList;
    }

    public void setRsrcReqPhyRsrcVoList(ArrayList<RsrcReqPhyRsrcVo> rsrcReqPhyRsrcVoList) {
        this.rsrcReqPhyRsrcVoList = rsrcReqPhyRsrcVoList;
    }

    public ArrayList<RsrcReqVmVo> getRsrcReqVmVoList() {
        return rsrcReqVmVoList;
    }

    public void setRsrcReqVmVoList(ArrayList<RsrcReqVmVo> rsrcReqVmVoList) {
        this.rsrcReqVmVoList = rsrcReqVmVoList;
    }

    public ArrayList<RsrcReqPmVo> getRsrcReqPmVoList() {
        return rsrcReqPmVoList;
    }

    public void setRsrcReqPmVoList(ArrayList<RsrcReqPmVo> rsrcReqPmVoList) {
        this.rsrcReqPmVoList = rsrcReqPmVoList;
    }

	/**
	 * @return the haComp
	 */
	public RrHaComp getHaComp() {
		return haComp;
	}

	/**
	 * @param haComp the haComp to set
	 */
	public void setHaComp(RrHaComp haComp) {
		this.haComp = haComp;
	}

}
