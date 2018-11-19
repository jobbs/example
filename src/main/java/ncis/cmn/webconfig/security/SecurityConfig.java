/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SecurityConfig.java
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
package ncis.cmn.webconfig.security;

import java.util.ArrayList;
import java.util.List;
import ncis.cmn.security.access.expression.CustomWebSecurityExpressionHandler;
import ncis.cmn.security.authentication.CustomAuthenticationFailureHandler;
import ncis.cmn.security.authentication.CustomAuthenticationSuccessHandler;
import ncis.cmn.security.provider.CustomAuthenticationProvider;
import ncis.cmn.security.provider.PKIAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//@Configuration
/*
 * @EnableWebSecurity annotation을 반드시 가져야 합니다.
 */
@EnableWebSecurity
public class SecurityConfig { // extends WebSecurityConfigurerAdapter

    @Configuration
    @Order(1)
    public static class SuperSecurityConfigurerAapter extends WebSecurityConfigurerAdapter {

        /*
         * DB 접속을 통하여 사용자 정보 및 권한을 확인할 Service
         */
        @Autowired CustomAuthenticationProvider authUserService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth)
                throws Exception {
            auth
                .authenticationProvider(authUserService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/super/**")
                .csrf().disable()
                .authorizeRequests()
                    .accessDecisionManager(accessDecisionManager())
                    .antMatchers(
                                "/favicon.ico").permitAll()     // 로그인을 하지 않아도 접근가능
                    .antMatchers(
                                "/super/login.do").anonymous() // 로그인이 되어있지 않은 사람들이 접근
                    .anyRequest().access("hasCustomRole()")
                    .and()
                .formLogin()
                    .usernameParameter("userId")
                    .passwordParameter("userPass")
                    .loginPage("/super/login.do")
                    .loginProcessingUrl("/super/login/superUserProcess")   // 로그인 처리 화면
                    .successHandler(customAuthenticationSuccessHandler())   // 로그인 성공 Handler
                    .failureHandler(customAuthenticationFailureHandler())   // 로그인 실패 Handler
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout.do")
                    .logoutSuccessUrl("/")
                    .permitAll()
                    .and()
                .exceptionHandling().accessDeniedPage("/error/accessDenied.do");  // 예외처리 Handling 에러 페이지로 Go~
        }

        public AuthenticationFailureHandler customAuthenticationFailureHandler() {
            CustomAuthenticationFailureHandler handler = new CustomAuthenticationFailureHandler();
            handler.setDefaultFailureUrl("/super/login.do?error=");
            return handler;
        }

        @Bean
        public AffirmativeBased accessDecisionManager() {
            List<AccessDecisionVoter<?>> voters = new ArrayList<AccessDecisionVoter<?>>();
            voters.add(expressionVoter());

            AffirmativeBased affirmativeBased = new AffirmativeBased(voters);
            affirmativeBased.setAllowIfAllAbstainDecisions(false);
            return  affirmativeBased;
        }

        @Bean
        public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
            CustomAuthenticationSuccessHandler handler = new CustomAuthenticationSuccessHandler();
            handler.setDefaultTargetUrl("/");
            return handler;
        }

        @Bean
        public WebExpressionVoter expressionVoter() {
            WebExpressionVoter voter = new WebExpressionVoter();

            CustomWebSecurityExpressionHandler handler = new CustomWebSecurityExpressionHandler();
            handler.setDefaultRolePrefix("");
            voter.setExpressionHandler(handler);
            return voter;
        }

    }

    @Configuration
    public static class PKISecurityConfigurerAapter extends WebSecurityConfigurerAdapter {

        /*
         * DB 접속을 통하여 사용자 정보 및 권한을 확인할 Service
         */
        @Autowired PKIAuthenticationProvider authUserService;


        @Override
        protected void configure(AuthenticationManagerBuilder auth)
                throws Exception {
            auth
                .authenticationProvider(authUserService);
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                .ignoring()
                    .antMatchers("/resources/**")
                    .antMatchers("/apityk/**")
                    .antMatchers("/rest/**")
                    .antMatchers("/inrest/**")
                    .antMatchers("/error/**")
                    .antMatchers("/test/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/**")
                .csrf().disable()
                .authorizeRequests()
                    .accessDecisionManager(accessDecisionManager())
                    .antMatchers(
                                "/favicon.ico").permitAll()     // 로그인을 하지 않아도 접근가능
                    .antMatchers(
                                "/login.do",
                                "/insertPKI.do" ).anonymous() // 로그인이 되어있지 않은 사람들이 접근
                    .antMatchers(
                            "/cmn/component/**",
                            "/api/cmn/component/**").access("user")
                    .anyRequest().access("hasCustomRole()")
                    .and()
                .formLogin()
                    .usernameParameter("SignedMsg")
                    .passwordParameter("OrgMsg")
                    .loginPage("/login.do")
                    .loginProcessingUrl("/login/process")   // 로그인 처리 화면
                    .successHandler(customAuthenticationSuccessHandler())   // 로그인 성공 Handler
                    .failureHandler(customAuthenticationFailureHandler())   // 로그인 실패 Handler
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout.do")
                    .logoutSuccessUrl("/")
                    .permitAll()
                    .and()
                .exceptionHandling().accessDeniedPage("/error/accessDenied.do");  // 예외처리 Handling 에러 페이지로 Go~
        }

        public AuthenticationFailureHandler customAuthenticationFailureHandler() {
            CustomAuthenticationFailureHandler handler = new CustomAuthenticationFailureHandler();
            handler.setDefaultFailureUrl("/login.do?error=");
            return handler;
        }



        @Bean
        public AffirmativeBased accessDecisionManager() {
            List<AccessDecisionVoter<?>> voters = new ArrayList<AccessDecisionVoter<?>>();
            voters.add(expressionVoter());

            AffirmativeBased affirmativeBased = new AffirmativeBased(voters);
            affirmativeBased.setAllowIfAllAbstainDecisions(false);
            return  affirmativeBased;
        }

        @Bean
        public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
            CustomAuthenticationSuccessHandler handler = new CustomAuthenticationSuccessHandler();
            handler.setDefaultTargetUrl("/");
            return handler;
        }

        @Bean
        public WebExpressionVoter expressionVoter() {
            WebExpressionVoter voter = new WebExpressionVoter();

            CustomWebSecurityExpressionHandler handler = new CustomWebSecurityExpressionHandler();
            handler.setDefaultRolePrefix("");
            voter.setExpressionHandler(handler);
            return voter;
        }

    }



}
