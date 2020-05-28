import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class viewuserinfo extends HttpServlet
{

    public viewuserinfo()
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
        try
        {
            String s = httpservletrequest.getParameter("cn");
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
            printwriter.println("<TD><strong>&nbsp;&nbsp;&nbsp;&nbsp;User ID</strong></TD></TR>");
            String s1;
            for(rs = st.executeQuery("select user_id from userinfo where companyname='" + s + "'"); rs.next(); printwriter.println("<TD>&nbsp;&nbsp;" + s1 + "&nbsp;&nbsp;</TD></TR>"))
            {
                s1 = rs.getString(1);
                printwriter.println("<TR>");
            }

            printwriter.println("<TR>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TD>&nbsp;<a href='./superuserview.html' target='_parent'><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go Back</strong></a></TD></TR>");
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