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

import com.netive.service.common.dao.CommonDAO;

@Service("sampleService")	//SERVICE IMPLEMENTS 처리시 어노테이션 지정을 권장 드립니다.
public class SampleServiceImpl extends CommonDAO implements SampleService {

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
		SampleVO vo = new SampleVO();
		
		//② 전처리 {처리 업무에 대한 내용 주석}

		//② SQL 처리
		vo = (SampleVO) this.selectForObject("selectSampleMethod1");	//MYBATIS QUERY CALL 내장함수 활용.
		//db.selectOne("selectSampleMethod1", vo);			//1 ROW TYPE 반환
		//db.selectList("selectSampleMethod1");				//N ROW LIST TYPE 반환

		//④ 후처리 {처리 업무에 대한 내용 주석}
		data.add(vo);
		
		//⑤ 결과값 반환	
		return data;
	}

	@Override
	public int getSampleMethod2() {

		//① 기능 내 전역 변수 선언
		int data = 0;
		
		//② 전처리 {처리 업무에 대한 내용 주석}
		//vo.setParm1("2");
		
		//② SQL 처리
		data = this.updateForObject("updateSampleMethod2");	//MYBATIS QUERY CALL 내장함수 활용.
		//db.update("updateSampleMethod2");				//UPDATE
		//db.update("updateSampleMethod2", vo);			//UPDATE, 인자 전달
		
		//④ 후처리 {처리 업무에 대한 내용 주석}
		
		//⑤ 결과값 반환	
		return data;
	}
	
	@Override	
	public int getSampleMethod3() {

		//① 기능 내 전역 변수 선언
		int data = 0;
		
		//② 전처리 {처리 업무에 대한 내용 주석}
		//vo.setParm1("2");
		
		//② SQL 처리
		data = this.deleteForObject("deleteSampleMethod3");	//MYBATIS QUERY CALL 내장함수 활용.
		//db.delete("deleteSampleMethod3");				//DELETE
		//db.delete("deleteSampleMethod3", vo);			//DELETE, 인자 전달
		
		//④ 후처리 {처리 업무에 대한 내용 주석}
		
		//⑤ 결과값 반환	
		return data;		
	}
	
	@Override	
	public int getSampleMethod4() {

		//① 기능 내 전역 변수 선언
		int data = 0;
		
		//② 전처리 {처리 업무에 대한 내용 주석}
		//vo.setParm1("2");
		
		//② SQL 처리
		data = this.insertForObject("insertSampleMethod4");	//MYBATIS QUERY CALL 내장함수 활용.
		//db.insert("insertSampleMethod4");				//INSERT
		//db.insert("insertSampleMethod4", vo);			//INSERT, 인자 전달
		
		//④ 후처리 {처리 업무에 대한 내용 주석}
		
		//⑤ 결과값 반환	
		return data;
	}
		
}
