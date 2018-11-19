/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename WebMvcConfig.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.webconfig;

import java.util.HashMap;
import java.util.Map;

import ncis.cmn.rest.interceptors.ProviderRestInterceptor;
import ncis.cmn.util.pagination.CommonPaginationRenderer;
import ncis.cmn.webconfig.interceptors.CustomControllerInterceptor;
import ncis.cmn.webconfig.multipart.CustomMultipartResolver;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import egovframework.rte.ptl.mvc.tags.ui.pagination.DefaultPaginationManager;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationRenderer;

@Configuration
/* <mvc:annotation-driven /> */
@EnableWebMvc
/*
<context:component-scan base-package="com.company">
  <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
  <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Service"/>
  <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
 </context:component-scan>
*/
@ComponentScan(
		basePackages="ncis",
		includeFilters={
				@ComponentScan.Filter(Controller.class)
		},
		excludeFilters={
				@ComponentScan.Filter(Service.class),
				@ComponentScan.Filter(Repository.class)
		}
	)
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	//<resources location="/resources/" mapping="/resources/**">에 해당됨.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);

		/*swagger설정.*/
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

	}

	//<mvc:default-servlet-handler>에 해당됨.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * <pre>
	 * Return Type을 JSON으로 사용하고 싶을 경우 설정을 해줘야 한다.<br />
	 * 없을 경우
	 * "The resource identified by this request is only capable of generating responses with characteristics not acceptable according to the request "accept" headers."
	 * 오류가 발생한다. <br />
	 *
	 * XML 설정은 아래와 같다.
	 * <mvc:annotation-driven  content-negotiation-manager="contentNegotiationManager" />
	 * <bean id="contentNegotiationManager" class="org.springframework.web.accept.ContentNegotiationManagerFactoryBean">
	 *      <property name="favorPathExtension" value="false" />
	 *      <property name="favorParameter" value="true" />
	 *      <property name="mediaTypes" >
	 *           <value>
	 *                json=application/json
	 *                xml=application/xml
	 *           </value>
	 *      </property>
	 * </bean>
	 * </pre>
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		/*swagger의 경우는 아래 주석처리된 2개 문장이 있을경우
		 * chrome에서 http://localhost:8080/swagger-ui.html 호출시
		 * script 실행이 거부됨. 임시로 주석처리함.*/
		/*Refused to execute script from 'http://localhost:8080/webjars/springfox-swagger-ui/lib/jquery-1.8.0.min.js' because its MIME type ('application/json') is not executable, and strict MIME type checking is enabled.*/

		configurer//.favorPathExtension(false)
				//	.favorParameter(true)
					.defaultContentType(MediaType.APPLICATION_JSON)
					.mediaType("xml", MediaType.APPLICATION_ATOM_XML)
					.mediaType("json", MediaType.APPLICATION_JSON);

	}

	/* <mvc:view-controller path="/accessDenied" view-name="error/accessDenied"/> */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error/accessDenied.do").setViewName("error/accessDenied");
	}

	/**
	 * Tiles 설정파일
	 *
	 * <bean id="titlesConfigurer"
	 * 	class="org.springframework.web.servlet.view.tiles2.TilesConfigurer">
	 * 	<property name="definitions">
	 * 		<list>
	 * 			<value>/WEB-INF/config/tiles-defs.xml</value>
	 * 		</list>
	 * 	</property>
	 * </bean>
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configure = new TilesConfigurer();
		configure.setDefinitions("/WEB-INF/config/tiles-defs.xml");
		return configure;
	}

	/**
	 * <bean class="org.springframework.web.servlet.view.UrlBasedViewResolver">
	 * 	<property name="viewClass" value="org.springframework.web.servlet.view.tiles2.TilesView"></property>
	 * 	<property name="order" value="1"></property>
	 * </bean>
	 */
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(1);
		return resolver;
	}

	/**
	 * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * 	<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"></property>
	 * 	<property name="prefix" value="/WEB-INF/jsp/"></property>
	 * 	<property name="suffix" value=".jsp"></property>
	 * 	<property name="order" value="2"></property>
	 * </bean>
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(2);
		return resolver;
	}

	/**
	 * MultipartResolver 설정
	 *
	 * <bean id="multipartResolver"
	 * 	class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	 * 	<property name="maxUploadSize" value="209715200" />
	 * 	<property name="maxInMemorySize" value="104857600" />
	 * </bean>
	 */
	@Bean(name="filterMultipartResolver")
	public MultipartResolver multipartResolver() {
		//CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		CustomMultipartResolver resolver = new CustomMultipartResolver();
		resolver.setMaxInMemorySize(104857600); //100MB
		resolver.setMaxUploadSize(209715200);	//200MB
		resolver.setDefaultEncoding("UTF-8");
		return resolver;
	}

	/**
	 * 전자정부프레임워크의 Paging 처리 Lib 사용하여
	 * Paging 설정
	 *
	 * <bean id="commonPaginationRenderer" class="com.company.util.pagination.CommonPaginationRenderer" />
     *
	 * <bean id="paginationManager" class="egovframework.rte.ptl.mvc.tags.ui.pagination.DefaultPaginationManager">
	 * 	<property name="rendererType">
	 * 		<map>
	 * 			<entry key="common" value-ref="commonPaginationRenderer"></entry>
	 * 		</map>
	 * 	</property>
	 * </bean>
	 */
	@Bean
	public DefaultPaginationManager paginationManager() {
		DefaultPaginationManager manager = new DefaultPaginationManager();

		Map<String, PaginationRenderer> renderer = new HashMap<String, PaginationRenderer>();
		renderer.put("common", new CommonPaginationRenderer());
		manager.setRendererType(renderer);

		return manager;
	}


	/**
	 * Message properties 설정
	 *
	 * <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
	 * 	<property name="basenames">
	 * 		<list>
	 * 			<value>properties.messages</value>
	 * 		</list>
	 * 	</property>
	 * </bean>
	 */
	@Bean
	public MessageSource messageSource(){
	  ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
	  messageSource.setBasenames(
			  "classpath:properties/messages"
		);
	  return messageSource;
	}

//	@Bean
//	public RestInterceptor restInterceptor() {
//	    return new RestInterceptor();
//	}

	@Bean
	public ProviderRestInterceptor providerRestInterceptor() {
	    return new ProviderRestInterceptor();
	}

	@Bean
	public CustomControllerInterceptor customControllerInterceptor() {
		return new CustomControllerInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//	    registry.addInterceptor(restInterceptor()).addPathPatterns("/gwrest/**");
	    registry.addInterceptor(providerRestInterceptor()).addPathPatterns("/rest/**");
	    registry.addInterceptor(customControllerInterceptor()).addPathPatterns("/**");
	}

}
