/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename EscapedXmlOutTag.java
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
package ncis.cmn.util.tag;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class EscapedXmlOutTag extends BodyTagSupport {

	private static final long serialVersionUID = 7168669777221758032L;

	protected Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public int doStartTag() throws JspException {
		try {

			if(value != null){
				out(pageContext, value);
			}
			return SKIP_BODY;

		} catch (IOException e) {
			throw new JspException(e.toString(), e);
		}
	}

	private void out(PageContext pageContext, Object obj) throws IOException {
		JspWriter w = pageContext.getOut();
		if(obj instanceof Reader){
			Reader reader = (Reader)obj;
			char[] buf = new char[4086];
			int count;
			while((count = reader.read(buf,0,4096)) != -1){
				writeEscapedXml(buf, count, w);
			}
		}else{
			String text = obj.toString();
			writeEscapedXml(text.toCharArray(), text.length(), w);
		}
	}

	private void writeEscapedXml(char[] buffer, int length, JspWriter w) throws IOException {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<length; i++){
			char c = buffer[i];
    		switch(c){
	    		case '<':
	    			sb.append("&lt;");
	    			break;
	    		case '>':
	    			sb.append("&gt;");
	    			break;
	    		case '&':
	    			sb.append("&amp;");
	    			break;
	    		case '"':
	    			sb.append("&#034;");
	    			break;
	    		case '\'':
	    			sb.append("&#039;");
	    			break;
	    		case 10:
	    			sb.append("<br />");
	    			break;
	    		case ' ':
	    			sb.append("&nbsp;");
	    			break;
    			default:
    				sb.append(c);
    		}
		}
		w.write(sb.toString());
	}

}
