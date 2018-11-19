/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename CustomSheet.java
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
package ncis.cmn.util.excel;

import java.util.List;
import java.util.Map;

public class CustomSheet {

    /**
     * Sheet명
     */
    private String sheetName;

    /**
     * Header 정보
     * Key : Data Class의 변수명
     * Value : 해더 명
     */
    private Map<String, String> hreader;

    /**
     * Data Vo
     */
    private List<?> datas;

    /**
     * @return the sheetName
     */
    public String getSheetName() {
        return sheetName;
    }

    /**
     * @param sheetName the sheetName to set
     */
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    /**
     * @return the hreader
     */
    public Map<String, String> getHreader() {
        return hreader;
    }

    /**
     * @param hreader the hreader to set
     */
    public void setHreader(Map<String, String> hreader) {
        this.hreader = hreader;
    }

    /**
     * @return the data
     */
    public List<?> getDatas() {
        return datas;
    }

    /**
     * @param data the data to set
     */
    public void setDatas(List<?> datas) {
        this.datas = datas;
    }

}
