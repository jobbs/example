package ncis.dsb.cmn.vo;
import java.math.BigDecimal;

public class ManagerSttsVo  {
	private String mngCd;
	private String mngNm;
	private BigDecimal mngCnt;

	/**
	 * @return the mngCd
	 */
	public String getMngCd() {
		return mngCd;
	}
	/**
	 * @param rhev the rhev to set
	 */
	public void setMngCd(String mngCd) {
		this.mngCd = mngCd;
	}
	/**
	 * @return the mngNm
	 */
	public String getMngNm() {
		return mngNm;
	}
	/**
	 * @param vmware the vmware to set
	 */
	public void setMngNm(String mngNm) {
		this.mngNm = mngNm;
	}
	/**
	 * @return the mngCnt
	 */
	public BigDecimal getMngCnt() {
		return mngCnt;
	}
	/**
	 * @param ibm the mngCnt to set
	 */
	public void setMngCnt(BigDecimal mngCnt) {
		this.mngCnt = mngCnt;
	}

}
