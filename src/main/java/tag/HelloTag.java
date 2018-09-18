package tag;

/**
 * Created by ���޻� on 2018/9/18.
 */
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
/**
 * ��ǩ�࿪��Ҫ��
 * 	1.�̳�SimpleTagSupport�ࡣ
 * 	2.override doTag��������д�����߼���
 *  3.��ǩ����Щ���ԣ���ǩ��ҲҪ����Ӧ������(��������һ�£�����Ҫƥ�䣬����Ҫ
 *  �ṩ��Ӧ��set����)��
 */
public class HelloTag extends SimpleTagSupport{
    private String info;
    private int qty;
    //Ϊ��֪��ʲôʱ��ʵ����
    public HelloTag(){
        System.out.println("HelloTagʵ����");
    }
    public void setInfo(String info) {
        System.out.println("����Info����" + info);
        this.info = info;
    }
    public void setQty(int qty) {
        System.out.println("����setQty����" + qty);
        this.qty = qty;
    }
    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("ִ��doTag");
        //ͨ��SimpleTagSupport���ṩ��getJspContext�������pageContext
        PageContext ctx=(PageContext)getJspContext();
        //pageContext�ṩ�˻��������������ķ���
        JspWriter out = ctx.getOut();
        for(int i = 0 ;i < qty;i ++){
            out.println(info + "<br/>");
        }
    }
}
