package tag;

/**
 * Created by ���޻� on 2018/9/18.
 */
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends SimpleTagSupport{
    private String pattern;
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    @Override
    public void doTag() throws JspException, IOException {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        PageContext ctx=(PageContext)getJspContext();
        JspWriter out = ctx.getOut();
        out.println(sdf.format(date));
    }
}
