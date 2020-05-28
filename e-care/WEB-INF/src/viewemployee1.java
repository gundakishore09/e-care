import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class viewemployee1 extends HttpServlet
{

    public viewemployee1()
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
        System.out.println("inside service");
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String s8 = "";
        String s9 = "";
        String s10 = "";
        String s11 = "";
        String s12 = "";
        String s13 = "";
        String s14 = "";
        String s15 = "";
        String s16 = "";
        String s17 = "";
        String s18 = "";
        int i = 0;
        int j = 0;
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        String s = httpservletrequest.getParameter("l");
        System.out.println(s);
        String s1 = httpservletrequest.getParameter("c");
        System.out.println(s1);
        String s2 = httpservletrequest.getParameter("m");
        System.out.println(s2);
        String s3 = httpservletrequest.getParameter("s");
        System.out.println(s3);
        String s4 = httpservletrequest.getParameter("u");
        System.out.println(s4);
        try
        {
            rs = st.executeQuery("select * from hdemp1 where user_id='" + s4 +"'");
            if(rs.next())
            {
                s5 = rs.getString(1);
                System.out.println("lname" + s5);
                s6 = rs.getString(2);
                System.out.println("categoryid" + s6);
                s7 = rs.getString(3);
                System.out.println("moduleid" + s7);
                s8 = rs.getString(4);
                System.out.println("supportmemberid" + s8);
                s9 = rs.getString(5);
                System.out.println("userid" + s9);
                s10 = rs.getString(6);
                s11 = rs.getString(7);
                s12 = rs.getString(8);
                s13 = rs.getString(9);
                s14 = rs.getString(10);
                i = rs.getInt(11);
                j = rs.getInt(12);
                s15 = rs.getString(13);
                System.out.println("email" + s15);
                s16 = rs.getString(14);
                System.out.println("pas" + s16);
                s17 = rs.getString(16);
                System.out.println("hintque" + s17);
                s18 = rs.getString(17);
                System.out.println("hintsolution" + s18);
            }
            printwriter.println("<HTML>");
            printwriter.println("<HEAD>");
            printwriter.println("<TITLE></TITLE>");
            printwriter.println("</HEAD>");
            printwriter.println("<BODY>");
            printwriter.println("<form name=f1 action='./employee'>");
            printwriter.println("<P>");
            printwriter.println("<TABLE border=0 align='center' cellPadding=1 cellSpacing=1 width=75%>");
            printwriter.println(" <TR>");
            printwriter.println("   <TD></TD>");
            printwriter.println("<TD><FONT size=4><STRONG>View Employee Details</STRONG></FONT></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD>  </TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("  <TD>Level name</TD>");
            printwriter.println("<TD>" + s5 + "</TD></TR>");
            printwriter.println("  <TD>Categoryid</TD>");
            printwriter.println("<TD>" + s6 + "</TD></TR>");
            printwriter.println("  <TD>Moduleid</TD>");
            printwriter.println("<TD>" + s7 + "</TD></TR>");
            printwriter.println("  <TD>Supportid</TD>");
            printwriter.println("<TD>" + s8 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>Userid</TD>");
            printwriter.println("<TD>" + s9 + "</TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println("<TD>Employeename</TD>");
            printwriter.println("   <TD>" + s10 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>Address</TD>");
            printwriter.println("<TD>" + s11 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>City</TD>");
            printwriter.println(" <TD>" + s12 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>State</TD>");
            printwriter.println("<TD>" + s13 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>Country</TD>");
            printwriter.println("<TD>" + s14 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>Zipcode</TD>");
            printwriter.println("<TD>" + i + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>Phno</TD>");
            printwriter.println("<TD>" + j + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>Email</TD>");
            printwriter.println("<TD>" + s15 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>password</TD>");
            printwriter.println("<TD>" + s16 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>hintquestion</TD>");
            printwriter.println("<TD>" + s17 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>hintsoultion</TD>");
            printwriter.println("<TD>" + s18 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD></TD></TR>");
            printwriter.println("<TD></TD>");
            printwriter.println("<TD><INPUT id=submit1 name=submit1 type=submit value=OK></TD></TR>");
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