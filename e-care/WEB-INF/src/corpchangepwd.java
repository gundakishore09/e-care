
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class corpchangepwd extends HttpServlet
{

    public corpchangepwd()
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
        try
        {
            System.out.println("Inside try");
            String s = httpservletrequest.getParameter("user_id");
            System.out.println("user_id is " + s);
            String s1 = httpservletrequest.getParameter("password1");
            System.out.println("password is " + s1);
            String s2 = httpservletrequest.getParameter("password2");
            System.out.println("password is " + s2);
            System.out.println("Checking User");
            rs = st.executeQuery("select user_id,password from registration where user_id='" + s + "' and password='" + s1 + "'");
            System.out.println("Checking");
            if(rs.next())
            {
                int i = st.executeUpdate("update registration set password='" + s2 + "' where user_id='" + s + "'");
                if(i == 1)
                {
                    printwriter.println("<HTML>");
                    printwriter.println("<HEAD>");
                    printwriter.println("<META NAME='GENERATOR' Content='Microsoft Visual Studio 6.0'>");
                    printwriter.println("<TITLE></TITLE>");
                    printwriter.println("<BODY>");
                    printwriter.println("<form name=f1 action=./elogin.html>");
                    printwriter.println("<P>&nbsp;</P>");
                    printwriter.println("<P>&nbsp;</P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P align=center><STRONG> ");
                    printwriter.println("<U>CHANGE PASSWORD</U></STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 width='75%' align=center>");
                    printwriter.println(" <TR>");
                    printwriter.println(" <TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    printwriter.println(" <STRONG>USER_ID&nbsp; :</STRONG></TD>");
                    printwriter.println(" <TD><INPUT id=user_id name=user_id value='" + s + "'></TD></TR>");
                    printwriter.println(" <TR>");
                    printwriter.println("  <TD><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Your New Password is&nbsp;&nbsp;:</STRONG></TD>");
                    printwriter.println("<TD><INPUT id=text name=text type=text value='" + s2 + "'></TD></TR>");
                    printwriter.println("<TR>");
                    printwriter.println("<TD></TD>");
                    printwriter.println("<TD><INPUT id=submit1 name=submit1 type=submit  value=submit style='HEIGHT: 24px; WIDTH: 66px'>&nbsp;</TD></TR></TABLE>&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                    printwriter.println("</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P></form></FORM>");
                    printwriter.println("</BODY></HTML>");
                }
            }
            rs = st.executeQuery("select user_id,password from hdemp1 where user_id='" + s + "' and password='" + s1 + "'");
            if(rs.next())
            {
                int j = st.executeUpdate("update hdemp1 set password='" + s2 + "' where userid='" + s + "'");
                if(j == 1)
                {
                    printwriter.println("<HTML>");
                    printwriter.println("<HEAD>");
                    printwriter.println("<META NAME='GENERATOR' Content='Microsoft Visual Studio 6.0'>");
                    printwriter.println("<TITLE></TITLE>");
                    printwriter.println("<BODY>");
                    printwriter.println("<form name=f1 action=./superlogin.html>");
                    printwriter.println("<P>&nbsp;</P>");
                    printwriter.println("<P>&nbsp;</P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P align=center><STRONG> ");
                    printwriter.println("<U>CHANGE PASSWORD</U></STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 width='75%' align=center>");
                    printwriter.println(" <TR>");
                    printwriter.println(" <TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    printwriter.println(" <STRONG>USER_ID&nbsp; :</STRONG></TD>");
                    printwriter.println(" <TD><INPUT id=user_id name=user_id value='" + s + "'></TD></TR>");
                    printwriter.println(" <TR>");
                    printwriter.println("  <TD><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Your New Password is&nbsp;&nbsp;:</STRONG></TD>");
                    printwriter.println("<TD><INPUT id=text name=text type=text value='" + s2 + "'></TD></TR>");
                    printwriter.println("<TR>");
                    printwriter.println("<TD></TD>");
                    printwriter.println("<TD><INPUT id=submit1 name=submit1 type=submit  value=submit style='HEIGHT: 24px; WIDTH: 66px'>&nbsp;</TD></TR></TABLE>&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                    printwriter.println("</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P></form></FORM>");
                    printwriter.println("</BODY></HTML>");
                }
            } else
            {
                printwriter.println("user name not valid");
            }
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