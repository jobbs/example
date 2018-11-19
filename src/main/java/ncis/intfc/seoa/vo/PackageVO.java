/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename PackageVO.java
 *
 * @author ShinKeeBong
 * @lastmodifier ShinKeeBong
 * @created 2016. 10. 20.
 * @lastmodified 2016. 10. 20.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 20.     ShinKeeBong         v1.0             최초생성
 *
 */
package ncis.intfc.seoa.vo;

/**
 * @author ShinKeeBong
 *
 */
public class PackageVO {

	private String epoch;        //epoch
	private String installDate;  //패키지 설치 날짜
	private String name;         //패키지명
	private String release;      //패키지 릴리즈
	private String version;      //패키지 버전


	public String getEpoch() {
		return epoch;
	}
	public void setEpoch(String epoch) {
		this.epoch = epoch;
	}
	public String getInstallDate() {
		return installDate;
	}
	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}


}
