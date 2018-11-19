/* ######################################################################################################
 * ### @AUTHOR   : NETIVE
 * ### @DATE     : 2018.07. 
 * ### @TITLE    : SPRING MVC SERVICE INTERFACE SAMPLE
 * ### @DESCRIPT : 	＊ SPRING INTERFACE 기본 적인 구조
 * ### 				＊ DAO 접근 전 데이터 처리를 위한 기능들 정의 하는 화면 입니다.
 * ### 				＊ SERVICE 기능 정의는 "set+패키지명+기능명", "get+패키지명+기능명" 구분 합니다.
 * ### 				＊ GET은 DAO 기능 접근시, SET는 DAO 기능 미 접근시 정의 합니다. 
 * ### 				＊ IN/OUT 데이터에 대해 명확히 정의 되어야 합니다.
 * ### 				＊ PUBLIC {OUTPUT PARM} FUNCTIONNAME({INPUT PARM}); 
 * ### 				＊ INTERFACE 정의서는 반드시 기능에 대한 설명을 주석 처리 합니다.
 * ######################################################################################################*/
package com.netive.service.sample;

import java.util.List;

public interface SampleService {

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : 서비스 기능 처리. 
	 * */					
	public List<SampleVO> setSampleMethod1() throws Exception;
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : 서비스 기능 처리.DAO SELECT. 
	 * */	
	public List<SampleVO> getSampleMethod1() throws Exception;

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : 서비스 기능 처리.DAO UPDATE. 
	 * */		
	public int getSampleMethod2() throws Exception;

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : 서비스 기능 처리.DAO DELTET. 
	 * */			
	public int getSampleMethod3() throws Exception;

	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : 서비스 기능 처리.DAO INSERT. 
	 * */				
	public int getSampleMethod4() throws Exception;
	
}
