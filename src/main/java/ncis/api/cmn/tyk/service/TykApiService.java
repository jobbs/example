/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename TykAPIService.java
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
package ncis.api.cmn.tyk.service;

import ncis.api.cmn.tyk.vo.TykApiResponseVo;
import ncis.api.cmn.tyk.vo.TykApiVo;
import ncis.api.cmn.tyk.vo.TykKeyVo;


/**
 * @author 이제율
 *
 */
public interface TykApiService {
    public TykApiResponseVo insertTykApi(TykApiVo tykApivo) throws Exception;

    public TykApiResponseVo deleteTykApi(TykApiVo tykApiVo) throws Exception;

    public TykApiResponseVo insertTykKey(TykKeyVo tykKeyVo) throws Exception;

    public TykApiResponseVo updateTykKey(TykKeyVo tykKeyVo) throws Exception;

    public TykApiResponseVo deleteTykKey(TykKeyVo tykKeyVo) throws Exception;

    public TykApiResponseVo reloadTyk(String regionId) throws Exception;
}
