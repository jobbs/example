/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TykApiController.java
 *
 * @author 이제율
 * @lastmodifier 이제율
 * @created 2016. 11. 1.
 * @lastmodified 2016. 11. 1.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 11. 1.     이제율         v1.0             최초생성
 *
 */
package ncis.api.cmn.tyk.web;

import javax.annotation.Resource;

import ncis.api.cmn.tyk.service.TykApiService;
import ncis.api.cmn.tyk.vo.TykApiResponseVo;
import ncis.api.cmn.tyk.vo.TykApiVo;
import ncis.api.cmn.tyk.vo.TykKeyVo;
import ncis.cmn.web.BaseController;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 이제율
 *
 */
@RestController
@RequestMapping(value="/apityk")
public class TykApiTestController extends BaseController {
	@Resource(name="tykApiService")
	TykApiService tykApiService;

	/**
	 * tyk API 등록 프로세스
	 * @param bindResult
	 * @param tykApiVo
	 * @return
	 */
	@RequestMapping(value="/insertTykApi.do", method=RequestMethod.GET)
	public void insertTykApi(@ModelAttribute("vo") TykApiVo tykApiVo) throws Exception{
		TykApiResponseVo tykApiResponseVo;
		tykApiResponseVo = tykApiService.insertTykApi(tykApiVo);
		tykApiService.reloadTyk("regionId");

		System.out.println("Status : " + tykApiResponseVo.getStatus());
	}

	/**
	 * tyk API 삭제 프로세스
	 * @param bindResult
	 * @param tykApiVo
	 * @return
	 */
	@RequestMapping(value="/deleteTykApi.do", method=RequestMethod.GET)
	public void deleteTykApi() throws Exception{
		TykApiResponseVo tykApiResponseVo;
		TykApiVo tykApiVo = new TykApiVo();
		tykApiResponseVo = tykApiService.deleteTykApi(tykApiVo);
		tykApiService.reloadTyk("regionId");

		System.out.println("Status : " + tykApiResponseVo.getStatus());
	}

	/**
	 * tyk key 생성
	 * @param bindResult
	 * @param tykApiVo
	 * @return
	 */
	@RequestMapping(value="/insertTykKey.do", method=RequestMethod.GET)
	public void insertTykKey(@ModelAttribute("vo") TykKeyVo tykKeyVo) throws Exception{
			TykApiResponseVo tykApiResponseVo;
			tykApiResponseVo = tykApiService.insertTykKey(tykKeyVo);
//			tykApiService.reloadTyk("regionId");

			System.out.println("Status : " + tykApiResponseVo.getStatus());
			System.out.println("key : " + tykApiResponseVo.getKey());
	}

	/**
	 * tyk key 삭제
	 * @param tykApiVo
	 * @return
	 */
	@RequestMapping(value="/updateTykKey.do", method=RequestMethod.GET)
	public void updateTykKey(@ModelAttribute("vo") TykKeyVo tykKeyVo) throws Exception{
		TykApiResponseVo tykApiResponseVo;
		tykApiResponseVo = tykApiService.updateTykKey(tykKeyVo);
		tykApiService.reloadTyk("regionId");

		System.out.println("Status : " + tykApiResponseVo.getStatus());
	}

	/**
	 * tyk key 삭제
	 * @param tykApiVo
	 * @return
	 */
	@RequestMapping(value="/deleteTykKey.do", method=RequestMethod.GET)
	public void deleteTykKey() throws Exception{
		TykApiResponseVo tykApiResponseVo;
		TykKeyVo tykKeyVo = new TykKeyVo();
		tykApiResponseVo = tykApiService.deleteTykKey(tykKeyVo);
		tykApiService.reloadTyk("regionId");

		System.out.println("Status : " + tykApiResponseVo.getStatus());
	}

	/**
	 * tyk reload
	 * @param tykApiVo
	 * @return
	 */
	@RequestMapping(value="/reloadTyk.do", method=RequestMethod.GET)
	public void reloadTyk() throws Exception{
		TykApiResponseVo tykApiResponseVo;
		tykApiResponseVo = tykApiService.reloadTyk("regionId");

		System.out.println("Status : " + tykApiResponseVo.getStatus());
	}
}
