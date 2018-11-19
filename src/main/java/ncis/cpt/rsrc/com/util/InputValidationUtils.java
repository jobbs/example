/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename InputValidationUtils.java
 *
 * @author 심원보
 * @lastmodifier 심원보
 * @created 2016. 10. 13.
 * @lastmodified 2016. 10. 13.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 13.     심원보         v1.0             최초생성
 *
 */
package ncis.cpt.rsrc.com.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * @author 심원보
 *
 */
public class InputValidationUtils {

    /**
     * Max, Size 어노테이션 최대 길이
     *
     * @param targetClassName
     * @param fieldName
     * @param groupInterfaceName
     * @return
     */
    public static String getMaxlength(String targetClassName, String fieldName, String groupInterfaceName) {

        Class<?> targetClass = null;
        Class<?> groupClass = null;
        try {
            targetClass = Class.forName(targetClassName);
            groupClass = Class.forName(groupInterfaceName);

            Field field = FieldUtils.getField(targetClass, fieldName, true);

            if (field == null) {
                targetClass = targetClass.getSuperclass();
                if (targetClass != null) {
                    field = FieldUtils.getField(targetClass, fieldName, true);
                }
            }

            if (field == null) {
                return "";
            }

            for (Annotation annotation : field.getAnnotations()) {
                if (annotation.annotationType().equals(Size.class))
                    for (Class<?> clazz : ((Size) annotation).groups())
                        if (clazz.isAssignableFrom(groupClass))
                            return String.valueOf(((Size) annotation).max());
                if (annotation.annotationType().equals(Max.class))
                    for (Class<?> clazz : ((Max) annotation).groups())
                        if (clazz.isAssignableFrom(groupClass))
                            return String.valueOf(((Max) annotation).value());
                if (annotation.annotationType().equals(DecimalMax.class))
                    for (Class<?> clazz : ((DecimalMax) annotation).groups())
                        if (clazz.isAssignableFrom(groupClass))
                            return String.valueOf(((DecimalMax) annotation).value().length());
            }

        } catch (ClassNotFoundException e) {
            return "";
        }

        return "";
    }

    /**
     * DecimalMax 어노테이션 최대값
     *
     * @param targetClassName
     * @param fieldName
     * @param groupInterfaceName
     * @return
     */
    public static String getMax(String targetClassName, String fieldName, String groupInterfaceName) {

        Class<?> targetClass = null;
        Class<?> groupClass = null;
        try {
            targetClass = Class.forName(targetClassName);
            groupClass = Class.forName(groupInterfaceName);

            Field field = FieldUtils.getField(targetClass, fieldName, true);

            if (field == null) {
                targetClass = targetClass.getSuperclass();
                if (targetClass != null) {
                    field = FieldUtils.getField(targetClass, fieldName, true);
                }
            }

            if (field == null) {
                return "";
            }

            for (Annotation annotation : field.getAnnotations()) {
                if (annotation.annotationType().equals(DecimalMax.class))
                    for (Class<?> clazz : ((DecimalMax) annotation).groups())
                        if (clazz.isAssignableFrom(groupClass))
                            return String.valueOf(((DecimalMax) annotation).value());
            }

        } catch (ClassNotFoundException e) {
            return "";
        }

        return "";
    }
}
