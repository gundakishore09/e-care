import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class userinfo1 extends HttpServlet
{

    public userinfo1()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside init");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
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
        javax.servlet.http.HttpSession httpsession = httpservletrequest.getSession(true);
        try
        {
            rs = st.executeQuery("select * from hdcompanyinfo");
            printwriter.println("<html>");
            printwriter.println("<head>");
            printwriter.println("<style>");
            printwriter.println("a{ Text-Decoration:none;}");
            printwriter.println("</style>");
            printwriter.println("</head>");
            printwriter.println("<body>");
            printwriter.println("<form > ");
            printwriter.println("<P align=center><FONT size=5><STRONG ");
            printwriter.println("style='COLOR: forestgreen'><U>HD User Info</U></STRONG></FONT></P>");
            printwriter.println("<P align=center>&nbsp;</P>");
            printwriter.println("<P align=center>");
            printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 style='HEIGHT: 130px; WIDTH: 431px'");
            printwriter.println("width=75%>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>&nbsp;&nbsp;LocationId&nbsp;&nbsp;</strong></TD>");
            printwriter.println("<TD><strong>&nbsp;&nbsp;LocationName&nbsp;&nbsp;</strong></TD>");
            printwriter.println("<TD>&nbsp;&nbsp;<strong>CompanyName&nbsp;</strong></TD>");
            printwriter.println("<TD><strong>&nbsp;&nbsp;User ID&nbsp;&nbsp;</strong></TD>");
            printwriter.println("<TD><strong>&nbsp;&nbsp;&nbsp;&nbsp;</strong></TD></TR>");
            for(; rs.next(); printwriter.println("</TR>"))
            {
                String s2 = rs.getString(1);
                String s = rs.getString(2);
                String s1 = rs.getString(3);
                String s3 = rs.getString(4);
                printwriter.println("<TR>");
                printwriter.println("<TD>&nbsp;&nbsp;" + s2 + "&nbsp;&nbsp;</TD>");
                printwriter.println("<TD>&nbsp;&nbsp;" + s + "&nbsp;&nbsp;</TD>");
                printwriter.println("<TD>&nbsp;&nbsp;" + s1 +"</TD>");
                printwriter.println("<TD>&nbsp;&nbsp;" + s3 + "&nbsp;&nbsp;</TD>");
                printwriter.println("<TD></TD>");
            }

            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("</TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR></TABLE></P>");
            printwriter.println("<P align=center>&nbsp;</P>");
            printwriter.println("</form>");
            printwriter.println("</body>");
            printwriter.println("</html>");
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