import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class superusermessage extends HttpServlet
{

    public superusermessage()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside try");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            System.out.println("Connection is created");
            st = con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            String s = httpservletrequest.getParameter("text1");
            String s1 = httpservletrequest.getParameter("select1");
            System.out.println("Before inserting");
            int i = st.executeUpdate("insert into superusermessages values('" + s1 + "','" + s + "')");
            System.out.println(i + "message inserted");
            printwriter.println("<HTML>");
            printwriter.println("<HEAD>");
            printwriter.println("<TITLE></TITLE>");
            printwriter.println("</HEAD>");
            printwriter.println("<BODY>");
            printwriter.println("<form name=f1 ");
            printwriter.println("action='./superusermessage'>");
            printwriter.println("<P align=center><FONT color=forestgreen ");
            printwriter.println("size=6><STRONG><U>UserInfo</U></STRONG></FONT></P>");
            printwriter.println("<P align=center>");
            printwriter.println("<TABLE border=1 align='center' cellPadding=1 cellSpacing=1 ");
            printwriter.println("width=75%>");
            printwriter.println("<TR>");
            printwriter.println("<TD> </TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println("<TD>select User</TD>");
            printwriter.println("<TD><SELECT id=select1 name=select1 style='HEIGHT: ");
            printwriter.println("22px; WIDTH: 173px'> ");
            printwriter.println("<OPTION selected value='Level 1 ");
            printwriter.println("Administrator'>Level 1 Administrator</OPTION><OPTION ");
            printwriter.println(" value='Level 2 Administrator'>Level 2 '");
            printwriter.println("'Administrator</OPTION><OPTION value='Level 3 ");
            printwriter.println("Administrator'>Level 3 ");
            printwriter.println(" Administrator</OPTION>");
            printwriter.println("<OPTION selected value='To all Administrators'>To all Administrators</OPTION>");
            printwriter.println("<OPTION value=''></OPTION></SELECT></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>Compose</TD>");
            printwriter.println("<TD><INPUT id=text1 name=text1 style='HEIGHT: 173px; ");
            printwriter.println("WIDTH: 339px'></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD><INPUT id=submit1 name=submit1 style='HEIGHT: ");
            printwriter.println("37px; WIDTH: 80px' type=submit value='Send ");
            printwriter.println("'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
            printwriter.println("<INPUT id=submit2 name=submit2 style='HEIGHT: 38px; WIDTH: ");
            printwriter.println("78px' type=submit value='Send all'></TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR></TABLE></P>");
            printwriter.println("</form>");
            printwriter.println("</BODY>");
            printwriter.println("</HTML>");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Connection con;
    Statement st;
    ResultSet rs;
}