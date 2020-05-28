import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class viewcompanyinfo extends HttpServlet
{

    public viewcompanyinfo()
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
            st1 = con.createStatement();
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
        String s = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        int i = 0;
        int j = 0;
        PrintWriter printwriter = httpservletresponse.getWriter();
        String s7 = "";
        String s9 = "";
        String s11 = "";
        String s12 = "";
        String s13 = "";
        String s14 = "";
        String s15 = "";
        String s16 = "";
        String s17 = "";
        String s18 = "";
        String s19 = "";
        httpservletresponse.setContentType("text/html");
        s = httpservletrequest.getParameter("l");
        System.out.println(s);
        s13 = httpservletrequest.getParameter("ln");
        System.out.println(s13);
        s1 = httpservletrequest.getParameter("cn");
        System.out.println(s1);
        s2 = httpservletrequest.getParameter("u");
        System.out.println(s2);
        try
        {
            rs = st.executeQuery("select * from hdcompanyinfo where user_id='" + s2 +"'");
            if(rs.next())
            {
                s3 = rs.getString(1);
                System.out.println("lid" + s3);
                s4 = rs.getString(2);
                System.out.println("locationname" + s4);
                String s6 = rs.getString(3);
                System.out.println("companyname" + s6);
                String s8 = rs.getString(4);
                System.out.println("userid is" + s8);
            }
            rs1 = st1.executeQuery("select * from registration where user_id='" + s2 + "'");
            if(rs1.next())
            {
                System.out.println("inside rs1");
                s11 = rs1.getString(1);
                s13 = rs1.getString(2);
                s14 = rs1.getString(3);
                j = rs1.getInt(4);
                s15 = rs1.getString(5);
                s16 = rs1.getString(6);
                s17 = rs1.getString(7);
                s18 = rs1.getString(8);
                i = rs1.getInt(9);
                s12 = rs1.getString(10);
                String s20 = rs1.getString(11);
                String s10 = rs1.getString(12);
                System.out.println(s10);
            }
            printwriter.println("<HTML>");
            printwriter.println("<HEAD>");
            printwriter.println("<TITLE></TITLE>");
            printwriter.println("</HEAD>");
            printwriter.println("<BODY>");
            printwriter.println("<form name=f1 action='./companyinfo'>");
            printwriter.println("<P>");
            printwriter.println("<TABLE border=0 align='center' cellPadding=1 cellSpacing=1 width=75%>");
            printwriter.println(" <TR>");
            printwriter.println("   <TD></TD>");
            printwriter.println("<TD><FONT size=4><STRONG>View Company Details</STRONG></FONT></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD></TD>");
            printwriter.println(" <TD>  </TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("  <TD>Location Id</TD>");
            printwriter.println("<TD>" + s3 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>Location Name</TD>");
            printwriter.println("<TD>" + s4 + "</TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println("<TD>Company Name</TD>");
            printwriter.println("   <TD>" + s1 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>fname</TD>");
            printwriter.println("<TD>" + s11 + "</TD></TR>");
            printwriter.println(" <TD>lname</TD>");
            printwriter.println("<TD>" + s13 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>Address</TD>");
            printwriter.println("<TD>" + s14 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>phno</TD>");
            printwriter.println("<TD>" + j + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD>State</TD>");
            printwriter.println("  <TD>" + s15 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>City</TD>");
            printwriter.println(" <TD>" + s16 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>Country</TD>");
            printwriter.println(" <TD>" + s17 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("  <TD>Zipcode</TD>");
            printwriter.println("  <TD>" + i + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("<TD>Gender</TD>");
            printwriter.println(" <TD>" + s18 + "</TD></TR>");
            printwriter.println("<TR>");
            printwriter.println("   <TD>Email</TD>");
            printwriter.println("   <TD>" + s12 + "</TD></TR>");
            printwriter.println(" <TR>");
            printwriter.println(" <TR>");
            printwriter.println("   <TD></TD>");
            printwriter.println("   <TD></TD></TR>");
            printwriter.println("  <TD></TD>");
            printwriter.println("  <TD><INPUT id=submit1 name=submit1 type=submit value=OK></TD></TR>");
            printwriter.println("<TR>");
            printwriter.println(" <TD></TD>");
            printwriter.println("  <TD></TD></TR></TABLE></P>");
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
    Statement st1;
    ResultSet rs;
    ResultSet rs1;
}