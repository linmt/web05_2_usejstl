package tag;

/**
 * Created by 张洲徽 on 2018/9/18.
 */
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
/**
 * 标签类开发要点
 * 	1.继承SimpleTagSupport类。
 * 	2.override doTag方法，编写处理逻辑。
 *  3.标签有哪些属性，标签类也要有相应的属性(属性名称一致，类型要匹配，并且要
 *  提供相应的set方法)。
 */
public class HelloTag extends SimpleTagSupport{
    private String info;
    private int qty;
    //为了知道什么时候实例化
    public HelloTag(){
        System.out.println("HelloTag实例化");
    }
    public void setInfo(String info) {
        System.out.println("设置Info变量" + info);
        this.info = info;
    }
    public void setQty(int qty) {
        System.out.println("设置setQty变量" + qty);
        this.qty = qty;
    }
    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("执行doTag");
        //通过SimpleTagSupport类提供的getJspContext方法获得pageContext
        PageContext ctx=(PageContext)getJspContext();
        //pageContext提供了获得其它隐含对象的方法
        JspWriter out = ctx.getOut();
        for(int i = 0 ;i < qty;i ++){
            out.println(info + "<br/>");
        }
    }
}
