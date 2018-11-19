/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * WthdrwStPerInstVo.java
 *
 * @author 양정순
 * @lastmodifier 양정순
 * @created 2016. 12. 10
 * @lastmodified2016. 12. 10
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 10   양정순         v1.0             최초생성
 *
 */

package ncis.dsb.stts.rsrcoptz.vo;

import java.math.BigDecimal;

public class WthdrwStPerInstVo{

		private String institutionId;
		private String institutionNm;
		private String regionId;
		private String regionNm;
		private String stdrYr;
		private String quarter;
		private long rn;
		private BigDecimal returnReqQtyVm;
		private BigDecimal returnReqQtyVcore;
		private BigDecimal returnReqQtyMem;
		private BigDecimal returnReqQtySan;
		private BigDecimal returnQtyVm;
		private BigDecimal returnQtyVcore;
		private BigDecimal returnQtyMem;
		private BigDecimal returnQtySan;
		private BigDecimal returnRtVm;
		private BigDecimal returnRtVcore;
		private BigDecimal returnRtMem;
		private BigDecimal returnRtSan;
		/**
		 * @return the institutionId
		 */
		public String getInstitutionId() {
			return institutionId;
		}
		/**
		 * @param institutionId the institutionId to set
		 */
		public void setInstitutionId(String institutionId) {
			this.institutionId = institutionId;
		}
		/**
		 * @return the institutionNm
		 */
		public String getInstitutionNm() {
			return institutionNm;
		}
		/**
		 * @param institutionNm the institutionNm to set
		 */
		public void setInstitutionNm(String institutionNm) {
			this.institutionNm = institutionNm;
		}
		/**
		 * @return the regionId
		 */
		public String getRegionId() {
			return regionId;
		}
		/**
		 * @param regionId the regionId to set
		 */
		public void setRegionId(String regionId) {
			this.regionId = regionId;
		}
		/**
		 * @return the regionNm
		 */
		public String getRegionNm() {
			return regionNm;
		}
		/**
		 * @param regionNm the regionNm to set
		 */
		public void setRegionNm(String regionNm) {
			this.regionNm = regionNm;
		}
		/**
		 * @return the stdrYr
		 */
		public String getStdrYr() {
			return stdrYr;
		}
		/**
		 * @param stdrYr the stdrYr to set
		 */
		public void setStdrYr(String stdrYr) {
			this.stdrYr = stdrYr;
		}
		/**
		 * @return the quarter
		 */
		public String getQuarter() {
			return quarter;
		}
		/**
		 * @param quarter the quarter to set
		 */
		public void setQuarter(String quarter) {
			this.quarter = quarter;
		}
		/**
		 * @return the rn
		 */
		public long getRn() {
			return rn;
		}
		/**
		 * @param rn the rn to set
		 */
		public void setRn(long rn) {
			this.rn = rn;
		}
		/**
		 * @return the returnReqQtyVm
		 */
		public BigDecimal getReturnReqQtyVm() {
			return returnReqQtyVm;
		}
		/**
		 * @param returnReqQtyVm the returnReqQtyVm to set
		 */
		public void setReturnReqQtyVm(BigDecimal returnReqQtyVm) {
			this.returnReqQtyVm = returnReqQtyVm;
		}
		/**
		 * @return the returnReqQtyVcore
		 */
		public BigDecimal getReturnReqQtyVcore() {
			return returnReqQtyVcore;
		}
		/**
		 * @param returnReqQtyVcore the returnReqQtyVcore to set
		 */
		public void setReturnReqQtyVcore(BigDecimal returnReqQtyVcore) {
			this.returnReqQtyVcore = returnReqQtyVcore;
		}
		/**
		 * @return the returnReqQtyMem
		 */
		public BigDecimal getReturnReqQtyMem() {
			return returnReqQtyMem;
		}
		/**
		 * @param returnReqQtyMem the returnReqQtyMem to set
		 */
		public void setReturnReqQtyMem(BigDecimal returnReqQtyMem) {
			this.returnReqQtyMem = returnReqQtyMem;
		}
		/**
		 * @return the returnReqQtySan
		 */
		public BigDecimal getReturnReqQtySan() {
			return returnReqQtySan;
		}
		/**
		 * @param returnReqQtySan the returnReqQtySan to set
		 */
		public void setReturnReqQtySan(BigDecimal returnReqQtySan) {
			this.returnReqQtySan = returnReqQtySan;
		}
		/**
		 * @return the returnQtyVm
		 */
		public BigDecimal getReturnQtyVm() {
			return returnQtyVm;
		}
		/**
		 * @param returnQtyVm the returnQtyVm to set
		 */
		public void setReturnQtyVm(BigDecimal returnQtyVm) {
			this.returnQtyVm = returnQtyVm;
		}
		/**
		 * @return the returnQtyVcore
		 */
		public BigDecimal getReturnQtyVcore() {
			return returnQtyVcore;
		}
		/**
		 * @param returnQtyVcore the returnQtyVcore to set
		 */
		public void setReturnQtyVcore(BigDecimal returnQtyVcore) {
			this.returnQtyVcore = returnQtyVcore;
		}
		/**
		 * @return the returnQtyMem
		 */
		public BigDecimal getReturnQtyMem() {
			return returnQtyMem;
		}
		/**
		 * @param returnQtyMem the returnQtyMem to set
		 */
		public void setReturnQtyMem(BigDecimal returnQtyMem) {
			this.returnQtyMem = returnQtyMem;
		}
		/**
		 * @return the returnQtySan
		 */
		public BigDecimal getReturnQtySan() {
			return returnQtySan;
		}
		/**
		 * @param returnQtySan the returnQtySan to set
		 */
		public void setReturnQtySan(BigDecimal returnQtySan) {
			this.returnQtySan = returnQtySan;
		}
		/**
		 * @return the returnRtVm
		 */
		public BigDecimal getReturnRtVm() {
			return returnRtVm;
		}
		/**
		 * @param returnRtVm the returnRtVm to set
		 */
		public void setReturnRtVm(BigDecimal returnRtVm) {
			this.returnRtVm = returnRtVm;
		}
		/**
		 * @return the returnRtVcore
		 */
		public BigDecimal getReturnRtVcore() {
			return returnRtVcore;
		}
		/**
		 * @param returnRtVcore the returnRtVcore to set
		 */
		public void setReturnRtVcore(BigDecimal returnRtVcore) {
			this.returnRtVcore = returnRtVcore;
		}
		/**
		 * @return the returnRtMem
		 */
		public BigDecimal getReturnRtMem() {
			return returnRtMem;
		}
		/**
		 * @param returnRtMem the returnRtMem to set
		 */
		public void setReturnRtMem(BigDecimal returnRtMem) {
			this.returnRtMem = returnRtMem;
		}
		/**
		 * @return the returnRtSan
		 */
		public BigDecimal getReturnRtSan() {
			return returnRtSan;
		}
		/**
		 * @param returnRtSan the returnRtSan to set
		 */
		public void setReturnRtSan(BigDecimal returnRtSan) {
			this.returnRtSan = returnRtSan;
		}


}
