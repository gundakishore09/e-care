import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class categoryuserlist extends HttpServlet
{

    public categoryuserlist()
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
        String s4 = "";
        try
        {
              System.out.println("in try");
            rs = st.executeQuery("select levelname,categoryid,moduleid,supportid,user_id from hdemp1");
              System.out.println("after rs"+rs);
            printwriter.println("<html>");
            printwriter.println("<head>");
            printwriter.println("<style>");
            printwriter.println("a{ Text-Decoration:none;}");
            printwriter.println("</style>");
            printwriter.println("</head>");
            printwriter.println("<body>");
            printwriter.println("<form > ");
            printwriter.println("<P align=center><FONT size=5><STRONG ");
            printwriter.println("style='COLOR: forestgreen'><U>EmployeeInfo</U></STRONG></FONT></P>");
            printwriter.println("<P align=center>&nbsp;</P>");
            printwriter.println("<P align=center>");
            printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 style='HEIGHT: 130px; WIDTH: 431px'");
            printwriter.println("width=75%>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>LevelName&nbsp;&nbsp;</strong></TD>");
            printwriter.println("<TD><strong>&nbsp;&nbsp;CategoryId&nbsp;&nbsp;</strong></TD>");
            printwriter.println("<TD><strong>&nbsp;&nbsp;Module Id&nbsp;&nbsp;</strong></TD>");
            printwriter.println("<TD><strong>&nbsp;&nbsp;Support Id&nbsp;&nbsp;</strong></TD>");
            printwriter.println("<TD><strong>&nbsp;&nbsp;Employee Id&nbsp;&nbsp;</strong></TD>");
            for(; rs.next(); printwriter.println("</TR>"))
            {
                  System.out.println("in the rs.next()");
                String s = rs.getString(1);
                String s2 = rs.getString(2);
                String s3 = rs.getString(3);
                String s5 = rs.getString(4);
                String s1 = rs.getString(5);
                System.out.println("id is" + s1);
                printwriter.println("<TR>");
                printwriter.println("<TD>&nbsp;&nbsp;" + s + "&nbsp;&nbsp;</TD>");
                printwriter.println("<TD>&nbsp;&nbsp;" + s2 + "&nbsp;&nbsp;</TD>");
                printwriter.println("<TD>&nbsp;&nbsp;" + s3 + "&nbsp;&nbsp;</TD>");
                printwriter.println("<TD>&nbsp;&nbsp;" + s5 + "&nbsp;&nbsp;</TD>");
                printwriter.println("<TD>&nbsp;&nbsp;" + s1 + "&nbsp;&nbsp;</TD>");
            }

            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD><strong>&nbsp;&nbsp;Click here to&nbsp;&nbsp;</strong> &gt;&gt;</TD>");
            printwriter.println("<TD>&nbsp;<a href='./reports'><strong>&nbsp;&nbsp; Go Back&nbsp;&nbsp;</strong></a></TD></TR>");
            printwriter.println("<TR>");
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