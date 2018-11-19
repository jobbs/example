/* ###################################################################################################### 
 * ### @AUTHOR   : NETIVE
 * ### @DATE     : 2018.07. 
 * ### @TITLE    : SPRING MVC SERVICE SAMPLE
 * ### @DESCRIPT : 	＊ SPRING SERVICE 기본 적인 구조
 * ### 				＊ DAO 접근 전 데이터 처리를 위한 기능들의 집합입니다.
 * ### 				＊ INTERFACE에서 주석 정의를 진행 하므로, 해당 페이지에서는 기능에 대한 주석은 생략 합니다.
 * ### 				＊ IN/OUT 데이터에 대해 명확히 정의 되어야 합니다.
 * ### 				＊ PUBLIC {OUTPUT PARM} FUNCTIONNAME({INPUT PARM}) {}
 * ###################################################################################################### */
package com.netive.service.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sampleService")	//SERVICE IMPLEMENTS 처리시 어노테이션 지정을 권장 드립니다.
public class SampleServiceImpl implements SampleService {

	@Autowired	//DAO 기능 사용 지정 어노테이션
	private SampleDAO dao;
	
	@Override	
	public List<SampleVO> setSampleMethod1() {
		
		//① 기능 내 전역 변수 선언
		List<SampleVO> data = new ArrayList<SampleVO>();
		SampleVO vo = new SampleVO();
		
		//② 기능 처리 {처리 업무에 대한 내용 주석}		
		vo.setParm1("3");
		vo.setParm2("4");
		
		//⑤ 결과값 반환		
		return data;
	}	
	
	@Override	
	public List<SampleVO> getSampleMethod1() {

		//① 기능 내 전역 변수 선언
		List<SampleVO> data = new ArrayList<SampleVO>();
		
		try {
			//② 전처리 {처리 업무에 대한 내용 주석}
			
			//③ DAO 기능 처리			
			data = dao.selectSampleMethod1();
					
			//④ 후처리 {처리 업무에 대한 내용 주석}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//⑤ 결과값 반환
		return data;
	}

	@Override
	public int getSampleMethod2() {

		//① 기능 내 전역 변수 선언
		int data = 0;
		
		try {
			//② 전처리 {처리 업무에 대한 내용 주석}
			
			//③ DAO 기능 처리			
			data = dao.updateSampleMethod2();
			
			//④ 후처리 {처리 업무에 대한 내용 주석}
						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		//⑤ 결과값 반환
		return data;
	}
	
	@Override	
	public int getSampleMethod3() {

		//① 기능 내 전역 변수 선언
		int data = 0;
		
		try {
			//② 전처리 {처리 업무에 대한 내용 주석}
			
			//③ DAO 기능 처리			
			data = dao.deleteSampleMethod3();
			
			//④ 후처리 {처리 업무에 대한 내용 주석}
						
		} catch (Exception e) {
			e.printStackTrace();
		}				
		
		//⑤ 결과값 반환
		return data;		
	}
	
	@Override	
	public int getSampleMethod4() {

		//① 기능 내 전역 변수 선언
		int data = 0;
		
		try {
			//② 전처리 {처리 업무에 대한 내용 주석}
			
			//③ DAO 기능 처리			
			data = dao.insertSampleMethod4();
			
			//④ 후처리 {처리 업무에 대한 내용 주석}
						
		} catch (Exception e) {
			e.printStackTrace();
		}					
		
		//⑤ 결과값 반환
		return data;
	}
		
}
