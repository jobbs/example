/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CommonPaginationRenderer.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 9. 23.
 * @lastmodified 2016. 9. 23.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 23.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.util.pagination;

import ncis.cmn.util.PropertiesUtil;
import egovframework.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

public class CommonPaginationRenderer extends AbstractPaginationRenderer {

	public CommonPaginationRenderer() {
		firstPageLabel = PropertiesUtil.getProperty("pagination.common.firstPageLabel");
        previousPageLabel = PropertiesUtil.getProperty("pagination.common.previousPageLabel");
        currentPageLabel = PropertiesUtil.getProperty("pagination.common.currentPageLabel");
        otherPageLabel = PropertiesUtil.getProperty("pagination.common.otherPageLabel");
        nextPageLabel = PropertiesUtil.getProperty("pagination.common.nextPageLabel");
        lastPageLabel = PropertiesUtil.getProperty("pagination.common.lastPageLabel");
	}

	@Override
	public String renderPagination(PaginationInfo paginationInfo,
			String jsFunction) {
		return super.renderPagination(paginationInfo, jsFunction);
	}

}
