/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename RandomUtil.java
 *
 * @author 박희택
 * @lastmodifier 박희택
 * @created 2016. 10. 29.
 * @lastmodified 2016. 10. 29.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 29.     박희택         v1.0             최초생성
 *
 */
package ncis.cmn.util;

import java.util.Random;

/**
 * @author 박희택
 *
 */
public class RandomUtil {


	public static String randomValue(String type, int cnt){
		StringBuffer strPwd = new StringBuffer();

		char str[] = new char[1];

		//특수기호 포함
		if("P".equals(type)){
			for(int i=0; i<cnt; i++){
				str[0] = (char)((Math.random() * 94)+33);
				strPwd.append(str);
			}
		// 대문자로만
		}else if("A".equals(type)){
			for(int i=0; i<cnt; i++){
				str[0] = (char)((Math.random() * 26)+65);
				strPwd.append(str);
			}
		// 소문자로만
		}else if("S".equals(type)){
			for(int i=0; i<cnt; i++){
				str[0] = (char)((Math.random() * 26)+97);
				strPwd.append(str);
			}
		// 숫자형으로
		}else if("I".equals(type)){
			int strs[] = new int[1];

			for(int i=0; i<cnt; i++){
				strs[0] = (int)((Math.random() * 9));
				strPwd.append(strs[0]);
			}
		// 소문자,숫자형
		}else if("C".equals(type)){
			Random rnd = new Random();

			for(int i=0; i<cnt; i++){
				if(rnd.nextBoolean()){
					strPwd.append((char)((int)(rnd.nextInt(26) + 97)));
				}else{
					strPwd.append((rnd.nextInt(10)));
				}
			}
		}

		return strPwd.toString();
	}
}

