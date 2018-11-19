package ncis.dsb.cmn.util;

import java.util.ArrayList;
import java.util.List;

import ncis.cmn.util.DateUtil;
import ncis.dsb.cmn.vo.DsbCodeVo;


public class DsbUtil {
	public static List<DsbCodeVo> getYearCd(){
		return getYearCd(10);
	}

	public static List<DsbCodeVo> getYearCd(int yearNum){
		List<DsbCodeVo> yearCdList = new ArrayList<DsbCodeVo>();
		DsbCodeVo yearCd = null;

		int year = Integer.parseInt(DateUtil.getCurrentDate("yyyy"));


		for(int i=year; yearNum>0; i--, yearNum--){
			yearCd = new DsbCodeVo();
			yearCd.setCd(Integer.toString(i));
			yearCd.setCdNm(Integer.toString(i)+"년");
			yearCdList.add(yearCd);
		}

		return yearCdList;
	}

	public static String pad(String str, int num){
		return pad(str, num, " ");
	}

	public static String pad(String str, int num, String paddingStr){
		String result = str;

		while(result.length()<num){
			result += paddingStr;
		}

		return result;
	}

	public static String rpad(String str, int num, String paddingStr){
		return pad(str, num, paddingStr);
	}

	public static String lpad(String str, int num, String paddingStr){
		String result = str;

		while(result.length()<num){
			result = paddingStr + result;
		}

		return result;
	}
}
