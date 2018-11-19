/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CustomAuthenticationProvider.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 19.
 * @lastmodified 2016. 10. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 19.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.security.provider;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;

import ncis.cmn.security.service.PKIUserDetailsService;
import ncis.cmn.security.vo.UserVo;
import ncis.cmn.util.PropertiesUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.bcqre.lib.CQJava;
import com.gpki.gpkiapi.GpkiApi;
import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.exception.GpkiApiException;
import com.gpki.gpkiapi.ivs.VerifyCert;
import com.gpki.gpkiapi.storage.Disk;

/**
 * @author 최진호
 *
 */
@Component
public class PKIAuthenticationProvider implements AuthenticationProvider {

    @Autowired private PKIUserDetailsService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    	try {
	    	//TODO 서비스 네임 KEY 변경 필요
	    	String serviceIniKey = PropertiesUtil.getProperty("pki.service.ini.key");

	        String username = authentication.getName();
	        String password = (String)authentication.getCredentials();
	        int isError = -1;

	        isError = CQJava.CQJInit(serviceIniKey);
	        if( isError != 0 ) {
//	            throw new BadCredentialsException(encodeURL("Error Num [100] : 인증서 초기화 실패"));
	        	throw new BadCredentialsException("Error Num [" + CQJava.CQJGetErrorNum() + "] : " + CQJava.CQJGetErrorMsg());
	        }

	        //TODO 서비스 네임 변경 필요
	        String strVerifiedData =  CQJava.CQJVerifyData(serviceIniKey, 1, username, password);
	        if( "".equals(strVerifiedData) ) {
	        	throw new BadCredentialsException("Error Num [" + CQJava.CQJGetErrorNum() + "] : " + CQJava.CQJGetErrorMsg());
	        }

	        String strCert = CQJava.CQJGetCertificateFromSignedData(username);
	    	if(strCert.equals("")) {
	        	throw new BadCredentialsException("Error Num [" + CQJava.CQJGetErrorNum() + "] : " + CQJava.CQJGetErrorMsg());
	    	}

	        /* *************************************************************************************
	    	 * GPKI IVS 테스트 시작
	    	 * 		GPKI를 통하여 인증서 만료 및 폐기에 대한 유효성 체크 처리
	    	 * *************************************************************************************/
	    	strCert = "-----BEGIN CERTIFICATE-----" + strCert + "-----END CERTIFICATE-----";

	    	GpkiApi.init(PropertiesUtil.getProperty("pki.gpki.conf.dir"));
	    	X509Certificate myCert = Disk.readCert(PropertiesUtil.getProperty("pki.server.cert"));

			X509Certificate cert = new X509Certificate(strCert);
	    	VerifyCert verifyCert = new VerifyCert(PropertiesUtil.getProperty("pki.gpki.conf"));

			verifyCert.setMyCert(myCert);
			verifyCert.verify(cert);
			/* *************************************************************************************
	    	 * GPKI IVS 테스트 종료
	    	 * *************************************************************************************/

	    	String dn = CQJava.CQJGetCertInfoFromSignedData(username, "CERT_SUBJECT");

	        UserVo user = (UserVo) userService.loadUserByUsername(dn);

	        if( null == user) {
	            throw new BadCredentialsException(encodeURL("Error Num [400] : 사용자가 존재하지 않습니다. 인증서 등록을 먼저 하여 주시기 바랍니다."));
	        }

	        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

	        return new UsernamePasswordAuthenticationToken(user, password, authorities);

    	} catch (GpkiApiException e) {
			throw new BadCredentialsException(encodeURL(e.getMessage()));
		}
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    private String encodeURL(String str) {
    	String encodeStr = null;
    	try {
    		encodeStr = URLEncoder.encode(str,"UTF-8");
		} catch (UnsupportedEncodingException e) {}

    	return encodeStr;
    }

}
