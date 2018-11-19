package ncis.rest.intfc.cmm.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private List<ResponseMessage> responseList = new ArrayList<ResponseMessage>();

	/**
	 * Customizing 응답 메시지 초기화
	 */
	@PostConstruct
	private void initResponseMessage() {
		ResponseMessage response500 = new ResponseMessageBuilder().code(500).message("Error").build();

		responseList.add(response500);
	}

	/**
	 * 컴퓨팅 스택 - 가상머신 관리
	 * @return
	 */
	@Bean
	public Docket configApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				// 기본 응답 Message가 아닌 특정 응답 메시지만을 사용하는 경우
				.useDefaultResponseMessages(true)
//				.globalResponseMessage(RequestMethod.GET, responseList)
				.groupName("Config-Api")
				.apiInfo(configApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("ncis.rest.intfc.conf.web")) // 특정 패키지 내의 Rest API 만 Document를 생성
			 	.paths(configApiPath()) // 특정 URL 경로에 해당하는 REST API만 Document 생성
				.build();
	}


	private ApiInfo configApiInfo() {
		return new ApiInfoBuilder().title("Config-Api")
				.description("Config API")
				.contact("SelimTSG")
				.version("v1.0")
				.build();
	}


	@SuppressWarnings("unchecked")
	private Predicate<String> configApiPath() {

		return or(
				regex("/rest/zones"),
				regex("/rest/clusters"),
				regex("/rest/pms"),
				regex("/rest/vms"),
				regex("/rest/templates"),
				regex("/rest/sws"),
				regex("/rest/templateSws"),
				regex("/rest/vmspecs"),
				regex("/rest/categories"),
				regex("/rest/appls"),
				regex("/rest/servcns"),
				regex("/rest/servc"),
				regex("/rest/img"));
	}


	/**
	 * 컴퓨팅 스택 - 스토리지 관리
	 * @return
	 */
	@Bean
	public Docket requestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				// 기본 응답 Message가 아닌 특정 응답 메시지만을 사용하는 경우
				.useDefaultResponseMessages(true)
				.groupName("Request-Api")
				.apiInfo(reuqestApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("ncis.rest.intfc.request.web")) // 특정 패키지 내의 Rest API 만 Document를 생성
				.paths(requestPath()) // 특정 URL 경로에 해당하는 REST API만 Document 생성
				.build();
	}


	private ApiInfo reuqestApiInfo() {
		return new ApiInfoBuilder().title("Request-Api")
				.description("Request API")
				.contact("SelimTSG")
				.version("v1.0")
				.build();
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> requestPath() {
		return or(
				regex("/rest/createVM"),
				regex("/rest/modifyVM"),
				regex("/rest/removeVM"),
				regex("/rest/createPM"),
				regex("/rest/removePM"),
				regex("/rest/createCluster"),
				regex("/rest/removeCluster"),
				regex("/rest/createSLB"),
				regex("/rest/removeReq")
				);
	}

}
