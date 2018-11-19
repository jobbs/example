/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NetwkStackService.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 05. 21.
 * @lastmodified 2017. 05. 21.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 05. 21.     x         v1.0             최초생성
 *
 */
package ncis.intfc.atmscl.service;

import ncis.cmn.rest.vo.RestHeaders;
import ncis.intfc.atmscl.vo.AtmSclResultIfVo;
import ncis.intfc.atmscl.vo.LimitrangesIfVo;
import ncis.intfc.atmscl.vo.NamespaceIfVo;
import ncis.intfc.atmscl.vo.ProjectRequestsIfVo;
import ncis.intfc.atmscl.vo.ResourceQuotasIfVo;

/**
 * @author x
 *
 */
public interface ServcAreaAPIService {

	/**
	 * 서비스영역 생성
	 * @param header
	 * @param projectRequestsIfVo
	 * @return
	 */
	AtmSclResultIfVo projectRequestsPost(RestHeaders headers, ProjectRequestsIfVo projectRequestsIfVo) throws Exception;


	/**
	 * 서비스영역 쿼터 생성
	 * @param header
	 * @param resourceQuotasIfVo
	 * @return
	 */
	AtmSclResultIfVo resourceQuotasPost(RestHeaders headers, ResourceQuotasIfVo resourceQuotasIfVo) throws Exception;


	/**
	 * 서비스영역 제한 생성
	 * @param header
	 * @param limitrangesIfVo
	 * @return
	 */
	AtmSclResultIfVo limitrangesPost(RestHeaders headers, LimitrangesIfVo limitrangesIfVo) throws Exception;


	/**
	 * 서비스영역 수정
	 * @param header
	 * @param namespaceIfVo
	 * @return
	 */
	AtmSclResultIfVo nameSpacesPut(RestHeaders headers, NamespaceIfVo namespaceIfVo) throws Exception;


	/**
	 * 서비스영역 삭제
	 * @param header
	 * @param namespacesId
	 * @return
	 */
	AtmSclResultIfVo deleteNamespaces(RestHeaders headers, String namespacesId) throws Exception;


	/**
	 * 서비스영역 쿼터 수정
	 * @param headers
	 * @param resourceQuotasIfVo
	 * @return
	 */
	AtmSclResultIfVo resourceQuotasPut(RestHeaders headers, ResourceQuotasIfVo resourceQuotasIfVo) throws Exception;


	/**
	 * 서비스영역 제한 수정
	 * @param headers
	 * @param namespaceIfVo
	 * @return
	 */
	AtmSclResultIfVo limitrangesPut(RestHeaders headers, LimitrangesIfVo limitrangesIfVo) throws Exception;


	/**
	 * 서비스영역 계정 생성
	 * @param header
	 * @param namespaceId
	 * @return
	 */
	AtmSclResultIfVo serviceAccountsPost(RestHeaders headers, String namespaceId) throws Exception;


	/**
	 * 서비스영역 롤 생성
	 * @param header
	 * @param namespaceId
	 * @return
	 */
	AtmSclResultIfVo rollBindingsPost(RestHeaders headers,  String namespaceId) throws Exception;

}
