import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class profile1 extends HttpServlet
{

    public profile1()
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
        String s = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s8 = "";
        String s9 = "";
        String s10 = "";
        String s12 = "";
        String s14 = "";
        String s16 = "";
        int i = 0;
        int j = 0;
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        System.out.println("inside servicemethod");
        try
        {
            System.out.println("inside servicetry");
            for(rs = st.executeQuery("select * from superuserprofile"); rs.next();)
            {
                System.out.println("inside if");
                s = rs.getString(1);
                System.out.println("fnameis " + s);
                s1 = rs.getString(2);
                System.out.println("lname is " + s1);
                s2 = rs.getString(3);
                System.out.println("address:" + s2);
                j = rs.getInt(4);
                System.out.println("phone is:" + j);
                s4 = rs.getString(5);
                System.out.println("state is:" + s4);
                s3 = rs.getString(6);
                System.out.println("city is:" + s3);
                s5 = rs.getString(7);
                System.out.println("country is:" + s5);
                i = rs.getInt(8);
                System.out.println("zip is:" + i);
                s8 = rs.getString(9);
                System.out.println("gender is:" + s8);
                s9 = rs.getString(10);
                System.out.println("website is:" + s9);
                String s7 = rs.getString(11);
                System.out.println("userid is:" + s7);
                String s15 = rs.getString(12);
                System.out.println("pass is:" + s15);
                String s17 = rs.getString(13);
                String s11 = rs.getString(14);
                String s13 = rs.getString(15);
            }

            printwriter.println("<HTML>");
            printwriter.println("<HEAD>");
            printwriter.println("<TITLE></TITLE>");
            printwriter.println("</HEAD>");
            printwriter.println("<BODY>");
            printwriter.println("<form name=f action='http://localhost:8080/superuserview.html'target='_parent'>");
            printwriter.println("<P align=center><FONT color=forestgreen ");
            printwriter.println("size=6><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp; ");
            printwriter.println("<U><strong>Super User Profile</strong></U></STRONG></FONT></P>");
            printwriter.println("<TABLE border=0 align=center cellPadding=1 cellSpacing=1 width=75%>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>First Name</strong></TD>");
            printwriter.println("<TD>" + s + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD><strong>Last Name</strong></TD>");
            printwriter.println("<TD>" + s1 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Address</strong></TD>");
            printwriter.println("<TD>" + s2 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>PhoneNumber</strong></TD>");
            printwriter.println("<TD>" + j + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>State</strong></TD>");
            printwriter.println("<TD>" + s4 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>City</strong></TD>");
            printwriter.println(" <TD>" + s3 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Country</strong></TD>");
            printwriter.println(" <TD>" + s5 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>PinCode</strong></TD>");
            printwriter.println(" <TD>" + i + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD><strong>Gender</strong></TD>");
            printwriter.println("<TD>" + s8 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD><strong>Email Id</strong></TD>");
            printwriter.println(" <TD>" + s9 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
            printwriter.println("<INPUT id=submit1 name=submit1 type=submit value=Ok></TD>");
            printwriter.println(" <TD></TD></TR></TABLE>");
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