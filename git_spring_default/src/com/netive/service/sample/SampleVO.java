/* ###################################################################################################### 
 * ### @AUTHOR   : NETIVE
 * ### @DATE     : 2018.07. 
 * ### @TITLE    : SPRING MVC VALUE OBJECT(VO) SAMPLE
 * ### @DESCRIPT : 	＊ SPRING VO 객체의 기본 적인 구조
 * ### 				＊ 인자 정보에 대한 GET/SET 명세를 작성합니다.
 * ### 				＊ 인자들의 기본값에 대한 설정은 VO객체에서 정의 합니다.
 * ### 				＊ REQUEST/RESPONSE에 대한 데이터 처리 및 데이터베이스 인자 객체를 위한 DTO의 역활까지 모두 수행 합니다.
 * ### 				＊ 가급적 VO객체를 최대한 활용하며 필요에 따라 MAP을 이용 하기시 바랍니다.
 * ###################################################################################################### */
package com.netive.service.sample;

public class SampleVO {

	public static final String defaultStr = "10";	//기본값 설정 예제
	
	private String parm1 = ""; 	 					//샘플 데이터 1
	private String parm2 = defaultStr;				//샘플 데이터 2, 기본값 설정 예제
	
	public String getParm1() {
		return parm1;
	}
	public void setParm1(String parm1) {
		this.parm1 = parm1;
	}
	public String getParm2() {
		return parm2;
	}
	public void setParm2(String parm2) {
		this.parm2 = parm2;
	}	
}
