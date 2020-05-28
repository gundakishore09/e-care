import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class userprofile extends HttpServlet
{

    public userprofile()
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
   HttpSession session=httpservletrequest.getSession(true);
         String vittu=(String)session.getValue("user");
        String s = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s8 = "";
        String s10 = "";
        String s11 = "";
        String s12 = "";
        String s14 = "";
        String s16 = "";
        String s18 = "";
        String s20 = "corpuser";
        int i = 0;
        int j = 0;
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        System.out.println("inside servicemethod");
        try
        {
            System.out.println("inside servicetry");
            System.out.println(s20);
            for(rs = st.executeQuery("select * from registration where user_id='" + vittu+ "'"); rs.next();)
            {
                System.out.println("inside USER PROFILE");
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
                s10 = rs.getString(8);
                System.out.println("gender is:" + s10);
                i = rs.getInt(9);
                System.out.println("zip is:" + i);
                s11 = rs.getString(10);
                System.out.println("website is:" + s11);
                String s7 = rs.getString(11);
                System.out.println("ctype is:" + s7);
                String s9 = rs.getString(12);
                System.out.println("userid is:" + s9);
                String s17 = rs.getString(13);
                System.out.println("pass is:" + s17);
                String s19 = rs.getString(14);
                String s13 = rs.getString(15);
                String s15 = rs.getString(16);
            }

            printwriter.println("<HTML>");
            printwriter.println("<HEAD>");
            printwriter.println("<TITLE></TITLE>");
            printwriter.println("</HEAD>");
            printwriter.println("<script language='JavaScript'>");
            printwriter.println("function okay(){");
            printwriter.println("document.f.action='./corporateuserview.html';");
            printwriter.println("document.f.submit();");
            printwriter.println("}");
            printwriter.println("</script>");
            printwriter.println("<BODY>");
            printwriter.println("<form name=f action='./corpotateuserview.html'target='_parent'>");
            printwriter.println("<P align=center><FONT color=forestgreen ");
            printwriter.println("size=6><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp; ");
            printwriter.println("<U>User Profile</U></STRONG></FONT></P>");
            printwriter.println("<TABLE border=0 align=center cellPadding=1 cellSpacing=1 width=75%>");
            printwriter.println("<TR>");
            printwriter.println("<TD>First Name</TD>");
            printwriter.println("<TD>" + s + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>Last Name</TD>");
            printwriter.println("<TD>" + s1 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>Address</TD>");
            printwriter.println("<TD>" + s2 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>PhoneNumber</TD>");
            printwriter.println("<TD>" + j + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>State</TD>");
            printwriter.println("<TD>" + s4 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>City</TD>");
            printwriter.println(" <TD>" + s3 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>Country</TD>");
            printwriter.println(" <TD>" + s5 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>Gender</TD>");
            printwriter.println("<TD>" + s10 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>PinCode</TD>");
            printwriter.println(" <TD>" + i + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>Email ID</TD>");
            printwriter.println(" <TD>" + s11 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;");
            printwriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
            printwriter.println("<INPUT id=submit1 name=submit1 type=submit value=Ok onClick='okay()'></TD>");
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