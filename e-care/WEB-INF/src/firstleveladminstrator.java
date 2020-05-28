
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

public class firstleveladminstrator extends HttpServlet
{

    public firstleveladminstrator()
    {
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        httpservletresponse.setContentType("text/html");
        PrintWriter printwriter = httpservletresponse.getWriter();
        try
        {
            printwriter.println("<HTML><HEAD>1st Level Adminstrator<TITLE></TITLE>");
            printwriter.println("<META content=\"text\"/html; charset=unicode\"\" http-equiv=Content-Type>");
            printwriter.println("<META content=\"MSHTML\" 5.00.2614.3500\"\" name=GENERATOR></HEAD>");
            printwriter.println("<BODY>");
            printwriter.println("<TABLE border=0 cellPadding=0 cellSpacing=0 id=TABLE1 width=100%>");
            printwriter.println("<TR>");
            printwriter.println("<TD colSpan=2 width=20%>&nbsp;</TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=right>&nbsp;</P></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=right><FONT face=Comic Sans MS size=5");
            printwriter.println(">e-Care&nbsp;&nbsp; </FONT></P></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD colSpan=2></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD width=35%>");
            printwriter.println("<P align=right><STRONG>enhanced customer support </STRONG></P>   </TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println(" <TD colSpan=2><FONT face=System>CATEGORIES</FONT></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD colSpan=2></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD colSpan=2>&nbsp;</TD>");
            printwriter.println("<TD>&nbsp;</TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=right><STRONG>Profile</STRONG></P></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD colSpan=2>");
            printwriter.println("<P align=center><STRONG>&nbsp;Category");
            printwriter.println("code</STRONG> </P> </TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=center><STRONG>Category name</STRONG> </P></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=center><STRONG>Status</STRONG></P></TD>");
            printwriter.println("<TD><STRONG>Modify</STRONG></TD>");
            printwriter.println("<TD><STRONG>Delete</STRONG>");
            printwriter.println("</TD>");
            printwriter.println("<TD>");
            printwriter.println("</P></A></TD></TR>");
            printwriter.println("<P align=right><STRONG>Messages<A href=\"C:\"KAVITHA\"\"COMPANY_INFO.HTML\"\" >");
            printwriter.println("<P align=right><A href=\"C:\"KAVITHA\"\"COMPANYINFO.HTML\"\" >");
            printwriter.println("</P></A></STRONG></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD colSpan=2>");
            printwriter.println("<P align=left><STRONG>&nbsp;&nbsp;&nbsp;C-0001&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG>");
            printwriter.println("</P></TD>");
            printwriter.println("<TD>&nbsp;&nbsp;</TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=right><STRONG>Support team<A href=\"C:\"KAVITHA\"\"employee.HTML\"\" ></P></A></STRONG></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD colSpan=2>");
            printwriter.println("<P align=left><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG>");
            printwriter.println("</P></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=right><STRONG>HD Problem List<A href=\"C:\"KAVITHA\"\"category.HTML\"\" ></P></A></STRONG></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD colSpan=2>");
            printwriter.println("<P align=left>&nbsp;</P></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=left>   &nbsp;</P></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=right><A");
            printwriter.println(".\"LOGOFF.HTML\"\"><STRONG>Logout&nbsp;</STRONG></A><A");
            printwriter.println(".\"LOGOFF.HTML\"\"></P></A></TD></TR></TABLE></BODY></HTML>");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
}