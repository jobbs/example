/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TestVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cpt.cmn.vo;

import java.util.List;
import ncis.cmn.validation.constrains.NullPattern;
import org.hibernate.validator.constraints.NotEmpty;

public class TestVo {

    private List<String> testCheck;


	/**
	 * 필수항목
	 */
	@NotEmpty(message="essential은 필수항목입니다.")
	private String essential;

	/**
	 * 숫자만
	 */
	@NullPattern(regexp="^[1-9]+\\d*$", message="onlyNumber는 숫자만 입력하세요.")
	private String onlyNumber;

	/**
	 * 정수만
	 */
	@NullPattern(regexp="^[1-9]+\\d*$", message="onlyNumber는 숫자만 입력하세요.")
	private String onlyInteger;

	/**
	 * 기호형정수만
	 */
	@NullPattern(regexp="^([-]?[1-9])+\\d*$", message="onlySignInteger은 기호가 시작하거나 숫자로 입력하여 주시기 바랍니다.")
	private String onlySignInteger;

	/**
	 * 콤마가 있는 정수
	 */
	@NullPattern(regexp="^(\\d{1,3})([,]\\d{3})*$", message="onlyIntegerNF은 숫자의 3자리마다 ,가 들어가도록 입력하시기 바랍니다.")
	private String onlyIntegerNF;

	/**
	 * 기호 콤마 정수
	 */
	@NullPattern(regexp="^(-?\\d{1,3})([,]\\d{3})*$", message="onlySignIntegerNF은 부호가 있거나 없는 숫자만를 3자리마다 ,가 들어가도록 입력하시기 바랍니다.")
	private String onlySignIntegerNF;


	/**
	 * 실수형
	 */
	@NullPattern(regexp="^\\d+((\\.?)\\d+)?$", message="onlyFloat은 실수형으로 입력하여 주시기 바랍니다.")
	private String onlyFloat;

	/**
	 * 기호 실수
	 */
	@NullPattern(regexp="^-?(\\d+)((\\.?)\\d+)?$", message="onlySignFloat은 부호가 있는 실수형으로 입력하여 주시기 바랍니다.")
	private String onlySignFloat;

	/**
	 * 콤마 실수형
	 */
	@NullPattern(regexp="^(\\d{1,3})([,]\\d{3})*((\\.?)\\d+)?$", message="onlyFloatNF은 부호가 있는 실수형으로 입력하여 주시기 바랍니다.")
	private String onlyFloatNF;

	/**
	 * 기호 콤마 실수형
	 */
	@NullPattern(regexp="^-?(\\d{1,3})([,]\\d{3})*((\\.?)\\d+)?$", message="onlySignFloatNF은 부호가 있는 실수형을 소수점 앞에 3자리마다 ,가 들어가도록 입력하여 주시기 바랍니다.")
	private String onlySignFloatNF;

	/**
	 * 영문만
	 */
	@NullPattern(regexp="^[a-zA-Z]*$", message="onlyAlpha은 영문만 입력하여 주시기 바랍니다.")
	private String onlyAlpha;

	/**
	 * 영문과 숫자만
	 */
	@NullPattern(regexp="^[0-9a-zA-Z]*$", message="onlyAlphaNum은 영문과 숫자만 입력하여 주시기 바랍니다.")
	private String onlyAlphaNum;

	/**
	 * 영문과 숫자 그리고 -
	 */
	@NullPattern(regexp="^[0-9a-zA-Z-]*$", message="onlyAlphaNumDash은 영문과 숫자 그리고 -만 입력하여 주시기 바랍니다.")
	private String onlyAlphaNumDash;

	/**
	 * 영문과 숫자 그리고 -
	 */
	@NullPattern(regexp="^[0-9-]*$", message="onlyNumDash은 숫자 그리고 -만 입력하여 주시기 바랍니다.")
	private String onlyNumDash;


	private String onlyDate;

	private String onlyPhone;


	@NullPattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", message="onlyEmail은 이메일 형식만 입력하여 주시기 바랍니다.")
	private String onlyEmail;

	/**
	 * @return the essential
	 */
	public String getEssential() {
		return essential;
	}

	/**
	 * @param essential the essential to set
	 */
	public void setEssential(String essential) {
		this.essential = essential;
	}

	/**
	 * @return the onlyNumber
	 */
	public String getOnlyNumber() {
		return onlyNumber;
	}

	/**
	 * @param onlyNumber the onlyNumber to set
	 */
	public void setOnlyNumber(String onlyNumber) {
		this.onlyNumber = onlyNumber;
	}

	/**
	 * @return the onlyInteger
	 */
	public String getOnlyInteger() {
		return onlyInteger;
	}

	/**
	 * @param onlyInteger the onlyInteger to set
	 */
	public void setOnlyInteger(String onlyInteger) {
		this.onlyInteger = onlyInteger;
	}

	/**
	 * @return the onlySignInteger
	 */
	public String getOnlySignInteger() {
		return onlySignInteger;
	}

	/**
	 * @param onlySignInteger the onlySignInteger to set
	 */
	public void setOnlySignInteger(String onlySignInteger) {
		this.onlySignInteger = onlySignInteger;
	}

	/**
	 * @return the onlyIntegerNF
	 */
	public String getOnlyIntegerNF() {
		return onlyIntegerNF;
	}

	/**
	 * @param onlyIntegerNF the onlyIntegerNF to set
	 */
	public void setOnlyIntegerNF(String onlyIntegerNF) {
		this.onlyIntegerNF = onlyIntegerNF;
	}

	/**
	 * @return the onlySignIntegerNF
	 */
	public String getOnlySignIntegerNF() {
		return onlySignIntegerNF;
	}

	/**
	 * @param onlySignIntegerNF the onlySignIntegerNF to set
	 */
	public void setOnlySignIntegerNF(String onlySignIntegerNF) {
		this.onlySignIntegerNF = onlySignIntegerNF;
	}

	/**
	 * @return the onlyFloat
	 */
	public String getOnlyFloat() {
		return onlyFloat;
	}

	/**
	 * @param onlyFloat the onlyFloat to set
	 */
	public void setOnlyFloat(String onlyFloat) {
		this.onlyFloat = onlyFloat;
	}

	/**
	 * @return the onlySignFloat
	 */
	public String getOnlySignFloat() {
		return onlySignFloat;
	}

	/**
	 * @param onlySignFloat the onlySignFloat to set
	 */
	public void setOnlySignFloat(String onlySignFloat) {
		this.onlySignFloat = onlySignFloat;
	}

	/**
	 * @return the onlyFloatNF
	 */
	public String getOnlyFloatNF() {
		return onlyFloatNF;
	}

	/**
	 * @param onlyFloatNF the onlyFloatNF to set
	 */
	public void setOnlyFloatNF(String onlyFloatNF) {
		this.onlyFloatNF = onlyFloatNF;
	}

	/**
	 * @return the onlySignFloatNF
	 */
	public String getOnlySignFloatNF() {
		return onlySignFloatNF;
	}

	/**
	 * @param onlySignFloatNF the onlySignFloatNF to set
	 */
	public void setOnlySignFloatNF(String onlySignFloatNF) {
		this.onlySignFloatNF = onlySignFloatNF;
	}

	/**
	 * @return the onlyAlpha
	 */
	public String getOnlyAlpha() {
		return onlyAlpha;
	}

	/**
	 * @param onlyAlpha the onlyAlpha to set
	 */
	public void setOnlyAlpha(String onlyAlpha) {
		this.onlyAlpha = onlyAlpha;
	}

	/**
	 * @return the onlyAlphaNum
	 */
	public String getOnlyAlphaNum() {
		return onlyAlphaNum;
	}

	/**
	 * @param onlyAlphaNum the onlyAlphaNum to set
	 */
	public void setOnlyAlphaNum(String onlyAlphaNum) {
		this.onlyAlphaNum = onlyAlphaNum;
	}

	/**
	 * @return the onlyAlphaNumDash
	 */
	public String getOnlyAlphaNumDash() {
		return onlyAlphaNumDash;
	}

	/**
	 * @param onlyAlphaNumDash the onlyAlphaNumDash to set
	 */
	public void setOnlyAlphaNumDash(String onlyAlphaNumDash) {
		this.onlyAlphaNumDash = onlyAlphaNumDash;
	}

	/**
	 * @return the onlyNumDash
	 */
	public String getOnlyNumDash() {
		return onlyNumDash;
	}

	/**
	 * @param onlyNumDash the onlyNumDash to set
	 */
	public void setOnlyNumDash(String onlyNumDash) {
		this.onlyNumDash = onlyNumDash;
	}

	/**
	 * @return the onlyDate
	 */
	public String getOnlyDate() {
		return onlyDate;
	}

	/**
	 * @param onlyDate the onlyDate to set
	 */
	public void setOnlyDate(String onlyDate) {
		this.onlyDate = onlyDate;
	}

	/**
	 * @return the onlyPhone
	 */
	public String getOnlyPhone() {
		return onlyPhone;
	}

	/**
	 * @param onlyPhone the onlyPhone to set
	 */
	public void setOnlyPhone(String onlyPhone) {
		this.onlyPhone = onlyPhone;
	}

	/**
	 * @return the onlyEmail
	 */
	public String getOnlyEmail() {
		return onlyEmail;
	}

	/**
	 * @param onlyEmail the onlyEmail to set
	 */
	public void setOnlyEmail(String onlyEmail) {
		this.onlyEmail = onlyEmail;
	}

    /**
     * @return the testCheck
     */
    public List<String> getTestCheck() {
        return testCheck;
    }

    /**
     * @param testCheck the testCheck to set
     */
    public void setTestCheck(List<String> testCheck) {
        this.testCheck = testCheck;
    }
}
