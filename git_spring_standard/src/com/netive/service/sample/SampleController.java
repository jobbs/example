/* ###################################################################################################### 
 * ### @AUTHOR   : NETIVE
 * ### @DATE     : 2018.07. 
 * ### @TITLE    : SPRING MVC CONTROLLER SAMPLE
 * ### @DESCRIPT : 	＊ SPRING CONTROLLER 기본 적인 구조
 * ### 				＊ URL REQUEST 요청이 발생 되면 요청에 대한 처리 후 VIEW(JSP) 페이지와 MAPPING 처리 합니다.
 * ### 				＊ 구성은 대단위 메뉴 단위로 기능 집합을 구성하며, 메뉴 하위 모든 요청은 해당 패키지 내에서 처리 진행 합니다.
 * ###################################################################################################### */
package com.netive.service.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("sampleController")
@Configuration
@PropertySource("classpath:properties/service.properties")		// [SAMPLE] PROPERTY CALL
@RequestMapping("/sample")										// REQUEST URL PARENT NODE PATH
public class SampleController {

	private final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@Autowired
	private SampleService service;					// SERVICE OBJECT CALL
		
	@Autowired	
	private Environment env;				// [SAMPLE] PROPERTY CALL
	
	/* 
	 * @AUTHOR   : NETIVE
	 * @DATE     : 2018.07. 
	 * @DESCRIPT : SPRING CONTROLLER, 기능을 상세를 정의 합니다. 
	 * */		
	@RequestMapping(value="/page",method=RequestMethod.GET)		// REQUEST URL CHILD NODE PATH
	private String sampleMethod1(Model m) throws Exception {
		
		try {
			
			// [SAMPLE] PROPERTY CALL
			logger.info("[PROPERTIES TEST] : "+env.getProperty("service.case.a"));
			m.addAttribute("p", service.getSampleMethod1());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sample/page";		// RESPONSE JSP PAGE PATH

	}
	
}
