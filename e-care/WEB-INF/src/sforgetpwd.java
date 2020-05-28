import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class sforgetpwd extends HttpServlet
{

    public sforgetpwd()
    {
        flag = 0;
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
        String s = "";
        String s1 = "";
        String s3 = "";
        String s5 = "";
        String s7 = "";
        String s9 = "";
        String s11 = "";
        String s12 = "";
        boolean flag1 = false;
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            System.out.println("hello");
            String s2 = httpservletrequest.getParameter("user_id");
            System.out.println("user_id is " + s2);
            String s4 = httpservletrequest.getParameter("hintquestion");
            System.out.println("hque is " + s4);
            String s6 = httpservletrequest.getParameter("hintsolution");
            System.out.println("hintsolution is " + s6);
            System.out.println("before select statement");
            rs = st.executeQuery("select user_id,password from superuserprofile where user_id='" + s2 + "'");
            System.out.println("After query");
            if(rs.next())
            {
                System.out.println("Inside while");
                String s8 = rs.getString(1);
                System.out.println("u is " + s8);
                String s10 = rs.getString(2);
                System.out.println("p is " + s10);
                printwriter.println("<HTML>");
                printwriter.println("<HEAD>");
                printwriter.println("<TITLE></TITLE>");
                printwriter.println("<BODY>");
                printwriter.println("<form name=f1 action=./superlogin.html>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P align=center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                printwriter.println("<FONT size=5> ");
                printwriter.println("<STRONG><U 'style=COLOR: forestgreen'>Forget Password</U></STRONG></FONT></P>");
                printwriter.println("<P align=center>&nbsp;</P>");
                printwriter.println("<TABLE border=0 align=center cellPadding=1 cellSpacing=1 width=75%>");
                printwriter.println(" <TR>");
                printwriter.println("<TD>");
                printwriter.println("  <P align=left><STRONG style='COLOR: forestgreen' ");
                printwriter.println("  >User ");
                printwriter.println("  Name&nbsp; is ");
                printwriter.println("</STRONG> </P></TD>");
                printwriter.println("  <TD><INPUT id=user_id name=user_id value='" + s8 + "'></TD></TR>");
                printwriter.println(" <TR>");
                printwriter.println("  <TD>");
                printwriter.println(" <P align=left><STRONG style='COLOR: forestgreen' ");
                printwriter.println(" >Password is </STRONG>  </P></TD>");
                printwriter.println("<TD>");
                printwriter.println("  <P align=left><INPUT id=text1 name=text1 value='" + s10 + "'></P></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println(" <TD>");
                printwriter.println(" <P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                printwriter.println(" </P>");
                printwriter.println(" <P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                printwriter.println(" </P>");
                printwriter.println(" <P>&nbsp;</P></TD>");
                printwriter.println(" <TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT id=submit1 name=submit1 style=HEIGHT: 24px; WIDTH: 73px type=submit value=OK>&nbsp;&nbsp;</TD></TR></TABLE>");
                printwriter.println("</form>");
                printwriter.println("</BODY>");
                printwriter.println("</HTML>");
            } 
			rs = st.executeQuery("select user_id,password from hdemp1 where user_id='" + s2 + "'");
			System.out.println("After query");
            if(rs.next())
            {
                System.out.println("Inside while");
                String s8 = rs.getString(1);
                System.out.println("u is " + s8);
                String s10 = rs.getString(2);
                System.out.println("p is " + s10);
                printwriter.println("<HTML>");
                printwriter.println("<HEAD>");
                printwriter.println("<TITLE></TITLE>");
                printwriter.println("<BODY>");
                printwriter.println("<form name=f1 action=./superlogin.html>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P align=center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                printwriter.println("<FONT size=5> ");
                printwriter.println("<STRONG><U 'style=COLOR: forestgreen'>Forget Password</U></STRONG></FONT></P>");
                printwriter.println("<P align=center>&nbsp;</P>");
                printwriter.println("<TABLE border=0 align=center cellPadding=1 cellSpacing=1 width=75%>");
                printwriter.println(" <TR>");
                printwriter.println("<TD>");
                printwriter.println("  <P align=left><STRONG style='COLOR: forestgreen' ");
                printwriter.println("  >User ");
                printwriter.println("  Name&nbsp; is ");
                printwriter.println("</STRONG> </P></TD>");
                printwriter.println("  <TD><INPUT id=user_id name=user_id value='" + s8 + "'></TD></TR>");
                printwriter.println(" <TR>");
                printwriter.println("  <TD>");
                printwriter.println(" <P align=left><STRONG style='COLOR: forestgreen' ");
                printwriter.println(" >Password is </STRONG>  </P></TD>");
                printwriter.println("<TD>");
                printwriter.println("  <P align=left><INPUT id=text1 name=text1 value='" + s10 + "'></P></TD></TR>");
                printwriter.println("<TR>");
                printwriter.println(" <TD>");
                printwriter.println(" <P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                printwriter.println(" </P>");
                printwriter.println(" <P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                printwriter.println(" </P>");
                printwriter.println(" <P>&nbsp;</P></TD>");
                printwriter.println(" <TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT id=submit1 name=submit1 style=HEIGHT: 24px; WIDTH: 73px type=submit value=OK>&nbsp;&nbsp;</TD></TR></TABLE>");
                printwriter.println("</form>");
                printwriter.println("</BODY>");
                printwriter.println("</HTML>");
            } 
			else
            {
                printwriter.println("<HTML>");
                printwriter.println("<HEAD>");
                printwriter.println("<BODY>");
                printwriter.println("<form name=f1 action=./sforgetpwd.html style=COLOR: forestgreen>");
                printwriter.println("<P>&nbsp;</P>");
                printwriter.println("<P align=center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                printwriter.println("<FONT size=5>");
                printwriter.println("<STRONG><U style=COLOR: forestgreen>Forget Password</U></STRONG></FONT></P>");
                printwriter.println("<P align=center>&nbsp;</P>");
                printwriter.println("<P align=center>&nbsp;</P>");
                printwriter.println("<P align=center><STRONG><FONT size=4>Invalid Values </FONT></STRONG></P>");
                printwriter.println("<P align=center><FONT size=4><STRONG>Please Check again</STRONG></FONT></P>");
                printwriter.println("<P align=center>&nbsp;</P>");
                printwriter.println("<P align=center><INPUT id=submit1 name=submit1 style=HEIGHT: 24px; WIDTH: 60px type=submit value=OK></P>");
                printwriter.println("</form>");
                printwriter.println("</BODY>");
                printwriter.println("</HTML>");
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
    int flag;
}