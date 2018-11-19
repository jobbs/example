/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename AppConfig.java
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

import ncis.cmn.webconfig.security.SecurityConfig;
import ncis.rest.intfc.cmm.config.SwaggerConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({WebMvcConfig.class, CommonConfig.class, SecurityConfig.class, DatabaseConfig.class, SlaveDatabaseConfig.class, SwaggerConfig.class})
@ImportResource("classpath:/spring/context-transation.xml")
@EnableAspectJAutoProxy
public class AppConfig {

}
