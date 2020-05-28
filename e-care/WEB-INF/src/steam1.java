import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class steam1 extends HttpServlet
{

    public steam1()
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
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            System.out.println("Connection is created");
            st = con.createStatement();
            st1 = con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println("init method" + exception);
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        System.out.println("inside service");
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        String s1 = "";
        String s3 = "";
        try
        {
            System.out.println("inside try");
            System.out.println("kkkkkkkkkkkkkkkk");
            String s4 = httpservletrequest.getParameter("mod1");
            rs = st.executeQuery("select * from supportteam where moduleid='" + s4 + "'");
            printwriter.println("<html>");
            printwriter.println("<head>");
            printwriter.println("<style>");
            printwriter.println("a{ Text-Decoration:none;}");
            printwriter.println("</style>");
            printwriter.println("</head>");
            printwriter.println("<body>");
            printwriter.println("<form > ");
            printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 width=75% align=center>");
            printwriter.println("<P>");
            printwriter.println(" <TR>");
            printwriter.println("  <TD></TD>");
            printwriter.println("  <TD></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=left style='COLOR: forestgreen'><FONT size=5><STRONG><U>HD SupportTeam Members</U></STRONG></FONT></P></TD></TR>");
            printwriter.println("<P align=center>&nbsp;</P>");
            printwriter.println("<P align=center>");
            printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 style='HEIGHT: 130px; WIDTH: 431px'");
            printwriter.println("width=75%>");
            printwriter.println("<TR>");
            printwriter.println("<TD><STRONG>&nbsp;&nbsp;&nbsp;SupportId&nbsp;&nbsp;&nbsp;</STRONG></TD>");
            printwriter.println("<TD><STRONG>&nbsp;&nbsp;&nbsp;SupportTeamName&nbsp;&nbsp;&nbsp;</STRONG></TD>");
            printwriter.println("<TD>");
            printwriter.println("</TR>");
            System.out.println("after rs");
            for(; rs.next(); printwriter.println("</TR>"))
            {
                System.out.println("INSIDE RS");
                String s = rs.getString(1);
                System.out.println("supportteamcode is " + s);
                String s2 = rs.getString(4);
                System.out.println("support team name is " + s2);
                printwriter.println(" <TR> ");
                printwriter.println(" <TD>&nbsp;&nbsp;" + s + "&nbsp;&nbsp;</TD> ");
                printwriter.println(" <TD>&nbsp;&nbsp;" + s2 + "&nbsp;&nbsp;</TD> ");
                printwriter.println(" <TD>  ");
            }

            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>&nbsp;</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD><STRONG>Click here to &gt;&gt;</STRONG></TD>");
            printwriter.println("<TD>&nbsp;<a href='./cat1'>Go Back</a></TD></TR>");
            printwriter.println("</P> ");
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
    Statement st1;
    ResultSet rs;
    ResultSet rs1;
}