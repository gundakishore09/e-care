
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class level1module extends HttpServlet
{

    public level1module()
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
        try
        {
            System.out.println("inside try");
            String s = httpservletrequest.getParameter("mod");
            System.out.println("module is" + s);
            rs = st.executeQuery("select * from module where categoryid='" + s + "'");
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
            printwriter.println("<P align=left style='COLOR: forestgreen'><FONT size=5><STRONG><U>HD Categories-Modules</U></STRONG></FONT></P></TD></TR>");
            printwriter.println("<P align=center>&nbsp;</P>");
            printwriter.println("<P align=center>");
            printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 style='HEIGHT: 130px; WIDTH: 431px'");
            printwriter.println("width=75%>");
            printwriter.println("<TR>");
            printwriter.println("<TD><STRONG>&nbsp;&nbsp;&nbsp;ModuleId&nbsp;&nbsp;&nbsp;</STRONG></TD>");
            printwriter.println("<TD><STRONG>&nbsp;&nbsp;&nbsp;CategoryId&nbsp;&nbsp;&nbsp;</STRONG></TD>");
            printwriter.println("<TD><STRONG>&nbsp;&nbsp;&nbsp;ModuleName&nbsp;&nbsp;&nbsp;</STRONG></TD>");
            printwriter.println("<TD><STRONG>&nbsp;&nbsp;Status&nbsp;&nbsp;&nbsp;</STRONG></TD>");
            printwriter.println("<TD>");
            printwriter.println("<P align=center><STRONG>&nbsp;&nbsp;Actions&nbsp;&nbsp;</STRONG></P></TD></TR>");
            System.out.println("after rs");
            for(; rs.next(); printwriter.println("</TR>"))
            {
                System.out.println("INSIDE RS");
                String s1 = rs.getString(1);
                System.out.println("modulecode is " + s1);
                String s2 = rs.getString(2);
                System.out.println("categorycode is " + s2);
                String s3 = rs.getString(3);
                System.out.println("modulename is " + s3);
                String s4 = rs.getString(4);
                System.out.println("modulestatus is " + s4);
                String s5 = "Modify Delete";
                printwriter.println(" <TR> ");
                printwriter.println(" <TD>&nbsp;&nbsp;<a href='./supportteam?mod1=" + s1 + "'>" + s1 + "</a>&nbsp;&nbsp;</TD> ");
                printwriter.println(" <TD>&nbsp;&nbsp;" + s2 + "&nbsp;&nbsp;</TD> ");
                printwriter.println(" <TD>&nbsp;&nbsp;" + s3 + "&nbsp;&nbsp;</TD> ");
                printwriter.println(" <TD>&nbsp;&nbsp;" + s4 + "&nbsp;&nbsp;</TD> ");
                printwriter.println(" <TD>  ");
                printwriter.println("<P align=center><a href='./modifymodule?m=" + s1 + "&c=" + s2 + "&n=" + s3 + "&s=" + s4 + "'>Modify</a><a href='./deletemodule?m=" + s1 + "&c=" + s2 + "&n=" + s3 + "&s=" + s4 + "'>Delete</a></P></TD>");
            }

            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD>&nbsp;</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
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