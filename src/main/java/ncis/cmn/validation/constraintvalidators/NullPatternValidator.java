/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename NullPatternValidator.java
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
package ncis.cmn.validation.constraintvalidators;

import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ncis.cmn.validation.constrains.NullPattern;

import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

public class NullPatternValidator implements ConstraintValidator<NullPattern, CharSequence> {

	private static final Log log = LoggerFactory.make();

	private java.util.regex.Pattern pattern;

	@Override
	public void initialize(NullPattern parameters) {
		NullPattern.Flag[] flags = parameters.flags();
		int intFlag = 0;
		for ( NullPattern.Flag flag : flags ) {
			intFlag = intFlag | flag.getValue();
		}

		try {
			pattern = java.util.regex.Pattern.compile( parameters.regexp(), intFlag );
		}
		catch ( PatternSyntaxException e ) {
			throw log.getInvalidRegularExpressionException( e );
		}
	}

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext constraintValidatorContext) {
		if ( value == null || "".equals(value) ) {
			return true;
		}
		Matcher m = pattern.matcher( value );
		return m.matches();
	}
}
