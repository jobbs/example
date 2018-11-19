/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename ObjectUtils.java
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
package ncis.cmn.util;

import java.util.List;

public class ObjectUtils extends org.springframework.util.ObjectUtils {

	/** <pre>
	 * 목록 객체가 빈 목록인지 여부를 판단
	 * </pre>
	 *
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List<?> list){
		return (list==null || list.isEmpty());
	}

	/** <pre>
	 * Integer 배열 생성
	 * </pre>
	 *
	 * @param start
	 * @param end
	 * @param step
	 * @return
	 */
	public static Integer[] createIntegerArray(int start, int end, int step){
		Integer[] array = null;
		for(int i=start; i<=end; i=i+step){
			array = addIntegerToArray(array,i);
		}
		return array;
	}

	public static Integer[] addIntegerToArray(Integer[] array, Integer value){
		if(isEmpty(array)){
			return new Integer[]{value};
		}

		Integer newArray[] = new Integer[array.length+1];
		System.arraycopy(array, 0, newArray, 0, array.length);
		newArray[array.length] = value;
		return newArray;
	}

}
