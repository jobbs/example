/* ###################################################################################################### 
 * ### @AUTHOR   : NETIVE
 * ### @DATE     : 2018.07. 
 * ### @TITLE    : SPRING MVC DAO INTERFACE SAMPLE
 * ### @DESCRIPT : 	＊ SPRING DAO INTERFACE 기본 적인 구조
 * ### 				＊ SQL MAPPING 하기 위한 기능들을 정의 하는 화면 입니다.
 * ### 				＊ "*-query.xml"내 정의 된 SQL ID와 MAPPING 시켜 주는 기능을 정의 합니다.
 * ### 				＊ DAO 기능 정의는 "SELECT+패키지명+기능명","UPDATE+패키지명+기능명","DELETE+패키지명+기능명","INSERT+패키지명+기능명","UPDATE+패키지명+기능명" 구분 합니다.
 * ### 				＊ SQL 처리 방식 별 FUNCTION NAME을 정의 하셔야 합니다.(FOR TRANSACTION) 
 * ### 				＊ IN/OUT 인자는 가급적 VO 데이터 활용을 권장 드립니다. 
 * ### 				＊ PUBLIC {OUTPUT PARM} FUNCTIONNAME({INPUT PARM}); 
 * ### 				＊ INTERFACE 정의서는 반드시 기능에 대한 설명을 주석 처리 합니다.
 * ###################################################################################################### */
package com.netive.service.sample;

import java.util.List;

public interface SampleDAO {
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : DAO SELECT 기능 MAPPING 
	 * */		
	public List<SampleVO> selectSampleMethod1() throws Exception;
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : DAO UPDATE 기능 MAPPING 
	 * */		
	public int updateSampleMethod2() throws Exception;
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : DAO DELETE 기능 MAPPING 
	 * */		
	public int deleteSampleMethod3() throws Exception;
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : DAO INSERT 기능 MAPPING 
	 * */		
	public int insertSampleMethod4() throws Exception;
	
	
}
